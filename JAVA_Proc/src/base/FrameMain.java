package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMain {

	public void createFrame() {
		Frame f = new Frame();
		f.setBounds(0, 100, 400, 600);
		
		Panel p1 = new Panel();//타이틀 넣는 패널
		Panel p2 = new Panel();	//하단 버튼2개 패널
		
		Label title = new Label("BOA4 동물병원");
		Button reserve_btn = new Button("진료예약");
		Button confirm_btn = new Button("예약확인");
		
		reserve_btn.setPreferredSize(new Dimension(100,100));
		confirm_btn.setPreferredSize(new Dimension(100,100));
		p1.add(title);
		
		p2.add(reserve_btn);
		p2.add(confirm_btn);
		p2.setLayout(new FlowLayout());

		f.add(p1, BorderLayout.NORTH);//타이틀		
		f.add(p2,BorderLayout.SOUTH);//버튼
		
		f.setVisible(true);

		//WindowClosing 구현된 MyEventListener를 frame의 windowListener에 연결
		f.addWindowListener(new MyEventListener());
		
		//예약하기 버튼 액션리스너
		reserve_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameReserve reserve = new FrameReserve();
				f.setVisible(false);
				reserve.createFrame();
			}
		});
	}
	

}