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
		//JPanel 구조
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

		//상단 JPanel(영화 포스터,영화 이름, 시간대 선택)
		final int movieNum = 8;
		int movieflag = 0;
		String[] movieurl = { 
				"라라랜드.png", "말할수없는비밀.jpg", "인사이드아웃.png", 
				"겨울왕국.png", "당신거기있어줄래요.png", "스파이더맨.png",
				"어벤져스.png", "부산행.png" };

		ImageIcon[] movieImg = new ImageIcon[movieNum];

		for (int i = 0; i < movieNum; i++) {
			movieImg[i] = new ImageIcon(movieurl[i]);
			if (m.getmName().equals("라라랜드")) {
				movieflag = 0;
			} else if (m.getmName().equals("말할수없는비밀")) {
				movieflag = 1;
			} else if (m.getmName().equals("인사이드아웃")) {
				movieflag = 2;
			} else if (m.getmName().equals("겨울왕국")) {
				movieflag = 3;
			} else if (m.getmName().equals("당신거기있어줄래요")) {
				movieflag = 4;
			} else if (m.getmName().equals("스파이더맨")) {
				movieflag = 5;
			} else if (m.getmName().equals("어벤져스")) {
				movieflag = 6;
			} else if (m.getmName().equals("부산행")) {
				movieflag = 7;
			}
		}//for

		JLabel img = new JLabel(movieImg[movieflag]);
		img.setBounds(50, 15, 175, 248);

		JLabel name = new JLabel(m.getmName());
		name.setFont(new Font("나눔고딕코딩", Font.BOLD, 32));
		name.setBounds(260, 35, 300, 175);

		Choice movieTime = new Choice();
		long time = System.currentTimeMillis();

		SimpleDateFormat dayTime = 
			new SimpleDateFormat("MM월 dd일(EE)");//(EE:요일)

		String str = dayTime.format( new Date(time) );

		String[] timeSlot = { 
				"시간대 선택", 
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

		movieTime.setFont(new Font("나눔고딕코딩", Font.PLAIN, 18));
		movieTime.setSize(270, 200);
		movieTime.setLocation(260, 200);

		JLabel screen = new JLabel("[스   크   린]");
		screen.setFont(new Font("나눔고딕코딩", Font.BOLD, 32));
		screen.setBounds(180, 223, 240, 120);
		screen.setVisible(false);

		//중반부 JPanel(좌석 선택)
		ButtonGroup bg = new ButtonGroup();
		final int seatNum = 8 * 5;
		JRadioButton[] seatChoice = new JRadioButton[seatNum];
		String[] seatn = { "1", "2", "3", "4", "5", "6", "7", "8" };
		String seatAl = "A";
		
		//a1 ~ a8
		//....
		//e1 ~ e8 까지 5행 8열의 좌석배치를 화면에 그린다.
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

		//하단의 버튼
		JButton btnBack = new JButton("뒤로가기");

		btnBack.setBackground(new Color(0xA6A6A6));
		btnBack.setSize(183, 87);
		btnBack.setLocation(5, 0);
		btnBack.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottom.add(btnBack);

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameMovieInfo(m));
			}
		});

		JButton btnHome = new JButton("처음 화면으로");

		btnHome.setBackground(new Color(0xA6A6A6));
		btnHome.setSize(183, 87);
		btnHome.setLocation(198, 0);
		btnHome.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottom.add(btnHome);

		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameBegin());
			}
		});

		JButton btnBuy = new JButton("결제하기");

		btnBuy.setBackground(new Color(0xA6A6A6));
		btnBuy.setSize(183, 87);
		btnBuy.setLocation(391, 0);
		btnBuy.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottom.add(btnBuy);

		//결제하기 버튼 유효성 체크
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

				if (movieTime.getSelectedItem().equals("시간대 선택")) {
					JOptionPane.showMessageDialog(
							null, "시간을 선택해 주세요");
					
				} else if (seatIndex == -1) {
					JOptionPane.showMessageDialog(
							null, "좌석을 선택해 주세요");
					
				} else {
					myM.setSeat(seatChoice[seatIndex].getText());
					//결제 성공 코드 추가 예정FrameBase.getInstance(
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

		//이미 등록된 예매 정보인지 확인 및 정확한 예매 정보인지 확인
		movieTime.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				for (int i = 0; i < seatNum; i++) {
					seatChoice[i].setEnabled(true);
				}

				
				//choice가 “시간대 선택”으로 되어 있을때는 좌석메뉴 비활성화
				if (e.getItem().equals("시간대 선택")) {
					
					for (int i = 0; i < seatNum; i++) {
						seatChoice[i].setVisible(false);
						screen.setVisible(false);
					}
					
				} else {
					
					//그렇지 않다면 좌석메뉴 활성
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
						
						//이미 예약된 좌석은 비활성화
						seatChoice[j].setEnabled(false);
					}
				}//for
			}//itemStateChanged
		}); //addItemListener
	}//생성자
}
