Feature: mnp

    @eshop @pipeline
    Scenario Outline: check essential sections are visible on the mnp page
        Given website is opened and user need it to be in language "<preferredLanguage>"
        When click on "<redLinesTab>" in nav bar in home page
        And scroll down to you can join with your number section in red lines page
        And click on switch now button in red lines page
        Then mnp stepper in mnp page should be displayed
        And mnp header in mnp Page should be "<mnpHeader>"
        And mnp sub header in mnp Page should be "<mnpSubHeader>"
        And enter your name text field in mnp page should be displayed
        And enter your mobile number text field in mnp page should be displayed
        And enter your email text field in mnp page should be displayed
        And submit button in mnp page should be dimmed
        Examples:
            | preferredLanguage |redLinesTab|mnpHeader                                           |mnpSubHeader                                    |
            | en                |Red lines  |Join #1 Network In Egypt In 2 Steps With Your Number|Don't worry the entire process is free of charge|
            | ar                |خطوط Red   |انضم إلى الشبكة رقم 1 في مصر بنفس رقمك              |عملية تحويل رقمك بلا رسوم او مصاريف              |

    @eshop @pipeline
    Scenario Outline: Check essential sections are displayed in store confirmation of mnp page
        Given website is opened and user need it to be in language "<preferredLanguage>"
        When click on "<redLinesTab>" in nav bar in home page
        And scroll down to you can join with your number section in red lines page
        And click on switch now button in red lines page
        And enter full name with text "<fullName>" in mnp page
        And enter mobile number with text "<nonVodafoneNumber>" in mnp page
        And enter email address with text "<email>" in mnp page
        And click on submit button in mnp page
        And click on select button in red essential card in mnp page
        And click on I am ready to pick up my sim button in mnp page
        And click on the first store from stores menu in mnp page
        And select a date from the calender in mnp page
        And select a time from time slot drop down menu in mnp page
        And click on select date and time button in mnp page
        Then user should be redirected to mnp store confirmation page with link "<mnpPersonalInfoPageLink>"
        And your booking summary text should be "<bookingSummary>"
        And cancel button in mnp store confirmation page should be displayed
        And confirm button in mnp store confirmation page should be displayed
        Examples:
            | preferredLanguage |redLinesTab | fullName     | nonVodafoneNumber   | email          | bookingSummary     |mnpPersonalInfoPageLink|
            | en                |Red lines   | Test         | 01123741589       | test@gmail.com |Your Booking Summary|https://eshop.vodafone.com.eg/en/mnp/store-confirmation|
            | ar                |خطوط Red    | Test         | 01123741589         | test@gmail.com |ملخص الحجز          |https://eshop.vodafone.com.eg/ar/mnp/store-confirmation|

    @eshop @pipeline
    Scenario Outline: Check redirection to mnp personal info page after click on edit button in your mobile section in summary page
        Given website is opened and user need it to be in language "<preferredLanguage>"
        When click on "<redLinesTab>" in nav bar in home page
        And scroll down to you can join with your number section in red lines page
        And click on switch now button in red lines page
        And enter full name with text "<fullName>" in mnp page
        And enter mobile number with text "<nonVodafoneNumber>" in mnp page
        And enter email address with text "<email>" in mnp page
        And click on submit button in mnp page
        And click on select button in red essential card in mnp page
        And click on edit button in your mobile number section in mnp summary page
        Then user should be redirected to mnp personal info page with link "<mnpPersonalInfoPageLink>"
        Examples:
            | preferredLanguage |redLinesTab| fullName    | nonVodafoneNumber | email                       | mnpPersonalInfoPageLink |
            | en                |Red lines  | Test         | 01111111111         | test@gmail.com              |https://eshop.vodafone.com.eg/en/mnp/personal-info|
            | ar                |خطوط Red   | Test         | 01111111111         | test@gmail.com              |https://eshop.vodafone.com.eg/ar/mnp/personal-info|

    @eshop @pipeline
    Scenario Outline: Check redirection to mnp rate plans page after click on edit button in your rate plan section in summary page
        Given website is opened and user need it to be in language "<preferredLanguage>"
        When click on "<redLinesTab>" in nav bar in home page
        And scroll down to you can join with your number section in red lines page
        And click on switch now button in red lines page
        And enter full name with text "<fullName>" in mnp page
        And enter mobile number with text "<nonVodafoneNumber>" in mnp page
        And enter email address with text "<email>" in mnp page
        And click on submit button in mnp page
        And click on select button in red essential card in mnp page
        And click on edit button in your rate plan section in mnp summary page
        Then user should be redirected to mnp rate plan page with link "<mnpRatePlanPageLink>"
        Examples:
            | preferredLanguage |redLinesTab|fullName| nonVodafoneNumber| email          | mnpRatePlanPageLink |
            | en                |Red lines  |Test    | 01111111111      | test@gmail.com |https://eshop.vodafone.com.eg/en/mnp/rate-plans|
            | ar                |خطوط Red   |Test    | 01111111111      | test@gmail.com |https://eshop.vodafone.com.eg/ar/mnp/rate-plans|