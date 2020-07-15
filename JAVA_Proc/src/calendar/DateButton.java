package calendar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import base.FrameTime;

public class DateButton extends JButton implements ActionListener
{
	private DiaryModel calendar; // address of the Diary model
	public DateButton(DiaryModel my_calendar)
	{ 
		super(""); // set label to nothing, but this will be repainted by the view
		calendar = my_calendar;
		setBackground(Color.white);		//��������
		addActionListener(this);
	}

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

					
					  if(input==0) { 
						  
					  FrameTime reserve = new FrameTime();
					  reserve.createFrame(); 
					  setVisible(false); 
					  
					  }
					 
				}

			});
			
		}
	}
}


