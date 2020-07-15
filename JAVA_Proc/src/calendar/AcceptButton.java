package calendar;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AcceptButton extends JButton implements ActionListener
{
	private JTextField yearField;	// the address of the diary's year text field
	private Choice monthChoice;		//the address of the diary's month choice
	private DiaryModel calendar;	// address of the SlidePuzzle model
	private UpdateableView view;	// address of Frame that displays this button


	public AcceptButton(String title, JTextField year, Choice month, DiaryModel my_calendar, UpdateableView my_view)
	{	
		super(title); // set label to title
		yearField = year;
		monthChoice = month;
		calendar = my_calendar;
		view = my_view;
		setBorder(BorderFactory.createRaisedBevelBorder()); //��ư �׵θ� �߰�
		addActionListener(this);
	}



	public void actionPerformed(ActionEvent evt)
	{ 
		try
		{
			int year = new Integer(yearField.getText()).intValue();
			int month = new Integer(monthChoice.getSelectedItem().trim()).intValue();
			calendar.goMonth(year, month - 1);
			view.update();
		}
		catch (NumberFormatException e)		//�⵵ �Է��ʵ忡 ���ڰ� �ƴ� ���� �Էµ� ���
		{
			JOptionPane.showMessageDialog(null,		//���� �޽����� ���
				"Error: Bad input year on the text field.");
		}
	}
}