package GUI_Test.src.frame;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameBase extends JFrame{
	
	private static FrameBase instance;

	
	private FrameBase(JPanel e) {
		//시스템 정보(화면 크기를 얻기 위한 Toolkit)
		Toolkit tk = Toolkit.getDefaultToolkit();

		//기본 JFrame 구조
		setTitle("영화 예매 프로그램");
		setLayout(null);
		setBounds(((int) tk.getScreenSize().getWidth()) / 2 - 300, 
				((int) tk.getScreenSize().getHeight()) / 2 - 400,
				600, 800);
		add(e);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자

	//싱글톤 기법을 사용하려고 한다
	public static void getInstance(JPanel e) {
			//static으로 선언했으므로 해당 메서드가 생성자보다도 먼저 호출된다
			instance = new FrameBase(e);//생성자를 통해 기본 프레임 정의
			
			instance.getContentPane().removeAll();
			instance.getContentPane().add(e);
			
			instance.revalidate(); //레이아웃 관리자에게 레이아웃정보를 다시 계산하도록 지시
			instance.repaint(); //레이아웃을 새로 그린다
	}//getInstance()

}
