Feature: checkout

  @eshop @pipeline @regression @checkout
  Scenario Outline: check success added new address for the first time
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    And scroll down to Top Selling section in home page
    And click on the first phone item in best selling phones in shop page
    And click on buy now button in product details page
    And click on checkout button in cart page
    And click on new Address button in checkout page
    And choose city name with text <city> from cities dropdown list in checkout page
    And choose district name with text <district> from districts dropdown list in checkout page
    And enter building number with text <buildingNumber> in checkout page
    And enter floor number with text <floorNumber> in checkout page
    And enter flat number with text <flatNumber> in checkout page
    And enter landmark with text <landMark> in checkout page
    And enter street name with text <streetName> in checkout page
    And click on save address button
    Then street name in the saved addresses section in checkout page should be equal to <streetName>
    And go to payment button in delivery option card in checkout page should be clickable
    Examples:
      | preferredLanguage |msisdn       |password           |city     |district      |buildingNumber|floorNumber|flatNumber|landMark       |streetName|
      | en                |redEssential|redEssentialPassword|" Alexandria "  |" Aamrya " |  "1"          |"2"         |"3"        |"Vodafone"     |"البيت"     |

  @eshop @pipeline @regression @checkout
  Scenario Outline: check essential sections are visible on the checkout page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    And scroll down to Top Selling section in home page
    And click on the first phone item in best selling phones in shop page
    And click on buy now button in product details page
    And click on checkout button in cart page
    Then checkout stepper in checkout page should be displayed
    And  cart section in checkout page should be displayed
    And  delivery options text in checkout page should be displayed
    And order summary section in checkout page should be displayed
    Examples:
      | preferredLanguage |msisdn       |password   |
      | en                |redEssential|redEssentialPassword|
      | ar                |redEssential|redEssentialPassword|

  @eshop @pipeline @regression @checkout
  Scenario Outline: check that the amount from cart equal the total amount in the order summary
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    And scroll down to Top Selling section in home page
    And click on the first phone item in best selling phones in shop page
    And click on buy now button in product details page
    And click on checkout button in cart page
    Then price in cart section should be equal to price in order summary section
    Examples:
      | preferredLanguage |msisdn       |password   |
      | en                |redEssential|redEssentialPassword|
      | ar                |redEssential|redEssentialPassword|

  @eshop @pipeline @regression @checkout
  Scenario Outline: check success added new address
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    And scroll down to Top Selling section in home page
    And click on the first phone item in best selling phones in shop page
    And click on buy now button in product details page
    And click on checkout button in cart page
    And click on new Address button in checkout page
    And choose city name with text <city> from cities dropdown list in checkout page
    And choose district name with text <district> from districts dropdown list in checkout page
    And enter building number with text <buildingNumber> in checkout page
    And enter floor number with text <floorNumber> in checkout page
    And enter flat number with text <flatNumber> in checkout page
    And enter landmark with text <landMark> in checkout page
    And enter street name with text <streetName> in checkout page
    And click on set as default address checkbox
    And click on save address button
    Then street name in the saved addresses section in checkout page should be equal to <streetName>
    And go to payment button in delivery option card in checkout page should be clickable
    Examples:
      | preferredLanguage |msisdn       |password           |city     |district      |buildingNumber|floorNumber|flatNumber|landMark       |streetName|
      | en                |redAdvance|redAdvancePassword|"Cairo"  |"Ain Shams" |  "1"          |"2"         |"3"        |"Vodafone"     |"Smart"     |

  @eshop @pipeline @regression @checkout
  Scenario Outline: check essential sections are visible on the payment methods page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    And scroll down to Top Selling section in home page
    And click on the first phone item in best selling phones in shop page
    And click on buy now button in product details page
    And click on checkout button in cart page
    And click on go to payment button in checkout page
    Then user should be redirected to payment methods page with link "<paymentMethodsLink>"
    And payment options section in checkout page should be displayed
    And paying full amount tab in checkout page should be displayed
    And installment tab in checkout page should be displayed
    Examples:
      | preferredLanguage |msisdn       |password           |paymentMethodsLink|
      | en                |redEssential|redEssentialPassword|https://eshop.vodafone.com.eg/en/checkout/payment-methods|
      | ar                |redEssential|redEssentialPassword|https://eshop.vodafone.com.eg/ar/checkout/payment-methods|

  @eshop @pipeline @regression @checkout
  Scenario Outline: check that paying full amount payment options texts are displayed in the checkout page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    And scroll down to Top Selling section in home page
    And click on the first phone item in best selling phones in shop page
    And click on buy now button in product details page
    And click on checkout button in cart page
    And click on go to payment button in checkout page
    Then vodafone cash payment method in checkout page should be "<vodafoneCash>"
    And  online credit card payment method in checkout page should be "<onlineCreditCard>"
    And  credit card on delivery payment method in checkout page should be "<creditCardOnDelivery>"
    And  cash on delivery payment method in checkout page should be "<cashOnDelivery>"
    Examples:
      | preferredLanguage |msisdn       |password           |vodafoneCash  |onlineCreditCard    |creditCardOnDelivery     |cashOnDelivery  |
      | en                |redEssential|redEssentialPassword| Vodafone Cash|Online Credit Card  |Credit/Debit Card on Delivery + Cash  |Cash On Delivery|
      | ar                |redEssential|redEssentialPassword| فودافون كاش  |ادفع بالبطاقة اونلاين| الدفع عند الاستلام (نقدًا + بطاقة ائتمان)|نقدا عند الاستلام |

  @eshop @pipeline @regression @checkout
  Scenario Outline: check that if total more than 60k error message is displayed and payment options are disabled expect online credit card
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    And click on "<laptopsTab>" in nav bar in home page
    And click on apple tab in products list page
    And click on fist mac item in in products list page
    And click on buy now button in product details page
    And click on checkout button in cart page
    And click on go to payment button in checkout page
    Then order over 60k info message in checkout page should be "<infoMessage>"
    And online credit card radio button in payment option card in checkout page should be clickable
    And cash on delivery radio button in payment option card in checkout page should be dimmed
    And credit card on delivery radio button in payment option card in checkout page should be dimmed
    And vodafone cash radio button in payment option card in checkout page should be dimmed
    Examples:
      | preferredLanguage |msisdn       |password           |laptopsTab                |infoMessage|
      | en                |redEssential|redEssentialPassword|Laptops             |Orders over 60000 EGP can't be paid by Cash On Delivery, Credit Card on Delivery, Vodafone Cash|
      | ar                |redEssential|redEssentialPassword|أجهزة كمبيوتر محمولة|الطلبات التى تزيد عن 60000 جنيه لا يمكن دفعها بطاقة الائتمان عند الاستلام, فودافون كاش, نقدا عند الاستلام|

  @eshop @pipeline @regression @checkout
  Scenario Outline: check shipping fess is 19 EGP in checkout page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    And scroll down to Top Selling section in home page
    And click on the first phone item in best selling phones in shop page
    And click on buy now button in product details page
    And click on checkout button in cart page
    And click on go to payment button in checkout page
    Then shipping fees value in in checkout page should be "<shippingFees>"
    Examples:
      | preferredLanguage |msisdn       |password   |shippingFees|
      | en                |redEssential|redEssentialPassword| 19 EGP|
      | ar                |redEssential|redEssentialPassword| 19 جنيه|

  @eshop @pipeline @regression @checkout
  Scenario Outline: check that Installments payment methods are displayed in Installment With Banks tab
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    And scroll down to Top Selling section in home page
    And click on the first phone item in best selling phones in shop page
    And click on buy now button in product details page
    And click on checkout button in cart page
    And click on go to payment button in checkout page
    And click on installment tab in checkout page
