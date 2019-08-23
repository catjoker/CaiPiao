package com.BASofttech.caipiao.util;


public final class DBInstance {

	private static final DBInstance ins = new DBInstance();
	
	public static DBInstance getInstance(){
		return ins;
	}
}
