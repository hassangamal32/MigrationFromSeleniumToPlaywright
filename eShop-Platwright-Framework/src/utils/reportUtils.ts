/**
 * Report Utilities
 * Handles report generation and auto-opening
 */

import { exec } from 'child_process';
import { promisify } from 'util';
import { existsSync } from 'fs';

const execAsync = promisify(exec);

/**
 * Auto-open Playwright HTML report
 */
export async function openPlaywrightReport(): Promise<void> {
  try {
    const reportPath = 'playwright-report/index.html';

    if (!existsSync(reportPath)) {
      console.warn('Playwright report not found at:', reportPath);
      return;
    }

    const reportUrl = `file:///${process.cwd()}/${reportPath}`.replace(/\\/g, '/');

    if (process.platform === 'win32') {
      // Windows
      await execAsync(`start "" "${reportUrl}"`);
    } else if (process.platform === 'darwin') {
      // macOS
      await execAsync(`open "${reportUrl}"`);
    } else {
      // Linux
      await execAsync(`xdg-open "${reportUrl}"`);
    }

    console.log('Playwright report opened successfully');
  } catch (error) {
    console.error('Failed to open Playwright report:', error);
  }
}

/**
 * Auto-open Allure report
 */
export async function openAllureReport(): Promise<void> {
  try {
    await execAsync('npx allure open');
    console.log('Allure report opened successfully');
  } catch (error) {
    console.error('Failed to open Allure report:', error);
  }
}

/**
 * Generate Allure report
 */
export async function generateAllureReport(): Promise<void> {
  try {
    await execAsync('npx allure generate allure-results --clean -o allure-report');
    console.log('Allure report generated successfully');
  } catch (error) {
    console.error('Failed to generate Allure report:', error);
  }
}
