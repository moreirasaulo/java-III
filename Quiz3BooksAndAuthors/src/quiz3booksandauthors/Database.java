/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3booksandauthors;

import java.sql.*;
import java.sql.Blob;
import javax.sql.rowset.serial.SerialBlob;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Database 
{    
    Connection con;  

    public Database() throws SQLException 
    {
        con = DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/booksAuthors", "root", "1468");
    }
    
    public ArrayList<String> getAllBooks() throws SQLException 
    {
        ArrayList<String> resultList = new ArrayList<>();
        
            String sql = "select B.id, B.title from Books as B;"
                    ;
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException
            while (result.next()) 
            {
                int id = result.getInt("id");
                String title = result.getString("title");
               
               

                resultList.add("["+ id +"]"+ " "+ title + " by");
            }
         
        return resultList;
    }
    
    public ArrayList<String> getAllAuthorsNames(int bookId) throws SQLException {

 

        ArrayList<String> resultList = new ArrayList<>();

 

            String sql = "select name from authors where bookId=?;";
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, bookId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

              
                String name = result.getString("name");
               

 

                resultList.add(name+",");

            }


        return resultList;
    }
    
    
    public ArrayList<String> getAllIsbns() throws SQLException {
        ArrayList<String> resultlst = new ArrayList<>();
        String sql = "select isbn from books;";
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            String isbn = result.getString("isbn");
            resultlst.add(isbn);
        }
        return resultlst;
    }
    
    public int addBook(Book book) throws SQLException 
    {
        String sql = "insert into Books (title, isbn, pubDate, coverImg) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, book.getTitle());
        statement.setString(2, book.getIsbn());
        statement.setDate(3, new java.sql.Date(book.getPubDate().getTime()));
        Blob blob = new SerialBlob(book.getCoverImg());
        statement.setBlob(4, blob);        
        //statement.execute();
        statement.executeUpdate();  //SQLException
        
        ResultSet rs = statement.getGeneratedKeys();

        if (rs.next()) 
        {
            int lastInsertedId = rs.getInt(1);
            return lastInsertedId;
        }
        throw new SQLException("Id after insert not found");
    }
    
    public int addAuthor(Author a) throws SQLException 
    {
        String sql = "insert into Authors (bookId, name) VALUES (?, ?)";
        PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, a.getBookId());
        statement.setString(2, a.getName());
        statement.executeUpdate();  //SQLException
        ResultSet result = statement.getGeneratedKeys();
        if (result.next()) 
        {
            int lastInsertedId = result.getInt(1);
            return lastInsertedId;
        }
        throw new SQLException("Id after insert not found");
    }
}
