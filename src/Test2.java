import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Test2 extends JFrame{
	
	Vector rd,cn;
	JTable jt=null;
	JScrollPane jsp=null;
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public static void main(String[] args) {
		Test2 t=new Test2();
	}
	public Test2()
	{
		cn=new Vector();
		cn.add("学号");
		cn.add("名字");
		cn.add("性别");
		cn.add("年龄");
		cn.add("系别");
		
		rd=new Vector();
		
		try {
			Class.forName
			("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			ct=DriverManager.getConnection
			("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=exb", "sa","yl");
			ps=ct.prepareStatement("select * from stu");
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Vector hang=new Vector();
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
		
		
		
		
		
		
		jt=new JTable(rd,cn);
		
		jsp=new JScrollPane(jt);
		
		this.add(jsp);
		
		this.setSize(300, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
