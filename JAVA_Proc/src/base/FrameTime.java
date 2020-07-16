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

import ReseveVO.MyReserve;
import calendar.DiaryModel;

public class FrameTime {
		
	public void createFrame(ArrayList<String> myreserveList) {
		Frame f = new Frame("진료 시간 선택 페이지");
		f.setBounds(0, 100, 400, 600);
		f.setBackground(Color.lightGray);
		f.setLayout(new BorderLayout());

		// 이미지
		ImageIcon img = new ImageIcon("졸림.png");
		JLabel j1 = new JLabel(img);// JLabel에만 ImageIcon을 추가할 수 있다.
		j1.setBounds(80, 10, 343, 300);// 원본이미지의 width, height를 알아야함
		j1.setLocation(0, 120);;
		f.add(j1);

		Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		Font fontCon = new Font("맑은 고딕", Font.PLAIN, 16);

		Panel pCon = new Panel();
		pCon.setLayout(null);
		pCon.setSize(400, 600);

		Panel pTitle = new Panel();
		pTitle.setSize(400, 50);
		Label title = new Label("시간 예약");
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

		Panel pConR = new Panel();
		pConR.setSize(190, 50);
		pConR.setLocation(150, 90);

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
		time.add("am: 09~10");
		time.add("am: 10~11");
		time.add("am: 11~12");
		time.add("pm: 00~01");
		time.add("pm: 01~02");
		time.add("pm: 02~03");
		time.add("pm: 03~04");
		time.add("pm: 04~05");
		time.add("pm: 05~06");

		time.setSize(100, 50);
		time.setLocation(50, 100);

		

		
		Panel pConC = new Panel();
		pConC.setSize(100, 200);
		pConC.setLocation(0, 50);
		pConC.add(time);
		pCon.add(pConC);

		f.add(pCon);

		f.setVisible(true);
		
		// ** 이전화면 이벤트 추가 **
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myreserveList.remove(myreserveList.size()-1);//최근에 추가된 값인 '날짜' 삭제
				new FrameDiary(new DiaryModel(),myreserveList); 
				f.setVisible(false);
				//confirm.createFrame(null);
			}
		});
		
		// ** 진료예약 확인 이벤트 추가 **
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myreserveList.add(time.getItem(time.getSelectedIndex()));
				
				int size=myreserveList.size();
				MyReserve ms = new MyReserve(myreserveList.get(size-5),myreserveList.get(size-4),myreserveList.get(size-3),myreserveList.get(size-2),myreserveList.get(size-1));
				
				ArrayList<MyReserve> myreserveComple = new ArrayList<MyReserve>();
				myreserveComple.add(ms);
				
				FrameReserveConfirm confirm = new FrameReserveConfirm();
				confirm.createFrame(myreserveComple);
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
