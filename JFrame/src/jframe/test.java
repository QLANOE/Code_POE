package jframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class test extends JFrame {

	public test() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setTitle("Fenetre de test");

		setLayout(null);

		JButton button = new JButton("Bouton de test");
		button.setBounds(10, 20, 100, 20);
		add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bouton cliqué");

			}
		});

		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Mouse Released");

			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("mouse Pressed");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("mouse Exited");

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouse Entered");

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouse clicked");

			}
		});

		JLabel label = new JLabel("Zone de texte");
		label.setBounds(10, 50, 200, 20);
		add(label);

		setVisible(true);

	}

	public static void main(String[] args) {
		new test();

	}

}
