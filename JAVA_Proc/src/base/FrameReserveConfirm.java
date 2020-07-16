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
		
		Frame f = new Frame("진료 예약 완료");
		f.setBounds(0, 100, 400, 600);
		f.setBackground(Color.lightGray);
		f.setLayout(new BorderLayout());

		// 폰트
		Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		Font fontCon = new Font("맑은 고딕", Font.PLAIN, 16);

		Panel pCon = new Panel();
		pCon.setLayout(null);
		pCon.setSize(400, 500);
		
		Panel pTitle = new Panel();
		pTitle.setSize(400, 50);
		Label title = new Label("예약정보");
		pTitle.setBackground(Color.pink);
		pTitle.setFont(fontTitle);
		pTitle.setLocation(0, 30);
		pTitle.add(title);
		f.add(pTitle);

		Panel pConL = new Panel();
		pConL.setSize(120, 400);
		pConL.setLocation(30, 60);
		Label reserveDate = new Label("날짜 : " , Label.RIGHT);
		pConL.add(reserveDate);
		Label reserveTime = new Label("시간 : " , Label.RIGHT);
		pConL.add(reserveTime);
		Label animalname = new Label("동물명 : ", Label.RIGHT);
		pConL.add(animalname);
		Label name = new Label("보호자명 : ", Label.RIGHT);
		pConL.add(name);
		Label phone = new Label("보호자연락처 : ", Label.RIGHT);
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
		
/*test용*/
//		Label reserveDateA = new Label("2020년 7월22일", Label.LEFT);
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

		Button btn1 = new Button("메인화면");
		btn1.setSize(200, 50);
		btn1.setLocation(100, 515);
		pCon.add(btn1,BorderLayout.CENTER);

		f.add(pCon);
		f.setVisible(true);

		

		
		// ** 메인화면이동 이벤트 추가 **
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameMain main = new FrameMain();
				
				main.createFrame(enrollList);
				f.setVisible(false);
			}
		});

		// 윈도우 종료 버튼 이벤트
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	/*test용*/
//	public static void main(String[] args) {
//		new FrameReserveConfirm().createFrame(null);
//	}
}
