package calendar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class PrevMonthButton extends JButton implements ActionListener {
	private DiaryModel calendar; // address of the diary model
	private UpdateableView view; // address of Frame that displays this button

	public PrevMonthButton(String title, DiaryModel my_calendar,
			UpdateableView my_view) {
		super(title); // set label to title, but this will be repainted by the
						// view
		calendar = my_calendar;
		view = my_view;
		setForeground(Color.white); // 글자색 지정
		setBorder(BorderFactory.createRaisedBevelBorder()); // 버튼 테두리 추가
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		calendar.prevMonth();
		view.update();
	}
}