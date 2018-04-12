package com.oracle.custom.exceptions;

@SuppressWarnings("serial")
public class ActionNotSupportedException extends Exception
{
	
  public ActionNotSupportedException(String exception)
  {
	  super(exception);
  }
}
