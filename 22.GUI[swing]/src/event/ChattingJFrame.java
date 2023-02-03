package event;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ChattingJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField chatTF;
	private JButton sendBtn;
	private JTextArea chatTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingJFrame frame = new ChattingJFrame();
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
	public ChattingJFrame() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				/*
				Terminates the currently running Java Virtual Machine. 
				 */
				System.exit(0);
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 357, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 200, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("랜덤채팅");
		lblNewLabel.setIcon(new ImageIcon("C:\\2022-11-JAVA-DEVELOPER\\01.JAVA_FUNDMENTAL\\image\\penguin\\penguin1.gif"));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		chatTF = new JTextField();
		chatTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("TextField enter key~~");
				/*
				 * frame의 TextField와 TextArea에 접근해야함
				 */
				String chatStr=ChattingJFrame.this.chatTF.getText();
				chatTF.setText("");
				ChattingJFrame.this.chatTA.append("경호:"+chatStr+"\n");
				chatTF.requestFocus();
			}
		});
		panel_1.add(chatTF);
		chatTF.setColumns(20);
		
		sendBtn = new JButton("전송");
		panel_1.add(sendBtn);
		
		
		chatTA = new JTextArea();
		chatTA.setEditable(false);
		
		chatTA.setText("경호:이따만나\r\n태희:아라써~~~~\n");
		contentPane.add(chatTA, BorderLayout.CENTER);
		/*
		 * 이벤트소쓰에 이벤트핸들러객체등록
		 */
		ChatSendButtonActionEventHandler handler=
				new ChatSendButtonActionEventHandler();
		sendBtn.addActionListener(handler);
		
	}//생성자
	/*************Inner class***********/
	public class ChatSendButtonActionEventHandler implements ActionListener{
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("send button click~~");
		/*
		 * frame의 TextField와 TextArea에 접근해야함
		 */
		String chatStr=ChattingJFrame.this.chatTF.getText();
		chatTF.setText("");
		ChattingJFrame.this.chatTA.append("경호:"+chatStr+"\n");
		chatTF.requestFocus();
		
	}
	
}


}













