import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Addresses Page Object Model
 * Handles address management
 */
export class Addresses extends BasePage {
  readonly ADDRESS_LIST = '[data-testid="address-list"]';
  readonly ADDRESS_ITEM = '.address-item';
  readonly ADD_ADDRESS_BTN = 'button:has-text("Add Address")';
  readonly EDIT_BTN = 'button[aria-label="Edit"]';
  readonly DELETE_BTN = 'button[aria-label="Delete"]';

  constructor(page: Page) {
    super(page);
  }

  async getAddressesCount(): Promise<number> {
    return await this.getElementCount(this.ADDRESS_ITEM);
  }

  async clickAddAddress(): Promise<void> {
    await this.click(this.ADD_ADDRESS_BTN);
  }

  async editAddressByIndex(index: number): Promise<void> {
    const selector = `${this.ADDRESS_ITEM}:nth-child(${index + 1}) ${this.EDIT_BTN}`;
    await this.click(selector);
  }

  async deleteAddressByIndex(index: number): Promise<void> {
    const selector = `${this.ADDRESS_ITEM}:nth-child(${index + 1}) ${this.DELETE_BTN}`;
    await this.click(selector);
  }
}
