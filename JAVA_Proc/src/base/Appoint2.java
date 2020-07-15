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
		JFrame f = new JFrame("진료예약 확인2");

		f.setBounds(200, 200, 500, 630);
		f.setLayout(null);

		Font font = new Font("맑은고딕", Font.BOLD, 30);
		Font font2 = new Font("맑은고딕", Font.BOLD, 25);
		Font btnFont = new Font("맑은고딕", Font.BOLD, 30);

		JLabel a1 = new JLabel();
		a1.setText("진료예약 확인2");

		a1.setBounds(200, 20, 220, 100);
		a1.setLocation(150, 10);
		a1.setFont(font);

		JLabel a2 = new JLabel();
		a2.setText("동물명");
		a2.setBounds(200, 200, 400, 200);
		a2.setLocation(20, 50);
		a2.setFont(font2);
		JTextField tf1 = new JTextField(20);
		tf1.setBounds(200, 100, 150, 30);
		tf1.setLocation(120, 135);

		JLabel a3 = new JLabel();
		a3.setText("보호자명");
		a3.setBounds(500, 600, 200, 100);
		a3.setLocation(20, 200);
		a3.setFont(font2);

		JTextField tf2 = new JTextField(20);
		tf2.setBounds(200, 100, 150, 30);
		tf2.setLocation(150, 235);

		JLabel a4 = new JLabel();
		a4.setText("날짜 및 시간정보");
		a4.setBounds(500, 600, 200, 100);
		a4.setLocation(20, 300);
		a4.setFont(font2);

		Button btn1 = new Button("메인화면");
		Button btn2 = new Button("확인");
		btn1.setSize(200, 50);
		btn1.setLocation(10, 540);
		btn2.setSize(200, 50);
		btn2.setLocation(290, 540);

		btn1.setFont(btnFont);
		btn2.setFont(btnFont);

		f.add(a1);
		f.add(a2);
		f.add(a3);
		f.add(a4);

		f.add(tf1);
		f.add(tf2);

		f.add(btn1);
		f.add(btn2);

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