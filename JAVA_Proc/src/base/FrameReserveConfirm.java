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
import java.util.ArrayList;

import ReseveVO.MyReserve;

public class FrameReserveConfirm {
	public void createFrame(ArrayList<MyReserve> myreserve) {
		 
		int index=myreserve.size()-1;
		
		Frame f = new Frame("���� ���� �Ϸ�");
		f.setBounds(0, 100, 400, 600);
		f.setBackground(Color.lightGray);
		f.setLayout(new BorderLayout());

		// ��Ʈ
		Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		Font fontCon = new Font("���� ���", Font.PLAIN, 16);

		Panel pCon = new Panel();
		pCon.setLayout(null);
		pCon.setSize(400, 500);
		
		Panel pTitle = new Panel();
		pTitle.setSize(400, 50);
		Label title = new Label("��������");
		pTitle.setBackground(Color.pink);
		pTitle.setFont(fontTitle);
		pTitle.setLocation(0, 30);
		pTitle.add(title);
		f.add(pTitle);

		Panel pConL = new Panel();
		pConL.setSize(120, 400);
		pConL.setLocation(50, 60);
		Label reserveDate = new Label("��¥, �ð� : " , Label.RIGHT);
		pConL.add(reserveDate);
		Label animalname = new Label("������ : ", Label.RIGHT);
		pConL.add(animalname);
		Label name = new Label("��ȣ�ڸ� : ", Label.RIGHT);
		pConL.add(name);
		Label phone = new Label("��ȣ�ڿ���ó : ", Label.RIGHT);
		pConL.add(phone);

		pCon.add(pConL);
		
		Panel pConR = new Panel();
		pConR.setSize(170, 400);
		pConR.setLocation(150, 90);

		Label reserveDateA = new Label(myreserve.get(index).getDate()+","+myreserve.get(index).getTime());
		Label animalnameA = new Label(myreserve.get(index).getAnimalName());
		Label nameA = new Label(myreserve.get(index).getName());
		Label phoneA = new Label(myreserve.get(index).getPhone());
		pConR.add(reserveDateA);
		pConR.add(animalnameA);
		pConR.add(nameA);
		pConR.add(phoneA);
//		CheckboxGroup rGroup1 = new CheckboxGroup();
//		Checkbox M = new Checkbox("����", rGroup1, true);
//		Checkbox FM = new Checkbox("����", rGroup1, false);
//		TextField animalcateA = new TextField(14);
//		TextField animalageA = new TextField(14);
//		CheckboxGroup rGroup2 = new CheckboxGroup();
//		Checkbox genderX = new Checkbox("��", rGroup2, true);
//		Checkbox genderO = new Checkbox("��", rGroup2, false);
		
		
		pCon.add(pConR);

		Button btn1 = new Button("����ȭ��");
		btn1.setSize(200, 50);
		btn1.setLocation(100, 515);
		pCon.add(btn1,BorderLayout.CENTER);

		f.add(pCon);
		f.setVisible(true);

		

		
		// ** ����ȭ���̵� �̺�Ʈ �߰� **
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameMain reserve = new FrameMain();
				
				reserve.createFrame();
				f.setVisible(false);
			}
		});

		// ������ ���� ��ư �̺�Ʈ
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
