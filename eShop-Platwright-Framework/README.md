# eShop Playwright Automation Framework

[![Playwright](https://img.shields.io/badge/Playwright-E40046?logo=Playwright&logoColor=white)](https://playwright.dev/)
[![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?logo=typescript&logoColor=white)](https://www.typescriptlang.org/)
[![Node.js](https://img.shields.io/badge/Node.js-339933?logo=Node.js&logoColor=white)](https://nodejs.org/)

Automated end-to-end testing framework for eShop Vodafone, migrated from Selenium to Playwright.

## 🚀 Features

- ✅ **Page Object Model (POM)** - 30 page classes for maintainable test code
- ✅ **TypeScript** - Strict type checking for reliability
- ✅ **Headed Mode** - All tests run in visible browser window
- ✅ **Video Recording** - All tests recorded for debugging
- ✅ **Screenshots on Failure** - Automatic screenshot capture
- ✅ **Playwright HTML Report** - Auto-opens after test run
- ✅ **Allure Reporting** - Advanced test metrics and reporting
- ✅ **Multi-Environment** - Production & Staging support
- ✅ **Parallel Execution Ready** - Framework supports concurrent test execution

## 📋 Prerequisites

- **Node.js** 16+ 
- **npm** 8+
- **Browsers** (installed via Playwright)

## 🛠️ Installation

1. **Clone and navigate to project:**
   ```bash
   cd eShop-Platwright-Framework
   ```

2. **Install dependencies:**
   ```bash
   npm install
   ```

3. **Verify Playwright installation:**
   ```bash
   npx playwright --version
   ```

## ⚙️ Configuration

### Environment Setup

Copy `.env.example` to `.env` and configure:

```bash
cp .env.example .env
```

**Environment variables:**
```
ENVIRONMENT=Production          # Production or Staging
PROD_BASE_URL=...              # Production URL
STAGING_BASE_URL=...           # Staging URL
HEADED_MODE=true               # Run in headed mode
REPORT_AUTO_OPEN=true          # Auto-open report after tests
```

**Switch environments:**
```bash
# Production
export ENVIRONMENT=Production

# Staging  
export ENVIRONMENT=Staging
```

## 🧪 Running Tests

### Run all tests (headed mode, video + screenshots enabled)
```bash
npm test
```

### Run in headed mode (visible browser)
```bash
npm run test:headed
```

### Run in debug mode
```bash
npm run test:debug
```

### Run with UI Mode
```bash
npm run test:ui
```

### Run specific test file
```bash
npx playwright test src/tests/home/home.spec.ts
```

### Run specific test by name pattern
```bash
npx playwright test -g "home page"
```

## 📊 Test Reports

### Playwright HTML Report
Automatically opens after test execution:
```bash
npm test
# Report opens automatically in browser
```

Manually open the last report:
```bash
npm run report
```

### Allure Report

Generate and open Allure report:
```bash
npm run allure:report
```

Or separately:
```bash
# Generate Allure report
npm run allure:generate

# Open Allure report
npm run report:allure
```

## 📁 Project Structure

```
eShop-Platwright-Framework/
├── src/
│   ├── config/               # Configuration & environment
│   │   ├── environment.ts    # Environment manager (Prod/Staging)
│   │   ├── browser.ts        # Browser configuration
│   │   └── msisdn.ts         # Test data (MSISDN configs)
│   │
│   ├── fixtures/             # Playwright fixtures
│   │   ├── basePage.ts       # Base page class (POM inheritance)
│   │   └── test.ts           # Custom test fixture
│   │
│   ├── pages/                # Page Object Model classes (30 pages)
│   │   ├── home.ts
│   │   ├── header.ts
│   │   ├── search.ts
│   │   ├── productsList.ts
│   │   ├── productDetails.ts
│   │   ├── cart.ts
│   │   ├── checkout.ts
│   │   └── ... (23 more pages)
│   │
│   ├── tests/                # Test specs organized by feature
│   │   ├── home/
│   │   │   └── home.spec.ts
│   │   ├── search/
│   │   │   └── search.spec.ts
│   │   ├── filter/
│   │   │   └── filter.spec.ts
│   │   ├── products/
│   │   │   └── productDetails.spec.ts
│   │   ├── cart/
│   │   │   └── cart.spec.ts
│   │   └── checkout/
│   │       └── checkout.spec.ts
│   │
│   └── utils/                # Utility functions
│       ├── excelReader.ts
│       ├── logger.ts
│       └── reportUtils.ts
│
├── playwright.config.ts      # Playwright configuration
├── tsconfig.json            # TypeScript configuration
├── .eslintrc.json           # ESLint rules
├── .prettierrc               # Code formatting
├── package.json             # Dependencies & scripts
├── .env.example             # Environment template
├── .env.production          # Production environment
├── .env.staging             # Staging environment
└── README.md                # This file
```

## 📝 Test Execution Flow

1. **Tests in headed mode** - Browser window visible during execution
2. **Video recording** - All tests recorded to `test-results/videos/`
3. **Screenshots on failure** - Captured to `test-results/screenshots/`
4. **Allure data** - Test metadata stored in `allure-results/`
5. **HTML Report** - Playwright report auto-opens with results
6. **Allure Report** - Historical metrics available via `npm run report:allure`

## 🔍 Page Object Model

All page classes extend `BasePage` with common functionality:

```typescript
// Example usage in tests
import { test } from '../fixtures/test';

test('should add product to cart', async ({ page, home, productDetails, cart }) => {
  await home.navigate();
  await home.searchForProduct('Flex Plans');
  await productDetails.addToCart();
  await cart.verifyCartNotEmpty();
});
```

**Base Page Methods:**
- `waitForElement(selector)` - Wait for element presence
- `click(selector)` - Click with retries
- `fill(selector, value)` - Fill input field
- `getElement(selector)` - Get element locator
- `takeScreenshot()` - Manual screenshot
- `getCurrentUrl()` - Get current URL
- `waitForNavigation()` - Wait for URL change

## 🐛 Debugging

### Debug mode with inspector
```bash
npm run test:debug
```

### UI Mode (interactive test debugger)
```bash
npm run test:ui
```

### Generate trace for failed tests
Traces are automatically generated for failed tests and can be viewed with:
```bash
npx playwright show-trace test-results/trace.zip
```

## ✅ Verification Checklist

After setup, verify:
- [ ] `npm install` completes without errors
- [ ] `npm run type-check` passes (TypeScript compilation)
- [ ] `npm run lint` shows no errors
- [ ] `npm test` executes (at least 1 test passes)
- [ ] Playwright HTML report auto-opens
- [ ] Videos created in `test-results/videos/`

## 🔧 Troubleshooting

### Port Already in Use
If port 3000 is already in use:
```bash
# Kill the process or use a different port
npm test -- --port 3001
```

### Browser Installation Issues
```bash
# Reinstall browsers
npx playwright install
```

### Report Not Opening
Set environment variable:
```bash
export REPORT_AUTO_OPEN=true
npm test
```

### Video Files Too Large
Videos are stored in `test-results/videos/`. To reduce space, configure retention in `playwright.config.ts`.

## 📚 Phases of Development

**✅ Phase 1: Project Setup** (Complete)
- Project structure, dependencies, configuration

**🔄 Phase 2: Core Framework** (In Progress)
- Base Page fixtures, Page Object Model classes (30 pages)

**⏳ Phase 3: Core Tests** (Upcoming)
- Test migration for 6-8 core features

**⏳ Phase 4: Reporting** (Upcoming)
- Report generation and auto-opening

**⏳ Phase 5: Documentation** (Upcoming)
- Final documentation and examples

## 🚀 Next Steps

1. Run `npm install` to install dependencies
2. Create `.env` file from `.env.example`
3. Start with Phase 2: Core Framework Architecture
4. Migrate Page Object classes from Selenium framework

## 📖 Resources

- [Playwright Documentation](https://playwright.dev)
- [Playwright Best Practices](https://playwright.dev/docs/best-practices)
- [Allure Report Integration](https://github.com/allure-framework/allure-playwright)

## 📄 License

ISC
