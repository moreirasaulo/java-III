/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz3booksandauthors;

import java.util.Date;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Book 
{
    private int id;
    private String title;
    private String isbn;
    private Date pubDate;
    private Blob coverImg;
    private ArrayList<String> authorList;
    
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
    public Book(int id, String title, String isbn, Date pubDate, Blob coverImg, ArrayList<String> authorList) throws InvalidDataException
    {
        setId(id);
        setTitle(title);
        setIsbn(isbn);
        setPubDate(pubDate);
        setCoverImg(coverImg);
        setAuthorList(authorList);
    }
    
    // GETTERS
    public int getId() 
    {        
        return id;
    }
    
    public String getTitle() 
    {        
        return title;
    }

    public String getIsbn() 
    {
        return isbn;
    }

    public Date getPubDate() 
    {
        return pubDate;
    }

    public Blob getCoverImg() 
    {
        return coverImg;
    }

    public ArrayList<String> getAuthorList() 
    {
        return authorList;
    }
    
    // SETTERS
    public void setId(int id) 
    {
        this.id = id;
    }
    
    public void setTitle(String title) throws InvalidDataException
    {
        if(title.length() < 1 || title.length() > 100)
        {
            throw new InvalidDataException("Title should have 1 to 100 characters.");
        }
        this.title = title;
    }

    public void setIsbn(String isbn) throws InvalidDataException
    {
        if(!isbn.matches("[0-9]{12}[0-9X]{1}"))
        {
            throw new InvalidDataException("ISBN field should have 13 characters with the first 12 being letters and the 13th being a letter or number");
        }
        this.isbn = isbn;
    }

    public void setPubDate(Date pubDate) 
    {
        this.pubDate = pubDate;
    }

    public void setCoverImg(Blob coverImg) 
    {
        this.coverImg = coverImg;
    }

    public void setAuthorList(ArrayList<String> authorList) 
    {
        this.authorList = authorList;
    }
    
    @Override
    public String toString()
    {
        return String.format("[%d] %s by %s", getId(), getTitle(), getAuthorList().toString());
    }
}
