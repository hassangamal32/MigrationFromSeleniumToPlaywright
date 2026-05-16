# Implementation Guide - eShop Playwright Framework

## 📋 Quick Start Checklist

Follow these steps to get the Playwright framework up and running.

---

## Step 1: Install Dependencies

```bash
cd eShop-Platwright-Framework
npm install
```

**Expected Output:**
```
added XXX packages in X.Xs
```

**Verify installation:**
```bash
npm list @playwright/test
```

Should show version 1.40.1 or higher.

---

## Step 2: Verify Environment Setup

```bash
# Check Node.js version (should be 16+)
node --version

# Check npm version (should be 8+)
npm --version

# Verify Playwright is installed
npx playwright --version
```

---

## Step 3: Install Browsers

```bash
# Install Playwright browsers (required for first run)
npx playwright install chromium
```

**Optional:** Install additional browsers for Phase 2
```bash
npx playwright install firefox
npx playwright install webkit
```

---

## Step 4: TypeScript Compilation Check

```bash
# Check that TypeScript compiles without errors
npm run type-check
```

**Expected:** No errors (clean compilation)

---

## Step 5: Linting Check

```bash
# Check code quality
npm run lint
```

**Expected:** No ESLint errors

---

## Step 6: Run First Test

```bash
# Run all tests in headed mode
npm test
```

**What happens:**
1. Browser window opens automatically
2. Tests execute in visible browser
3. You can see automation happening in real-time
4. Videos record to `test-results/videos/`
5. Screenshots saved for failures
6. Allure data collected in `allure-results/`
7. After completion → **HTML Report auto-opens in browser**

**Expected duration:** 5-10 minutes for all 39 tests

---

## Step 7: Review Test Results

### Playwright HTML Report (Auto-opens)
- Shows all test results
- Videos embedded for each test
- Screenshots for failures
- Test duration
- Pass/fail status

### View Reports Manually

```bash
# Open last Playwright HTML report
npm run report

# Generate and open Allure report
npm run allure:report
```

---

## Step 8: Run Specific Tests

```bash
# Run only home page tests
npx playwright test src/tests/home/home.spec.ts

# Run tests matching pattern
npx playwright test -g "home page"

# Run specific test file with verbose output
npx playwright test src/tests/filter/filter.spec.ts --verbose

# Run in debug mode
npx playwright test src/tests/home/home.spec.ts --debug
```

---

## Step 9: Configure Environment

### For Production Testing

```bash
# Use production environment
export ENVIRONMENT=Production
npm test
```

Or update `.env` file:
```
ENVIRONMENT=Production
PROD_BASE_URL=https://eshop.vodafone.com.eg/en/
```

### For Staging Testing

```bash
# Use staging environment
export ENVIRONMENT=Staging
npm test
```

Or update `.env.staging` and load it:
```bash
export $(cat .env.staging | xargs)
npm test
```

---

## Step 10: Update Test Data

**CRITICAL:** Update actual test data before running against production

Edit `src/config/msisdn.ts`:

```typescript
// ❌ PLACEHOLDER - Update with real data
PROD: {
  VALID_MSISDN: '201012345678',      // ← Replace with real MSISDN
  // ... other fields
}
```

Edit `src/config/browser.ts`:

```typescript
DEFAULT_TIMEOUT: 60000,               // ← Adjust if needed
ELEMENT_TIMEOUT: 10000,              // ← Adjust if needed
```

---

## Critical Feature: Select First In-Stock Product

This is the **user requirement** that has been implemented.

**Test file:** `src/tests/filter/filter.spec.ts`  
**Test method:** `should select first in-stock product`  
**POM method:** `ProductsList.selectFirstInStockProduct()`

**How it works:**
```typescript
// In test
await productsList.selectFirstInStockProduct();

// In POM class
async selectFirstInStockProduct(): Promise<void> {
  const productsCount = await this.getProductsCount();
  
  for (let i = 0; i < productsCount; i++) {
    const isInStock = await this.isProductInStockByIndex(i);
    if (isInStock) {
      await this.clickProductByIndex(i);
      return;
    }
  }
  
  throw new Error('No in-stock products found on this page');
}
```

**Verify:** Run filter tests to confirm this works with your app
```bash
npx playwright test src/tests/filter/filter.spec.ts -g "first in-stock"
```

---

## Configuration Options

### Headed Mode (Default: ON)

```
// In playwright.config.ts
headless: false,  // ✅ Always runs in headed mode
```

To temporarily disable:
```bash
npx playwright test --headed=false
```

### Video Recording (Default: ON)

```
// In playwright.config.ts
recordVideo: {
  dir: 'test-results/videos',
}
```

Videos saved to `test-results/videos/` automatically.

### Screenshots on Failure (Default: ON)

```
// In playwright.config.ts
screenshot: 'only-on-failure',
```

Screenshots saved to `test-results/screenshots/` for failed tests.

### HTML Report Auto-Open (Default: ON)

```
// In playwright.config.ts
reporter: [
  ['html', { outputFolder: 'playwright-report', open: 'always' }],
]
```

Report auto-opens in default browser after tests complete.

---

## Troubleshooting

### Issue: Tests not finding elements

**Cause:** Selectors in POM classes are placeholders

**Solution:** Update selectors in `src/pages/*.ts` to match your application
```typescript
// Example: Update Home page selectors
readonly SEARCH_INPUT = 'input[placeholder="Search"]'; // ← Verify this matches your app
```

**How to find correct selectors:**
1. Open app in browser
2. Right-click on element → Inspect
3. Copy selector (Chrome DevTools provides suggestions)
4. Update POM class selector

### Issue: Tests timeout

**Cause:** Elements take longer to appear/load

