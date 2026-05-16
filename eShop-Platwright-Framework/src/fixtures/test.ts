import { test as base, Page } from '@playwright/test';
import { BasePage } from './basePage';

// Define custom fixtures
type TestFixtures = {
  page: Page;
  basePage: BasePage;
};

/**
 * Custom test fixture that extends @playwright/test
 * 
 * This fixture automatically provides:
 * - page: Playwright Page object
 * - basePage: BasePage instance for common operations
 * 
 * Usage in tests:
 * test('example', async ({ page, basePage }) => {
 *   await basePage.navigateTo('https://example.com');
 *   // ... test code
 * });
 */
export const test = base.extend<TestFixtures>({
  basePage: async ({ page }, use) => {
    const basePage = new BasePage(page);
    await use(basePage);
  },
});

export { expect } from '@playwright/test';
