package video.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class video_cDao {

private String namespace="video.model.video_cBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public video_cBean getByVideo_cInfo(int num) {
		video_cBean vcb = sqlSessionTemplate.selectOne(namespace+".getByVideo_cInfo",num);
		return vcb;
	}
}
