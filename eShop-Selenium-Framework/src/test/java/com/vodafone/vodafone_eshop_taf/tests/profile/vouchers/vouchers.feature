Feature: vouchers

  @eshop @pipeline @vouchers @regression @New
  Scenario Outline: verify vouchers section in my profile page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And  user enter "<msisdn>" and "<password>" to login
    And  user click on go to my account button
    And  click on user name on header
    And  click on profile from dropdown menu on header
    Then vouchers section in profile page should be displayed

    Examples:
      | preferredLanguage | msisdn    | password    |
      | en                | dslNumber | dslPassword |
      | ar                | dslNumber | dslPassword |

  @eshop @pipeline @vouchers @regression @New
  Scenario Outline: Verify active voucher section when no active vouchers exist
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And  click on user name on header
    And  click on profile from dropdown menu on header
    And click on vouchers section in profile page
    And click on active vouchers tab in vouchers section in profile page
    Then active vouchers tab is displayed with text "<activeTab>"
    And active vouchers section displaying message with text "<expectedMessage>"
    Examples:
      | preferredLanguage | msisdn        | password        | activeTab | expectedMessage             |
      | en                | voucherMsisdn | voucherPassword | Active    | You Have no Active Vouchers |
      | ar                | voucherMsisdn | voucherPassword | نشطة      | ليس لديك عروض نشطة          |

  @eshop @pipeline @vouchers @regression @New
  Scenario Outline: Verify Used Voucher section when no used vouchers exist
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And click on user name on header
    And click on profile from dropdown menu on header
    And click on vouchers section in profile page
    And click on used vouchers tab in vouchers section in profile page
    Then used vouchers tab is displayed with text "<activeTab>"
    And used vouchers section displaying message with text "<expectedMessage>"
    Examples:
      | preferredLanguage | msisdn    | password    | activeTab | expectedMessage           |
      | en                | dslNumber | dslPassword | Used      | You Have no Used Vouchers |
      | ar                | dslNumber | dslPassword | مستخدمة   | ليس لديك عروض مستخدمة     |

  @eshop @pipeline @vouchers @regression @New
  Scenario Outline: Verify Expired Voucher section when no expired vouchers exist
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And click on user name on header
    And click on profile from dropdown menu on header
    And click on vouchers section in profile page
    And click on expired vouchers tab in vouchers section in profile page
    Then expired vouchers tab is displayed with text "<activeTab>"
    And expired vouchers section displaying message with text "<expectedMessage>"
    Examples:
      | preferredLanguage | msisdn    | password    | activeTab | expectedMessage              |
      | en                | dslNumber | dslPassword | Expired   | You Have no Expired Vouchers |
      | ar                | dslNumber | dslPassword | منتهية    | ليس لديك عروض منتهية         |

  @eshop @pipeline @vouchers @regression @New
  Scenario Outline: Verify Used Voucher content displayed in the Expired Voucher section on the Vouchers page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And click on user name on header
    And click on profile from dropdown menu on header
    And click on vouchers section in profile page
    And click on used vouchers tab in vouchers section in profile page
    And select voucher at index <voucherIndex> in vouchers section in profile page
    Then check name of cart label "<cartLabel>" in vouchers section in profile page
    And check name of cart tag "<cartTag>" in vouchers section in profile page
    And check name of cart status "<cartStatus>" in vouchers section in profile page
    And check name of cart title "<cartTitle>" in vouchers section in profile page
    And check redeem button status in vouchers section in profile page is disabled
    Examples:
      | preferredLanguage | msisdn          | password          | voucherIndex | cartLabel | cartTag      | cartStatus | cartTitle                     |
      | en                | insuranceMsisdn | insurancePassword | 1            | SAVE 10   | CARTDISCOUNT | Used       | Checkout Now & Save 10% OFF!  |
      | ar                | insuranceMsisdn | insurancePassword | 1            | وفر 10    | CARTDISCOUNT | مستخدمة    | كمل طلبك دلوقتي و خد 10% خصم! |

  @eshop @pipeline @vouchers @regression @New
  Scenario Outline: Verify Expired Voucher content in the Expired Voucher section on the Vouchers page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on login icon in header
    And user enter "<msisdn>" and "<password>" to login
    And user click on go to my account button
    And click on user name on header
    And click on profile from dropdown menu on header
    And click on vouchers section in profile page
    And click on expired vouchers tab in vouchers section in profile page
    And select voucher at index <voucherIndex> in vouchers section in profile page
    Then check name of cart label "<cartLabel>" in vouchers section in profile page
    And check name of cart tag "<cartTag>" in vouchers section in profile page
    And check name of cart status "<cartStatus>" in vouchers section in profile page
    And check name of cart title "<cartTitle>" in vouchers section in profile page
    Examples:
      | preferredLanguage | msisdn          | password          | voucherIndex | cartLabel | cartTag      | cartStatus | cartTitle                       |
      | en                | insuranceMsisdn | insurancePassword | 2            | SAVE 25   | CARTDISCOUNT | Expired    | Enjoy 25% OFF Your First Order! |
      | en                | insuranceMsisdn | insurancePassword | 1            | SAVE 10   | CARTDISCOUNT | Expired    | Checkout Now & Save 10% OFF!    |