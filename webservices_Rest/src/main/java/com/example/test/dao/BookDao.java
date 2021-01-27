package com.example.test.dao;

import com.example.test.model.Book;
import com.example.test.rowmapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks() {
        final String GET_ALL_BOOKS = "Select id, bookname, authorname from book";
        return this.jdbcTemplate.query(GET_ALL_BOOKS, new BookRowMapper());
    }

    public int saveBook(Book book) {
        final String SAVE_BOOK = "insert into book(bookname, authorname) values(?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement stmt = connection.prepareStatement(SAVE_BOOK, new String[]{"id"});
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getAuthorName());
            return stmt;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Book findBookById(int id) {
        final String FIND_BY_ID = "select id, boknaoke, authorname from book where id = ?";
        return this.jdbcTemplate.queryForObject(FIND_BY_ID, this::mapRowToBook, id);
    }

    public void updateBook(Book book) {
        final String UPDATE_BOOK_QUERY = "update book set bookname = ?, authorname = ? where id = ?";
        this.jdbcTemplate.update(UPDATE_BOOK_QUERY, book.getName(), book.getAuthorName(), book.getId());
    }

    public boolean deleteBookById(int id) {
        final String DELETE_QUERY = "delete from book where id = ?";
        return this.jdbcTemplate.update(DELETE_QUERY, id) > 0;
    }

    private Book mapRowToBook(ResultSet resultSet, int rowNumber) throws SQLException {
        return new Book()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("bookname"))
                .setAuthorName(resultSet.getString("authorname"));
    }
}
