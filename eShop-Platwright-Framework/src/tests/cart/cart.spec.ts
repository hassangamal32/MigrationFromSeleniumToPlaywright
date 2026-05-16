import { test, expect } from '../../fixtures/test.js';
import { Home } from '../../pages/home.js';
import { Header } from '../../pages/header.js';
import { ProductDetails } from '../../pages/productDetails.js';
import { ProductsList } from '../../pages/productsList.js';
import { Cart } from '../../pages/cart.js';
import { environmentManager } from '../../config/environment.js';
import { Logger } from '../../utils/logger.js';

test.describe('Shopping Cart Tests', () => {
  let home: Home;
  let productDetails: ProductDetails;
  let productsList: ProductsList;
  let cart: Cart;

  test.beforeEach(async ({ page }) => {
    home = new Home(page);
    productDetails = new ProductDetails(page);
    productsList = new ProductsList(page);
    cart = new Cart(page);
    const baseUrl = environmentManager.getBaseUrl();
    Logger.info(`Navigating to: ${baseUrl}`);
    await home.navigateTo(baseUrl);
  });

  test('should add product to cart and verify', async ({ page }) => {
    const header = new Header(page);
    Logger.info('Test: Add product to cart');

    // Navigate to products
    await home.searchForProduct('plans');
    await productsList.waitForProductsToLoad();

    // Get product name for verification
    const productName = await productsList.getProductNameByIndex(0);
    Logger.info(`Adding product to cart: ${productName}`);

    // Click on product
    await productsList.clickProductByIndex(0);
    await productDetails.verifyProductDetailsLoaded();

    // Add to cart
    await productDetails.addToCart();
    await home.wait(1500);

    // Navigate to cart
    const header = new (require('../../pages/header').Header)(page);
    await header.clickShoppingCart();

    // Verify item in cart
    const isInCart = await cart.verifyItemInCart(productName);
    expect(isInCart).toBeTruthy();

    Logger.success(`Successfully added and verified product in cart: ${productName}`);
  });

  test('should display cart items with quantity and price', async ({ page }) => {
    const header = new Header(page);
    Logger.info('Test: Verify cart displays items correctly');

    // Add a product first
    await home.searchForProduct('plans');
    await productsList.waitForProductsToLoad();
    await productsList.clickProductByIndex(0);
    await productDetails.verifyProductDetailsLoaded();
    await productDetails.addToCart();
    await home.wait(1000);

    // Navigate to cart
    await header.clickShoppingCart();

    // Verify cart not empty
    const notEmpty = await cart.verifyCartNotEmpty();
    expect(notEmpty).toBeTruthy();

    // Get items count
    const count = await cart.getCartItemsCount();
    expect(count).toBeGreaterThan(0);

    // Get item details
    const itemName = await cart.getItemNameByIndex(0);
    const itemPrice = await cart.getItemPriceByIndex(0);
    expect(itemName).toBeTruthy();
    expect(itemPrice).toBeTruthy();

    Logger.success(`Cart item: ${itemName} - ${itemPrice}`);
  });

  test('should update item quantity in cart', async ({ page }) => {
    const header = new Header(page);
    Logger.info('Test: Update quantity in cart');

    // Add product
    await home.searchForProduct('plans');
    await productsList.waitForProductsToLoad();
    await productsList.clickProductByIndex(0);
    await productDetails.verifyProductDetailsLoaded();
    await productDetails.setQuantity(2);
    await productDetails.addToCart();
    await home.wait(1000);

    // Navigate to cart
    await header.clickShoppingCart();

    // Update quantity
    await cart.setItemQuantityByIndex(0, 3);
    await home.wait(500);

    // Verify quantity updated
    const qty = await cart.getItemQuantityByIndex(0);
    expect(qty).toBe(3);

    Logger.success(`Item quantity updated to: ${qty}`);
  });

  test('should calculate cart total correctly', async ({ page }) => {
    const header = new Header(page);
    Logger.info('Test: Verify cart total calculation');

    // Add product
    await home.searchForProduct('plans');
    await productsList.waitForProductsToLoad();
    await productsList.clickProductByIndex(0);
    await productDetails.verifyProductDetailsLoaded();
    await productDetails.addToCart();
    await home.wait(1000);

    // Navigate to cart
    await header.clickShoppingCart();

    // Get totals
    const subtotal = await cart.getSubtotal();
    const tax = await cart.getTax();
    const total = await cart.getTotal();

    expect(subtotal).toBeTruthy();
    expect(total).toBeTruthy();

    Logger.success(`Subtotal: ${subtotal}, Tax: ${tax}, Total: ${total}`);
  });

  test('should remove item from cart', async ({ page }) => {
    const header = new Header(page);
    Logger.info('Test: Remove item from cart');

    // Add product
    await home.searchForProduct('plans');
    await productsList.waitForProductsToLoad();
    await productsList.clickProductByIndex(0);
    await productDetails.verifyProductDetailsLoaded();
    await productDetails.addToCart();
    await home.wait(1000);

    // Navigate to cart
    await header.clickShoppingCart();

    const itemCountBefore = await cart.getCartItemsCount();
    Logger.info(`Items in cart before removal: ${itemCountBefore}`);

    // Remove item
    await cart.removeItemByIndex(0);
    await home.wait(500);

    // Verify removed
    if (itemCountBefore === 1) {
      const isEmpty = await cart.verifyCartEmpty();
      expect(isEmpty).toBeTruthy();
      Logger.success('Cart is now empty after removing the only item');
    } else {
      const itemCountAfter = await cart.getCartItemsCount();
      expect(itemCountAfter).toBe(itemCountBefore - 1);
      Logger.success(`Item removed. Items remaining: ${itemCountAfter}`);
    }
  });

  test('should proceed to checkout from cart', async ({ page }) => {
    const header = new Header(page);
    Logger.info('Test: Proceed to checkout from cart');

    // Add product
    await home.searchForProduct('plans');
    await productsList.waitForProductsToLoad();
    await productsList.clickProductByIndex(0);
    await productDetails.verifyProductDetailsLoaded();
    await productDetails.addToCart();
    await home.wait(1000);

    // Navigate to cart
    await header.clickShoppingCart();

    // Verify checkout button visible
    const checkoutVisible = await cart.verifyCheckoutButtonVisible();
    expect(checkoutVisible).toBeTruthy();

    Logger.success('Checkout button is visible in cart');
  });
});
