package base;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMain {

	public void createFrame() {
		Frame f = new Frame();
		f.setBounds(0, 100, 400, 600);
		
		Panel p1 = new Panel();//Ÿ��Ʋ �ִ� �г�
		Panel p2 = new Panel();	//�ϴ� ��ư2�� �г�
		
		Label title = new Label("BOA4 ��������");
		Button reserve_btn = new Button("���Ό��");
		Button confirm_btn = new Button("����Ȯ��");
		
		reserve_btn.setPreferredSize(new Dimension(100,100));
		confirm_btn.setPreferredSize(new Dimension(100,100));
		p1.add(title);
		
		p2.add(reserve_btn);
		p2.add(confirm_btn);
		p2.setLayout(new FlowLayout());

		f.add(p1, BorderLayout.NORTH);//Ÿ��Ʋ		
		f.add(p2,BorderLayout.SOUTH);//��ư
		
		f.setVisible(true);

		//WindowClosing ������ MyEventListener�� frame�� windowListener�� ����
		f.addWindowListener(new MyEventListener());
		
		//�����ϱ� ��ư �׼Ǹ�����
		reserve_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameReserve reserve = new FrameReserve();
				f.setVisible(false);
				reserve.createFrame();
			}
		});
	}
	

}