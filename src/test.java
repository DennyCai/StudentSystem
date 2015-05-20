import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class test extends JFrame{
	
	Vector rd,cn;
	JTable jt=null;
	JScrollPane jsp=null;
	
	public static void main(String[] args) {
		test t=new test();
		
	}
	
	public test()
	{
		cn=new Vector();
		cn.add("学号");
		cn.add("名字");
		cn.add("性别");
		cn.add("年龄");
		cn.add("系别");
		
		rd=new Vector();
		Vector hang=new Vector();
		hang.add("x001");
		hang.add("XXOO");
		hang.add("男");
		hang.add("19");
		hang.add("电软");
		rd.add(hang);
		
		jt=new JTable(rd,cn);
		
		jsp=new JScrollPane(jt);
		
		this.add(jsp);
		
		this.setSize(300, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
