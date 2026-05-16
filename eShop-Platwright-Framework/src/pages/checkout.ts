import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Checkout Page Object Model
 * Handles interactions with the checkout process
 */
export class Checkout extends BasePage {
  // Selectors
  readonly CHECKOUT_TITLE = 'h1:has-text("Checkout")';
  readonly PERSONAL_INFO_TAB = '[data-testid="tab-personal-info"]';
  readonly SHIPPING_TAB = '[data-testid="tab-shipping"]';
  readonly PAYMENT_TAB = '[data-testid="tab-payment"]';
  readonly REVIEW_TAB = '[data-testid="tab-review"]';

  // Personal Information
  readonly FIRST_NAME_INPUT = 'input[name="firstName"]';
  readonly LAST_NAME_INPUT = 'input[name="lastName"]';
  readonly EMAIL_INPUT = 'input[name="email"]';
  readonly PHONE_INPUT = 'input[name="phone"]';

  // Shipping Address
  readonly ADDRESS_INPUT = 'input[name="address"]';
  readonly CITY_INPUT = 'input[name="city"]';
  readonly POSTAL_CODE_INPUT = 'input[name="postalCode"]';
  readonly COUNTRY_SELECT = 'select[name="country"]';

  // Payment
  readonly PAYMENT_METHOD_SELECT = '[data-testid="payment-method"]';
  readonly CARD_NUMBER_INPUT = 'input[name="cardNumber"]';
  readonly CVV_INPUT = 'input[name="cvv"]';
  readonly EXPIRY_INPUT = 'input[name="expiry"]';

  // Buttons
  readonly NEXT_BTN = 'button:has-text("Next")';
  readonly PREVIOUS_BTN = 'button:has-text("Previous")';
  readonly COMPLETE_ORDER_BTN = 'button:has-text("Complete Order")';
  readonly REVIEW_ORDER_BTN = 'button:has-text("Review Order")';

  // Order Review
  readonly ORDER_SUMMARY = '[data-testid="order-summary"]';
  readonly ORDER_TOTAL = '[data-testid="order-total"]';
  readonly CONFIRM_ORDER_BTN = 'button:has-text("Confirm Order")';

  constructor(page: Page) {
    super(page);
  }

  /**
   * Verify checkout page loaded
   */
  async verifyCheckoutPageLoaded(): Promise<boolean> {
    return await this.isElementVisible(this.CHECKOUT_TITLE);
  }

  /**
   * Fill personal information
   */
  async fillPersonalInformation(firstName: string, lastName: string, email: string, phone: string): Promise<void> {
    await this.fill(this.FIRST_NAME_INPUT, firstName);
    await this.fill(this.LAST_NAME_INPUT, lastName);
    await this.fill(this.EMAIL_INPUT, email);
    await this.fill(this.PHONE_INPUT, phone);
  }

  /**
   * Fill shipping address
   */
  async fillShippingAddress(
    address: string,
    city: string,
    postalCode: string,
    country: string,
  ): Promise<void> {
    await this.fill(this.ADDRESS_INPUT, address);
    await this.fill(this.CITY_INPUT, city);
    await this.fill(this.POSTAL_CODE_INPUT, postalCode);
    // Select country from dropdown
    await this.page.selectOption(this.COUNTRY_SELECT, country);
  }

  /**
   * Get current step title
   */
  async getCurrentStepTitle(): Promise<string> {
    const tabs = await this.page.locator('[data-testid*="tab-"]').filter({ state: 'visible' });
    return await tabs.first().textContent() || '';
  }

  /**
   * Click next button
   */
  async clickNext(): Promise<void> {
    await this.click(this.NEXT_BTN);
  }

  /**
   * Click previous button
   */
  async clickPrevious(): Promise<void> {
    await this.click(this.PREVIOUS_BTN);
  }

  /**
   * Fill payment information
   */
  async fillPaymentInformation(cardNumber: string, cvv: string, expiry: string): Promise<void> {
    await this.fill(this.CARD_NUMBER_INPUT, cardNumber);
    await this.fill(this.CVV_INPUT, cvv);
    await this.fill(this.EXPIRY_INPUT, expiry);
  }

  /**
   * Select payment method
   */
  async selectPaymentMethod(method: string): Promise<void> {
    await this.click(this.PAYMENT_METHOD_SELECT);
    const option = `[data-value="${method}"]`;
    await this.click(option);
  }

  /**
   * Get order total
   */
  async getOrderTotal(): Promise<string> {
    return await this.getText(this.ORDER_TOTAL);
  }

  /**
   * Complete order
   */
  async completeOrder(): Promise<void> {
    await this.click(this.COMPLETE_ORDER_BTN);
  }

  /**
   * Confirm order
   */
  async confirmOrder(): Promise<void> {
    await this.click(this.CONFIRM_ORDER_BTN);
  }

  /**
   * Verify order summary displayed
   */
  async verifyOrderSummaryDisplayed(): Promise<boolean> {
    return await this.isElementVisible(this.ORDER_SUMMARY);
  }

  /**
   * Get first name value
   */
  async getFirstNameValue(): Promise<string> {
    return await this.getAttribute(this.FIRST_NAME_INPUT, 'value') || '';
  }

  /**
   * Get email value
   */
  async getEmailValue(): Promise<string> {
    return await this.getAttribute(this.EMAIL_INPUT, 'value') || '';
  }

  /**
   * Go to personal info step
   */
  async goToPersonalInfoStep(): Promise<void> {
    await this.click(this.PERSONAL_INFO_TAB);
  }

  /**
   * Go to shipping step
   */
  async goToShippingStep(): Promise<void> {
    await this.click(this.SHIPPING_TAB);
  }

  /**
   * Go to payment step
   */
  async goToPaymentStep(): Promise<void> {
    await this.click(this.PAYMENT_TAB);
  }

  /**
   * Go to review step
   */
  async goToReviewStep(): Promise<void> {
    await this.click(this.REVIEW_TAB);
  }
}
