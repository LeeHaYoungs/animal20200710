package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Appoint2 {

	public void createFrame() {
		// TODO Auto-generated method stub
		Frame f = new Frame("���Ό�� Ȯ��2");
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
		Label title = new Label("���Ό��Ȯ��2");
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
		Label name = new Label("��ȣ�ڸ� : ", Label.RIGHT);
		pConL.add(name);
		Label information = new Label("��¥ �� �ð�", Label.RIGHT);
		pConL.add(information);
		pCon.add(pConL);

		Panel pConR = new Panel();
		pConR.setSize(190, 400);
		pConR.setLocation(150, 90);

		TextField animalnameA = new TextField(18);
		pConR.add(animalnameA);
		TextField animalnameB = new TextField(18);
		pConR.add(animalnameB);

		pCon.add(pConR);

		Button btn1 = new Button("����ȭ��");
		btn1.setSize(200, 50);
		btn1.setLocation(100, 515);
		pCon.add(btn1);

		f.add(pCon);

		f.setVisible(true);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameMain reserve = new FrameMain();
				f.setVisible(false);
				reserve.createFrame();
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
