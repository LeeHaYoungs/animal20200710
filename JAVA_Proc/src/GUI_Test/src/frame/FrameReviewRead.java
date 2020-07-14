package frame;

import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import movieVO.Movie;

public class FrameReviewRead extends JFrame{

	public FrameReviewRead( Movie m ){ //���並 ������� ��ȭ ������ �Ķ���ͷ� �޾ƾ��Ѵ�

		//�ı� ��� â
	      TextArea review = 
	new TextArea("����\t�̸�\t\t\t������\n", 0, 0,TextArea.SCROLLBARS_VERTICAL_ONLY);
	      review.setEditable(false);
	      review.append(m.getReview());
	      review.setSize(800,300);
	      review.setLocation(700,200);
	      review.setFont(new Font("�������",Font.PLAIN,18));
	      add(review);
	      
	      //���ο� ���� ������ ����
	      Frame fr= new Frame();
	      fr.setTitle(m.getmName()+"�� ����");
	      fr.setSize(800, 300);
	      fr.setLocation(700, 200);
	      fr.add(review);
	      fr.setVisible(true);
	      
	      //����â�� x�� ������ �� System.exit(0)�� �ϸ� �������α׷� ��ü�� ����ǹǷ�
	      //dispose()�� ���� ���� �����Ӹ� ��������� �Ѵ�.
	      fr.addWindowListener(new WindowAdapter() {
	         @Override
	         public void windowClosing(WindowEvent e) {
	            fr.setVisible(false);
	            fr.dispose();
	         }
	      });   
	   }//������  
	}

