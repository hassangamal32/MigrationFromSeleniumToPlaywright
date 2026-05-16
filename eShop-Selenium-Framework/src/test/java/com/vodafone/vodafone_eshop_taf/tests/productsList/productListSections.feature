Feature: Product List Sections

  @eshop @pipeline @productsList @regression
  Scenario Outline: Verify main promotional banners at the top of screen are displayed in All products list page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on all tab in nav bar in home page
    Then  main promotional banner carousel should be displayed in products list page
    And   at least one banner image should be visible in main carousel in products list page
    And   banner navigation arrows should be displayed in products list page

    Examples:
      | preferredLanguage |
      | en                |
      | ar                |

  #These sections are hidden for commercial reasons.
#  @eshop @pipeline @productsList @regression
#  Scenario Outline: Verify second promotional banners at the middle of screen are displayed in All products list page
#    Given website is opened and user need it to be in language "<preferredLanguage>"
#    When  click on all tab in nav bar in home page
#    Then  secondary promotional banner section should be displayed in products list page
#    And   at least one secondary banner image should be visible in products list page
#
#    Examples:
#      | preferredLanguage |
#      | en                |
#      | ar                |
#
#
#  @eshop @pipeline @productsList @regression
#  Scenario Outline: Verify Featured Brands section is displayed and contains brands on All products list page
#    Given website is opened and user need it to be in language "<preferredLanguage>"
#    When  click on all tab in nav bar in home page
#    And   scroll down to featured brands section in products list page
#    Then  featured brands section should be displayed in products list page
#    And   featured brands list should contain "<brandName>" in products list page
#
#    Examples:
#      | preferredLanguage | brandName |
#      | en                | Apple     |
#      | en                | Samsung   |
#      | en                | LG        |
#      | en                | Xiaomi    |
