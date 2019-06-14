package com.cdac.singer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cdac.singer.model.Singer;
import com.cdac.singer.util.DBConnection;

public class SingerDaoImpl implements SingerDao{

	@Override
	public boolean insert(Singer s) {
		Connection con=null;
		String query="insert into singer values(default,?,?,?)";
		
		con=DBConnection.getConnection();
		System.out.println(con);
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,s.getId());
			pst.setString(2, s.getName());
			pst.setString(3, s.getType());
			
			int r=pst.executeUpdate();
			if(r==1)
			{
				System.out.println("Record Inserted");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}

	@Override
	public boolean validate(Singer s) {
		Connection con1=DBConnection.getConnection();
		String q="select id from singer where id=?";
		
		try {
			PreparedStatement pst=con1.prepareStatement(q);
			pst.setInt(1, s.getId());
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
