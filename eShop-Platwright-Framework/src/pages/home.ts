import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Home Page Object Model
 * Handles interactions with the home page
 */
export class Home extends BasePage {
  // Selectors
  readonly LOGO = 'img[alt="Vodafone Logo"]';
  readonly SEARCH_INPUT = 'input[placeholder="Search"]';
  readonly SEARCH_BUTTON = 'button[aria-label="Search"]';
  readonly HEADER = 'header';
  readonly MEGA_MENU = '[data-testid="mega-menu"]';
  readonly BANNER = '.hero-banner';
  readonly FEATURED_PRODUCTS = '.featured-products';
  readonly PRODUCT_CARD = '.product-card';
  readonly CATEGORY_LINK = 'a[data-category]';

  constructor(page: Page) {
    super(page);
  }

  /**
   * Navigate to home page
   */
  async navigate(): Promise<void> {
    await this.navigateTo(this.page.url().split('/en/')[0] + '/en/');
  }

  /**
   * Verify home page loaded successfully
   */
  async verifyHomePageLoaded(): Promise<boolean> {
    return await this.isElementVisible(this.LOGO);
  }

  /**
   * Search for product
   */
  async searchForProduct(productName: string): Promise<void> {
    await this.fill(this.SEARCH_INPUT, productName);
    await this.click(this.SEARCH_BUTTON);
  }

  /**
   * Get search input value
   */
  async getSearchInputValue(): Promise<string> {
    return await this.getAttribute(this.SEARCH_INPUT, 'value') || '';
  }

  /**
   * Click on category
   */
  async clickCategory(categoryName: string): Promise<void> {
    const categoryLink = `a[data-category="${categoryName}"]`;
    await this.click(categoryLink);
  }

  /**
   * Get featured products count
   */
  async getFeaturedProductsCount(): Promise<number> {
    return await this.getElementCount(this.PRODUCT_CARD);
  }

  /**
   * Click on first featured product
   */
  async clickFirstFeaturedProduct(): Promise<void> {
    const firstProduct = `${this.FEATURED_PRODUCTS} ${this.PRODUCT_CARD}:first-child`;
    await this.click(firstProduct);
  }

  /**
   * Click on product by name
   */
  async clickProductByName(productName: string): Promise<void> {
    const productLink = `a[data-product-name="${productName}"]`;
    await this.click(productLink);
  }

  /**
   * Verify banner is visible
   */
  async verifyBannerVisible(): Promise<boolean> {
    return await this.isElementVisible(this.BANNER);
  }

  /**
   * Get header text
   */
  async getHeaderText(): Promise<string> {
    return await this.getText('h1');
  }

  /**
   * Verify featured products section exists
   */
  async verifyFeaturedProductsExist(): Promise<boolean> {
    return await this.isElementVisible(this.FEATURED_PRODUCTS);
  }
}
