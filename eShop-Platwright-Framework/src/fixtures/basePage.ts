import { Page, Locator, expect } from '@playwright/test';
import { BROWSER_CONFIG } from '../config/browser';

/**
 * BasePage - Abstract base class for all Page Object Model classes
 * 
 * Provides common methods for:
 * - Element interaction (click, fill, type)
 * - Waiting for elements
 * - Navigation
 * - Screenshots and videos
 * - Assertions and verification
 */
export class BasePage {
  protected page: Page;

  constructor(page: Page) {
    this.page = page;
  }

  /**
   * Navigate to a specific URL
   */
  async navigateTo(url: string): Promise<void> {
    await this.page.goto(url, { waitUntil: 'networkidle' });
  }

  /**
   * Navigate to base URL
   */
  async navigateToBaseUrl(): Promise<void> {
    await this.page.goto(this.page.context().browser()?.contexts()[0]?.browser?.name || '/', {
      waitUntil: 'networkidle',
    });
  }

  /**
   * Wait for element to be visible with timeout
   */
  async waitForElement(selector: string, timeout: number = BROWSER_CONFIG.ELEMENT_TIMEOUT): Promise<Locator> {
    const locator = this.page.locator(selector);
    await locator.waitFor({ state: 'visible', timeout });
    return locator;
  }

  /**
   * Wait for element to be hidden
   */
  async waitForElementToBeHidden(
    selector: string,
    timeout: number = BROWSER_CONFIG.ELEMENT_TIMEOUT,
  ): Promise<void> {
    await this.page.locator(selector).waitFor({ state: 'hidden', timeout });
  }

  /**
   * Get locator for element (without waiting)
   */
  getElement(selector: string): Locator {
    return this.page.locator(selector);
  }

  /**
   * Safe click with retry logic (Selenium equivalent: safeClick)
   */
  async click(selector: string, retries: number = BROWSER_CONFIG.CLICK_RETRY_ATTEMPTS): Promise<void> {
    for (let attempt = 1; attempt <= retries; attempt++) {
      try {
        const locator = this.page.locator(selector);
        await locator.click({ force: false });
        return;
      } catch (error) {
        if (attempt === retries) {
          throw error;
        }
        // Wait a bit before retry
        await this.page.waitForTimeout(BROWSER_CONFIG.WAIT_UNTIL_STABLE);
      }
    }
  }

  /**
   * Safe click using JavaScript (for stubborn elements)
   */
  async clickWithJavaScript(selector: string): Promise<void> {
    await this.page.evaluate((sel: string) => {
      const element = document.querySelector(sel) as HTMLElement;
      if (element) {
        element.click();
      }
    }, selector);
  }

  /**
   * Fill input field with text
   */
  async fill(selector: string, value: string): Promise<void> {
    const locator = this.page.locator(selector);
    await locator.fill(value);
  }

  /**
   * Clear input field
   */
  async clear(selector: string): Promise<void> {
    const locator = this.page.locator(selector);
    await locator.clear();
  }

  /**
   * Type text character by character
   */
  async type(selector: string, value: string, delay: number = 50): Promise<void> {
    const locator = this.page.locator(selector);
    await locator.type(value, { delay });
  }

  /**
   * Get element text content
   */
  async getText(selector: string): Promise<string> {
    const locator = this.page.locator(selector);
    return await locator.textContent() || '';
  }

  /**
   * Get element attribute value
   */
  async getAttribute(selector: string, attribute: string): Promise<string | null> {
    const locator = this.page.locator(selector);
    return await locator.getAttribute(attribute);
  }

  /**
   * Check if element is visible
   */
  async isElementVisible(selector: string): Promise<boolean> {
    try {
      await this.page.locator(selector).waitFor({ state: 'visible', timeout: 5000 });
      return true;
    } catch {
      return false;
    }
  }

  /**
   * Check if element exists in DOM
   */
  async isElementPresent(selector: string): Promise<boolean> {
    const locator = this.page.locator(selector);
    return await locator.isVisible().catch(() => false);
  }

  /**
   * Check if element is clickable
   */
  async isElementClickable(selector: string): Promise<boolean> {
    try {
      const locator = this.page.locator(selector);
      return await locator.isEnabled();
    } catch {
      return false;
    }
  }

  /**
   * Get count of elements matching selector
   */
  async getElementCount(selector: string): Promise<number> {
    return await this.page.locator(selector).count();
  }

  /**
   * Get all text content of elements matching selector
   */
  async getAllText(selector: string): Promise<string[]> {
    const locator = this.page.locator(selector);
    const count = await locator.count();
    const texts: string[] = [];
    for (let i = 0; i < count; i++) {
      const text = await locator.nth(i).textContent();
      if (text) {
        texts.push(text.trim());
      }
    }
    return texts;
  }

