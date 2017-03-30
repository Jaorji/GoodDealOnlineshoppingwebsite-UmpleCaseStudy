/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package com.ji.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.Action;
import org.apache.struts.upload.FormFile;
import java.util.List;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import com.ji.Entity.*;
import com.ji.DAO.*;
import com.ji.tool.*;

// line 10 "../../../GoodsAction.ump"
public class GoodsAction extends Action
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GoodsAction Attributes
  private int action;
  private HttpSession session;

  //GoodsAction Associations
  private Goods goodsForm;
  private GoodsDao dao;
  private BrandDao brand;
  private UploadFile uploadFile;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GoodsAction(int aAction, HttpSession aSession, Goods aGoodsForm, GoodsDao aDao, BrandDao aBrand, UploadFile aUploadFile)
  {
    super();
    action = aAction;
    session = aSession;
    if (!setGoodsForm(aGoodsForm))
    {
      throw new RuntimeException("Unable to create GoodsAction due to aGoodsForm");
    }
    if (!setDao(aDao))
    {
      throw new RuntimeException("Unable to create GoodsAction due to aDao");
    }
    if (!setBrand(aBrand))
    {
      throw new RuntimeException("Unable to create GoodsAction due to aBrand");
    }
    if (!setUploadFile(aUploadFile))
    {
      throw new RuntimeException("Unable to create GoodsAction due to aUploadFile");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAction(int aAction)
  {
    boolean wasSet = false;
    action = aAction;
    wasSet = true;
    return wasSet;
  }

  public boolean setSession(HttpSession aSession)
  {
    boolean wasSet = false;
    session = aSession;
    wasSet = true;
    return wasSet;
  }

  public int getAction()
  {
    return action;
  }

  public HttpSession getSession()
  {
    return session;
  }

  public Goods getGoodsForm()
  {
    return goodsForm;
  }

  public GoodsDao getDao()
  {
    return dao;
  }

  public BrandDao getBrand()
  {
    return brand;
  }

  public UploadFile getUploadFile()
  {
    return uploadFile;
  }

  public boolean setGoodsForm(Goods aNewGoodsForm)
  {
    boolean wasSet = false;
    if (aNewGoodsForm != null)
    {
      goodsForm = aNewGoodsForm;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setDao(GoodsDao aNewDao)
  {
    boolean wasSet = false;
    if (aNewDao != null)
    {
      dao = aNewDao;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setBrand(BrandDao aNewBrand)
  {
    boolean wasSet = false;
    if (aNewBrand != null)
    {
      brand = aNewBrand;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setUploadFile(UploadFile aNewUploadFile)
  {
    boolean wasSet = false;
    if (aNewUploadFile != null)
    {
      uploadFile = aNewUploadFile;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    goodsForm = null;
    dao = null;
    brand = null;
    uploadFile = null;
  }

  // line 34 "../../../GoodsAction.ump"
   public  GoodsAction(){
    
  }

  // line 37 "../../../GoodsAction.ump"
   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
    request.setCharacterEncoding("gb2312");
	this.dao = new GoodsDao();
	brand = new BrandDao();
	action = Integer.parseInt(request.getParameter("action"));
	System.out.println("session"+ request.getSession());
	session = request.getSession();
		
		switch (action) {
		case 0: {
			return goodSelect(mapping, form, request, response); 
		}
		case 1: {
			return goodForward(mapping, form, request, response); 
		}
		case 2: {
			return selectSmallName(mapping, form, request, response); 
		}
		case 3: {
			return saveGoods(mapping, form, request, response); 
		}

		case 5: {
			return selectOneGoods(mapping, form, request, response); 
		}
		case 6: {
			return deleteGoods(mapping, form, request, response);
		}
		case 7: {
			return goodSelectMark(mapping, form, request, response); 
		}
		case 8: {
			return goodSelectSmall(mapping, form, request, response); 
			}
		case 9: {
			return goodSelectBig(mapping, form, request, response); 
		}
		case 10: {
			return managerFreePirceForward(mapping, form, request, response);
		}
		case 11: {
			return managerFreePirce(mapping, form, request, response); 
		}
		case 12: {
			return goodSelectBigHead(mapping, form, request, response); 
		}
		case 13: {
			return goodSelectSmallHead(mapping, form, request, response); 
		}
		case 14: {
			return goodSelectNewHead(mapping, form, request, response);
		}
		case 15: {
			return goodSelectFreeHead(mapping, form, request, response); 
		}
		case 16: {
			return goodSelectOneHead(mapping, form, request, response);
		}
        }
		Goods goodsForm = (Goods) form;
		
		throw new java.lang.UnsupportedOperationException(
				"Method $execute() not yet implemented.");
  }

  // line 105 "../../../GoodsAction.ump"
   public ActionForward goodSelectOneHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    request.setAttribute("form", dao.selectOneGoods(Integer.valueOf(request
				.getParameter("id"))));
	return mapping.findForward("goodSelectOneHead");
  }

  // line 114 "../../../GoodsAction.ump"
   public ActionForward goodSelectFreeHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Goods> list = null;
	String status = request.getParameter("status");
	list = dao.selectSale(status);
	int pageNumber = list.size();
	int maxPage = pageNumber; 
	String number = request.getParameter("i");
	if (maxPage % 4 == 0) {
		maxPage = maxPage / 4;
	} else {
		maxPage = maxPage / 4 + 1;
		}
	if (number == null) {
		number = "0";
	}
	request.setAttribute("number", String.valueOf(number));
	request.setAttribute("maxPage", String.valueOf(maxPage));
	request.setAttribute("pageNumber", String.valueOf(pageNumber));
	request.setAttribute("list", list);
	return mapping.findForward("goodSelectFreeHead");
  }

  // line 139 "../../../GoodsAction.ump"
   public ActionForward goodSelectNewHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Goods> list = null;
	String status = request.getParameter("status");
	list = dao.selectSale(status);
	request.setAttribute("list", list);
	return mapping.findForward("goodSelectNewHead");
  }

  // line 149 "../../../GoodsAction.ump"
   public ActionForward goodSelectSmallHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Goods> list = null;
	list = dao.selectSmall(Integer.valueOf(request.getParameter("brandId")));
	int pageNumber = list.size(); 
	int maxPage = pageNumber;
	String number = request.getParameter("i");
	if (maxPage % 4 == 0) {
		maxPage = maxPage / 4;
	} else {
		maxPage = maxPage / 4 + 1;
	}
	if (number == null) {
		number = "0";
	}
	request.setAttribute("number", String.valueOf(number));
	request.setAttribute("maxPage", String.valueOf(maxPage));
	request.setAttribute("pageNumber", String.valueOf(pageNumber));
	request.setAttribute("list", list);
	request.setAttribute("smallList", brand.selectOneBigId(Integer
				.valueOf(request.getParameter("typeId"))));
	return mapping.findForward("goodSelectSmallHead");
  }

  // line 174 "../../../GoodsAction.ump"
   public ActionForward goodSelectBigHead(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Goods> list = null;
	list = dao.selectBig(Integer.valueOf(request.getParameter("typeId")));
	int pageNumber = list.size(); 
	int maxPage = pageNumber; 
	String number = request.getParameter("i");
	if (maxPage % 4 == 0) {
		maxPage = maxPage / 4;
	} else {
		maxPage = maxPage / 4 + 1;
	}
	if (number == null) {
		number = "0";
	}
	request.setAttribute("number", String.valueOf(number));
	request.setAttribute("maxPage", String.valueOf(maxPage));
	request.setAttribute("pageNumber", String.valueOf(pageNumber));
	request.setAttribute("list", list);
	request.setAttribute("smallList", brand.selectOneBigId(Integer
				.valueOf(request.getParameter("typeId"))));
	return mapping.findForward("goodSelectBigHead");
  }

  // line 199 "../../../GoodsAction.ump"
   public ActionForward managerFreePirce(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    Goods goodsForm = (Goods) form;
	
	String status = request.getParameter("status").trim();
	String id = request.getParameter("id").trim();
	if (status.equals("NotSale")) {
		goodsForm.setSalePrice(Double.valueOf("0"));
		goodsForm.backToOriginalPrice();
		goodsForm.setId(Integer.valueOf(id));
		dao.managerPrice(goodsForm);
		request.setAttribute("result", "price can not change");
	} else {
		String free = request.getParameter("salePrice").trim();
		goodsForm.setSalePrice(Double.valueOf(free));
		goodsForm.changePrice();
		goodsForm.setId(Integer.valueOf(id));
		dao.managerPrice(goodsForm);
		request.setAttribute("result", "price changed");
	}

	return mapping.findForward("goodsOperation");
  }

  // line 224 "../../../GoodsAction.ump"
   public ActionForward managerFreePirceForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    request.setAttribute("form", dao.selectOneGoods(Integer.valueOf(request
				.getParameter("id"))));
	return mapping.findForward("managerSalePirce");
  }

  // line 232 "../../../GoodsAction.ump"
   public ActionForward goodSelectBig(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Goods> list = null;
	list = dao.selectBig(Integer.valueOf(request.getParameter("typeId")));
	int pageNumber = list.size(); 
	int maxPage = pageNumber; 
	String number = request.getParameter("i");
	if (maxPage % 6 == 0) {
		maxPage = maxPage / 6;
	} else {
		maxPage = maxPage / 6 + 1;
	}
	if (number == null) {
		number = "0";
	}
	request.setAttribute("number", String.valueOf(number));
	request.setAttribute("maxPage", String.valueOf(maxPage));
	request.setAttribute("pageNumber", String.valueOf(pageNumber));
	request.setAttribute("list", list);
	return mapping.findForward("goodSelectBig");
  }

  // line 256 "../../../GoodsAction.ump"
   public ActionForward goodSelectSmall(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Goods> list = null;
	list = dao.selectSmall(Integer.valueOf(request.getParameter("brandId")));
    int pageNumber = list.size(); 
	int maxPage = pageNumber; 
	String number = request.getParameter("i");
	if (maxPage % 6 == 0) {
		maxPage = maxPage / 6;
	} else {
		maxPage = maxPage / 6 + 1;
	}
	if (number == null) {
		number = "0";
	}
	request.setAttribute("number", String.valueOf(number));
	request.setAttribute("maxPage", String.valueOf(maxPage));
	request.setAttribute("pageNumber", String.valueOf(pageNumber));
	request.setAttribute("list", list);
	return mapping.findForward("goodSelectSmall");
  }

  // line 279 "../../../GoodsAction.ump"
   public ActionForward goodSelectMark(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Goods> list = null;
	list = dao.selectSale(request.getParameter("status"));
	int pageNumber = list.size(); 
	int maxPage = pageNumber; 
	String number = request.getParameter("i");
	if (maxPage % 6 == 0) {
		maxPage = maxPage / 6;
	} else {
		maxPage = maxPage / 6 + 1;
	}
	if (number == null) {
		number = "0";
	}
	request.setAttribute("number", String.valueOf(number));
	request.setAttribute("maxPage", String.valueOf(maxPage));
	request.setAttribute("pageNumber", String.valueOf(pageNumber));
	request.setAttribute("list", list);
	return mapping.findForward("goodSelectMark");
  }

  // line 301 "../../../GoodsAction.ump"
   public ActionForward deleteGoods(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    dao.deleteGoods(Integer.valueOf(request.getParameter("id")));
	request.setAttribute("result", "Goods deleted");
	return mapping.findForward("goodsOperation");
  }

  // line 308 "../../../GoodsAction.ump"
   public ActionForward selectOneGoods(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    request.setAttribute("form", dao.selectOneGoods(Integer.valueOf(request
				.getParameter("id"))));
	return mapping.findForward("selectContent");
  }

  // line 317 "../../../GoodsAction.ump"
   public ActionForward saveGoods(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
    Goods goodsForm = (Goods) form;
	Type type = new Type();
	TypeDao typeDao = new TypeDao();
	Brand brand = new Brand();
	BrandDao brandDao = new BrandDao();
		
	String dir = servlet.getServletContext().getRealPath("/goodsPicture/1195000722234.jpg");
	FormFile formFile = goodsForm.getFormFile();
	//String getType = formFile.getFileName().substring(
	
	//			formFile.getFileName().lastIndexOf(".") + 1);
	
	String result = "upload sccessfully";
	String imageType[] = { "JPG", "jpg", "gif", "bmp", "BMP" };
	//for (int ii = 0; ii < imageType.length; ii++) {
	
	 // if (imageType[ii].equals(getType)) {
	 
				
	      type = typeDao.selectOneType(Integer.valueOf(request.getParameter("typeId")));
		  goodsForm.setType(type);
		  brand = brandDao.selectOneBrand(Integer.valueOf(request.getParameter("brandId")));
		  goodsForm.setBrand(brand);
		  goodsForm.setName(request.getParameter("name"));
		  goodsForm.setManufacturer(request.getParameter("manufacturer"));
		  goodsForm.setPrice(Double.valueOf(request.getParameter("pirce")));
		  goodsForm.setSalePrice(Double.valueOf(request.getParameter("salePirce")));
		  goodsForm.setDescription(request.getParameter("description"));			
	   	  goodsForm.setNumberInInventory(Integer.valueOf(request.getParameter("numberInInventory")));
		  //goodsForm.setPicture("goodsPicture/"+uploadFile.upload(dir, formFile));
		  
		  dao.insertGoods(goodsForm);
		  result = "upload picture";
		//}
		
	 //}
	 
		request.setAttribute("result", result);
		return mapping.findForward("goodsOperation");
  }

  // line 362 "../../../GoodsAction.ump"
   public ActionForward selectSmallName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    request.setAttribute("typeId", request.getParameter("typeId"));
		return mapping.findForward("goodForward");
  }

  // line 368 "../../../GoodsAction.ump"
   public ActionForward goodForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    return mapping.findForward("goodForward");
  }

  // line 374 "../../../GoodsAction.ump"
   public ActionForward goodSelect(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    List<Goods> list = null;
		list = dao.selectGoods();
		int pageNumber = list.size(); 
		int maxPage = pageNumber; 
		String number = request.getParameter("i");
		if (maxPage % 6 == 0) {
			maxPage = maxPage / 6;
		} else {
			maxPage = maxPage / 6 + 1;
		}
		if (number == null) {
			number = "0";
		}
		request.setAttribute("number", String.valueOf(number));
		request.setAttribute("maxPage", String.valueOf(maxPage));
		request.setAttribute("pageNumber", String.valueOf(pageNumber));
		request.setAttribute("list", list);
		return mapping.findForward("goodSelect");
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "action" + ":" + getAction()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "session" + "=" + (getSession() != null ? !getSession().equals(this)  ? getSession().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "goodsForm = "+(getGoodsForm()!=null?Integer.toHexString(System.identityHashCode(getGoodsForm())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "dao = "+(getDao()!=null?Integer.toHexString(System.identityHashCode(getDao())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "brand = "+(getBrand()!=null?Integer.toHexString(System.identityHashCode(getBrand())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "uploadFile = "+(getUploadFile()!=null?Integer.toHexString(System.identityHashCode(getUploadFile())):"null")
     + outputString;
  }
}