package base;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameEnroll {
	public static void main(String[] args) {
		
		Frame f=new Frame("동물등록 페이지");
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
        Label title=new Label("동물등록(개)");
        pTitle.setBackground(Color.pink);
        pTitle.setFont(fontTitle);
        pTitle.setLocation(0, 30);
        pTitle.add(title);
        f.add(pTitle);
		
        Panel pConL = new Panel();
        pConL.setSize(120, 400);
        pConL.setLocation(50, 90);
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
        pConR.setLocation(150, 90);
        
        TextField animalnameA=new TextField(18);
        pConR.add(animalnameA);
        CheckboxGroup rGroup1= new CheckboxGroup();
        Checkbox M=new Checkbox("수컷",rGroup1,true);
        Checkbox FM=new Checkbox("암컷",rGroup1,false); 
        TextField animalgenderA=new TextField(18);
        TextField animalageA=new TextField(18);
        pConR.add(M); 
        pConR.add(FM);
        pConR.add(animalgenderA);
        pConR.add(animalageA);
        CheckboxGroup rGroup2= new CheckboxGroup();
        Checkbox genderX=new Checkbox("유",rGroup2,true);
        Checkbox genderO=new Checkbox("무",rGroup2,false); 
        pConR.add(genderX); 
        pConR.add(genderO);
        TextField nameA=new TextField(18);
        TextField phoneA=new TextField(18);
        pConR.add(nameA);
        pConR.add(phoneA);
        
        pCon.add(pConR);
		
        Button btn1 = new Button("취소");
        Button btn2 = new Button("등록");
        btn1.setSize(200, 50);
        btn1.setLocation(0,515);
        btn2.setSize(200, 50);
        btn2.setLocation(201,515);
        pCon.add(btn1);
        pCon.add(btn2);
        
        f.add(pCon);
		
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
