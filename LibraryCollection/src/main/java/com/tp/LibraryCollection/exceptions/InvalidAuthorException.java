package com.tp.LibraryCollection.exceptions;

public class InvalidAuthorException extends Exception {
    public InvalidAuthorException( String message ){
        super( message );
    }

    public InvalidAuthorException( String message, Throwable innerException ){
        super( message, innerException);
    }
}
