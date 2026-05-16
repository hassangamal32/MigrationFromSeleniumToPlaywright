package com.vodafone.vodafone_eshop_taf.utilities;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DeliveryDateUtils {

    /**
     * Calculate expected delivery range
     */
    public static DateRange calculateExpectedRange(String city) {

        int[] deliveryRangeDays = DeliveryDateUtils.getDeliveryDaysForCity(city);
        int minDays = deliveryRangeDays[0];
        int maxDays = deliveryRangeDays[1];
        LocalDate startDate = LocalDate.now();
        LocalDate fromDate = addBusinessDays(startDate, minDays);
        LocalDate toDate = addBusinessDays(startDate, maxDays);

        return new DateRange(fromDate, toDate);
    }

    /**
     * Add business days (excluding Friday & Saturday)
     */
    private static LocalDate addBusinessDays(LocalDate date, int days) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);

            if (isBusinessDay(result)) {
                addedDays++;
            }
        }
        return result;
    }

    private static boolean isBusinessDay(LocalDate date) {
        return !(date.getDayOfWeek() == DayOfWeek.FRIDAY ||
                date.getDayOfWeek() == DayOfWeek.SATURDAY);
    }

    /**
     * Parse UI text
     * Example: "Estimated Delivery: 7 Apr 2026 - 9 Apr 2026"
     */
    public static DateRange parseFromUI(String text) {

        DateTimeFormatter UI_FORMAT = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);
        try {
            // remove any prefix before "Delivery:"
            String cleaned = text
                    .replace("الوقت المتوقع:", "")
                    .replace("Estimated Delivery:", "")
                    .trim();
            cleaned = normalizeArabicDate(cleaned);
            String[] parts = cleaned.split("-");

            String fromPart = parts[0].trim();
            String toPart = parts[1].trim();

            LocalDate fromDate = LocalDate.parse(fromPart, UI_FORMAT);
            LocalDate toDate = LocalDate.parse(toPart, UI_FORMAT);

            return new DateRange(fromDate, toDate);

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse delivery date from UI: " + text, e);
        }
    }

    /**
     * Exact validation
     */
    public static boolean validateExact(DateRange expected, DateRange actual) {
        return expected.getFrom().equals(actual.getFrom()) &&
                expected.getTo().equals(actual.getTo());
    }

    /**
     * Flexible validation (actual within expected range)
     */
    public static boolean validateRange(DateRange expected, DateRange actual) {

        boolean fromValid = !actual.getFrom().isBefore(expected.getFrom()) &&
                !actual.getFrom().isAfter(expected.getTo());

        boolean toValid = !actual.getTo().isBefore(expected.getFrom()) &&
                !actual.getTo().isAfter(expected.getTo());

        return fromValid && toValid;
    }

    public static int[] getDeliveryDaysForCity(String city) {

        String cityLower = city.trim().toLowerCase();
        int offset = 1;
        int min;
        int max;

        switch (cityLower) {
            case "cairo":
            case "giza":
                min = 1;
                max = 2;
                break;
            case "alexandria":
            case "الأسكندرية":
                min = 2;
                max = 3;
                break;
            case "aswan":
            case "أسوان":
            case "marsamatrouh":
            case "hurghada":
            case "newcapital":
            case "assiut":
            case "luxor":
            case "banysuef":
            case "sohag":
            case "fayoum":
            case "qena":
            case "minya":
            case "newvalley":
                min = 5;
                max = 7;
                break;
            default:
                min = 3;
                max = 5;
                break;
        }

        return new int[]{min + offset, max + offset};
    }


    public static boolean isNowWithinRange(String uiDateText, int allowedMinutes) {
        // example: 30 Mar 2026 3:19 PM
        uiDateText = normalizeArabicDate(uiDateText);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy h:mm a", Locale.ENGLISH);
        LocalDateTime uiDate = LocalDateTime.parse(uiDateText.trim(), formatter);
        LocalDateTime now = LocalDateTime.now();
        long diff = Math.abs(java.time.Duration.between(now, uiDate).toMinutes());
        return diff <= allowedMinutes;
    }

    public static boolean isCancelledTimeValid(String uiText, int allowedMinutes) {
        String cleaned = uiText
                .replace("تم الإلغاء في تاريخ", "")
                .replace("Cancelled on", "")
                .trim();
        cleaned = normalizeArabicDate(cleaned);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy h:mm a", Locale.ENGLISH);
        LocalDateTime cancelledTime = LocalDateTime.parse(cleaned, formatter);
        LocalDateTime now = LocalDateTime.now();
        long diff = Math.abs(java.time.Duration.between(now, cancelledTime).toMinutes());
        return diff <= allowedMinutes;
    }

    private static String normalizeArabicDate(String text) {

        return text
                // months
                .replace("يناير", "Jan")
                .replace("فبراير", "Feb")
                .replace("مارس", "Mar")
                .replace("أبريل", "Apr")
                .replace("مايو", "May")
                .replace("يونيو", "Jun")
                .replace("يوليو", "Jul")
                .replace("أغسطس", "Aug")
                .replace("سبتمبر", "Sep")
                .replace("أكتوبر", "Oct")
                .replace("نوفمبر", "Nov")
                .replace("ديسمبر", "Dec")

                // AM/PM
                .replace("ص", "AM")
                .replace("م", "PM");
    }

    /**
     * Helper class for date range
     */
    public static class DateRange {

        private final LocalDate from;
        private final LocalDate to;

        public DateRange(LocalDate from, LocalDate to) {
            this.from = from;
            this.to = to;
        }

        public LocalDate getFrom() {
            return from;
        }

        public LocalDate getTo() {
            return to;
        }

        @Override
        public String toString() {
            return "From: " + from + " | To: " + to;
        }
    }


}