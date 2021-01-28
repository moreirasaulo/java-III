package practice17.review;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;

public class Flight 
{
    private String airlines;
    private int number;
    private HashSet<Weekday> weekday;
    private String city;
    private Date date;
    
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public Flight(String airlines, int number, HashSet<Weekday> weekday, Date date, String city) throws IllegalArgumentException
    {
        setAirlines(airlines);
        setNumber(number);
        setWeekday(weekday);
        setCity(city);
        setDate(date);
    }

    // GETTERS
    public String getAirlines() 
    {
        return airlines;
    }

    public int getNumber() 
    {
        return number;
    }

    public HashSet<Weekday> getWeekday() 
    {
        return weekday;
    }

    public String getCity() 
    {
        return city;
    }

    public Date getDate() 
    {
        return date;
    }

    // SETTERS
    public void setAirlines(String airlines) throws IllegalArgumentException
    {
        if(!airlines.matches("[A-Z]{2}"))
        {
            throw new IllegalArgumentException("Airlines field must contain 2 uppercase letters.");
        }
        this.airlines = airlines;
    }

    public void setNumber(int number) 
    {
        this.number = number;
    }

    public void setWeekday(HashSet<Weekday> weekday) 
    {
        this.weekday = weekday;
    }

    public void setCity(String city) throws IllegalArgumentException
    {
        if(city.length() == 0) 
        {
            throw new IllegalArgumentException("The city field cannot be empty.");
        }
        this.city = city;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
    
    //SORTING    
    //name
    //compare by City (String)
    static final Comparator <Flight> compareByName = (Flight f1, Flight f2) -> 
    {
        return  f1.getCity().compareTo(f2.getCity());
    };
  
    //flight number (int)
    static final Comparator<Flight> compareByFlightNo = (Flight f1, Flight f2) -> 
    {
      return  f1.getNumber() - f2.getNumber();
    };
  
    //compare by date of flight (Date)
    static final Comparator<Flight> compareByDate = (Flight f1, Flight f2) -> 
    {
        return  f1.getDate().compareTo(f2.getDate());
    };
   
    //compare by Airlines (String)
    static final Comparator <Flight> compareByAirlines = (Flight f1, Flight f2) -> 
    {
        return  f1.getAirlines().compareTo(f2.getAirlines());
    };
    
    @Override
    public String toString()
    {
        return String.format("Flight № %s%d departs on %s %s to %s", airlines, number, Arrays.toString(weekday.toArray()), dateFormat.format(getDate()), city);
    }
    
    public String toDataString()
    {
        return String.format("%s;%d;%s;%s;%s", airlines, number, Arrays.toString(weekday.toArray()), dateFormat.format(getDate()), city);
    }
}
