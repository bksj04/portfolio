package member.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberJjimDao {

	private String namespace="member.model.MemberJjimBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	public int insertJjim(MemberJjimBean jjim) {
		int cnt = sqlSessionTemplate.insert(namespace+".insertJjim",jjim);
		return cnt;
	}
	public int deleteJjim(MemberJjimBean jjim) {
		int cnt = sqlSessionTemplate.delete(namespace + ".deleteJjim",jjim);
		return cnt;
	}
	public List<MemberJjimBean> getByData(String member_id) {
		List<MemberJjimBean> mjlists = sqlSessionTemplate.selectList(namespace+".getByData",member_id);
		return mjlists;
	}
	public List<MemberJjimBean> getByMydata(String member_id){
		List<MemberJjimBean> cblists = sqlSessionTemplate.selectList(namespace+".getByMydata",member_id);
		return cblists;
	}
}
