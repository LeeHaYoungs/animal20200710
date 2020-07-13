package base;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//WindowListener를 구현하는 MyEventListener클래스 생성
public class MyEventListener implements WindowListener{

	@Override
	public void windowActivated(WindowEvent e) { }

	@Override
	public void windowClosed(WindowEvent e) { }

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) { }
	
	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) { }
}
