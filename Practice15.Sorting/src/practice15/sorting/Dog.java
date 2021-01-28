/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice15.sorting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Dog 
{
    private String name;
    private int age;
    private Date dob;
    
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    // CONSTRUCTORS
    public Dog(String name, int age, Date dob)
    {
        setName(name);
        setAge(age);
        setDob(dob);
    }

    // GETTERS
    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public Date getDob() 
    {
        return dob;
    }

    // SETTERS
    public void setName(String name) throws IllegalArgumentException
    {
        if(!name.matches("[^;^,]{1,20}"))
        {
            throw new IllegalArgumentException("The name should be up to 20 characters. Semicolons and commas are not permitted.");
        }
        this.name = name;
    }

    public void setAge(int age) 
    {        
        this.age = age;
    }

    public void setDob(Date dob) throws IllegalArgumentException
    {
        try
        {
            if(dob.before(dateFormat.parse("1956-01-01")) || dob.after(dateFormat.parse("2000-12-31")))
            {
                throw new IllegalArgumentException("This obituary registration only works with dogs born between 1956 and 2000.");
            }
        }
        catch(ParseException ex)
        {
            throw new IllegalArgumentException("Unparseable date.");
        }
        this.dob = dob;
    }
    
    // TO STRING
    @Override
    public String toString()
    {        
        return String.format("%s, born %s died at %d years old", name, dateFormat.format(dob), age);
    }
    
    //sorting
   
    //name
    //compare by name (String)
   static final Comparator <Dog> compareByName = (Dog d1, Dog d2) -> {
      return  d1.getName().compareTo(d2.getName());
    };
  
   //age
   static final Comparator<Dog> compareByAge = (Dog d1, Dog d2) -> {
      return  d1.getAge() - d2.getAge();
    };
  
   //compare by date of birth (Date)
   static final Comparator<Dog> compareByBirthday = (Dog d1, Dog d2) -> {
      return  d1.getDob().compareTo(d2.getDob());
    };
}
