package calendar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class NextMonthButton extends JButton implements ActionListener {
	private DiaryModel calendar; // address of the diary model
	private UpdateableView view; // address of Frame that displays this button

	public NextMonthButton(String title, DiaryModel my_calendar,
			UpdateableView my_view) {
		super(title); // set label to nothing, but this will be repainted by the
						// view
		calendar = my_calendar;
		view = my_view;
		setForeground(Color.white); // ���ڻ� ����
		setBorder(BorderFactory.createRaisedBevelBorder()); // ��ư �׵θ� �߰�
		addActionListener(this);
	}

	//ㅇㅇㅇ
	public void actionPerformed(ActionEvent evt) {
		calendar.nextMonth();
		view.update();
	}
}