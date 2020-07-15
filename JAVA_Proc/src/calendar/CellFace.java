package calendar;
import java.awt.Color;

/** CellFace defines of a date cell 
  *	@author Park Sung Jae
  *	@version 0.1 2001.12.16 */
public class CellFace
{ 
	private String face_value;  // the value written on the cell's face
	private Color face_color;	// the color of cell's value

  /** Constructor CellFace creates a cell
	* @param value - the value written on the cell's face
	* @param color - the color of cell's value */
	public CellFace(String value, Color color)
	{ 
		face_value = value;
		face_color = color;
	}

  /** getValue returns the face value of the cell 
	* @return the face value of the cell*/
	public String getValue()
	{
		return face_value; 
	}

  /** getColor returns the face color of the cell 
	* @return the face color of the cell*/
	public Color getColor() 
	{
		return face_color;
	}
}