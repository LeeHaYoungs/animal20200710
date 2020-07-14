package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameBegin extends JPanel {

	public FrameBegin() {

		// JPanel ����
		setBackground(new Color(255, 241, 54));
		setLayout(null);
		setSize(600, 800);

		// ������ �̹���
		ImageIcon cinema = new ImageIcon("MSG.jpg");
		JLabel lblCinema = new JLabel(cinema);
		lblCinema.setSize(600, 620);
		lblCinema.setLocation(-15, 0);
		add(lblCinema);

		// �ϴ��� ��ư ����
		JButton btnInfo = new JButton("��ȭ ����");
		JButton btnPost = new JButton("��ȭ ���ϱ�");

		btnInfo.setBackground(new Color(183, 240, 117));
		btnPost.setBackground(new Color(183, 240, 117));

		btnInfo.setSize(300, 150);
		btnInfo.setLocation(((int) getSize().getWidth() / 2) - 310,
				(int) getLocation().getY() / 2 + 610);

		btnInfo.setFont(new Font("����", Font.BOLD, 26));
		btnPost.setSize(300, 150);

		btnPost.setLocation((int) btnInfo.getLocation().getX() + 300,
				(int) btnInfo.getLocation().getY());

		btnPost.setFont(new Font("����", Font.BOLD, 26));

		add(btnInfo);
		add(btnPost);
		
		//��ư �̺�Ʈ(�����ϱ� / �ı� �����)
		btnInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//FrameMovieSelect Ŭ������ ���� �����Ƿ� ������ ����.
				FrameBase.getInstance( new FrameMovieSelect() );
			}
		});
		
		btnPost.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance( new FrameMovieReview() );
			}
		});

	}//������


}
