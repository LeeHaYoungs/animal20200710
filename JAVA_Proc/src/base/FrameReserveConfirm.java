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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import EnrollVO.Enroll;
import ReseveVO.Reserve;

public class FrameReserveConfirm {
	public void createFrame(Reserve reserve2) {
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

		//
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
		Label reserveDate = new Label("��¥, �ð� :", Label.RIGHT);
		pConL.add(reserveDate);
		Label animalname = new Label("������ : ", Label.RIGHT);
		pConL.add(animalname);
		Label name = new Label("��ȣ�ڸ� : ", Label.RIGHT);
		pConL.add(name);
		Label phone = new Label("��ȣ�ڿ���ó : ", Label.RIGHT);
		pConL.add(phone);

		pCon.add(pConL);

		Panel pConR = new Panel();
		pConR.setSize(190, 400);
		pConR.setLocation(150, 60);
		TextField reserveDateA = new TextField(16);
		reserveDate.setEnabled(false);
		TextField animalnameA = new TextField(16);
		pConR.add(reserveDate);
		pConR.add(animalnameA);
		TextField nameA = new TextField(16);
		TextField phoneA = new TextField(16);
		pConR.add(nameA);
		pConR.add(phoneA);

		pCon.add(pConR);

		Button btn1 = new Button("����ȭ��");
		btn1.setSize(200, 50);
		btn1.setLocation(0, 515);
		pCon.add(btn1);

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

		// ������ ���� ��ư �̺�Ʈ
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
