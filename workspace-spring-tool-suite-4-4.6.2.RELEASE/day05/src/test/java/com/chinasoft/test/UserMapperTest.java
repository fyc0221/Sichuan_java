package com.chinasoft.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.chinasoft.mapper.UserMapper;
import com.chinasoft.pojo.User;
import com.chinasoft.util.SessionUtil;

public class UserMapperTest {
	public SqlSessionFactory factory = SessionUtil.getSession();
	@Test
	public void addUserNoPar() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.addUserNoPar();
		session.commit();
		session.close();
	}
	@Test
	public void addUserByPar() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User(35, "榛庢槑", "liming111", "6666666", "鍙版咕鏂扮", "723872387@qq.com", 1);
		mapper.addUserByPar(user);
		session.commit();
		session.close();
	}

	@Test
	public void selectOneByPar() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.selectOneByPar(5);//绗竴娆℃墽琛宻ql璇彞
		System.out.println(user);
		session.clearCache();//娓呴櫎涓�绾х紦瀛�
		User user1 = mapper.selectOneByPar(5);//绗簩娆℃墽琛宻ql璇彞
		System.out.println(user);
		session.close();
		System.out.println(user == user1);
	}

	@Test
	 public void selectOneByParCache() {

	  SqlSession session = factory.openSession();
	  UserMapper mapper = session.getMapper(UserMapper.class);
	  User user = mapper.selectOneByPar(5);// 绗竴娆℃墽琛宻ql璇彞 System.out.println(user);
	  System.out.println(user);
	  session.close();

	  SqlSession session1 = factory.openSession();
	  UserMapper mapper1 = session1.getMapper(UserMapper.class);
	  User user1 = mapper1.selectOneByPar(5);// 绗竴娆℃墽琛宻ql璇彞
	  System.out.println(user1);
	  session1.close();

	  System.out.println(user == user1);

	 }
	@Test
	public void selectAll() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectAll();
		for (User user : list) {
			System.out.println(user);
		}
		session.close();
	}

	@Test
	public void selectLogin() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("lol");
		user.setPassword("123456");
		User user1 = mapper.selectLogin(user);
		System.out.println(user1);
		session.close();
	}

	@Test
	public void selectOrderBy() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = mapper.selectOrderBy("username");
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	@Test
	public void findUserWith_if() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("lol");
		user.setPassword("123456");
		User user1 = mapper.findUserWith_if(user);
		System.out.println(user1);
		session.close();
	}
	
	//娴嬭瘯鍔ㄦ�乨ql_foreach
	@Test
	public void findUsersWithList() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(6);
		List<User> users = mapper.findUsersWithList(list);
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	 @Test
	 public void findUserByPage(){
		 SqlSession session = factory.openSession();
		 UserMapper mapper = session.getMapper(UserMapper.class);
		 Map<String,Integer> map = new HashMap<String,Integer>();
		 map.put("index", 0);
		 map.put("size", 5);
		 List<User> list = mapper.findUserByPage(map);
		 for(User u:list){
			 System.out.println(u);
		 }
	}
	@Test
	public void addUserSelective() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setPhone("110");
		user.setUsername("榛勬槑鏄�");
		user.setPassword("20020219");
		System.out.println(user);
		mapper.addUserSelective(user);
		session.commit();
		session.close();
	}
	 
	public static void main(String[] args) {
		// new UserMapperTest().addUserNoPar();
		// new UserMapperTest().addUserByPar();
		// new UserMapperTest().selectOneByPar();
		// new UserMapperTest().selectOneByPar();
		new UserMapperTest().selectAll();
		
		System.out.println("我们已经合并了");

	}

	

}
