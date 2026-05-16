import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Order Confirmation Page Object Model
 * Handles order confirmation and details
 */
export class OrderConfirmation extends BasePage {
  readonly CONFIRMATION_TITLE = 'h1:has-text("Order Confirmed")';
  readonly ORDER_NUMBER = '[data-testid="order-number"]';
  readonly ORDER_TOTAL = '[data-testid="order-total"]';
  readonly DELIVERY_DATE = '[data-testid="delivery-date"]';
  readonly CONTINUE_SHOPPING_BTN = 'button:has-text("Continue Shopping")';

  constructor(page: Page) {
    super(page);
  }

  async verifyOrderConfirmationPageLoaded(): Promise<boolean> {
    return await this.isElementVisible(this.CONFIRMATION_TITLE);
  }

  async getOrderNumber(): Promise<string> {
    return await this.getText(this.ORDER_NUMBER);
  }

  async getOrderTotal(): Promise<string> {
    return await this.getText(this.ORDER_TOTAL);
  }

  async getDeliveryDate(): Promise<string> {
    return await this.getText(this.DELIVERY_DATE);
  }

  async clickContinueShopping(): Promise<void> {
    await this.click(this.CONTINUE_SHOPPING_BTN);
  }
}
