Feature: Home Page

  @eshop @pipeline @home @regression
  Scenario Outline: check redirection for home page when click on Vodafone eshop icon
    Given website is opened and user need it to be in language "<preferredLanguage>"
    Then tracking link should be contain home link "<homeLinkText>" in home page

    Examples:
      | preferredLanguage | homeLinkText    |
      | en                | Vodafone E-shop |
      | ar                | متجر ڤودافون    |

  @eshop @pipeline @home @regression
  Scenario Outline: check redirection when click on Barnd tab in shop by brand section
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When scroll down to Featured Brand section in home page
    And click on "<brandName>" tab in shop by brand section in home page
    Then user should be redirected to page with link "<brandLink>" in product list page
    Examples:
      | preferredLanguage | brandName | brandLink                                                                |
      | en                | Samsung   | https://eshop.vodafone.com.eg/en/list?brandId=01H5HYCEEW5KFG0BP40QYR0WQ2 |
      | en                | anker     | https://eshop.vodafone.com.eg/en/list?brandId=01HF40S2W887FH0NJR0G901AHG |
      | en                | LG        | https://eshop.vodafone.com.eg/en/list?brandId=01HRCADATS3KJE0PQC2YE91HNT |
      | en                | apple     | https://eshop.vodafone.com.eg/en/list?brandId=01H5HYF1XFN7RE0R0A5K7C1A4X |
      | ar                | سامسونج   | https://eshop.vodafone.com.eg/ar/list?brandId=01H5HYCEEW5KFG0BP40QYR0WQ2 |
      | ar                | أنكر      | https://eshop.vodafone.com.eg/ar/list?brandId=01HF40S2W887FH0NJR0G901AHG |
      | ar                | LG        | https://eshop.vodafone.com.eg/ar/list?brandId=01HRCADATS3KJE0PQC2YE91HNT |
      | ar                | أبل       | https://eshop.vodafone.com.eg/ar/list?brandId=01H5HYF1XFN7RE0R0A5K7C1A4X |

#  @eshop @pipeline @home
#  Scenario Outline: Check smart Phones header category at home page
#    Given website is opened and user need it to be in language "<preferredLanguage>"
#    When  scroll down to most selling phones
#    Then  the smart Phones section header in home page with header "<headerText>" should be displayed
#
#    Examples:
#      | preferredLanguage | headerText    |
#      | en                | Smart Phones  |
#      | ar                | تليفونات ذكية |

#  @eshop @pipeline @home
#  Scenario Outline: Check redirection of see more button in category sections in home page
#    Given website is opened and user need it to be in language "<preferredLanguage>"
#    And  scroll down to see more button in "<categoryName>" in home page
#    When click on see more button in "<categoryName>" in home page
#    Then user should be redirected to page with link "<itemsPageLink>" in product list page
#    Examples:
#      | preferredLanguage | categoryName | itemsPageLink                                                     |
#      | en                | Deals        | https://eshop.vodafone.com.eg/en/list?categoryUrls=%2Fdeals       |
#      | en                | Accessories  | https://eshop.vodafone.com.eg/en/list?categoryUrls=%2Faccessories |
#      | ar                | العروض       | https://eshop.vodafone.com.eg/ar/list?categoryUrls=%2Fdeals       |
#      | ar                | اكسسوارات    | https://eshop.vodafone.com.eg/ar/list?categoryUrls=%2Faccessories |

#  @eshop @pipeline @home
#  Scenario Outline: Check the first item on accessories category section is clickable
#    Given website is opened and user need it to be in language "<preferredLanguage>"
#    And  scroll down to see more button in accessories module in home page
#    When click on the first accessory item in best selling accessories in shop page
#    Then user should be redirected to page with partial link "<productDetailsPartialLink>" in product details page
#    Examples:
#      | preferredLanguage | productDetailsPartialLink             |
#      | en                | https://eshop.vodafone.com.eg/en/prod |
#      | ar                | https://eshop.vodafone.com.eg/ar/prod |

  @eshop @pipeline @home @regression
  Scenario Outline: Check redirection of tabs in nav bar in home page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And   click on "<tabs>" in nav bar in home page
    Then  user should be redirected to page with partial link "<productDetailsPartialLink>" in product details page

    Examples:
      | preferredLanguage | productDetailsPartialLink                                                 | tabs          |
      | en                | https://eshop.vodafone.com.eg/en/lines/red/numbers                        | Red lines     |
      | en                | https://eshop.vodafone.com.eg/en/list?categoryUrls=%2Fsmart-phones        | Smart Phones  |
      | en                | https://eshop.vodafone.com.eg/en/internetServices/dsl/dsl-landline        | DSL           |
      | en                | https://eshop.vodafone.com.eg/en/internetServices/at-home/at-home-bundles | Home wireless |
      | en                | https://eshop.vodafone.com.eg/en/list?categoryUrls=%2Fwifi-devices        | Wifi Devices  |
      | ar                | https://eshop.vodafone.com.eg/ar/lines/red/numbers                        | خطوط Red      |
      | ar                | https://eshop.vodafone.com.eg/ar/list?categoryUrls=%2Fsmart-phones        | تليفونات ذكية |
      | ar                | https://eshop.vodafone.com.eg/ar/internetServices/dsl/dsl-landline        | انترنت منزلى  |
      | ar                | https://eshop.vodafone.com.eg/ar/internetServices/at-home/at-home-bundles | انترنت هوائي  |
      | ar                | https://eshop.vodafone.com.eg/ar/list?categoryUrls=%2Fwifi-devices        | اجهزه واي فاي |

#  @eshop @pipeline @home @regression
#  Scenario Outline: check cart icon in home page while logout is not clickable
#    Given website is opened and user need it to be in language "<preferredLanguage>"
#    Then  cart icon in home page should be unClickable
#
#    Examples:
#      | preferredLanguage |
#      | en                |
#      | ar                |

  @eshop @pipeline @home @regression
  Scenario Outline: check cart icon in home page while login is clickable
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    Then  cart icon in home page should be clickable

    Examples:
      | preferredLanguage | msisdn     | password           |
      | en                | redAdvance | redAdvancePassword |
      | ar                | redAdvance | redAdvancePassword |

  @eshop @pipeline @home @regression @New @RecommendedforU
  Scenario Outline: Recommended For You section is displayed while user logged in
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And scroll down to recommended for you section in home page
    Then recommended for you section in home page should be displayed

    Examples:
      | preferredLanguage | msisdn   | password     |
      | en                | TestUser | TestPassword |

  @eshop @pipeline @home @regression @New @RecommendedforU
  Scenario Outline: check Recommended For You section have less than 50 sku
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And scroll down to recommended for you section in home page
    Then recommended for you section in home page should have less than 50 sku

    Examples:
      | preferredLanguage | msisdn   | password     |
      | en                | TestUser | TestPassword |