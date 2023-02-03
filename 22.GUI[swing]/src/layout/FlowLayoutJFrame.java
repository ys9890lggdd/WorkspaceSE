package layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class FlowLayoutJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlowLayoutJFrame frame = new FlowLayoutJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FlowLayoutJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton_1 = new JButton("FIRST");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("SECOND");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("THIRD");
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("FOURTH");
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("FIFTH");
		contentPane.add(btnNewButton_4);
	}

}
