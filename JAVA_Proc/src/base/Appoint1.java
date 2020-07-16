package base;

import java.awt.BorderLayout;
import java.awt.Button;
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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import EnrollVO.Enroll;
import ReseveVO.MyReserve;

public class Appoint1 {

   public void createFrame(ArrayList<Enroll> enrollList) {

		Frame f=new Frame("진료예약 확인");
  		f.setBounds(500,100,400,600);

          f.setBackground(Color.lightGray);
          f.setLayout(new BorderLayout());
          
          Font fontTitle=new Font(Font.SANS_SERIF,Font.BOLD,24);
          Font fontCon=new Font("맑은 고딕",Font.PLAIN,16);
          
          Panel pCon = new Panel();
          pCon.setLayout(null);
          pCon.setSize(400,600);
          
          Panel pTitle=new Panel();
          pTitle.setSize(400, 50);
          Label title=new Label("진료예약확인");
          pTitle.setBackground(Color.pink);
          pTitle.setFont(fontTitle);
          pTitle.setLocation(0, 30);
          pTitle.add(title);
          f.add(pTitle);
          
          ImageIcon img = new ImageIcon("강아지와 고양이.jpg");
  		JLabel j1 = new JLabel(img);
  		j1.setBounds(50,200,300,300);
  		f.add(j1);
          
          Panel pConL = new Panel();
          pConL.setSize(120, 400);
          pConL.setLocation(50, 90);
          Label name=new Label("보호자명 : ",Label.RIGHT);
          pConL.add(name);
          Label phone=new Label("보호자 연락처 : ",Label.RIGHT);
          pConL.add(phone);
          pCon.add(pConL);
     
          Panel pConR = new Panel();
          pConR.setSize(190, 400);
          pConR.setLocation(150, 90);
   
          TextField nameA=new TextField(14);
          pConR.add(nameA);
          TextField phoneB=new TextField(14);
          pConR.add(phoneB);
          
          pCon.add(pConR);
         
          Button btn1 = new Button("메인화면");
          Button btn2 = new Button("확인");
          btn1.setSize(200, 50);
          btn1.setLocation(0,515);
          btn2.setSize(200, 50);
          btn2.setLocation(201,515);
          pCon.add(btn1);
          pCon.add(btn2);
          
          f.add(pCon);
     
      
     
      f.setVisible(true);
      
    
      
      
      //메인
      btn1.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            FrameMain reserve = new FrameMain();
            f.setVisible(false);
            reserve.createFrame(enrollList);
         }
          
       });
      
      //확인
      btn2.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            //일치하는 번호찾기
        	 String insertinfo = phoneB.getText();
        
        	 int existindex=0;
        	 
        	 for(int i=0;i<enrollList.size();i++) {
        		if(insertinfo.equals(enrollList.get(i).getPhone())){
        			
        			existindex=i;
        			
        		}
        	 }
        		if(existindex!=0) {
        			Appoint2 reserve = new Appoint2();
       	        
        			reserve.createFrame(enrollList,existindex);//입력한거 , 기존정보
                    f.setVisible(false);
        		}else {//
        			int input = JOptionPane.showConfirmDialog(null, "일치하는 예약정보가 없습니다.","예약확인",
							JOptionPane.YES_NO_OPTION);
	
					System.out.println(input);
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