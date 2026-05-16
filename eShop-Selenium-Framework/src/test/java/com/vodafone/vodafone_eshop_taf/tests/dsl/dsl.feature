Feature: DSL

  @eshop @pipeline @regression @dsl
  Scenario Outline: Check dsl card content in dsl page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on "<tabs>" in nav bar in home page
    Then dsl title in dsl page should be "<dslTitle>"
    And Dsl subtitle in dsl page should be displayed
    And subscribe button in dsl page should be displayed
    And dsl info message in dsl page should be "<dslInfo>"
    And terms and conditions button in dsl page should be "<termsAndConditions>"
    Examples:
      | preferredLanguage | dslTitle                                                          | dslInfo                                                                                         | termsAndConditions   | tabs         |
      | en                | Supercharge Your Entertainment and Productivity with Vodafone DSL | You can only have one active request at a time, Wait for completion before submitting a new one | Terms And Conditions | DSL          |
      | ar                | اشحن طاقتك مع الأنترنت المنزلي من فودافون                         | لا يمكنك ارسال اكثر من طلب اشتراك واحد في نفس الوقت انتظر حتي يتم الانتهاء قبل تقديم طلب جديد   | الشروط و الأحكام     | انترنت منزلى |

  @eshop @pipeline @regression @dsl
  Scenario Outline: Check the dsl bundles content in dsl bundles page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on "<tabs>" in nav bar in home page
    And click on subscribe button in dsl page
    Then dsl bundles stepper in dsl bundles page should be displayed
    And add new address in dsl page
    And enter governorate "<governorate>" and district "<district>" and street name "<streetname>" in your address in dsl page
    And enter building no "<building>" and floor no "<floor>" and apartment no "<apartment>" in your address in dsl page
    And click on saved address in dsl page
    And enter fullname "<fullname>" phone number "<phone>" and landline number "<landline>" in dsl page
    And click on continue button in dsl subscription details page
    And dsl bundles title in dsl bundles page should be "<dslBundlesTitle>"
    And dsl bundles subtitle in dsl bundles page should be displayed
    And first bundle name in dsl bundles page should be "<firstBundleName>"
    And first bundle price in dsl page should be "<firstBundlePrice>"
    And first bundle select button in dsl page should be displayed

    Examples:
      | preferredLanguage | firstBundleName | firstBundlePrice | tabs         | dslBundlesTitle              | landline | governorate | district | streetname | building | floor | apartment | fullname | phone     |
      | en                | 140 GB          | 210 EGP          | DSL          | Vodafone DSL Home Internet   | 22222222 | Cairo       | Maadi    | test       | 11       | 1     | 1         | test     | dslNumber |
      | ar                | 140 جيجا        | 210 جنيه         | انترنت منزلى | الانترنت المنزلي فودافون DSL | 22222222 | القاهرة     | المعادي  | test       | 11       | 1     | 1         | test     | dslNumber |

  @eshop @pipeline @regression @dsl
  Scenario Outline: Check that there are 4 bundles in default tab which is the 1st tab of speed
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on "<tabs>" in nav bar in home page
    And click on subscribe button in dsl page
    Then dsl bundles stepper in dsl bundles page should be displayed
    And add new address in dsl page
    And enter governorate "<governorate>" and district "<district>" and street name "<streetname>" in your address in dsl page
    And enter building no "<building>" and floor no "<floor>" and apartment no "<apartment>" in your address in dsl page
    And click on saved address in dsl page
    And enter fullname "<fullname>" phone number "<phone>" and landline number "<landline>" in dsl page
    And click on continue button in dsl subscription details page
    And dsl bundles title in dsl bundles page should be "<dslBundlesTitle>"
    And dsl bundles subtitle in dsl bundles page should be displayed
    Then default tab of speed should be "<defaultTab>"
    And first bundle name in dsl bundles page should be "<firstBundleName>"
    And second bundle name in dsl bundles page should be "<secondBundleName>"
    And third bundle name in dsl bundles page should be "<thirdBundleName>"
    And fourth bundle name in dsl bundles page should be "<fourthBundleName>"

    Examples:
      | preferredLanguage | firstBundleName | secondBundleName | thirdBundleName | fourthBundleName | defaultTab      | tabs         | governorate | district | streetname | building | floor | apartment | fullname | phone     | landline | dslBundlesTitle              |
      | en                | 140 GB          | 200 GB           | 300 GB          | 600 GB           | Up To 30 Mbps   | DSL          | Cairo       | Maadi    | test       | 11       | 1     | 1         | test     | dslNumber | 22222222 | Vodafone DSL Home Internet   |
      | ar                | 140 جيجا        | 200 جيجا         | 300 جيجا        | 600 جيجا         | تصل الى 30 ميجا | انترنت منزلى | القاهرة     | المعادي  | test       | 11       | 1     | 1         | test     | dslNumber | 22222222 | الانترنت المنزلي فودافون DSL |


  @eshop @pipeline @regression @dsl
  Scenario Outline: Check the present of router name in dsl devices page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When click on "<tabs>" in nav bar in home page
    And click on subscribe button in dsl page
    Then dsl bundles stepper in dsl bundles page should be displayed
    And add new address in dsl page
    And enter governorate "<governorate>" and district "<district>" and street name "<streetname>" in your address in dsl page
    And enter building no "<building>" and floor no "<floor>" and apartment no "<apartment>" in your address in dsl page
    And click on saved address in dsl page
    And enter fullname "<fullname>" phone number "<phone>" and landline number "<landline>" in dsl page
    And click on continue button in dsl subscription details page
    And click on select button in first bundle section in dsl bundles page
    Then router name in dsl devices page should be "<routerName>"

    Examples:
      | preferredLanguage | routerName       | tabs         | governorate | district | streetname | building | floor | apartment | fullname | phone     | landline |
      | en                | VDSL Plus Router | DSL          | Cairo       | Maadi    | test       | 11       | 1     | 1         | test     | dslNumber | 22222222 |
      | ar                | VDSL Plus Router | انترنت منزلى | القاهرة     | المعادي  | test       | 11       | 1     | 1         | test     | dslNumber | 22222222 |

  @eshop @pipeline @regression @dsl
  Scenario Outline: check that user could buy router in cash
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on "<tabs>" in nav bar in home page
    And click on subscribe button in dsl page
    Then dsl bundles stepper in dsl bundles page should be displayed
    And add new address in dsl page
    And enter governorate "<governorate>" and district "<district>" and street name "<streetname>" in your address in dsl page
    And enter building no "<building>" and floor no "<floor>" and apartment no "<apartment>" in your address in dsl page
    And click on saved address in dsl page
    And enter fullname "<fullname>" phone number "<phone>" and landline number "<landline>" in dsl page
    And click on continue button in dsl subscription details page
    And click on select button in first bundle section in dsl bundles page
    And click on select button in choose your router page in dsl page
    And click on cash button in router section in dsl devices page
    Then cash label in router section in dsl checkout page should be displayed

    Examples:
      | preferredLanguage | landline | tabs         | governorate | district | streetname | building | floor | apartment | fullname | phone     |
      | en                | 33333333 | DSL          | Cairo       | Maadi    | test       | 1        | 1     | 1         | test     | dslNumber |
      | ar                | 11111111 | انترنت منزلى | القاهرة     | المعادي  | test       | 1        | 1     | 1         | test     | dslNumber |

  @eshop @pipeline @regression @dsl
  Scenario Outline: check that user could rent router
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on "<tabs>" in nav bar in home page
    And click on subscribe button in dsl page
    Then dsl bundles stepper in dsl bundles page should be displayed
    And add new address in dsl page
    And enter governorate "<governorate>" and district "<district>" and street name "<streetname>" in your address in dsl page
    And enter building no "<building>" and floor no "<floor>" and apartment no "<apartment>" in your address in dsl page
    And click on saved address in dsl page
    And enter fullname "<fullname>" phone number "<phone>" and landline number "<landline>" in dsl page
    And click on continue button in dsl subscription details page
    And click on select button in first bundle section in dsl bundles page
    And click on select button in choose your router page in dsl page
    And click on rent button in router section in dsl devices page
    Then rent label in router section in dsl checkout page should be displayed

    Examples:
      | preferredLanguage | phone     | governorate | landline | tabs         | district | streetname | building | floor | apartment | fullname |
      | en                | dslNumber | Cairo       | 22222222 | DSL          | Maadi    | test       | 1        | 1     | 1         | test     |
      | ar                | dslNumber | القاهرة     | 22222222 | انترنت منزلى | المعادي  | test       | 1        | 1     | 1         | test     |

  @eshop @pipeline @regression @dsl
  Scenario Outline: check that user could edit subscription details
    Given website is opened and user need it to be in language "<preferredLanguage>"
    And click on "<tabs>" in nav bar in home page
    And click on subscribe button in dsl page
    Then dsl bundles stepper in dsl bundles page should be displayed
    And add new address in dsl page
    And enter governorate "<governorate>" and district "<district>" and street name "<streetname>" in your address in dsl page
    And enter building no "<building>" and floor no "<floor>" and apartment no "<apartment>" in your address in dsl page
    And click on saved address in dsl page
    And enter fullname "<fullname>" phone number "<phone>" and landline number "<landline>" in dsl page
    And click on continue button in dsl subscription details page
    And click on select button in first bundle section in dsl bundles page
    And click on select button in choose your router page in dsl page
    And click on cash button in router section in dsl devices page
    And click on edit subscription details button in router section in dsl checkout page
    And add new address in dsl page
    And enter governorate "<governorate>" and district "<district>" and street name "<streetname>" in your address in dsl page
    And enter building no "<building>" and floor no "<floor>" and apartment no "<apartment>" in your address in dsl page
    And click on saved address in dsl page
    And enter fullname "<fullname>" phone number "<phone>" and landline number "<newLandline>" in dsl page
    And click on continue button in dsl subscription details page
    And click on select button in first bundle section in dsl bundles page
    And click on cash button in router section in dsl devices page
    Then cash label in router section in dsl checkout page should be displayed

    Examples:
      | preferredLanguage | phone     | governorate | landline | newLandline | tabs         | district | streetname | building | floor | apartment | fullname |
      | en                | dslNumber | Cairo       | 22222222 | 11111111    | DSL          | Maadi    | test       | 1        | 1     | 1         | test     |
      | ar                | dslNumber | القاهرة     | 22222222 | 11111111    | انترنت منزلى | المعادي  | test       | 1        | 1     | 1         | test     |