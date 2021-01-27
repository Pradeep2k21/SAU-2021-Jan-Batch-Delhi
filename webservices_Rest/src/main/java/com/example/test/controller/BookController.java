package com.example.test.controller;

import com.example.test.model.Book;
import com.example.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

//    @GetMapping("/list")
//    public Book getBook() {
//        return new Book().setId(1).setName("Test").setAuthorName("Author Name");
//    }




    @Autowired
    BookService bookService;

    @GetMapping("/all")
   @CrossOrigin(origins = "*")

    public ResponseEntity<List<Book>> listAllBooks(){
//        try{
//            return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
//        } catch( Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }

        return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Integer> saveBook(@RequestBody Book book) {
//        try{
//            if(book == null || book.getName() == null || book.getAuthorName() == null || book.getName().isEmpty() || book.getAuthorName().isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//            return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        if(book == null || book.getName() == null || book.getAuthorName() == null || book.getName().isEmpty() || book.getAuthorName().isEmpty()) {
              return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    @CrossOrigin(origins = "*")
    public  Book findById(@PathVariable("id") int id){
        return this.bookService.findBookId(id);
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "*")
    public ResponseEntity updateBook(@RequestBody Book book) {
        try{
            bookService.updateBook(book);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("id") int id) {
        try{
            return new ResponseEntity<>(this.bookService.deleteBook(id), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
