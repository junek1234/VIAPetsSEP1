package model;

import java.io.Serializable;

public class Date implements Serializable
{
  private int day;
  private int month;
  private int year;
  private int hour;

  public Date(int day, int month, int year, int hour)
  {
    this.day = day;
    this.month = month;
    this.year = year;
    this.hour = hour;
  }

  public int getDay()
  {

    return day;
  }

  public int getMonth()
  {

    return month;
  }

  public int getYear()
  {

    return year;
  }

  public int getHour()
  {

    return hour;
  }

  public void setDay(int day)
  {

    this.day = day;
  }

  public void setMonth(int month)
  {

    this.month = month;
  }

  public void setYear(int year)
  {

    this.year = year;
  }

  public void setHour(int hour)
  {

    this.hour = hour;
  }

  public String toString()
  {
    return day + "/" + month + "/" + year + " " + hour;
  }

  public boolean equals(Object obj)
  {
    if (obj == null)
    {
      return false;
    }
    if (obj == this)
    {
      return true;
    }
    if (obj.getClass() != this.getClass())
    {
      return false;
    }
    Date other = (Date) obj;
    return day == other.day && month == other.month && year == other.year && hour == other.hour;
  }
  public boolean isGreaterThan(Object obj)
  {
    if (obj == null)
    {
      return false;
    }
    if (obj == this)
    {
      return false;
    }
    if (obj.getClass() != this.getClass())
    {
      return false;
    }
    Date other = (Date) obj;
    if (this.year > other.year)
    {
      return true;
    }
    else if (this.year == other.year)
    {
      if (this.month > other.month)
      {
        return true;
      }
      else if (this.month == other.month)
      {
        if (this.day > other.day)
        {
          return true;
        }
        else if (this.day == other.day)
        {
          return this.hour > other.hour;
        }
      }

    }
    return false;
  }


  public Date copy()
  {

    return new Date(day, month, year, hour);
  }

  /*public int compareTo(Date other)
  {
    if (year < other.year)
    {
      return -1;
    }
    if (year > other.year)
    {
      return 1;
    }
    if (month < other.month)
    {
      return -1;
    }
    if (month > other.month)
    {
      return 1;
    }
    if (day < other.day)
    {
      return -1;
    }
    if (day > other.day)
    {
      return 1;
    }
    if (hour < other.hour)
    {
      return -1;
    }
    if (hour > other.hour)
    {
      return 1;
    }
    return 0;
  }*/
}
