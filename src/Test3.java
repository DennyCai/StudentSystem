import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Test3 extends JFrame implements ActionListener{
	
	JPanel jp1=null,jp2=null;
	JTable jt=null;
	JButton jb1=null,jb2=null,jb3=null,jb4=null,jb5=null;
	JScrollPane jsp=null;
	JLabel jl=null;
	JTextField jtf=null;
	StuModel sm;
	
	
	
	
	public static void main(String[] args) {
		Test3 t3=new Test3();
	}
	
	public Test3()
	{
		
		
		jp1=new JPanel();
		jtf=new JTextField(10);
		jl=new JLabel("请输入名字：");
		jb1=new JButton("查询");
		jb1.setActionCommand("查询");
		jb1.addActionListener(this);
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2=new JPanel();
		jb2=new JButton("添加");
		jb2.setActionCommand("add");
		jb2.addActionListener(this);
		jb3=new JButton("修改");
		jb3.setActionCommand("update");
		jb3.addActionListener(this);
		jb4=new JButton("删除");
		jb4.setActionCommand("del");
		jb4.addActionListener(this);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		
		StuModel sm=new StuModel();
		
		jt=new JTable(sm);
		jsp=new JScrollPane(jt);
		
		this.add(jsp,BorderLayout.CENTER);
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.setTitle("学生信息管理系统");
		this.setSize(300, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getActionCommand())
		{
		case "查询":
			String name=jtf.getText().trim();
			String sql="select * from stu where stuName='"+name+"'";
			sm=new StuModel(sql);
			jt.setModel(sm);
			break;
		case "add":
			StuAdd sa=new StuAdd(this,"添加学生信息",true);
			sm=new StuModel();
			jt.setModel(sm);
			break;
		case "update":
			int sr=jt.getSelectedRow();
			if(sr!=-1)
			{
				sm=new StuModel();
				stuUp su=new stuUp(this, "修改学生信息", true, sm,sr );
			}
			else{
				JOptionPane.showMessageDialog(this, "请选择要修改的一项。");
				return;
			}
			sm=new StuModel();
			jt.setModel(sm);
			break;
		case "del":
			int r=jt.getSelectedRow();
			if(r==-1)
			{	
				JOptionPane.showMessageDialog(this, "请选择要删除的一项。");
				return;
			}
			String did=(String)(jt.getValueAt(r, 0));
			String del="delete stu where stuId='"+did+"'";
			new StuModel(del);
			jt.setModel(new StuModel());
			break;
		}
	}
	
	
	
	
	
	
	

}
