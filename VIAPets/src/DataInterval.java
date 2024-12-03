import javax.xml.crypto.Data;

public class DataInterval
{
  private Date startDate;
  private Date endDate;

  public DataInterval(Date startDate, Date endDate)
  {
    this.startDate = startDate;
    this.endDate =endDate;
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
    DataInterval other = (DataInterval) obj;
    return startDate.equals(other.startDate) &&endDate.equals(other.endDate);
  }
  public Date getstartDate()
  {
    return startDate;
  }
  public Date geendDate()
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

  public DataInterval getDataInterval()
  {
    return this;
  }

  public String toString()
  {
    return "DataInterval{" + "startDate=" + startDate + ",endDate=" +endDate + '}';
  }

}
