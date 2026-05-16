package com.vodafone.vodafone_eshop_taf.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FlexLinesPlans extends PageBase {


    private final By chosenNumber = By.xpath("//div[@class='lines-lineCardSummary-lineInfo']");
    private final By linePriceinPlansPage = By.xpath("//vf-line-card-summary//div[1]/div[2]/div[1]/p[2]");
    private final By ratePlansType = By.xpath("//div[@class='lines-planCard-header']/p");
    private final By editButton = By.xpath("//div[@class='lines-lineCardSummary-editNumber']//button//span");
    private final By seeMoreInfoButton = By.xpath("//div[@class='lines-planCard-button']//button");
    private final By monthlyPriceWithoutVAT = By.xpath("//div[@class='sections-container']//div[1]//div[2]/p/b");
    private final By monthlyPriceWithVAT = By.xpath("//div[@class='sections-container']//div[2]//div[2]/p/b");
    private final By closeSeeMoreInfoButton = By.xpath("//div[@class='lines-planMoreInfo-container']//button");
    private final By ratePlanSelectButton = By.xpath("//div[@class='lines-planCard-header']//button");
    private final By ratePlanQuotas = By.xpath("//div[@class='content']/p[@class='data']");
    private final By ratePlanPrices = By.xpath("//div[@class='content']/p[@class='data']");
    

    public String getMsisdnNumber() {
        return safeFindElement(chosenNumber).getText();
    }

    public String getLinePriceInPlansPage() {
        return safeFindElement(linePriceinPlansPage).getText();
    }

    public String getLinePriceTextInPlansPage() {
        return splitString(getLinePriceInPlansPage(),"\\D+");
    }

    public String getRatePlansName(String planName) {
        JavascriptExecutorScroll(safeFindElement(ratePlansType));

        List<WebElement> ratePlans = safeFindElements(ratePlansType);

        if (ratePlans.size() < 4) {
            throw new IllegalStateException("Number of rate plans is less than four");
        }

        for (WebElement ratePlan : ratePlans) {
            JavascriptExecutorScroll(ratePlan);
            String ratePlansText = ratePlan.getText();

            if (ratePlansText.equals(planName)) {
                return ratePlansText;
            }
        }

        return "No Matched Rate Plans";
    }

    public String getFirstRatePlansName() {
        WebElement ratePlan = safeFindElement(ratePlansType);
        return ratePlan.getText();
    }


    public WebElement getSeeMoreInfoButton(String planName) {
        List<WebElement> seeMoreInfoButtons = safeFindElements(seeMoreInfoButton);
        List<WebElement> ratePlans = safeFindElements(ratePlansType);
        for (int i = 0; i < ratePlans.size(); i++) {
            JavascriptExecutorScroll(seeMoreInfoButtons.get(i));
            String ratePlansText = ratePlans.get(i).getText();
            if (ratePlansText.equals(planName))
                return seeMoreInfoButtons.get(i);
        }
        return null;
    }

    public String getRatePlanQuotas(String planName) {
        List<WebElement> quotas = safeFindElements(ratePlanQuotas);
        List<WebElement> ratePlans = safeFindElements(ratePlansType);
        for (int i = 0; i < ratePlans.size(); i++) {
            JavascriptExecutorScroll(quotas.get(i * 2 + 1));
            String ratePlansText = ratePlans.get(i).getText();
            if (ratePlansText.equals(planName))
                return quotas.get(i * 2 + 1).getText();
        }
        return "No Quota Found";
    }

    public String getRatePlanPrices(String planName) {
        List<WebElement> prices = safeFindElements(ratePlanPrices);
        List<WebElement> ratePlans = safeFindElements(ratePlansType);
        for (int i = 0; i < ratePlans.size(); i++) {
            JavascriptExecutorScroll(prices.get(i * 2));
            String ratePlansText = ratePlans.get(i).getText();
            if (ratePlansText.equals(planName))
                return prices.get(i * 2).getText();
        }
        return "No Price Found";
    }

    public WebElement getRatePlanSelectButton(String planName) {
        List<WebElement> ratePlanSelectButtons = safeFindElements(ratePlanSelectButton);
        List<WebElement> ratePlans = safeFindElements(ratePlansType);
        for (int i = 0; i < ratePlans.size(); i++) {
            JavascriptExecutorScroll(ratePlanSelectButtons.get(i));
            String ratePlansText = ratePlans.get(i).getText();
            if (ratePlansText.equals(planName))
                return ratePlanSelectButtons.get(i);
        }
        return null;
    }

    public String getMonthlyPriceWithoutVAT_Text() {
        return safeFindElement(monthlyPriceWithoutVAT).getText();
    }

    public String getMonthlyPriceWithVAT_Text() {
        return safeFindElement(monthlyPriceWithVAT).getText();
    }


    public FlexLines clickOnEditButton() {
        JavascriptExecutorScroll(safeFindElement(editButton));
        JavascriptExecutorClick(safeFindElement(editButton));
        return new FlexLines();
    }

    public void clickOnSeeMoreInfoButton(String planName) {
        List<WebElement> seeMoreInfoButtons = safeFindElements(seeMoreInfoButton);
        List<WebElement> ratePlans = safeFindElements(ratePlansType);

        if (seeMoreInfoButtons.size() != ratePlans.size()) {
            throw new IllegalStateException("Mismatch between number of 'See More Info' buttons and available rate plans.");
        }

        for (int i = 0; i < seeMoreInfoButtons.size(); i++) {
            WebElement ratePlan = ratePlans.get(i);
            WebElement seeMoreButton = seeMoreInfoButtons.get(i);

            JavascriptExecutorScroll(seeMoreButton);

            String ratePlansText = ratePlan.getText();
            if (ratePlansText.equals(planName)) {
                JavascriptExecutorClick(seeMoreButton);
                return;
            }
        }

        throw new NoSuchElementException("Rate plan with name '" + planName + "' not found.");
    }

    public FlexLinesSummary clickOnRatePlanSelectButton(String planName) {
        List<WebElement> selectButtons = safeFindElements(ratePlanSelectButton);
        List<WebElement> plans = safeFindElements(ratePlansType);

        if (selectButtons.size() != plans.size()) {
            throw new IllegalStateException("Mismatch between number of rate plan select buttons and available rate plans.");
        }

        for (int i = 0; i < selectButtons.size(); i++) {
            WebElement ratePlan = plans.get(i);
            WebElement selectButton = selectButtons.get(i);

            JavascriptExecutorScroll(selectButton);

            String ratePlansText = ratePlan.getText();
            if (ratePlansText.equals(planName)) {
                JavascriptExecutorScroll(ratePlan);
                JavascriptExecutorClick(selectButton);
                return new FlexLinesSummary();
            }
        }

        throw new NoSuchElementException("Rate plan with name '" + planName + "' not found.");
    }
}
