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
		cn.add("ѧ��");
		cn.add("����");
		cn.add("�Ա�");
		cn.add("����");
		cn.add("ϵ��");
		
		rd=new Vector();
		Vector hang=new Vector();
		hang.add("x001");
		hang.add("XXOO");
		hang.add("��");
		hang.add("19");
		hang.add("����");
		rd.add(hang);
		
		jt=new JTable(rd,cn);
		
		jsp=new JScrollPane(jt);
		
		this.add(jsp);
		
		this.setSize(300, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
