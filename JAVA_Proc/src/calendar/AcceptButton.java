package calendar;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/** AcceptButton implements a button controller for a diary 
  *	@author Park Sung Jae
  *	@version 0.1 2001.12.16 */
public class AcceptButton extends JButton implements ActionListener
{
	private JTextField yearField;	// the address of the diary's year text field
	private Choice monthChoice;		//the address of the diary's month choice
	private DiaryModel calendar;	// address of the SlidePuzzle model
	private UpdateableView view;	// address of Frame that displays this button

  /** Constructor AcceptButton builds the button
    * @param title - the button's face
    * @param year - the address of the diary's year text field
    * @param month - the address of the diary's month choice
    * @param my_calendar - the address of the diary's model object
    * @param my_view - the address of the diary's view */
	public AcceptButton(String title, JTextField year, Choice month, DiaryModel my_calendar, UpdateableView my_view)
	{	
		super(title); // set label to title
		yearField = year;
		monthChoice = month;
		calendar = my_calendar;
		view = my_view;
		setBorder(BorderFactory.createRaisedBevelBorder()); //버튼 테두리 추가
		addActionListener(this);
	}


  /** actionPerformed goes entered year and month for dairy */
	public void actionPerformed(ActionEvent evt)
	{ 
		try
		{
			int year = new Integer(yearField.getText()).intValue();
			int month = new Integer(monthChoice.getSelectedItem().trim()).intValue();
			calendar.goMonth(year, month - 1);
			view.update();
		}
		catch (NumberFormatException e)		//년도 입력필드에 숫자가 아닌 것이 입력될 경우
		{
			JOptionPane.showMessageDialog(null,		//에러 메시지를 출력
				"Error: Bad input year on the text field.");
		}
	}
}