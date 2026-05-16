Feature: Login

  @eshop @pipeline @regression @login
  Scenario Outline: Check login by valid msisdn and password
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    Then user should be redirected to page with link <shopPage> to home page

    Examples:
      | preferredLanguage | msisdn     | password           | shopPage                            |
      | en                | redAdvance | redAdvancePassword | "https://eshop.vodafone.com.eg/en/" |
      | ar                | redAdvance | redAdvancePassword | "https://eshop.vodafone.com.eg/ar/" |

  @eshop @pipeline @regression @login
  Scenario Outline: Check failure login using invalid credentials
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And user switch language in login page in vodafone website to be "<preferredLanguage>"
    And  user enter "<msisdn>" and "<password>" to login
    When  user click on go to my account button
    Then error message in login page should be <errorMessageText>

    Examples:
      | preferredLanguage | msisdn        | password        | errorMessageText                   |
      | en                | invalidNumber | invalidPassword | "Invalid username or password"     |
      | ar                | invalidNumber | invalidPassword | "خطأ في اسم المستخدم أو كلمة مرور" |

  @eshop @pipeline @regression @login
  Scenario Outline: Check redirection to registration page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  click on register link
    Then  registration form header in registration page should be "<registrationFormHeader>"

    Examples:
      | preferredLanguage | registrationFormHeader    |
      | en                | Enter your mobile number  |
      | ar                | رقم الموبايل              |

  @eshop @pipeline @regression @login
  Scenario Outline: Check redirection to forget password page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  click on forget password link
    Then  reset password section header in reset password page should be "<resetFormHeader>"

    Examples:
      | preferredLanguage | resetFormHeader         |
      | en                | Reset password          |
      | ar                | إعادة تعيين كلمة المرور |