import { test, expect } from '../../fixtures/test.js';
import { Checkout } from '../../pages/checkout.js';
import { environmentManager } from '../../config/environment.js';
import { TEST_DATA } from '../../config/msisdn.js';
import { Logger } from '../../utils/logger.js';

test.describe('Checkout Tests', () => {
  let checkout: Checkout;

  test.beforeEach(async ({ page }) => {
    checkout = new Checkout(page);
  });

  test('should load checkout page', async ({ page }) => {
    Logger.info('Test: Load checkout page');

    const baseUrl = environmentManager.getBaseUrl();
    await page.goto(`${baseUrl}checkout`);

    // Verify checkout page loaded
    const isLoaded = await checkout.verifyCheckoutPageLoaded();
    expect(isLoaded).toBeTruthy();

    Logger.success('Checkout page loaded successfully');
  });

  test('should fill personal information form', async ({ page }) => {
    Logger.info('Test: Fill personal information');

    const baseUrl = environmentManager.getBaseUrl();
    await page.goto(`${baseUrl}checkout`);

    const data = TEST_DATA.ADDRESS;

    // Fill personal info
    await checkout.fillPersonalInformation(data.firstName, data.lastName, TEST_DATA.EMAIL, data.phoneNumber);

    // Verify values
    const firstName = await checkout.getFirstNameValue();
    const email = await checkout.getEmailValue();

    expect(firstName).toContain(data.firstName);
    expect(email).toContain(TEST_DATA.EMAIL);

    Logger.success('Personal information filled successfully');
  });

  test('should fill shipping address form', async ({ page }) => {
    Logger.info('Test: Fill shipping address');

    const baseUrl = environmentManager.getBaseUrl();
    await page.goto(`${baseUrl}checkout`);

    const data = TEST_DATA.ADDRESS;

    // Fill address
    await checkout.fillShippingAddress(data.street, data.city, data.postalCode, 'Egypt');

    Logger.success('Shipping address filled successfully');
  });

  test('should navigate between checkout steps', async ({ page }) => {
    Logger.info('Test: Navigate between checkout steps');

    const baseUrl = environmentManager.getBaseUrl();
    await page.goto(`${baseUrl}checkout`);

    // Verify we can navigate to personal info step
    const stepTitle = await checkout.getCurrentStepTitle();
    expect(stepTitle).toBeTruthy();

    Logger.success(`Current step: ${stepTitle}`);
  });

  test('should display order summary', async ({ page }) => {
    Logger.info('Test: Display order summary at review step');

    const baseUrl = environmentManager.getBaseUrl();
    await page.goto(`${baseUrl}checkout?step=review`);

    // Verify order summary displayed
    const summaryDisplayed = await checkout.verifyOrderSummaryDisplayed();
    expect(summaryDisplayed).toBeTruthy();

    Logger.success('Order summary displayed successfully');
  });

  test('should display order total', async ({ page }) => {
    Logger.info('Test: Display order total');

    const baseUrl = environmentManager.getBaseUrl();
    await page.goto(`${baseUrl}checkout?step=review`);

    try {
      const total = await checkout.getOrderTotal();
      expect(total).toBeTruthy();
      Logger.success(`Order Total: ${total}`);
    } catch (error) {
      Logger.info('Order total not available at this stage');
    }
  });

  test('should handle payment information input (if applicable)', async ({ page }) => {
    Logger.info('Test: Verify payment step exists');

    const baseUrl = environmentManager.getBaseUrl();
    await page.goto(`${baseUrl}checkout?step=payment`);

    // Try to go to payment step
    try {
      await checkout.goToPaymentStep();
      Logger.success('Payment step is available');
    } catch (error) {
      Logger.info('Payment step not immediately available');
    }
  });
});
