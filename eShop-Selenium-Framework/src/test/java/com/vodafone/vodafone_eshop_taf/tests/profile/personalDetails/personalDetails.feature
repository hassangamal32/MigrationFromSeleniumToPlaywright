Feature: personal Details

  @eshop @pipeline @customer_profile @regression
  Scenario Outline: check personal details section on user profile page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And  click on user name on header
    And  click on profile from dropdown menu on header
    Then name on personal info card in profile page should be"<userName>"
    And  mobileNumber on personal info card in profile page should be"<mobileNumber>"
    Examples:
      | preferredLanguage | msisdn     | password           | mobileNumber | userName |
      | en                | redAdvance | redAdvancePassword | MobileNumber | name     |
      | ar                | redAdvance | redAdvancePassword | MobileNumber | name     |

  @eshop @pipeline @customer_profile @regression
  Scenario Outline: check logout from user profile page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And  click on user name on header
    And  click on profile from dropdown menu on header
    And  click on logout button on profile
    And  click on login icon in header
    Then browser should be redirected to "<loginPageLink>"
    Examples:
      | preferredLanguage | msisdn     | password           | loginPageLink                                                                                 |
      | en                | redAdvance | redAdvancePassword | https://web.vodafone.com.eg/auth/realms/vf-realm/protocol/openid-connect/auth?client_id=eshop |
      | ar                | redAdvance | redAdvancePassword | https://web.vodafone.com.eg/auth/realms/vf-realm/protocol/openid-connect/auth?client_id=eshop |
