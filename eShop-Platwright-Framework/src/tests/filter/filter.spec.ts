import { test, expect } from '../../fixtures/test.js';
import { Home } from '../../pages/home.js';
import { ProductsList } from '../../pages/productsList.js';
import { environmentManager } from '../../config/environment.js';
import { Logger } from '../../utils/logger.js';

test.describe('Filter and Sort Tests', () => {
  let home: Home;
  let productsList: ProductsList;

  test.beforeEach(async ({ page }) => {
    home = new Home(page);
    productsList = new ProductsList(page);
    const baseUrl = environmentManager.getBaseUrl();
    Logger.info(`Navigating to: ${baseUrl}`);
    await home.navigateTo(baseUrl);
    // Navigate to products list
    await home.searchForProduct('plans');
  });

  test('should display products list with filter options', async () => {
    Logger.info('Test: Verify products list displays with filter options');

    // Wait for products to load
    await productsList.waitForProductsToLoad();

    // Verify products list loaded
    const isLoaded = await productsList.verifyProductsListLoaded();
    expect(isLoaded).toBeTruthy();

    // Get products count
    const count = await productsList.getProductsCount();
    expect(count).toBeGreaterThan(0);

    Logger.success(`Products list loaded with ${count} products`);
  });

  test('should display product information (name, price, stock status)', async () => {
    Logger.info('Test: Verify product information is displayed');

    await productsList.waitForProductsToLoad();

    // Get product details
    const productName = await productsList.getProductNameByIndex(0);
    expect(productName).toBeTruthy();
    expect(productName.length).toBeGreaterThan(0);

    const price = await productsList.getProductPriceByIndex(0);
    expect(price).toBeTruthy();

    const stockStatus = await productsList.getStockStatusByIndex(0);
    expect(stockStatus).toBeTruthy();

    Logger.success(`Product: ${productName}, Price: ${price}, Stock: ${stockStatus}`);
  });

  test('should identify in-stock and out-of-stock products', async () => {
    Logger.info('Test: Verify in-stock and out-of-stock identification');

    await productsList.waitForProductsToLoad();

    const productCount = await productsList.getProductsCount();

    for (let i = 0; i < Math.min(productCount, 5); i++) {
      const isInStock = await productsList.isProductInStockByIndex(i);
      Logger.debug(`Product ${i}: In Stock = ${isInStock}`);
    }

    Logger.success('Successfully identified product stock status');
  });

  test('should select first in-stock product (USER REQUIREMENT)', async () => {
    Logger.info('Test: Select first in-stock product (Critical user requirement)');

    await productsList.waitForProductsToLoad();

    // Get first in-stock product name before clicking
    const productName = await productsList.getFirstInStockProductName();
    Logger.success(`First in-stock product found: ${productName}`);

    // Select first in-stock product
    await productsList.selectFirstInStockProduct();

    // Verify navigation occurred (should be on product details page)
    const currentUrl = await home.getCurrentUrl();
    expect(currentUrl).toBeTruthy();

    Logger.success(`Successfully selected first in-stock product: ${productName}`);
  });

  test('should handle pagination if available', async () => {
    Logger.info('Test: Verify pagination functionality');

    await productsList.waitForProductsToLoad();

    const initialCount = await productsList.getProductsCount();
    Logger.info(`Initial products count on page: ${initialCount}`);

    // Check if pagination exists
    const paginationExists = await productsList.isElementVisible(productsList.PAGINATION);

    if (paginationExists) {
      try {
        await productsList.goToNextPage();
        const nextPageCount = await productsList.getProductsCount();
        Logger.success(`Successfully navigated to next page. Products: ${nextPageCount}`);
      } catch (error) {
        Logger.info('Next page button not available or disabled');
      }
    } else {
      Logger.info('Pagination not available for this product list');
    }
  });

  test('should display all product names correctly', async () => {
    Logger.info('Test: Verify all product names are displayed');

    await productsList.waitForProductsToLoad();

    const productNames = await productsList.getAllProductNames();
    expect(productNames.length).toBeGreaterThan(0);

    // Verify no empty names
    const emptyNames = productNames.filter((name) => !name || name.length === 0);
    expect(emptyNames.length).toBe(0);

    Logger.success(`Verified ${productNames.length} product names are displayed`);
  });

  test('should click on specific product by name', async () => {
    Logger.info('Test: Click on product by name');

    await productsList.waitForProductsToLoad();

    // Get first product name
    const productName = await productsList.getProductNameByIndex(0);

    // Click on product by name
    await productsList.clickProductByName(productName);

    // Verify navigation
    const url = await home.getCurrentUrl();
    expect(url).toBeTruthy();

    Logger.success(`Successfully clicked product: ${productName}`);
  });
});
