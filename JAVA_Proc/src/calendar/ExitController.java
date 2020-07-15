package calendar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** ExitController exits the diary
  *	@author Park Sung Jae
  *	@version 0.1 2001.12.16 */
public class ExitController extends WindowAdapter
{ public void windowClosing(WindowEvent e)
  { System.exit(0); }
}