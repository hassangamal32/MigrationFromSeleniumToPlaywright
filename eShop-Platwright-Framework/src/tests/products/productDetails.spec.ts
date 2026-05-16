import { test, expect } from '../../fixtures/test.js';
import { Home } from '../../pages/home.js';
import { ProductDetails } from '../../pages/productDetails.js';
import { ProductsList } from '../../pages/productsList.js';
import { environmentManager } from '../../config/environment.js';
import { Logger } from '../../utils/logger.js';

test.describe('Product Details Tests', () => {
  let home: Home;
  let productDetails: ProductDetails;
  let productsList: ProductsList;

  test.beforeEach(async ({ page }) => {
    home = new Home(page);
    productDetails = new ProductDetails(page);
    productsList = new ProductsList(page);
    const baseUrl = environmentManager.getBaseUrl();
    Logger.info(`Navigating to: ${baseUrl}`);
    await home.navigateTo(baseUrl);

    // Search and navigate to products
    await home.searchForProduct('plans');
    await productsList.waitForProductsToLoad();

    // Click on first product to view details
    await productsList.clickFirstProduct();
    await productDetails.verifyProductDetailsLoaded();
  });

  test('should display product details page with all information', async () => {
    Logger.info('Test: Verify product details page loads with complete information');

    // Verify page loaded
    const isLoaded = await productDetails.verifyProductDetailsLoaded();
    expect(isLoaded).toBeTruthy();

    // Get product information
    const productName = await productDetails.getProductName();
    expect(productName).toBeTruthy();
    expect(productName.length).toBeGreaterThan(0);

    const price = await productDetails.getProductPrice();
    expect(price).toBeTruthy();

    const description = await productDetails.getProductDescription();
    expect(description).toBeTruthy();

    Logger.success(`Product Details: ${productName} - ${price}`);
  });

  test('should display product stock status', async () => {
    Logger.info('Test: Verify product stock status is displayed');

    const isInStock = await productDetails.isProductInStock();
    const stockStatus = await productDetails.getStockStatusText();
    expect(stockStatus).toBeTruthy();

    Logger.success(`Stock Status: ${stockStatus} (In Stock: ${isInStock})`);
  });

  test('should allow quantity adjustment', async () => {
    Logger.info('Test: Verify quantity can be adjusted');

    // Get initial quantity
    const initialQty = await productDetails.getQuantity();
    Logger.info(`Initial quantity: ${initialQty}`);

    // Increase quantity
    await productDetails.increaseQuantity();
    const increasedQty = await productDetails.getQuantity();
    expect(increasedQty).toBe(initialQty + 1);

    // Set quantity to specific value
    await productDetails.setQuantity(5);
    const finalQty = await productDetails.getQuantity();
    expect(finalQty).toBe(5);

    Logger.success(`Quantity adjustment verified. Final quantity: ${finalQty}`);
  });

  test('should add product to cart', async () => {
    Logger.info('Test: Add product to cart');

    // Verify add to cart button is enabled
    const isEnabled = await productDetails.verifyAddToCartEnabled();
    expect(isEnabled).toBeTruthy();

    // Get product name for verification
    const productName = await productDetails.getProductName();

    // Add to cart
    await productDetails.addToCart();

    // Wait for confirmation (toast notification or cart update)
    await home.wait(1000);

    Logger.success(`Product added to cart: ${productName}`);
  });

  test('should display product images', async () => {
    Logger.info('Test: Verify product images are displayed');

    // Get image count
    const imageCount = await productDetails.getImageCount();
    expect(imageCount).toBeGreaterThan(0);

    // Get main image source
    const imageSource = await productDetails.getMainImageSource();
    expect(imageSource).toBeTruthy();

    Logger.success(`Product has ${imageCount} images. Main image: ${imageSource}`);
  });

  test('should display product specifications', async () => {
    Logger.info('Test: Verify product specifications are displayed');

    const specs = await productDetails.getSpecifications();
    if (specs && specs.length > 0) {
      Logger.success(`Product specifications: ${specs.substring(0, 100)}...`);
    } else {
      Logger.info('No specifications available for this product');
    }
  });

  test('should display product rating if available', async () => {
    Logger.info('Test: Verify product rating');

    try {
      const rating = await productDetails.getProductRating();
      if (rating && rating.length > 0) {
        Logger.success(`Product rating: ${rating}`);
      } else {
        Logger.info('No rating available for this product');
      }
    } catch (error) {
      Logger.info('Rating section not available');
    }
  });
});
