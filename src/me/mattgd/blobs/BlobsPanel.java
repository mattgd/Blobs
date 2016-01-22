package me.mattgd.blobs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BlobsPanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private final int SIZE = 360;
	private final int BLOB_SIZE = 10;
	private Blobs b;
	
	public static void main (String[] args) {
		new BlobsPanel();
	}
	
	BlobsPanel() {
		setVisible(true);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setPreferredSize(new Dimension(SIZE - 4, SIZE - 1));
		frame.setResizable(false);
		frame.pack(); // Size frame
		frame.setVisible(true);
		
		addMouseListener(this);
		//if (g == null) System.exit(0);
		b = new Blobs(35, this);
		repaint();
    	// Class variables
		//String inputNumber = JOptionPane.showInputDialog(null, "Enter a size : ","Input", 1);
		//b = new Blobs(Integer.parseInt(inputNumber));
		//int row = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a row : ","Input", 1));
		//int col = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a column : ","Input", 1));

		//b.pick(row, col);

    	/*JOptionPane.showMessageDialog(null, b.toString()); // Ending output
 		System.exit(0); // Exit*/
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (int i = 0; i < b.getBoard().length; i++) {
			for (int j = 0; j < b.getBoard()[0].length; j++) {
				g.setColor(b.getBoard()[i][j] == 1 ? Color.WHITE : Color.BLACK);
				g.fillRect(i * BLOB_SIZE, j * BLOB_SIZE, BLOB_SIZE, BLOB_SIZE);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        b.pick(e.getX() / BLOB_SIZE, e.getY() / BLOB_SIZE);
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
