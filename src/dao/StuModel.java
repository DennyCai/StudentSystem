package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class StuModel extends AbstractTableModel{
	Vector rd,cn,hang;
	
	
	public StuModel()
	{
		
	}
	
	public void queryStu(String sql,String paras[])
	{
		SqlHelper sh=null;
		
		rd=new Vector();
		cn=new Vector();
		cn.add("学号");
		cn.add("名字");
		cn.add("性别");
		cn.add("年龄");
		cn.add("系别");
		
		try {
			sh=new SqlHelper();
			ResultSet rs=sh.query(sql, paras);
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sh.close();
		}
	
	}
	public boolean upStu(String sql,String paras[])
	{
		SqlHelper sh=new SqlHelper();
		return sh.Update(sql, paras);
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
