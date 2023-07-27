package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Entity.phoneEntity;



public class PhoneDao {
	
	private Connection con;

	public PhoneDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean insert(phoneEntity pm) {
		
		boolean f=false;
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into phone values(?,?,?)");
			ps.setInt(1, pm.getId());
			ps.setString(2,pm.getName());
			ps.setString(3,pm.getPhone());
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean update(phoneEntity pm) {
		
		boolean f=false;
		
		try {
			PreparedStatement ps=con.prepareStatement("update phone set name=?, phone=? where id=?");
			ps.setString(1,pm.getName());
			ps.setString(2,pm.getPhone());
			ps.setInt(3,pm.getId());
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean delete(int id) {
		
		boolean f=false;
		
		try {
			PreparedStatement ps=con.prepareStatement("delete from phone where id=?");
			ps.setInt(1, id);
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public phoneEntity info(int id) {
		
		phoneEntity obj = new phoneEntity(); 
		try {
			PreparedStatement ps=((Connection) con).prepareStatement("select * from phone where id =?");
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setPhone(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
	}
	
	public List<phoneEntity > allData() {
		List<phoneEntity> lst=new ArrayList<phoneEntity>();
		phoneEntity obj=null;
		try {
			PreparedStatement ps=((Connection) con).prepareStatement("select * from phone");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				obj=new phoneEntity();
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setPhone(rs.getString(3));
				lst.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	
}
