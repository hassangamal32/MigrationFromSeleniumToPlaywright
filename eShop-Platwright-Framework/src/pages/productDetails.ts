import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Product Details Page Object Model
 * Handles interactions with individual product detail page
 */
export class ProductDetails extends BasePage {
  // Selectors
  readonly PRODUCT_IMAGE = 'img[data-testid="product-image"]';
  readonly PRODUCT_NAME = 'h1[data-testid="product-name"]';
  readonly PRODUCT_PRICE = '[data-testid="product-price"]';
  readonly PRODUCT_DESCRIPTION = '[data-testid="product-description"]';
  readonly STOCK_STATUS = '[data-testid="stock-status"]';
  readonly IN_STOCK_INDICATOR = '.in-stock';
  readonly OUT_OF_STOCK_INDICATOR = '.out-of-stock';
  readonly QUANTITY_INPUT = 'input[data-testid="quantity"]';
  readonly INCREASE_QUANTITY_BTN = 'button[aria-label="Increase quantity"]';
  readonly DECREASE_QUANTITY_BTN = 'button[aria-label="Decrease quantity"]';
  readonly ADD_TO_CART_BTN = 'button:has-text("Add to Cart")';
  readonly BUY_NOW_BTN = 'button:has-text("Buy Now")';
  readonly SPECIFICATIONS = '[data-testid="specifications"]';
  readonly REVIEWS_SECTION = '[data-testid="reviews"]';
  readonly RATING = '[data-testid="product-rating"]';
  readonly IMAGE_GALLERY = '[data-testid="image-gallery"]';
  readonly THUMBNAIL = '[data-testid="thumbnail"]';

  constructor(page: Page) {
    super(page);
  }

  /**
   * Get product name
   */
  async getProductName(): Promise<string> {
    return await this.getText(this.PRODUCT_NAME);
  }

  /**
   * Get product price
   */
  async getProductPrice(): Promise<string> {
    return await this.getText(this.PRODUCT_PRICE);
  }

  /**
   * Get product description
   */
  async getProductDescription(): Promise<string> {
    return await this.getText(this.PRODUCT_DESCRIPTION);
  }

  /**
   * Get product rating
   */
  async getProductRating(): Promise<string> {
    return await this.getText(this.RATING);
  }

  /**
   * Check if product is in stock
   */
  async isProductInStock(): Promise<boolean> {
    return await this.isElementVisible(this.IN_STOCK_INDICATOR);
  }

  /**
   * Check if product is out of stock
   */
  async isProductOutOfStock(): Promise<boolean> {
    return await this.isElementVisible(this.OUT_OF_STOCK_INDICATOR);
  }

  /**
   * Get stock status text
   */
  async getStockStatusText(): Promise<string> {
    return await this.getText(this.STOCK_STATUS);
  }

  /**
   * Get current quantity
   */
  async getQuantity(): Promise<number> {
    const value = await this.getAttribute(this.QUANTITY_INPUT, 'value');
    return parseInt(value || '1', 10);
  }

  /**
   * Set quantity
   */
  async setQuantity(quantity: number): Promise<void> {
    await this.fill(this.QUANTITY_INPUT, quantity.toString());
  }

  /**
   * Increase quantity
   */
  async increaseQuantity(): Promise<void> {
    await this.click(this.INCREASE_QUANTITY_BTN);
  }

  /**
   * Decrease quantity
   */
  async decreaseQuantity(): Promise<void> {
    await this.click(this.DECREASE_QUANTITY_BTN);
  }

  /**
   * Add product to cart
   */
  async addToCart(): Promise<void> {
    await this.click(this.ADD_TO_CART_BTN);
  }

  /**
   * Click buy now
   */
  async clickBuyNow(): Promise<void> {
    await this.click(this.BUY_NOW_BTN);
  }

  /**
   * Get specifications text
   */
  async getSpecifications(): Promise<string> {
    return await this.getText(this.SPECIFICATIONS);
  }

  /**
   * Click on thumbnail to change main image
   */
  async clickThumbnailByIndex(index: number): Promise<void> {
    const selector = `${this.THUMBNAIL}:nth-child(${index + 1})`;
    await this.click(selector);
  }

  /**
   * Get number of product images
   */
  async getImageCount(): Promise<number> {
    return await this.getElementCount(this.THUMBNAIL);
  }

  /**
   * Verify product details page loaded
   */
  async verifyProductDetailsLoaded(): Promise<boolean> {
    return await this.isElementVisible(this.PRODUCT_NAME);
  }

  /**
   * Scroll to reviews section
   */
  async scrollToReviews(): Promise<void> {
    await this.scrollIntoView(this.REVIEWS_SECTION);
  }

  /**
   * Verify add to cart button enabled
   */
  async verifyAddToCartEnabled(): Promise<boolean> {
    const button = this.getElement(this.ADD_TO_CART_BTN);
    return await button.isEnabled();
  }

  /**
   * Verify add to cart button disabled
   */
  async verifyAddToCartDisabled(): Promise<boolean> {
    const button = this.getElement(this.ADD_TO_CART_BTN);
    return !(await button.isEnabled());
  }

  /**
   * Get product main image source
   */
  async getMainImageSource(): Promise<string | null> {
    return await this.getAttribute(this.PRODUCT_IMAGE, 'src');
  }
}
