package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
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

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import EnrollVO.Enroll;
import ReseveVO.MyReserve;
import calendar.DiaryModel;

public class FrameTime {
	
	ArrayList<MyReserve> myreserveComple = new ArrayList<MyReserve>();
	
	public void createFrame(ArrayList<Enroll> enrollList) {
		
		Frame f = new Frame("진료 시간 선택 페이지");
		f.setBounds(500, 100, 400, 600);
		f.setBackground(Color.lightGray);
		f.setLayout(new BorderLayout());

		Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		Font fontCon = new Font("맑은 고딕", Font.PLAIN, 16);

		

		Panel pCon = new Panel();
		pCon.setLayout(null);
		pCon.setSize(400, 600);

		Panel pTitle = new Panel();
		pTitle.setSize(400, 50);
		Label title = new Label("예약 시간 선택");
		pTitle.setBackground(Color.pink);
		pTitle.setFont(fontTitle);
		pTitle.setLocation(0, 30);
		pTitle.add(title);
		f.add(pTitle);

		// Panel pConL = new Panel();
		// pConL.setSize(100, 50);
		// pConL.setLocation(50, 90);
		// Label animalname=new Label("진료 날짜 : ",Label.RIGHT);
		// pConL.add(animalname);
		// pCon.add(pConL);
		// TextField animalnameA=new TextField(18);
		// pConR.add(animalnameA);
		// pCon.add(pConR);

		Button btn1 = new Button("이전화면");
		Button btn2 = new Button("예약하기");
		btn1.setSize(200, 50);
		btn1.setLocation(0, 515);
		btn2.setSize(200, 50);
		btn2.setLocation(201, 515);
		pCon.add(btn1);
		pCon.add(btn2);

		Choice time = new Choice();
		time.add("예약 시간 선택");
		time.add("am : 09:00~10:00");
		time.add("am : 10:00~11:00");
		time.add("am : 11:00~12:00");
		time.add("pm : 12:00~01:00");
		time.add("pm : 01:00~02:00");
		time.add("pm : 02:00~03:00");
		time.add("pm : 03:00~04:00");
		time.add("pm : 04:00~05:00");
		time.add("pm : 05:00~06:00");

		time.setSize(350, 50);
		time.setLocation(20, 100);
		f.add(time);

		f.add(pCon);
		// 이미지
				ImageIcon img = new ImageIcon("졸림.png");
				JLabel j1 = new JLabel(img);// JLabel에만 ImageIcon을 추가할 수 있다.
				j1.setBounds(20,150,343,300);// 원본이미지의 width, height를 알아야함
				//j1.setLocation(0, 120);;
				pCon.add(j1);
				
		f.setVisible(true);

		// ** 이전화면 이벤트 추가 **
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// enrollList.remove(enrollList.size()-1);//최근에 추가된 값인 '날짜' 삭제

				new FrameDiary(new DiaryModel(), enrollList);
				f.setVisible(false);
				// confirm.createFrame(null);
			}
		});

		// ** 진료예약 확인 이벤트 추가 **
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				enrollList.get(enrollList.size() - 1)
						.setTime(time.getItem(time.getSelectedIndex()));

				// int size=enrollList.size();
				// MyReserve ms = new
				// MyReserve(myreserveList.get(size-5),myreserveList.get(size-4),myreserveList.get(size-3),myreserveList.get(size-2),myreserveList.get(size-1));

				//
				// myreserveComple.add(ms);

				FrameReserveConfirm confirm = new FrameReserveConfirm();
				confirm.createFrame(enrollList);
				f.setVisible(false);
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
