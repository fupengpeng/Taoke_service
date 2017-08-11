package com.jiudianlianxian.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jiudianlianxian.domain.User;
import com.jiudianlianxian.entity.data.LoginData;
import com.jiudianlianxian.entity.result.LoginResult;
import com.jiudianlianxian.util.SqlHelper;

/**
 * 
 * Title: UsersService
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: ShoppingMall
 * @author fupengpeng
 * @date 2017年7月27日 下午3:06:00
 *
 */
public class UsersService {
	private static final int SUCCESS = 0;
	private static final int ERROR = 1;
	
	

	
	
	
	/**
	 * 
	 * Description: 登录
	 * @param user
	 * @return
	 */
	public LoginResult login (User user){
		LoginResult loginResult = new LoginResult();
		LoginData loginData = new LoginData();
		loginResult.setLoginData(loginData);
		String sql = "select * from user where phonenumber='"+user.getPhonenumber()+"' and password='"+user.getPassword()+"'";
		System.out.println("sql = "+sql);
		ResultSet rs = SqlHelper.executeQuery(sql);
		try {
			// 查询数据库,获取上述uid对应的数据
			if (rs.next()) {
				System.out.println("ssadfasdf"+rs.getString(5));
				while (rs.next()) {
					System.out.println(rs.getString(5));
					loginResult.setInfo(rs.getString(5).toString()); 
					loginResult.setCode(SUCCESS);
				}
			}else {
				loginResult.setInfo("登录失败"); 
				loginResult.setCode(ERROR);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("001");
			e.printStackTrace();
		}finally{
			System.out.println("002");
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}
		return loginResult;
		
	}
	
	
	/**
	 * 
	 * Description: 注册
	 * @param user
	 * @return
	 */
	public boolean register (User user){
		boolean b = true;
		String sql = "INSERT INTO user (phonenumber, password) VALUES ("+user.getPhonenumber()+", "+user.getPassword()+");";
		System.out.println("sql====" + sql);
		try {
			SqlHelper.executeUpdate(sql);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}
		return b;
		
	}
	
	/**
	 * 
	 * Description: 根据给定的phonenumber查询数据库数据
	 * @param phonenumber
	 * @return
	 */
	public boolean getVerificationCode (String phonenumber){
		boolean b = true;
		String sql = "select * from user where phonenumber='"+phonenumber+"'";
		System.out.println("sql = "+sql);
		ResultSet rs = SqlHelper.executeQuery(sql);
		try {
			// 查询数据库,获取上述uid对应的数据
			while (rs.next()) {
				System.out.println(rs.getString(5));
				
				if (rs.getString(5) != null) {
					b = false;
					System.out.println("获取到查询数据库的值");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("001");
			e.printStackTrace();
		}finally{
			System.out.println("002");
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}
		System.out.println("b = " + b);
		return b;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * Description: 根据给定的sex查询数据库数据
	 * @param uid
	 * @return
	 */
	public ArrayList<User>  getUserBySex (String sex){
		ArrayList<User> users = new ArrayList<User>();
		
		String sql = "select * from user where sex='"+sex+"'";
		System.out.println("sql = "+sql);
		ResultSet rs = SqlHelper.executeQuery(sql);
		try {
			// 查询数据库,获取上述uid对应的数据
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUid(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setPhonenumber(rs.getString(5));
				user.setLocation(rs.getString(6));
				user.setDetailedaddress(rs.getString(7));
				user.setPostcode(rs.getString(8));
				user.setBirthday(rs.getString(9));
				user.setWechat(rs.getString(10));
				user.setGrowthvalue(rs.getString(11));
				user.setAccount(rs.getString(12));
				user.setPassword(rs.getString(13));
				user.setIntegral(rs.getString(14));
				user.setIsdefaultaddress(rs.getString(15));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}
		
		return users;
		
	}
	
	/**
	 * 
	 * Description: 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user){
		boolean b = true;
		String sql = "INSERT INTO user("
				+ "id,uid,username,sex,phonenumber,"
				+ "location,detailedaddress,postcode,birthday,wechat,"
				+ "growthvalue,account,password,integral,isdefaultaddress) "
				+ "VALUES("
				+ user.getId()+","+user.getUid()+","+user.getUsername()+","+user.getSex()+","+user.getPhonenumber()+","
				+ user.getLocation()+","+user.getDetailedaddress()+","+user.getPostcode()+","+user.getBirthday()+","+user.getWechat()+","
				+ user.getGrowthvalue()+","+ user.getAccount()+","+user.getPassword()+","+user.getIntegral()+","+user.getIsdefaultaddress()+") ;";
		
//		String sql = "INSERT INTO user("
//				+ "id,uid,username,sex,phonenumber,"
//				+ "location,detailedaddress,postcode,birthday,wechat,"
//				+ "growthvalue,account,password,integral,isdefaultaddress) "
//				+ "VALUES(15,100115,'涵畅','女',15858585252,'陕西西安','西五路35号',65566,19990505,15858585252,545664,15858585252,100115,5485,false) ;";
		System.out.println("mysql = " + sql);
		try {
			SqlHelper.executeUpdate(sql);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * 
	 * Description: 修改用户
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user){
		boolean b = true;
		String sql = "UPDATE user SET "
				+ "username='"+user.getUsername()+"' , "
				+ "sex='"+user.getSex()+"' ,  "
				+ "phonenumber='"+user.getPhonenumber()+"' ,  "
				+ "location='"+user.getLocation()+"' ,  "
				+ "detailedaddress='"+user.getDetailedaddress()+"' ,  "
				+ "postcode='"+user.getPostcode()+"' ,  "
				+ "birthday='"+user.getBirthday()+"' ,  "
				+ "wechat='"+user.getWechat()+"' ,  "
				+ "growthvalue='"+user.getGrowthvalue()+"' ,  "
				+ "account='"+user.getAccount()+"' ,  "
				+ "password='"+user.getPassword()+"' ,  "
				+ "integral='"+user.getIntegral()+"' ,  "
				+ "isdefaultaddress='"+user.getIsdefaultaddress()+"' "
				+ "WHERE uid='"+user.getUid()+"';";
		try {
			SqlHelper.executeUpdate(sql);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}
		
		
		return b;
	}
	
	/**
	 * 
	 * Description: 根据给定的uid查询数据库数据
	 * @param uid
	 * @return
	 */
	public User getUserByUid (String uid){
		
		User user = new User();
		String sql = "select * from user where uid='"+uid+"'";
		ResultSet rs = SqlHelper.executeQuery(sql);
		try {
			// 查询数据库,获取上述uid对应的数据
			while (rs.next()) {
				
				user.setId(rs.getInt(1));
				user.setUid(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setPhonenumber(rs.getString(5));
				user.setLocation(rs.getString(6));
				user.setDetailedaddress(rs.getString(7));
				user.setPostcode(rs.getString(8));
				user.setBirthday(rs.getString(9));
				user.setWechat(rs.getString(10));
				user.setGrowthvalue(rs.getString(11));
				user.setAccount(rs.getString(12));
				user.setPassword(rs.getString(13));
				user.setIntegral(rs.getString(14));
				user.setIsdefaultaddress(rs.getString(15));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}
		
		return user;
		
	}

	/**
	 * 
	 * Description: 根据给定的uid刪除用戶
	 * @param uid
	 * @return
	 */
	public boolean delUser(String uid){
		boolean b = true;
		String sql = "delete from user where uid = '"+uid+"'";
		
		try {
			System.out.println("uid---"+uid);
			SqlHelper.executeUpdate(sql);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}
		
		return b;
	}
	/**
	 * 
	 * Description: 获取pageCount
	 * @param pageSize
	 * @return
	 */
	public int getPageCount(int pageSize) {
		int rowCount = 0;
		ResultSet rs = null;
		String sql = "SELECT * from user";

		try {
			rs = SqlHelper.executeQuery(sql);

			// 查询数据库,计算数据共有多少页
			while (rs.next()) {
				rowCount = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}
		return (rowCount - 1) / pageSize + 1;

	}

	/**     
	 * @return 
	 * Description:  按照分页来获取用户
	 * @param pageNow  当前页
	 * @param pageSize  当前页显示的数据数
	 * @return  用户数据对象集合
	 */
	public ArrayList<User> getUsersByPage(int pageNow, int pageSize) {
		ArrayList<User> al = new ArrayList<User>();

		String sql = "SELECT * from user WHERE id<=" + pageSize * pageNow
				+ " and id>=" + (pageSize * (pageNow - 1) + 1) + "; ";

		ResultSet rs = SqlHelper.executeQuery(sql);
		// 二次封装，将ResultSet---->User对象---->ArrayList集合
		try {
			while (rs.next()) {
				User user = new User();
				user.setUid(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPhonenumber(rs.getString(5));
				user.setLocation(rs.getString(6));
				user.setDetailedaddress(rs.getString(7));
				al.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}

		return al;
	}

	/**
	 * Description: 登录验证
	 * @param user
	 * @return  登录是否成功
	 */
	public boolean checkUser(User user) {

		boolean b = false;
		// //1.连接数据库
		// Connection ct = null;
		// PreparedStatement ps = null;
		// ResultSet rs = null;
		//
		// try {
		//
		// Class.forName("com.mysql.jdbc.Driver");
		// ct =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingmall",
		// "root", "root");
		// //SELECT * FROM user WHERE account='15858585959' and
		// password='100101'
		// // ps =
		// ct.prepareStatement("SELECT * from user WHERE 	account='"+user.getAccount()+"' and password='"+user.getPassword()+"'");
		// ps = ct.prepareStatement("SELECT * FROM user ");
		//
		// //给？赋值
		// rs = ps.executeQuery();
		//
		// if(rs.next()){
		// b = true;
		// }
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// 使用SqlHelper来实现数据库操作
		String sql = "SELECT * FROM user WHERE account = '"+user.getAccount()+"' AND password = '"+user.getPassword()+"';";
//		String sql = "SELECT * FROM user";
		ResultSet rs = SqlHelper.executeQuery(sql);
		try {
			if (rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}

		return b;
	}

}
