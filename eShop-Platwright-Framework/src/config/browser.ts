/**
 * Browser Configuration Constants
 */

export const BROWSER_CONFIG = {
  // Timeouts
  DEFAULT_TIMEOUT: parseInt(process.env.DEFAULT_TIMEOUT || '60000', 10),
  ELEMENT_TIMEOUT: parseInt(process.env.ELEMENT_TIMEOUT || '10000', 10),
  NAVIGATION_TIMEOUT: 30000,
  
  // Retry attempts
  CLICK_RETRY_ATTEMPTS: 5,
  
  // Wait strategies
  WAIT_UNTIL_STABLE: 500, // ms to wait for element to stabilize
  
  // Video recording
  VIDEO_ENABLED: true,
  VIDEO_DIR: 'test-results/videos',
  
  // Screenshots
  SCREENSHOT_ON_FAILURE: true,
  SCREENSHOT_DIR: 'test-results/screenshots',
  
  // Headed mode
  HEADED_MODE: process.env.HEADED_MODE !== 'false',
  
  // Report
  REPORT_AUTO_OPEN: process.env.REPORT_AUTO_OPEN !== 'false',
  ALLURE_REPORT_ENABLE: process.env.ALLURE_REPORT_ENABLE !== 'false',
};

export const VIEWPORT = {
  WIDTH: 1920,
  HEIGHT: 1080,
};

export const COLORS = {
  IN_STOCK: '#4CAF50', // Green
  OUT_OF_STOCK: '#FF5252', // Red
  LIMITED_STOCK: '#FFC107', // Amber
};
