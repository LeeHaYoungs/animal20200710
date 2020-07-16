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

public class Appoint2 {

	public void createFrame(ArrayList<Enroll> enrollList, int existindex) {
		// TODO Auto-generated method stub
		int index=enrollList.size()-1;
		
		Frame f = new Frame("진료예약 확인2");
		f.setBounds(0, 100, 400, 600);
		f.setBackground(Color.lightGray);
		f.setLayout(new BorderLayout());

		Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		Font fontCon = new Font("맑은 고딕", Font.PLAIN, 20);

		Panel pCon = new Panel();
		pCon.setLayout(null);
		pCon.setSize(400, 600);

		Panel pTitle = new Panel();
		pTitle.setSize(400, 50);
		Label title = new Label("진료예약확인2");
		pTitle.setBackground(Color.pink);
		pTitle.setFont(fontTitle);
		pTitle.setLocation(0, 30);
		pTitle.add(title);
		f.add(pTitle);

//		Panel pConL = new Panel();
//		pConL.setSize(400, 400);
//		pConL.setLocation(50, 90);
//		Label animalname = new Label("동물명 : "+ myreserve.getAnimalName(), Label.RIGHT);
//		pConL.add(animalname);
//		Label name = new Label("보호자명 : "+ myreserve.getName(), Label.RIGHT);
//		pConL.add(name);
//		Label information = new Label("날짜 및 시간"+ myreserve.getDate()+","+myreserve.getTime(), Label.RIGHT);
//		pConL.add(information);
//		pCon.add(pConL);
//
		
		Panel pConL = new Panel();
		
		//boxLayout
				BoxLayout Box = new BoxLayout(pConL, BoxLayout.Y_AXIS);
				pConL.setLayout(Box);
		
		pConL.setSize(230, 200);
		pConL.setLocation(50, 90);
		
		Label animalname = new Label("동물명 : "+ enrollList.get(existindex).getAnimalname(), Label.RIGHT);
		pConL.add(animalname);
		Label name = new Label("보호자명 : "+ enrollList.get(existindex).getName(), Label.RIGHT);
		pConL.add(name);
		Label date = new Label("날짜 : "+ enrollList.get(existindex).getDate(), Label.LEFT);
		pConL.add(date);
		Label time = new Label("시간 : "+ enrollList.get(existindex).getTime(), Label.LEFT);
		pConL.add(time);
		
		pCon.add(pConL);
		
//		Label animalname = new Label("동물명 : "+ "1", Label.LEFT);
//		pConL.add(animalname);
//		Label name = new Label("보호자명 : "+ "1", Label.LEFT);
//		pConL.add(name);
//		Label date = new Label("날짜 : "+ "2020년 7월22일", Label.LEFT);
//		pConL.add(date);
//		Label time = new Label("시간 : "+ "am : 10:00~11:00", Label.LEFT);
//		pConL.add(time);
		
		animalname.setFont(fontCon);
		name.setFont(fontCon);
		date.setFont(fontCon);
		time.setFont(fontCon);
		
		pCon.add(pConL);
		
		
//		Panel pConR = new Panel();
//		pConR.setSize(190, 400);
//		pConR.setLocation(150, 90);
//
//		TextField animalnameA = new TextField(18);
//		pConR.add(animalnameA);
//		TextField animalnameB = new TextField(18);
//		pConR.add(animalnameB);

//		pCon.add(pConR);

		Button btn1 = new Button("메인화면");
		btn1.setSize(200, 50);
		btn1.setLocation(100, 515);
		pCon.add(btn1);

		f.add(pCon);

		f.setVisible(true);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameMain reserve = new FrameMain();
				reserve.createFrame(enrollList);
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
//	public static void main(String[] args) {
//		new Appoint2().createFrame(null, null);
//	}
}
