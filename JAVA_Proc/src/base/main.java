package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
	
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setBounds(0, 100, 400, 400);
		

		Panel p1 = new Panel();//타이틀 넣는 패널
		Panel p2 = new Panel();	//하단 버튼2개 패널
		
		Label title = new Label("BOA4 동물병원");
		Button reserve_btn = new Button("진료예약");
		Button confirm_btn = new Button("예약확인");

		p1.add(title);
		
		p2.add(reserve_btn);
		p2.add(confirm_btn);
		p2.setLayout(new FlowLayout());

		frame.add(p1, BorderLayout.NORTH);//타이틀		
		frame.add(p2,BorderLayout.SOUTH);//버튼
		
		frame.setVisible(true);

		//WindowClosing 구현된 MyEventListener를 frame의 windowListener에 연결
		frame.addWindowListener(new MyEventListener());
		
		//예약하기 버튼 액션리스너
		reserve_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				main2 m2 = new main2();
				frame.setVisible(false);
				m2.createFrame();
			}
			
		});
	}
}