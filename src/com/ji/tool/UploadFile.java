/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.tool;
import java.io.*;
import java.util.Date;
import org.apache.struts.upload.FormFile;

// line 3 "../../../UploadFile.ump"
public class UploadFile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UploadFile()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  // line 8 "../../../UploadFile.ump"
   public String upload(String dir, FormFile formFile) throws Exception{
    Date date = new Date();
		
		String fname = formFile.getFileName();
		
		int i = fname.indexOf(".");
		String name = String.valueOf(date.getTime());
		String type = fname.substring(i + 1);
		fname = name + "." + type;
		InputStream streamIn = formFile.getInputStream(); 
		File uploadFile = new File(dir); 
		if (!uploadFile.exists() || uploadFile == null) { 
			uploadFile.mkdirs();
		}
		String path = uploadFile.getPath() + "/" + fname;
		OutputStream streamOut = new FileOutputStream(path);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = streamIn.read(buffer, 0, 8192)) != -1) {
			streamOut.write(buffer, 0, bytesRead);
		}
		streamOut.close();
		streamIn.close();
		formFile.destroy();
		return fname;
  }

}