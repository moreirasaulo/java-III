/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice12.comparableexample;

/**
 *
 * @author Acer
 */
public class User implements Comparable<User>
{
    private int id;
    private String name;
    
    public User(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    public String toString()
    {
        return id + " : " + name;
    }
    
    // Accepts user object and compares whether the current object's id is lesser or greater than the id object
    // being passed and return int value
    //@Override
    //public int compareTo(User user)
    //{
    //    return id - user.getId();
    //}
    
    // To order by name:
    public int compareTo(User user){
          return name.compareTo(user.getName());
    }
}
