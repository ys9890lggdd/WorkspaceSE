package com.itwill.shop.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Point;

public class ShopMainFrame extends JFrame {
	/************ 1.Service객체멤버변수선언 ************/
	private ProductService productService;
	private UserService userService;
	private CartService cartService;
	private OrderService orderService;
	/**************************************************/

	/***** 로그인한User객체저장할 User객체선언 **********/
	private User loginUser = null;
	/**************************************************/

	private JPanel contentPane;
	private JTextField searchTextField;
	private JTabbedPane shopTabbedPane;
	private JPanel southMenuPanel;
	private JPanel northMenuPanel;
	private JButton cartButton;
	private JPanel productSmallDogContentPanel;
	private JPanel productMiddleDogContentPanel;
	private JPanel productBigDogContentPanel;
	private JPanel productPopularDogContentPanel;
	private JPanel cartContentPanel;
	private JLabel cartCountLabel;
	private JPanel cartPanel;
	private JScrollPane cartContentPanelScrollPane;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField idTextField;
	private JTextField userLoginIdTF;
	private JTextField UserLoginPasswordTF;
	private JTabbedPane userTabbedPane;
	private JTextField userJoinNameTF;
	private JTextField userJoinEmailTF;
	private JLabel loginPasswordMessageLabel;
	private JLabel userLoginPasswordLabel;
	private JLabel userLoginIdMessageLabel;
	private JTextField userJoinIdTF;
	private JTextField userJoinPasswordTF;
	private JLabel userJoinIdMsgLB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMainFrame frame = new ShopMainFrame();
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
	public ShopMainFrame()  throws Exception{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShopMainFrame.class.getResource("/images/title_logo25.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 740);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		shopTabbedPane.setForeground(Color.DARK_GRAY);
		shopTabbedPane.setBackground(Color.WHITE);
		shopTabbedPane.setFont(new Font("D2Coding", Font.BOLD, 12));
		shopTabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);

		JPanel productPupularDogPanel = new JPanel();
		productPupularDogPanel.setBackground(Color.WHITE);
		shopTabbedPane.addTab("인기견", new ImageIcon(ShopMainFrame.class.getResource("/images/title_logo20.png")),
				productPupularDogPanel, null);
		shopTabbedPane.setBackgroundAt(0, Color.WHITE);
		productPupularDogPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane productPopularDogContentPanelScrollPane = new JScrollPane();
		productPopularDogContentPanelScrollPane.setBackground(Color.WHITE);
		productPopularDogContentPanelScrollPane.setPreferredSize(new Dimension(390, 780));
		productPopularDogContentPanelScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		productPupularDogPanel.add(productPopularDogContentPanelScrollPane, BorderLayout.CENTER);

		productPopularDogContentPanel = new JPanel();
		productPopularDogContentPanel.setPreferredSize(new Dimension(390, 780));
		productPopularDogContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		productPopularDogContentPanel.setBackground(Color.WHITE);
		productPopularDogContentPanelScrollPane.setViewportView(productPopularDogContentPanel);
		productPopularDogContentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));

		/************* 제품1개UI패널 디자인 시작 *******************/
		JPanel productPanel = new JPanel();
		productPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		productPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		productPanel.setBounds(new Rectangle(0, 0, 120, 120));
		productPanel.setMaximumSize(new Dimension(200, 200));
		productPanel.setMinimumSize(new Dimension(150, 150));
		productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		productPanel.setBackground(Color.WHITE);
		productPanel.setBorder(null);
		productPanel.setSize(new Dimension(120, 120));
		productPanel.setPreferredSize(new Dimension(170, 190));
		productPanel.setLayout(null);
		JLabel productImageLabel = new JLabel("");
		productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

		productImageLabel.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/bigle.png")));
		productImageLabel.setBounds(3, 1, 162, 116);
		productPanel.add(productImageLabel);

		JLabel productDescLabel = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t" + "견종: 비글<br>\r\n\t\t\t"
				+ "가격: 34,000<br>\r\n\t\t\t" + "설명: 귀여워요\r\n\t\t\r\n </font></html>");
		productDescLabel.setVerticalAlignment(SwingConstants.TOP);
		productDescLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		productDescLabel.setHorizontalAlignment(SwingConstants.LEFT);
		productDescLabel.setBounds(3, 143, 164, 47);
		productPanel.add(productDescLabel);

		JButton cartAddButton = new JButton("");
		cartAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>카트담기...");
			}
		});
		cartAddButton.setBorder(null);
		cartAddButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartAddButton.setOpaque(false);
		cartAddButton.setBackground(Color.WHITE);
		cartAddButton.setForeground(Color.WHITE);
		cartAddButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart20.png")));
		cartAddButton.setBounds(136, 119, 31, 23);
		productPanel.add(cartAddButton);

		JComboBox cartQtyComboBox = new JComboBox();
		cartQtyComboBox.setAutoscrolls(true);
		cartQtyComboBox
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		cartQtyComboBox.setOpaque(false);
		cartQtyComboBox.setBorder(null);
		cartQtyComboBox.setBackground(Color.WHITE);
		cartQtyComboBox.setBounds(99, 119, 33, 23);
		cartQtyComboBox.setMaximumRowCount(cartQtyComboBox.getModel().getSize());
		productPanel.add(cartQtyComboBox);

		productPopularDogContentPanel.add(productPanel);
		/************* 제품1개UI패널 디자인끝 *******************/

		JPanel productSmallDogPanel = new JPanel();
		productSmallDogPanel.setBackground(Color.WHITE);
		shopTabbedPane.addTab("소형견", new ImageIcon(ShopMainFrame.class.getResource("/images/small_dog20.png")),
				productSmallDogPanel, null);
		productSmallDogPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane productSmallDogContentPanelScrollPane = new JScrollPane();
		productSmallDogContentPanelScrollPane.setPreferredSize(new Dimension(390, 780));
		productSmallDogContentPanelScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		productSmallDogPanel.add(productSmallDogContentPanelScrollPane, BorderLayout.CENTER);

		productSmallDogContentPanel = new JPanel();
		productSmallDogContentPanel.setPreferredSize(new Dimension(390, 780));
		productSmallDogContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		productSmallDogContentPanelScrollPane.setViewportView(productSmallDogContentPanel);
		productSmallDogContentPanel.setBackground(Color.WHITE);
		productSmallDogContentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));

		shopTabbedPane.setBackgroundAt(1, Color.WHITE);

		JPanel productMiddleDogPanel = new JPanel();
		productMiddleDogPanel.setBackground(Color.WHITE);
		shopTabbedPane.addTab("중형견", new ImageIcon(ShopMainFrame.class.getResource("/images/middle_dog20.png")),
				productMiddleDogPanel, null);
		productMiddleDogPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane productMiddleDogContentPanelScrollPane = new JScrollPane();
		productMiddleDogContentPanelScrollPane.setPreferredSize(new Dimension(390, 780));
		productMiddleDogContentPanelScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		productMiddleDogPanel.add(productMiddleDogContentPanelScrollPane);

		productMiddleDogContentPanel = new JPanel();
		productMiddleDogContentPanel.setPreferredSize(new Dimension(390, 780));
		productMiddleDogContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		productMiddleDogContentPanel.setBackground(Color.WHITE);
		productMiddleDogContentPanelScrollPane.setViewportView(productMiddleDogContentPanel);
		productMiddleDogContentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));
		shopTabbedPane.setBackgroundAt(2, Color.WHITE);

		JPanel productBigDogPanel = new JPanel();
		productBigDogPanel.setBackground(Color.WHITE);
		shopTabbedPane.addTab("대형견", new ImageIcon(ShopMainFrame.class.getResource("/images/big_dog20.png")),
				productBigDogPanel, null);
		productBigDogPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane productBigDogContentPanelScrollPane = new JScrollPane();
		productBigDogContentPanelScrollPane.setPreferredSize(new Dimension(390, 780));
		productBigDogContentPanelScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		productBigDogPanel.add(productBigDogContentPanelScrollPane, BorderLayout.CENTER);

		productBigDogContentPanel = new JPanel();
		productBigDogContentPanel.setPreferredSize(new Dimension(390, 780));
		productBigDogContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		productBigDogContentPanel.setBackground(Color.WHITE);
		productBigDogContentPanelScrollPane.setViewportView(productBigDogContentPanel);
		productBigDogContentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));
		shopTabbedPane.setBackgroundAt(3, Color.WHITE);

		cartPanel = new JPanel();
		cartPanel.setBackground(Color.WHITE);
		shopTabbedPane.addTab("카트", new ImageIcon(ShopMainFrame.class.getResource("/images/cart20.png")), cartPanel, null);
		shopTabbedPane.setEnabledAt(4, false);
		cartPanel.setLayout(new BorderLayout(0, 0));

		cartContentPanelScrollPane = new JScrollPane();
		cartContentPanelScrollPane.setBackground(Color.WHITE);
		cartContentPanelScrollPane.setPreferredSize(new Dimension(390, 780));
		cartContentPanelScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		cartPanel.add(cartContentPanelScrollPane, BorderLayout.CENTER);

		cartContentPanel = new JPanel();
		cartContentPanel.setPreferredSize(new Dimension(390, 780));
		cartContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		cartContentPanel.setBackground(Color.WHITE);
		cartContentPanelScrollPane.setViewportView(cartContentPanel);
		cartContentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 10));
		/**************** UIcartItemPanel[카트아이템1개Panel] **************/
		JPanel cartItemPanel = new JPanel();
		cartItemPanel.setBorder(null);
		cartItemPanel.setBackground(Color.WHITE);
		cartItemPanel.setPreferredSize(new Dimension(350, 72));
		cartItemPanel.setLayout(null);

		JLabel cartItemImageLabel = new JLabel("비글");
		cartItemImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cartItemImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		cartItemImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		cartItemImageLabel.setIcon(
				new ImageIcon(ShopMainFrame.class.getResource("/images/50" + "bigle.png")));
		cartItemImageLabel.setBounds(0, 0, 69, 72);
		cartItemPanel.add(cartItemImageLabel);

		JLabel cartItemDescLabel = new JLabel(new DecimalFormat("#,###").format(300000));
		cartItemDescLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cartItemDescLabel.setFont(new Font("D2Coding", Font.PLAIN, 13));
		cartItemDescLabel.setBounds(61, 25, 74, 23);
		cartItemPanel.add(cartItemDescLabel);

		JButton cartItemDeleteButton = new JButton("");
		cartItemDeleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartItemDeleteButton.setBorder(null);
		cartItemDeleteButton.setBackground(Color.WHITE);
		cartItemDeleteButton
				.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart_item_delete30.png")));
		cartItemDeleteButton.setBounds(335, 27, 15, 17);
		cartItemPanel.add(cartItemDeleteButton);
		
		JLabel cartItemTotPrice = new JLabel(
				new DecimalFormat("#,###").format(9000000));
		cartItemTotPrice.setFont(new Font("D2Coding", Font.PLAIN, 13));
		cartItemTotPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		cartItemTotPrice.setBounds(187, 25, 69, 22);
		cartItemPanel.add(cartItemTotPrice);
		
		JComboBox cartItemQtyComboBox = new JComboBox();
		cartItemQtyComboBox.setModel(
				new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		cartItemQtyComboBox.setBounds(141, 24, 39, 23);
		cartItemQtyComboBox.setSelectedItem(2 + "");
		cartItemPanel.add(cartItemQtyComboBox);
		JButton cartItemUpdateButton = new JButton("수정");
		cartItemUpdateButton.setPreferredSize(new Dimension(57, 23));
		cartItemUpdateButton.setFont(new Font("D2Coding", Font.BOLD, 11));
		cartItemUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		cartItemUpdateButton.setBounds(268, 23, 59, 27);
		cartItemPanel.add(cartItemUpdateButton);

		

		cartContentPanel.add(cartItemPanel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setPreferredSize(new Dimension(350, 15));
		cartContentPanel.add(lblNewLabel);
		
		JButton cartOrderButton = new JButton("주문하기");
		
		cartOrderButton.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		cartOrderButton.setBackground(UIManager.getColor("Button.light"));
		cartOrderButton.setFont(new Font("D2Coding", Font.PLAIN, 17));
		cartOrderButton.setPreferredSize(new Dimension(350, 40));
		cartContentPanel.add(cartOrderButton);
		/**************** UIcartItemPanel[카트아이템1개Panel] **************/
		
		
		
		shopTabbedPane.setBackgroundAt(4, Color.WHITE);

		JPanel userPanel = new JPanel();
		userPanel.setBackground(Color.WHITE);
		userPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {

			}
		});
		shopTabbedPane.addTab("회원", new ImageIcon(ShopMainFrame.class.getResource("/images/user20.png")), userPanel, null);
		shopTabbedPane.setEnabledAt(5, true);
		shopTabbedPane.setBackgroundAt(5, Color.WHITE);
		userPanel.setLayout(new BorderLayout(0, 0));
		
		userTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		userPanel.add(userTabbedPane, BorderLayout.CENTER);
		
		JPanel userLoginPanel = new JPanel();
		userTabbedPane.addTab("로그인", null, userLoginPanel, null);
		userLoginPanel.setLayout(null);
		
		userLoginIdTF = new JTextField();
		userLoginIdTF.setText("guard1");
		userLoginIdTF.setBounds(102, 92, 240, 21);
		userLoginPanel.add(userLoginIdTF);
		userLoginIdTF.setColumns(10);
		
		UserLoginPasswordTF = new JTextField();
		UserLoginPasswordTF.setText("1111");
		UserLoginPasswordTF.setBounds(102, 149, 240, 21);
		userLoginPanel.add(UserLoginPasswordTF);
		UserLoginPasswordTF.setColumns(10);
		
		userLoginPasswordLabel = new JLabel("패쓰워드");
		userLoginPasswordLabel.setBounds(12, 152, 57, 15);
		userLoginPanel.add(userLoginPasswordLabel);
		
		JLabel userLoginIdLabel = new JLabel("아이디");
		userLoginIdLabel.setBounds(12, 95, 57, 15);
		userLoginPanel.add(userLoginIdLabel);
		
		JButton userLoginLoginBtn = new JButton("로그인");
		userLoginLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/********로그인버튼클릭시*********/
				//1.입력유효성체크
				String userid = userLoginIdTF.getText();
				String password=UserLoginPasswordTF.getText();
				if(userid.equals("")) {
					userLoginIdMessageLabel.setText("아이디를 입력하세요.");
					userLoginIdTF.requestFocus();
					return;
				}
				if(password.equals("")) {
					loginPasswordMessageLabel.setText("패쓰워드를 입력하세요.");
					UserLoginPasswordTF.requestFocus();
					return;
				}
				//2.UserService.login 메쏘드호출
				/***********2.UserService.login 메쏘드호출**************/
				try {
					
					int result = userService.login(userid, password);
					if(result==1) {
						/*
						 * 로그인성공
						 *  - 성공한아이디로 User정보얻기
						 *  - ShopMainFrame에 User객체 넘겨주기(ShopMainFrame객체의 메소드호출시 인자로 넘겨주기)
						 *  - 로그인창닫기
						 */
						User loginUser = userService.findUser(userid);
						loginProcess(loginUser);
						
						
						
					}else if(result==0) {
						//로그인실패
						userLoginIdMessageLabel.setText("아이디또는비밀번호가 일치하지않습니다.");
						userLoginIdTF.requestFocus();
						userLoginIdTF.setSelectionStart(0);
						userLoginIdTF.setSelectionEnd(userid.length());
					}
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				/******************************************************/
			}
		});
		userLoginLoginBtn.setBounds(28, 224, 140, 23);
		userLoginPanel.add(userLoginLoginBtn);
		
		userLoginIdMessageLabel = new JLabel("");
		userLoginIdMessageLabel.setBounds(102, 119, 240, 20);
		userLoginPanel.add(userLoginIdMessageLabel);
		
		loginPasswordMessageLabel = new JLabel("");
		loginPasswordMessageLabel.setBounds(102, 180, 240, 20);
		userLoginPanel.add(loginPasswordMessageLabel);
		
		JLabel userInfoTitleLabel = new JLabel("로그인");
		userInfoTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userInfoTitleLabel.setFont(new Font("굴림", Font.BOLD, 22));
		userInfoTitleLabel.setBounds(28, 39, 314, 29);
		userLoginPanel.add(userInfoTitleLabel);
		
		JButton userLoginJoinBtn = new JButton("가입");
		userLoginJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTabbedPane.setSelectedIndex(1);
			}
		});
		userLoginJoinBtn.setBounds(202, 224, 140, 23);
		userLoginPanel.add(userLoginJoinBtn);
		
		JPanel userJoinPanel = new JPanel();
		userTabbedPane.addTab("회원가입", null, userJoinPanel, null);
		userJoinPanel.setLayout(null);
		
		JLabel userJoinNameLabel = new JLabel("이름");
		userJoinNameLabel.setBounds(29, 208, 61, 15);
		userJoinPanel.add(userJoinNameLabel);
		
		userJoinNameTF = new JTextField();
		userJoinNameTF.setColumns(10);
		userJoinNameTF.setBounds(102, 205, 238, 21);
		userJoinPanel.add(userJoinNameTF);
		
		JLabel userJoinEmailLabel = new JLabel("이메일");
		userJoinEmailLabel.setBounds(29, 259, 61, 15);
		userJoinPanel.add(userJoinEmailLabel);
		
		userJoinEmailTF = new JTextField();
		userJoinEmailTF.setColumns(10);
		userJoinEmailTF.setBounds(102, 256, 238, 21);
		userJoinPanel.add(userJoinEmailTF);
		
		JLabel userJoinIdLabel = new JLabel("아이디");
		userJoinIdLabel.setBounds(27, 112, 64, 15);
		userJoinPanel.add(userJoinIdLabel);
		
		userJoinIdTF = new JTextField();
		userJoinIdTF.setColumns(10);
		userJoinIdTF.setBounds(103, 109, 237, 21);
		userJoinPanel.add(userJoinIdTF);
		
		JLabel userJoinPasswordLabel = new JLabel("패쓰워드");
		userJoinPasswordLabel.setBounds(29, 164, 61, 15);
		userJoinPanel.add(userJoinPasswordLabel);
		
		userJoinPasswordTF = new JTextField();
		userJoinPasswordTF.setColumns(10);
		userJoinPasswordTF.setBounds(103, 161, 237, 21);
		userJoinPanel.add(userJoinPasswordTF);
		
		JLabel userJoinTitleLabel = new JLabel("회원가입");
		userJoinTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userJoinTitleLabel.setFont(new Font("굴림", Font.BOLD, 22));
		userJoinTitleLabel.setBounds(29, 56, 314, 29);
		userJoinPanel.add(userJoinTitleLabel);
		
		JButton userJoinBtn = new JButton("가입");
		userJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String userId=userJoinIdTF.getText();
					boolean isDuplicate=
							userService.isDuplicateId(userId);
					if(isDuplicate) {
						userJoinIdTF.setSelectionStart(0);
						userJoinIdTF.setSelectionEnd(userId.length());
						userJoinIdTF.requestFocus();
						userJoinIdMsgLB.setText("아이디가 사용중입니다.");
						return;
					}
					String password=userJoinPasswordTF.getText();
					String name=userJoinNameTF.getText();
					String email=userJoinEmailTF.getText();
					User user=new User(userId, password, name, email);
					userService.create(user);
					userTabbedPane.setSelectedIndex(0);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		userJoinBtn.setBounds(74, 306, 97, 23);
		userJoinPanel.add(userJoinBtn);
		
		JButton userJoinCancleBtn = new JButton("취소");
		userJoinCancleBtn.setBounds(221, 306, 97, 23);
		userJoinPanel.add(userJoinCancleBtn);
		
		userJoinIdMsgLB = new JLabel("");
		userJoinIdMsgLB.setForeground(Color.RED);
		userJoinIdMsgLB.setBounds(113, 136, 227, 15);
		userJoinPanel.add(userJoinIdMsgLB);
		
		JPanel userInfoPanel = new JPanel();
		userInfoPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				idTextField.setText(loginUser.getUserId());
				nameTextField.setText(loginUser.getName());
				emailTextField.setText(loginUser.getEmail());
			}
		});
		userTabbedPane.addTab("회원정보", null, userInfoPanel, null);
		userTabbedPane.setEnabledAt(2, false);
		userInfoPanel.setLayout(null);
		
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(71, 173, 57, 15);
		userInfoPanel.add(nameLabel);
		
		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setBounds(71, 213, 57, 15);
		userInfoPanel.add(emailLabel);
		
		JButton logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					logoutProcess();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		logoutButton.setForeground(Color.DARK_GRAY);
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setBounds(79, 305, 209, 29);
		userInfoPanel.add(logoutButton);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setColumns(10);
		nameTextField.setBounds(172, 170, 116, 21);
		userInfoPanel.add(nameTextField);
		
		emailTextField = new JTextField();
		emailTextField.setEditable(false);
		emailTextField.setColumns(10);
		emailTextField.setBounds(172, 210, 116, 21);
		userInfoPanel.add(emailTextField);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(71, 129, 57, 15);
		userInfoPanel.add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setEnabled(false);
		idTextField.setEditable(false);
		idTextField.setColumns(10);
		idTextField.setBounds(172, 126, 116, 21);
		userInfoPanel.add(idTextField);
		
		JLabel userInfoLabel = new JLabel("회원정보");
		userInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userInfoLabel.setFont(new Font("굴림", Font.BOLD, 22));
		userInfoLabel.setBounds(38, 35, 314, 29);
		userInfoPanel.add(userInfoLabel);
		
		JPanel orderPanel = new JPanel();
		shopTabbedPane.addTab("주문", new ImageIcon(ShopMainFrame.class.getResource("/images/checklist20.png")), orderPanel, null);
		orderPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane orderContentPanelScrollPane = new JScrollPane();
		orderContentPanelScrollPane.setPreferredSize(new Dimension(390, 780));
		orderContentPanelScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		orderContentPanelScrollPane.setBackground(Color.WHITE);
		orderPanel.add(orderContentPanelScrollPane, BorderLayout.CENTER);
		
		JPanel orderContentPanel = new JPanel();
		orderContentPanel.setPreferredSize(new Dimension(390, 780));
		orderContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		orderContentPanel.setBackground(Color.WHITE);
		orderContentPanelScrollPane.setViewportView(orderContentPanel);
		orderContentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel orderItemTitlePanel = new JPanel();
		orderItemTitlePanel.setLayout(null);
		orderItemTitlePanel.setPreferredSize(new Dimension(350, 50));
		orderItemTitlePanel.setBorder(null);
		orderItemTitlePanel.setBackground(Color.WHITE);
		orderContentPanel.add(orderItemTitlePanel);
		
		JLabel cartItemDescLabel_1_1 = new JLabel("300,000");
		cartItemDescLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		cartItemDescLabel_1_1.setFont(new Font("D2Coding", Font.PLAIN, 13));
		cartItemDescLabel_1_1.setBounds(61, 25, 74, 23);
		orderItemTitlePanel.add(cartItemDescLabel_1_1);
		
		JButton cartItemDeleteButton_1_1 = new JButton("");
		cartItemDeleteButton_1_1.setBorder(null);
		cartItemDeleteButton_1_1.setBackground(Color.WHITE);
		cartItemDeleteButton_1_1.setBounds(335, 27, 15, 17);
		orderItemTitlePanel.add(cartItemDeleteButton_1_1);
		
		JLabel cartItemTotPrice_1_1 = new JLabel("9,000,000");
		cartItemTotPrice_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		cartItemTotPrice_1_1.setFont(new Font("D2Coding", Font.PLAIN, 13));
		cartItemTotPrice_1_1.setBounds(187, 25, 69, 22);
		orderItemTitlePanel.add(cartItemTotPrice_1_1);
		
		JPanel orderItemPanel = new JPanel();
		orderItemPanel.setLayout(null);
		orderItemPanel.setPreferredSize(new Dimension(300, 55));
		orderItemPanel.setBorder(null);
		orderItemPanel.setBackground(Color.WHITE);
		orderContentPanel.add(orderItemPanel);
		
		JLabel orderItemImageLabel = new JLabel("");
		orderItemImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		orderItemImageLabel.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/50bigle.jpg")));
		orderItemImageLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		orderItemImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderItemImageLabel.setBounds(0, 0, 51, 60);
		orderItemPanel.add(orderItemImageLabel);
		
		JLabel orderItemDescLabel = new JLabel("300,000");
		orderItemDescLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		orderItemDescLabel.setFont(new Font("D2Coding", Font.PLAIN, 13));
		orderItemDescLabel.setBounds(61, 25, 74, 23);
		orderItemPanel.add(orderItemDescLabel);
		
		JLabel orderItemTotPrice = new JLabel("9,000,000");
		orderItemTotPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		orderItemTotPrice.setFont(new Font("D2Coding", Font.PLAIN, 13));
		orderItemTotPrice.setBounds(187, 25, 69, 22);
		orderItemPanel.add(orderItemTotPrice);
		
		JPanel orderItemPanel_1 = new JPanel();
		orderItemPanel_1.setLayout(null);
		orderItemPanel_1.setPreferredSize(new Dimension(300, 55));
		orderItemPanel_1.setBorder(null);
		orderItemPanel_1.setBackground(Color.WHITE);
		orderContentPanel.add(orderItemPanel_1);
		
		JLabel orderItemImageLabel_1 = new JLabel("");
		orderItemImageLabel_1.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/50dalma.jpg")));
		orderItemImageLabel_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		orderItemImageLabel_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		orderItemImageLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		orderItemImageLabel_1.setBounds(0, 0, 51, 60);
		orderItemPanel_1.add(orderItemImageLabel_1);
		
		JLabel orderItemDescLabel_1 = new JLabel("300,000");
		orderItemDescLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		orderItemDescLabel_1.setFont(new Font("D2Coding", Font.PLAIN, 13));
		orderItemDescLabel_1.setBounds(61, 25, 74, 23);
		orderItemPanel_1.add(orderItemDescLabel_1);
		
		JLabel orderItemTotPrice_1 = new JLabel("9,000,000");
		orderItemTotPrice_1.setHorizontalAlignment(SwingConstants.RIGHT);
		orderItemTotPrice_1.setFont(new Font("D2Coding", Font.PLAIN, 13));
		orderItemTotPrice_1.setBounds(187, 25, 69, 22);
		orderItemPanel_1.add(orderItemTotPrice_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setPreferredSize(new Dimension(350, 15));
		orderContentPanel.add(lblNewLabel_1);

		southMenuPanel = new JPanel();
		southMenuPanel.setBackground(Color.WHITE);
		FlowLayout fl_southMenuPanel = (FlowLayout) southMenuPanel.getLayout();
		fl_southMenuPanel.setHgap(25);
		contentPane.add(southMenuPanel, BorderLayout.SOUTH);

		JButton searchButton = new JButton("검색");
		searchButton.setHorizontalTextPosition(SwingConstants.CENTER);
		searchButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/search_dog50.png")));
		searchButton.setOpaque(false);
		searchButton.setBorderPainted(false);
		searchButton.setBackground(Color.WHITE);
		southMenuPanel.add(searchButton);

		JButton homeButton = new JButton("홈");
		homeButton.setHorizontalTextPosition(SwingConstants.CENTER);
		homeButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***** 하단메뉴홈버튼클릭시인기견보여주기 *******/
				shopTabbedPane.setSelectedIndex(0);
			}
		});
		homeButton.setBackground(Color.WHITE);
		homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeButton.setBorderPainted(false);
		homeButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/shoppingmall.png")));
		homeButton.setOpaque(false);
		southMenuPanel.add(homeButton);

		JButton userButton = new JButton("MY");
		userButton.setHorizontalTextPosition(SwingConstants.CENTER);
		userButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		userButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***** 하단메뉴 사용자버튼클릭시 로그인 혹은 사용자정보 보여주기 *******/
				if (loginUser == null) {
					/************* 1.로그인다이알로그 보여주기 ********
					LoginDialog loginDialog = new LoginDialog();
					loginDialog.setVisible(true);
					// 로그인다이알로그의 메쏘드호출시 ShopMainFrame객체의 참조변수를 인자로대입
					loginDialog.setShopMainFrame(ShopMainFrame.this);
					*/
					shopTabbedPane.setSelectedIndex(5);
					userTabbedPane.setSelectedIndex(0);
					
					
				} else {
					/************** 2.로그인한사용자 정보 보여주기 *************/
					shopTabbedPane.setSelectedIndex(5);
					idTextField.setText(loginUser.getUserId());
					nameTextField.setText(loginUser.getName());
					emailTextField.setText(loginUser.getEmail());

				}

			}
		});
		userButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		userButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/user.png")));
		userButton.setOpaque(false);
		userButton.setBorderPainted(false);
		userButton.setBackground(Color.WHITE);
		southMenuPanel.add(userButton);

		northMenuPanel = new JPanel();
		northMenuPanel.setPreferredSize(new Dimension(10, 35));
		northMenuPanel.setBackground(Color.WHITE);
		contentPane.add(northMenuPanel, BorderLayout.NORTH);
		northMenuPanel.setLayout(null);

		searchTextField = new JTextField();
		searchTextField.setPreferredSize(new Dimension(10, 21));
		searchTextField.setBounds(79, 2, 185, 29);
		northMenuPanel.add(searchTextField);
		searchTextField.setColumns(10);

		cartButton = new JButton("");
		cartButton.setVerticalAlignment(SwingConstants.BOTTOM);
		cartButton.setHorizontalAlignment(SwingConstants.LEFT);
		cartButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loginUser == null) {
					// 1.로그인 안했을때
					/*
					LoginDialog loginDialog = new LoginDialog();
					loginDialog.setShopMainFrame(ShopMainFrame.this);
					loginDialog.setVisible(true);
					*/
					shopTabbedPane.setSelectedIndex(5);
					userTabbedPane.setSelectedIndex(0);
				} else {
					// 2.로그인 했을때
					/********** 카트리스트보여주기 *******/
					try {
						// 카트패널보여주기
						shopTabbedPane.setSelectedIndex(4);
						// 카트리스트보여주기
						displayCartList();
						
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					/**********************************/
				}
			}
		});
		cartButton.setOpaque(false);
		cartButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart25.png")));
		cartButton.setBorderPainted(false);
		cartButton.setBackground(Color.WHITE);
		cartButton.setBounds(312, 1, 45, 35);
		northMenuPanel.add(cartButton);

		cartCountLabel = new JLabel("");
		cartCountLabel.setVerticalAlignment(SwingConstants.TOP);
		cartCountLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		cartCountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cartCountLabel.setOpaque(true);
		cartCountLabel.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/0.png")));
		cartCountLabel.setBackground(Color.WHITE);
		cartCountLabel.setBounds(357, 0, 20, 13);
		northMenuPanel.add(cartCountLabel);

		JLabel mainLogoLabel = new JLabel("");
		mainLogoLabel.setBackground(Color.WHITE);
		mainLogoLabel.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/main_logo60X25.png")));
		mainLogoLabel.setBounds(0, 0, 76, 35);
		northMenuPanel.add(mainLogoLabel);

		JLabel searchImageLabel = new JLabel("");
		searchImageLabel.setBackground(Color.WHITE);
		searchImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchImageLabel.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/search_image20.png")));
		searchImageLabel.setBounds(264, 2, 32, 29);
		northMenuPanel.add(searchImageLabel);

		/************ Service객체멤버변수초기화 ************/
		productService = new ProductService();
		userService = new UserService();
		cartService = new CartService();
		orderService = new OrderService();
		/*************************************************/
		try {
			/************ 인기견리스트보여주기 ************/
			displayProductPopularDogList();
			/************ 소형견리스트보여주기 ************/
			displayProductSmallDogList();
			/************ 중형견리스트보여주기 ************/
			displayProductMiddleDogList();
			/************ 대형견리스트보여주기 ************/
			displayProductBigDogList();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}// 생성자끝

	/********************** 로그인한유저의카트리스트보여주기 ****************/
	public void displayCartList() throws Exception {
		// 카트목록삭제
		cartContentPanel.removeAll();
		List<Cart> cartList = cartService.getCartItemByUserId(loginUser.getUserId());
		for (Cart cart : cartList) {
			/**************** cartItemPanel[카트아이템1개Panel] **************/
			JPanel cartItemPanel = new JPanel();
			cartItemPanel.setBorder(null);
			cartItemPanel.setBackground(Color.WHITE);
			cartItemPanel.setPreferredSize(new Dimension(350, 72));
			cartItemPanel.setLayout(null);

			JLabel cartItemImageLabel = new JLabel(cart.getProduct().getP_name());
			cartItemImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			cartItemImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
			cartItemImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			cartItemImageLabel.setIcon(
					new ImageIcon(ShopMainFrame.class.getResource("/images/50" + cart.getProduct().getP_image())));
			cartItemImageLabel.setBounds(0, 0, 69, 72);
			cartItemPanel.add(cartItemImageLabel);

			JLabel cartItemDescLabel = new JLabel(new DecimalFormat("#,###").format(cart.getProduct().getP_price()));
			cartItemDescLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			cartItemDescLabel.setFont(new Font("D2Coding", Font.PLAIN, 13));
			cartItemDescLabel.setBounds(61, 25, 74, 23);
			cartItemPanel.add(cartItemDescLabel);

			JButton cartItemDeleteButton = new JButton("");
			cartItemDeleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cartItemDeleteButton.addActionListener(new ActionListener() {
				private Cart c = cart;
				JPanel cPanel=cartItemPanel;	
				public void actionPerformed(ActionEvent e) {

					/************** 카트아이템1개삭제 ******************/
					try {
						// 카트아이템삭제
						int deleteCartItemCount = cartService.deleteCartItemByCartNo(c.getCart_no());
						JOptionPane.showMessageDialog(null, deleteCartItemCount + " 개의 제품이 삭제되었습니다.");
						// cart수량 아이콘변경하기
						int cartItemCount = cartService.getCartItemByUserId(loginUser.getUserId()).size();
						cartCountLabel.setIcon(
								new ImageIcon(ShopMainFrame.class.getResource("/images/" + cartItemCount + ".png")));
						// 카트리스트보여주기
						displayCartList();
						shopTabbedPane.setSelectedIndex(0);
						shopTabbedPane.setSelectedIndex(4);
						
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					/*************************************************/

				}
			});
			
			cartItemDeleteButton.setBorder(null);
			cartItemDeleteButton.setBackground(Color.WHITE);
			cartItemDeleteButton
					.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart_item_delete30.png")));
			cartItemDeleteButton.setBounds(335, 27, 15, 17);
			cartItemPanel.add(cartItemDeleteButton);
			
			JLabel cartItemTotPrice = new JLabel(
					new DecimalFormat("#,###").format(cart.getProduct().getP_price() * cart.getCart_qty()));
			cartItemTotPrice.setFont(new Font("D2Coding", Font.PLAIN, 13));
			cartItemTotPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			cartItemTotPrice.setBounds(187, 25, 69, 22);
			cartItemPanel.add(cartItemTotPrice);
			
			JComboBox cartItemQtyComboBox = new JComboBox();
			cartItemQtyComboBox.setModel(
					new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
			cartItemQtyComboBox.setBounds(141, 24, 39, 23);
			cartItemQtyComboBox.setSelectedItem(cart.getCart_qty() + "");
			cartItemPanel.add(cartItemQtyComboBox);
			
			cartItemQtyComboBox.addItemListener(new ItemListener() {
				private Cart c = cart;
				public void itemStateChanged(ItemEvent e) {
					/***수량변경시 선택될때마다호출***/
					if(e.getStateChange()==ItemEvent.SELECTED) {
						/****************카트수량수정******************/
						try {
							String cartSelectedQtyStr = (String)cartItemQtyComboBox.getSelectedItem();
							int cartSelectedQty=Integer.parseInt(cartSelectedQtyStr);
							int updateCartCount = cartService.updateCart(c.getCart_no(),cartSelectedQty);
							//카트아이템총가격변경
							cartItemTotPrice.setText(
									new DecimalFormat("#,###").format(c.getProduct().getP_price()*cartSelectedQty));
							
						}catch (Exception ex) {
							ex.printStackTrace();
						}
						/**********************************************/
					}
				}
			});
			
			

			JButton cartItemUpdateButton = new JButton("수정");
			cartItemUpdateButton.setPreferredSize(new Dimension(57, 23));
			cartItemUpdateButton.setFont(new Font("D2Coding", Font.BOLD, 11));
			cartItemUpdateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			cartItemUpdateButton.setBounds(268, 23, 59, 27);
			cartItemPanel.add(cartItemUpdateButton);
			cartContentPanel.add(cartItemPanel);
			/***************************************************************/

		}
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setPreferredSize(new Dimension(350, 15));
		cartContentPanel.add(lblNewLabel);
		
		JButton cartOrderButton = new JButton("주문하기");
		cartOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("주문~~~~~~~~~");
					orderService.create(loginUser.getUserId());
					displayCartList();
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		cartOrderButton.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		cartOrderButton.setBackground(UIManager.getColor("Button.light"));
		cartOrderButton.setFont(new Font("D2Coding", Font.PLAIN, 17));
		cartOrderButton.setPreferredSize(new Dimension(350, 40));
		cartContentPanel.add(cartOrderButton);

	}

	/*********** 로그인다이알로그에서 로그인성공시 호출하는 메쏘드 ****************/
	public void loginProcess(User loginUser) throws Exception {
		/*
		 * 1. ShopMainFrame의멤버변수에 로그인한User객체를  저장
		 * 2. ShopMainFrame의 타이틀변경
		 * 3. 카트의 수량아이콘변경
		 */
		this.loginUser = loginUser;
		setTitle(loginUser.getName());
		int cartItemCount = cartService.getCartItemByUserId(loginUser.getUserId()).size();
		cartCountLabel.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/" + cartItemCount + ".png")));
		shopTabbedPane.setEnabledAt(4, true);
		shopTabbedPane.setSelectedIndex(0);
		
		userTabbedPane.setEnabledAt(0,false);
		userTabbedPane.setEnabledAt(1,false);
		userTabbedPane.setEnabledAt(2,true);
		userTabbedPane.setSelectedIndex(2);
	}
	public void logoutProcess() throws Exception {
		/*
		 * 1. ShopMainFrame의멤버변수에 로그인한User객삭제
		 * 2. ShopMainFrame의 타이틀변경
		 * 3. 카트탭불활성화
		 */
		this.loginUser = null;
		setTitle("");
		int cartItemCount = 0;
		cartCountLabel.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/" + cartItemCount + ".png")));
		
		shopTabbedPane.setEnabledAt(4, false);
		
		userTabbedPane.setEnabledAt(0,true);
		userTabbedPane.setEnabledAt(1,true);
		userTabbedPane.setEnabledAt(2,true);
		
		shopTabbedPane.setSelectedIndex(0);
	}
	/*********************** 인기견보여주기 *******************************/
	public void displayProductPopularDogList() throws Exception {
		productPopularDogContentPanel.removeAll();
		List<Product> productList = productService.productList();
		Collections.shuffle(productList);
		for (Product product : productList) {
			/************* 제품1개UI디자인 *******************/
			JPanel productPanel = new JPanel();
			productPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			productPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			productPanel.setBounds(new Rectangle(0, 0, 120, 120));
			productPanel.setMaximumSize(new Dimension(200, 200));
			productPanel.setMinimumSize(new Dimension(150, 150));
			productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			productPanel.setBackground(Color.WHITE);
			productPanel.setBorder(null);
			productPanel.setSize(new Dimension(120, 120));
			productPanel.setPreferredSize(new Dimension(170, 190));
			productPanel.setLayout(null);
			JLabel productImageLabel = new JLabel("");
			productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

			productImageLabel
					.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/" + product.getP_image())));
			productImageLabel.setBounds(3, 1, 162, 116);
			productPanel.add(productImageLabel);

			JLabel productDescLabel = new JLabel("<html><font size='3'>" + "견종: " + product.getP_name() + "<br>"
					+ "가격: " + new DecimalFormat("#,###").format(product.getP_price()) + "<br>" + "설명: "
					+ product.getP_desc() + "</font></html>");

			productDescLabel.setVerticalAlignment(SwingConstants.TOP);
			productDescLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			productDescLabel.setHorizontalAlignment(SwingConstants.LEFT);
			productDescLabel.setBounds(3, 143, 164, 47);
			productPanel.add(productDescLabel);

			JComboBox cartQtyComboBox = new JComboBox();
			cartQtyComboBox.setAutoscrolls(true);
			cartQtyComboBox.setModel(
					new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
			cartQtyComboBox.setOpaque(false);
			cartQtyComboBox.setBorder(null);
			cartQtyComboBox.setBackground(Color.WHITE);
			cartQtyComboBox.setBounds(99, 119, 33, 23);
			cartQtyComboBox.setMaximumRowCount(cartQtyComboBox.getModel().getSize());
			productPanel.add(cartQtyComboBox);

			JButton cartAddButton = new JButton("");
			cartAddButton.addActionListener(new ActionListener() {
				private Product p = product;

				public void actionPerformed(ActionEvent e) {

					if (loginUser != null) {
						// 로그인했을때
						/****************** 카트에담기 ***************/
						try {
							String cartQtyStr = (String) cartQtyComboBox.getSelectedItem();
							int cartQty = Integer.parseInt(cartQtyStr);
							Cart addCartItem = 
									new Cart(0,
												new User(loginUser.getUserId(), null, null, null), 
												new Product(p.getP_no(), null, 0, null, null, 0),
												cartQty);

							int addCount = cartService.addCart(loginUser.getUserId(),p.getP_no(),cartQty);
							// 카트수량아이콘변경
							int cartItemCount = cartService.getCartItemByUserId(loginUser.getUserId()).size();
							cartCountLabel.setIcon(new ImageIcon(
									ShopMainFrame.class.getResource("/images/" + cartItemCount + ".png")));
							// 메세지출력
							JOptionPane.showMessageDialog(null, "장바구니에 제품이담겼습니다");

						} catch (Exception ex) {
							ex.printStackTrace();
						}
						/*******************************************/

					} else {
						// 로그인안했을때
						/****************** 로그인다이알로그뛰우기 ***************/
						LoginDialog loginDialog = new LoginDialog();
						loginDialog.setShopMainFrame(ShopMainFrame.this);
						loginDialog.setVisible(true);
					}

				}
			});
			cartAddButton.setBorder(null);
			cartAddButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cartAddButton.setOpaque(false);
			cartAddButton.setBackground(Color.WHITE);
			cartAddButton.setForeground(Color.WHITE);
			cartAddButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart20.png")));
			cartAddButton.setBounds(136, 119, 31, 23);
			productPanel.add(cartAddButton);

			productPopularDogContentPanel.add(productPanel);
			/*******************************/

		}

	}

	/*********************** 소형견보여주기 *******************************/
	public void displayProductSmallDogList() throws Exception {
		List<Product> productList = productService.productList();
		Collections.shuffle(productList);

		for (int i = 0; i < productList.size() - 4; i++) {
			Product product = productList.get(i);
			/************* 제품1개UI디자인 *******************/
			JPanel productPanel = new JPanel();
			productPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			productPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			productPanel.setBounds(new Rectangle(0, 0, 120, 120));
			productPanel.setMaximumSize(new Dimension(200, 200));
			productPanel.setMinimumSize(new Dimension(150, 150));
			productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			productPanel.setBackground(Color.WHITE);
			productPanel.setBorder(null);
			productPanel.setSize(new Dimension(120, 120));
			productPanel.setPreferredSize(new Dimension(170, 190));
			productPanel.setLayout(null);
			JLabel productImageLabel = new JLabel("");
			productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

			productImageLabel
					.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/" + product.getP_image())));
			productImageLabel.setBounds(3, 1, 162, 116);
			productPanel.add(productImageLabel);

			JLabel productDescLabel = new JLabel("<html><font size='3'>" + "견종: " + product.getP_name() + "<br>"
					+ "가격: " + new DecimalFormat("#,###").format(product.getP_price()) + "<br>" + "설명: "
					+ product.getP_desc() + "</font></html>");

			productDescLabel.setVerticalAlignment(SwingConstants.TOP);
			productDescLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			productDescLabel.setHorizontalAlignment(SwingConstants.LEFT);
			productDescLabel.setBounds(3, 143, 164, 47);
			productPanel.add(productDescLabel);

			JComboBox cartQtyComboBox = new JComboBox();
			cartQtyComboBox.setAutoscrolls(true);
			cartQtyComboBox.setModel(
					new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
			cartQtyComboBox.setOpaque(false);
			cartQtyComboBox.setBorder(null);
			cartQtyComboBox.setBackground(Color.WHITE);
			cartQtyComboBox.setBounds(99, 119, 33, 23);
			cartQtyComboBox.setMaximumRowCount(cartQtyComboBox.getModel().getSize());
			productPanel.add(cartQtyComboBox);

			JButton cartAddButton = new JButton("");
			cartAddButton.addActionListener(new ActionListener() {
				private Product p = product;

				public void actionPerformed(ActionEvent e) {

					if (loginUser != null) {
						// 로그인했을때
						/****************** 카트에담기 ***************/
						try {
							String cartQtyStr = (String) cartQtyComboBox.getSelectedItem();
							int cartQty = Integer.parseInt(cartQtyStr);
							int addCount = cartService.addCart(loginUser.getUserId(),p.getP_no(),cartQty);
							// 카트수량아이콘변경
							int cartItemCount = cartService.getCartItemByUserId(loginUser.getUserId()).size();
							cartCountLabel.setIcon(new ImageIcon(
									ShopMainFrame.class.getResource("/images/" + cartItemCount + ".png")));
							// 메세지출력
							JOptionPane.showMessageDialog(null, "장바구니에 제품이담겼습니다");

						} catch (Exception ex) {
							ex.printStackTrace();
						}
						/*******************************************/

					} else {
						// 로그인안했을때
						/****************** 로그인다이알로그뛰우기 ***************/
						LoginDialog loginDialog = new LoginDialog();
						loginDialog.setShopMainFrame(ShopMainFrame.this);
						loginDialog.setVisible(true);
					}

				}
			});
			cartAddButton.setBorder(null);
			cartAddButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cartAddButton.setOpaque(false);
			cartAddButton.setBackground(Color.WHITE);
			cartAddButton.setForeground(Color.WHITE);
			cartAddButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart20.png")));
			cartAddButton.setBounds(136, 119, 31, 23);
			productPanel.add(cartAddButton);

			// productSmallDogContentPanel에 제품UI추가
			productSmallDogContentPanel.add(productPanel);
			/*******************************/

		}
	}

	/*********************** 중형견보여주기 *******************************/
	public void displayProductMiddleDogList() throws Exception {
		List<Product> productList = productService.productList();
		Collections.shuffle(productList);

		for (int i = 0; i < productList.size() - 5; i++) {
			Product product = productList.get(i);
			/************* 제품1개UI디자인 *******************/
			JPanel productPanel = new JPanel();
			productPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			productPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			productPanel.setBounds(new Rectangle(0, 0, 120, 120));
			productPanel.setMaximumSize(new Dimension(200, 200));
			productPanel.setMinimumSize(new Dimension(150, 150));
			productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			productPanel.setBackground(Color.WHITE);
			productPanel.setBorder(null);
			productPanel.setSize(new Dimension(120, 120));
			productPanel.setPreferredSize(new Dimension(170, 190));
			productPanel.setLayout(null);
			JLabel productImageLabel = new JLabel("");
			productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

			productImageLabel
					.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/" + product.getP_image())));
			productImageLabel.setBounds(3, 1, 162, 116);
			productPanel.add(productImageLabel);

			JLabel productDescLabel = new JLabel("<html><font size='3'>" + "견종: " + product.getP_name() + "<br>"
					+ "가격: " + new DecimalFormat("#,###").format(product.getP_price()) + "<br>" + "설명: "
					+ product.getP_desc() + "</font></html>");

			productDescLabel.setVerticalAlignment(SwingConstants.TOP);
			productDescLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			productDescLabel.setHorizontalAlignment(SwingConstants.LEFT);
			productDescLabel.setBounds(3, 143, 164, 47);
			productPanel.add(productDescLabel);

			JComboBox cartQtyComboBox = new JComboBox();
			cartQtyComboBox.setAutoscrolls(true);
			cartQtyComboBox.setModel(
					new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
			cartQtyComboBox.setOpaque(false);
			cartQtyComboBox.setBorder(null);
			cartQtyComboBox.setBackground(Color.WHITE);
			cartQtyComboBox.setBounds(99, 119, 33, 23);
			cartQtyComboBox.setMaximumRowCount(cartQtyComboBox.getModel().getSize());
			productPanel.add(cartQtyComboBox);

			JButton cartAddButton = new JButton("");
			cartAddButton.addActionListener(new ActionListener() {
				private Product p = product;

				public void actionPerformed(ActionEvent e) {

					if (loginUser != null) {
						// 로그인했을때
						/****************** 카트에담기 ***************/
						try {
							String cartQtyStr = (String) cartQtyComboBox.getSelectedItem();
							int cartQty = Integer.parseInt(cartQtyStr);
							Cart addCartItem = 
									new Cart(0,
												new User(loginUser.getUserId(), null, null, null),
												new Product(p.getP_no(), null, 0, null, null, 0),
												cartQty);

							int addCount = cartService.addCart(loginUser.getUserId(),p.getP_no(),cartQty);
							// 카트수량아이콘변경
							int cartItemCount = cartService.getCartItemByUserId(loginUser.getUserId()).size();
							cartCountLabel.setIcon(new ImageIcon(
									ShopMainFrame.class.getResource("/images/" + cartItemCount + ".png")));
							// 메세지출력
							JOptionPane.showMessageDialog(null, "장바구니에 제품이담겼습니다");

						} catch (Exception ex) {
							ex.printStackTrace();
						}
						/*******************************************/

					} else {
						// 로그인안했을때
						/****************** 로그인다이알로그뛰우기 ***************/
						LoginDialog loginDialog = new LoginDialog();
						loginDialog.setShopMainFrame(ShopMainFrame.this);
						loginDialog.setVisible(true);
					}

				}
			});
			cartAddButton.setBorder(null);
			cartAddButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cartAddButton.setOpaque(false);
			cartAddButton.setBackground(Color.WHITE);
			cartAddButton.setForeground(Color.WHITE);
			cartAddButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart20.png")));
			cartAddButton.setBounds(136, 119, 31, 23);
			productPanel.add(cartAddButton);

			productMiddleDogContentPanel.add(productPanel);
			/*******************************/

		}
	}

	/*********************** 대형견보여주기 *******************************/
	public void displayProductBigDogList() throws Exception {
		List<Product> productList = productService.productList();
		Collections.shuffle(productList);
		for (int i = 0; i < productList.size() - 7; i++) {
			Product product = productList.get(i);
			/************* 제품1개UI디자인 *******************/
			JPanel productPanel = new JPanel();
			productPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			productPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			productPanel.setBounds(new Rectangle(0, 0, 120, 120));
			productPanel.setMaximumSize(new Dimension(200, 200));
			productPanel.setMinimumSize(new Dimension(150, 150));
			productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			productPanel.setBackground(Color.WHITE);
			productPanel.setBorder(null);
			productPanel.setSize(new Dimension(120, 120));
			productPanel.setPreferredSize(new Dimension(170, 190));
			productPanel.setLayout(null);
			JLabel productImageLabel = new JLabel("");
			productImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

			productImageLabel
					.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/" + product.getP_image())));
			productImageLabel.setBounds(3, 1, 162, 116);
			productPanel.add(productImageLabel);

			JLabel productDescLabel = new JLabel("<html><font size='3'>" + "견종: " + product.getP_name() + "<br>"
					+ "가격: " + new DecimalFormat("#,###").format(product.getP_price()) + "<br>" + "설명: "
					+ product.getP_desc() + "</font></html>");

			productDescLabel.setVerticalAlignment(SwingConstants.TOP);
			productDescLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			productDescLabel.setHorizontalAlignment(SwingConstants.LEFT);
			productDescLabel.setBounds(3, 143, 164, 47);
			productPanel.add(productDescLabel);

			JComboBox cartQtyComboBox = new JComboBox();
			cartQtyComboBox.setAutoscrolls(true);
			cartQtyComboBox.setModel(
					new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
			cartQtyComboBox.setOpaque(false);
			cartQtyComboBox.setBorder(null);
			cartQtyComboBox.setBackground(Color.WHITE);
			cartQtyComboBox.setBounds(99, 119, 33, 23);
			cartQtyComboBox.setMaximumRowCount(cartQtyComboBox.getModel().getSize());
			productPanel.add(cartQtyComboBox);

			JButton cartAddButton = new JButton("");
			cartAddButton.addActionListener(new ActionListener() {
				private Product p = product;

				public void actionPerformed(ActionEvent e) {

					if (loginUser != null) {
						// 로그인했을때
						/****************** 카트에담기 ***************/
						try {
							String cartQtyStr = (String) cartQtyComboBox.getSelectedItem();
							int cartQty = Integer.parseInt(cartQtyStr);
							int addCount = cartService.addCart(loginUser.getUserId(),p.getP_no(),cartQty);
							// 카트수량아이콘변경
							int cartItemCount = cartService.getCartItemByUserId(loginUser.getUserId()).size();
							cartCountLabel.setIcon(new ImageIcon(
									ShopMainFrame.class.getResource("/images/" + cartItemCount + ".png")));
							// 메세지출력
							JOptionPane.showMessageDialog(null, "장바구니에 제품이담겼습니다");

						} catch (Exception ex) {
							ex.printStackTrace();
						}
						/*******************************************/

					} else {
						// 로그인안했을때
						/****************** 로그인다이알로그뛰우기 ***************/
						LoginDialog loginDialog = new LoginDialog();
						loginDialog.setShopMainFrame(ShopMainFrame.this);
						loginDialog.setVisible(true);
					}
				}
			});
			cartAddButton.setBorder(null);
			cartAddButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cartAddButton.setOpaque(false);
			cartAddButton.setBackground(Color.WHITE);
			cartAddButton.setForeground(Color.WHITE);
			cartAddButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart20.png")));
			cartAddButton.setBounds(136, 119, 31, 23);
			productPanel.add(cartAddButton);

			productBigDogContentPanel.add(productPanel);
			/*******************************/

		}
	}
}// end class
