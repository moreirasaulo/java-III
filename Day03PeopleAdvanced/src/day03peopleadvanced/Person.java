/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03peopleadvanced;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Acer
 */
public class Person {
    String name;
    int heightCm;
    Date dateOfBirth;
    
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public Person(String name, int heightCm, Date dateOfBirth)
    {
        this.name = name;
        this.heightCm = heightCm;
        this.dateOfBirth = dateOfBirth;
    }
	
    @Override
    public String toString() 
    {
        // TODO: Fix display of the date
        return String.format("%s is %dcm tall born %s", name, heightCm, dateFormat.format(dateOfBirth));
    }
}
