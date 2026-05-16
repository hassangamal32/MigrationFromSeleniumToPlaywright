import * as XLSX from 'xlsx';
import * as fs from 'fs';
import * as path from 'path';

/**
 * Excel Reader Utility
 * Handles reading data from Excel files (.xlsx, .xls)
 */
export class ExcelReader {
  /**
   * Read Excel file and return all sheets data
   */
  static readExcelFile(filePath: string): Record<string, any[][]> {
    if (!fs.existsSync(filePath)) {
      throw new Error(`File not found: ${filePath}`);
    }

    const workbook = XLSX.readFile(filePath);
    const result: Record<string, any[][]> = {};

    workbook.SheetNames.forEach((sheetName) => {
      const worksheet = workbook.Sheets[sheetName];
      const data = XLSX.utils.sheet_to_json(worksheet, { header: 1 });
      result[sheetName] = data;
    });

    return result;
  }

  /**
   * Read specific sheet from Excel file
   */
  static readSheet(filePath: string, sheetName: string): any[][] {
    if (!fs.existsSync(filePath)) {
      throw new Error(`File not found: ${filePath}`);
    }

    const workbook = XLSX.readFile(filePath);
    const worksheet = workbook.Sheets[sheetName];

    if (!worksheet) {
      throw new Error(`Sheet "${sheetName}" not found in ${filePath}`);
    }

    return XLSX.utils.sheet_to_json(worksheet, { header: 1 });
  }

  /**
   * Read Excel data as objects (with headers)
   */
  static readSheetAsObjects(filePath: string, sheetName: string): Record<string, any>[] {
    if (!fs.existsSync(filePath)) {
      throw new Error(`File not found: ${filePath}`);
    }

    const workbook = XLSX.readFile(filePath);
    const worksheet = workbook.Sheets[sheetName];

    if (!worksheet) {
      throw new Error(`Sheet "${sheetName}" not found in ${filePath}`);
    }

    return XLSX.utils.sheet_to_json(worksheet);
  }

  /**
   * Get sheet names from Excel file
   */
  static getSheetNames(filePath: string): string[] {
    if (!fs.existsSync(filePath)) {
      throw new Error(`File not found: ${filePath}`);
    }

    const workbook = XLSX.readFile(filePath);
    return workbook.SheetNames;
  }

  /**
   * Get specific cell value
   */
  static getCellValue(filePath: string, sheetName: string, cellAddress: string): any {
    const data = this.readSheet(filePath, sheetName);
    const workbook = XLSX.readFile(filePath);
    const worksheet = workbook.Sheets[sheetName];
    return worksheet[cellAddress]?.v || null;
  }
}
