package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlHelper {

	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String url="jdbc:microsoft:sqlserver://localhost:1433;databaseName=exb"
			,dir="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	String user="sa",passwd="yl";
	
	public ResultSet query(String sql,String paras[])
	{
		try {
			Class.forName(dir);
			ct=DriverManager.getConnection(url,user,passwd);
			ps=ct.prepareStatement(sql);
			if(paras!=null)
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public boolean Update(String sql,String paras[])
	{
		boolean b =true;
		
		try {
			Class.forName(dir);
			ct=DriverManager.getConnection(url,user,passwd);
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			if(ps.executeUpdate()!=1)
			{
				b=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			b=false;
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}
	
	public void close()
	{
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(ct!=null)
				ct.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
