Feature: Red

  @eshop @pipeline @regression @red
  Scenario Outline: check content for red lines page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    Then the stepper on the red lines page should be displayed
    And the main title on the red lines page should be displayed with text "<title>"
    Examples:
      | preferredLanguage | title                       | tabs      |
      | en                | Choose RED Line | Red lines |
      | ar                | إختر رقم RED   | خطوط Red  |

  @eshop @pipeline @regression @red
  Scenario Outline: verify line price and msisdn number in red lines page and red plans page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    And scroll to the line price on the red line page
    Then the line price on the Red lines page should be displayed as "<price>"
    When click on the first available red line in red line page
    And click on the choose this line button in red line page
    And click on rate plan in the rate plan page
    Then the msisdn number displayed on the red plans summary page should match the chosen number in red lines page
    And the chosen line price on the red plans summary page should be displayed as "<price>"
    Examples:
      | preferredLanguage | price | tabs      |
      | en                | 200   | Red lines |
      | ar                | 200   | خطوط Red  |

  @eshop @pipeline @regression @red
  Scenario Outline: validate content of plans in red plans page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    And click on the first available red line in red line page
    And click on the choose this line button in red line page
    Then "<planName>" name in plans section in red plans page should be "<planName>"
    And "<planName>" data in plans section in red plans page should be "<planData>"
    And "<planName>" voice in plans section in red plans page should be "<planVoice>"
    And "<planName>" family members in plans section in red plans page should be "<planFamilyMembersNo>"
    Examples:
      | preferredLanguage | planName    | planData | planVoice     | planFamilyMembersNo        | tabs      |
      | en                | RED ADVANCE | 25 GB    | 5000 minutes  | Up to 2 family members     | Red lines |
      | en                | RED PRIME   | 40 GB    | 7000 minutes  | Up to 3 family members     | Red lines |
      | ar                | RED ELITE   | 70 GB    | 10000 minutes | تقدر تضم 4 أفراد من العائلة| خطوط Red  |

  @eshop @pipeline @regression @red
  Scenario Outline: check content of overlay with plans in red plans page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    And click on the first available red line in red line page
    And click on the choose this line button in red line page
    And click on see more info in any card of plans in red plans page
    Then subscription title during promotional period in red plan details overlay in red plans page should be "<subscriptionTitleDuringPromotionalPeriod>"
    And vat title during promotional period in red plan details overlay in red plans page should be "<vatTitleDuringPromotionalPeriod>"
    And subscription title after promotional period in red plan details overlay in red plans page should be "<subscriptionTitleAfterPromotionalPeriod>"
    And vat title after promotional period in red plan details overlay in red plans page should be "<vatTitleAfterPromotionalPeriod>"
    And subscription channels title in red plan details overlay in red plans page should be "<subscribtionToTitle>"
    And more benefits title in red plan details overlay in red plans page should be "<moreBenefitsTitle>"
    Examples:
      | preferredLanguage | subscriptionTitleDuringPromotionalPeriod       | vatTitleDuringPromotionalPeriod             | tabs      | subscriptionTitleAfterPromotionalPeriod      | vatTitleAfterPromotionalPeriod     | subscribtionToTitle | moreBenefitsTitle |
      | en                | Monthly Subscription                           | Monthly Subscription Including VAT          | Red lines | Monthly Subscription | Monthly Subscription Including VAT | Subscription to 4 out of 5 of the following    | More benefits    |
      | ar                | إشتراك شهرى                                    | إشتراك شهرى شامل ضريبة القيمة المضافة       | خطوط Red  | إشتراك شهرى          | إشتراك شهرى شامل ضريبة القيمة المضافة      | إشتراك فى 4 من 6 من الآتى           | المزيد من الفوائد      |

  @eshop @pipeline @regression @red
  Scenario Outline: check edit button in red plans page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    And click on the first available red line in red line page
    And click on the choose this line button in red line page
    And click on "<planName>" select button in red plan page
    And click on edit button in red plans page
    Then user should be redirected to page with link "<redLinesLink>" in red line page
    And choose this line button in red line page should be dimmed
    Examples:
      | preferredLanguage | tabs      | redLinesLink                                       |planName     |
      | en                | Red lines | https://eshop.vodafone.com.eg/en/lines/red/numbers |RED ADVANCE  |
      | ar                | خطوط Red  | https://eshop.vodafone.com.eg/ar/lines/red/numbers |RED ADVANCE  |

  @eshop @pipeline @regression @red
  Scenario Outline: validate content of specific plans in red summary page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    And click on the first available red line in red line page
    And click on the choose this line button in red line page
    And click on "<planName>" select button in red plan page
    Then "<planName>" name in with rate plan section in red summary page should be "<planName>"
    Examples:
      | preferredLanguage | planName    |tabs      |
      | en                | RED ADVANCE+ |Red lines |
      | en                | RED PRIME+   |Red lines |
      | ar                | +RED ELITE   |خطوط Red  |

  @eshop @pipeline @regression @red
  Scenario Outline: check success redirect to cart page after select red line and complete required data
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And click on vodafone logo in header section
    When click on "<tabs>" in nav bar in home page
    And scroll to lines section header in red line page
    And click on the first available red line in red line page
    And click on the choose this line button in red line page
    And click on "<planName>" select button in red plan page
    And select myself option in red summary page
    And enter national id "<nationalId>" in red summary page
    And enter first name "<firstName>" in red summary page
    And enter last name "<lastName>" in red summary page
    And click on the next button in red summary page
    And click on provide one of the following documents check box in red summary page
    And click on submit button in red summary page
    Then user should be redirected to page with link "<cartLink>" in cart page
    Examples:
      | preferredLanguage | msisdn     | password           | nationalId     | planName      | tabs      | cartLink |firstName |lastName|
      | en                | redAdvance | redAdvancePassword | 29010071402015 | RED ESSENTIAL | Red lines | https://eshop.vodafone.com.eg/en/cart |test|test|
      | ar                | redAdvance | redAdvancePassword | 29010071402015 | RED ESSENTIAL     | خطوط Red  | https://eshop.vodafone.com.eg/ar/cart |test|test|

