import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class stuUp extends JDialog implements ActionListener{
	JLabel jl1=null,jl2=null,jl3=null,jl4=null,jl5=null;
	JTextField jtf1=null,jtf2=null,jtf3=null,jtf4=null,jtf5=null;
	JButton jb1=null,jb2=null;
	
	public stuUp(Frame f,String t,boolean model,StuModel sm,int row)
	{
		super(f,t,model);
		
		
		
		jl1=new JLabel("学生学号：");
		jl2=new JLabel("学生姓名：");
		jl3=new JLabel("学生性别：");
		jl4=new JLabel("学生年龄：");
		jl5=new JLabel("学生学系：");
		
		jtf1=new JTextField(10);
		jtf1.setText((String)sm.getValueAt(row, 0));
		jtf1.setEditable(false);
		jtf2=new JTextField(10);
		jtf2.setText((String)sm.getValueAt(row, 1));
		jtf3=new JTextField(10);
		jtf3.setText((String)sm.getValueAt(row, 2));
		jtf4=new JTextField(10);
		int age=(int)sm.getValueAt(row, 3);
		jtf4.setText(String.valueOf(age));
		jtf5=new JTextField(10);
		jtf5.setText((String)sm.getValueAt(row, 4));
		
		jb1=new JButton("修改");
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
			String upd=
			"update stu set stuName='"+jtf2.getText()+"',stuSex='"+jtf3.getText()+"',stuAge='"+Integer.parseInt(jtf4.getText())+
			"',stuDept='"+jtf5.getText()+"' where stuId='"+jtf1.getText()+"'";
			new StuModel().update(upd);
			this.dispose();
			break;
		case "exit":
			this.dispose();
			break;
		}
	}
}
