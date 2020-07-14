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
		// JPanel �⺻ ����
		setBackground(new Color(0xFFD700));
		setLayout(null);
		setSize(600, 800);

		// ��ܺ� �̹���
		ImageIcon popcon = new ImageIcon("popcon2.png");
		JLabel lblPopcon = new JLabel(popcon);
		lblPopcon.setSize(600, 280);
		lblPopcon.setLocation(0, 0);
		add(lblPopcon);

		// �ı� ���� ��ȭ ����(������ư)
		JPanel dis2 = new JPanel(); // ���� �г� ����
		dis2.setLayout(new GridLayout(3, 3));
		dis2.setBounds(0, 280, 600, 220);

		dis2.setBorder(
			new TitledBorder( null, //�׵θ�����
			"���� �� ��ȭ ����", //����
			TitledBorder.LEADING, //�ؽ�Ʈ ���Ĺ��:��������
			TitledBorder.TOP, //�ؽ�Ʈ ǥ�� ��ġ : ���
			null, //��Ʈ ��������
			new Color(255, 122, 144) )); //����

		JRadioButton movie1 = new JRadioButton("��󷣵�");
		JRadioButton movie2 = new JRadioButton("���Ҽ����º��");
		JRadioButton movie3 = new JRadioButton("�λ��̵�ƿ�");
		JRadioButton movie4 = new JRadioButton("�ܿ�ձ�");
		JRadioButton movie5 = new JRadioButton("��Űű��־��ٷ���");
		JRadioButton movie6 = new JRadioButton("�����̴���");
		JRadioButton movie7 = new JRadioButton("�����");
		JRadioButton movie8 = new JRadioButton("�λ���");
		add(dis2);

		// ���� ���� �ޱ� (���� ��ư)
		JPanel dis1 = new JPanel(); // ���� ��ư, ������ ���� �г� ����
		dis1.setBorder(new TitledBorder(
				null, //�׵θ�����
				"���䳲���", TitledBorder.LEADING, //�ؽ�Ʈ ���Ĺ��:��������
				TitledBorder.TOP, //�ؽ�Ʈ ǥ�� ��ġ : ���
				null, //��Ʈ ��������
				null));//���� ��������
		
		dis1.add(new JLabel("���� "));
		JRadioButton point1 = new JRadioButton("1��");
		JRadioButton point2 = new JRadioButton("2��");
		JRadioButton point3 = new JRadioButton("3��");
		JRadioButton point4 = new JRadioButton("4��");
		JRadioButton point5 = new JRadioButton("5��");

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

		// �ۼ��� �̸�
		TextField reviewName = new TextField("�ۼ��� �̸�", 40);
		reviewName.setBounds(0, 430, 50, 100);
		dis1.add(reviewName);

		// ���� �� �Է¹ޱ�
		TextField review = new TextField("�������� �Է����ּ���.(30 ���� �̸�)", 50);
		review.setBounds(0, 430, 400, 100);
		dis1.add(review);

		JButton btn = new JButton("�Ϸ�");
		btn.setBounds(400, 430, 200, 100);
		dis1.add(btn);
		btn.setEnabled(false);

		add(dis1);
		dis1.setVisible(false);

		// ��ȭ ������ư ����
		String mName[] = { "��󷣵�", "���Ҽ����º��", "�λ��̵�ƿ�", 
					"�ܿ�ձ�", "��Űű��־��ٷ���", "�����̴���", 
					"�����", "�λ���" };
		ButtonGroup group1 = new ButtonGroup();
		JRadioButton movie[] = new JRadioButton[8];


		for (int i = 0; i < mName.length; i++) {
			movie[i] = new JRadioButton(mName[i]);
			movie[i].setFont(new Font("��������ڵ�", Font.BOLD, 16));
			
			dis2.add(movie[i]);
			group1.add(movie[i]);
			
			//�� ������ư�� Ŭ�� �̺�Ʈ ����
			movie[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
			//� ������ư�̵� �����ϴ� ���� ������ �ۼ����� ȭ�鿡 ��������.
					dis1.setVisible(true);
					
					String[] movieurl = { 
				"��󷣵�.png", "���Ҽ����º��.jpg", "�λ��̵�ƿ�.png", 
				"�ܿ�ձ�.png", "��Űű��־��ٷ���.png", "�����̴���.png", 
				"�����.png", "�λ���.png" };
					
					//�򰡸� ���� ������ ��ȭ�� index�� ����Ѵ�
					int movieIndex = 0;
					if (e.getActionCommand().equals("��󷣵�")) {
						movieIndex = 0;
					} else if (e.getActionCommand().equals("���Ҽ����º��")) {
						movieIndex = 1;
					} else if (e.getActionCommand().equals("�λ��̵�ƿ�")) {
						movieIndex = 2;
					} else if (e.getActionCommand().equals("�ܿ�ձ�")) {
						movieIndex = 3;
					} else if (e.getActionCommand().equals("��Űű��־��ٷ���")) {
						movieIndex = 4;
					} else if (e.getActionCommand().equals("�����̴���")) {
						movieIndex = 5;
					} else if (e.getActionCommand().equals("�����")) {
						movieIndex = 6;
					} else if (e.getActionCommand().equals("�λ���")) {
						movieIndex = 7;
					}
				}//actionPerformed
			});
			
		}//for

		// ���� �� ���(30���� �̻�, �� ���ڿ��� ��ϺҰ�)
		review.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				if (review.getText().equals("")) {
					btn.setEnabled(false);
					
				} else if (review.getText().length() > 30) {
					btn.setEnabled(false);
				
				} else if (review.getText().equals("�������� �Է����ּ���.(30 ���� �̸�)")) {
					btn.setEnabled(false);
					
				} else {
					//1 ~ 30�� ������ �򰡰� �������� �Ϸ��ư Ȱ��ȭ
					btn.setEnabled(true);
				}
			}
		});

		// �ۼ��� �̸� â Ŭ���� �ؽ�Ʈ ��Ʈ ����
		reviewName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (reviewName.getText().equals("�ۼ��� �̸�")) {
					reviewName.setText("");
				}
			}
		});

		// ���� �� â Ŭ���� �ؽ�Ʈ ��Ʈ ����
		review.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (review.getText().equals("�������� �Է����ּ���.(30 ���� �̸�)")) {
					review.setText("");
				}
			}
		});

		// �Ϸ� ��ư
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (point1.isSelected() || point2.isSelected() || 
						point3.isSelected() || point4.isSelected() || 
							point5.isSelected()) {
					
					if (reviewName.getText().equals("")) {
						reviewName.setText("�͸�");
						
					} else if (reviewName.getText().equals("�ۼ��� �̸�")) {
						reviewName.setText("�͸�");
						
					}
					
					//�� �� ����� Ȯ���ϱ�
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
						//�ۼ��� �ı⸦ ��ȭ ����Ʈ�� �߰�
						new MovieDAO().inputReview(
							movie[i].getText(), reviewName.getText(), 
							review.getText(), num);
				           }
					}//for
					
					JOptionPane.showMessageDialog(
							null, "���� �ۼ��� �Ϸ��Ͽ����ϴ�.");
					FrameBase.getInstance(new FrameBegin());
					
				} else {
					//������ ���� �������
					JOptionPane.showMessageDialog(
							null, "������ �Է����ּ���.");
				}
			}//actionPerformed
		});

		// �ڷΰ��� ��ư
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

		add(bottomSet, BorderLayout.SOUTH);

	}//������
}
