import { defineConfig, devices } from '@playwright/test';

/**
 * Playwright Configuration for eShop Automation Framework
 * 
 * Features enabled:
 * - Headed mode: Tests run in visible browser window
 * - Video recording: Captured for all tests
 * - Screenshots: Captured on failure only (to save space)
 * - HTML Report: Auto-opens after test run
 * - Allure Report: Integration enabled
 */

const config = defineConfig({
  testDir: './src/tests',
  fullyParallel: false,
  forbidOnly: !!process.env.CI,
  retries: process.env.CI ? 2 : 0,
  workers: process.env.CI ? 1 : 1,
  
  reporter: [
    ['html', { outputFolder: 'playwright-report', open: 'always' }],
    ['allure-playwright'],
    ['list']
  ],
  
  use: {
    baseURL: process.env.BASE_URL || 'https://eshop.vodafone.com.eg/en/',
    trace: 'on-first-retry',
    screenshot: 'only-on-failure',
    video: 'all',
  },
  
  projects: [
    {
      name: 'chromium',
      use: {
        ...devices['Desktop Chrome'],
        // Headed mode enabled - tests run in visible browser window
        headless: false,
        // Video recording for all tests
        recordVideo: {
          dir: 'test-results/videos',
        },
        // Screenshot on failure
        screenshot: 'only-on-failure',
      },
    },

    // Uncomment to enable Firefox and WebKit testing (Phase 2)
    // {
    //   name: 'firefox',
    //   use: {
    //     ...devices['Desktop Firefox'],
    //     headless: false,
    //     recordVideo: {
    //       dir: 'test-results/videos',
    //     },
    //     screenshot: 'only-on-failure',
    //   },
    // },
    //
    // {
    //   name: 'webkit',
    //   use: {
    //     ...devices['Desktop Safari'],
    //     headless: false,
    //     recordVideo: {
    //       dir: 'test-results/videos',
    //     },
    //     screenshot: 'only-on-failure',
    //   },
    // },
  ],
  
  webServer: undefined,
  
  timeout: 60 * 1000, // 60 seconds per test
  expect: {
    timeout: 10 * 1000, // 10 seconds for assertions
  },
});

export default config;
