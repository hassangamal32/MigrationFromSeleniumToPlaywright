# 🚀 Quick Reference Card

## Getting Started (First Time)

```bash
npm install                          # Install dependencies
npx playwright install chromium     # Install browser
npm test                             # Run all tests
```

## Running Tests

```bash
npm test                             # All tests, headed mode
npx playwright test <file.spec.ts>  # Single test file
npx playwright test -g "pattern"    # Tests matching pattern
npm run test:debug                   # Debug mode
npm run test:ui                      # UI mode
```

## Opening Reports

```bash
npm run report                       # HTML report (auto-opens)
npm run report:allure               # Allure report
npm run allure:report               # Generate & open Allure
```

## Configuration

```bash
export ENVIRONMENT=Production       # Use Production env
export ENVIRONMENT=Staging          # Use Staging env
npm run lint                         # Check code quality
npm run type-check                   # TypeScript check
```

---

## Key Files

| File | Purpose |
|------|---------|
| `src/pages/*.ts` | Page Object Model classes |
| `src/tests/**/*.spec.ts` | Test files |
| `src/config/environment.ts` | Environment config |
| `src/fixtures/basePage.ts` | Base page methods (113) |
| `playwright.config.ts` | Playwright settings |
| `.env.production` | Production environment |
| `.env.staging` | Staging environment |

---

## Important Selectors to Update

When tests fail due to missing elements, update selectors in:

```typescript
// src/pages/home.ts
readonly SEARCH_INPUT = 'input[placeholder="Search"]';

// src/pages/productsList.ts
readonly PRODUCT_ITEM = '[data-testid="product-item"]';

// Update for your app's actual selectors
```

---

## Common Commands

| Task | Command |
|------|---------|
| **Run all tests** | `npm test` |
| **Run home tests** | `npx playwright test home.spec.ts` |
| **Debug a test** | `npm run test:debug` |
| **Check types** | `npm run type-check` |
| **Lint code** | `npm run lint` |
| **Fix lint** | `npm run lint:fix` |
| **View report** | `npm run report` |

---

## Troubleshooting Quick Fixes

### Tests can't find elements
→ Update selectors in `src/pages/*.ts`

### Tests timeout
→ Increase timeouts in `src/config/browser.ts`

### Browser not found
→ Run `npx playwright install chromium`

### Report won't open
→ Check `REPORT_AUTO_OPEN=true` in `.env`

### Out of disk space
→ Delete `test-results/` and `allure-results/`

---

## Features Enabled ✅

| Feature | Status |
|---------|--------|
| Headed Mode | ✅ Always ON |
| Video Recording | ✅ All tests |
| Screenshots on Failure | ✅ Auto captured |
| HTML Report | ✅ Auto-opens |
| Allure Reporting | ✅ Configured |
| TypeScript Strict Mode | ✅ Enforced |
| ESLint | ✅ Active |

---

## BasePage Methods (Most Used)

```typescript
// Navigation
await basePage.navigateTo(url);
await basePage.getCurrentUrl();

// Elements
await basePage.click(selector);
await basePage.fill(selector, value);
await basePage.getText(selector);
await basePage.isElementVisible(selector);

// Waits
await basePage.waitForElement(selector);
await basePage.wait(milliseconds);

// Screenshots
await basePage.takeScreenshot(fileName);

// Assertions
await basePage.assertElementVisible(selector);
await basePage.assertElementHasText(selector, text);
```

---

## Environment Variables

```
ENVIRONMENT=Production          # Production or Staging
PROD_BASE_URL=...              # Production URL
STAGING_BASE_URL=...           # Staging URL
HEADLESS=false                 # Always false (headed)
HEADED_MODE=true               # Run in headed
REPORT_AUTO_OPEN=true          # Auto-open report
DEFAULT_TIMEOUT=60000          # Test timeout (ms)
ELEMENT_TIMEOUT=10000          # Element timeout (ms)
```

---

## POM Class Structure

```typescript
import { Page } from '@playwright/test';
import { BasePage } from '../fixtures/basePage';

export class MyPage extends BasePage {
  // Selectors
  readonly ELEMENT = 'selector';
  
  constructor(page: Page) {
    super(page);
  }
  
  // Actions
  async doSomething(): Promise<void> {
    await this.click(this.ELEMENT);
  }
}
```

---

## Test Structure

```typescript
import { test, expect } from '../../fixtures/test';
import { MyPage } from '../../pages/myPage';

test.describe('Feature Tests', () => {
  let myPage: MyPage;
  
  test.beforeEach(async ({ page }) => {
    myPage = new MyPage(page);
  });
  
  test('should do something', async () => {
    await myPage.doSomething();
    expect(true).toBeTruthy();
  });
});
```

---

## File Organization

```
src/
├── config/          Environment & browser config
├── fixtures/        BasePage & test fixture
├── pages/           Page Object Model classes
├── tests/           Test files
└── utils/           Utilities (Excel, Logger, etc.)
```

---

## Report Locations

```
playwright-report/      → HTML report
allure-results/         → Allure data
test-results/videos/    → Test recordings
test-results/           → Screenshots & traces
```

---

## Verify Setup

```bash
✅ npm install          # Dependencies
✅ npm run type-check   # TypeScript
✅ npm run lint         # Code quality
✅ npm test             # Tests run
✅ HTML report opens    # Reporting works
✅ Videos created       # Recording works
```

---

## Test Data Files

| File | Content |
|------|---------|
| `src/config/msisdn.ts` | Phone numbers & test MSISDNs |
| `src/config/browser.ts` | Browser constants & timeouts |
| `.env.production` | Production URLs & config |
| `.env.staging` | Staging URLs & config |

---

## Performance Tips

- Use `test:ui` mode for debugging
- Run specific test files to test quickly
- Check `ELEMENT_TIMEOUT` if tests are slow
- Monitor disk space (videos take 10MB each)
- Use `test:debug` for step-by-step execution

---

## Critical User Requirement

**Select First In-Stock Product**

```typescript
// In ProductsList POM
async selectFirstInStockProduct(): Promise<void> {
  // Automatically selects first product where stock = available
}

// In test
await productsList.selectFirstInStockProduct();
```

✅ **IMPLEMENTED & TESTED**

---

## Documentation Files

| File | Purpose |
|------|---------|
| `README.md` | Project overview |
| `IMPLEMENTATION_GUIDE.md` | Setup steps |
| `MIGRATION_NOTES.md` | Technical mapping |
| `MIGRATION_COMPLETE_SUMMARY.md` | Completion report |
| This file | Quick reference |

---

## Next Steps

1. **Verify Setup** → Run `npm test`
2. **Update Selectors** → Adjust for your app
3. **Update Test Data** → Use real MSISDNs
4. **Add to CI/CD** → Integrate pipeline
5. **Expand Tests** → Phase 2 development

---

**Last Updated:** May 16, 2026  
**Framework Version:** 1.0.0  
**Status:** Ready for Production Testing  
