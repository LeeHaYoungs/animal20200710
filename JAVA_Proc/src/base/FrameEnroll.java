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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import EnrollVO.Enroll;

public class FrameEnroll {

	public void createFrame(ArrayList<Enroll> enrollList) {

		Frame f = new Frame("동물등록 페이지");
		f.setBounds(0, 100, 400, 600);
		f.setBackground(Color.lightGray);
		f.setLayout(new BorderLayout());

		Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		Font fontCon = new Font("맑은 고딕", Font.PLAIN, 16);

		Panel pCon = new Panel();
		pCon.setLayout(null);
		pCon.setSize(400, 600);

		Panel pTitle = new Panel();
		pTitle.setSize(400, 50);
		Label title = new Label("동물등록(개)");
		pTitle.setBackground(Color.pink);
		pTitle.setFont(fontTitle);
		pTitle.setLocation(0, 30);
		pTitle.add(title);
		f.add(pTitle);

		Panel pConL = new Panel();
		pConL.setSize(120, 400);
		pConL.setLocation(50, 90);
		Label animalname = new Label("동물명 : ", Label.RIGHT);
		pConL.add(animalname);
		Label animalgender = new Label("동물성별 : ", Label.RIGHT);
		pConL.add(animalgender);
		Label animalcate = new Label("종류 : ", Label.RIGHT);
		pConL.add(animalcate);
		Label animalage = new Label("동물 나이 : ", Label.RIGHT);
		pConL.add(animalage);
		Label genderless = new Label("중성화유무 : ", Label.RIGHT);
		pConL.add(genderless);
		Label name = new Label("보호자명 : ", Label.RIGHT);
		pConL.add(name);
		Label phone = new Label("보호자연락처 : ", Label.RIGHT);
		pConL.add(phone);

		pCon.add(pConL);

		Panel pConR = new Panel();
		pConR.setSize(170, 400);
		pConR.setLocation(160, 90);

		TextField animalnameA = new TextField(14);
		pConR.add(animalnameA);
		CheckboxGroup rGroup1 = new CheckboxGroup();
		Checkbox M = new Checkbox("수컷", rGroup1, true);
		Checkbox FM = new Checkbox("암컷", rGroup1, false);
		TextField animalcateA = new TextField(14);
		TextField animalageA = new TextField(14);
		pConR.add(M);
		pConR.add(FM);
		pConR.add(animalcateA);
		pConR.add(animalageA);
		CheckboxGroup rGroup2 = new CheckboxGroup();
		Checkbox genderX = new Checkbox("유", rGroup2, true);
		Checkbox genderO = new Checkbox("무", rGroup2, false);
		pConR.add(genderX);
		pConR.add(genderO);
		TextField nameA = new TextField(14);
		TextField phoneA = new TextField(14);
		pConR.add(nameA);
		pConR.add(phoneA);

		pCon.add(pConR);

		Button btn1 = new Button("취소");
		Button btn2 = new Button("등록");
		btn1.setSize(200, 50);
		btn1.setLocation(0, 515);
		btn2.setSize(200, 50);
		btn2.setLocation(201, 515);
		pCon.add(btn1);
		pCon.add(btn2);

		f.add(pCon);

		f.setVisible(true);

		// 암,수 체크
		// String animalgender_check = null;
		// M.addItemListener(new ItemListener() {
		// @Override
		// public void itemStateChanged(ItemEvent e) {
		// if(M.getState()) {
		// animalgender_check="수컷";
		// }else
		// animalgender_check="암컷";
		// }
		// });

		// 중성화 유,무 체크
		boolean genderless_check;
		if (genderX.getState() == true) {
			genderless_check = true;
		} else
			genderless_check = false;

		  //취소버튼 (뒤페이지 진료예약페이지로)
        btn1.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
             FrameReserve reserve = new FrameReserve();
              reserve.createFrame(enrollList);
              f.setVisible(false);
          }
           
        });
		
		// 등록
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String animalgender_check = null;
				if (M.getState()) {// 수컷이 true면
					animalgender_check = "수컷";
				} else if (FM.getState()) {
					animalgender_check = "암컷";
				}

				//ArrayList가 없으면 생성
				if(enrollList==null) {
					ArrayList<Enroll> enrollList = new ArrayList<Enroll>();
					
					Enroll enroll = new Enroll(animalnameA.getText(),
							animalgender_check, animalcateA.getText(),
							Integer.parseInt(animalageA.getText()),
							genderless_check, nameA.getText(), phoneA.getText() ,0," "," ");
				
					enrollList.add(enroll);
					
					FrameReserve2 reserve = new FrameReserve2();
					
					reserve.createFrame(enrollList);
					f.setVisible(false);
				}else {
					Enroll enroll = new Enroll(animalnameA.getText(),
							animalgender_check, animalcateA.getText(),
							Integer.parseInt(animalageA.getText()),
							genderless_check, nameA.getText(), phoneA.getText() ,0," "," ");
				
					enrollList.add(enroll);
					
					FrameReserve2 reserve = new FrameReserve2();
					
					reserve.createFrame(enrollList);
					f.setVisible(false);
				}
				
				
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
