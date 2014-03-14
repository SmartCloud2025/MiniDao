package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.spring.SpringTxTestCase;
import examples.dao.JeecgDemoDao;
import examples.entity.JeecgDemo;

/**
 * 单元测试
 * MiniDao支持实体维护
 * 
 * @author yanping.shi
 * 
 */
public class JeecgDemoDaoJunit extends SpringTxTestCase {

	@Autowired
	private JeecgDemoDao jeecgDemoDao;
	
	String  id = "402880e740a622870140a6228ac00000";
	
	
	@Test
	public void testInsert() {
		JeecgDemo jeecgDemo = new JeecgDemo();
		jeecgDemo.setAge(30);
		jeecgDemo.setBirthday(new Date());
		jeecgDemo.setUserName("张代浩111");
		jeecgDemoDao.saveByHiber(jeecgDemo);
		id = jeecgDemo.getId();
	}

	//@Test
	public void testUpdate() {
		JeecgDemo jeecgDemo = new JeecgDemo();
		jeecgDemo.setId(id);
		jeecgDemo.setAge(90);
		jeecgDemo.setBirthday(new Date());
		jeecgDemo.setUserName("李四");
		jeecgDemoDao.updateByHiber(jeecgDemo);
	}


	//@Test
	public void testGetEntity() {
		JeecgDemo jeecgDemo = jeecgDemoDao.getByIdHiber(JeecgDemo.class,id);
		if(jeecgDemo!=null){
			logger.info("-------------testGetEntity() -------------"+jeecgDemo.getAge()+"       "+jeecgDemo.getUserName());
		}
	}

	//@Test
	public void testDelete() {
		JeecgDemo jeecgDemo = new JeecgDemo();
		//删除必须带上ID
		jeecgDemo.setId(id);
		jeecgDemoDao.deleteByHiber(jeecgDemo);
	}
	
	
	//@Test
	public void testDeleteById() {
		jeecgDemoDao.deleteByIdHiber(JeecgDemo.class, id);
	}
	

	@Test
	public void testListAll() {
		JeecgDemo jeecgDemo = new JeecgDemo();
		List<JeecgDemo> list = jeecgDemoDao.listByHiber(jeecgDemo);
		for(JeecgDemo po:list){
			logger.info(po.getUserName());
		}
	}

}
