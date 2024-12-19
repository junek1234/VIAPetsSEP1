package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Date class represents a date with day, month, and year.
 * It provides methods to get, set, compare, and format dates.
 * This class implements the Serializable interface for object serialization.
 *
 * @author Felipe Figueiredo
 * @author Cristina Aurelia Matei
 * @version 1.0
 */
public class Date implements Serializable {
  private int day;
  private int month;
  private int year;

  /**
   * Constructs a Date object with the specified day, month, and year.
   *
   * @param day the day of the date
   * @param month the month of the date
   * @param year the year of the date
   */
  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * Gets the day of the date.
   *
   * @return the day of the date
   */
  public int getDay() {
    return day;
  }

  /**
   * Gets the month of the date.
   *
   * @return the month of the date
   */
  public int getMonth() {
    return month;
  }

  /**
   * Gets the year of the date.
   *
   * @return the year of the date
   */
  public int getYear() {
    return year;
  }

  /**
   * Sets the day of the date.
   *
   * @param day the new day value
   */
  public void setDay(int day) {
    this.day = day;
  }

  /**
   * Sets the month of the date.
   *
   * @param month the new month value
   */
  public void setMonth(int month) {
    this.month = month;
  }

  /**
   * Sets the year of the date.
   *
   * @param year the new year value
   */
  public void setYear(int year) {
    this.year = year;
  }

  /**
   * Converts the current Date object to a LocalDate object.
   *
   * @return a LocalDate representing the same date
   */
  public LocalDate toLocalDate() {
    return LocalDate.of(year, month, day);
  }

  /**
   * Formats the current Date object using the provided DateTimeFormatter.
   *
   * @param formatter the formatter used to format the date
   * @return a string representation of the date formatted according to the provided formatter
   */
  public String format(DateTimeFormatter formatter) {
    return toLocalDate().format(formatter);
  }

  /**
   * Formats the current Date object into a string representation.
   *
   * @return a string representation of the date in the format "day/month/year"
   */
  public String toString() {
    return String.format("%02d/%02d/%04d", day, month, year);
  }

  /**
   * Compares this Date object to another object for equality.
   *
   * @param obj the object to compare this Date to
   * @return true if the given object is equal to this Date, false otherwise
   */
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != this.getClass()) {
      return false;
    }
    Date other = (Date) obj;
    return day == other.day && month == other.month && year == other.year;
  }

  /**
   * Compares this Date object to another Date object to see if it is greater.
   *
   * @param obj the Date object to compare to
   * @return true if this Date is greater than the given Date, false otherwise
   */
  public boolean isGreaterThan(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return false;
    }
    if (obj.getClass() != this.getClass()) {
      return false;
    }
    Date other = (Date) obj;
    if (this.year > other.year) {
      return true;
    } else if (this.year == other.year) {
      if (this.month > other.month) {
        return true;
      } else if (this.month == other.month) {
        if (this.day > other.day) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Creates a copy of this Date object.
   *
   * @return a new Date object that is a copy of this Date
   */
  public Date copy() {
    return new Date(day, month, year);
  }
}
