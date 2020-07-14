//����������
package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameReserve{
	public void createFrame() {
		Frame f =new Frame("���� ����");
	    f.setBounds(0,100,400,600);
	    f.setBackground(Color.lightGray);
	    f.setLayout(new BorderLayout());
	    
	    //��Ʈ
	    Font fontTitle=new Font(Font.SANS_SERIF,Font.BOLD,24);
	    Font fontCon=new Font("���� ���",Font.PLAIN,16);
	    
	    Panel pCon = new Panel();
	    pCon.setLayout(null);
	    pCon.setSize(400,500);
	    
	    //
	    Panel pTitle=new Panel();
	    pTitle.setSize(400, 50);
	    Label title=new Label("�������� �Է�");
	    pTitle.setBackground(Color.pink);
	    pTitle.setFont(fontTitle);
	    pTitle.setLocation(0, 30);
	    pTitle.add(title);
	    f.add(pTitle);
	    
	    Panel pConL = new Panel();
	    pConL.setSize(120, 400);
	    pConL.setLocation(50, 60);
	    Label animaltype=new Label("������� ���� :",Label.RIGHT);
	    pConL.add(animaltype);
	    Label sirialNum=new Label("��Ϲ�ȣ:",Label.RIGHT);
	    pConL.add(sirialNum);
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
	    pConR.setLocation(150, 60);
	    CheckboxGroup rGroup1= new CheckboxGroup(); 
	    Checkbox dog=new Checkbox("��",rGroup1,true);
	    Checkbox cat=new Checkbox("�����",rGroup1,false);
	    TextField sirialNumA=new TextField(18);
	    sirialNumA.setEnabled(false);
	    TextField animalnameA=new TextField(18);
	    pConR.add(dog); 
	    pConR.add(cat);
	    pConR.add(sirialNumA);
	    pConR.add(animalnameA);
	    CheckboxGroup rGroup2= new CheckboxGroup();
	    Checkbox M=new Checkbox("����",rGroup2,true);
	    Checkbox FM=new Checkbox("����",rGroup2,false); 
	    TextField animalgenderA=new TextField(18);
	    TextField animalageA=new TextField(18);
	    pConR.add(M); 
	    pConR.add(FM);
	    pConR.add(animalgenderA);
	    pConR.add(animalageA);
	    CheckboxGroup rGroup3= new CheckboxGroup();
	    Checkbox genderX=new Checkbox("��",rGroup3,true);
	    Checkbox genderO=new Checkbox("��",rGroup3,false); 
	    pConR.add(genderX); 
	    pConR.add(genderO);
	    TextField nameA=new TextField(18);
	    TextField phoneA=new TextField(18);
	    pConR.add(nameA);
	    pConR.add(phoneA);
	    
	    pCon.add(pConR);
	    
	   
	    
	    Button btn1 = new Button("����ȭ��");
	    Button btn2 = new Button("����");
	    btn1.setSize(200, 50);
	    btn1.setLocation(0,515);
	    btn2.setSize(200, 50);
	    btn2.setLocation(201,515);
	    pCon.add(btn1);
	    pCon.add(btn2);
	    
	    f.add(pCon);
	    f.setVisible(true);
	    
	    // ** ����ȭ���̵� �̺�Ʈ �߰� **
	    btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameMain reserve = new FrameMain();
				f.setVisible(false);
				reserve.createFrame();
			}
	    	
	    });
	    
	    
	    //������ ���� ��ư �̺�Ʈ
	    f.addWindowListener(new WindowAdapter() {
	       @Override
	       public void windowClosing(WindowEvent e) {
	          System.exit(0);
	       }
	    });
	}


}

