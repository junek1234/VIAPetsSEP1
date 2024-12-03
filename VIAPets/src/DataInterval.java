import javax.xml.crypto.Data;

public class DataInterval extends Data
{
  Date leaveDate;
  Date pickupDate;

  public DataInterval(Date leaveDate, Date pickupDate)
  {
    this.leaveDate = leaveDate;
    this.pickupDate = pickupDate;
  }
  public equals(Object obj)
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
    return leaveDate.equals(other.leaveDate) && pickupDate.equals(other.pickupDate);
  }
  public Date getLeaveDate()
  {
    return leaveDate;
  }
  public Date getPickupDate()
  {
    return pickupDate;
  }
  public calculateInterval()
  {
    return pickupDate.day - leaveDate.day;
  }

  public String toString()
  {
    return "DataInterval{" + "leaveDate=" + leaveDate + ", pickupDate=" + pickupDate + '}';
  }

  public getDataInterval()
  {
    return this;
  }
}
