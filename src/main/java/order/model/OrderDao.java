package order.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import member.model.MemberBean;
import utility.Paging;

@Component
@Repository
public class OrderDao {
	
	private String namespace="order.model.OrderBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<OrderBean> selectAll(Paging pageInfo, Map<String, String> map) {
		List<OrderBean> lists = new ArrayList<OrderBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace + ".selectAll", map, rowBounds);
		return lists;
	}
	
	public int setInsertOrder(OrderBean ob) {
		System.out.println("1234567");
		int cnt=sqlSessionTemplate.insert(namespace+".insertOrder", ob);
		return cnt;
	}
	
	public int updateData(OrderBean ob) {
		return sqlSessionTemplate.update(namespace+".updateData",ob);
	}
	public OrderBean getOneData(int mnum) {
		OrderBean ob=sqlSessionTemplate.selectOne(namespace+".getOneData",mnum);
		return ob;
	}
	
	public int OrderCheck(int mnum) {
		int cnt = sqlSessionTemplate.selectOne(namespace+".OrderCheck",mnum);
		return cnt;
	}
	
}
