package com.tp.LibraryCollection.exceptions;

public class OverloadLibraryException extends Exception {
    public OverloadLibraryException( String message ){
        super( message );
    }

    public OverloadLibraryException( String message, Throwable innerException ){
        super( message, innerException);
    }
}
