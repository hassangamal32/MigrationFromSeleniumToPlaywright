Feature: Payment Content Page Entry Points and Functionality

  @eshop @pipeline @regression @payment-content
  Scenario Outline: logged-out users can view shop now pay later section in home page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  scroll to shop now pay later section in home page
    Then  shop now pay later section should be displayed in home page

    Examples:
      | preferredLanguage |
      | en                |
      | ar                |


  @eshop @pipeline @regression @payment-content
  Scenario Outline: logged-in users can view shop now pay later section in home page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And   user enter "<msisdn>" and "<password>" to login
    And   user click on go to my account button
    And   scroll to shop now pay later section in home page
    Then  shop now pay later section should be displayed in home page

    Examples:
      | preferredLanguage | msisdn         | password         |
      | en                | employeeMsisdn | employeePassword |
      | ar                | employeeMsisdn | employeePassword |


  @eshop @pipeline @regression @payment-content
  Scenario Outline: user can navigate between payment content & payment details pages when enter through shop now pay later section in home page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  scroll to shop now pay later section in home page
    And   click on explore all button in shop now pay later section in home page
    Then  user should be redirected to payment content page with link "<paymentContentPageLink>"
    And   dynamic banner should be displayed in payment content page
    And   educational section should be displayed in payment content page
    And   banks tab should be selected in payment content page
    When  click on bnpls tab in payment content page
    Then  card of payment partner "<bnplName>" should be displayed in payment content page
    And   click on payment partner card "<bnplName>" in payment content page
    And   user should be redirected to payment details page with link "<bnplPageLink>"
    And   content of installment plans for payment partner should be displayed in payment details page
    When  click on installment plans breadcrumb in payment details page
    Then  user should be redirected to payment content page with link "<paymentContentPageLink>"
    And   bnpls tab should be selected in payment content page
    When  click on banks tab in payment content page
    Then  card of payment partner "<bankName>" should be displayed in payment content page
    When  click on payment partner card "<bankName>" in payment content page
    Then  user should be redirected to payment details page with link "<bankPageLink>"
    And   content of installment plans for payment partner should be displayed in payment details page
    When  click on installment plans breadcrumb in payment details page
    Then  user should be redirected to payment content page with link "<paymentContentPageLink>"
    And   banks tab should be selected in payment content page

    Examples:
      | preferredLanguage | bankName | bnplName | paymentContentPageLink | bankPageLink                                  | bnplPageLink                     |
      | en                | cib      | Seven    | /en/installments-info  | /en/installments-info/cib-installment-details | /en/installments-info/seven-info |
      | ar                | cib      | Seven    | /ar/installments-info  | /ar/installments-info/cib-installment-details | /ar/installments-info/seven-info |


  @eshop @pipeline @regression @payment-content
  Scenario Outline: user can navigate to payment details page through shop now pay later section in home page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  scroll to shop now pay later section in home page
    And   click on payment partner card "<partnerName>" in shop now pay later section in home page
    Then  user should be redirected to payment details page with link "<partnerPageLink>"
    And   content of installment plans for payment partner should be displayed in payment details page

    Examples:
      | preferredLanguage | partnerName | partnerPageLink                               |
      | en                | Seven       | /en/installments-info/seven-info              |
      | ar                | cib         | /ar/installments-info/cib-installment-details |


  @eshop @pipeline @regression @payment-content
  Scenario Outline: user can navigate to payment details page through product details page and navigate back to banks page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  scroll down to Top Selling section in home page
    And   click on the first item in top selling section in home page
    And   click on monthly installments plans section in product details page
    And   select payment partner card "<bankName>" in product details page
    And   click on learn more button in product details page
    Then  user should be redirected to payment details page with link "<bankPageLink>"
    When  click on installment plans breadcrumb in payment details page
    Then  user should be redirected to payment content page with link "<paymentContentPageLink>"
    And   banks tab should be selected in payment content page

    Examples:
      | preferredLanguage | bankName | bankPageLink                                  | paymentContentPageLink |
      | en                | Cib      | /en/installments-info/cib-installment-details | /en/installments-info  |
      | ar                | Cib      | /ar/installments-info/cib-installment-details | /ar/installments-info  |


  @eshop @pipeline @regression @payment-content
  Scenario Outline: user can navigate to payment details page through product details page and navigate back to bnpls page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  scroll down to Top Selling section in home page
    And   click on the first item in top selling section in home page
    And   click on monthly installments plans section in product details page
    And   click on bnpl installments tab in product details page
    And   select payment partner card "<bnplName>" in product details page
    And   click on learn more button in product details page
    Then  user should be redirected to payment details page with link "<bnplPageLink>"
    When  click on installment plans breadcrumb in payment details page
    Then  user should be redirected to payment content page with link "<paymentContentPageLink>"
    And   bnpls tab should be selected in payment content page

    Examples:
      | preferredLanguage | bnplName | bnplPageLink                     | paymentContentPageLink |
      | en                | Seven    | /en/installments-info/seven-info | /en/installments-info  |
      | ar                | Seven    | /ar/installments-info/seven-info | /ar/installments-info  |
