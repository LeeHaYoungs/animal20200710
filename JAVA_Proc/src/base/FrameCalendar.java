package base;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;

import javax.swing.JComboBox;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import EnrollVO.Enroll;

public class FrameCalendar extends JFrame implements ActionListener {

	// North

	JPanel topPane = new JPanel();

	JButton prevBtn = new JButton("��");

	JButton nextBtn = new JButton("��");

	JLabel yearLbl = new JLabel("��");

	JLabel monthLbl = new JLabel("��");

	// test

	JComboBox<Integer> yearCombo = new JComboBox<Integer>();

	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();

	JComboBox<Integer> monthCombo = new JComboBox<Integer>();

	DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

	// Center

	JPanel centerPane = new JPanel(new BorderLayout());
	JPanel titlePane = new JPanel(new GridLayout(1, 7));
	String titleStr[] = {"��", "��", "ȭ", "��", "��", "��", "��"};
	JPanel datePane = new JPanel(new GridLayout(0, 7));
	Calendar now;
	int year, month, date;

	public FrameCalendar() {
		Frame f = new Frame("�޷½���");
		f.setBounds(100, 100, 400, 600);

		Panel pSouth = new Panel();
		Button btn1 = new Button("����ȭ��");
		Button btn2 = new Button("�����ϱ�");
		btn1.setPreferredSize(new Dimension(180, 80));
		btn2.setPreferredSize(new Dimension(180, 80));
		now = Calendar.getInstance(); // ���� ��¥
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH) + 1;
		date = now.get(Calendar.DATE);
		topPane.add(prevBtn);
		for (int i = year - 100; i <= year + 50; i++) {
			yearModel.addElement(i);
		}
		yearCombo.setModel(yearModel);
		yearCombo.setSelectedItem(year); // ���� �⵵ ����
		topPane.add(yearCombo);
		topPane.add(yearLbl);

		for (int i = 1; i <= 12; i++) {
			monthModel.addElement(i);
		}

		monthCombo.setModel(monthModel);
		monthCombo.setSelectedItem(month); // ���� �� ����
		topPane.add(monthCombo);
		topPane.add(monthLbl);
		topPane.add(nextBtn);
		topPane.setBackground(new Color(100, 200, 200));
		f.add(topPane, "North");
		// Center
		titlePane.setBackground(Color.white);

		for (int i = 0; i < titleStr.length; i++) {
			JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);
			if (i == 0) {
				lbl.setForeground(Color.red);
			} else if (i == 6) {
				lbl.setForeground(Color.blue);
			}
			titlePane.add(lbl);
		}
		centerPane.add(titlePane, "North");

		// ��¥ ���

		dayPrint(year, month);

		centerPane.add(datePane, "Center");
		f.add(centerPane, "Center");

		pSouth.add(btn1);
		pSouth.add(btn2);
		f.add(pSouth, "South");
		f.setVisible(true);
		
		// ** ����ȭ�� �̺�Ʈ �߰� **
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameReserve reserve = new FrameReserve();
				f.setVisible(false);
				reserve.createFrame();
			}
		});
		
		// ** ���Ό�� Ȯ�� �̺�Ʈ �߰� **
				btn2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						FrameReserveConfirm confirm = new FrameReserveConfirm();
						f.setVisible(false);
						confirm.createFrame(null);
					}
				});
				
				
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// Overring
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if (obj instanceof JButton) {
			JButton eventBtn = (JButton) obj;
			int yy = (Integer) yearCombo.getSelectedItem();
			int mm = (Integer) monthCombo.getSelectedItem();
			if (eventBtn.equals(prevBtn)) { // ����
				if (mm == 1) {
					yy--;
					mm = 12;
				} else {
					mm--;
				}
			} else if (eventBtn.equals(nextBtn)) { // ������
				if (mm == 12) {
					yy++;
					mm = 1;
				} else {
					mm++;
				}
			}

			yearCombo.setSelectedItem(yy);
			monthCombo.setSelectedItem(mm);
		} else if (obj instanceof JComboBox) { // �޺��ڽ� �̺�Ʈ �߻���
			createDayStart();
		}
	}

	public void createDayStart() {
		datePane.setVisible(false); // �г� �����
		datePane.removeAll(); // ��¥ ����� �� �����
		dayPrint((Integer) yearCombo.getSelectedItem(),
				(Integer) monthCombo.getSelectedItem());
		datePane.setVisible(true); // �г� �����
	}

	public void dayPrint(int y, int m) {
		Calendar cal = Calendar.getInstance();
		cal.set(y, m - 1, 1); // ����� ù���� ��ü �����.
		int week = cal.get(Calendar.DAY_OF_WEEK); // 1�Ͽ� ���� ���� �Ͽ��� : 0
		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // �� ���� ������
																	// ��

		for (int i = 1; i < week; i++) { // ��¥ ��� �������� ���� ���
			datePane.add(new JLabel(" "));
		}
		for (int i = 1; i <= lastDate; i++) {
			JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);
			cal.set(y, m - 1, i);
			int outWeek = cal.get(Calendar.DAY_OF_WEEK);
			if (outWeek == 1) {
				lbl.setForeground(Color.red);
			} else if (outWeek == 7) {
				lbl.setForeground(Color.BLUE);
			}

			JRadioButton crb = new JRadioButton();
			ButtonGroup group = new ButtonGroup();

			group.add(crb);
			datePane.add(crb);
			datePane.add(lbl);
		}
	}

	public static void main(String[] args) {
		new FrameCalendar();
	}

}
