package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
	
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setBounds(0, 100, 400, 400);
		

		Panel p1 = new Panel();//Ÿ��Ʋ �ִ� �г�
		Panel p2 = new Panel();	//�ϴ� ��ư2�� �г�
		
		Label title = new Label("BOA4 ��������");
		Button reserve_btn = new Button("���Ό��");
		Button confirm_btn = new Button("����Ȯ��");

		p1.add(title);
		
		p2.add(reserve_btn);
		p2.add(confirm_btn);
		p2.setLayout(new FlowLayout());

		frame.add(p1, BorderLayout.NORTH);//Ÿ��Ʋ		
		frame.add(p2,BorderLayout.SOUTH);//��ư
		
		frame.setVisible(true);

		//WindowClosing ������ MyEventListener�� frame�� windowListener�� ����
		frame.addWindowListener(new MyEventListener());
		
		//�����ϱ� ��ư �׼Ǹ�����
		reserve_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				main2 m2 = new main2();
				frame.setVisible(false);
				m2.createFrame();
			}
			
		});
	}
}