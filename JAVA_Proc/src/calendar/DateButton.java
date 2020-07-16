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

import ReseveVO.MyReserve;
import base.FrameTime;

public class DateButton extends JButton implements ActionListener
{
	
	ArrayList<String> myreserveList = new ArrayList<String>();

	
	private DiaryModel calendar; // address of the Diary model
	public DateButton(DiaryModel my_calendar, ArrayList<String> list) 
	{ 
		super(""); // set label to nothing, but this will be repainted by the view
		calendar = my_calendar;
		setBackground(Color.white);		//배경색지정
		
		//동물명, 보호자명, 보호자 연락처 추가
		myreserveList=list;
		
		
		addActionListener(this);
	}


	
	public void actionPerformed(ActionEvent evt)
	{ 
		if ( !getText().equals("") )   // it's not the blank space, is it?
		{ 
			//눌려진 버튼의 날짜 구하기
			Date now = calendar.getDate(new Integer(getText()).intValue());
			String selectDate=now.getYear()+"년"+(now.getMonth() + 1)+"월"+now.getDate()+"일";
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int input = JOptionPane.showConfirmDialog(null, "선택하신 날짜는 "+selectDate+" 입니다", "예약일자확인",
							JOptionPane.YES_NO_OPTION);
	
					System.out.println(input);
					// yes-0, no-1

					
					  if(input==0) { 
						//동물명, 보호자명, 보호자 연락처 + 날짜
						  myreserveList.add(selectDate);
						  
					  FrameTime reserve = new FrameTime();
					  reserve.createFrame(myreserveList); 
					  setVisible(false); 
					  
					  }
					 
				}

			});
			
		}
	}
}


