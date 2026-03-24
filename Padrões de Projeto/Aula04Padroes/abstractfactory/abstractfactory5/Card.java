package abstractfactory5;

// Card.java
// This file implements Solitaire cards

import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

// The Card class represents cards on a Solitaire Deck
// Each card has four properties, a colour, a shading pattern
// a number of designs and a symbol.
// In this class all objects are blue and ovals. 
public class Card extends JComponent {
	static final int xSize = 150; // the width of the card

	static final int ySize = 200; // the height of the card

	static final Color backGround = new Color(240, 240, 240); // background card colour
														
	static Vector cardsInSet = new Vector();

	private Color colour; // the cards colour (red, green or purple)

	private Shading shading; // the cards shading (filled, outlined or
								// striped)

	private Location location; // the y location on the card where the shape is
								// drawn

	private Symbol symbol; // the shape to draw (oval, diamond, or squiggle)

	private int index; // the index in the array of cards where this one is
						// stored

	private int strokeIndex = 0; // a toggle switch for bolding the edges of
									// the card

	// the stroke width to use when drawing
	private Stroke cardStroke[] = { new BasicStroke(2.0f),
			new BasicStroke(5.0f) };

	// An array of colours for the border of the card
	private Color strokeColor[] = { Color.black, Color.blue };

	// the constructor simply sets each of the cards properties
	public Card(Color color, Shading shading, Location location, Symbol symbol) {
		this.colour = color;
		this.shading = shading;
		this.location = location;
		this.symbol = symbol;
		setSize(xSize, ySize);
	}

	// toString is included mostly for debugging
	public String toString() {
		return "Card " + colour + " " + symbol;
	}

	// paint draws the cards background and then places the shapes on it
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g; // the 2D graphics context

		Dimension d = getSize(); // the size of the card

		// This code draws the offwhite background
		g2d.setColor(backGround);
		g2d.fillRoundRect(1, 1, (int) d.getWidth() - 2,
				(int) d.getHeight() - 2, 20, 20);

		// Paint the border of the card
		g2d.setPaint(strokeColor[strokeIndex]);
		g2d.setStroke(cardStroke[strokeIndex]);
		g2d.drawRoundRect(1, 1, (int) d.getWidth() - 2,
				(int) d.getHeight() - 2, 20, 20);

		// We loop through this cards location drawing the symbol
		for (int i = 0; i < location.size(); i++) {
			int yValue = ((Integer) location.get(i)).intValue();
			symbol.draw(g2d, yValue, colour, backGround, shading);
		}
	}

	// the following methods are defined to keep layout managers and others from
	// changing the size of the card. Note that the location can still be set
	// using either setBounds or setLocation
	public void setSize(int width, int height) {
		super.setSize(xSize, ySize);
	}

	public void setSize(Dimension d) {
		super.setSize(xSize, ySize);
	}

	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, xSize, ySize);
	}

	public void setBounds(Rectangle r) {
		super.setBounds((int) r.getX(), (int) r.getY(), xSize, ySize);
	}

	// set and get the index of this card in the array of cards
	public void setIndex(int i) {
		index = i;
	}

	public int getIndex() {
		return index;
	}

	// set and get whether the edge of the card is bold or not
	public void setBold(boolean b) {
		if (b)
			strokeIndex = 1;
		else
			strokeIndex = 0;
	}

	public boolean getBold() {
		return strokeIndex == 1;
	}

	public void changeBold() {
		strokeIndex = (strokeIndex + 1) % 2;
	}

	// Check if three cards are all the same colour or all different
	public static boolean colourSet(Card one, Card two, Card three) {
		if ((one.colour == two.colour && one.colour == three.colour)
				|| (one.colour != two.colour && one.colour != three.colour && two.colour != three.colour))
			return true;
		return false;
	}

	// Check if three cards all have the same shading or are all different
	public static boolean shadingSet(Card one, Card two, Card three) {
		if ((one.shading == two.shading && one.shading == three.shading)
				|| (one.shading != two.shading && one.shading != three.shading && two.shading != three.shading))
			return true;
		return false;
	}

	// Check if three cards all have the same symbol or are all different
	public static boolean symbolSet(Card one, Card two, Card three) {
		if ((one.symbol == two.symbol && one.symbol == three.symbol)
				|| (one.symbol != two.symbol && one.symbol != three.symbol && two.symbol != three.symbol))
			return true;
		return false;
	}

	// Check if three cards all have the same number of spots or are all
	// different
	public static boolean numberSet(Card one, Card two, Card three) {
		if ((one.location == two.location && one.location == three.location)
				|| (one.location != two.location
						&& one.location != three.location && two.location != three.location))
			return true;
		return false;
	}
}

// Abstract class shading represents a method for filling the cards symbols
abstract class Shading {
	public static Shading getInstance() {
		return null;
	}

	// A getter to get the paint object for the card
	abstract public Paint getPaint(Color c, Color backGround);
}

// Filled represents the Shading for filled cards
class Filled extends Shading {

	// We have exactly one instance of the filled class
	private static Filled instance = new Filled();

	// The private constructor keeps outsiders from making instances
	private Filled() {
	}

	// getInstance returns the only instance of this class
	public static Shading getInstance() {
		return instance;
	}

