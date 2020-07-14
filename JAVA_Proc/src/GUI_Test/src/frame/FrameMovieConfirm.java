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

		//JPanel 구조
		setBackground(new Color(0xFFD700));
		setLayout(null);
		setSize(600, 800);

		//영화 포스터
		final int movieNum = 8;
		int movieflag = 0;
		String[] movieurl = { 
				"라라랜드2.png", "말할수없는비밀2.jpg", "인사이드아웃2.png", 
				"겨울왕국2.png", "당신거기있어줄래요2.png", "스파이더맨2.png",
				"어벤져스2.png", "부산행2.png" };

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
		}//for()

		JLabel img = new JLabel(movieImg[movieflag]);
		img.setBounds(155, 13, 285, 350);
		add(img);

		//예매 정보 확인 창
		TextArea story = new TextArea(
				"\n◎ 영화제목 : " + m.getmName() + "\n\n" + 
				"◎ 영화시간 : " + e.getTime() + "\n\n"
				+ "◎ 좌     석 : " + e.getSeat() + "\n\n" + 
				"◎ 금     액 : " + m.getPrice() + "원", 0, 0,
				TextArea.SCROLLBARS_NONE);
		
		story.setSize(580, 280);
		story.setLocation(0, 375);
		story.setBackground(new Color(0xFFD700));
		story.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		add(story);

		//하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(0, 660, 600, 100);
		bottomSet.setLayout(null);
		bottomSet.setBackground(new Color(0xFFD700));

		JButton btnBack = new JButton("뒤로가기");

		btnBack.setBackground(new Color(0xA6A6A6));
		btnBack.setSize(183, 87);
		btnBack.setLocation(5, 0);
		btnBack.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(btnBack);

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameReserve(m));
			}
		});

		//최종결제 버튼
		JButton btnBuy = new JButton("결제하기");

		btnBuy.setBackground(new Color(0xA6A6A6));
		btnBuy.setSize(183, 87);
		btnBuy.setLocation(391, 0);
		btnBuy.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(btnBuy);

		//결제하기 버튼 클릭
		btnBuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				new MovieDAO().addReserveInfo(e);
				JOptionPane.showMessageDialog(
					null, "영화제목 : " + m.getmName() + "\n" + 
					"영화시간 : " + e.getTime() + "\n" + 
					"좌석 : " + e.getSeat() + "\n" + 
					"금액 : " + m.getPrice() + "원 입니다.");
				//결제를 마치고 첫 페이지로 보낸다.
				FrameBase.getInstance(new FrameBegin());
			}
		});

		add(bottomSet, BorderLayout.SOUTH);

	}//생성자
}

