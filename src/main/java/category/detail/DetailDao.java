package category.detail;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DetailDao {
	
	String namespace="category.detail.DetailBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public DetailBean getOneData(int num) {
		DetailBean db = sqlSessionTemplate.selectOne(namespace+".getOneData",num);
		return db;
	}
	public List<DetailBean> getByGenre(String genre){
		List<DetailBean> dblists = sqlSessionTemplate.selectList(namespace+".getByGenre",genre);
		return dblists;	
	}
	public int insertData(DetailBean db) {
		int cnt = sqlSessionTemplate.insert(namespace+".insertData",db);
		return cnt;
	}
	public int updateData(DetailBean db) {
		int cnt = sqlSessionTemplate.update(namespace+".updateData",db);
		return cnt;
	}
}



