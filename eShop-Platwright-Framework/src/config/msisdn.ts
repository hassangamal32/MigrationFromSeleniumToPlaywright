/**
 * Test Data Configuration - MSISDN (Phone Numbers)
 * 
 * NOTE: These are placeholder values. Replace with actual valid test data
 * from the Selenium framework's configuration files.
 */

export const MSISDN_CONFIG = {
  // Production Environment
  PROD: {
    VALID_MSISDN: '201012345678',
    INVALID_MSISDN: '201099999999',
    PREPAID_MSISDN: '201098765432',
    POSTPAID_MSISDN: '201055555555',
  },
  
  // Staging Environment
  STAGING: {
    VALID_MSISDN: '201087654321',
    INVALID_MSISDN: '201077777777',
    PREPAID_MSISDN: '201066666666',
    POSTPAID_MSISDN: '201044444444',
  },
};

export const TEST_DATA = {
  // Common test credentials
  EMAIL: 'test@vodafone.com.eg',
  INVALID_EMAIL: 'invalid@example.com',
  PASSWORD: 'TestPassword123!',
  
  // Product test data
  SEARCH_KEYWORDS: ['flex', 'plans', 'red', 'phone'],
  
  // Address data
  ADDRESS: {
    firstName: 'Test',
    lastName: 'User',
    street: '123 Test Street',
    city: 'Cairo',
    postalCode: '12345',
    phoneNumber: '201012345678',
  },
};
