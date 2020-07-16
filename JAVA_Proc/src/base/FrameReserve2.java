package base;
//����������


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
import java.util.ArrayList;

import javax.swing.JOptionPane;

import EnrollVO.Enroll;
import calendar.DiaryModel;


//FrameEnroll���� ����� ������ �޾ƿ� ���� ������
public class FrameReserve2{
   public void createFrame(ArrayList<Enroll> enroll) {
      Frame f =new Frame("���� ����");
      f.setBounds(0,100,400,600);
      f.setBackground(Color.lightGray);
      f.setLayout(new BorderLayout());

      int input=JOptionPane.showConfirmDialog(null,"��Ϲ�ȣ�� �߱޵Ǿ����ϴ�.","����â", JOptionPane.CLOSED_OPTION);
      System.out.println(input);
      
      //���� �ֱٿ� ����� enroll���� �ε���
      int index=enroll.size()-1;
      
      Enroll latelyEnroll = new Enroll();
      latelyEnroll=enroll.get(index);
      
      //��Ʈ
      Font fontTitle=new Font(Font.SANS_SERIF,Font.BOLD,24);
      Font fontCon=new Font("���� ���",Font.PLAIN,16);

      Panel pCon = new Panel();
      pCon.setLayout(null);
      pCon.setSize(400,500);

      //
      Panel pTitle=new Panel();
      pTitle.setSize(400, 50);
      Label title=new Label("�������� �Է�");
      pTitle.setBackground(Color.pink);
      pTitle.setFont(fontTitle);
      pTitle.setLocation(0, 30);
      pTitle.add(title);
      f.add(pTitle);

      Panel pConL = new Panel();
      pConL.setSize(120, 400);
      pConL.setLocation(50, 60);
      Label animaltype=new Label("������� ���� :",Label.RIGHT);
      pConL.add(animaltype);
      Label sirialNum=new Label("��Ϲ�ȣ:",Label.RIGHT);
      pConL.add(sirialNum);
      Label animalname=new Label("������ : ",Label.RIGHT);
      pConL.add(animalname);
      Label animalgender=new Label("�������� : ",Label.RIGHT);
      pConL.add(animalgender);
      Label animalcate=new Label("���� : ",Label.RIGHT);
      pConL.add(animalcate);
      Label animalage=new Label("���� ���� : ",Label.RIGHT);
      pConL.add(animalage);
      Label genderless =new Label("�߼�ȭ���� : ",Label.RIGHT);
      pConL.add(genderless);
      Label name=new Label("��ȣ�ڸ� : ",Label.RIGHT);
      pConL.add(name);
      Label phone=new Label("��ȣ�ڿ���ó : ",Label.RIGHT);
      pConL.add(phone);

      pCon.add(pConL);


      Panel pConR = new Panel();
      pConR.setSize(190, 400);
      pConR.setLocation(150, 60);
      CheckboxGroup rGroup1= new CheckboxGroup(); 
      Checkbox dog=new Checkbox("��",rGroup1,true);
      //'��'�� ����� �� �ְ�, ��� ������ ���� ������ �̹Ƿ� true
      Checkbox cat=new Checkbox("�����",rGroup1,false);
      TextField sirialNumA=new TextField(16);
      sirialNumA.setEnabled(false);

      TextField animalnameA=new TextField(16);
      pConR.add(dog); 
      pConR.add(cat);
      pConR.add(sirialNumA);
      pConR.add(animalnameA);
      CheckboxGroup rGroup2= new CheckboxGroup();

      sirialNumA.setText(String.valueOf(latelyEnroll.getSirialNum()));
      animalnameA.setText(latelyEnroll.getAnimalname());

      if(latelyEnroll.getAnimalgender().equals("����")){
         Checkbox M=new Checkbox("����",rGroup2,true);
         Checkbox FM=new Checkbox("����",rGroup2,false);
         pConR.add(M); 
         pConR.add(FM);
      }else {
         Checkbox M=new Checkbox("����",rGroup2,false);
         Checkbox FM=new Checkbox("����",rGroup2,true);
         pConR.add(M); 
         pConR.add(FM);
      }

      TextField animalcateA=new TextField(16);
      TextField animalageA=new TextField(16);

      animalcateA.setText(latelyEnroll.getAnimalcate());
      animalageA.setText(String.valueOf(latelyEnroll.getAnimalage()));
      
      
      pConR.add(animalcateA);
      pConR.add(animalageA);
      CheckboxGroup rGroup3= new CheckboxGroup();

      if(!latelyEnroll.isGenderless()) {//�߼�ȭ ����
         Checkbox genderX=new Checkbox("��",rGroup3,true);
         Checkbox genderO=new Checkbox("��",rGroup3,false); 
         pConR.add(genderX); 
         pConR.add(genderO);
      }else{
         Checkbox genderX=new Checkbox("��",rGroup3,false);
         Checkbox genderO=new Checkbox("��",rGroup3,true); 
         pConR.add(genderX); 
         pConR.add(genderO);
      }

      TextField nameA=new TextField(16);
      TextField phoneA=new TextField(16);
      pConR.add(nameA);
      pConR.add(phoneA);
      pCon.add(pConR);

      nameA.setText(latelyEnroll.getName());
      phoneA.setText(latelyEnroll.getPhone());
      
      Button btn1 = new Button("����ȭ��");
      Button btn2 = new Button("����");
      btn1.setSize(200, 50);
      btn1.setLocation(0,515);
      btn2.setSize(200, 50);
      btn2.setLocation(201,515);
      pCon.add(btn1);
      pCon.add(btn2);

      f.add(pCon);
      f.setVisible(true);

      //����� �� ��������� �״�� �����ͼ� ����â�� ����ش�.

      //���� ������ �޼��� �˾�â�� �߰� �� �Ŀ� ���â���� �̵�
      dog.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int input=JOptionPane.showConfirmDialog(null,"���� ��Ϲ�ȣ�� �ֽ��ϱ�?","����â", JOptionPane.YES_NO_OPTION);
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

      // ** ����ȭ���̵� �̺�Ʈ �߰� **
      btn1.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            FrameMain reserve = new FrameMain();
            f.setVisible(false);
            reserve.createFrame();
         }

      });

      // ** ���� ��ư �̺�Ʈ �߰�
      btn2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           
           //������, ��ȣ�ڸ�, ��ȣ�� ����ó framediary�� ������
           ArrayList<String> list = new ArrayList<String>();
           list.add(animalnameA.getText());
           list.add(nameA.getText());
           list.add(phoneA.getText());
           
           f.setVisible(false);
           new FrameDiary(new DiaryModel(),list);
           
//           Reserve reserve = new Reserve();//��ü �����ϸ鼭 �� �޾ƿ�
//           
//           
//           FrameMain s = new FrameMain();
//           f.setVisible(false);
//           reserve.createFrame();
        }
         
      });

      //������ ���� ��ư �̺�Ʈ
      f.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }


}

