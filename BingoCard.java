import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.*;



public class BingoPanel extends JPanel implements KeyListener, MouseListener {
	
	private BingoCard card;
	private Graphics g = null;
	
	private ArrayList<Integer> allnumbers = new ArrayList<>();
	
	public BingoPanel(BingoCard card) {
		super();
		this.card = card;
		
		addMouseListener(this);
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		System.out.println(g==null);
		int x = e.getX();
		int y = e.getY();
		double distance = Math.sqrt((x-900)*(x-900)+(y-200)*(y-200));
		if(distance <= 100) {
			System.out.println(x + " " + y + " " + distance);
			g.setColor(new Color(0, 125, 125));
			
		}
		repaint();
	}

	@Override
	public void paint(Graphics graphics) {
		
		if(g == null) {
			g = graphics;
		}
		
		graphics.setColor(new Color(255, 255, 255));
		graphics.fillRect(0,0,2000,2000);
		
		try {
            graphics.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResource("BingoTemplate.png"))), 0, 0, null);
            drawText(graphics);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//Button
		graphics.setColor(Color.red);
		graphics.fillOval(800, 100, 200, 200);			//800-1000, 100-300, so mid at (900, 200)
//		graphics.drawString("TEST", 900, 75);
		//Text in button
		graphics.setColor(Color.white);
		graphics.setFont(new Font("", Font.PLAIN, 55));
		graphics.drawString("Ball", 850, 220);
		
		//Box of the numbers
		graphics.setColor(new Color(0, 0, 255));
		graphics.fillRect(750, 600, 300, 100);
		
		//number
		graphics.setColor(new Color(255, 255, 255));
		graphics.drawString("12", 860, 600);
		repaint();
	}
	
	
	
	private void drawText(Graphics numbers) {
		Font font = new Font("Times New Roman", Font.PLAIN, 40);
		numbers.setFont(font);
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				if(!(row == 2 && col == 2)) numbers.drawString(Integer.toString(card.getTile(row, col).getValue()), row * 126 + 89, col * 129 + 227);
			}
		}
	}
}
