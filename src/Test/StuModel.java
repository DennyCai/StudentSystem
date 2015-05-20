package Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class StuModel extends AbstractTableModel{
	Vector rd,cn,hang;
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String url="jdbc:microsoft:sqlserver://localhost:1433;databaseName=exb"
			,dir="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	String user="sa",passwd="yl";
	
	public StuModel()
	{
		init("");
	}
	
	public StuModel(String sql)
	{
		init(sql);
	}
	
	public void init(String sql)
	{
		rd=new Vector();
		cn=new Vector();
		cn.add("学号");
		cn.add("名字");
		cn.add("性别");
		cn.add("年龄");
		cn.add("系别");
		
		try {
			Class.forName
			("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			ct=DriverManager.getConnection
			("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=exb", "sa","yl");
			if(sql=="")
			{	ps=ct.prepareStatement("select * from stu");
				rs=ps.executeQuery();
				while(rs.next())
				{
					hang=new Vector();
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					hang.add(rs.getString(3));
					hang.add(rs.getInt(4));
					hang.add(rs.getString(5));
					rd.add(hang);
				}
			}
			else 
			{	
				ps=ct.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next())
				{
					hang=new Vector();
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					hang.add(rs.getString(3));
					hang.add(rs.getInt(4));
					hang.add(rs.getString(5));
					rd.add(hang);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
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
	
	
	public boolean updStu(String sql,String paras[])
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
		
		return b;
	}
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
		return this.cn.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		return rd.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		
		return ((Vector)rd.get(row)).get(col);
	}


	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)(cn.get(column));
	}

}
