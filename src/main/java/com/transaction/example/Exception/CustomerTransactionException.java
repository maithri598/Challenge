package com.transaction.example.Exception;

public class CustomerTransactionException extends Exception {
	
	private static final long serialVersionUID = -3128681006635769411L;
    
    public CustomerTransactionException(String message) {
        super(message);
    }

}
