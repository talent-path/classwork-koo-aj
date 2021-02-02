package com.tp.LibraryCollection.exceptions;

public class InvalidTitleException extends Exception {

    public InvalidTitleException( String message ){
        super( message );
    }

    public InvalidTitleException( String message, Throwable innerException ){
        super( message, innerException);
    }
}