**Solution:** Increase timeouts in `src/config/browser.ts`
```typescript
DEFAULT_TIMEOUT: 120000,  // Increase from 60000
ELEMENT_TIMEOUT: 20000,   // Increase from 10000
```

### Issue: Video/Screenshot storage fills up

**Cause:** Too many test runs create large files

**Solution:** 
```bash
# Clean up old results
rm -rf test-results
rm -rf allure-results

# Run tests again
npm test
```

### Issue: Port already in use

**Cause:** Another process using port 3000

**Solution:**
```bash
# Kill process on port 3000 (Windows)
netstat -ano | findstr :3000
taskkill /PID <PID> /F

# Or use different port in config
```

### Issue: Browser not found

**Cause:** Playwright browsers not installed

**Solution:**
```bash
# Install missing browser
npx playwright install chromium
```

---

## Next: Update Selectors & Test Data

### 1. Update POM Selectors

For each test failure related to selectors:
1. Identify the element in your app
2. Get the correct CSS selector or XPath
3. Update corresponding selector in `src/pages/`

**Example:** If home page search input has different selector:
```typescript
// src/pages/home.ts
readonly SEARCH_INPUT = 'input.search-field'; // ← Update this
```

### 2. Update Test Data

Edit `src/config/msisdn.ts` with real test data:
```typescript
PROD: {
  VALID_MSISDN: '201012345678',        // Real MSISDN
  PREPAID_MSISDN: '201098765432',      // Real prepaid
}
```

### 3. Verify URLs

Check `.env` files have correct URLs:
```
PROD_BASE_URL=https://eshop.vodafone.com.eg/en/
STAGING_BASE_URL=https://staging.eshop.vodafone.com.eg/en/
```

---

## Running Full Test Suite

### Sequential Execution (Default)

```bash
# Run all tests one by one
npm test
```

**Features:**
- ✅ Headed mode (visible browser)
- ✅ Video recording
- ✅ Screenshots on failure
- ✅ HTML report auto-open
- ✅ Allure data collection

### Debug Mode

```bash
# Interactive debugging with Playwright Inspector
npm run test:debug
```

**Features:**
- Step through tests
- Inspect elements
- Run specific commands
- Perfect for troubleshooting

### UI Mode (Experimental)

```bash
# Interactive UI with test exploration
npm run test:ui
```

**Features:**
- Visual test explorer
- Step through UI
- See locators
- Test runner dashboard

---

## Performance Notes

### Expected Test Duration

- Home tests: ~2 minutes
- Search tests: ~2-3 minutes
- Filter tests: ~3-4 minutes
- Product details: ~2-3 minutes
- Cart tests: ~3-4 minutes
- Checkout tests: ~2-3 minutes

**Total:** ~15-20 minutes for all 39 tests

### Resource Usage

- **Disk Space:** ~500MB for videos + reports per run
- **Memory:** 300-500MB during test execution
- **Network:** 50-100MB (depends on app data)

---

## Verification Checklist

Before proceeding to Phase 2, verify:

- [ ] `npm install` completes successfully
- [ ] `npx playwright --version` shows version
- [ ] `npm run type-check` passes
- [ ] `npm run lint` shows no errors
- [ ] `npm test` runs all 39 tests
- [ ] HTML report auto-opens
- [ ] Videos created in `test-results/videos/`
- [ ] Screenshots captured for any failures
- [ ] All 6 test files execute without errors
- [ ] Allure data generated in `allure-results/`

---

## What's Ready for Phase 2

After verification, you can proceed to Phase 2:

### Phase 2 Deliverables (17 remaining POM classes)
```
- PaymentDetails.ts
- PaymentContent.ts
- MyOrders.ts
- OrderDetails.ts
- Vouchers.ts
- FlexLines.ts
- FlexLinesPlans.ts
- FlexLinesSummary.ts
- RedLines.ts
- RedLinesPlans.ts
- RedLinesSummary.ts
- Dsl.ts
- Mnp.ts
- AtHomeBundle.ts
- AtHomeRouter.ts
- AtHomeSubscriptionDetails.ts
- Filter.ts (if separate from ProductsList)
```

### Phase 2 Tests
- Login & Authentication (~5-8 tests)
- Profile Management (~5-7 tests)
- Service Plans (Flex/Red/DSL) (~8-12 tests)
- Payment Processing (~6-10 tests)
- Order Management (~5-8 tests)

---

## Commands Reference

| Command | Purpose |
|---------|---------|
| `npm test` | Run all tests |
| `npm run test:headed` | Run in headed mode (explicit) |
| `npm run test:debug` | Debug with inspector |
| `npm run test:ui` | UI mode |
| `npm run report` | Open HTML report |
| `npm run report:allure` | Generate & open Allure |
| `npm run lint` | Check code quality |
| `npm run lint:fix` | Fix linting issues |
| `npm run type-check` | TypeScript compilation check |

---

## Support

### Documentation Files

- **README.md** - Comprehensive project documentation
- **MIGRATION_NOTES.md** - Detailed migration mapping
- **playwright.config.ts** - Commented configuration file
- **src/fixtures/basePage.ts** - 113 base methods with JSDoc comments

### Code Examples

Find examples in:
- `src/tests/**/*.spec.ts` - Test structure examples
- `src/pages/*.ts` - POM class examples
- `src/utils/*.ts` - Utility function examples

---

## Ready to Start? ✨

```bash
# 1. Install dependencies
npm install

# 2. Run first test
npm test

# 3. Watch browser automation in real-time
# 4. View HTML report (auto-opens)
# 5. Check videos in test-results/videos/
```

**Good luck! 🚀**

---

**Questions?** Refer to:
- playwright.dev - Official documentation
- README.md - Project setup
- MIGRATION_NOTES.md - Selenium→Playwright mapping
