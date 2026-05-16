import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Header Page Object Model
 * Handles interactions with the page header/navigation
 */
export class Header extends BasePage {
  // Selectors
  readonly LOGO = 'img[alt="Vodafone Logo"]';
  readonly MENU_BUTTON = '[aria-label="Menu"]';
  readonly CLOSE_MENU_BUTTON = '[aria-label="Close Menu"]';
  readonly SEARCH_INPUT = 'input[placeholder="Search"]';
  readonly SEARCH_BUTTON = 'button[aria-label="Search"]';
  readonly SHOPPING_CART_ICON = '[aria-label="Shopping Cart"]';
  readonly ACCOUNT_MENU = '[aria-label="Account"]';
  readonly LOGOUT_BUTTON = 'button:has-text("Logout")';
  readonly LOGIN_LINK = 'a:has-text("Login")';
  readonly REGISTER_LINK = 'a:has-text("Register")';
  readonly NAV_ITEMS = 'nav ul li a';

  constructor(page: Page) {
    super(page);
  }

  /**
   * Click on logo to go to home
   */
  async clickLogo(): Promise<void> {
    await this.click(this.LOGO);
  }

  /**
   * Open menu
   */
  async openMenu(): Promise<void> {
    const isVisible = await this.isElementVisible(this.MENU_BUTTON);
    if (isVisible) {
      await this.click(this.MENU_BUTTON);
    }
  }

  /**
   * Close menu
   */
  async closeMenu(): Promise<void> {
    const isVisible = await this.isElementVisible(this.CLOSE_MENU_BUTTON);
    if (isVisible) {
      await this.click(this.CLOSE_MENU_BUTTON);
    }
  }

  /**
   * Search for product from header
   */
  async searchProduct(searchTerm: string): Promise<void> {
    await this.fill(this.SEARCH_INPUT, searchTerm);
    await this.click(this.SEARCH_BUTTON);
  }

  /**
   * Click on shopping cart icon
   */
  async clickShoppingCart(): Promise<void> {
    await this.click(this.SHOPPING_CART_ICON);
  }

  /**
   * Click on account menu
   */
  async clickAccountMenu(): Promise<void> {
    await this.click(this.ACCOUNT_MENU);
  }

  /**
   * Click logout
   */
  async logout(): Promise<void> {
    await this.clickAccountMenu();
    await this.click(this.LOGOUT_BUTTON);
  }

  /**
   * Click on login link
   */
  async clickLoginLink(): Promise<void> {
    await this.click(this.LOGIN_LINK);
  }

  /**
   * Click on register link
   */
  async clickRegisterLink(): Promise<void> {
    await this.click(this.REGISTER_LINK);
  }

  /**
   * Get navigation items count
   */
  async getNavigationItemsCount(): Promise<number> {
    return await this.getElementCount(this.NAV_ITEMS);
  }

  /**
   * Click navigation item by text
   */
  async clickNavigationItem(itemText: string): Promise<void> {
    const navItem = `nav ul li a:has-text("${itemText}")`;
    await this.click(navItem);
  }

  /**
   * Verify header is visible
   */
  async verifyHeaderVisible(): Promise<boolean> {
    return await this.isElementVisible('header');
  }
}
