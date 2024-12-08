package model;

import java.io.Serializable;

public class DateInterval implements Serializable
{
  private Date startDate;
  private Date endDate;

  public DateInterval(Date startDate, Date endDate)
  {
    this.startDate = startDate;
    this.endDate =endDate;
  }
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass())
    {
      return false;
    }
    DateInterval other = (DateInterval) obj;
    return startDate.equals(other.startDate) &&endDate.equals(other.endDate);
  }
  public Date getStartDate()
  {
    return startDate;
  }
  public Date getEndDate()
  {
    return endDate;
  }
  public void setStartDate(Date startDate)
  {
    this.startDate = startDate;
  }
  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
  }

 //check if this is correct - calculateInterval
  public int calculateInterval()
  {
    int startTotalHours = convertToHours(startDate);
    int endTotalHours = convertToHours(endDate);
    return endTotalHours - startTotalHours;
  }

  private int convertToHours(Date date)
  {
    int daysInYear = 365;
    int daysInMonth = 30;
    return date.getYear() * daysInYear * 24 +
        date.getMonth() * daysInMonth * 24 +
        date.getDay() * 24 +
        date.getHour();
  }

  public DateInterval getDateInterval()
  {
    return new DateInterval(startDate,endDate);
  }

  public String toString()
  {
    return "DateInterval{" + "startDate=" + startDate + ",endDate=" +endDate + '}';
  }

}
