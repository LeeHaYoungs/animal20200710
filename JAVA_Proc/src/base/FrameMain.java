package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FrameMain {

   public void createFrame() {
      Frame f = new Frame();
      f.setBounds(0, 100, 400, 600);
      f.setBackground(Color.lightGray);
       f.setLayout(new BorderLayout());
       
       Font fontTitle=new Font(Font.SANS_SERIF,Font.BOLD,24);
       Font fontCon=new Font("���� ���",Font.PLAIN,16);
         
       ImageIcon img=new ImageIcon("������.gif");
       JLabel j=new JLabel(img);
       j.setBounds(50,100,300,300);
       f.add(j);
       
       
       Panel pCon = new Panel();
       pCon.setLayout(null);
       pCon.setSize(400,500);
       
       Panel pTitle=new Panel();
       pTitle.setSize(400, 50);
       Label title=new Label("BOA4 ��������");
       pTitle.setBackground(Color.pink);
       pTitle.setFont(fontTitle);
       pTitle.setLocation(0, 30);
       pTitle.add(title);
       f.add(pTitle);
      
       Button reserve_btn = new Button("���Ό��");
       Button confirm_btn = new Button("����Ȯ��");
       reserve_btn.setSize(200, 50);
       reserve_btn.setLocation(0,515);
       confirm_btn.setSize(200, 50);
       confirm_btn.setLocation(201,515);
       pCon.add(reserve_btn);
       pCon.add(confirm_btn);
          
       f.add(pCon);
      
      f.setVisible(true);

      //WindowClosing ������ MyEventListener�� frame�� windowListener�� ����
      f.addWindowListener(new MyEventListener());
      
      //�����ϱ� ��ư �׼Ǹ�����
      reserve_btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            FrameReserve reserve = new FrameReserve();
            f.setVisible(false);
            reserve.createFrame(null);
         }
      });
      
      //����Ȯ�� ��ư �׼Ǹ�����
      confirm_btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            Appoint1 reserve = new Appoint1();
            f.setVisible(false);
            reserve.createFrame();
         }
      });
   }
   

}