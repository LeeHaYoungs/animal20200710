package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import movieDAO.MovieDAO;
import movieVO.Movie;
import movieVO.MyMovie;

public class FrameMovieConfirm extends JPanel {
	
	public FrameMovieConfirm( Movie m, MyMovie e ) {

		//JPanel ����
		setBackground(new Color(0xFFD700));
		setLayout(null);
		setSize(600, 800);

		//��ȭ ������
		final int movieNum = 8;
		int movieflag = 0;
		String[] movieurl = { 
				"��󷣵�2.png", "���Ҽ����º��2.jpg", "�λ��̵�ƿ�2.png", 
				"�ܿ�ձ�2.png", "��Űű��־��ٷ���2.png", "�����̴���2.png",
				"�����2.png", "�λ���2.png" };

		ImageIcon[] movieImg = new ImageIcon[movieNum];
		for (int i = 0; i < movieNum; i++) {
			movieImg[i] = new ImageIcon(movieurl[i]);
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
		}//for()

		JLabel img = new JLabel(movieImg[movieflag]);
		img.setBounds(155, 13, 285, 350);
		add(img);

		//���� ���� Ȯ�� â
		TextArea story = new TextArea(
				"\n�� ��ȭ���� : " + m.getmName() + "\n\n" + 
				"�� ��ȭ�ð� : " + e.getTime() + "\n\n"
				+ "�� ��     �� : " + e.getSeat() + "\n\n" + 
				"�� ��     �� : " + m.getPrice() + "��", 0, 0,
				TextArea.SCROLLBARS_NONE);
		
		story.setSize(580, 280);
		story.setLocation(0, 375);
		story.setBackground(new Color(0xFFD700));
		story.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		add(story);

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

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameReserve(m));
			}
		});

		//�������� ��ư
		JButton btnBuy = new JButton("�����ϱ�");

		btnBuy.setBackground(new Color(0xA6A6A6));
		btnBuy.setSize(183, 87);
		btnBuy.setLocation(391, 0);
		btnBuy.setFont(new Font("��������ڵ�", Font.BOLD, 22));
		bottomSet.add(btnBuy);

		//�����ϱ� ��ư Ŭ��
		btnBuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				new MovieDAO().addReserveInfo(e);
				JOptionPane.showMessageDialog(
					null, "��ȭ���� : " + m.getmName() + "\n" + 
					"��ȭ�ð� : " + e.getTime() + "\n" + 
					"�¼� : " + e.getSeat() + "\n" + 
					"�ݾ� : " + m.getPrice() + "�� �Դϴ�.");
				//������ ��ġ�� ù �������� ������.
				FrameBase.getInstance(new FrameBegin());
			}
		});

		add(bottomSet, BorderLayout.SOUTH);

	}//������
}

