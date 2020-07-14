package GUI_Test.src.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import GUI_Test.src.movieDAO.MovieDAO;
import GUI_Test.src.movieVO.Movie;

public class FrameMovieSelect2 extends JPanel{

	//�����ڿ� ���� �߰�
	   public FrameMovieSelect2() {
	      //JPanel ����
	      setBackground(new Color(0xFFD700));
	      setLayout(null);
	      setSize(600,2000);
	      
	      //��ȭ5�� ����
	      ImageIcon movie5 = new ImageIcon("��Űű��־��ٷ���.png");
	      JButton btnMovie5 = new JButton(movie5);
	      btnMovie5.setName("��Űű��־��ٷ���");
	      
	      btnMovie5.setSize(185,250);
	      btnMovie5.setLocation(72,30);
	      add(btnMovie5);
	      
	      btnMovie5.addActionListener(new ActionListener() {
	         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            Movie movie5 = new MovieDAO().searchMovie("��Űű��־��ٷ���");
				FrameBase.getInstance( new FrameMovieInfo(movie5) );

	         }
	      });
	      
	      //��ȭ6�� ����
	      ImageIcon movie6 = new ImageIcon("�����̴���.png");
	      JButton btnMovie6 = new JButton(movie6);
	      btnMovie6.setName("�����̴���");
	      
	      btnMovie6.setSize(185,250);
	      btnMovie6.setLocation(320,30);
	      add(btnMovie6);
	      
	      btnMovie6.addActionListener(new ActionListener() {
	         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            Movie movie6 = new MovieDAO().searchMovie("�����̴���");
				FrameBase.getInstance( new FrameMovieInfo(movie6) );

	         }
	      });
	      
	      //��ȭ7�� ����
	      ImageIcon movie7 = new ImageIcon("�����.png");
	      JButton btnMovie7 = new JButton(movie7);
	      btnMovie7.setName("�����");
	      
	      btnMovie7.setSize(185,250);
	      btnMovie7.setLocation(72,340);
	      add(btnMovie7);
	      
	      btnMovie7.addActionListener(new ActionListener() {
	         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            Movie movie7 = new MovieDAO().searchMovie("�����");
				FrameBase.getInstance( new FrameMovieInfo(movie7) );

	         }
	      });
	      
	      //��ȭ8�� ����
	      ImageIcon movie8 = new ImageIcon("�λ���.png");
	      JButton btnMovie8 = new JButton(movie8);
	      btnMovie8.setName("�λ���");
	      
	      btnMovie8.setSize(185,250);
	      btnMovie8.setLocation(320,340);
	      add(btnMovie8);
	      
	      btnMovie8.addActionListener(new ActionListener() {
	         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            Movie movie8 = new MovieDAO().searchMovie("�λ���");
				FrameBase.getInstance( new FrameMovieInfo(movie8) );

	         }
	      });
	      
	      //�ϴ��� ��ư ����
	       JPanel bottomSet = new JPanel();

	         bottomSet.setBounds(0, 660, 600, 100);
	         bottomSet.setLayout(null);
	         bottomSet.setBackground(new Color(0xFFD700));
	         
	         JButton btnBack = new JButton("���� ������");

	         btnBack.setBackground(new Color(0xA6A6A6));
	         btnBack.setSize(183, 87);
	         btnBack.setLocation(5, 0);
	         btnBack.setFont(new Font("��������ڵ�", Font.BOLD, 22));
	         bottomSet.add(btnBack);

	         btnBack.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	               FrameBase.getInstance(new FrameMovieSelect());
	

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

	         add(bottomSet, BorderLayout.SOUTH);

	   }//������
	}

