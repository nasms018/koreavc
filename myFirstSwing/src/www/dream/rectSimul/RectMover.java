package www.dream.rectSimul;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class RectMover {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 2000);
		frame.setTitle("Rect Move");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JButton btn = new JButton("눌러요");
		frame.add(btn);
		
		class TimeListner implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				Point pt = btn.getLocation();
				btn.setLocation(pt.x + 1, pt.y + 1);
			}
		}
		ActionListener listener = new TimeListner();
		Timer t = new Timer(500, listener);
		t.start();
	}
	
}
