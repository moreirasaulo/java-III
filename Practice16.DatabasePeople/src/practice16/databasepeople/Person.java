package practice16.databasepeople;

public class Person 
{
    private int id;
    private String name;
    private int age;
    
    // CONSTRUCTOR
    public Person(int id, String name, int age) throws PersonException
    {
        setId(id);
        setName(name);
        setAge(age);
    }

    // GETTERS
    public int getId()
    {
        return id;
    }
    
    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    // SETTERS
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setName(String name) throws PersonException
    {
        if(!name.matches("[A-Za-z- ]{1,100}"))
        {
            throw new PersonException("Name field has to be between 1 and 100 characters.");
        }
        this.name = name;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }  
    
    // TO STRING
    @Override
    public String toString()
    {
        return name + ", " + age;
    }
}
