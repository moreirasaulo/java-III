/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice8.modelwithtypeofobject;

/**
 *
 * @author Acer
 */
public class Cat {
    String colour;
    int age;

    public Cat(String colour, int age) {
        this.colour = colour;
        this.age = age;
    } 
    
    public String toString()
    {
        return String.format("%s;%s", colour, age);
        // return String = colour + ";" + age; -> Same
    }
    
    public boolean isRed()
    {
        if(colour.equals("red"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void UntilTen()
    {
        System.out.println(10 - age);
    }
}
