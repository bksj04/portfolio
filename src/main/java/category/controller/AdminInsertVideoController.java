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
public class AdminInsertVideoController {

	private final String command="/adminInsertVideo.category";
	private final String getPage="adminInsertVideoForm";
	private final String goPage="adminInsertDetailForm";
	
	@Autowired
	CategoryDao cdao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView doation() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView doAction( @Valid CategoryBean cb,BindingResult result,HttpServletRequest request,@RequestParam("file") MultipartFile file
			) {
		
		ModelAndView mav=new ModelAndView();	
		if(result.hasErrors() || file.isEmpty() ) {
			System.out.println("에러.");
			mav.setViewName(getPage);
			return mav;
		}
		String category=cb.getCategory();
		System.out.println(cb.getGrade());
		System.out.println(cb.getCategory());
		System.out.println(cb.getTitle());
		
		String root_path = request.getSession().getServletContext().getRealPath("/");  
	    String attach_path = "resources/images/poster/";
	    String filename = file.getOriginalFilename();
	    System.out.println(filename);
	    System.out.println(root_path + attach_path + filename);
	    File f = new File(root_path + attach_path + filename);
	    try {
	     file.transferTo(f);
	    } catch (Exception e) {
	     System.out.println(e.getMessage());
	    }  
	    cb.setImage(filename);
	    System.out.println(filename);
	    
	    int cnt = cdao.InsertVideo(cb);
	    CategoryBean ncb=cdao.selectTitle(cb.getTitle());
	    
	    if(cnt>0) {
	    	System.out.println(ncb.getNum());
	    	mav.addObject("cb",ncb);
	    	mav.setViewName(goPage);
	    }else {
	    	mav.setViewName(getPage);
	    }
	    
		return mav;
	}
	@Autowired
	DetailDao ddao;
	
	@RequestMapping(value="/adminLastInsertVideo.category",method=RequestMethod.POST)
	public ModelAndView goPage(@Valid DetailBean db,BindingResult result,CategoryBean cb) {
		ModelAndView mav=new ModelAndView();
		System.out.println("에러러");
		CategoryBean ncb=cdao.selectTitle(cb.getTitle());
		if(result.hasErrors()) {
			mav.addObject("cb",ncb);
			System.out.println("에러2.");
			mav.setViewName(goPage);
			return mav;
		}
		ddao.InsertVideo(db);
		
		mav.setViewName("redirect:/videoList.category");
		return mav;
	}
	
}
