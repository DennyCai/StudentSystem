package dao;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class StuAdd extends JDialog implements ActionListener{
	JLabel jl1=null,jl2=null,jl3=null,jl4=null,jl5=null;
	JTextField jtf1=null,jtf2=null,jtf3=null,jtf4=null,jtf5=null;
	JButton jb1=null,jb2=null;
	
	public StuAdd(Frame f,String t,boolean model)
	{
		super(f,t,model);
		
		
		jl1=new JLabel("学生学号：");
		jl2=new JLabel("学生姓名：");
		jl3=new JLabel("学生性别：");
		jl4=new JLabel("学生年龄：");
		jl5=new JLabel("学生学系：");
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		jtf4=new JTextField(10);
		jtf5=new JTextField(10);
		
		jb1=new JButton("确认");
		jb1.setActionCommand("add");
		jb1.addActionListener(this);
		jb2=new JButton("返回");
		jb2.setActionCommand("exit");
		jb2.addActionListener(this);
		
		this.setLayout(new FlowLayout());
		this.add(jl1);
		this.add(jtf1);
		this.add(jl2);
		this.add(jtf2);
		this.add(jl3);
		this.add(jtf3);
		this.add(jl4);
		this.add(jtf4);
		this.add(jl5);
		this.add(jtf5);
		this.add(jb1);
		this.add(jb2);
		
		this.setSize(230, 220);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getActionCommand()) 
		{
		case "add":
			StuModel temp=new StuModel();
			String sql="insert into stu values(?,?,?,?,?)";
			String paras[]={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText()};
			if(!temp.upStu(sql, paras))
			{	
				new JOptionPane().showMessageDialog(this, "添加学生信息失败！");
			}
			this.dispose();
			break;
		case "exit":
			this.dispose();
			break;
		}
	}
	
	
}
