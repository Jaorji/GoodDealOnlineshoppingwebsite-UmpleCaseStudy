/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.tool;
import java.util.Date;
import java.text.DateFormat;

// line 3 "../../../CountTime.ump"
public class CountTime
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CountTime()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  // line 9 "../../../CountTime.ump"
   public String currentlyTime(){
    Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		return dateFormat.format(date);
  }

}