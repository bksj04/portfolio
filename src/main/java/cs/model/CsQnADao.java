package cs.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class CsQnADao {

private String namespace = "cs.model.CsQnABean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int writeQuestions(CsQnABean cqb) {
		int cnt = sqlSessionTemplate.insert(namespace+".writeQuestions",cqb);
		return cnt;
	}
	public int getTotalCount(Map<String,String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+".getTotalCount",map);
		return cnt;
	}
	public List<CsQnABean> getAllData(Paging pageInfo,Map<String,String> map){
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<CsQnABean> lists = sqlSessionTemplate.selectList(namespace+".getAllData",map,rowBounds);
		return lists;
	}
	public CsQnABean getOneData(int num) {
		CsQnABean cqb = sqlSessionTemplate.selectOne(namespace+".getOneData",num);
		return cqb;
	}
	public int writeAnswer(CsQnABean cqb) {
		int cnt = sqlSessionTemplate.insert(namespace+".writeAnswer",cqb);
		return cnt;
	}
	public List<CsQnABean> getByData(String writer){
		List<CsQnABean> lists = sqlSessionTemplate.selectList(namespace+".getByData",writer);
		return lists;
	}
	public int getByTotalCount(String writer) {
		int count = sqlSessionTemplate.selectOne(namespace+".getByTotalCount",writer);
		return count;
	}
	public int deleteData(int num) {
		int cnt = sqlSessionTemplate.delete(namespace+".deleteData",num);
		return cnt;
	}
}
