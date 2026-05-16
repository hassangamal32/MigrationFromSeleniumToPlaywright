Feature: Flex

  @eshop @pipeline
  Scenario Outline: check content for flex lines page
    Given flex lines page is opened in language "<preferredLanguage>"
    Then the stepper in the flex lines page should be displayed
    And the main title on the flex lines page should be displayed with text "<flexLinePageTitle>"
    And the line price in the flex lines page should be "<price>"
    And terms and conditions title in flex lines page should be "<termsAndConditions>"
    And the terms and condition section in the flex lines page should be clickable
    Examples:
      | preferredLanguage | price | flexLinePageTitle           | termsAndConditions   |
      | en                | 66    | Choose Your Vodafone Number | Red Terms And Conditions |
      | ar                | 66    | اختار رقمك من فودافون       | شروط وأحكام شريحة ريد     |

  @eshop @pipeline
  Scenario Outline: Verify that the chosen MSISDN in flex lines page reflected correctly in flex lines plans page with correct price
    Given flex lines page is opened in language "<preferredLanguage>"
    When user click on the first available flex line in the flex lines page
    Then the selected number in flex lines is the same as the clicked number
    When click on Choose this line button in flex lines page
    Then user should be redirected to page with link "<flexLinesPlansLink>"
    And the msisdn number displayed on the flex plans page should match the chosen number in flex lines page
    And the chosen line price in the flex lines plans page should be "<price>"
    Examples:
      | preferredLanguage | price | flexLinesPlansLink                                          |
      | en                | 66    | https://eshop.vodafone.com.eg/en/lines/flex/plans?show=4444 |
      | ar                | 66    | https://eshop.vodafone.com.eg/ar/lines/flex/plans?show=4444 |

  @eshop @pipeline
  Scenario Outline: Verify that the rate plans and flex quotas presence in flex lines plans page
    Given flex lines page is opened in language "<preferredLanguage>"
    When user click on the first available flex line in the flex lines page
    And click on Choose this line button in flex lines page
    Then "<planName>" name in plans section in flex plans page should be "<planName>"
    And "<planName>" price in plans section in flex plans page should be "<ratePlanPrice>"
    And "<planName>" quota in plans section in flex plans page should be "<flexQuota>"
    Examples:
      | preferredLanguage | planName  | ratePlanPrice | flexQuota |
      | en                | FLEX 70   | 70 EGP/Month  | 3000      |
      | en                | FLEX 200  | 200 EGP/Month | 13000     |
      | ar                | فليكس 100 | 100 جنيه/شهر  | 5500      |

  @eshop @pipeline
  Scenario Outline: check edit button in flex plans page
    Given flex lines page is opened in language "<preferredLanguage>"
    When user click on the first available flex line in the flex lines page
    And click on Choose this line button in flex lines page
    And user click on edit button in flex plans page
    Then user should be redirected to page with link "<flexLinesLink>"
    And selected MSISDN in flex lines page is empty
    And choose this line button in flex line page should be dimmed
    Examples:
      | preferredLanguage | flexLinesLink                                                 |
      | en                | https://eshop.vodafone.com.eg/en/lines/flex/numbers?show=4444 |
      | ar                | https://eshop.vodafone.com.eg/ar/lines/flex/numbers?show=4444 |

  @eshop @pipeline
  Scenario Outline: Verify content of overlay for rate plan details
    Given flex lines page is opened in language "<preferredLanguage>"
    When user click on the first available flex line in the flex lines page
    And click on Choose this line button in flex lines page
    And click on see more info button for "<planName>" in the flex lines plans page
    Then monthly subscription excluding VAT for "<planName>" in flex plan details overlay in flex plans page should be "<monthlySubscriptionExcludingVAT>"
    And monthly subscription including VAT for "<planName>" in flex plan details overlay in flex plans page should be "<monthlySubscriptionIncludingVAT>"
    Examples:
      | preferredLanguage | planName  | monthlySubscriptionExcludingVAT | monthlySubscriptionIncludingVAT |
      | en                | FLEX 45   | 45 EGP /Month                   | 64 EGP /Month                   |
      | en                | FLEX 100  | 100 EGP /Month                  | 142 EGP /Month                  |
      | ar                | فليكس 45  | 45 جنيه /شهر                    | 64 جنيه /شهر                    |
      | ar                | فليكس 200 | 200 جنيه /شهر                   | 285 جنيه /شهر                   |

  @eshop @pipeline
  Scenario Outline: Check success redirect to flex lines summary page after select rate plan
    Given flex lines page is opened in language "<preferredLanguage>"
    When user click on the first available flex line in the flex lines page
    And click on Choose this line button in flex lines page
    And click on select button of "<planName>" in flex lines plans page
    Then user will be redirected to flex lines summary page with link "<flexLinesSummaryLink>"
    Then user will be redirected to flex lines summary page and title should "<pleaseEnterYourIDTitle>"

    Examples:
      | preferredLanguage | planName | pleaseEnterYourIDTitle      | flexLinesSummaryLink                                         |
      | en                | FLEX 200 | Please Enter Your ID Number | https://eshop.vodafone.com.eg/en/lines/flex/review?show=4444 |
      | ar                | فليكس 100 | ادخل رقم بطاقتك الشخصية     | https://eshop.vodafone.com.eg/ar/lines/flex/review?show=4444 |
      | ar                | فليكس 45 | ادخل رقم بطاقتك الشخصية     | https://eshop.vodafone.com.eg/ar/lines/flex/review?show=4444 |

  @eshop @pipeline
  Scenario Outline: Check success redirect to cart page after select flex line and complete required data
    Given flex lines page is opened in language "<preferredLanguage>"
    When click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And user click on the first available flex line in the flex lines page
    And click on Choose this line button in flex lines page
    And click on select button of "<planName>" in flex lines plans page
    And user enter "<validID>" in flex lines summary page
    And user click on ID submit button in flex lines summary page
    Then user will be redirected to cart page with link "<cartPageLink>"

    Examples:
      | preferredLanguage | msisdn     | password           | planName | validID        | cartPageLink                          |
      | en                | redAdvance | redAdvancePassword | FLEX 45  | 29475752341223 | https://eshop.vodafone.com.eg/en/cart |
      | ar                | redAdvance | redAdvancePassword | فليكس 70  | 29475752341223 | https://eshop.vodafone.com.eg/ar/cart |
