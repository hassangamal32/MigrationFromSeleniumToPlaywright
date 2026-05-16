Feature: My orders

  @eshop @pipeline @customer_profile @regression @New
  Scenario Outline:check the status of order for new user don't have any order yet on new orders tab
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And   user enter "<msisdn>" and "<password>" to login
    And   user click on go to my account button
    And   click on user name on header
    And   click on my orders from dropdown menu on header
    Then  order status on new orders tab in my orders page should be"<noOrderText>"

    Examples:
      | preferredLanguage | msisdn  | password        | noOrderText        |
      | en                | newUser | newUserPassword | You Have No Orders |
      | ar                | newUser | newUserPassword | لا يوجد لديك طلبات |

  @eshop @pipeline @customer_profile @regression @New
  Scenario Outline:check the status of order for new user don't have any order yet on order history tab
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And   user enter "<msisdn>" and "<password>" to login
    And   user click on go to my account button
    And   click on user name on header
    And   click on my orders from dropdown menu on header
    And   click on order history tab in my orders page
    Then  order status on order history tab in my orders page should be"<noOrderText>"
    Examples:
      | preferredLanguage | msisdn  | password        | noOrderText        |
      | en                | newUser | newUserPassword | You Have No Orders |
      | ar                | newUser | newUserPassword | لا يوجد لديك طلبات |

  @eshop  @pipeline @customer_profile @regression  @update
  Scenario Outline: check view of orders on new orders tab, and check features of edit address and cancel
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And  click on cart icon in the home page header
    And  click on remove button in cart page
    And  open the product details page of item with link "<productPageLink>"
    And  click on buy now button in product details page
    Then user should be redirected to page with link "<cartLink>" in cart page
    When click on checkout button in cart page
    And  click on new Address button in checkout page
    And  choose city name with text "<city>" from cities dropdown list in checkout page
    And  choose district name with text "<district>" from districts dropdown list in checkout page
    And  enter street name with text "<streetName>" in checkout page
    And  enter building number with text "<buildingNumber>" in checkout page
    And  enter floor number with text "<floorNumber>" in checkout page
    And  enter flat number with text "<apartmentNumber>" in checkout page
    And  enter landmark with text "<landMark>" in checkout page
    And  click on set as default address checkbox
    And  click on save address button
    And  click on go to payment button in checkout page
    And  select payment method "<paymentMethod>" in payment page
    And  click on place order button in payment page
    When cache order id in order confirmation page
    And  click on user name on header
    And  click on my orders from dropdown menu on header
    Then order id in my orders page should be same as order confirmation page
    And  order date should be current time in my orders page
    And  order estimated delivery time should be the range for city "<city>" in my orders page
    And  order address should be "<orderAddress>" in my orders page
    And  order status should be "<orderStatus>" in my orders page
    And  edit address button should be displayed in my orders page
    And  track order button should be displayed in my orders page
    And  cancel order button should be displayed in my orders page
    When click on edit address button in my orders page
    And  click on edit address button in edit address window in my orders page
    Then city field should be dimmed in edit address window in my orders page.
    And  district field should be editable in edit address window in my orders page
    And  street name field should be editable in edit address window in my orders page
    And  building no field should be editable in edit address window in my orders page
    And  floor no field should be editable in edit address window in my orders page
    And  apartment no field should be editable in edit address window in my orders page
    When change address district to "<newDistrict>" in edit address window in my orders page
    And  click on confirm button in edit address window in my orders page
    And  click on done popup in success window in my orders page
    Then order address should be "<newOrderAddress>" in my orders page
    When click on cancel order button for latest order in my orders page
    And  click on yes button for order cancel in my orders page
    And  click on user name on header
    And  click on my orders from dropdown menu on header
    And  click on order history tab in my orders page
    Then order status should be "<newOrderStatus>" in my orders page
    And  order estimated delivery time should be replaced with cancellation time

    Examples:
      | preferredLanguage | msisdn         | password         | productPageLink                                         | cartLink                              | orderConfirmationLink                                   | city       | district | streetName | buildingNumber | floorNumber | apartmentNumber | landMark | paymentMethod     | orderStatus    | orderAddress                                                                                                            | newDistrict | newOrderAddress                                                                                                        | newOrderStatus |
      | ar                | employeeMsisdn | employeePassword | https://eshop.vodafone.com.eg/ar/prod/vivo-y31-5g-256gb | https://eshop.vodafone.com.eg/ar/cart | https://eshop.vodafone.com.eg/ar/checkout/order-summary | الأسكندرية | العامرية | vodafone   | 1              | 2           | 3               | Vodafone | نقدا عند الاستلام | تم انشاء الطلب | Street Name: vodafone, Landmark: Vodafone, Building Number: 1, Floor Number: 2, Apartment Number: 3, Aamrya, Alexandria | العجمى      | Street Name: vodafone, Landmark: Vodafone, Building Number: 1, Floor Number: 2, Apartment Number: 3, Agamy, Alexandria | تم الإلغاء     |
      | en                | employeeMsisdn | employeePassword | https://eshop.vodafone.com.eg/en/prod/vivo-y31-5g-256gb | https://eshop.vodafone.com.eg/en/cart | https://eshop.vodafone.com.eg/en/checkout/order-summary | Aswan      | Aswan    | vodafone   | 1              | 2           | 3               | Vodafone | Cash On Delivery  | Order Placed   | Street Name: vodafone, Landmark: Vodafone, Building Number: 1, Floor Number: 2, Apartment Number: 3, Aswan, Aswan       | Edfu        | Street Name: vodafone, Landmark: Vodafone, Building Number: 1, Floor Number: 2, Apartment Number: 3, Edfu, Aswan       | Cancelled      |


  @eshop  @pipeline @customer_profile @regression  @update
  Scenario Outline: check view of orders & cancellation on order details page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And  click on cart icon in the home page header
    And  click on remove button in cart page
    And  open the product details page of item with link "<productPageLink>"
    And  click on buy now button in product details page
    Then user should be redirected to page with link "<cartLink>" in cart page
    When click on checkout button in cart page
    And  click on new Address button in checkout page
    And  choose city name with text "<city>" from cities dropdown list in checkout page
    And  choose district name with text "<district>" from districts dropdown list in checkout page
    And  enter street name with text "<streetName>" in checkout page
    And  enter building number with text "<buildingNumber>" in checkout page
    And  enter floor number with text "<floorNumber>" in checkout page
    And  enter flat number with text "<apartmentNumber>" in checkout page
    And  enter landmark with text "<landMark>" in checkout page
    And  click on set as default address checkbox
    And  click on save address button
    And  click on go to payment button in checkout page
    And  select payment method "<paymentMethod>" in payment page
    And  click on place order button in payment page
    When cache order id in order confirmation page
    And  click on user name on header
    And  click on my orders from dropdown menu on header
    And  click on order details page link in my orders page
    Then order id in order details page should be same as order confirmation page
    And  order estimated delivery time should be the range for city "<city>" in order details page
    And  cancel order button should be displayed in order details page
    When click on cancel order button in order details page
    And  click on yes button for order cancel in order details page
    And  click on order history tab in my orders page
    Then order status should be "<newOrderStatus>" in my orders page
    And  order estimated delivery time should be replaced with cancellation time

    Examples:
      | preferredLanguage | msisdn         | password         | productPageLink                                         | cartLink                              | orderConfirmationLink                                   | city       | district | streetName | buildingNumber | floorNumber | apartmentNumber | landMark | paymentMethod     | newOrderStatus |
      | en                | employeeMsisdn | employeePassword | https://eshop.vodafone.com.eg/en/prod/vivo-y31-5g-256gb | https://eshop.vodafone.com.eg/en/cart | https://eshop.vodafone.com.eg/en/checkout/order-summary | Alexandria | Aamrya   | vodafone   | 1              | 2           | 3               | Vodafone | Cash On Delivery  | Cancelled      |
      | ar                | employeeMsisdn | employeePassword | https://eshop.vodafone.com.eg/ar/prod/vivo-y31-5g-256gb | https://eshop.vodafone.com.eg/ar/cart | https://eshop.vodafone.com.eg/ar/checkout/order-summary | أسوان      | أسوان    | vodafone   | 1              | 2           | 3               | Vodafone | نقدا عند الاستلام | تم الإلغاء     |

  @eshop @pipeline @customer_profile @regression @New  @update
  Scenario Outline: check view of orders in order history tab
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And  click on user name on header
    And  click on my orders from dropdown menu on header
    And  click on order history tab in my orders page
    And  search for order by order id "<orderId>" in my orders page
    Then order id should be "<orderId>" in my orders page
    And  order date should be "<orderDate>" in my orders page
    And  order estimated delivery time should be "<orderEstimatedDelivery>" in my orders page
    And  order address should be "<orderAddress>" in my orders page
    And  order status should be "<orderStatus>" in my orders page
    And  number of items in order should be "<numberOfItems>" in my orders page
    And  first item name in order summary should be "<itemName>" in my orders page
    And  first item price in order summary should be "<itemPrice>" in my orders page
    When click on order details page link in my orders page
    Then order id should be "<orderId>" in order details page
    And  order date should be "<orderDate>" in order details page
    And  order estimated delivery time should be "<orderEstimatedDelivery>" in order details page
    And  first item name in order summary should be "<itemName>" in order details page
    And  first item price in order summary should be "<itemPrice>" in order details page
    Examples:
      | preferredLanguage | msisdn         | password         | orderId               | orderDate           | orderEstimatedDelivery                  | orderAddress                                                                                                           | orderStatus | numberOfItems | itemName                           | itemPrice |
      | en                | employeeMsisdn | employeePassword | VF8959628720917857734 | 2 Apr 2026 4:31 PM  | Cancelled on 2 Apr 2026 4:31 PM         | Street Name: vodafone, Landmark: Vodafone, Building Number: 1, Floor Number: 2, Apartment Number: 3, Agamy, Alexandria | Cancelled   | 1             | Vivo Y31 5G Smart Phone (8/256)    | 13,990    |
      | ar                | employeeMsisdn | employeePassword | VF8959628720917857734 | 2 أبريل 2026 4:31 م | تم الإلغاء في تاريخ 2 أبريل 2026 4:31 م | Street Name: vodafone, Landmark: Vodafone, Building Number: 1, Floor Number: 2, Apartment Number: 3, Agamy, Alexandria | تم الإلغاء  | 1             | هاتف فيفو Y31 الجيل الخامس (8/256) | 13,990    |


  @eshop @pipeline @customer_profile @regression @New  @update
  Scenario Outline: check buy again from order history tab
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And   user enter "<msisdn>" and "<password>" to login
    And   user click on go to my account button
    And   click on cart icon in the home page header
    And   click on remove button in cart page
    And   click on user name on header
    And   click on my orders from dropdown menu on header
    And   click on order history tab in my orders page
    And   search for order by order id "<orderId>" in my orders page
    And   click on buy again button for product on order history tab in my orders page
    Then  success message popup in my orders page should be"<successfullyAddedText>"
    And   number of items in cart icon in header should be "<cartCounter>"
    Examples:
      | preferredLanguage | msisdn         | password         | orderId               | successfullyAddedText        | cartCounter |
