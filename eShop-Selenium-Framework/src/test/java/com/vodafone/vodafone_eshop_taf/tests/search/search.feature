Feature: Search

  @eshop @pipeline @regression @search
  Scenario Outline: check search result and the redirection to specific product
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When enter "<productName>" in search field in header section
    And click enter button in keyboard
    Then search result title in search page should be "<productName>"
    And all products in search page should be "<productName>"

    Examples:
      | preferredLanguage | productName |
      | en                | Samsung     |
      | ar                | سامسونج     |

  @eshop @pipeline @regression @search
  Scenario Outline: check remove text from search field
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When enter "<productName>" in search field in header section
    And click enter button in keyboard
    And click on search field in header section
    And click on remove button in search field
    Then remove button in search bar should be disappeared

    Examples:
      | preferredLanguage | productName |
      | en                | apple       |
      | ar                | أبل         |

  @eshop @pipeline @regression @search
  Scenario Outline: check search results for non-existing items
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When enter "<searchText>" in search field in header section
    And click enter button in keyboard
    Then "<resultText>" in search page should be displayed

    Examples:
      | preferredLanguage | searchText  | resultText                              |
      | en                | search      | No Result for what you were looking for |
      | ar                | بحث         | لم يتم العثور على نتائج                 |

  @eshop @pipeline @regression @search
  Scenario Outline: check autocomplete functionality on search
    Given website is opened and user need it to be in language "<preferredLanguage>"
    When enter "<searchText>" in search field in header section
    Then text in drop down list in search field in header section should be "<resultText>"

    Examples:
      | preferredLanguage | searchText  | resultText  |
      | en                | sam         | samsung     |
      | ar                | سام         | سامسونج     |

