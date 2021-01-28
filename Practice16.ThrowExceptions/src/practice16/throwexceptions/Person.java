/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice16.throwexceptions;

public class Person 
{
    private String name;
    private int age;
    
    public Person(String name, int age) throws SaulosException
    {
        setName(name);
        setAge(age);
    }
    
    
    
    @Override
    public String toString()
    {
        return getName() + ", " + getAge();
    }

    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public void setName(String name)  throws SaulosException
    {
         if(!name.matches("[^;,]{1,50}"))
         {
             throw new SaulosException("Name can't be empty nor contain symbols ; and ,");
         }

        this.name = name;
    }

    public void setAge(int age) throws SaulosException
    {
        if(age < 18)
        {
            throw new SaulosException("Age must be more than 18"); 
        }
        this.age = age;
    }
}
