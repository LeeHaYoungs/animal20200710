package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JLabel;

public class bookiingComplete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frame f = new Frame("");
		f.setBounds(100, 100, 400, 500);
		//f.setBackground(Color.orange);

		Font font = new Font("막은고딕", Font.BOLD, 20);

		// 북쪽단
		Panel pNorth = new Panel();
		Label bookingComplete = new Label("진료예약완료");
		pNorth.add(bookingComplete);
		pNorth.setFont(font);

		// 중앙
		Panel pCenter = new Panel();
//		JLabel date = new JLabel("<html>날짜, 시간 : <br>");
//		JLabel animalName = new JLabel("동물명 : ");
//		JLabel personName = new JLabel("보호자명 : ");
//		JLabel personPhone = new JLabel("보호자연락처 : ");
		JLabel arr = new JLabel();
		String data = "<html><br><br> 날짜, 시간 :"+
		"<br><br>동물명 : "+"<br><br>보호자명 : "+"<br><br>보호자연락처 : ";
		
		arr.setText(data);
		arr.setFont(font);
		
//		pCenter.add(date);
//		pCenter.add(animalName);
//		pCenter.add(personName);
//		pCenter.add(personPhone);

		pCenter.add(arr);
		// 남쪽단
		Panel pSouth = new Panel();
		//pSouth.setFont(font);
		Button menu = new Button("메인화면으로");
		//menu.setBounds(400, 400, 400, 600);
		menu.setFont(new Font("맑은고딕", Font.BOLD, 30));

		pSouth.add(menu);

		f.add(pNorth, BorderLayout.NORTH);
		f.add(pCenter, BorderLayout.CENTER);
		f.add(pSouth, BorderLayout.SOUTH);
		f.setVisible(true);
		f.setResizable(false);
	}

}
