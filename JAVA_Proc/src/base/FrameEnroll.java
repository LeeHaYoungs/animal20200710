package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;

public class FrameEnroll {
   public static void main(String[] args) {

      Frame f=new Frame("������� ������");
      f.setSize(400, 600);
      //f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
      GridLayout grid = new GridLayout(10,2);
      grid.setVgap(5);//�׸��� ���� ���� ���� 5
      
      f.setLayout(grid);
      
      Label la=new Label("�������(��)");
      Font font=new Font("���� ���",Font.BOLD,20);
      la.setFont(font);
      f.add(la);
      
      //������
      Panel p1 = new Panel();

      Label la2=new Label("������");
      TextField tf2=new TextField(20);
      
      p1.setLayout(new FlowLayout());
      p1.add(la2,BorderLayout.WEST);
      p1.add(tf2);
      
      Font font2=new Font("���� ���",Font.PLAIN,15);
      
      la2.setFont(font2);
      tf2.setFont(font2);

      f.add(p1);
      
      //���� ����
      Box b3=Box.createHorizontalBox();
      Label la3=new Label("���� ����");
      CheckboxGroup group=new CheckboxGroup();
      Checkbox s1=new Checkbox("����",group,true);
      Checkbox s2=new Checkbox("����",group,false);
      la3.setFont(font2);
      s1.setFont(font2);
      s2.setFont(font2);
      b3.add(la3);
      b3.add(s1);
      b3.add(s2);
      f.add(b3);
      
      Box b4=Box.createHorizontalBox();
      Label la4=new Label("����");
      TextField tf4=new TextField(20);
      la4.setFont(font2);
      tf4.setFont(font2);
      b4.add(la4);
      b4.add(tf4);
      f.add(b4);
      
      Box b5=Box.createHorizontalBox();
      Label la5=new Label("���� ����");
      TextField tf5=new TextField(20);
      la5.setFont(font2);
      tf5.setFont(font2);
      b5.add(la5);
      b5.add(tf5);
      f.add(b5);
      
      
      Box b6=Box.createHorizontalBox();
      Label la6=new Label("�߼�ȭ ����");
      CheckboxGroup group2=new CheckboxGroup();
      Checkbox y=new Checkbox("��",group2,true);
      Checkbox n=new Checkbox("��",group2,false);
      la6.setFont(font2);
      y.setFont(font2);
      n.setFont(font2);
      b6.add(la6);
      b6.add(y);
      b6.add(n);
      f.add(b6);
      
      Box b7=Box.createHorizontalBox();
      Label la7=new Label("��ȣ�ڸ�");
      TextField tf7=new TextField(20);
      la7.setFont(font2);
      tf7.setFont(font2);
      b7.add(la7);
      b7.add(tf7);
      f.add(b7);
      
      Box b8=Box.createHorizontalBox();
      Label la8=new Label("��ȣ�� ����ó");
      TextField tf8=new TextField(20);
      la8.setFont(font2);
      tf8.setFont(font2);
      b8.add(la8);
      b8.add(tf8);
      f.add(b8);
      
      Panel ps=new Panel();
      Button btne=new Button("���");
      Button btnc=new Button("���");
      ps.setFont(font2);
      ps.add(btne);
      ps.add(btnc);
      f.add(ps,BorderLayout.SOUTH);
      
      f.setVisible(true);
      
      f.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
         
      });
      
   }
}
