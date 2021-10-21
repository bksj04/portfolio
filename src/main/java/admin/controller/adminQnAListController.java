package admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cs.model.CsQnABean;
import cs.model.CsQnADao;
import utility.Paging;

@Controller
public class adminQnAListController {

	@Autowired
	CsQnADao cqdao;
	
	private final String command = "/qnaList.admin";
	private final String getPage = "adminMain";
	
	@RequestMapping(value=command)
	public ModelAndView doActionGet(@RequestParam(value="whatColumn",required = false) String whatColumn, 
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber", required = false) String pageNumber,
			@RequestParam(value="pageSize", required = false) String pageSize,
			HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn); // whatColumn=title
		map.put("keyword", "%"+keyword+"%"); // keyword=%a%

		int totalCount = cqdao.getTotalCount(map);
		String url = request.getContextPath()+command; 
		Paging pageInfo = new Paging(pageNumber,pageSize,totalCount,url,whatColumn,keyword, null);

		List<CsQnABean> lists = cqdao.getAllData(pageInfo,map);
		
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("totalCount", totalCount);
		
		String pageType = "qnaList";
		mav.addObject("pageType", pageType);
		
		mav.setViewName(getPage);
		return mav;
	}
}
