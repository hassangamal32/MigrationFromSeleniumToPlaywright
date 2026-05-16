import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Products List Page Object Model
 * Handles interactions with the products list/catalog page
 */
export class ProductsList extends BasePage {
  // Selectors
  readonly PRODUCT_ITEM = '[data-testid="product-item"]';
  readonly PRODUCT_NAME = '.product-name';
  readonly PRODUCT_PRICE = '.product-price';
  readonly PRODUCT_STOCK_STATUS = '.stock-status';
  readonly IN_STOCK_BADGE = '.in-stock';
  readonly OUT_OF_STOCK_BADGE = '.out-of-stock';
  readonly PRODUCT_IMAGE = 'img[alt*="product"]';
  readonly FILTER_BUTTON = '[aria-label="Filters"]';
  readonly SORT_DROPDOWN = '[data-testid="sort-dropdown"]';
  readonly VIEW_DETAILS_BUTTON = 'button:has-text("View Details")';
  readonly ADD_TO_CART_BUTTON = 'button:has-text("Add to Cart")';
  readonly PAGINATION = '[data-testid="pagination"]';
  readonly LOADING_SKELETON = '[data-testid="loading-skeleton"]';

  constructor(page: Page) {
    super(page);
  }

  /**
   * Get products count on current page
   */
  async getProductsCount(): Promise<number> {
    return await this.getElementCount(this.PRODUCT_ITEM);
  }

  /**
   * Get all product names
   */
  async getAllProductNames(): Promise<string[]> {
    return await this.getAllText(`${this.PRODUCT_ITEM} ${this.PRODUCT_NAME}`);
  }

  /**
   * Get product name by index
   */
  async getProductNameByIndex(index: number): Promise<string> {
    const selector = `${this.PRODUCT_ITEM}:nth-child(${index + 1}) ${this.PRODUCT_NAME}`;
    return await this.getText(selector);
  }

  /**
   * Get product price by index
   */
  async getProductPriceByIndex(index: number): Promise<string> {
    const selector = `${this.PRODUCT_ITEM}:nth-child(${index + 1}) ${this.PRODUCT_PRICE}`;
    return await this.getText(selector);
  }

  /**
   * Get stock status for product by index
   */
  async getStockStatusByIndex(index: number): Promise<string> {
    const selector = `${this.PRODUCT_ITEM}:nth-child(${index + 1}) ${this.PRODUCT_STOCK_STATUS}`;
    return await this.getText(selector);
  }

  /**
   * Check if product is in stock by index
   */
  async isProductInStockByIndex(index: number): Promise<boolean> {
    const selector = `${this.PRODUCT_ITEM}:nth-child(${index + 1}) ${this.IN_STOCK_BADGE}`;
    return await this.isElementVisible(selector);
  }

  /**
   * Click on first product
   */
  async clickFirstProduct(): Promise<void> {
    const firstProduct = `${this.PRODUCT_ITEM}:first-child`;
    await this.click(firstProduct);
  }

  /**
   * Click on product by name
   */
  async clickProductByName(productName: string): Promise<void> {
    const product = `${this.PRODUCT_ITEM}:has-text("${productName}")`;
    await this.click(product);
  }

  /**
   * Click on product by index
   */
  async clickProductByIndex(index: number): Promise<void> {
    const product = `${this.PRODUCT_ITEM}:nth-child(${index + 1})`;
    await this.click(product);
  }

  /**
   * Select first in-stock product
   * Important user requirement: select first product in filter page (make sure product in stock)
   */
  async selectFirstInStockProduct(): Promise<void> {
    const productsCount = await this.getProductsCount();
    
    for (let i = 0; i < productsCount; i++) {
      const isInStock = await this.isProductInStockByIndex(i);
      if (isInStock) {
        await this.clickProductByIndex(i);
        return;
      }
    }
    
    throw new Error('No in-stock products found on this page');
  }

  /**
   * Get selected first in-stock product name
   */
  async getFirstInStockProductName(): Promise<string> {
    const productsCount = await this.getProductsCount();
    
    for (let i = 0; i < productsCount; i++) {
      const isInStock = await this.isProductInStockByIndex(i);
      if (isInStock) {
        return await this.getProductNameByIndex(i);
      }
    }
    
    throw new Error('No in-stock products found on this page');
  }

  /**
   * Click view details for product by index
   */
  async clickViewDetailsByIndex(index: number): Promise<void> {
    const selector = `${this.PRODUCT_ITEM}:nth-child(${index + 1}) ${this.VIEW_DETAILS_BUTTON}`;
    await this.click(selector);
  }

  /**
   * Click add to cart for product by index
   */
  async clickAddToCartByIndex(index: number): Promise<void> {
    const selector = `${this.PRODUCT_ITEM}:nth-child(${index + 1}) ${this.ADD_TO_CART_BUTTON}`;
    await this.click(selector);
  }

  /**
   * Open filters
   */
  async openFilters(): Promise<void> {
    await this.click(this.FILTER_BUTTON);
  }

  /**
   * Change sort option
   */
  async changeSortOption(sortValue: string): Promise<void> {
    await this.click(this.SORT_DROPDOWN);
    const option = `[data-value="${sortValue}"]`;
    await this.click(option);
  }

  /**
   * Verify products list loaded
   */
  async verifyProductsListLoaded(): Promise<boolean> {
    return (await this.getProductsCount()) > 0;
  }

  /**
   * Wait for products to load
   */
  async waitForProductsToLoad(): Promise<void> {
    await this.waitForElementToBeHidden(this.LOADING_SKELETON);
    // Wait for at least one product to appear
    await this.waitForElement(this.PRODUCT_ITEM);
  }

  /**
   * Go to next page
   */
  async goToNextPage(): Promise<void> {
    const nextButton = `${this.PAGINATION} button[aria-label="Next"]`;
    await this.click(nextButton);
    await this.waitForProductsToLoad();
  }

  /**
   * Go to previous page
   */
  async goToPreviousPage(): Promise<void> {
    const prevButton = `${this.PAGINATION} button[aria-label="Previous"]`;
    await this.click(prevButton);
    await this.waitForProductsToLoad();
  }
}
