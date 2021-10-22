package com.tp1.example.tp1;

import me.alidg.errors.annotation.ExceptionMapping;
import org.springframework.http.HttpStatus;

@ExceptionMapping(statusCode = HttpStatus.PRECONDITION_FAILED, errorCode = "Book wasn't completed")
public class FailedToAddBookException extends RuntimeException{
}
