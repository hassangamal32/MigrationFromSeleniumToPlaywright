import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Payment Page Object Model
 * Handles payment processing
 */
export class Payment extends BasePage {
  readonly PAYMENT_METHOD = '[data-testid="payment-method"]';
  readonly CARD_DETAILS = '[data-testid="card-details"]';
  readonly PAY_BTN = 'button:has-text("Pay")';
  readonly CANCEL_BTN = 'button:has-text("Cancel")';

  constructor(page: Page) {
    super(page);
  }

  async selectPaymentMethod(method: string): Promise<void> {
    const selector = `[data-value="${method}"]`;
    await this.click(selector);
  }

  async clickPayButton(): Promise<void> {
    await this.click(this.PAY_BTN);
  }

  async verifyPaymentPageLoaded(): Promise<boolean> {
    return await this.isElementVisible(this.PAYMENT_METHOD);
  }
}
