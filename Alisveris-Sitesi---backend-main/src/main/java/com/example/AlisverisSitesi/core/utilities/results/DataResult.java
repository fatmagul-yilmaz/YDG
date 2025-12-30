package com.example.AlisverisSitesi.core.utilities.results;


//Birden fazla veri tipi ile çalışacağımız için altta t datası diye generic bir şey belirledik.
public class DataResult <T> extends Result{

	private T data;
	
	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data=data;
	}
	
	public DataResult(T data, boolean success) {
		super(success);
		this.data=data;
	}
	
	public T getData() {
		return this.data;
	}
}

