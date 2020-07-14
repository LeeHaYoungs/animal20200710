package frame;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import movieDAO.MovieDAO;
import movieVO.Movie;
import movieVO.MyMovie;

public class FrameReserve extends JPanel {
	public FrameReserve( Movie m ) {
		//JPanel ����
		setBackground(new Color(0xFFD700)); 
		setLayout(null);
		setSize(600, 800);

		JPanel top = new JPanel();
		top.setBackground(new Color(0xFFD700));
		top.setLayout(null);
		top.setSize(600, 300);
		top.setLocation(0, 0);
		
		JPanel center = new JPanel();
		center.setBackground(new Color(0xFFD700)); 
		center.setLayout(new GridLayout(5, 8));
		center.setSize(600, 350);
		center.setLocation(0, 305);
		
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(0xFFD700)); 
		bottom.setLayout(null);
		bottom.setSize(600, 200);
		bottom.setLocation(0, 660);

		//��� JPanel(��ȭ ������,��ȭ �̸�, �ð��� ����)
		final int movieNum = 8;
		int movieflag = 0;
		String[] movieurl = { 
				"��󷣵�.png", "���Ҽ����º��.jpg", "�λ��̵�ƿ�.png", 
				"�ܿ�ձ�.png", "��Űű��־��ٷ���.png", "�����̴���.png",
				"�����.png", "�λ���.png" };

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
		}//for

		JLabel img = new JLabel(movieImg[movieflag]);
		img.setBounds(50, 15, 175, 248);

		JLabel name = new JLabel(m.getmName());
		name.setFont(new Font("��������ڵ�", Font.BOLD, 32));
		name.setBounds(260, 35, 300, 175);

		Choice movieTime = new Choice();
		long time = System.currentTimeMillis();

		SimpleDateFormat dayTime = 
			new SimpleDateFormat("MM�� dd��(EE)");//(EE:����)

		String str = dayTime.format( new Date(time) );

		String[] timeSlot = { 
				"�ð��� ����", 
				str + " 06:30~08:30", 
				str + " 09:00~11:00", 
				str + " 11:30~13:30",
				str + " 14:00~16:00", 
				str + " 16:30~18:30", 
				str + " 19:00~21:30", 
				str + " 22:00~00:00",
				str + " 00:30~02:30" };

		for (int i = 0; i < timeSlot.length; i++) {
			movieTime.add(timeSlot[i]);
		}

		movieTime.setFont(new Font("��������ڵ�", Font.PLAIN, 18));
		movieTime.setSize(270, 200);
		movieTime.setLocation(260, 200);

		JLabel screen = new JLabel("[��   ũ   ��]");
		screen.setFont(new Font("��������ڵ�", Font.BOLD, 32));
		screen.setBounds(180, 223, 240, 120);
		screen.setVisible(false);

		//�߹ݺ� JPanel(�¼� ����)
		ButtonGroup bg = new ButtonGroup();
		final int seatNum = 8 * 5;
		JRadioButton[] seatChoice = new JRadioButton[seatNum];
		String[] seatn = { "1", "2", "3", "4", "5", "6", "7", "8" };
		String seatAl = "A";
		
		//a1 ~ a8
		//....
		//e1 ~ e8 ���� 5�� 8���� �¼���ġ�� ȭ�鿡 �׸���.
		for (int i = 0; i < 5; i++) {
			
			if (i == 1) {
				seatAl = "B";
			} else if (i == 2) {
				seatAl = "C";
			} else if (i == 3) {
				seatAl = "D";
			} else if (i == 4) {
				seatAl = "E";
			}
			
			for (int j = 0; j < 8; j++) {
				seatChoice[(i * 8) + j] = new JRadioButton( seatAl + seatn[j] );
				bg.add(seatChoice[(i * 8) + j]);
				center.add(seatChoice[(i * 8) + j]);
				seatChoice[(i * 8) + j].setVisible(false);
			}

		}//for

		//�ϴ��� ��ư
		JButton btnBack = new JButton("�ڷΰ���");

		btnBack.setBackground(new Color(0xA6A6A6));
		btnBack.setSize(183, 87);
		btnBack.setLocation(5, 0);
		btnBack.setFont(new Font("��������ڵ�", Font.BOLD, 22));
		bottom.add(btnBack);

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameMovieInfo(m));
			}
		});

		JButton btnHome = new JButton("ó�� ȭ������");

		btnHome.setBackground(new Color(0xA6A6A6));
		btnHome.setSize(183, 87);
		btnHome.setLocation(198, 0);
		btnHome.setFont(new Font("��������ڵ�", Font.BOLD, 22));
		bottom.add(btnHome);

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
		bottom.add(btnBuy);

		//�����ϱ� ��ư ��ȿ�� üũ
		btnBuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MyMovie myM = new MyMovie();
				myM.setmName(m.getmName());
				myM.setTime(movieTime.getSelectedItem());
				int seatIndex = -1;
				for (int i = 0; i < seatNum; i++) {
					if (seatChoice[i].isSelected()) {
						seatIndex = i;
					}
				}

				if (movieTime.getSelectedItem().equals("�ð��� ����")) {
					JOptionPane.showMessageDialog(
							null, "�ð��� ������ �ּ���");
					
				} else if (seatIndex == -1) {
					JOptionPane.showMessageDialog(
							null, "�¼��� ������ �ּ���");
					
				} else {
					myM.setSeat(seatChoice[seatIndex].getText());
					//���� ���� �ڵ� �߰� ����FrameBase.getInstance(
					FrameBase.getInstance(
							new FrameMovieConfirm(m, myM));


				}
			}
		});//addActionListener

		top.add(movieTime);
		top.add(img);
		top.add(name);
		top.add(screen);

		add(top);
		add(center);
		add(bottom);

		//�̹� ��ϵ� ���� �������� Ȯ�� �� ��Ȯ�� ���� �������� Ȯ��
		movieTime.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				for (int i = 0; i < seatNum; i++) {
					seatChoice[i].setEnabled(true);
				}

				
				//choice�� ���ð��� ���á����� �Ǿ� �������� �¼��޴� ��Ȱ��ȭ
				if (e.getItem().equals("�ð��� ����")) {
					
					for (int i = 0; i < seatNum; i++) {
						seatChoice[i].setVisible(false);
						screen.setVisible(false);
					}
					
				} else {
					
					//�׷��� �ʴٸ� �¼��޴� Ȱ��
					for (int i = 0; i < seatNum; i++) {
						seatChoice[i].setVisible(true);
						screen.setVisible(true);
					}
				}

				MovieDAO setSeat = new MovieDAO();
				for (int j = 0; j < seatNum; j++) {
					
					if (setSeat.dupSeat(
							m.getmName(),
							e.getItem().toString(), 
							seatChoice[j].getText())) {
						
						//�̹� ����� �¼��� ��Ȱ��ȭ
						seatChoice[j].setEnabled(false);
					}
				}//for
			}//itemStateChanged
		}); //addItemListener
	}//������
}
