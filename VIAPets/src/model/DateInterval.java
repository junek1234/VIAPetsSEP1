package model;

import java.io.Serializable;

/**
 * The DateInterval class represents an interval between two dates (startDate and endDate).
 * It provides methods to get, set, and compare date intervals.
 * This class implements the Serializable interface for object serialization.
 *
 * @author Felipe Figueiredo
 * @author Cristina Aurelia Matei
 * @version 1.0
 */
public class DateInterval implements Serializable {
  private Date startDate;
  private Date endDate;

  /**
   * Constructs a DateInterval object with the specified start and end dates.
   *
   * @param startDate the start date of the interval
   * @param endDate the end date of the interval
   */
  public DateInterval(Date startDate, Date endDate) {
    this.startDate = startDate.copy();
    this.endDate = endDate.copy();
  }

  /**
   * Compares this DateInterval object to another object for equality.
   *
   * @param obj the object to compare this DateInterval to
   * @return true if the given object is equal to this DateInterval, false otherwise
   */
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
    DateInterval other = (DateInterval) obj;
    return startDate.equals(other.startDate) && endDate.equals(other.endDate);
  }

  /**
   * Gets the start date of the interval.
   *
   * @return the start date of the interval
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * Gets the end date of the interval.
   *
   * @return the end date of the interval
   */
  public Date getEndDate() {
    return endDate;
  }

  /**
   * Sets the start date of the interval.
   *
   * @param startDate the new start date for the interval
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  /**
   * Sets the end date of the interval.
   *
   * @param endDate the new end date for the interval
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  /**
   * Checks if a given date is between the start and end dates of the interval.
   *
   * @param date the date to check
   * @return true if the date is between the start and end dates (inclusive), false otherwise
   */
  public boolean isBetween(Date date) {
    return (!startDate.isGreaterThan(date)) && !date.isGreaterThan(endDate);
  }

  /**
   * Creates a copy of this DateInterval object.
   *
   * @return a new DateInterval object that is a copy of this DateInterval
   */
  public DateInterval getDateInterval() {
    return new DateInterval(startDate, endDate);
  }

  /**
   * Returns a string representation of the DateInterval in the format:
   *
   * @return a string representation of the DateInterval
   */
  public String toString() {
    return "DateInterval{" + "startDate=" + startDate + ", endDate=" + endDate + '}';
  }
}
