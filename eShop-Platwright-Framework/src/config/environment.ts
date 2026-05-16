import dotenv from 'dotenv';
import path from 'path';

dotenv.config();

export type EnvironmentType = 'Production' | 'Staging';

interface EnvironmentConfig {
  baseUrl: string;
  apiUrl: string;
  testMsisdn: string;
  headlessMode: boolean;
}

class EnvironmentManager {
  private environment: EnvironmentType;
  private config: EnvironmentConfig;

  constructor() {
    this.environment = (process.env.ENVIRONMENT as EnvironmentType) || 'Production';
    this.config = this.loadConfig();
  }

  private loadConfig(): EnvironmentConfig {
    switch (this.environment) {
      case 'Staging':
        return {
          baseUrl: process.env.STAGING_BASE_URL || 'https://staging.eshop.vodafone.com.eg/en/',
          apiUrl: process.env.STAGING_API_URL || 'https://staging-api.vodafone.com.eg/',
          testMsisdn: process.env.STAGING_TEST_MSISDN || '201087654321',
          headlessMode: process.env.HEADLESS === 'true',
        };
      case 'Production':
      default:
        return {
          baseUrl: process.env.PROD_BASE_URL || 'https://eshop.vodafone.com.eg/en/',
          apiUrl: process.env.PROD_API_URL || 'https://api.vodafone.com.eg/',
          testMsisdn: process.env.PROD_TEST_MSISDN || '201012345678',
          headlessMode: process.env.HEADLESS === 'true',
        };
    }
  }

  getEnvironment(): EnvironmentType {
    return this.environment;
  }

  getBaseUrl(): string {
    return this.config.baseUrl;
  }

  getApiUrl(): string {
    return this.config.apiUrl;
  }

  getTestMsisdn(): string {
    return this.config.testMsisdn;
  }

  isHeadlessMode(): boolean {
    return this.config.headlessMode;
  }

  getConfig(): EnvironmentConfig {
    return this.config;
  }
}

export const environmentManager = new EnvironmentManager();
