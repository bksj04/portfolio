package many.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ManyDao {

	private String namespace="many.model.ManyBean";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<ManyBean> selectMany() {
		List<ManyBean> many=new ArrayList<ManyBean>();
		many = sqlSessionTemplate.selectList(namespace + ".selectMany");
		return many;
	}
	
	
}
