package GUI_Test.src.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI_Test.src.movieVO.Movie;

public class FrameMovieInfo extends JPanel {

	public FrameMovieInfo( Movie m ) { //Ŭ���� �̹����� ������ ������ �Ķ���ͷ� �޴´�.
		// JPanel ����
		setBackground(new Color(250, 244, 192));
		setLayout(null);
		setSize(600, 800);

		
		// ������ �κ�
		final int movieNum = 8;
		int movieflag = 0;
		String[] movieurl = { 
			"��󷣵�2.png", "���Ҽ����º��2.jpg", "�λ��̵�ƿ�2.png", 
			"�ܿ�ձ�2.png", "��Űű��־��ٷ���2.png", "�����̴���2.png",
			"�����2.png", "�λ���2.png" };

		ImageIcon[] movieImg = new ImageIcon[movieNum];

		for (int i = 0; i < movieNum; i++) {
	
			movieImg[i] = new ImageIcon( movieurl[i] );
			if (m.getmName().equals("��󷣵�")) {
				movieflag = 0;
			} else if (m.getmName().equals("���Ҽ����º��")) {
				movieflag = 1;
			} else if (m.getmName().equals("�λ��̵�ƿ�")) {
				movieflag = 2;
			} else if (m.getmName().equals("�ܿ�ձ�")) {
				movieflag = 3;
			} else if (m.getmName().equals("��Űű��־��ٷ���")) {
				movieflag = 4;
			} else if (m.getmName().equals("�����̴���")) {
				movieflag = 5;
			} else if (m.getmName().equals("�����")) {
				movieflag = 6;
			} else if (m.getmName().equals("�λ���")) {
				movieflag = 7;
			}
		}//for

		JLabel img = new JLabel( movieImg[movieflag] );
		img.setBounds(50, 13, 285, 350);
		add(img);

		// ��ȭ ���� ���� �ؽ�Ʈ
		TextArea story = new TextArea(
				"\n�ݿ�ȭ����" + "\n" + "   " + m.getmName() + 
				"\n\n" + "����     ��" + "\n" + "   " + 
				String.format("%.1f", m.getScore()) + " / 5 ��\n\n" + 
				"���� �� ��" + "\n" + "   " + m.getStory(),
				0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		story.setSize(580, 280);
		story.setLocation(0, 375);
		story.setBackground(new Color(0xFFD700));
		story.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		add(story);

		// ��ϵ� �ı� ����
		JButton btnReview = new JButton("���� ����");

		btnReview.setBackground(new Color(229, 216, 92));
		btnReview.setSize(150, 40);
		btnReview.setLocation(400, 325);
		btnReview.setFont(new Font("��������ڵ�", Font.BOLD, 18));

		btnReview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//���亸�� ��� �߰� ����
				new FrameReviewRead(m);

			}
		});
		add(btnReview);

		//�ϴ��� ��ư
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(0, 660, 600, 100);
		bottomSet.setLayout(null);
		bottomSet.setBackground(new Color(0xFFD700));

		JButton btnBack = new JButton("�ڷΰ���");
		btnBack.setBackground(new Color(0xA6A6A6));
		btnBack.setSize(183, 87);
		btnBack.setLocation(5, 0);
		btnBack.setFont(new Font("��������ڵ�", Font.BOLD, 22));
		bottomSet.add(btnBack);

		int buttonNum = movieflag;
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (0 <= buttonNum && buttonNum <= 3) {
					FrameBase.getInstance(new FrameMovieSelect());
				} else {
					FrameBase.getInstance(new FrameMovieSelect2());
				}
			}
		});

		JButton btnHome = new JButton("ó�� ȭ������");

		btnHome.setBackground(new Color(0xA6A6A6));
		btnHome.setSize(183, 87);
		btnHome.setLocation(198, 0);
		btnHome.setFont(new Font("��������ڵ�", Font.BOLD, 22));
		bottomSet.add(btnHome);

		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameBegin());
			}
		});

		JButton btnBuy = new JButton("�����ϱ�");

		btnBuy.setBackground(new Color(0xA6A6A6));
		btnBuy.setSize(183, 87);
		btnBuy.setLocation(391, 0);
		btnBuy.setFont(new Font("��������ڵ�", Font.BOLD, 22));
		bottomSet.add(btnBuy);

		btnBuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//�����ϱ� ��� �߰� ����
				FrameBase.getInstance(new FrameReserve(m));

			}
		});

		add(bottomSet, BorderLayout.SOUTH);

	}//������
}

