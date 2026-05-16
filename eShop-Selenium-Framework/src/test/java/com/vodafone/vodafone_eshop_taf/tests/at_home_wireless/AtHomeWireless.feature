Feature: At Home Wireless

    @eshop @pipeline @athome @regression
    Scenario Outline: Check at home wireless card content in at home bundles page
        Given user change website language to be in language "<preferredLanguage>"
        When  click on "<tab>" in nav bar in home page
        Then home wireless stepper in at home bundles page should be displayed
        And at home bundles page title should be "<homeWirelessInternetBundlesTitle>"
        And at home bundles page description should be displayed

        Examples:
            | preferredLanguage | tab           | homeWirelessInternetBundlesTitle |
            | en                | Home wireless | Home Wireless Internet Bundles   |
            | ar                | انترنت هوائي  | باقات النت الهوائي المنزلي       |

    @eshop @pipeline @athome @regression
    Scenario Outline: check four bundles name in at home bundles page
        Given user change website language to be in language "<preferredLanguage>"
        When  click on "<tab>" in nav bar in home page
        Then first bundle name in at home bundles page should be displayed with text "<firstBundle>"
        And second bundle name in at home bundles page should be displayed with text "<secondBundle>"
        And third bundle name in at home bundles page should be displayed with text "<thirdBundle>"
        Then fourth bundle name in at home bundles page should be displayed with text "<fourthBundle>"
        Examples:
            | preferredLanguage | firstBundle         | secondBundle         | thirdBundle          | fourthBundle         | tab           |
            | en                | Quota 40 GB / Month | Quota 135 GB / Month | Quota 250 GB / Month | Quota 400 GB / Month | Home wireless |
            | ar                | باقة 40 جيجا / شهر  | باقة 135 جيجا / شهر  | باقة 250 جيجا / شهر  | باقة 400 جيجا / شهر  | انترنت هوائي  |

    @eshop @pipeline @athome @regression
    Scenario Outline: check success redirect to at home router page after selecting specific bundle
        Given user change website language to be in language "<preferredLanguage>"
        When  click on "<tab>" in nav bar in home page
        And click on select first quota in at home bundles page
        Then user should be redirected to page with link "<chooseRouterLink>"

        Examples:
            | preferredLanguage       | tab           | chooseRouterLink                                                          |
            | en                      | Home wireless | https://eshop.vodafone.com.eg/en/internetServices/at-home/at-home-routers |
            | ar                      | انترنت هوائي  | https://eshop.vodafone.com.eg/ar/internetServices/at-home/at-home-routers |

    @eshop @pipeline @athome @regression
    Scenario Outline: Check at home wireless card content in at home router page
        Given user change website language to be in language "<preferredLanguage>"
        When  click on "<tab>" in nav bar in home page
        And click on select first quota in at home bundles page
        Then choose routers page title should be "<chooseRouterTitle>" in at home router page
        And home wireless plus router title in at home router page should be "<firstRouter>"
        And home wireless router title in at home router page should be "<secondRouter>"

        Examples:
          | preferredLanguage | tab           | firstRouter                      | secondRouter          | chooseRouterTitle  |
          | en                | Home wireless | Home Wireless 4G Plus            | Home Wireless 5G Plus | Choose your router |
          | ar                | انترنت هوائي  | راوتر هوائي منزلي فائق السرعة 4G | راوتر هوائي منزلي فائق السرعة 5G بلس  | اختار الراوتر      |


    @eshop @pipeline @athome @regression
    Scenario Outline: check the price of 2 router cash & installment in at home router page
        Given user change website language to be in language "<preferredLanguage>"
        When  click on "<tab>" in nav bar in home page
        And click on select first quota in at home bundles page
        And "<routerType>" price in at home router page should be "<routerPrice>"
        And "<routerType>" installment price in at home page should be "<routerInstallmentPrice>"
        Examples:
          | preferredLanguage | routerType                    | routerPrice | tab           | routerInstallmentPrice |
          | en                | Home Wireless 5G Plus         | 6,000 EGP   | Home wireless | 500 EGP/               |
          | ar                | راوتر هوائي منزلي فائق السرعة 4G | 2,500 جنيه  | انترنت هوائي  | 208 جنيه/              |

  @eshop @pipeline @athome @regression
    Scenario Outline: validate that the router price in the "at home router" page matches the price on the "subscription details" page
        Given user change website language to be in language "<preferredLanguage>"
        When   click on "<tab>" in nav bar in home page
        And click on select first quota in at home bundles page
        And get "<routerPrice>" Price in at home router page
        And click on select button for "<atHomeRouter>" in at home router page
        Then router price in at home router page should be the same as "<routerName>" price in subscription details page

        Examples:
          | preferredLanguage | tab           | routerPrice                   | atHomeRouter                  | routerName                    |
          | en                | Home wireless | Home Wireless 4G Plus         | Home Wireless 4G Plus         | Home Wireless 4G              |
          | ar                | انترنت هوائي  | راوتر هوائي منزلي فائق السرعة 4G | راوتر هوائي منزلي فائق السرعة 4G | راوتر هوائي منزلي فائق السرعة 4G |

  @eshop @pipeline @athome @regression
    Scenario Outline: Check that user can edit in router type in subscription details page
        Given user change website language to be in language "<preferredLanguage>"
        When  click on "<tab>" in nav bar in home page
        And click on select first quota in at home bundles page
        And click on select button for "<routerName>" in at home router page
        Then user should be redirected to subscription details page with link "<subscriptionDetailsLink>"
        When click on edit button "<routerName>" in subscription page
        And click on select button for "<atHomeSecondRouter>" in at home router page
        Then home wireless router title in at home Subscription details should be "<atHomeSecondRouter>"

        Examples:
          | preferredLanguage | routerName                       | tab           | atHomeSecondRouter               | subscriptionDetailsLink                                                                |
          | en                | Home Wireless 5G Plus            | Home wireless | Home Wireless 5G Plus            | https://eshop.vodafone.com.eg/en/internetServices/at-home/at-home-subscription-details |
          | ar                | راوتر هوائي منزلي فائق السرعة 4G | انترنت هوائي  | راوتر هوائي منزلي فائق السرعة 4G | https://eshop.vodafone.com.eg/ar/internetServices/at-home/at-home-subscription-details |

    @eshop @pipeline @athome @regression
    Scenario Outline: check please enter your national id in Subscription Details page
        Given user change website language to be in language "<preferredLanguage>"
        When   click on "<tab>" in nav bar in home page
        And  click on select first quota in at home bundles page
        And click on select button for "<routerName>" in at home router page
        And scroll down to please enter your national id section in subscription page
        Then check please enter your national id section in subscription page should be displayed
        When enter your national id "<nationalID>" in national id input field in subscription page
        And click on go to checkout button in subscription details page
        Then check the national id response message "<NationalIDResponseMessage>" if national id is not eligible for purchasing at home router
        And enter your factory number "<factoryNumber>" in factory number input field in subscription page
        And click on go to checkout button in subscription details page
        Then check the factory number response message "<FactoryNumberResponseMessage>" if factory number is not eligible for purchasing at home router

        Examples:
          | preferredLanguage | tab           | routerName                       | NationalIDResponseMessage        | nationalID     | factoryNumber | FactoryNumberResponseMessage                                             |
          | en                | Home wireless | Home Wireless 4G Plus            | Please enter a valid national id | 77705102103711 | 12345678900   | Factory Number should be 9-characters(uppercase letters and digits only) |
          | ar                | انترنت هوائي  | راوتر هوائي منزلي فائق السرعة 4G | من فضلك أدخل رقم قومى صحيح       | 77705102103711 | 12345678900   | يرجى إدخال رقم المصنع الصحيح المكون من 9 رموز (أحرف كبيرة وأرقام فقط)    |


  @eshop @pipeline @athome @regression
    Scenario Outline: check success redirect to cart page after select home wireless router and complete required data
        Given user change website language to be in language "<preferredLanguage>"
        When click on login icon in header
        And  user enter "<msisdn>" and "<password>" to login
        And  user click on go to my account button
        When  click on "<tab>" in nav bar in home page
        And click on select first quota in at home bundles page
        And click on select button for "<routerName>" in at home router page
        And scroll down to please enter your national id section in subscription page
        Then check please enter your national id section in subscription page should be displayed
        When enter your national id "<nationalID>" in national id input field in subscription page
        And enter your factory number "<factoryNumber>" in factory number input field in subscription page
        And click on go to checkout button in subscription details page
        Then user should be redirected to page with link "<cartLink>" in cart page

    Examples:
      | preferredLanguage | msisdn     | password           | tab           | routerName                       | cartLink                              | nationalID     | factoryNumber |
      | en                | redAdvance | redAdvancePassword | Home wireless | Home Wireless 5G Plus            | https://eshop.vodafone.com.eg/en/cart | 29505102221101 | AB1234567     |
      | ar                | redAdvance | redAdvancePassword | انترنت هوائي  | راوتر هوائي منزلي فائق السرعة 4G | https://eshop.vodafone.com.eg/ar/cart | 29505102221101 | AB1234567     |

  @eshop @pipeline @athome @regression @new
  Scenario Outline: check pop up message when user entering national id less than 18 years old
    Given user change website language to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    When  click on "<tab>" in nav bar in home page
    And click on select first quota in at home bundles page
    And click on select button for "<routerName>" in at home router page
    And scroll down to please enter your national id section in subscription page
    Then check please enter your national id section in subscription page should be displayed
    When enter your national id "<nationalID>" in national id input field in subscription page
    And enter your factory number "<factoryNumber>" in factory number input field in subscription page
    And click on go to checkout button in subscription details page
    Then pop up appear with message "<failureMessage>" that national id is not eligible from purchase at home in subscription page

    Examples:
      | preferredLanguage | msisdn     | password           | tab           | routerName                       | failureMessage                                                | nationalID     | factoryNumber |
      | en                | redAdvance | redAdvancePassword | Home wireless | Home Wireless 5G Plus            | You must be at least 18 years old to purchase a Home Wireless | 31101013332211 | AB1234567     |
      | ar                | redAdvance | redAdvancePassword | انترنت هوائي  | راوتر هوائي منزلي فائق السرعة 4G | يجب أن يكون عمرك 18 سنة على الأقل لشراء انترنت هوائي          | 31101013332211 | AB1234567     |
