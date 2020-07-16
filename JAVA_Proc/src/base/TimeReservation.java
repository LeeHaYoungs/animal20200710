package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TimeReservation {

	public static void main(String[] args) {
		Frame f=new Frame("진료 예약 페이지");
   		f.setBounds(0,100,400,600);
           f.setBackground(Color.lightGray);
           f.setLayout(new BorderLayout());
           
           Font fontTitle=new Font(Font.SANS_SERIF,Font.BOLD,24);
           Font fontCon=new Font("맑은 고딕",Font.PLAIN,16);
           
           Panel pCon = new Panel();
           pCon.setLayout(null);
           pCon.setSize(400,600);
           
           Panel pTitle=new Panel();
           pTitle.setSize(400, 50);
           Label title=new Label("진료 예약");
           pTitle.setBackground(Color.pink);
           pTitle.setFont(fontTitle);
           pTitle.setLocation(0, 30);
           pTitle.add(title);
           f.add(pTitle);
           
           Button btn1 = new Button("이전화면");
           Button btn2 = new Button("예약하기");
           btn1.setSize(200, 50);
           btn1.setLocation(0,515);
           btn2.setSize(200, 50);
           btn2.setLocation(201,515);
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
   		
   		time.setSize(350, 50);
		time.setLocation(20, 100);
		f.add(time);
           f.add(pCon);
           
           ImageIcon img = new ImageIcon("졸림.png");
       	JLabel j1 = new JLabel(img);
      	j1.setBounds(20,150,343,300);
       	
     	pCon.add(j1);
           
           
           
           
           
           
           
           f.setVisible(true);
           f.addWindowListener(new WindowAdapter() {
	   			@Override
	   			public void windowClosing(WindowEvent e) {
	   				System.exit(0);
	   				System.out.println();
	   			}
	   		});
	}

}
