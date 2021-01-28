package practice16.databasepeople;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database 
{
    Connection con;
    
    public Database() throws SQLException
    {
        //connect to database
         con =DriverManager.getConnection(
         "jdbc:mysql://localhost:3306/idp23person","root","1468");
    }
    
    //SELECT, a method that returns arrayList <Person> from database with all records
   public  ArrayList<Person> getAllPeople() throws SQLException 
    {
        ArrayList<Person> list = new ArrayList<>();
        
        String sql = "SELECT * FROM people";
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql); //SQLException

 

        while(result.next())
        {
            int id = result.getInt("id");
            String name = result.getString("name");
            int age = result.getShort("age");
              
            try 
            {
                list.add(new Person(id, name, age));
            } 
            catch (PersonException ex) 
            {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

   //will add person to database and return int (Id of just created person)
   public int addPerson(Person p) throws SQLException
   {
       
             //insert data to table people
             //no need to insert id as it is auto increment
             String sql = "INSERT INTO people (name, age) VALUES (?, ?)";
 
             //[prepared statement helps to escape special characters and protects from sql injection
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  //con is the Connection name from connecting to database
            statement.setString(1, p.getName());
            statement.setInt(2, p.getAge());
            
            statement.executeUpdate(); //SQLException

 

            /* IF METHOD WAS VOID THEN DIREGARD ALL THIS PART ----------*/
            /* In fact we do not really need to know what was newly inserted id */
            //obtain ID of newly inserted record
            ResultSet rs = statement.getGeneratedKeys(); //ask for set of generated keys (returns list of inserted ids)
            if(rs.next())
            {
                int lastInsertedId = rs.getInt(1);
                p.setId(lastInsertedId); //write back id to the object passed    //IT IS OPTIONAL
                return lastInsertedId;   //-------------UNTIL HERE
            }
            //if inserted list is empty (no new ids)
            throw new SQLException ("Id after insert not found");
    }
   
    public void updatePerson (Person p) throws SQLException
   {
       //we never update id
      
       String sql = "UPDATE people SET name=?, age=? WHERE id=?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, p.getName());
        statement.setInt(2, p.getAge());
        statement.setInt(3, p.getId());
       
        statement.executeUpdate();  //SQLException
   }
}
