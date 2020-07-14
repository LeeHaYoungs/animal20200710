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

	public FrameMovieInfo( Movie m ) { //클릭한 이미지의 정보를 생성자 파라미터로 받는다.
		// JPanel 구조
		setBackground(new Color(250, 244, 192));
		setLayout(null);
		setSize(600, 800);

		
		// 포스터 부분
		final int movieNum = 8;
		int movieflag = 0;
		String[] movieurl = { 
			"라라랜드2.png", "말할수없는비밀2.jpg", "인사이드아웃2.png", 
			"겨울왕국2.png", "당신거기있어줄래요2.png", "스파이더맨2.png",
			"어벤져스2.png", "부산행2.png" };

		ImageIcon[] movieImg = new ImageIcon[movieNum];

		for (int i = 0; i < movieNum; i++) {
	
			movieImg[i] = new ImageIcon( movieurl[i] );
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

		JLabel img = new JLabel( movieImg[movieflag] );
		img.setBounds(50, 13, 285, 350);
		add(img);

		// 영화 관련 정보 텍스트
		TextArea story = new TextArea(
				"\n◎영화제목" + "\n" + "   " + m.getmName() + 
				"\n\n" + "◎평     점" + "\n" + "   " + 
				String.format("%.1f", m.getScore()) + " / 5 점\n\n" + 
				"◎줄 거 리" + "\n" + "   " + m.getStory(),
				0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		story.setSize(580, 280);
		story.setLocation(0, 375);
		story.setBackground(new Color(0xFFD700));
		story.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		add(story);

		// 등록된 후기 보기
		JButton btnReview = new JButton("리뷰 보기");

		btnReview.setBackground(new Color(229, 216, 92));
		btnReview.setSize(150, 40);
		btnReview.setLocation(400, 325);
		btnReview.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));

		btnReview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//리뷰보기 기능 추가 예정
				new FrameReviewRead(m);

			}
		});
		add(btnReview);

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

		JButton btnHome = new JButton("처음 화면으로");

		btnHome.setBackground(new Color(0xA6A6A6));
		btnHome.setSize(183, 87);
		btnHome.setLocation(198, 0);
		btnHome.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(btnHome);

		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameBegin());
			}
		});

		JButton btnBuy = new JButton("예매하기");

		btnBuy.setBackground(new Color(0xA6A6A6));
		btnBuy.setSize(183, 87);
		btnBuy.setLocation(391, 0);
		btnBuy.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(btnBuy);

		btnBuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//예매하기 기능 추가 예정
				FrameBase.getInstance(new FrameReserve(m));

			}
		});

		add(bottomSet, BorderLayout.SOUTH);

	}//생성자
}

