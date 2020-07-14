package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import movieDAO.MovieDAO;
import movieVO.Movie;

public class FrameMovieSelect extends JPanel {

	//�����ڿ� ���� �߰�
		public FrameMovieSelect() {

			//JPanel ����
			setBackground(new Color(0xFFD700));
			setLayout(null);
			setSize(600,2000);

			//��ȭ1�� ����
			ImageIcon movie1 = new ImageIcon("��󷣵�.png");
			JButton btnMovie1 = new JButton(movie1);
			btnMovie1.setName("��󷣵�");

			btnMovie1.setSize(185,250);
			btnMovie1.setLocation(72,30);
			add(btnMovie1);

			btnMovie1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Movie movie1 = new MovieDAO().searchMovie("��󷣵�");
					FrameBase.getInstance( new FrameMovieInfo(movie1) );
					//�����͸� Ŭ���ص� ���� �󼼺���� �������� �ʰ� �ִ�.
				}
			});

			//��ȭ2�� ����
			ImageIcon movie2 = new ImageIcon("���Ҽ����º��.jpg");
			JButton btnMovie2 = new JButton(movie2);
			btnMovie2.setName("���Ҽ����º��");

			btnMovie2.setSize(185,250);
			btnMovie2.setLocation(320,30);
			add(btnMovie2);

			btnMovie2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Movie movie2 = new MovieDAO().searchMovie("���Ҽ����º��");
					FrameBase.getInstance( new FrameMovieInfo(movie2) );
					//�����͸� Ŭ���ص� ���� �󼼺���� �������� �ʰ� �ִ�.
				}
			});

			//��ȭ3�� ����
			ImageIcon movie3 = new ImageIcon("�λ��̵�ƿ�.png");
			JButton btnMovie3 = new JButton(movie3);
			btnMovie3.setName("�λ��̵�ƿ�");

			btnMovie3.setSize(185,250);
			btnMovie3.setLocation(72,340);
			add(btnMovie3);

			btnMovie3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Movie movie3 = new MovieDAO().searchMovie("�λ��̵�ƿ�");
					FrameBase.getInstance( new FrameMovieInfo(movie3) );

					//�����͸� Ŭ���ص� ���� �󼼺���� �������� �ʰ� �ִ�.
				}
			});

			//��ȭ4�� ����
			ImageIcon movie4 = new ImageIcon("�ܿ�ձ�.png");
			JButton btnMovie4 = new JButton(movie4);
			btnMovie4.setName("�ܿ�ձ�");

			btnMovie4.setSize(185,250);
			btnMovie4.setLocation(320,340);
			add(btnMovie4);

			btnMovie4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Movie movie4 = new MovieDAO().searchMovie("�ܿ�ձ�");
					FrameBase.getInstance( new FrameMovieInfo(movie4) );

					//�����͸� Ŭ���ص� ���� �󼼺���� �������� �ʰ� �ִ�.
				}
			});

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
					FrameBase.getInstance(new FrameBegin());
				}
			});

			JButton btnNext = new JButton("���� ������");

			btnNext.setBackground(new Color(0xA6A6A6));
			btnNext.setSize(183, 87);
			btnNext.setLocation(391, 0);
			btnNext.setFont(new Font("��������ڵ�", Font.BOLD, 22));
			bottomSet.add(btnNext);

			btnNext.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//������������ �Ѿ�� ��� �������� �Ѵ�.
					//FrameMovieSelect2 Ŭ������ ���� 1���� �����ϰ� ���� ó��
					FrameBase.getInstance( new FrameMovieSelect2() );
				}
			});

			add(bottomSet, BorderLayout.SOUTH);

		}//������
	}

