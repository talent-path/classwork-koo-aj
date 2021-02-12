package com.tp.LibraryCollection.persistence;

import com.tp.LibraryCollection.exceptions.*;
import com.tp.LibraryCollection.models.Book;
import com.tp.LibraryCollection.models.LibraryCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostgresLibraryDao implements LibraryCollectionDao{
    @Autowired
    private JdbcTemplate template;

    @Override
    public Book getBookByID(Integer bookID) throws InvalidBookIDException {
        return null;
    }

    @Override
    public LibraryCollection getAllBooks() {
        return null;
    }

    @Override
    public Book updateBook(Integer bookId, String title, List<String> author, Integer yearPublished) throws InvalidBookException, InvalidTitleException, InvalidYearPublishedException, InvalidAuthorException {
        return null;
    }

//    @Override
//    public int addBook(String title, List<String> authors, Integer yearPublished) throws InvalidYearPublishedException, InvalidAuthorException, OverloadLibraryException, InvalidTitleException {
//        return 0;
//    }

    @Override
    public Book deleteBook(Integer bookID) throws InvalidBookIDException {
        return null;
    }

    @Override
    public List<Book> getBookStartsWith(String startsWith) throws InvalidBookIDException {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) throws InvalidBookIDException {
        return null;
    }

    @Override
    public List<Book> getBooksByPublishedYear(Integer year) throws InvalidBookIDException {
        return null;
    }
    
    @Override
    public Book addBook(String title, List<String> authors, Integer yearPublished) {
        List<Integer> authorList = new ArrayList<>();
        for (String author : authors) {
            Integer authorID = addOrRetrieve(author);
            authorList.add(authorID);

        }
        // add the book to database
//        Book
        // for each author add an entry to the book table
        // connect id from the book to the id related to the author
        return null;
    }

    // We are either adding a new "author" or we're retrieving an author that already exist.
    private Integer addOrRetrieve(String author) {
        Integer authorID = getAuthorID(author);
        if (authorID == null)
            authorID = addAuthor(author);
        return authorID;
    }

    // we are getting the author id that already exist;
    // if it doesn't exist we return null
    private Integer getAuthorID(String author) {
        List<Integer> id = new ArrayList<>();
        id =  template.query("select \"authorID\" from \"Author\" where \"authorName\" = '" + author + "'", new IDMapper());
        if (id.isEmpty()) return null;
        else return id.get(0);
    }

    //
    private Integer addAuthor(String author) {
        return template.query("insert into public.\"Author\" (\"authorName\")\n" +
                "values ('" + author + "')\n" +
                "returning \"authorID\" ", new IDMapper()).get(0);
    }

    private class IDMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("authorID");
        }
    }
}
