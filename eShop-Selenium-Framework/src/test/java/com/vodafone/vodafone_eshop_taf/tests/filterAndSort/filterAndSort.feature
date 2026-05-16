Feature: filter and sort

  @eshop @pipeline @productsList @regression
  Scenario Outline: Check the default view for filter in products list page
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    Then  sort by default view should be "<defaultOption>" in products list page
    And   clear filter button should be displayed in products list page
    And   reset all filters button should be displayed in products list page

    Examples:
      | preferredLanguage | tabs          | defaultOption |
      | en                | Smart Phones  | Recommended   |
      | ar                | تليفونات ذكية | الاكثر ترشيحا |

  @eshop @pipeline @productsList @regression
  Scenario Outline: validate sort by options view
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    And   expand sort by drop down menu in products list page
    Then  first sort by value should be "<firstSortBy>" in products list page
    And   second sort by value should be "<secondSortBy>" in products list page
    And   third sort by value should be "<thirdSortBy>" in products list page
    And   fourth sort by value should be "<fourthSortBy>" in products list page
    And   fifth sort by value should be "<fifthSortBy>" in products list page

    Examples:
      | preferredLanguage | tabs          | firstSortBy   | secondSortBy      | thirdSortBy       | fourthSortBy         | fifthSortBy    |
      | en                | Smart Phones  | Recommended   | Price Low to High | Price High to Low | Discount High to Low | Best Rated     |
      | ar                | تليفونات ذكية | الاكثر ترشيحا | السعر - من الاقل  | السعر - من الاعلي | الخصم - من الاعلي    | الأفضل تقييماٌ |


  @eshop @pipeline @productsList @regression
  Scenario Outline: filter by category
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on all tab in nav bar in home page
    And   expand category filter drop down in products list page
    And   expand category title drop down "<categoryTitle>" if needed "<flag>" in products list page
    And   enable the category "<categoryName>" checkbox in products list page
    Then  results should be filtered by "<filterName>" in products list page

    Examples:
      | preferredLanguage | categoryTitle           | flag | categoryName | filterName   |
      | en                | Phones & Accessories    | Yes  | Smart Phones | smart phones |
      | en                | Phones & Accessories    | Yes  | Accessories  | accessories  |
      | en                |                         | No   | Tablets      | tablets      |
      | ar                | التليفونات و الأكسسورات | Yes  | التليفونات   | smart phones |
      | ar                | التليفونات و الأكسسورات | Yes  | الاكسسوارات  | accessories  |
      | ar                |                         | No   | التابلت      | tablets      |
