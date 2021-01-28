/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice13.bigwork;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Acer
 */
public class Birthday 
{
    private String name;
    private Date birthday;
    
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public Birthday(String name, Date birthday)
    {
        setName(name); // These statements might throw illegal argument exception
        setBirthday(birthday);
    }
    
    @Override
    public String toString() 
    {
        return getName() + " born " + dateFormat.format(getBirthday()) + " " + getDaysTillBday();
    }

    public int getDaysTillBday() 
    {
        int daysTillBday = -1;
        Calendar nextBday = Calendar.getInstance();
        // today
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(today));
        
        // get day and month
        Calendar calBday = Calendar.getInstance();
        calBday.setTime(this.birthday);
        
        // Today's date
        Calendar calToday = Calendar.getInstance();
        calToday.setTime(today);
        
        int dayBday = calBday.get(Calendar.DAY_OF_MONTH);
        int monthBday = calBday.get(Calendar.MONTH);
        int yearBday = calBday.get(Calendar.YEAR);
        
        int dayToday = calToday.get(Calendar.DAY_OF_MONTH);
        int monthToday = calToday.get(Calendar.MONTH);
        int yearToday = calToday.get(Calendar.YEAR);
        
        
        if((monthToday > monthBday) || (monthToday == monthBday && dayToday > dayBday)) 
        // means the next bday is only next year
        {
            nextBday.set((yearToday +1), monthBday, dayBday);//add +1 for next year if this month is > birth month
        }
        else // today or anytime this year
        { 
            nextBday.set(yearToday, monthBday, dayBday);
        }
        
        
       daysTillBday = (int)((nextBday.getTimeInMillis() - calToday.getTimeInMillis())/(1000*60*60*24));        
        
        
        return daysTillBday;  
    }

    // Getters
    public String getName() 
    {
        return name;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    
    // Setters
    public void setName(String name) 
    {
        this.name = name;
    }

    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }
    
   
}
