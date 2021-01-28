/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3booksandauthors;

/**
 *
 * @author Acer
 */
public class Author 
{
    private int id; // INT PK AI
    private int bookId; // INT, FK -> books.id
    private String name; // VC(50), verify 1-50 chars long

    public Author (int id, int bookId, String name) throws InvalidDataException 
    {
        setId(id);
        setBookId(bookId);
        setName(name); 
    }
    
    // GETTERS
    public int getId() 
    {
        return id;
    }

    public int getBookId() 
    {
        return bookId;
    }

    public String getName() 
    {
        return name;
    }

    // SETTERS
    public void setId(int id) 
    {
        this.id = id;
    }

    public void setBookId(int bookId) 
    {
        this.bookId = bookId;
    }

    public void setName(String name) throws InvalidDataException
    {
        if(name.length() < 1 || name.length() > 50)
        {
            throw new InvalidDataException("Title should have 1 to 100 characters.");
        }
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return String.format("[%d] %s", id, name);
    }
}
