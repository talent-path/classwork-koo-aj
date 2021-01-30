package com.tp.LibraryCollection.exceptions;

public class InvalidYearPublishedException extends Exception {
    public InvalidYearPublishedException( String message ){
        super( message );
    }

    public InvalidYearPublishedException( String message, Throwable innerException ){
        super( message, innerException);
    }
}
