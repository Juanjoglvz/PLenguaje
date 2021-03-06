package moomaui.presentation.drawing;

import java.awt.Color;
import java.awt.Graphics2D;

public interface GraphicObject {
	int getX();
	int getY();
	Color getColor();
	void setX(int X);
	void setY(int Y);
	void setColor(Color color);
	
	void paint(Graphics2D g2);
}