#    eshop order
      | en                | employeeMsisdn | employeePassword | VF8137661344255722095 | Item Added To Cart           | 1           |
      | ar                | employeeMsisdn | employeePassword | VF8137661344255722095 | تم اضافه المنتج لعربه التسوق | 1           |
#    smartTech Order
#      | en                | employeeMsisdn | employeePassword | VF5102680886422621859 | Item Added To Cart           | 1           |
#      | ar                | employeeMsisdn | employeePassword | VF5102680886422621859 | تم اضافه المنتج لعربه التسوق | 1           |


  @eshop @pipeline @customer_profile @regression @New @SmartTech  @update
  Scenario Outline: verify smartTech order view in order history tab
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And   user enter "<msisdn>" and "<password>" to login
    And   user click on go to my account button
    And   click on user name on header
    And   click on my orders from dropdown menu on header
    And   click on order history tab in my orders page
    And   search for order by order id "<orderId>" in my orders page
    Then  order should has the tag "<smartTechOrderTag>" in my orders page
    And   order should has the label "<smartTechLabel>" instead of item price in my orders page
    When  click on order details page link in my orders page
    Then  order should has the tag "<smartTechOrderTag>" in order details page
    And   total price for order should equal "<itemPrice>" in order details page

    Examples:
      | preferredLanguage | msisdn         | password         | orderId                | smartTechOrderTag | smartTechLabel | itemPrice |
      | en                | employeeMsisdn | employeePassword | VF15268509852982463036 | In-Store Purchase | Paid in Store  | 3,999     |
      | ar                | employeeMsisdn | employeePassword | VF15268509852982463036 | طلب من الفرع      | مدفوع في الفرع | 3,999     |
