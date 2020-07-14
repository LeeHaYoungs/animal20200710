package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import movieDAO.MovieDAO;

public class FrameMovieReview extends JPanel {
	public FrameMovieReview() {
		// JPanel 기본 구조
		setBackground(new Color(0xFFD700));
		setLayout(null);
		setSize(600, 800);

		// 상단부 이미지
		ImageIcon popcon = new ImageIcon("popcon2.png");
		JLabel lblPopcon = new JLabel(popcon);
		lblPopcon.setSize(600, 280);
		lblPopcon.setLocation(0, 0);
		add(lblPopcon);

		// 후기 남길 영화 선택(라디오버튼)
		JPanel dis2 = new JPanel(); // 평점 패널 생성
		dis2.setLayout(new GridLayout(3, 3));
		dis2.setBounds(0, 280, 600, 220);

		dis2.setBorder(
			new TitledBorder( null, //테두리없음
			"평점 줄 영화 선택", //내용
			TitledBorder.LEADING, //텍스트 정렬방식:양쪽정렬
			TitledBorder.TOP, //텍스트 표시 위치 : 상단
			null, //폰트 지정안함
			new Color(255, 122, 144) )); //색상

		JRadioButton movie1 = new JRadioButton("라라랜드");
		JRadioButton movie2 = new JRadioButton("말할수없는비밀");
		JRadioButton movie3 = new JRadioButton("인사이드아웃");
		JRadioButton movie4 = new JRadioButton("겨울왕국");
		JRadioButton movie5 = new JRadioButton("당신거기있어줄래요");
		JRadioButton movie6 = new JRadioButton("스파이더맨");
		JRadioButton movie7 = new JRadioButton("어벤져스");
		JRadioButton movie8 = new JRadioButton("부산행");
		add(dis2);

		// 평점 점수 받기 (라디오 버튼)
		JPanel dis1 = new JPanel(); // 라디오 버튼, 한줄평 받을 패널 생성
		dis1.setBorder(new TitledBorder(
				null, //테두리없음
				"리뷰남기기", TitledBorder.LEADING, //텍스트 정렬방식:양쪽정렬
				TitledBorder.TOP, //텍스트 표시 위치 : 상단
				null, //폰트 지정안함
				null));//색상 지정안함
		
		dis1.add(new JLabel("평점 "));
		JRadioButton point1 = new JRadioButton("1점");
		JRadioButton point2 = new JRadioButton("2점");
		JRadioButton point3 = new JRadioButton("3점");
		JRadioButton point4 = new JRadioButton("4점");
		JRadioButton point5 = new JRadioButton("5점");

		dis1.add(point1);
		dis1.add(point2);
		dis1.add(point3);
		dis1.add(point4);
		dis1.add(point5);

		ButtonGroup group2 = new ButtonGroup();
		group2.add(point1);
		group2.add(point2);
		group2.add(point3);
		group2.add(point4);
		group2.add(point5);

		dis1.setSize(600, 120);
		dis1.setLocation(0, 500);

		// 작성자 이름
		TextField reviewName = new TextField("작성자 이름", 40);
		reviewName.setBounds(0, 430, 50, 100);
		dis1.add(reviewName);

		// 한줄 평 입력받기
		TextField review = new TextField("한줄평을 입력해주세요.(30 글자 미만)", 50);
		review.setBounds(0, 430, 400, 100);
		dis1.add(review);

		JButton btn = new JButton("완료");
		btn.setBounds(400, 430, 200, 100);
		dis1.add(btn);
		btn.setEnabled(false);

		add(dis1);
		dis1.setVisible(false);

		// 영화 라디오버튼 정보
		String mName[] = { "라라랜드", "말할수없는비밀", "인사이드아웃", 
					"겨울왕국", "당신거기있어줄래요", "스파이더맨", 
					"어벤져스", "부산행" };
		ButtonGroup group1 = new ButtonGroup();
		JRadioButton movie[] = new JRadioButton[8];


		for (int i = 0; i < mName.length; i++) {
			movie[i] = new JRadioButton(mName[i]);
			movie[i].setFont(new Font("나눔고딕코딩", Font.BOLD, 16));
			
			dis2.add(movie[i]);
			group1.add(movie[i]);
			
			//각 라디오버튼에 클릭 이벤트 감지
			movie[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
			//어떤 라디오버튼이든 선택하는 순간 한줄평 작성폼이 화면에 보여진다.
					dis1.setVisible(true);
					
					String[] movieurl = { 
				"라라랜드.png", "말할수없는비밀.jpg", "인사이드아웃.png", 
				"겨울왕국.png", "당신거기있어줄래요.png", "스파이더맨.png", 
				"어벤져스.png", "부산행.png" };
					
					//평가를 위해 선택한 영화를 index로 기억한다
					int movieIndex = 0;
					if (e.getActionCommand().equals("라라랜드")) {
						movieIndex = 0;
					} else if (e.getActionCommand().equals("말할수없는비밀")) {
						movieIndex = 1;
					} else if (e.getActionCommand().equals("인사이드아웃")) {
						movieIndex = 2;
					} else if (e.getActionCommand().equals("겨울왕국")) {
						movieIndex = 3;
					} else if (e.getActionCommand().equals("당신거기있어줄래요")) {
						movieIndex = 4;
					} else if (e.getActionCommand().equals("스파이더맨")) {
						movieIndex = 5;
					} else if (e.getActionCommand().equals("어벤져스")) {
						movieIndex = 6;
					} else if (e.getActionCommand().equals("부산행")) {
						movieIndex = 7;
					}
				}//actionPerformed
			});
			
		}//for

		// 한줄 평 등록(30글자 이상, 빈 문자열은 등록불가)
		review.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				if (review.getText().equals("")) {
					btn.setEnabled(false);
					
				} else if (review.getText().length() > 30) {
					btn.setEnabled(false);
				
				} else if (review.getText().equals("한줄평을 입력해주세요.(30 글자 미만)")) {
					btn.setEnabled(false);
					
				} else {
					//1 ~ 30자 범위의 평가가 있을때만 완료버튼 활성화
					btn.setEnabled(true);
				}
			}
		});

		// 작성자 이름 창 클릭시 텍스트 힌트 제거
		reviewName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (reviewName.getText().equals("작성자 이름")) {
					reviewName.setText("");
				}
			}
		});

		// 한줄 평 창 클릭시 텍스트 힌트 제거
		review.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (review.getText().equals("한줄평을 입력해주세요.(30 글자 미만)")) {
					review.setText("");
				}
			}
		});

		// 완료 버튼
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (point1.isSelected() || point2.isSelected() || 
						point3.isSelected() || point4.isSelected() || 
							point5.isSelected()) {
					
					if (reviewName.getText().equals("")) {
						reviewName.setText("익명");
						
					} else if (reviewName.getText().equals("작성자 이름")) {
						reviewName.setText("익명");
						
					}
					
					//몇 점 줬는지 확인하기
					int num = 0;
					if (point1.isSelected()) {
						num = 1;
					} else if (point2.isSelected()) {
						num = 2;
					} else if (point3.isSelected()) {
						num = 3;
					} else if (point4.isSelected()) {
						num = 4;
					} else if (point5.isSelected()) {
						num = 5;
					}

					for (int i = 0; i < movie.length; i++) {
					    if (movie[i].isSelected()) {
						//작성한 후기를 영화 리스트에 추가
						new MovieDAO().inputReview(
							movie[i].getText(), reviewName.getText(), 
							review.getText(), num);
				           }
					}//for
					
					JOptionPane.showMessageDialog(
							null, "리뷰 작성을 완료하였습니다.");
					FrameBase.getInstance(new FrameBegin());
					
				} else {
					//점수를 주지 않은경우
					JOptionPane.showMessageDialog(
							null, "평점을 입력해주세요.");
				}
			}//actionPerformed
		});

		// 뒤로가기 버튼
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
				FrameBase.getInstance(new FrameBegin());
			}
		});

		add(bottomSet, BorderLayout.SOUTH);

	}//생성자
}
