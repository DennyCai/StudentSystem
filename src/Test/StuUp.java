package Test;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class StuUp extends JDialog implements ActionListener{
	JLabel jl1=null,jl2=null,jl3=null,jl4=null,jl5=null;
	JTextField jtf1=null,jtf2=null,jtf3=null,jtf4=null,jtf5=null;
	JButton jb1=null,jb2=null;
	
	public StuUp(Frame f,String t,boolean model,StuModel sm,int row)
	{
		super(f,t,model);
		
		
		
		jl1=new JLabel("ѧ��ѧ�ţ�");
		jl2=new JLabel("ѧ��������");
		jl3=new JLabel("ѧ���Ա�");
		jl4=new JLabel("ѧ�����䣺");
		jl5=new JLabel("ѧ��ѧϵ��");
		
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
		
		jb1=new JButton("�޸�");
		jb1.setActionCommand("add");
		jb1.addActionListener(this);
		jb2=new JButton("����");
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
			String sql="update stu set stuName=?,stuSex=?,stuAge=?,stuDept=? where stuId=?";
			String paras[]={jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf1.getText()};
			StuModel temp=new StuModel();
			if(!temp.updStu(sql, paras))
			{	
				JOptionPane.showMessageDialog(this, "�޸�ѧ����Ϣʧ�ܣ�");
				return;
			}
			this.dispose();
			break;
		case "exit":
			this.dispose();
			break;
		}
	}
}
