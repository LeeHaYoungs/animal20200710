package calendar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/** DateButton implements a button controller for a diary 
  *	@author Park Sung Jae
  *	@version 0.1 2001.12.16 */
public class DateButton extends JButton implements ActionListener
{
	private DiaryModel calendar; // address of the Diary model
  /** Constructor PuzzleButton builds the button
    * @param my_calendar - the address of the diary model object */
	public DateButton(DiaryModel my_calendar)
	{ 
		super(""); // set label to nothing, but this will be repainted by the view
		calendar = my_calendar;
		setBackground(Color.white);		//��������
		addActionListener(this);
	}

  /** actionPerformed processes open a text editor */
	public void actionPerformed(ActionEvent evt)
	{ 
		if ( !getText().equals("") )   // it's not the blank space, is it?
		{ 
			//������ ��ư�� ��¥ ���ϱ�
			Date now = calendar.getDate(new Integer(getText()).intValue());
			String selectDate=now.getYear()+"��"+(now.getMonth() + 1)+"��"+now.getDate()+"��";
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int input = JOptionPane.showConfirmDialog(null, "�����Ͻ� ��¥�� "+selectDate+" �Դϴ�", "��������Ȯ��",
							JOptionPane.YES_NO_OPTION);
					System.out.println(input);
					// yes-0, no-1

					/*
					 * if(input==0) { FrameMain reserve = new FrameMain(); f.setVisible(false);
					 * reserve.createFrame(); }
					 */
				}

			});
			
		}
	}
}


