package com.tp1.example.tp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;



@RestController
public class BookController {
    private ArrayList<BookEntity> bookList;

    BookController() {
        this.bookList = new ArrayList<BookEntity>();
        BookEntity book1 = new BookEntity("Livre 1", "michel", "001");
        BookEntity book2 = new BookEntity("Livre 2", "henri", "002");
        BookEntity book3 = new BookEntity("Livre 3", "patrick", "003");
        BookEntity book4 = new BookEntity("Livre 4", "jacky", "004");
        BookEntity book5 = new BookEntity("Livre 5", "paul", "005");
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
        this.bookList.add(book4);
        this.bookList.add(book5);
    }

    @GetMapping("/books/all")
    public ResponseEntity<ArrayList<BookEntity>> getBookList() {
        if (this.bookList.isEmpty())
            throw new BookListIsEmpty();
        return new ResponseEntity(this.bookList, HttpStatus.OK);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello ";
    }

//    @GetMapping("books/{id}")
//    public ResponseEntity<BookEntity> getById(@PathVariable String id) {
//        Optional<BookEntity> book = BookController.getByIsbn(id);
//        if (book.isPresent()) {
//            return new ResponseEntity<>(book.get(), HttpStatus.OK);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }

//    public BookEntity getByIsbn(String isbn){
//        ArrayList list = getBookList().getBody();
//        for (BookEntity book : list){
//            if (book.getIsbn() == isbn) return book;
//        }
//    }


    @PostMapping("/books/add")
    public ResponseEntity addBook(@RequestBody BookEntity book) {
        if (book.getName().isEmpty() || book.getAuthor().isEmpty() || book.getIsbn().isEmpty())
            throw new FailedToAddBookException();
        this.bookList.add(book);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/books/remove/one/{isbn}")
    public ResponseEntity deleteBook(@PathVariable(value = "isbn") String isbn) {
        int i = 0;
        for (BookEntity books : this.bookList) {
            if (books.getIsbn().equals(isbn)){
                this.bookList.remove(i);
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }
        throw new BookDidNotExist();
    }
}
