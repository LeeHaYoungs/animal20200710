package base;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import calendar.AcceptButton;
import calendar.CellFace;
import calendar.DateButton;
import calendar.DiaryModel;
import calendar.ExitController;
import calendar.NextMonthButton;
import calendar.PrevMonthButton;
import calendar.UpdateableView;

/** DiaryFrame shows a diary 
  *   @author Park Sung Jae
  *   @version 0.1 2001.12.16 */
public class FrameDiary extends JFrame implements UpdateableView
{  
	private DiaryModel calendar;   // the model; 
   
   private DateButton[] button;  // the buttons on the face of the view
   private JLabel titleLabel;
   private JTextField yearField;
   private Choice monthChoice;

   
   /** Constructor DiaryFrame builds the view
   * @param cells - the model, a diary */
   public FrameDiary(DiaryModel cells)
      {  
      calendar = cells;

      Toolkit theKit = getToolkit();            //윈도우 툴킷 구하기
      Dimension wndSize = theKit.getScreenSize();   //화켠 크기 구하기

      //
      setBounds(0, 100,      //위치
                  400, 600);   //크기

       try   
      {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
      catch(Exception e)
      {
         e.printStackTrace();
        }
       
       setBackground(Color.lightGray);
      setLayout(new BorderLayout());

      // 폰트
      Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 24);
      Font fontCon = new Font("맑은 고딕", Font.PLAIN, 16);

      Panel pCon = new Panel();
      pCon.setLayout(null);
      pCon.setSize(400, 500);

      //
      Panel pTitle = new Panel();
      pTitle.setSize(400, 50);
      Label title = new Label("예약 일자 선택");
      pTitle.setBackground(Color.pink);
      pTitle.setFont(fontTitle);
      pTitle.setLocation(0, 0);
      pTitle.add(title);
      add(pTitle);
      
      //상단의 년도와 달 이동 버튼 패널과 요일 레이블 패널
      JPanel upperPanel = new JPanel();   
      //상단의 년도와 달 이동 버튼 패널
      JPanel titlePanel = new JPanel(new FlowLayout());
      titlePanel.setSize(400, 50);
      titlePanel.setLocation(0, 51);
      titlePanel.add(new PrevMonthButton(" <  ", calendar, this)); 
      titleLabel = new JLabel();
      titleLabel.setForeground(Color.DARK_GRAY);
      titlePanel.add(titleLabel);
      titlePanel.add(new NextMonthButton("  > ", calendar, this));
      
      upperPanel.add(titlePanel);


      
      //   //상단의 요일 라벨 패널, 가운데 날짜 버튼 패널
      JPanel datePanel = new JPanel(new GridLayout(7, 7));
      datePanel.setBorder(BorderFactory.createRaisedBevelBorder()); //테두리
      JLabel label;
      datePanel.add(label = new JLabel("     일"));
      label.setForeground(Color.red);
      datePanel.add(label = new JLabel("     월"));
      datePanel.add(label = new JLabel("     화"));
      datePanel.add(label = new JLabel("     수"));
      datePanel.add(label = new JLabel("     목"));
      datePanel.add(label = new JLabel("     금"));
      datePanel.add(label = new JLabel("     토")); 
      label.setForeground(Color.blue);
      button = new DateButton[DiaryModel.NUM_CELL];
      for( int i = 0; i < button.length; i++ )
      {
         button[i] = new DateButton(calendar);
         datePanel.add(button[i]);
      }

      
      //아래쪽 원하는 년도와 달로 직접 이동 패널
      JPanel bottomPanel = new JPanel(new FlowLayout());
      JLabel nameLabel = new JLabel("예약 월 바로가기      ");
      nameLabel.setFont(new Font("20th Century Font", Font.ITALIC, 14));
      bottomPanel.add(nameLabel);
      yearField = new JTextField("", 5);
      yearField.setBorder(BorderFactory.createLoweredBevelBorder());
      bottomPanel.add(yearField);
      bottomPanel.add(new JLabel(" / "));
      monthChoice = new Choice();
      for(int i = 1; i <= 12; i++) 
         monthChoice.addItem(String.valueOf(i)+" "); //원하는 달로 직접가기
      bottomPanel.add(monthChoice);
      bottomPanel.add(new JLabel("   "));
      bottomPanel.add(new AcceptButton("  Go  ", yearField, monthChoice, calendar, this));

      //Add top, center and bottom panel to content pane
      Container content = getContentPane();
      content.setLayout(new BorderLayout());
      content.add(upperPanel, BorderLayout.NORTH);
      content.add(datePanel , BorderLayout.CENTER);
      content.add(bottomPanel , BorderLayout.SOUTH);

      update();  // initialize the pieces with their numbers

      addWindowListener(new ExitController()); // activates X-button
      setTitle("BOA4 동물병원");
      setVisible(true);
   }

  /** update  consults the model and repaints each button */
   public void update()
   {
      CellFace[] cell = calendar.contents();
        for(int i = 0; i < button.length; i++)
        { 
         button[i].setText(cell[i].getValue());      //날짜버튼의 내용 지정
         button[i].setForeground(cell[i].getColor());//날짜버튼의 색 지정
         if (button[i].getText().equals(""))
            button[i].setVisible(false);   //공백 날짜 버튼 안보이게
         else
            button[i].setVisible(true);      //공백이 아닌 날짜 버튼 보이게
        }
      
      int year = calendar.getYear();
      int month = calendar.getMonth();

      //상단패널의 년도와 달 갱신
      titleLabel.setText("     " + year + "  /  " + (month + 1) + "     ");
      yearField.setText(new Integer(year).toString());   //년도 필드 갱신
      monthChoice.select(month);   //달이동 쵸이스 갱신
   
   }
 }