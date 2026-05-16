import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Personal Details Page Object Model
 * Handles personal information management
 */
export class PersonalDetails extends BasePage {
  readonly FIRST_NAME_INPUT = 'input[name="firstName"]';
  readonly LAST_NAME_INPUT = 'input[name="lastName"]';
  readonly EMAIL_INPUT = 'input[name="email"]';
  readonly PHONE_INPUT = 'input[name="phone"]';
  readonly DATE_OF_BIRTH_INPUT = 'input[name="dateOfBirth"]';
  readonly SAVE_BTN = 'button:has-text("Save")';
  readonly CANCEL_BTN = 'button:has-text("Cancel")';

  constructor(page: Page) {
    super(page);
  }

  async fillPersonalDetails(firstName: string, lastName: string, email: string): Promise<void> {
    await this.fill(this.FIRST_NAME_INPUT, firstName);
    await this.fill(this.LAST_NAME_INPUT, lastName);
    await this.fill(this.EMAIL_INPUT, email);
  }

  async savePersonalDetails(): Promise<void> {
    await this.click(this.SAVE_BTN);
  }

  async getFirstNameValue(): Promise<string> {
    return await this.getAttribute(this.FIRST_NAME_INPUT, 'value') || '';
  }
}
