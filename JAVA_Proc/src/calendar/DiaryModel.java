package calendar;
import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/** DiaryModel models a diary. 
  *	@author Park Sung Jae
  *	@version 0.1 2001.12.16 */
public class DiaryModel
{ 
	public static final int NUM_CELL = 37;	//날짜 버튼의 총 갯수
	private CellFace[] cell; // the diary button face
	
	private GregorianCalendar today;	//오늘 달력
	private GregorianCalendar calendar;	//화면에 보여줄 달력
 
  /** Constructor DiaryModel constructs the initial diary on today */
	public DiaryModel()
	{ 
		today = new GregorianCalendar();
		calendar = new GregorianCalendar();
		cell = new CellFace[NUM_CELL];
		goMonth(today.get(today.YEAR), today.get(today.MONTH));
	}

  /** contents  returns the current state of the cells' face
    * @return a matrix that contains the addresses of the cells' face */
	public CellFace[] contents()
	{ 
		CellFace[] answer = new CellFace[NUM_CELL];
		for ( int i = 0;  i < NUM_CELL;  i++ ) 
	 		answer[i] = cell[i]; 
		return cell;
	}
	
  /** goMonth save cells' face by target year and month 
	* @param year - the target year
	* @param month - the target month, month : 0 ~ 11, 0 is January */
	public void goMonth(int year, int month) 
	{
		calendar.set(year, month, 1);
		
		int day = 1;
		for ( int i = 0; i < NUM_CELL; i++ )
	    { 
			if (i >= calendar.get(calendar.DAY_OF_WEEK)-1 && day <= calendar.getActualMaximum(calendar.DAY_OF_MONTH))
			{
				if(	today.get(today.MONTH) == calendar.get(calendar.MONTH) &&
					today.get(today.YEAR) == calendar.get(Calendar.YEAR) &&
					today.get(today.DATE) == day )
				{	cell[i] = new CellFace(new Integer(day).toString(), Color.cyan); } //오늘
				else if (i % 7 == 0)
				{	cell[i] = new CellFace(new Integer(day).toString(), Color.red); }//일요일
					else if (i % 7 == 6)
					{	cell[i] = new CellFace(new Integer(day).toString(), Color.blue); }//토요일
						else 
						{	cell[i] = new CellFace(new Integer(day).toString(), Color.black); }//평일
				day++;
	
			}
			else {
				cell[i] = new CellFace("", Color.black); //날짜가 없는 cell 
			}
	    }
	}

  /** prevMonth go month by one month ago */
	public void prevMonth()
	{
		goMonth(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1);
	}

  /** nextMonth go month by one month later */
	public void nextMonth()
	{
		goMonth(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
	}
	
  /** getYear returns the year on current calendar
	* @return the year */
	public int getYear()
	{
		return calendar.get(Calendar.YEAR);
	}

  /** getMonth returns the month on current calendar
	* @return the month */
	public int getMonth()
	{
		return calendar.get(Calendar.MONTH);
	}

  /** getDate returns the date on current calendar
	* @return the date */
	public Date getDate(int date)
	{
		return new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), date);
	} 

}