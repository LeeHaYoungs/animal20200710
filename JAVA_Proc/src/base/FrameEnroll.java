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

import EnrollVO.Enroll;

public class FrameEnroll {

	public void createFrame(ArrayList<Enroll> enrollList) {

		Frame f = new Frame("������� ������");
		f.setBounds(0, 100, 400, 600);
		f.setBackground(Color.lightGray);
		f.setLayout(new BorderLayout());

		Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		Font fontCon = new Font("���� ���", Font.PLAIN, 16);

		Panel pCon = new Panel();
		pCon.setLayout(null);
		pCon.setSize(400, 600);

		Panel pTitle = new Panel();
		pTitle.setSize(400, 50);
		Label title = new Label("�������(��)");
		pTitle.setBackground(Color.pink);
		pTitle.setFont(fontTitle);
		pTitle.setLocation(0, 30);
		pTitle.add(title);
		f.add(pTitle);

		Panel pConL = new Panel();
		pConL.setSize(120, 400);
		pConL.setLocation(50, 90);
		Label animalname = new Label("������ : ", Label.RIGHT);
		pConL.add(animalname);
		Label animalgender = new Label("�������� : ", Label.RIGHT);
		pConL.add(animalgender);
		Label animalcate = new Label("���� : ", Label.RIGHT);
		pConL.add(animalcate);
		Label animalage = new Label("���� ���� : ", Label.RIGHT);
		pConL.add(animalage);
		Label genderless = new Label("�߼�ȭ���� : ", Label.RIGHT);
		pConL.add(genderless);
		Label name = new Label("��ȣ�ڸ� : ", Label.RIGHT);
		pConL.add(name);
		Label phone = new Label("��ȣ�ڿ���ó : ", Label.RIGHT);
		pConL.add(phone);

		pCon.add(pConL);

		Panel pConR = new Panel();
		pConR.setSize(170, 400);
		pConR.setLocation(160, 90);

		TextField animalnameA = new TextField(14);
		pConR.add(animalnameA);
		CheckboxGroup rGroup1 = new CheckboxGroup();
		Checkbox M = new Checkbox("����", rGroup1, true);
		Checkbox FM = new Checkbox("����", rGroup1, false);
		TextField animalcateA = new TextField(14);
		TextField animalageA = new TextField(14);
		pConR.add(M);
		pConR.add(FM);
		pConR.add(animalcateA);
		pConR.add(animalageA);
		CheckboxGroup rGroup2 = new CheckboxGroup();
		Checkbox genderX = new Checkbox("��", rGroup2, true);
		Checkbox genderO = new Checkbox("��", rGroup2, false);
		pConR.add(genderX);
		pConR.add(genderO);
		TextField nameA = new TextField(14);
		TextField phoneA = new TextField(14);
		pConR.add(nameA);
		pConR.add(phoneA);

		pCon.add(pConR);

		Button btn1 = new Button("���");
		Button btn2 = new Button("���");
		btn1.setSize(200, 50);
		btn1.setLocation(0, 515);
		btn2.setSize(200, 50);
		btn2.setLocation(201, 515);
		pCon.add(btn1);
		pCon.add(btn2);

		f.add(pCon);

		f.setVisible(true);

		// ��,�� üũ
		// String animalgender_check = null;
		// M.addItemListener(new ItemListener() {
		// @Override
		// public void itemStateChanged(ItemEvent e) {
		// if(M.getState()) {
		// animalgender_check="����";
		// }else
		// animalgender_check="����";
		// }
		// });

		// �߼�ȭ ��,�� üũ
		boolean genderless_check;
		if (genderX.getState() == true) {
			genderless_check = true;
		} else
			genderless_check = false;

		  //��ҹ�ư (�������� ���Ό����������)
        btn1.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
             FrameReserve reserve = new FrameReserve();
              reserve.createFrame(enrollList);
              f.setVisible(false);
          }
           
        });
		
		// ���
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String animalgender_check = null;
				if (M.getState()) {// ������ true��
					animalgender_check = "����";
				} else if (FM.getState()) {
					animalgender_check = "����";
				}

				//ArrayList�� ������ ����
				if(enrollList==null) {
					ArrayList<Enroll> enrollList = new ArrayList<Enroll>();
					
					Enroll enroll = new Enroll(animalnameA.getText(),
							animalgender_check, animalcateA.getText(),
							Integer.parseInt(animalageA.getText()),
							genderless_check, nameA.getText(), phoneA.getText() ,0," "," ");
				
					enrollList.add(enroll);
					
					FrameReserve2 reserve = new FrameReserve2();
					
					reserve.createFrame(enrollList);
					f.setVisible(false);
				}else {
					Enroll enroll = new Enroll(animalnameA.getText(),
							animalgender_check, animalcateA.getText(),
							Integer.parseInt(animalageA.getText()),
							genderless_check, nameA.getText(), phoneA.getText() ,0," "," ");
				
					enrollList.add(enroll);
					
					FrameReserve2 reserve = new FrameReserve2();
					
					reserve.createFrame(enrollList);
					f.setVisible(false);
				}
				
				
			}
		});

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