#      | en                | Audio                        | Yes  | True Wireless       | true wireless      |
#      | en                | Audio                        | Yes  | Portable speakers   | portable speakers  |
#      | en                | Audio                        | Yes  | Headphones          | headphones         |
#      | en                |                              | No   | Wearables           | wearables          |
#      | en                |                              | No   | Smart Home          | smart home         |
#      | en                |                              | No   | Special Bundles     | special bundles    |
#      | en                | Deals                        | Yes  | Accessories Deals   | accessories deals  |
#      | en                | Deals                        | Yes  | Gaming Deals        | gaming deals       |
#      | en                | Deals                        | Yes  | Laptop Deals        | laptop deals       |
#      | en                | Deals                        | Yes  | Audio Deals         | audio deals        |
#      | en                | Deals                        | Yes  | Smart Phones Deals  | smart phones deals |
#      | en                | Deals                        | Yes  | Smart TVs Deals   | smart t vs deals  |
#      | en                | Deals                        | Yes  | Tablets Deals       | tablets deals      |
#      | en                | Deals                        | Yes  | Wearables Deals     | wearables deals    |
#      | en                |                              | No   | Wifi Devices        | wifi devices       |
#      | ar                | التلفزيونات و المسرح المنزلى | Yes  | ساوند بار         | soundbars         |
#      | ar                | التلفزيونات و المسرح المنزلى | Yes  | التليفزيونات      | tv                |
#      | ar                | الكمبيوتر                    | Yes  | اللاب توب           | laptops            |
#      | ar                | الكمبيوتر                    | Yes  | كاميرات             | cameras            |
#      | ar                | الكمبيوتر                    | Yes  | فلاش ميمورى         | flash memory       |
#      | ar                | الألعاب                      | Yes  | اجهزة كونسول      | consoles          |
#      | ar                | الألعاب                      | Yes  | شاشات ألعاب         | monitors           |
#      | ar                | الألعاب                      | Yes  | اجهزة تحكم          | controllers        |
#      | ar                | الألعاب                      | Yes  | اكسسوارات ألعاب     | gaming accessories |
#      | ar                | الألعاب                      | Yes  | سى دى ألعاب       | games             |
#      | ar                | السماعات                     | Yes  | سماعات لاسلكية      | true wireless      |
#      | ar                | السماعات                     | Yes  | مكبرات صوت          | portable speakers  |
#      | ar                | السماعات                     | Yes  | سماعات رأس          | headphones         |
#      | ar                |                              | No   | الساعات الذكية      | wearables          |
#      | ar                |                              | No   | البيت الذكى         | smart home         |
#      | ar                |                              | No   | عروض خاصة           | special bundles    |
#      | ar                | العروض                       | Yes  | عروض الأكسسوارات  | accessories deals |
#      | ar                | العروض                       | Yes  | عروض الألعاب        | gaming deals       |
#      | ar                | العروض                       | Yes  | عروض اللاب توب      | laptop deals       |
#      | ar                | العروض                       | Yes  | عروض السماعات       | audio deals        |
#      | ar                | العروض                       | Yes  | عروض التليفونات     | smart phones deals |
#      | ar                | العروض                       | Yes  | عروض التليفزيونات | smart t vs deals  |
#      | ar                | العروض                       | Yes  | عروض التابلت        | tablets deals      |
#      | ar                | العروض                       | Yes  | عروض الساعات الذكية | wearables deals    |
#      | ar                |                              | No   | أجهزة الواى فاى   | wifi devices      |


  @eshop @pipeline @productsList @regression @New
  Scenario Outline: filter by brand
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on all tab in nav bar in home page
    And   expand brand filter drop down in products list page
    And   enable the brand "<brandName>" checkbox in products list page
    Then  the brand filter "<brandName>" should be active in products list page

    Examples:
      | preferredLanguage | brandName |
      | en                | Apple     |
      | en                | Samsung   |
      | en                | Anker     |
      | en                | Logitech  |
      | ar                | أبل       |
      | ar                | سامسونج   |
      | ar                | أنكر      |
      | ar                | Logitech  |
