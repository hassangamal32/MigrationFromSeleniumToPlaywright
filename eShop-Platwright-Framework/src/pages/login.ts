import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

/**
 * Login Page Object Model
 * Handles interactions with the login page
 */
export class Login extends BasePage {
  // Selectors
  readonly LOGIN_TITLE = 'h1:has-text("Login")';
  readonly EMAIL_INPUT = 'input[name="email"]';
  readonly PASSWORD_INPUT = 'input[name="password"]';
  readonly LOGIN_BTN = 'button:has-text("Login")';
  readonly REMEMBER_ME_CHECKBOX = 'input[type="checkbox"][name="rememberMe"]';
  readonly FORGOT_PASSWORD_LINK = 'a:has-text("Forgot Password")';
  readonly SIGNUP_LINK = 'a:has-text("Sign Up")';
  readonly ERROR_MESSAGE = '[role="alert"]';
  readonly EMAIL_ERROR = 'span:has-text("Email is required")';
  readonly PASSWORD_ERROR = 'span:has-text("Password is required")';
  readonly SOCIAL_LOGIN_GOOGLE = 'button[aria-label="Sign in with Google"]';
  readonly SOCIAL_LOGIN_FACEBOOK = 'button[aria-label="Sign in with Facebook"]';
  readonly LOADING_SPINNER = '[data-testid="loading-spinner"]';

  constructor(page: Page) {
    super(page);
  }

  /**
   * Verify login page loaded
   */
  async verifyLoginPageLoaded(): Promise<boolean> {
    return await this.isElementVisible(this.LOGIN_TITLE);
  }

  /**
   * Login with email and password
   */
  async login(email: string, password: string): Promise<void> {
    await this.fill(this.EMAIL_INPUT, email);
    await this.fill(this.PASSWORD_INPUT, password);
    await this.click(this.LOGIN_BTN);
    // Wait for loading to complete
    await this.waitForElementToBeHidden(this.LOADING_SPINNER);
  }

  /**
   * Get email input value
   */
  async getEmailValue(): Promise<string> {
    return await this.getAttribute(this.EMAIL_INPUT, 'value') || '';
  }

  /**
   * Get password input value
   */
  async getPasswordValue(): Promise<string> {
    return await this.getAttribute(this.PASSWORD_INPUT, 'value') || '';
  }

  /**
   * Click remember me checkbox
   */
  async clickRememberMe(): Promise<void> {
    await this.click(this.REMEMBER_ME_CHECKBOX);
  }

  /**
   * Check if remember me is checked
   */
  async isRememberMeChecked(): Promise<boolean> {
    const checkbox = this.page.locator(this.REMEMBER_ME_CHECKBOX);
    return await checkbox.isChecked();
  }

  /**
   * Click forgot password
   */
  async clickForgotPassword(): Promise<void> {
    await this.click(this.FORGOT_PASSWORD_LINK);
  }

  /**
   * Click sign up link
   */
  async clickSignUp(): Promise<void> {
    await this.click(this.SIGNUP_LINK);
  }

  /**
   * Get error message
   */
  async getErrorMessage(): Promise<string> {
    return await this.getText(this.ERROR_MESSAGE);
  }

  /**
   * Verify error message displayed
   */
  async verifyErrorMessageDisplayed(): Promise<boolean> {
    return await this.isElementVisible(this.ERROR_MESSAGE);
  }

  /**
   * Verify email error displayed
   */
  async verifyEmailErrorDisplayed(): Promise<boolean> {
    return await this.isElementVisible(this.EMAIL_ERROR);
  }

  /**
   * Verify password error displayed
   */
  async verifyPasswordErrorDisplayed(): Promise<boolean> {
    return await this.isElementVisible(this.PASSWORD_ERROR);
  }

  /**
   * Click Google sign in
   */
  async clickGoogleSignIn(): Promise<void> {
    await this.click(this.SOCIAL_LOGIN_GOOGLE);
  }

  /**
   * Click Facebook sign in
   */
  async clickFacebookSignIn(): Promise<void> {
    await this.click(this.SOCIAL_LOGIN_FACEBOOK);
  }

  /**
   * Verify login button enabled
   */
  async verifyLoginButtonEnabled(): Promise<boolean> {
    const button = this.getElement(this.LOGIN_BTN);
    return await button.isEnabled();
  }

  /**
   * Verify login button disabled
   */
  async verifyLoginButtonDisabled(): Promise<boolean> {
    const button = this.getElement(this.LOGIN_BTN);
    return !(await button.isEnabled());
  }

  /**
   * Clear email input
   */
  async clearEmail(): Promise<void> {
    await this.clear(this.EMAIL_INPUT);
  }

  /**
   * Clear password input
   */
  async clearPassword(): Promise<void> {
    await this.clear(this.PASSWORD_INPUT);
  }
}
