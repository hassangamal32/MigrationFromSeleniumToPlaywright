Feature: Product Details Page

  @eshop @pipeline @productDetails @regression
  Scenario Outline: check that device name in product details page is the same as the device name in home page
    Given   website is opened and user need it to be in language "<preferredLanguage>"
    When    scroll down to Top Selling section in home page
    And     get first item title in top selling section in home page
    And     click on the first item in top selling section in home page
    Then    device name in product details page should be the same as the device name in home page

    Examples:
      | preferredLanguage |
      | en                |
      | ar                |

  @eshop @pipeline @productDetails @regression
  Scenario Outline: Check Specifications & Terms and conditions card content
    Given   website is opened and user need it to be in language "<preferredLanguage>"
    When    scroll down to Top Selling section in home page
    And     click on the first item in top selling section in home page
    And     scroll down to specifications section in product details page
    Then    specifications tab should be displayed in product details page
    And     click on specifications section in product details page
    And     specifications section body in product details page should be displayed
    When    scroll down to Terms and conditions tab in product details page
    Then    terms and conditions section in product details page should be displayed
    And     click on terms section in product details page
    And     terms section body in product details page should be displayed

    Examples:
      | preferredLanguage |
      | en                |
      | ar                |

  @eshop @pipeline @productDetails @regression
  Scenario Outline: check return correct value for installment price/year to any product
    Given   website is opened and user need it to be in language "<preferredLanguage>"
    When    scroll down to Top Selling section in home page
    And     click on the first item in top selling section in home page
    Then    the price with 12 months interest in the product details page should match the expected price

    Examples:
      | preferredLanguage |
      | en                |
      | ar                |

  @eshop @pipeline @productDetails @regression
  Scenario Outline: check product details card content
    Given   website is opened and user need it to be in language "<preferredLanguage>"
    When    scroll down to Top Selling section in home page
    And     click on the first item in top selling section in home page
    Then    product title in product details page should be displayed
    And     product color in product details page should be displayed
    And     product image in product details page should be displayed
    And     product storage in product details page should be displayed
    And     product installment section header in product details page should be displayed
    And     product price in product details page should be displayed
    And     add to cart button in product details page should be displayed
    And     buy now button in product details page should be displayed

    Examples:
      | preferredLanguage |
      | en                |
      | ar                |

  @eshop @pipeline @productDetails @regression
  Scenario Outline: check payment card content in product details page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When    scroll down to Top Selling section in home page
    And     click on the first item in top selling section in home page
    And     click on monthly installments plans section in product details page
    Then    installments plans options should be displayed product details page
