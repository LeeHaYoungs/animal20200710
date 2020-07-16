package calendar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import EnrollVO.Enroll;
import base.FrameTime;

public class DateButton extends JButton implements ActionListener
{
	
	ArrayList<Enroll> enrollList = new ArrayList<Enroll>();
	int index ;
	
	private DiaryModel calendar; // address of the Diary model
	public DateButton(DiaryModel my_calendar, ArrayList<Enroll> enrollList3) 
	{ 
		super(""); // set label to nothing, but this will be repainted by the view
		calendar = my_calendar;
		setBackground(Color.white);		//��������
		
		//������, ��ȣ�ڸ�, ��ȣ�� ����ó �߰�
		enrollList=enrollList3;
		index=enrollList.size()-1;
		
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
						//������, ��ȣ�ڸ�, ��ȣ�� ����ó + ��¥
						//  enrollList.add(selectDate);
						  enrollList.get(index).setDate(selectDate);
						  
						  
					  FrameTime reserve = new FrameTime();
					  reserve.createFrame(enrollList); 
					  setVisible(false); 
					  
					  }
					 
				}

			});
			
		}
	}
}


