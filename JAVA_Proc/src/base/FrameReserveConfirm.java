package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;

import EnrollVO.Enroll;

public class FrameReserveConfirm {
	public void createFrame(ArrayList<Enroll> enrollList) {
	int index=enrollList.size()-1;
		
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
		pConL.setLocation(30, 60);
		Label reserveDate = new Label("��¥ : " , Label.RIGHT);
		pConL.add(reserveDate);
		Label reserveTime = new Label("�ð� : " , Label.RIGHT);
		pConL.add(reserveTime);
		Label animalname = new Label("������ : ", Label.RIGHT);
		pConL.add(animalname);
		Label name = new Label("��ȣ�ڸ� : ", Label.RIGHT);
		pConL.add(name);
		Label phone = new Label("��ȣ�ڿ���ó : ", Label.RIGHT);
		pConL.add(phone);

		pCon.add(pConL);
		

		Panel pConR = new Panel();

		//boxLayout
		BoxLayout Box = new BoxLayout(pConR, BoxLayout.Y_AXIS);
	
		pConR.setLayout(Box);
		pConR.setSize(150, 158);
		pConR.setLocation(180,64);
//	
		Label reserveDateA = new Label(enrollList.get(index).getDate(), Label.LEFT);
		pConR.add(reserveDateA);
		Label reserveTimeA = new Label(enrollList.get(index).getTime(), Label.LEFT);
		pConR.add(reserveTimeA);
		Label animalnameA = new Label(enrollList.get(index).getAnimalname(), Label.LEFT);
		pConR.add(animalnameA);
		Label nameA = new Label(enrollList.get(index).getName(), Label.LEFT);
		pConR.add(nameA);
		Label phoneA = new Label(enrollList.get(index).getPhone(), Label.LEFT);	
		pConR.add(phoneA);
//	
		
/*test��*/
//		Label reserveDateA = new Label("2020�� 7��22��", Label.LEFT);
//		pConR.add(reserveDateA);
//		Label reserveTimeA = new Label("am : 10:00~11:00", Label.LEFT);
//		pConR.add(reserveTimeA);
//		Label animalnameA = new Label("name", Label.LEFT);
//		pConR.add(animalnameA);
//		Label nameA = new Label("owner", Label.LEFT);
//		pConR.add(nameA);
//		Label phoneA = new Label("010-1230123", Label.LEFT);	
//		pConR.add(phoneA);		


		
		pConL.setFont(fontCon);
		pConR.setFont(fontCon);
		
		
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
				FrameMain main = new FrameMain();
				
				main.createFrame(enrollList);
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
	/*test��*/
//	public static void main(String[] args) {
//		new FrameReserveConfirm().createFrame(null);
//	}
}
