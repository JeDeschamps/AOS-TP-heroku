package com.tp1.example.tp1;


import me.alidg.errors.annotation.ExceptionMapping;
import org.springframework.http.HttpStatus;

@ExceptionMapping(statusCode = HttpStatus.NOT_FOUND, errorCode = "Book wasn't found")
public class BookDidNotExist extends RuntimeException{

}
