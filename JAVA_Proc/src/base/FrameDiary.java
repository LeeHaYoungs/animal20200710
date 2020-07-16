package base;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import EnrollVO.Enroll;
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
   public FrameDiary(DiaryModel cells,ArrayList<Enroll> enrollList)//������, ��ȣ�ڸ�, ��ȣ�� ����ó
      {  
      calendar = cells;

      Toolkit theKit = getToolkit();            //������ ��Ŷ ���ϱ�
      Dimension wndSize = theKit.getScreenSize();   //ȭ�� ũ�� ���ϱ�

      //
      setBounds(500, 100,      //��ġ
                  400, 600);   //ũ��

       try   
      {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
      catch(Exception e)
      {
         e.printStackTrace();
        }
       
      setBackground(Color.darkGray);
      setLayout(new FlowLayout());

      // ��Ʈ
      Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 24);
      Font fontCon = new Font("���� ���", Font.PLAIN, 16);

      Panel pCon = new Panel();
      pCon.setLayout(null);
      pCon.setSize(400, 600);

      //
      Panel pTitle = new Panel();
      pTitle.setSize(400, 50);
      Label title = new Label("���� ���� ����");
      pTitle.setBackground(Color.pink);
      pTitle.setFont(fontTitle);
      pTitle.setLocation(0, 0);
      pTitle.add(title);
      pCon.add(pTitle);
      
      //����� �⵵�� �� �̵� ��ư �гΰ� ���� ���̺� �г�
      JPanel upperPanel = new JPanel();   
      //����� �⵵�� �� �̵� ��ư �г�
      JPanel titlePanel = new JPanel();
      upperPanel.setSize(400, 50);
      upperPanel.setLocation(0, 51);
      titlePanel.add(new PrevMonthButton(" <  ", calendar, this)); 
      titleLabel = new JLabel();
      titleLabel.setForeground(Color.DARK_GRAY);
      titlePanel.add(titleLabel);
      titlePanel.add(new NextMonthButton("  > ", calendar, this));
      
      upperPanel.add(titlePanel);


      
      //   //����� ���� �� �г�, ��� ��¥ ��ư �г�
      JPanel datePanel = new JPanel(new GridLayout(7, 7));
      datePanel.setSize(400, 400);
      datePanel.setLocation(0, 51);
      //datePanel.setBorder(BorderFactory.createRaisedBevelBorder()); //�׵θ�
      JLabel label;
      datePanel.add(label = new JLabel("     ��"));
      label.setForeground(Color.red);
      datePanel.add(label = new JLabel("     ��"));
      datePanel.add(label = new JLabel("     ȭ"));
      datePanel.add(label = new JLabel("     ��"));
      datePanel.add(label = new JLabel("     ��"));
      datePanel.add(label = new JLabel("     ��"));
      datePanel.add(label = new JLabel("     ��")); 
      label.setForeground(Color.blue);
      button = new DateButton[DiaryModel.NUM_CELL];
      for( int i = 0; i < button.length; i++ )
      {
         button[i] = new DateButton(calendar,enrollList);//�Ķ���� �ΰ� �ޱ� //������, ��ȣ�ڸ�, ��ȣ�� ����ó
         datePanel.add(button[i]);
      }

      
      //�Ʒ��� ���ϴ� �⵵�� �޷� ���� �̵� �г�
      JPanel bottomPanel = new JPanel(new FlowLayout());
      JLabel nameLabel = new JLabel("���� �� �ٷΰ���      ");
      nameLabel.setFont(new Font("20th Century Font", Font.ITALIC, 14));
      bottomPanel.add(nameLabel);
      yearField = new JTextField("", 5);
      yearField.setBorder(BorderFactory.createLoweredBevelBorder());
      bottomPanel.add(yearField);
      bottomPanel.add(new JLabel(" / "));
      monthChoice = new Choice();
      for(int i = 1; i <= 12; i++) 
         monthChoice.addItem(String.valueOf(i)+" "); //���ϴ� �޷� ��������
      bottomPanel.add(monthChoice);
      bottomPanel.add(new JLabel("   "));
      bottomPanel.add(new AcceptButton("  Go  ", yearField, monthChoice, calendar, this));

      //Add top, center and bottom panel to content pane
     // Container content = getContentPane();
      //content.setLayout(new BorderLayout());
     
     pCon.add(upperPanel);
     pCon.add(datePanel);
     pCon.add(bottomPanel);
     
     Button btn1 = new Button("< ����");
     btn1.setSize(200, 50);
     btn1.setLocation(100,515);
     pCon.add(btn1);
     
     add(pCon);

      update();  // initialize the pieces with their numbers

      addWindowListener(new ExitController()); // activates X-button
      setTitle("BOA4 ��������");
      setVisible(true);
      
   // ** ����ȭ���̵� �̺�Ʈ �߰� **
      btn1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           FrameReserve reserve = new FrameReserve();
            setVisible(false);
            reserve.createFrame(enrollList);
        }
         
      });
   }

  /** update  consults the model and repaints each button */
   public void update()
   {
      CellFace[] cell = calendar.contents();
        for(int i = 0; i < button.length; i++)
        { 
         button[i].setText(cell[i].getValue());      //��¥��ư�� ���� ����
         button[i].setForeground(cell[i].getColor());//��¥��ư�� �� ����
         if (button[i].getText().equals(""))
            button[i].setVisible(false);   //���� ��¥ ��ư �Ⱥ��̰�
         else
            button[i].setVisible(true);      //������ �ƴ� ��¥ ��ư ���̰�
        }
      
      int year = calendar.getYear();
      int month = calendar.getMonth();

      //����г��� �⵵�� �� ����
      titleLabel.setText("     " + year + "  /  " + (month + 1) + "     ");
      yearField.setText(new Integer(year).toString());   //�⵵ �ʵ� ����
      monthChoice.select(month);   //���̵� ���̽� ����
   
   }
 }