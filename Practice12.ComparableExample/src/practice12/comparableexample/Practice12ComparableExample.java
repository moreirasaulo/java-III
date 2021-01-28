/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice12.comparableexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Acer
 */
public class Practice12ComparableExample 
{
    public static void main(String[] args) 
    {
        List<User> users = new ArrayList<User>();
        User user1 = new User(5, "John");
        User user2 = new User(7, "Alex");
        User user3 = new User(1, "Peter");
        User user4 = new User(4, "Lucas");
        
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        
        Collections.sort(users);
        
        //User[] userArray = {user1, user2, user3, user4};
        //Arrays.sort(userArray);
        
        for(User user : users) // If uncomment above, sb: for(User user : userArray)
        {
            System.out.println(user);
        }
    }
    
}
