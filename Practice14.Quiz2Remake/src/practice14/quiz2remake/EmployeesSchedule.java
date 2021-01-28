/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice14.quiz2remake;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class EmployeesSchedule {
    private String name;
    private boolean isManager;
    private String department;
    private Date dateHired;
    HashSet<Weekday> workdaysList = new HashSet<>(); /*hashsets are basically arrays list 
    that doesn't accept duplicates*/
    
    static SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
    static SimpleDateFormat printDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    final String NAME_DEPT_PATTERN = "[^;\\^?\\@!\\~*]{2,50}";
    
    // CONSTRUCTORS
    
    public EmployeesSchedule (String name, boolean isManager, String department, Date dateHired) throws InvalidValueException
    {
        setName(name);
        setIsManager(isManager);
        setDepartment(department);
        setDateHired(dateHired);
        setWorkdaysList(workdaysList);
    }
    
    public EmployeesSchedule (String dataLine) throws InvalidValueException
    {
        String[] data = dataLine.split(";");
        if(data.length != 4)
        {
            JOptionPane.showMessageDialog(this, "The file has wrong data structure. Please review.", "Error loading data",
                    JOptionPane.ERROR_MESSAGE);
        }
        String nameManager = data[0];
        String lastCharacter = nameManager.substring(nameManager.length()-1);
        if(lastCharacter.equals("*"))
        {
            setIsManager(true);            
            try
            {
                setName(nameManager.substring(0, nameManager.length() - 1));
            }
            catch(InvalidValueException e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error loading data",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            setIsManager(false);
            setName(nameManager);
        }
                
        String department = data[2];
        String workDaysList = data[3];
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public boolean isManager() {
        return isManager;
    }

    public String getDepartment() {
        return department;
    }

    public Date getDateHired() {
        return dateHired;
    }
    
    public Date getWorkdaysList() {
        return dateHired;
    }

    // SETTERS
    public void setName(String name) throws InvalidValueException
    {
         if(!name.matches(NAME_DEPT_PATTERN)) 
        {
            throw new InvalidValueException("Please mind that no special characters are permitted. The lenght should be between 2 and 50 characters.");
        }
        this.name = name;
    }

    public void setIsManager(boolean isManager) 
    {
        this.isManager = isManager;
    }

    public void setDepartment(String department) throws InvalidValueException
    {   
        if(!department.matches(NAME_DEPT_PATTERN))
        {
            throw new InvalidValueException("Please note that no special characters are permitted. The lenght should be between 2 and 50 characters.");
        }
        this.department = department;
    }

    public void setDateHired(Date dateHired) throws InvalidValueException
    {
        try 
        {
            if (dateHired.before(dateFormat.parse("1900-01-01")) || dateHired.after(dateFormat.parse("2100-01-01"))) 
            {
                throw new InvalidValueException("Invalid input. Date hired should be from year 1900 to year 2100.");
            }
            this.dateHired = dateHired;
        }
        catch (ParseException ex) 
        {
            throw new InvalidValueException (ex.getMessage());
        }
    }
    
    public void setWorkdaysList(HashSet<Weekday> workdaysList)
    {
        this.workdaysList = workdaysList;
    }
    
    @Override
    public String toString() 
    {
        String manOrEmp ="";
        if(isManager ==  true)
        {
            manOrEmp = "manager";
        }
        else
        {
            manOrEmp = "employee";
        }
        
        //set.toArray(new String[set.size()]);
        
        return String.format("%s,%s of %s department, hired on %s, works on %s",
                name, manOrEmp, department,dateFormat.format(dateHired), workdaysList.toArray(new String[workdaysList.size()]));              
    }   
    
    public String toDataString()
    {
        String manOrEmp ="";
        if(isManager ==  true)
        {
            manOrEmp = "*";
        }
        else
        {
            manOrEmp = "";
        }
        
        return String.format("%s%s;%s;%s;%s", name, manOrEmp, printDateFormat.format(dateHired), department, workdaysList.toArray(new String[workdaysList.size()]));
    }
}
