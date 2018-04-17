package intro_to_array_lists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {

	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".

	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners

	JFrame frame = new JFrame("GuestBook");
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Name");
	JButton view = new JButton("View Name");
	ArrayList<String> guests = new ArrayList<String>();

	public static void main(String[] args) {

		GuestBook gb = new GuestBook();
		gb.run();

	}

	void run() {

		frame.add(panel);
		panel.add(add);
		panel.add(view);

		add.addActionListener(this);
		view.addActionListener(this);

		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == add) {
			String s = JOptionPane.showInputDialog("What name do you want to add to the guestbook?");
			guests.add(s);
		}

		if (e.getSource() == view) {
			String s = "";
			
			for (int i = 0; i < guests.size(); i++) {
				 s += "Guest #" + i + " " + guests.get(i) + "\n";
			}
			
			JOptionPane.showMessageDialog(null, s);
			
		}

	}

}