  /**
   * Scroll element into view
   */
  async scrollIntoView(selector: string): Promise<void> {
    const locator = this.page.locator(selector);
    await locator.scrollIntoViewIfNeeded();
  }

  /**
   * Scroll to top of page
   */
  async scrollToTop(): Promise<void> {
    await this.page.evaluate(() => window.scrollTo(0, 0));
  }

  /**
   * Scroll to bottom of page
   */
  async scrollToBottom(): Promise<void> {
    await this.page.evaluate(() => window.scrollTo(0, document.body.scrollHeight));
  }

  /**
   * Scroll by pixels (positive = down, negative = up)
   */
  async scroll(pixels: number): Promise<void> {
    await this.page.evaluate((py: number) => window.scrollBy(0, py), pixels);
  }

  /**
   * Get current page URL
   */
  async getCurrentUrl(): Promise<string> {
    return this.page.url();
  }

  /**
   * Wait for URL to contain/match text
   */
  async waitForUrlContains(urlPart: string, timeout: number = 10000): Promise<void> {
    await this.page.waitForURL(`**/*${urlPart}*`, { timeout });
  }

  /**
   * Navigate back
   */
  async navigateBack(): Promise<void> {
    await this.page.goBack({ waitUntil: 'networkidle' });
  }

  /**
   * Navigate forward
   */
  async navigateForward(): Promise<void> {
    await this.page.goForward({ waitUntil: 'networkidle' });
  }

  /**
   * Reload page
   */
  async reloadPage(): Promise<void> {
    await this.page.reload({ waitUntil: 'networkidle' });
  }

  /**
   * Wait for page title
   */
  async waitForPageTitle(title: string, timeout: number = 10000): Promise<void> {
    await this.page.waitForFunction(
      (expectedTitle: string) => document.title === expectedTitle,
      expectedTitle,
      { timeout },
    );
  }

  /**
   * Get page title
   */
  async getPageTitle(): Promise<string> {
    return this.page.title();
  }

  /**
   * Execute JavaScript code
   */
  async executeScript<T>(script: string | ((arg?: any) => T), arg?: any): Promise<T> {
    return await this.page.evaluate(script, arg);
  }

  /**
   * Wait for specific time (use sparingly)
   */
  async wait(milliseconds: number): Promise<void> {
    await this.page.waitForTimeout(milliseconds);
  }

  /**
   * Take screenshot
   */
  async takeScreenshot(fileName?: string): Promise<Buffer | string> {
    const path = fileName ? `test-results/screenshots/${fileName}.png` : undefined;
    return await this.page.screenshot({ path, fullPage: true });
  }

  /**
   * Get page height
   */
  async getPageHeight(): Promise<number> {
    return await this.page.evaluate(() => document.documentElement.scrollHeight);
  }

  /**
   * Focus on element
   */
  async focus(selector: string): Promise<void> {
    await this.page.locator(selector).focus();
  }

  /**
   * Hover over element
   */
  async hover(selector: string): Promise<void> {
    await this.page.locator(selector).hover();
  }

  /**
   * Press key
   */
  async pressKey(key: string): Promise<void> {
    await this.page.keyboard.press(key);
  }

  /**
   * Press multiple keys (e.g., 'Control+A')
   */
  async pressKeys(...keys: string[]): Promise<void> {
    for (const key of keys) {
      await this.page.keyboard.press(key);
    }
  }

  /**
   * Accept dialog/alert
   */
  async acceptDialog(): Promise<void> {
    this.page.once('dialog', (dialog) => dialog.accept());
  }

  /**
   * Dismiss dialog/alert
   */
  async dismissDialog(): Promise<void> {
    this.page.once('dialog', (dialog) => dialog.dismiss());
  }

  /**
   * Assertion: Element should be visible
   */
  async assertElementVisible(selector: string, message?: string): Promise<void> {
    const locator = this.page.locator(selector);
    await expect(locator).toBeVisible();
  }

  /**
   * Assertion: Element should have text
   */
  async assertElementHasText(selector: string, expectedText: string): Promise<void> {
    const locator = this.page.locator(selector);
    await expect(locator).toContainText(expectedText);
  }

  /**
   * Assertion: Element should have exact text
   */
  async assertElementHasExactText(selector: string, expectedText: string): Promise<void> {
    const locator = this.page.locator(selector);
    await expect(locator).toHaveText(expectedText);
  }

  /**
   * Assertion: URL should contain text
   */
  async assertUrlContains(urlPart: string): Promise<void> {
    await expect(this.page).toHaveURL(new RegExp(urlPart));
  }

  /**
   * Assertion: Page should contain text
   */
  async assertPageContainsText(text: string): Promise<void> {
    await expect(this.page.locator('body')).toContainText(text);
  }
}
