package calendar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/** NextMonthButton implements a button controller for a diary 
  *	@author Park Sung Jae
  *	@version 0.1 2001.12.16 */
public class NextMonthButton extends JButton implements ActionListener
{
	private DiaryModel calendar; // address of the diary model
	private UpdateableView view; // address of Frame that displays this button

  /** Constructor NextMonthButton builds the button
	* @param title - the face of button
	* @param my_puzzle - the address of the puzzle model object
	* @param my_view - the address of the puzzle's view */
	public NextMonthButton(String title, DiaryModel my_calendar, UpdateableView my_view)
	{	
		super(title); // set label to nothing, but this will be repainted by the view
		calendar = my_calendar;
		view = my_view;
		setForeground(Color.white);			//글자색 지정
		setBorder(BorderFactory.createRaisedBevelBorder()); //버튼 테두리 추가
		addActionListener(this);
	}


  /** actionPerformed goes one month after for dairy */
	public void actionPerformed(ActionEvent evt)
	{ 
		calendar.nextMonth();
		view.update();
	}
}