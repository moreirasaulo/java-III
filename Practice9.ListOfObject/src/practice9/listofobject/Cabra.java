/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice9.listofobject;

/**
 *
 * @author Acer
 */
public class Cabra 
{
    String name;
    int age;

    public Cabra(String name, int age) 
    {
        this.name = name;
        this.age = age;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "Name: " + name + "; Age: " + age;  
    }
}