#    And     cib bank icon in payment card content in product details page should be displayed
    And     misr bank icon in payment card content in product details page should be displayed
    When    click on bnpl installments tab in product details page
    Then    installments plans options should be displayed product details page
    And     seven icon in payment card content in product details page should be displayed
    And     aman icon in payment card content in product details page should be displayed

    Examples:
      | preferredLanguage |
      | en                |
      | ar                |

  @eshop @pipeline @productDetails @regression
  Scenario Outline:check item added successfully to cart page while user login and press on add to cart button
    Given   website is opened and user need it to be in language "<preferredLanguage>"
    When    click on login icon in header
    And     user enter "<msisdn>" and "<password>" to login
    And     user click on go to my account button
    And     click on cart icon in the home page header
    And     click on remove button in cart page
    And     scroll down to Top Selling section in home page
    And     click on the first item in top selling section in home page
    And     click on add to cart button in product details page
    Then    number of items in cart icon in header should be "<numberOfItems>"

    Examples:
      | preferredLanguage | msisdn         | password         | numberOfItems |
      | en                | employeeMsisdn | employeePassword | 1             |
      | ar                | employeeMsisdn | employeePassword | 1             |

  @eshop @pipeline @productDetails @regression
  Scenario Outline:check that user will redirect to login page when press on buy now button without login 1st
    Given   website is opened and user need it to be in language "<preferredLanguage>"
    When    scroll down to Top Selling section in home page
    And     click on the first item in top selling section in home page
    And     click on buy now button in product details page for guest user
    Then    user will redirect to "<loginPageLink>" login page

    Examples:
      | preferredLanguage | loginPageLink                                                            |
      | en                | https://web.vodafone.com.eg/auth/realms/vf-realm/protocol/openid-connect |
      | ar                | https://web.vodafone.com.eg/auth/realms/vf-realm/protocol/openid-connect |

  @eshop @pipeline @productDetails @regression
  Scenario Outline:check product added successfully while user logged in and press on buy now button
    Given   website is opened and user need it to be in language "<preferredLanguage>"
    When    click on login icon in header
    And     user enter "<msisdn>" and "<password>" to login
    And     user click on go to my account button
    And     click on cart icon in the home page header
    And     click on remove button in cart page
    And     scroll down to Top Selling section in home page
    And     click on the first item in top selling section in home page
    And     get product title in product details page
    And     click on buy now button in product details page
    Then    user should be redirected to page with link "<cartPageLink>"
    And     product title in cart page should be the same as the product name in product details page
    And     number of items in cart icon in header should be "<numberOfItems>"

    Examples:
      | preferredLanguage | msisdn         | password         | cartPageLink                          | numberOfItems |
      | en                | employeeMsisdn | employeePassword | https://eshop.vodafone.com.eg/en/cart | 1             |

  @eshop @pipeline @productDetails @regression
  Scenario Outline:check product added successfully in add to compare section in product details page
    Given   website is opened and user need it to be in language "<preferredLanguage>"
    When    scroll down to Top Selling section in home page
    And     click on the first item in top selling section in home page
    And     click on add to compare check box in product details page
    Then    compare section should be displayed in product details page
    And     compare button should be disabled in product details page
    And     clear all button in product page details should be displayed

    Examples:
      | preferredLanguage |
      | en                |
      | ar                |

  @eshop @pipeline @productDetails @regression @New
  Scenario Outline: check insurance options content in product details page
    Given   open the product details page of item with link "<productPageLink>"
    Then    insurance options section title should be displayed
    And     option of insurance "<insuranceType>" should be displayed in product details page
    When    click on insurance "<insuranceType>" details button in product details page
    Then    user should be redirected to page with link "<insuranceDetailsPageLink>"

    Examples:
      | productPageLink                                   | insuranceType     | insuranceDetailsPageLink                                 |
      | https://eshop.vodafone.com.eg/en/prod/i-phone-air | Basic Insurance   | https://eshop.vodafone.com.eg/en/insurance-terms/basic   |
      | https://eshop.vodafone.com.eg/ar/prod/i-phone-air | Basic Insurance   | https://eshop.vodafone.com.eg/ar/insurance-terms/basic   |
      | https://eshop.vodafone.com.eg/en/prod/i-phone-air | Premium Insurance | https://eshop.vodafone.com.eg/en/insurance-terms/premium |
      | https://eshop.vodafone.com.eg/ar/prod/i-phone-air | Premium Insurance | https://eshop.vodafone.com.eg/ar/insurance-terms/premium |

  @eshop @pipeline @productDetails @regression @New
  Scenario Outline:   user can add insurance on the product
    Given   click on login icon in header
    When    user enter "<msisdn>" and "<password>" to login
    And     user click on go to my account button
    And     click on cart icon in the home page header
    And     click on remove button in cart page
    And     open the product details page of item with link "<productPageLink>"
    And     click on add insurance button "<insuranceType>" in product details page
    And     click on add to cart button in product details page
    And     click on shopping cart icon in header
    Then    check "<insuranceType>" insurance is added for "<itemName>" item in cart page

    Examples:
      | productPageLink                                   | msisdn         | password         | insuranceType     | itemName   |
      | https://eshop.vodafone.com.eg/en/prod/i-phone-air | employeeMsisdn | employeePassword | Basic Insurance   | iPhone Air |
      | https://eshop.vodafone.com.eg/ar/prod/i-phone-air | employeeMsisdn | employeePassword | Basic Insurance   | iPhone Air |
      | https://eshop.vodafone.com.eg/en/prod/i-phone-air | employeeMsisdn | employeePassword | Premium Insurance | iPhone Air |
      | https://eshop.vodafone.com.eg/ar/prod/i-phone-air | employeeMsisdn | employeePassword | Premium Insurance | iPhone Air |

  @eshop @pipeline @productDetails @regression @New
  Scenario Outline: user can trade in his old device
    Given   website is opened and user need it to be in language "<preferredLanguage>"
    When    click on login icon in header
    And     user enter "<msisdn>" and "<password>" to login
    And     user click on go to my account button
    And     scroll down to Top Selling section in home page
    And     click on the first item in top selling section in home page
    Then    trade in section should be displayed in product details page
    When    click on trade in button in product details page
    Then    user should be redirected to page with link "<tradeInVodafoneWebsite>"

    Examples:
      | preferredLanguage | msisdn         | password         | tradeInVodafoneWebsite              |
      | en                | employeeMsisdn | employeePassword | https://web.vodafone.com.eg/spa/dlm |
      | ar                | employeeMsisdn | employeePassword | https://web.vodafone.com.eg/spa/dlm |


  @eshop @pipeline @productDetails @regression @New
  Scenario Outline: user can use notify me feature for out of stock products
    Given   click on login icon in header
    When    user enter "<msisdn>" and "<password>" to login
    And     user click on go to my account button
    And     open the product details page of item with link "<productPageLink>"
    And     click on notify me button in product details page
    Then    notify me popup should appear in product details page
    When    click on confirm button in notify me popup in product details page
    Then    notify me button should be disabled in product details page
    And     notify me button text should appear as "<notifiedText>" in product details page

    Examples:
      | productPageLink                                                                          | msisdn         | password         | notifiedText |
      | https://eshop.vodafone.com.eg/en/prod/samsung-smart-tv-43-crystal-uhd-4k-uhd---43du7000  | employeeMsisdn | employeePassword | Notified     |
      | https://eshop.vodafone.com.eg/ar/prod/samsung-smart-tv-55-inch-crystal-4k-uhd---55du8000 | employeeMsisdn | employeePassword | تم الابلاغ   |

  @eshop @pipeline @productDetails @regression @New @RecommendedforU
  Scenario Outline: Recommended For You section is displayed while user logged in
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And scroll down to Top Selling section in home page
    And click on the first item in top selling section in home page
    And scroll down to recommended for you section in product details page
    Then recommended for you section in product details page should be displayed

    Examples:
      | preferredLanguage | msisdn   | password     |
      | en                | TestUser | TestPassword |

  @eshop @pipeline @productDetails @regression @New @RecommendedforU
  Scenario Outline: check Recommended For You section have less than 50 sku
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And scroll down to Top Selling section in home page
    And click on the first item in top selling section in home page
    And scroll down to recommended for you section in product details page
    Then recommended for you section in product details page should have less than 50 sku

    Examples:
      | preferredLanguage | msisdn   | password     |
      | en                | TestUser | TestPassword |