#      | en                | Belkin     |
#      | en                | Asus       |
#      | en                | Lenovo     |
#      | en                | Xiaomi     |
#      | en                | RAVPower   |
#      | en                | Momax      |
#      | en                | Redragon   |
#      | en                | Infinix    |
#      | en                | Sony       |
#      | en                | JBL        |
#      | en                | Huawei     |
#      | en                | Realme     |
#      | en                | MSI        |
#      | en                | HP         |
#      | en                | Panzer     |
#      | en                | ttec       |
##      | en                | HONOR      |
#      | en                | Oraimo     |
#      | en                | WIWU       |
#      | en                | FlakeTech  |
#      | en                | Oppo       |
#      | en                | Philips    |
#      | en                | Razer      |
#      | en                | LG         |
#      | en                | Dell       |
#      | en                | Haier      |
#      | en                | TCL        |
#      | en                | Nintendo   |
#      | en                | Eufy       |
#      | en                | Recci      |
#      | en                | Tornado    |
#      | en                | Hyundai    |
#      | en                | Motorola   |
#      | en                | Vivo       |
#      | en                | Sharp      |
#      | en                | Marvo      |
#      | en                | Etrain     |
#      | en                | Jabra      |
#      | en                | GameSir    |
#      | en                | Manhattan  |
#      | en                | Choetech   |
#      | en                | Hama       |
#      | en                | Sandisk    |
#      | en                | Smart Gate |
#      | en                | DXRacer    |
#      | en                | Zotac      |
#      | en                | Acer       |
#      | ar                | بلكن       |
#      | ar                | Asus       |
#      | ar                | لينوفو     |
#      | ar                | شاومى      |
#      | ar                | راف باور   |
#      | ar                | Momax      |
#      | ar                | Redragon   |
#      | ar                | انفينيكس   |
#      | ar                | سوني       |
#      | ar                | جي بي ال   |
#      | ar                | هواوي      |
#      | ar                | ريل مي     |
#      | ar                | MSI        |
#      | ar                | اتش بي     |
#      | ar                | Panzer     |
#      | ar                | ttec       |
#      | ar                | HONOR      |
#      | ar                | Oraimo     |
#      | ar                | WIWU       |
#      | ar                | FlakeTech  |
#      | ar                | أوبو       |
#      | ar                | Philips    |
#      | ar                | Razer      |
#      | ar                | LG         |
#      | ar                | Dell       |
#      | ar                | Haier      |
#      | ar                | TCL        |
#      | ar                | Nintendo   |
#      | ar                | Eufy       |
#      | ar                | Recci      |
#      | ar                | Tornado    |
#      | ar                | Hyundai    |
#      | ar                | Motorola   |
#      | ar                | Vivo       |
#      | ar                | Sharp      |
#      | ar                | Marvo      |
#      | ar                | Etrain     |
#      | ar                | Jabra      |
#      | ar                | GameSir    |
#      | ar                | Manhattan  |
#      | ar                | Choetech   |
#      | ar                | هاما       |
#      | ar                | Sandisk    |
#      | ar                | Smart Gate |
#      | ar                | DXRacer    |
#      | ar                | Zotac      |
#      | ar                | Acer       |


  @eshop @pipeline @productsList @regression @New
  Scenario Outline: filter by price options
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on all tab in nav bar in home page
    And   expand price filter drop down in products list page
    And   enable the price "<priceFilterName>" checkbox in products list page
    Then  first item price should be "<priceFilterOption>"

    Examples:
      | preferredLanguage | priceFilterName    | priceFilterOption |
      | en                | Below 2,000        | Below 2,000       |
      | en                | 2,000 to 4,000     | 2,000 to 4,000    |
      | en                | 6,000 to 10,000    | 6,000 to 10,000   |
      | en                | 12,000 to 18,000   | 12,000 to 18,000  |
      | en                | Above 21,000       | Above 21,000      |
      | ar                | أقل من 2000        | Below 2,000       |
      | ar                | من 2000 الى 4000   | 2,000 to 4,000    |
      | ar                | من 6000 الى 10000  | 6,000 to 10,000   |
      | ar                | من 12000 الى 18000 | 12,000 to 18,000  |
      | ar                | أعلى من 21000      | Above 21,000      |


  @eshop @pipeline @productsList @regression @New
  Scenario Outline: filter by custom price
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on all tab in nav bar in home page
    And   expand price filter drop down in products list page
    And   enter minimum value "<min>" for price filter in products list page
    And   enter maximum value "<max>" for price filter in products list page
    And   click on apply button for price filter in products list page
    Then  first item price should be between min <min> and max <max> in products list page

    Examples:
      | preferredLanguage | min  | max  |
      | en                | 3000 | 5000 |
      | ar                | 3000 | 5000 |


  @eshop @pipeline @productsList @regression @New
  Scenario Outline: sort by Price low to high
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    And   expand sort by drop down menu in products list page
    And   select sort by price low to high in products list page
    Then  first item price should be less than or equal second item price in products list page

    Examples:
      | preferredLanguage | tabs          |
      | en                | Smart Phones  |
      | ar                | تليفونات ذكية |


  @eshop @pipeline @productsList @regression @New
  Scenario Outline: sort by Price high to low
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    And   expand sort by drop down menu in products list page
    And   select sort by price high to low in products list page
    Then  first item price should be greater than or equal second item price in products list page

    Examples:
      | preferredLanguage | tabs          |
      | en                | Smart Phones  |
      | ar                | تليفونات ذكية |


  @eshop @pipeline @productsList @regression @New
  Scenario Outline: sort by discount high to low
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    And   expand sort by drop down menu in products list page
    And   select sort by discount high to low in products list page
    Then  first item discount should be greater than or equal second item discount in products list page

    Examples:
      | preferredLanguage | tabs          |
      | en                | Smart Phones  |
      | ar                | تليفونات ذكية |


  @eshop @pipeline @productsList @regression @New
  Scenario Outline: sort by best rated
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When  click on "<tabs>" in nav bar in home page
    And   expand sort by drop down menu in products list page
    And   select sort by best rated in products list page
    Then  first item rate should be greater than or equal second item rate in products list page

    Examples:
      | preferredLanguage | tabs          |
      | en                | Smart Phones  |
      | ar                | تليفونات ذكية |

