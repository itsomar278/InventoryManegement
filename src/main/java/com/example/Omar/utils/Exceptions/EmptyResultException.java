package com.example.Omar.utils.Exceptions;

public class EmptyResultException extends RuntimeException
{

    public EmptyResultException()
    {
        super("Requested Resource Not Found");
    }

    public EmptyResultException(String message)
    {
        super(message);
    }

}