	// filled uses the foreground colour to fill the card
	public Paint getPaint(Color colour, Color backGround) {
		return colour;
	}
}

// Outlined represents the Shading for outlined cards
class Outlined extends Shading {

	// We have exactly one instance of the Outlined class
	private static Outlined instance = new Outlined();

	// The private constructor keeps outsiders from making instances
	private Outlined() {
	}

	// getInstance returns the one instance of this class
	public static Shading getInstance() {
		return instance;
	}

	// Outlined fills the cards with the background colour
	public Paint getPaint(Color colour, Color backGround) {
		return backGround;
	}
}

// Striped represents the Shading for striped cards
class Striped extends Shading {

	// We have exactly one instance of the striped class
	private static Striped instance = new Striped();

	private Striped() {
	}

	public static Shading getInstance() {
		return instance;
	}

	// Striped objects are filled with a ShadingPaint of our creation
	public Paint getPaint(Color colour, Color backGround) {
		BufferedImage buffImage = new BufferedImage(10, 10,
				BufferedImage.TYPE_INT_RGB);

		Graphics2D gg = buffImage.createGraphics();
		gg.setColor(colour);
		gg.fillRect(0, 0, 10, 5); // draw a filled rectangle

		gg.setColor(backGround);
		gg.fillRect(0, 5, 10, 5); // draw a filled rectangle

		// paint buffImage onto the JFrame
		return (new TexturePaint(buffImage, new Rectangle(10, 12)));
	}
}

// Locations contains an array of y locations of where to
// draw the shapes. arr[0] has a vector of one element.
// This vector is used when one shape is to be drawn.
// arr[1] contains a vector of two elements.
// arr[2] contains a vector of three elements.
abstract class Location {
	private Vector l;

	public Location() {
		l = new Vector();
	}

	public static Location getInstance() {
		return null;
	}

	public int size() {
		return l.size();
	}

	public Object get(int i) {
		return l.get(i);
	}

	protected boolean add(Object o) {
		return l.add(o);
	}
}

class OneLoc extends Location {
	private static Location instance = new OneLoc();

	public static Location getInstance() {
		return instance;
	}

	private OneLoc() {
		super();
		add(new Integer(80));
	}
}

class TwoLoc extends Location {
	private static Location instance = new TwoLoc();

	public static Location getInstance() {
		return instance;
	}

	private TwoLoc() {
		super();
		add(new Integer(55));
		add(new Integer(105));
	}
}

class ThreeLoc extends Location {
	private static Location instance = new ThreeLoc();

	public static Location getInstance() {
		return instance;
	}

	private ThreeLoc() {
		super();
		add(new Integer(30));
		add(new Integer(80));
		add(new Integer(130));
	}
}

// A Symbol is one of the shapes that need drawing, oval, diamond or squiggle
abstract class Symbol {
	public static Symbol getInstance() {
		return null;
	}

	abstract public void draw(Graphics g, int yValue, Color color,
			Color backGround, Shading shading);
}

// class Oval knows how to draw ovals
class Oval extends Symbol {

	private static Oval instance = new Oval();

	private Oval() {
	}

	public static Symbol getInstance() {
		return instance;
	}

	// the draw method draws an oval
	public void draw(Graphics g, int yValue, Color colour, Color backGround,
			Shading shading) {

		// Draw the oval
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(colour);
		g2d.setStroke(new BasicStroke(5.0f));
		g2d.drawOval(40, yValue, 70, 40);

		// Fill the oval
		g2d.setPaint(shading.getPaint(colour, backGround));
		g2d.fillOval(40, yValue, 70, 40);
	}
}

// class Diamond knows how to draw diamonds
class Diamond extends Symbol {

	private static Diamond instance = new Diamond();

	private Diamond() {
	}

	public static Symbol getInstance() {
		return instance;
	}

	// the draw method draws a diamond
	public void draw(Graphics g, int yValue, Color colour, Color backGround,
			Shading shading) {

		// Draw the diamond
		Polygon p = new Polygon();
		p.addPoint(75, yValue);
		p.addPoint(110, yValue + 20);
		p.addPoint(75, yValue + 40);
		p.addPoint(40, yValue + 20);

		// Fill the diamond
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(colour);
		g2d.setStroke(new BasicStroke(5.0f));
		g2d.drawPolygon(p);
		g2d.setPaint(shading.getPaint(colour, backGround));
		g2d.fillPolygon(p);
	}
}

// class Squiggle knows how to draw a squiggle
class Squiggle extends Symbol {

	private static Squiggle instance = new Squiggle();

	private Squiggle() {
	}

	public static Symbol getInstance() {
		return instance;
	}

	// The draw method draws a squiggle
	public void draw(Graphics g, int yValue, Color colour, Color backGround,
			Shading shading) {

		// Draw the squiggle
		Polygon p = new Polygon();
		p.addPoint(40, yValue + 30);
		p.addPoint(65, yValue);
		p.addPoint(85, yValue + 20);
		p.addPoint(110, yValue + 10);
		p.addPoint(85, yValue + 40);
		p.addPoint(65, yValue + 20);

		// Fill the squiggle
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(colour);
		g2d.setStroke(new BasicStroke(5.0f));
		g2d.drawPolygon(p);
		g2d.setPaint(shading.getPaint(colour, backGround));
		g2d.fillPolygon(p);
	}
}
