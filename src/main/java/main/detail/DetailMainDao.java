package main.detail;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import category.detail.DetailBean;

@Component("MyDetailMainDao")
public class DetailMainDao {

	String namespace ="main.detail.DetailMainBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public DetailMainBean getOneData(int num) {
		DetailMainBean dmb = sqlSessionTemplate.selectOne(namespace+".getOneData",num);
		return dmb;
	}
	public List<DetailMainBean> getByGenre(String genre){
		List<DetailMainBean> dmblists = sqlSessionTemplate.selectList(namespace+".getByGenre",genre);
		return dmblists;	
	}
}
