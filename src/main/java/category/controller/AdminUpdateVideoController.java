package category.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import category.detail.DetailBean;
import category.detail.DetailDao;
import category.model.CategoryBean;
import category.model.CategoryDao;


@Controller
public class AdminUpdateVideoController {
	private final String command="/updateVideo.category";
	private final String getPage="adminUpdateVideoForm";
	private final String gotoPage="adminUpdateVideoDetailForm";
	
	@Autowired
	CategoryDao cdao;
	
	@Autowired
	DetailDao ddao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView doation(@RequestParam("num")int num,
			 @RequestParam("pageNumber") int pageNumber) {
		
		ModelAndView mav = new ModelAndView();
		
		CategoryBean cb =cdao.selectNum(num); 
		
		mav.addObject("cb",cb);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView doAction(@RequestParam("file") MultipartFile file,CategoryBean cb,HttpServletRequest request) {
		
		ModelAndView mav=new ModelAndView();
				
		String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/images/poster/";
	    String filename = file.getOriginalFilename();
	    int cnt = 0;
		if(filename != null && !filename.equals("")) {
			System.out.println("�궗吏� 諛붽퓞");
			new File(root_path + attach_path + filename).delete();				
			File f = new File(root_path + attach_path + filename);
			try {
			     file.transferTo(f);
			    } catch (Exception e) {
			     System.out.println(e.getMessage());
			    }  
			cb.setImage(filename);	
			cnt = cdao.UpdateVideo(cb);
		}else {
			
			System.out.println("�궗吏� �븞諛붽퓞");
			cb.setImage(filename);		 			  
			cnt = cdao.UpdateNoVideo(cb);
		 }	
	
	    System.out.println(filename);
	    
	    System.out.println("�뾽�뜲�씠�듃");
	    CategoryBean ncb= cdao.selectNum(cb.getNum());  
	    if(cnt>0) {
	    	System.out.println("�뾽�뜲�씠�듃�꽦怨�");
	    	System.out.println(ncb.getNum());
	    	DetailBean db = ddao.getOneData(ncb.getNum()); 	  
	    	System.out.println(cb.getGrade());
			System.out.println(cb.getCategory());
			System.out.println(cb.getTitle());
	    	mav.addObject("cb",ncb);
	    	mav.addObject("db",db);	    	
	    	mav.setViewName(gotoPage);
	    }else {
	    	System.out.println("�떎�뙣");
	    	mav.setViewName(getPage);
	    }
	    
		return mav;
	}
	
	  @RequestMapping(value="/adminLastUpdateVideo.category",method=RequestMethod.POST)
	  public ModelAndView goPage(DetailBean db,CategoryBean cb, BindingResult result) {
		  
		  ddao.updateData(db);
		  ModelAndView mav=new ModelAndView();
			mav.setViewName("redirect:/videoList.category");
			return mav;
	 }
	 
}
