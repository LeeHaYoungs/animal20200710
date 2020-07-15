package calendar;
import java.awt.Color;

public class CellFace
{ 
	private String face_value;  // the value written on the cell's face
	private Color face_color;	// the color of cell's value

	public CellFace(String value, Color color)
	{ 
		face_value = value;
		face_color = color;
	}

	public String getValue()
	{
		return face_value; 
	}

	public Color getColor() 
	{
		return face_color;
	}
}