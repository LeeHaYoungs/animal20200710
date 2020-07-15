package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import base.FrameDiary;

public class DateSelect {
	
	public void createFrame() {
		Frame f = new Frame("진료 예약");
		f.setBounds(0, 100, 400, 600);
		f.setBackground(Color.lightGray);
		f.setLayout(new BorderLayout());

		// 폰트
		Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		Font fontCon = new Font("맑은 고딕", Font.PLAIN, 16);

		Panel pCon = new Panel();
		pCon.setLayout(null);
		pCon.setSize(400, 500);

		//
		Panel pTitle = new Panel();
		pTitle.setSize(400, 50);
		Label title = new Label("예약 일자 선택");
		pTitle.setBackground(Color.pink);
		pTitle.setFont(fontTitle);
		pTitle.setLocation(0, 30);
		pTitle.add(title);
		f.add(pTitle);
		f.add(pCon);
		
		 new FrameDiary(new DiaryModel());
		
		
		
		f.setVisible(true);
		
		// 윈도우 종료 버튼 이벤트
				f.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
		
	}
		
}
