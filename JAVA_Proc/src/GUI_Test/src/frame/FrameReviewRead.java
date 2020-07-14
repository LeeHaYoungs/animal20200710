package frame;

import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import movieVO.Movie;

public class FrameReviewRead extends JFrame{

	public FrameReviewRead( Movie m ){ //리뷰를 보고싶은 영화 정보를 파라미터로 받아야한다

		//후기 출력 창
	      TextArea review = 
	new TextArea("평점\t이름\t\t\t한줄평\n", 0, 0,TextArea.SCROLLBARS_VERTICAL_ONLY);
	      review.setEditable(false);
	      review.append(m.getReview());
	      review.setSize(800,300);
	      review.setLocation(700,200);
	      review.setFont(new Font("맑은고딕",Font.PLAIN,18));
	      add(review);
	      
	      //새로운 서브 프레임 구현
	      Frame fr= new Frame();
	      fr.setTitle(m.getmName()+"의 리뷰");
	      fr.setSize(800, 300);
	      fr.setLocation(700, 200);
	      fr.add(review);
	      fr.setVisible(true);
	      
	      //리뷰창의 x를 눌렀을 때 System.exit(0)를 하면 예매프로그램 자체가 종료되므로
	      //dispose()를 통해 서브 프레임만 종료해줘야 한다.
	      fr.addWindowListener(new WindowAdapter() {
	         @Override
	         public void windowClosing(WindowEvent e) {
	            fr.setVisible(false);
	            fr.dispose();
	         }
	      });   
	   }//생성자  
	}

