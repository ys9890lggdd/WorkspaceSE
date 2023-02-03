package basic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;

public class ChidJFrameWB extends JFrame {

	private JPanel contentPane;
	private JButton okBtn;
	private JButton cancleBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChidJFrameWB frame = new ChidJFrameWB();
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
	public ChidJFrameWB() {
		setTitle("나의첫번째WB프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 404);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		okBtn = new JButton("확인");
		okBtn.setBounds(12, 47, 106, 49);
		contentPane.add(okBtn);
		
		cancleBtn = new JButton("취소");
		cancleBtn.setBounds(143, 47, 106, 49);
		contentPane.add(cancleBtn);
	}
}
