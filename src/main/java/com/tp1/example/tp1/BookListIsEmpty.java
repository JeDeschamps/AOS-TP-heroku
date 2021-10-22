package com.tp1.example.tp1;

import me.alidg.errors.annotation.ExceptionMapping;
import org.springframework.http.HttpStatus;

@ExceptionMapping(statusCode = HttpStatus.NO_CONTENT, errorCode = "Book list is empty")
public class BookListIsEmpty extends RuntimeException{
}
