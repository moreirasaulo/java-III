package day02fileioclean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day02FileIOClean {

    public static void main(String[] args) 
    {
        //  Part 1: writing to file
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        int count = (int)(Math.random() * 10 + 1);
        
        // with writing to file just handle IOException, no need to hande FileNotFound exception
        // try with resources
        try (PrintWriter fileOutput = new PrintWriter(new File("output.txt")))        
        {
            for(int i = 0; i < count; i++)
            {
                fileOutput.println(name);
            }
        } 
        catch (IOException ex) 
        {
            System.out.println("Error writing to file" + ex.getMessage());
        }
        
        
        // Part 2: Reading a file
        {
            try (Scanner fileInput = new Scanner(new File ("output.txt")))
            {
                while(fileInput.hasNextLine())
                {
                    String line = fileInput.nextLine();
                    System.out.println("Line: " + line);
                }
            }
            catch (IOException ex)
            {
                System.out.println("Error reading file: " + ex.getMessage());
            }
                    
        }
    }
    
}
