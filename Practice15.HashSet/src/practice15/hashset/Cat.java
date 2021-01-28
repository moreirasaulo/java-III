/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice15.hashset;

import java.util.Arrays;
import java.util.HashSet;

public class Cat 
{
    private String name;
    private int age;
    private HashSet<Season> seasons;
    
    // CONSTRUCTOR
    public Cat(String name, int age, HashSet<Season> seasons)
    {
        setName(name);
        setAge(age);
        setSeasons(seasons);
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

    public HashSet<Season> getSeasons() 
    {
        return seasons;
    }

    // SETTERS
    public void setName(String name) 
    {
        this.name = name;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public void setSeasons(HashSet<Season> seasons) 
    {
        this.seasons = seasons;
    }
    
    // TO STRING
    @Override
    public String toString()
    {
        return String.format("%s is %d years old and likes %s", name, age, Arrays.toString(seasons.toArray()));
    }
}
