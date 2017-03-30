/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.tool;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.RequestProcessor;

// line 4 "../../../SelfRequestProcessor.ump"
public class SelfRequestProcessor extends RequestProcessor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SelfRequestProcessor()
  {
    super();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  // line 12 "../../../SelfRequestProcessor.ump"
   protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response){
    super.processPreprocess(request, response);
		try {
			request.setCharacterEncoding("gb2312");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		return true;
  }

}