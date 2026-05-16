import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Search Page Object Model
 * Handles interactions with the search functionality
 */
export class Search extends BasePage {
  // Selectors
  readonly SEARCH_INPUT = 'input[placeholder="Search products"]';
  readonly SEARCH_BUTTON = 'button[type="submit"]:has-text("Search")';
  readonly SEARCH_RESULTS_CONTAINER = '[data-testid="search-results"]';
  readonly SEARCH_RESULT_ITEM = '.search-result-item';
  readonly NO_RESULTS_MESSAGE = 'p:has-text("No results found")';
  readonly RESULT_COUNT = '[data-testid="result-count"]';
  readonly LOADING_INDICATOR = '[aria-label="Loading"]';

  constructor(page: Page) {
    super(page);
  }

  /**
   * Search for a product
   */
  async searchProduct(productName: string): Promise<void> {
    await this.fill(this.SEARCH_INPUT, productName);
    await this.click(this.SEARCH_BUTTON);
    // Wait for search results to load
    await this.waitForElementToBeHidden(this.LOADING_INDICATOR);
  }

  /**
   * Get search input value
   */
  async getSearchInputValue(): Promise<string> {
    return await this.getAttribute(this.SEARCH_INPUT, 'value') || '';
  }

  /**
   * Get search result count
   */
  async getSearchResultCount(): Promise<number> {
    return await this.getElementCount(this.SEARCH_RESULT_ITEM);
  }

  /**
   * Verify search results displayed
   */
  async verifySearchResultsDisplayed(): Promise<boolean> {
    return await this.isElementVisible(this.SEARCH_RESULTS_CONTAINER);
  }

  /**
   * Verify no results message
   */
  async verifyNoResultsMessage(): Promise<boolean> {
    return await this.isElementVisible(this.NO_RESULTS_MESSAGE);
  }

  /**
   * Click on first search result
   */
  async clickFirstSearchResult(): Promise<void> {
    const firstResult = `${this.SEARCH_RESULT_ITEM}:first-child`;
    await this.click(firstResult);
  }

  /**
   * Click on search result by text
   */
  async clickSearchResultByText(productName: string): Promise<void> {
    const result = `${this.SEARCH_RESULT_ITEM}:has-text("${productName}")`;
    await this.click(result);
  }

  /**
   * Get all search result titles
   */
  async getAllSearchResultTitles(): Promise<string[]> {
    return await this.getAllText(`${this.SEARCH_RESULT_ITEM} h3`);
  }

  /**
   * Clear search input
   */
  async clearSearchInput(): Promise<void> {
    await this.clear(this.SEARCH_INPUT);
  }

  /**
   * Verify search input focused
   */
  async verifySearchInputFocused(): Promise<void> {
    await this.focus(this.SEARCH_INPUT);
  }

  /**
   * Get result count text
   */
  async getResultCountText(): Promise<string> {
    return await this.getText(this.RESULT_COUNT);
  }
}
