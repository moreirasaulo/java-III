/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice11.gettersandsettersconfig;

import java.util.Date;

/**
 *
 * @author Acer
 */
public class Animal {
    private String type;
    private String colour;
    private int age;
    
    //Constructor
    public Animal(String type, String colour, int age)
    {
        setType(type); // These statements might throw illegal argument exception
        setColour(colour);
        setAge(age);        
    }
    
    public String toString()
    {
        return type + ", " + colour + ", " + age;
    } 

    // Type
    public String getType() 
    {
        return type;
    }

    public void setType(String type) throws IllegalArgumentException
    {
        if(!type.matches("^[a-zA-Z- ]{1,20}$"))
        {
            throw new IllegalArgumentException ("Type should have between 1 and 20 characters.");
        }
        this.type = type;        
    }

    // Colour
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) 
    {
        this.colour = colour;
    }

    //Age
    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException
    {
        if(age < 0 || age > 70)
        {
            throw new IllegalArgumentException ("Age must be between 0 and 70");
        }
        this.age = age;
    }
    
}
