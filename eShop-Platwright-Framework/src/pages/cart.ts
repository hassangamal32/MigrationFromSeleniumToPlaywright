import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Cart Page Object Model
 * Handles interactions with the shopping cart
 */
export class Cart extends BasePage {
  // Selectors
  readonly CART_ITEM = '[data-testid="cart-item"]';
  readonly ITEM_NAME = '.item-name';
  readonly ITEM_PRICE = '.item-price';
  readonly ITEM_QUANTITY = 'input[data-testid="quantity"]';
  readonly INCREASE_QTY_BTN = 'button[aria-label="Increase quantity"]';
  readonly DECREASE_QTY_BTN = 'button[aria-label="Decrease quantity"]';
  readonly REMOVE_BTN = 'button:has-text("Remove")';
  readonly SUBTOTAL = '[data-testid="subtotal"]';
  readonly TAX = '[data-testid="tax"]';
  readonly TOTAL = '[data-testid="total"]';
  readonly CHECKOUT_BTN = 'button:has-text("Proceed to Checkout")';
  readonly CONTINUE_SHOPPING_BTN = 'button:has-text("Continue Shopping")';
  readonly EMPTY_CART_MESSAGE = 'p:has-text("Your cart is empty")';
  readonly PROMO_CODE_INPUT = 'input[placeholder="Enter promo code"]';
  readonly APPLY_PROMO_BTN = 'button:has-text("Apply")';
  readonly CART_SUMMARY = '[data-testid="cart-summary"]';

  constructor(page: Page) {
    super(page);
  }

  /**
   * Get cart items count
   */
  async getCartItemsCount(): Promise<number> {
    return await this.getElementCount(this.CART_ITEM);
  }

  /**
   * Verify cart is not empty
   */
  async verifyCartNotEmpty(): Promise<boolean> {
    return (await this.getCartItemsCount()) > 0;
  }

  /**
   * Verify cart is empty
   */
  async verifyCartEmpty(): Promise<boolean> {
    return await this.isElementVisible(this.EMPTY_CART_MESSAGE);
  }

  /**
   * Get item name by index
   */
  async getItemNameByIndex(index: number): Promise<string> {
    const selector = `${this.CART_ITEM}:nth-child(${index + 1}) ${this.ITEM_NAME}`;
    return await this.getText(selector);
  }

  /**
   * Get item price by index
   */
  async getItemPriceByIndex(index: number): Promise<string> {
    const selector = `${this.CART_ITEM}:nth-child(${index + 1}) ${this.ITEM_PRICE}`;
    return await this.getText(selector);
  }

  /**
   * Get item quantity by index
   */
  async getItemQuantityByIndex(index: number): Promise<number> {
    const selector = `${this.CART_ITEM}:nth-child(${index + 1}) ${this.ITEM_QUANTITY}`;
    const value = await this.getAttribute(selector, 'value');
    return parseInt(value || '1', 10);
  }

  /**
   * Set item quantity by index
   */
  async setItemQuantityByIndex(index: number, quantity: number): Promise<void> {
    const selector = `${this.CART_ITEM}:nth-child(${index + 1}) ${this.ITEM_QUANTITY}`;
    await this.fill(selector, quantity.toString());
  }

  /**
   * Increase item quantity by index
   */
  async increaseItemQuantityByIndex(index: number): Promise<void> {
    const selector = `${this.CART_ITEM}:nth-child(${index + 1}) ${this.INCREASE_QTY_BTN}`;
    await this.click(selector);
  }

  /**
   * Decrease item quantity by index
   */
  async decreaseItemQuantityByIndex(index: number): Promise<void> {
    const selector = `${this.CART_ITEM}:nth-child(${index + 1}) ${this.DECREASE_QTY_BTN}`;
    await this.click(selector);
  }

  /**
   * Remove item from cart by index
   */
  async removeItemByIndex(index: number): Promise<void> {
    const selector = `${this.CART_ITEM}:nth-child(${index + 1}) ${this.REMOVE_BTN}`;
    await this.click(selector);
  }

  /**
   * Remove item by name
   */
  async removeItemByName(itemName: string): Promise<void> {
    const selector = `${this.CART_ITEM}:has-text("${itemName}") ${this.REMOVE_BTN}`;
    await this.click(selector);
  }

  /**
   * Get subtotal
   */
  async getSubtotal(): Promise<string> {
    return await this.getText(this.SUBTOTAL);
  }

  /**
   * Get tax amount
   */
  async getTax(): Promise<string> {
    return await this.getText(this.TAX);
  }

  /**
   * Get total price
   */
  async getTotal(): Promise<string> {
    return await this.getText(this.TOTAL);
  }

  /**
   * Proceed to checkout
   */
  async proceedToCheckout(): Promise<void> {
    await this.click(this.CHECKOUT_BTN);
  }

  /**
   * Continue shopping
   */
  async continueShopping(): Promise<void> {
    await this.click(this.CONTINUE_SHOPPING_BTN);
  }

  /**
   * Apply promo code
   */
  async applyPromoCode(promoCode: string): Promise<void> {
    await this.fill(this.PROMO_CODE_INPUT, promoCode);
    await this.click(this.APPLY_PROMO_BTN);
  }

  /**
   * Verify checkout button visible
   */
  async verifyCheckoutButtonVisible(): Promise<boolean> {
    return await this.isElementVisible(this.CHECKOUT_BTN);
  }

  /**
   * Get all item names in cart
   */
  async getAllItemNames(): Promise<string[]> {
    return await this.getAllText(`${this.CART_ITEM} ${this.ITEM_NAME}`);
  }

  /**
   * Verify item in cart by name
   */
  async verifyItemInCart(itemName: string): Promise<boolean> {
    const items = await this.getAllItemNames();
    return items.some((name) => name.includes(itemName));
  }
}
