Feature: addresses

  @eshop @pipeline @addresses @regression @New
  Scenario Outline: verify add & remove default address in addresses page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And   user enter "<msisdn>" and "<password>" to login
    And   user click on go to my account button
    And   click on user name on header
    And   click on profile from dropdown menu on header
    And   click on addresses tab in profile page
    Then  addresses tab in profile page should be displayed
    When  click on add address button in addresses page
    And   enter city name "<city>" in addresses page
    And   enter district name "<district>" in addresses page
    And   enter street name "<street>" in addresses page
    And   enter building number "<building>" in addresses page
    And   enter floor number "<floor>" in addresses page
    And   enter apartment number "<apartment>" in addresses page
    And   select address type "<addressType>" in addresses page
    And   enable make default address option in addresses page
    And   click on confirm button in addresses page
    And   click on done popup in success window in addresses page
    Then  default address should be displayed with title "<title>" in addresses page
    And   default address type should be "<addressType>"
    And   default address text should be "<fullAddress>"
    When  click on remove button for address "<fullAddress>" in addresses page
    And   click on yes button in confirm remove address modal in addresses page
    And   click on done popup in success window in addresses page
    Then  address "<fullAddress>" should not be displayed in addresses page

    Examples:
      | preferredLanguage | msisdn         | password         | city   | district | street | building | floor | apartment | addressType | title             | fullAddress                                               |
      | en                | employeeMsisdn | employeePassword | Giza   | Dokki    | a      | a        | a     | a         | Home        | Default address   | a St. a , Apt a , Floor No a , District Dokki , City Giza |
      | ar                | employeeMsisdn | employeePassword | الجيزة | الدقي    | أ      | أ        | أ     | أ         | Work        | العنوان الافتراضي | أ شارع أ , شقة أ , رقم الطابق أ , حي الدقي , مدينة الجيزة |


  @eshop @pipeline @addresses @regression @New
  Scenario Outline: verify add & remove another address in addresses page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on login icon in header
    And   user enter "<msisdn>" and "<password>" to login
    And   user click on go to my account button
    And   click on user name on header
    And   click on profile from dropdown menu on header
    And   click on addresses tab in profile page
    And   click on add address button in addresses page
    And   enter city name "<city>" in addresses page
    And   enter district name "<district>" in addresses page
    And   enter street name "<street>" in addresses page
    And   enter building number "<building>" in addresses page
    And   enter floor number "<floor>" in addresses page
    And   enter apartment number "<apartment>" in addresses page
    And   select address type "<addressType>" in addresses page
    And   click on confirm button in addresses page
    And   click on done popup in success window in addresses page
    And   search for added address "<fullAddress>" in addresses page
    Then  address should be displayed with title "<title>" in addresses page
    And   address type should be "<addressType>"
    And   address text should be "<fullAddress>"
    When  click on remove button for address "<fullAddress>" in addresses page
    And   click on yes button in confirm remove address modal in addresses page
    And   click on done popup in success window in addresses page
    Then  address "<fullAddress>" should not be displayed in addresses page

    Examples:
      | preferredLanguage | msisdn         | password         | city | district | street | building | floor | apartment | addressType | title           | fullAddress                                              |
      | en                | employeeMsisdn | employeePassword | Qena | Qena     | a      | a        | a     | a         | Home        | Another address | a St. a , Apt a , Floor No a , District Qena , City Qena |
      | ar                | employeeMsisdn | employeePassword | قنا  | قنا      | أ      | أ        | أ     | أ         | Work        | عنوان آخر       | أ شارع أ , شقة أ , رقم الطابق أ , حي قنا , مدينة قنا     |