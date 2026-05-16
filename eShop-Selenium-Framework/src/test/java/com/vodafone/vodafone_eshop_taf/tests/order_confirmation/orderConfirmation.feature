Feature: display recommended product sections on order confirmation page

  @eshop @pipeline @regression @recommended_sections
  Scenario Outline: check recommended sections appears in cart & order confirmation pages
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And   click on login icon in header
    And   user enter "<msisdn>" and "<password>" to login
    And   user click on go to my account button
    And   click on cart icon in the home page header
    And   click on remove button in cart page
    And   scroll down to Top Selling section in home page
    And   click on the first item in top selling section in home page
    And   click on buy now button in product details page
    Then  user should be redirected to page with link "<cartLink>" in cart page
    And   the header "<headerTitle1>" should be visible in cart page
    And   the header "<headerTitle2>" should be visible in cart page
    And   the header "<headerTitle3>" should be visible in cart page
    And   the header "<headerTitle4>" should be visible in cart page
    When  click on checkout button in cart page
    And   click on go to payment button in checkout page
    And   select payment method "<paymentMethod>" in payment page
    And   click on place order button in payment page
    Then  the header "<headerTitle1>" should be visible in order confirmation page
    And   the header "<headerTitle2>" should be visible in order confirmation page
    And   the header "<headerTitle3>" should be visible in order confirmation page
    And   the header "<headerTitle4>" should be visible in order confirmation page
    And   click on user name on header
    And   click on my orders from dropdown menu on header
    And   click on cancel order button for latest order in my orders page
    And   click on yes button for order cancel in my orders page

    Examples:
      | preferredLanguage | msisdn         | password         | cartLink                              | paymentMethod     | headerTitle1             | headerTitle2               | headerTitle3         | headerTitle4         |
      | en                | employeeMsisdn | employeePassword | https://eshop.vodafone.com.eg/en/cart | Cash On Delivery  | Recently Viewed Products | Frequently Bought Together | Also Viewed Products | Also Bought Products |
      | ar                | employeeMsisdn | employeePassword | https://eshop.vodafone.com.eg/ar/cart  | نقدا عند الاستلام | Recently Viewed Products | Frequently Bought Together | Also Viewed Products | Also Bought Products |


