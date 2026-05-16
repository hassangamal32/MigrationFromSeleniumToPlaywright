Feature: cart feature

  @eshop @pipeline @cart @regression @new
  Scenario Outline: check cart icon in home page after login is clickable
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    Then cart icon in home page should be clickable
    And click on cart icon in the home page header
    Then user should be redirected to page with link "<cartLink>" in cart page
    Examples:
      | preferredLanguage | msisdn    | password    | cartLink                              |
      | ar                | dslNumber | dslPassword | https://eshop.vodafone.com.eg/ar/cart |
      | en                | dslNumber | dslPassword | https://eshop.vodafone.com.eg/en/cart |

  @eshop @pipeline @cart @regression @new
  Scenario Outline: check cart when its empty
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    Then cart icon in home page should be clickable
    And click on cart icon in the home page header
    Then user should be redirected to page with link "<cartLink>" in cart page
    And cart page should be empty with message "<emptyCartMessage>" in cart page
    And click on continue shopping button in empty cart page

    Examples:
      | preferredLanguage | msisdn    | password    | cartLink                              | emptyCartMessage   |
      | ar                | dslNumber | dslPassword | https://eshop.vodafone.com.eg/ar/cart | سلتك فاضية         |
      | en                | dslNumber | dslPassword | https://eshop.vodafone.com.eg/en/cart | Your Cart Is Empty |

  @eshop @pipeline @cart @regression @new
  Scenario Outline: redirect from cart page to home page when cart is empty
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    Then cart icon in home page should be clickable
    And click on cart icon in the home page header
    Then user should be redirected to page with link "<cartLink>" in cart page
    And cart page should be empty with message "<emptyCartMessage>" in cart page
    And click on start shopping button in empty cart page
    Then user should be redirected to home page with link "<homePage>"

    Examples:
      | preferredLanguage | msisdn    | password    | cartLink                              | emptyCartMessage   | homePage                          |
      | ar                | dslNumber | dslPassword | https://eshop.vodafone.com.eg/ar/cart | سلتك فاضية         | https://eshop.vodafone.com.eg/ar/ |
      | en                | dslNumber | dslPassword | https://eshop.vodafone.com.eg/en/cart | Your Cart Is Empty | https://eshop.vodafone.com.eg/en/ |

  @eshop @pipeline @cart @regression
  Scenario Outline: check content card for order summary and cart summary
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And scroll down to Top Selling section in home page
    And click on the first item in top selling section in home page
    And click on buy now button in product details page
    Then user should be redirected to page with link "<cartLink>" in cart page
    Then order summary header in cart page should be displayed
    And cart summary header in cart page should be displayed
    And go to checkout button in cart summary section in cart page should be displayed
    And continue shopping button in cart summary section in cart page should be displayed
    Examples:
      | preferredLanguage | msisdn       | password             | cartLink                              |
      | en                | dslNumber    | dslPassword          | https://eshop.vodafone.com.eg/en/cart |
      | ar                | redEssential | redEssentialPassword | https://eshop.vodafone.com.eg/ar/cart |

  @eshop @pipeline @cart @regression
  Scenario Outline: Check total price in cart page is equal the summation of all items prices in cart
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And scroll down to Top Selling section in home page
    And click on the second item in top selling section in home page
    And click on buy now button in product details page
    Then first item in cart page should be displayed
    And second item in cart page should be displayed
    And total price in cart page should be equal the summation of 2 item price
    Examples:
      | preferredLanguage | msisdn       | password             |
      | en                | dslNumber    | dslPassword          |
      | ar                | redEssential | redEssentialPassword |

  @eshop @pipeline @cart @regression
  Scenario Outline: check redirection of continue shopping button from cart page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on continue shopping button in cart page
    Then user should be redirected to home page with link <homePage>
    Examples:
      | preferredLanguage | msisdn    | password    | homePage                            |
      | en                | dslNumber | dslPassword | "https://eshop.vodafone.com.eg/en/" |
      | ar                | dslNumber | dslPassword | "https://eshop.vodafone.com.eg/ar/" |


  @eshop @pipeline @cart @regression
  Scenario Outline: check redirection to checkout page from cart page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on checkout button in cart page
    Then user should be redirected to checkout page with link "<checkoutLink>"
    Examples:
      | preferredLanguage | msisdn    | password    | checkoutLink                                       |
      | ar                | dslNumber | dslPassword | https://eshop.vodafone.com.eg/ar/checkout/shipping |
      | en                | dslNumber | dslPassword | https://eshop.vodafone.com.eg/en/checkout/shipping |


  @eshop @pipeline @cart @regression
  Scenario Outline: check failure message when user enter invalid promo code
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on promo code button in cart page
    And enter promo code with text <invalidPromoCode> in cart page
    And click on apply button in cart page
    Then error message in cart page should be displayed with text "<errorMessage>"
    Examples:
      | preferredLanguage | msisdn    | password    | invalidPromoCode | errorMessage      |
      | en                | dslNumber | dslPassword | "VF00"           | Coupon is expired |
      | ar                | dslNumber | dslPassword | "VF00"           | الكوبون منتهي     |

  @eshop @pipeline @cart @regression @New
  Scenario Outline: check red installment section displayed in the cart page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    Then check red installment section is displayed in cart page
    Examples:
      | preferredLanguage | msisdn    | password    |
      | en                | dslNumber | dslPassword |
      | ar                | dslNumber | dslPassword |

  @eshop @pipeline @cart @regression @New
  Scenario Outline: check red points section and redemption in the cart page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    Then check red points section is displayed in cart page
    And click on dropdown arrow in red points section in cart page
    And enter amount "<AmountEGP>" in egyptian pounds in red points section in cart page
    And click on apply button in red points section in cart page
    Then success message in red points section in cart page should be displayed with text "<successMessage>"
    And delete redeemed points from cart page
    Examples:
      | preferredLanguage | msisdn    | password    | AmountEGP | successMessage     |
      | en                | dslNumber | dslPassword | 5         | You redeemed 5 EGP |
      | ar                | dslNumber | dslPassword | 5         | انت استبدلت 5 جنيه |

  @eshop @pipeline @cart @regression @New
  Scenario Outline: check subtotal section and total price in cart page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    Then check subtotal section in order summary section in cart page is displayed
    Then check number of items in subtotal section in order summary section in cart page is "<items>"
    Then check total price in EGP in order summary section in cart page is "<totalFeesEGP>"
    Examples:
      | preferredLanguage | msisdn    | password    | items        | totalFeesEGP |
      | en                | dslNumber | dslPassword | ( 2 Items )  | 63,993       |
      | ar                | dslNumber | dslPassword | ( 2 منتجات ) | 63,993       |

  @eshop @pipeline @cart @regression @New
  Scenario Outline: verify number of added items in cart icon in header
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    Then number of items in cart icon in header should be "<numberOfItems>"
    Examples:
      | preferredLanguage | msisdn    | password    | numberOfItems |
      | en                | dslNumber | dslPassword | 2             |
      | ar                | dslNumber | dslPassword | 2             |

  @eshop @pipeline @cart
  Scenario Outline: Check that can't add more than one from the same item
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And scroll down to Top Selling section in home page
    And click on the first item in top selling section in home page
    And click on buy now button in product details page
    And click on cart icon in the home page header
    And click on increase the counter of item button in cart page
    Then error message in cart page should be "<errorMessage>"
    Examples:
      | preferredLanguage | msisdn    | password    | errorMessage                     |
      | en                | dslNumber | dslPassword | Maximum Allowed Quantity Reached |
      | ar                | dslNumber | dslPassword | لقد وصلت للحد الاقصي المسموح     |

  @eshop @pipeline @cart @regression
  Scenario Outline: check delete all product from the cart
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    Then user should be redirected to home page with link "<homePage>"
    Examples:
      | preferredLanguage | msisdn       | password             | homePage                          |
      | en                | dslNumber    | dslPassword          | https://eshop.vodafone.com.eg/en/ |
      | ar                | redEssential | redEssentialPassword | https://eshop.vodafone.com.eg/ar/ |

  @eshop @pipeline @cart @regression @New
  Scenario Outline: check delete specific product from the cart
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And  click on cart icon in the home page header
    And  click on remove button in cart page
    And  open the product details page of item with link "<productPageLink>"
    And  click on add insurance button "<insuranceType>" in product details page
    And  click on add to cart button in product details page
    And click on cart icon in the home page header
    And click on remove button for "<itemName>" item in cart page
    Examples:
      | preferredLanguage | msisdn          | password          | insuranceType     | itemName   | productPageLink                                   |
      | en                | insuranceMsisdn | insurancePassword | Basic Insurance   | iPhone Air | https://eshop.vodafone.com.eg/en/prod/i-phone-air |
      | ar                | insuranceMsisdn | insurancePassword | Premium Insurance | iPhone Air | https://eshop.vodafone.com.eg/ar/prod/i-phone-air |

  @eshop @pipeline @cart @regression @new
  Scenario Outline: check insurance added on specific product in cart page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And  click on cart icon in the home page header
    And  click on remove button in cart page
    And  open the product details page of item with link "<productPageLink>"
    And  click on add insurance button "<insuranceType>" in product details page
    And  click on add to cart button in product details page
    And click on cart icon in the home page header
    Then check "<insuranceType>" insurance is added for "<itemName>" item in cart page
    Examples:
      | preferredLanguage | msisdn          | password          | insuranceType     | itemName   | productPageLink                                   |
      | en                | insuranceMsisdn | insurancePassword | Basic Insurance   | iPhone Air | https://eshop.vodafone.com.eg/en/prod/i-phone-air |
      | ar                | insuranceMsisdn | insurancePassword | Premium Insurance | iPhone Air | https://eshop.vodafone.com.eg/ar/prod/i-phone-air |

  @eshop @pipeline @cart @regression @new
  Scenario Outline: check delete specific product insurance from the cart
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And  click on cart icon in the home page header
    And  click on remove button in cart page
    And  open the product details page of item with link "<productPageLink>"
    And  click on add insurance button "<insuranceType>" in product details page
    And  click on add to cart button in product details page
    And click on cart icon in the home page header
    And click on remove button for insurance of item "<itemName>" in cart page
    Examples:
      | preferredLanguage | msisdn          | password          | insuranceType     | itemName   | productPageLink                                   |
      | en                | insuranceMsisdn | insurancePassword | Basic Insurance   | iPhone Air | https://eshop.vodafone.com.eg/en/prod/i-phone-air |
      | ar                | insuranceMsisdn | insurancePassword | Premium Insurance | iPhone Air | https://eshop.vodafone.com.eg/ar/prod/i-phone-air |