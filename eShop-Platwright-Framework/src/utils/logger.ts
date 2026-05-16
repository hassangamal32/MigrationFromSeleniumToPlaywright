/**
 * Logger Utility
 * Simple logging utility for tests
 */

export enum LogLevel {
  INFO = 'INFO',
  WARN = 'WARN',
  ERROR = 'ERROR',
  DEBUG = 'DEBUG',
  SUCCESS = 'SUCCESS',
}

export class Logger {
  private static readonly timestamp = (): string => {
    return new Date().toISOString();
  };

  private static readonly formatMessage = (level: LogLevel, message: string): string => {
    return `[${Logger.timestamp()}] [${level}] ${message}`;
  };

  static info(message: string): void {
    console.log(Logger.formatMessage(LogLevel.INFO, message));
  }

  static warn(message: string): void {
    console.warn(Logger.formatMessage(LogLevel.WARN, message));
  }

  static error(message: string): void {
    console.error(Logger.formatMessage(LogLevel.ERROR, message));
  }

  static debug(message: string): void {
    if (process.env.DEBUG) {
      console.debug(Logger.formatMessage(LogLevel.DEBUG, message));
    }
  }

  static success(message: string): void {
    console.log(Logger.formatMessage(LogLevel.SUCCESS, message));
  }

  static table(data: any): void {
    console.table(data);
  }
}
