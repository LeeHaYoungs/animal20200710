//예약페이지
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import EnrollVO.Enroll;
import ReseveVO.Reserve;

public class FrameReserve{
	public void createFrame(Enroll enroll) {
		Frame f =new Frame("진료 예약");
	    f.setBounds(0,100,400,600);
	    f.setBackground(Color.lightGray);
	    f.setLayout(new BorderLayout());
	    
	    //폰트
	    Font fontTitle=new Font(Font.SANS_SERIF,Font.BOLD,24);
	    Font fontCon=new Font("맑은 고딕",Font.PLAIN,16);
	    
	    Panel pCon = new Panel();
	    pCon.setLayout(null);
	    pCon.setSize(400,500);
	    
	    //
	    Panel pTitle=new Panel();
	    pTitle.setSize(400, 50);
	    Label title=new Label("예약정보 입력");
	    pTitle.setBackground(Color.pink);
	    pTitle.setFont(fontTitle);
	    pTitle.setLocation(0, 30);
	    pTitle.add(title);
	    f.add(pTitle);
	    
	    Panel pConL = new Panel();
	    pConL.setSize(120, 400);
	    pConL.setLocation(50, 60);
	    Label animaltype=new Label("진료받을 동물 :",Label.RIGHT);
	    pConL.add(animaltype);
	    Label sirialNum=new Label("등록번호:",Label.RIGHT);
	    pConL.add(sirialNum);
	    Label animalname=new Label("동물명 : ",Label.RIGHT);
	    pConL.add(animalname);
	    Label animalgender=new Label("동물성별 : ",Label.RIGHT);
	    pConL.add(animalgender);
	    Label animalcate=new Label("종류 : ",Label.RIGHT);
	    pConL.add(animalcate);
	    Label animalage=new Label("동물 나이 : ",Label.RIGHT);
	    pConL.add(animalage);
	    Label genderless =new Label("중성화유무 : ",Label.RIGHT);
	    pConL.add(genderless);
	    Label name=new Label("보호자명 : ",Label.RIGHT);
	    pConL.add(name);
	    Label phone=new Label("보호자연락처 : ",Label.RIGHT);
	    pConL.add(phone);
	    
	    pCon.add(pConL);
	    
	    
	    Panel pConR = new Panel();
	    pConR.setSize(190, 400);
	    pConR.setLocation(150, 60);
	    CheckboxGroup rGroup1= new CheckboxGroup(); 
	    Checkbox dog=new Checkbox("개",rGroup1,false);
	    Checkbox cat=new Checkbox("고양이",rGroup1,false);
	    TextField sirialNumA=new TextField(16);
	    sirialNumA.setEnabled(false);
	    TextField animalnameA=new TextField(16);
	    pConR.add(dog); 
	    pConR.add(cat);
	    pConR.add(sirialNumA);
	    pConR.add(animalnameA);
	    CheckboxGroup rGroup2= new CheckboxGroup();
	    Checkbox M=new Checkbox("수컷",rGroup2,true);
	    Checkbox FM=new Checkbox("암컷",rGroup2,false); 
	    TextField animalgenderA=new TextField(16);
	    TextField animalageA=new TextField(16);
	    pConR.add(M); 
	    pConR.add(FM);
	    pConR.add(animalgenderA);
	    pConR.add(animalageA);
	    CheckboxGroup rGroup3= new CheckboxGroup();
	    Checkbox genderX=new Checkbox("유",rGroup3,true);
	    Checkbox genderO=new Checkbox("무",rGroup3,false); 
	    pConR.add(genderX); 
	    pConR.add(genderO);
	    TextField nameA=new TextField(16);
	    TextField phoneA=new TextField(16);
	    pConR.add(nameA);
	    pConR.add(phoneA);
	    
	    pCon.add(pConR);
	    
	    Button btn1 = new Button("메인화면");
	    Button btn2 = new Button("다음");
	    btn1.setSize(200, 50);
	    btn1.setLocation(0,515);
	    btn2.setSize(200, 50);
	    btn2.setLocation(201,515);
	    pCon.add(btn1);
	    pCon.add(btn2);
	    
	    f.add(pCon);
	    f.setVisible(true);
	    
	    //등록한 후 등록정보를 그대로 가져와서 예약창에 띄워준다.
	    if(enroll!=null) {
	    	dog.setEnabled(true);//개 선택
	    	if(enroll.getAnimalgender()=="수컷") {
	    		M.setEnabled(true);
	    	}else
	    		FM.setEnabled(true);
	    	animalnameA.setText(enroll.getAnimalname());
	    	
	    }else {
//	    	Checkbox dog=new Checkbox("개",rGroup1,false);
//	 	    Checkbox cat=new Checkbox("고양이",rGroup1,false);
//	 	    
//		    Checkbox M=new Checkbox("수컷",rGroup2,true);
//		    Checkbox FM=new Checkbox("암컷",rGroup2,false);
//		    
//		    Checkbox genderX=new Checkbox("유",rGroup3,true);
//		    Checkbox genderO=new Checkbox("무",rGroup3,false); 
	    }
	    
	       //개를 누르면 메세지 팝업창이 뜨고 그 후에 등록창으로 이동
	       dog.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	            int input=JOptionPane.showConfirmDialog(null,"개의 등록번호가 있습니까?","선택창", JOptionPane.YES_NO_OPTION);
	            System.out.println(input);
	            //yes-0, no-1
	            if(input==1) {
	               FrameEnroll enroll = new FrameEnroll();
	               f.setVisible(false);
	               enroll.createFrame();
	            }else {
	        	    sirialNumA.setEnabled(true);

	            }
	         }
	          
	      });
	       
	       cat.addMouseListener(new MouseAdapter() {
		         @Override
		         public void mouseClicked(MouseEvent e) {
		          
		        	    sirialNumA.setEnabled(false);

		         }
		      });

	    // ** 메인화면이동 이벤트 추가 **
	    btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameMain reserve = new FrameMain();
				f.setVisible(false);
				reserve.createFrame();
			}
	    	
	    });
	    
	    // ** 다음 버튼 이벤트 추가
	    btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				Reserve reserve = new Reserve();//객체 생성하면서 값 받아옴
//				
//				
//				FrameMain s = new FrameMain();
//				f.setVisible(false);
//				reserve.createFrame();
			}
	    	
	    });
	    
	    //윈도우 종료 버튼 이벤트
	    f.addWindowListener(new WindowAdapter() {
	       @Override
	       public void windowClosing(WindowEvent e) {
	          System.exit(0);
	       }
	    });
	}


}

