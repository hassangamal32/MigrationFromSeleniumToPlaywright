import { test, expect } from '../../fixtures/test.js';
import { Home } from '../../pages/home.js';
import { Search } from '../../pages/search.js';
import { environmentManager } from '../../config/environment.js';
import { Logger } from '../../utils/logger.js';

test.describe('Search Tests', () => {
  let home: Home;
  let search: Search;

  test.beforeEach(async ({ page }) => {
    home = new Home(page);
    search = new Search(page);
    const baseUrl = environmentManager.getBaseUrl();
    Logger.info(`Navigating to: ${baseUrl}`);
    await home.navigateTo(baseUrl);
  });

  test('should search for a product successfully', async () => {
    Logger.info('Test: Search for product');

    const searchTerm = 'Flex Plans';
    await home.searchForProduct(searchTerm);

    // Verify search results are displayed
    const resultsDisplayed = await search.verifySearchResultsDisplayed();
    expect(resultsDisplayed).toBeTruthy();

    Logger.success(`Search results displayed for: ${searchTerm}`);
  });

  test('should display multiple search results', async () => {
    Logger.info('Test: Verify multiple search results');

    await home.searchForProduct('plans');

    // Wait for results to load
    await search.waitForElement(search.SEARCH_RESULT_ITEM);

    // Get result count
    const count = await search.getSearchResultCount();
    expect(count).toBeGreaterThan(0);

    Logger.success(`Found ${count} search results`);
  });

  test('should display no results for invalid search', async () => {
    Logger.info('Test: Verify no results message for invalid search');

    await home.searchForProduct('xyz123invalidproduct');

    // Verify no results message
    const noResults = await search.verifyNoResultsMessage();
    expect(noResults).toBeTruthy();

    Logger.success('No results message displayed as expected');
  });

  test('should display product titles in search results', async () => {
    Logger.info('Test: Verify product titles in search results');

    await home.searchForProduct('red');

    // Get all product titles
    const titles = await search.getAllSearchResultTitles();
    expect(titles.length).toBeGreaterThan(0);

    Logger.success(`Found product titles: ${titles.join(', ')}`);
  });

  test('should allow clicking on first search result', async () => {
    Logger.info('Test: Click on first search result');

    await home.searchForProduct('flex');

    // Click first result
    await search.clickFirstSearchResult();

    // Verify navigation occurred
    const url = await home.getCurrentUrl();
    expect(url).not.toContain('search');

    Logger.success('Successfully clicked and navigated from search result');
  });

  test('should clear search input', async () => {
    Logger.info('Test: Clear search input');

    await home.searchForProduct('test');
    const valueBefore = await search.getSearchInputValue();
    expect(valueBefore).toContain('test');

    await search.clearSearchInput();
    const valueAfter = await search.getSearchInputValue();
    expect(valueAfter).toBe('');

    Logger.success('Search input cleared successfully');
  });
});
