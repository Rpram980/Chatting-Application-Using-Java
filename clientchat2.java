import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.net.*;
import java.io.*;
class proh
{
	public static void main(String [] args)
	{
		new gui2();
}
}

class gui2 extends JFrame implements ActionListener
{
	
	JFrame f;
	JLabel l1,l2,l3;
	JPanel p;
	JButton b2;
	JButton bs;
	JTextField n1,n2,n3;
	JTextArea n11,n12;
	static BufferedReader stdin,in;
	static PrintStream out;
	static gui4 g;
	int flag=0;
	String str="";
	Recv R=new Recv();
	gui2()
	{
		g=new gui4();
	    f=new JFrame();
		f.setSize(500,300);
		f.setLayout(null);
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(20,5,300,350);
		n1=new JTextField(100);
		n1.setBounds(100,5,200,30);
		n2=new JTextField(30);
		n2.setBounds(100,55,200,30);
		n3=new JTextField(20);
		n3.setBounds(100,105,200,30);
		b2=new JButton("connect");
		b2.setBounds(140,160,100,30);
		b2.addActionListener(this);
		bs.addActionListener(this);
		
		l1=new JLabel("Name");
		l1.setBounds(0,5,100,30);
		l2=new JLabel ("Enter IP address");
		l2.setBounds(0,45,100,50);
		l3=new JLabel ("Enter port num");
		l3.setBounds(0,95,100,50);
		p.add(l1);
		p.add(n1);
		p.add(l2);
		p.add(n2);
		p.add(l3);
		p.add(n3);
		p.add(b2);
		f.add(p);
		f.setVisible(true);
		
        
	}
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b2)
	{	
		int i=func();
		if(i==1)
		{
			f.setVisible(false);
		    g.f.setVisible(true);
			R.start();
		}
		else
		{
			JOptionPane.showMessageDialog(f,"Not Conneced!!!");
		}
	}
	if(ae.getSource()==bs)
	{	
		String str1=n12.getText();
		n11.setText(n11.getText()+"\r\n"+"Client::::"+str1);
		out.println(str1);
		n12.setText("");
	}
}



int func()
{
	int port1=Integer.parseInt(n3.getText());
	String ip=n2.getText();
	try
	{
		Socket s=new Socket(ip,port1);
		out=new PrintStream(s.getOutputStream());
		stdin= new BufferedReader(new InputStreamReader(s.getInputStream()));
		flag=1;
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	return(flag);
}
class Recv extends Thread
{
	public void run()
	{
	try
	{
		str=stdin.readLine();
		if(str.length()>0&& str!=null)
		{
			n11.setText(n11.getText()+"\r\n"+"Server:::"+str);
			str="";
		}

	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	new Recv().start();
	}
}

class gui4 extends JFrame
{
	JScrollPane sp,dp;
	JFrame f;
	JPanel p;
	
	JRadioButton b3;
	
	gui4()
	{
	    f=new JFrame();
		f.setVisible(false);
		f.setTitle("Client");
		f.setSize(600,800);
		f.setLayout(null);
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(20,5,500,650);
		n11=new JTextArea();
		sp=new JScrollPane(n11,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setBounds(0,10,450,550);
		n12=new JTextArea();
		dp=new JScrollPane(n12,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		dp.setBounds(0,560,300,70);
		bs=new JButton("SEND");
		bs.setBounds(340,560,100,50);
		
		b3=new JRadioButton("connected");
		b3.setBounds(700,700,10,10);
		p.add(b3);
		p.add(bs);
		p.add(sp);
		p.add(dp);
		f.add(p);
	
	}
}
}
