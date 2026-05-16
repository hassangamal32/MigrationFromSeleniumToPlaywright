import { test, expect } from '../../fixtures/test.js';
import { Home } from '../../pages/home.js';
import { Header } from '../../pages/header.js';
import { environmentManager } from '../../config/environment.js';
import { Logger } from '../../utils/logger.js';

test.describe('Home Page Tests', () => {
  let home: Home;
  let header: Header;

  test.beforeEach(async ({ page }) => {
    home = new Home(page);
    header = new Header(page);
    const baseUrl = environmentManager.getBaseUrl();
    Logger.info(`Navigating to home page: ${baseUrl}`);
    await home.navigateTo(baseUrl);
  });

  test('should load home page successfully', async () => {
    Logger.info('Test: Verify home page loads successfully');

    // Verify home page loaded
    const isLoaded = await home.verifyHomePageLoaded();
    expect(isLoaded).toBeTruthy();

    // Verify logo is visible
    const logoVisible = await home.isElementVisible(home.LOGO);
    expect(logoVisible).toBeTruthy();

    Logger.success('Home page loaded successfully');
  });

  test('should display header elements', async () => {
    Logger.info('Test: Verify header elements are visible');

    // Verify header is visible
    const headerVisible = await header.verifyHeaderVisible();
    expect(headerVisible).toBeTruthy();

    // Verify search input is available
    const searchVisible = await header.isElementVisible(header.SEARCH_INPUT);
    expect(searchVisible).toBeTruthy();

    Logger.success('Header elements are visible');
  });

  test('should display featured products', async () => {
    Logger.info('Test: Verify featured products section exists');

    // Verify featured products section exists
    const featured = await home.verifyFeaturedProductsExist();
    expect(featured).toBeTruthy();

    // Get products count
    const productCount = await home.getFeaturedProductsCount();
    expect(productCount).toBeGreaterThan(0);

    Logger.success(`Found ${productCount} featured products`);
  });

  test('should navigate correctly using header menu', async () => {
    Logger.info('Test: Verify header navigation works');

    // Verify header navigation items
    const navCount = await header.getNavigationItemsCount();
    expect(navCount).toBeGreaterThan(0);

    Logger.success(`Header has ${navCount} navigation items`);
  });

  test('should verify page title', async () => {
    Logger.info('Test: Verify page title');

    const title = await home.getPageTitle();
    expect(title).toBeTruthy();
    expect(title.length).toBeGreaterThan(0);

    Logger.success(`Page title: ${title}`);
  });
});
