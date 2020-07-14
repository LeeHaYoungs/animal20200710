<<<<<<< HEAD
package base;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameEnroll {
	public static void main(String[] args) {
		
		Frame f=new Frame("������� ������");
		f.setBounds(0,100,400,600);
        f.setBackground(Color.lightGray);
        f.setLayout(new BorderLayout());
        
        Font fontTitle=new Font(Font.SANS_SERIF,Font.BOLD,24);
        Font fontCon=new Font("���� ���",Font.PLAIN,16);
        
        Panel pCon = new Panel();
        pCon.setLayout(null);
        pCon.setSize(400,600);
        
        Panel pTitle=new Panel();
        pTitle.setSize(400, 50);
        Label title=new Label("�������(��)");
        pTitle.setBackground(Color.pink);
        pTitle.setFont(fontTitle);
        pTitle.setLocation(0, 30);
        pTitle.add(title);
        f.add(pTitle);
		
        Panel pConL = new Panel();
        pConL.setSize(120, 400);
        pConL.setLocation(50, 90);
        Label animalname=new Label("������ : ",Label.RIGHT);
        pConL.add(animalname);
        Label animalgender=new Label("�������� : ",Label.RIGHT);
        pConL.add(animalgender);
        Label animalcate=new Label("���� : ",Label.RIGHT);
        pConL.add(animalcate);
        Label animalage=new Label("���� ���� : ",Label.RIGHT);
        pConL.add(animalage);
        Label genderless =new Label("�߼�ȭ���� : ",Label.RIGHT);
        pConL.add(genderless);
        Label name=new Label("��ȣ�ڸ� : ",Label.RIGHT);
        pConL.add(name);
        Label phone=new Label("��ȣ�ڿ���ó : ",Label.RIGHT);
        pConL.add(phone);
        
        pCon.add(pConL);
        
        Panel pConR = new Panel();
        pConR.setSize(190, 400);
        pConR.setLocation(150, 90);
        
        TextField animalnameA=new TextField(18);
        pConR.add(animalnameA);
        CheckboxGroup rGroup1= new CheckboxGroup();
        Checkbox M=new Checkbox("����",rGroup1,true);
        Checkbox FM=new Checkbox("����",rGroup1,false); 
        TextField animalgenderA=new TextField(18);
        TextField animalageA=new TextField(18);
        pConR.add(M); 
        pConR.add(FM);
        pConR.add(animalgenderA);
        pConR.add(animalageA);
        CheckboxGroup rGroup2= new CheckboxGroup();
        Checkbox genderX=new Checkbox("��",rGroup2,true);
        Checkbox genderO=new Checkbox("��",rGroup2,false); 
        pConR.add(genderX); 
        pConR.add(genderO);
        TextField nameA=new TextField(18);
        TextField phoneA=new TextField(18);
        pConR.add(nameA);
        pConR.add(phoneA);
        
        pCon.add(pConR);
		
        Button btn1 = new Button("���");
        Button btn2 = new Button("���");
        btn1.setSize(200, 50);
        btn1.setLocation(0,515);
        btn2.setSize(200, 50);
        btn2.setLocation(201,515);
        pCon.add(btn1);
        pCon.add(btn2);
        
        f.add(pCon);
		
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
=======
package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;

public class FrameEnroll {
   public static void main(String[] args) {

      Frame f=new Frame("������� ������");
      f.setSize(400, 600);
      //f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
      GridLayout grid = new GridLayout(10,2);
      grid.setVgap(5);//�׸��� ���� ���� ���� 5
      
      f.setLayout(grid);
      
      Label la=new Label("�������(��)");
      Font font=new Font("���� ���",Font.BOLD,20);
      la.setFont(font);
      f.add(la);
      
      //������
      Panel p1 = new Panel();

      Label la2=new Label("������");
      TextField tf2=new TextField(20);
      
      p1.setLayout(new FlowLayout());
      p1.add(la2,BorderLayout.WEST);
      p1.add(tf2);
      
      Font font2=new Font("���� ���",Font.PLAIN,15);
      
      la2.setFont(font2);
      tf2.setFont(font2);

      f.add(p1);
      
      //���� ����
      Box b3=Box.createHorizontalBox();
      Label la3=new Label("���� ����");
      CheckboxGroup group=new CheckboxGroup();
      Checkbox s1=new Checkbox("����",group,true);
      Checkbox s2=new Checkbox("����",group,false);
      la3.setFont(font2);
      s1.setFont(font2);
      s2.setFont(font2);
      b3.add(la3);
      b3.add(s1);
      b3.add(s2);
      f.add(b3);
      
      Box b4=Box.createHorizontalBox();
      Label la4=new Label("����");
      TextField tf4=new TextField(20);
      la4.setFont(font2);
      tf4.setFont(font2);
      b4.add(la4);
      b4.add(tf4);
      f.add(b4);
      
      Box b5=Box.createHorizontalBox();
      Label la5=new Label("���� ����");
      TextField tf5=new TextField(20);
      la5.setFont(font2);
      tf5.setFont(font2);
      b5.add(la5);
      b5.add(tf5);
      f.add(b5);
      
      
      Box b6=Box.createHorizontalBox();
      Label la6=new Label("�߼�ȭ ����");
      CheckboxGroup group2=new CheckboxGroup();
      Checkbox y=new Checkbox("��",group2,true);
      Checkbox n=new Checkbox("��",group2,false);
      la6.setFont(font2);
      y.setFont(font2);
      n.setFont(font2);
      b6.add(la6);
      b6.add(y);
      b6.add(n);
      f.add(b6);
      
      Box b7=Box.createHorizontalBox();
      Label la7=new Label("��ȣ�ڸ�");
      TextField tf7=new TextField(20);
      la7.setFont(font2);
      tf7.setFont(font2);
      b7.add(la7);
      b7.add(tf7);
      f.add(b7);
      
      Box b8=Box.createHorizontalBox();
      Label la8=new Label("��ȣ�� ����ó");
      TextField tf8=new TextField(20);
      la8.setFont(font2);
      tf8.setFont(font2);
      b8.add(la8);
      b8.add(tf8);
      f.add(b8);
      
      Panel ps=new Panel();
      Button btne=new Button("���");
      Button btnc=new Button("���");
      ps.setFont(font2);
      ps.add(btne);
      ps.add(btnc);
      f.add(ps,BorderLayout.SOUTH);
      
      f.setVisible(true);
      
      f.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
         
      });
      
   }
}
>>>>>>> refs/remotes/origin/master
