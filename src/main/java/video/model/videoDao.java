package video.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class videoDao {

private String namespace="video.model.videoBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public videoBean getByVideoInfo(int num) {
		videoBean vbean = sqlSessionTemplate.selectOne(namespace+".getByVideoInfo",num);
		return vbean;
	}
	public int watchCountUp(int num) {
		int cnt = sqlSessionTemplate.update(namespace+".watchCountUp",num);
		return cnt;
	}
	public List<videoBean> getAllData(){
		List<videoBean> vlists = sqlSessionTemplate.selectList(namespace+".getAllData");
		return vlists;
	}
	public List<videoBean> getAllDataHot(){
		List<videoBean> hlists = sqlSessionTemplate.selectList(namespace+".getAllDataHot");
		return hlists;
	}
	public int jjimCountUp(int num) {
		int cnt = sqlSessionTemplate.update(namespace+".jjimCountUp",num);
		return cnt;
	}
	public int jjimCountDown(int num) {
		int cnt = sqlSessionTemplate.update(namespace+".jjimCountDown",num);
		return cnt;
	}
	public List<videoBean> getAllDataJjim() {
		List<videoBean> jlists = sqlSessionTemplate.selectList(namespace+".getAllDataJjim");
		return jlists;
	}
}
