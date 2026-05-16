import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * MegaMenu Page Object Model
 * Handles interactions with the mega menu navigation
 */
export class MegaMenu extends BasePage {
  readonly MEGA_MENU = '[data-testid="mega-menu"]';
  readonly MENU_ITEM = '.menu-item';
  readonly SUBMENU_ITEM = '.submenu-item';

  constructor(page: Page) {
    super(page);
  }

  async verifyMegaMenuVisible(): Promise<boolean> {
    return await this.isElementVisible(this.MEGA_MENU);
  }

  async clickMenuItemByName(itemName: string): Promise<void> {
    const item = `${this.MENU_ITEM}:has-text("${itemName}")`;
    await this.click(item);
  }

  async clickSubMenuItemByName(subItemName: string): Promise<void> {
    const item = `${this.SUBMENU_ITEM}:has-text("${subItemName}")`;
    await this.click(item);
  }
}