#    Then HSBC payment method in checkout page should be displayed
    And  CIB payment method in checkout page should be displayed
    And  cairo bank payment method in checkout page should be displayed
    Examples:
      | preferredLanguage |msisdn       |password   |
      | en                |redEssential|redEssentialPassword|
      | ar                |redEssential|redEssentialPassword|

  @eshop @pipeline @regression @checkout
  Scenario Outline: check that buy now pay later payment methods are displayed in buy now pay later tab
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    And scroll down to Top Selling section in home page
    And click on the first phone item in best selling phones in shop page
    And click on buy now button in product details page
    And click on checkout button in cart page
    And click on go to payment button in checkout page
    And click on installment tab in checkout page
    And click on Buy now pay later radio button
    Then forsa payment method in checkout page should be displayed
    And  souhoola payment method in checkout page should be displayed
    And  valu payment method in checkout page should be displayed
    Examples:
      | preferredLanguage |msisdn       |password   |
      | en                |redEssential|redEssentialPassword|

  @eshop @pipeline @regression @checkout
  Scenario Outline: check after deleting address go to payment button will not be clickable
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And click on cart icon in the home page header
    And click on remove button in cart page
    And scroll down to Top Selling section in home page
    And click on the first phone item in best selling phones in shop page
    And click on buy now button in product details page
    And click on checkout button in cart page
    And click on delete button in saved address section in checkout page
    Then go to payment button in delivery option card in checkout page should be dimmed
    Examples:
      | preferredLanguage |msisdn       |password   |
      | en                |redEssential |redEssentialPassword|