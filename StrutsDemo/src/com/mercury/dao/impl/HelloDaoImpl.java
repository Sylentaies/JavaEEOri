package com.mercury.dao.impl;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;
import com.mercury.util.JdbcUtil;

public class HelloDaoImpl implements HelloDao {
	Connection conn = JdbcUtil.getConnection();
	

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		try{
			String sp = "{? = call saveUser(?,?)}";
			CallableStatement cs = conn.prepareCall(sp);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, user.getName());
			cs.setInt(3, user.getAge());
			cs.execute();
			System.out.println("Returned value: "+ cs.getInt(1));
		}catch (Exception e){
			e.printStackTrace();
		}
	
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		try{
			String sql = "update sample set age = ? where name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getAge());
			ps.setString(2, user.getName());
			ps.execute();
		}catch(Exception e ){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		try{
			String sql = "delete from sample where age = ? and name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getAge());
			ps.setString(2, user.getName());
			ps.execute();
		}catch(Exception e ){
			e.printStackTrace();
		}

		

	}

	@Override
	public List<User> queryAll() {
		List<User> list = new ArrayList<User>();
		try{
			String sp = "{? = call queryUser()}";
			CallableStatement cs = conn.prepareCall(sp);
			cs = conn.prepareCall(sp);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet)cs.getObject(1);
			while(rs.next()){
				list.add(new User(rs.getString("name"),rs.getInt("age")));
			}
			rs.close();
		}catch(Exception e ){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User loadUserByName(String name) {
		User user = new User();
		try{
			String sql = "select * from sample where name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
			}
			rs.close();
		}catch(Exception e ){
			e.printStackTrace();
		}
		return user;
	}

}
