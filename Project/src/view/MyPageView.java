package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.CardDAO;
import model.CustomerDAO;
import model.DeliveryDAO;
import model.MissionDAO;
import model.RefundDAO;
import model.SignUpDAO;
import model.rec.CardVO;
import model.rec.CustomerVO;
import model.rec.DeliveryVO;
import model.rec.MissionVO;
import model.rec.RefundVO;

public class MyPageView extends JFrame implements ActionListener {

	private JFrame frame;
	JPanel myPageMain;
	JPanel cardInfoJPanel;
	JTable cardInfotable;
	// ��������
	JPasswordField passwordField;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JLabel lb010;
	JButton btnmodify;
	JPanel modifypanel;
	JLabel lbnick = new JLabel("�г���");
	JLabel lbtel = new JLabel("��ȭ��ȣ");
	JLabel lbaddr = new JLabel("�ּ�");;
	JLabel lbpw = new JLabel("��й�ȣ");;
	// �̼�
	JTable missiontable;
	JPanel missionpanel;
	JComboBox missioncomboBox = new JComboBox<>();

	JScrollPane missionscrollPane;
	MissionTableModel tmmission;
	JTextField tfMissionSearch;

	ArrayList list;

	SignUpDAO sdao = null;
	CustomerDAO csdao = null;
	CustomerVO csvo = null;
	MissionDAO mdao = null;
	MissionVO mvo = null;
	CardVO cvo;
	CardDAO cdao;
	DeliveryVO dvo;
	DeliveryDAO ddao;
	RefundVO rvo;
	RefundDAO rdao;
	RefundView rview;
	DeliveryDetailView dview;
	MyPageView mview;
	RefundView refund;
	ArrayList cardList;
	ArrayList deliList;
	String orderNo;
	String RefundNo;

	JPanel deliveryInfoPanel;
	JTable deliveryInfotable;
	JTextField ordernocode;
	JTextField ordernocode2;

	static int pk;
	static String nick;
	static int point;
	JButton btnback;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPageView frame = new MyPageView(pk, nick, point);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// DB ����
	public MyPageView(int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;

//		CustomerDAO cdao = new CustomerDAO();
//		CustomerVO cvo = cdao.info(pk);

		addLayout();

//		CustomerDAO cdao = new CustomerDAO();
//		CustomerVO vo = cdao.info(pk, nick, point);

		cardInfo();
		deliveryInfo();
		// modifyInfo();
		missionInfo();

		offSwitchDeli();
		offSwitchCard();
		offSwitchmodify();
		offSwitchmission();

		try {
			csvo = new CustomerVO();
			csdao = new CustomerDAO();
			list = csdao.custAll();
			mdao = new MissionDAO();
			cdao = new CardDAO();
			cvo = new CardVO();
			cardList = cdao.cardAll();
			ddao = new DeliveryDAO();
			dvo = new DeliveryVO();
			deliList = ddao.deliveryAll();
			rdao = new RefundDAO();
			rvo = new RefundVO();
			System.out.println("��DB ���� ����!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��DB ���� ���� : " + e.getMessage());
		}

	}

	public void addLayout() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 820);
		myPageMain = new JPanel();
		myPageMain.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(myPageMain);
		myPageMain.setLayout(null);

		btnback = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MainHomeView plantview = new MainHomeView(pk, nick, point);
				plantview.setVisible(true);

			}
		});
		deliveryInfoPanel = new JPanel();
		deliveryInfoPanel.setBounds(233, 153, 1093, 609);
		myPageMain.add(deliveryInfoPanel);
		deliveryInfoPanel.setLayout(null);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(30, 36, 1019, 480);
		deliveryInfoPanel.add(scrollPane2);

		deliveryInfotable = new JTable();
		deliveryInfotable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Ŭ���Ҷ� ���ž����۹�ȣ �������� -- ȯ��
				int col2 = 2;
				int row2 = deliveryInfotable.getSelectedRow();
				String ordernocode2 = String.valueOf(deliveryInfotable.getValueAt(row2, col2));
				MyPageView.this.ordernocode2.setText(ordernocode2);
				// Ŭ���Ҷ� ��۹�ȣ �������� -- ��ۻ�
				int col = 5;
				int row = deliveryInfotable.getSelectedRow();
				String ordernocode = String.valueOf(deliveryInfotable.getValueAt(row, col));
				MyPageView.this.ordernocode.setText(ordernocode);
			}
		});

		deliveryInfotable.setFont(new Font("�������", Font.PLAIN, 15));
		deliveryInfotable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "�ֹ���ȣ", "�ֹ���¥", "���ž����۹�ȣ", "��ǰ��", "��ǰ����", "��۹�ȣ", "��ۿ�����", "��ۻ���" }));
		deliveryInfotable.getColumnModel().getColumn(1).setMinWidth(75);
		scrollPane2.setViewportView(deliveryInfotable);

		// ��ۻ󼼺�� �Ѿ��
		JButton detailbtn = new JButton("��ۻ� ��ȸ");
		detailbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderNo = (String) deliveryInfotable.getValueAt(deliveryInfotable.getSelectedRow(), 5);
				DeliveryDetailView DeliveryDetail = new DeliveryDetailView(dvo, orderNo, pk, nick, point);
				DeliveryDetail.setVisible(true);
			}
		});
		detailbtn.setFont(new Font("�������", Font.PLAIN, 15));
		detailbtn.setBounds(215, 542, 131, 31);
		deliveryInfoPanel.add(detailbtn);

		ordernocode = new JTextField();
		ordernocode.setEditable(false);
		ordernocode.setHorizontalAlignment(SwingConstants.CENTER);
		ordernocode.setFont(new Font("�������", Font.PLAIN, 15));
		ordernocode.setBounds(100, 542, 102, 31);
		deliveryInfoPanel.add(ordernocode);
		ordernocode.setColumns(10);

		JLabel lblNewLabel = new JLabel("��۹�ȣ");
		lblNewLabel.setFont(new Font("�������", Font.PLAIN, 15));
		lblNewLabel.setBounds(30, 542, 113, 31);
		deliveryInfoPanel.add(lblNewLabel);

		JLabel lblNewLabel2 = new JLabel("���ž����۹�ȣ");
		lblNewLabel2.setFont(new Font("�������", Font.PLAIN, 15));
		lblNewLabel2.setBounds(512, 542, 113, 31);
		deliveryInfoPanel.add(lblNewLabel2);

		ordernocode2 = new JTextField();
		ordernocode2.setEditable(false);
		ordernocode2.setHorizontalAlignment(SwingConstants.CENTER);
		ordernocode2.setFont(new Font("�������", Font.PLAIN, 15));
		ordernocode2.setColumns(10);
		ordernocode2.setBounds(627, 542, 102, 31);
		deliveryInfoPanel.add(ordernocode2);

		// ȯ���ϱ�� �Ѿ��
		JButton refundbtn = new JButton("ȯ���ϱ�");
		refundbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			    int col3 = 7;
//			    int row3 = deliveryInfotable.getSelectedRow();
//			    String deliverynow = (String) deliveryInfotable.getValueAt(row3, col3);
				String deliverynow = (String) deliveryInfotable.getValueAt(deliveryInfotable.getSelectedRow(), 7);
				if (deliverynow.equals("����غ���")) {
					// ȯ�� ���� ����
//				    int col4 = 2;
//				    int row4 = deliveryInfotable.getSelectedRow();
//				    String refundNo = (String) deliveryInfotable.getValueAt(row4, col4);
					String refundNo = (String) deliveryInfotable.getValueAt(deliveryInfotable.getSelectedRow(), 2);
					RefundView refund = new RefundView(refundNo, pk, nick, point);
					refund.setVisible(true);
				} else {
					// ���� �޽��� ǥ��
					JOptionPane.showMessageDialog(null, "����� �Ǵ� ��ۿϷ�� ��ǰ�� ȯ���� �Ұ����մϴ�.", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		refundbtn.setFont(new Font("�������", Font.PLAIN, 15));
		refundbtn.setBounds(918, 542, 131, 31);
		deliveryInfoPanel.add(refundbtn);

		JButton refundbtn_1 = new JButton("�ı⾲��");
		refundbtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		refundbtn_1.setFont(new Font("�������", Font.PLAIN, 15));
		refundbtn_1.setBounds(741, 542, 131, 31);
		deliveryInfoPanel.add(refundbtn_1);
		missionpanel = new JPanel();
		missionpanel.setBounds(233, 153, 1093, 609);
		myPageMain.add(missionpanel);
		missionpanel.setLayout(null);

		missioncomboBox = new JComboBox();
//		missioncomboBox.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//					
//			}
//		});

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				missionSearch();
			}
		});

		missioncomboBox.setModel(new DefaultComboBoxModel(new String[] { "�Ϸ�", "�̿Ϸ�" }));
		missioncomboBox.setBounds(24, 31, 117, 23);
		missionpanel.add(missioncomboBox);

		missionscrollPane = new JScrollPane();
		missionscrollPane.setBounds(24, 52, 1018, 483);
		missionpanel.add(missionscrollPane);

		missiontable = new JTable();
		missiontable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\uBBF8\uC158\uBA85", "\uBBF8\uC158 \uD3EC\uC778\uD2B8" }));
		missionscrollPane.setViewportView(missiontable);

		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (missioncomboBox.getSelectedIndex() == 0) {
					missionSearch();
				} else {
					missionmiSearch();
				}
			}
		});

		btnNewButton.setFont(new Font("�������", Font.PLAIN, 15));
		btnNewButton.setBounds(153, 31, 117, 23);
		missionpanel.add(btnNewButton);

		modifypanel = new JPanel();
		modifypanel.setBounds(233, 153, 1093, 609);
		myPageMain.add(modifypanel);
		modifypanel.setLayout(null);

		lbnick = new JLabel("\uB2C9\uB124\uC784");
		lbnick.setFont(new Font("�������", Font.PLAIN, 20));
		lbnick.setBounds(239, 136, 65, 24);
		modifypanel.add(lbnick);

		lbtel = new JLabel("\uC804\uD654\uBC88\uD638");
		lbtel.setFont(new Font("�������", Font.PLAIN, 20));
		lbtel.setBounds(239, 251, 89, 24);
		modifypanel.add(lbtel);

		lbaddr = new JLabel("\uC8FC\uC18C");
		lbaddr.setFont(new Font("�������", Font.PLAIN, 20));
		lbaddr.setBounds(239, 356, 41, 24);
		modifypanel.add(lbaddr);

		passwordField = new JPasswordField();
		passwordField.setBounds(273, 76, 274, 29);
		modifypanel.add(passwordField);

		textField = new JTextField();
		textField.setBounds(273, 170, 274, 29);
		modifypanel.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				missionSearch();
			}
		});

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(273, 390, 274, 29);
		modifypanel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(342, 285, 205, 29);
		modifypanel.add(textField_2);

		lb010 = new JLabel("010 -");
		lb010.setFont(new Font("�������", Font.PLAIN, 20));
		lb010.setBounds(273, 292, 57, 15);
		modifypanel.add(lb010);

		btnmodify = new JButton("\uC218\uC815");
		btnmodify.setFont(new Font("�������", Font.PLAIN, 20));
		btnmodify.setBounds(342, 496, 148, 40);
		modifypanel.add(btnmodify);

		JLabel lbpw = new JLabel("PW");
		lbpw.setFont(new Font("�������", Font.PLAIN, 20));
		lbpw.setBounds(239, 37, 41, 29);
		modifypanel.add(lbpw);

		// ȸ�� �������� �ϴ� �ڵ�
		btnmodify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				csvo = new CustomerVO();
				try {
					csvo.setMembercode(pk);
					csvo.setPw(passwordField.getText());
					csvo.setNick(textField.getText());
					csvo.setTel(textField_2.getText());
					csvo.setAddr(textField_1.getText());

					csdao = new CustomerDAO();
					csdao.updateInfo(csvo);
					System.out.println("��������");

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showConfirmDialog(null, "��������" + e2.getMessage());
				}
			}
		});

		btnback.setFont(new Font("�������", Font.PLAIN, 18));
		btnback.setBounds(60, 659, 142, 31);
		myPageMain.add(btnback);

		JLabel mypage = new JLabel("My Page");
		mypage.setFont(new Font("�������", Font.PLAIN, 18));
		mypage.setBounds(60, 47, 113, 30);
		myPageMain.add(mypage);

		JButton orderlist = new JButton("�ֹ�����");
		orderlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deliveryInfoPanel.setVisible(true);
				deliveryInfotable.setVisible(true);
				cardInfoJPanel.setVisible(false);
				cardInfotable.setVisible(false);
				modifypanel.setVisible(false);
				lbpw.setVisible(false);
				lbnick.setVisible(false);
				lbtel.setVisible(false);
				lbaddr.setVisible(false);
				passwordField.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				lb010.setVisible(false);
				btnmodify.setVisible(false);
				missionpanel.setVisible(false);
				missioncomboBox.setVisible(false);
				missionscrollPane.setVisible(false);
				missiontable.setVisible(false);

				try {
					ArrayList<ArrayList<String>> deliList = ddao.deliveryAll();

					DefaultTableModel model = (DefaultTableModel) deliveryInfotable.getModel();
					model.setRowCount(0); // ���̺� �ʱ�ȭ

					for (ArrayList<String> deli : deliList) {
						model.addRow(deli.toArray());
					}
				} catch (SQLException ev) {
					// TODO Auto-generated catch block
					ev.printStackTrace();
				}
			}
		});
		orderlist.setFont(new Font("�������", Font.PLAIN, 18));
		orderlist.setBounds(60, 304, 142, 31);
		myPageMain.add(orderlist);

		JButton cardinfo = new JButton("ī������");
		cardinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardInfoJPanel.setVisible(true);
				cardInfotable.setVisible(true);
				modifypanel.setVisible(false);
				lbpw.setVisible(false);
				lbnick.setVisible(false);
				lbtel.setVisible(false);
				lbaddr.setVisible(false);
				passwordField.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				lb010.setVisible(false);
				btnmodify.setVisible(false);
				missionpanel.setVisible(false);
				missioncomboBox.setVisible(false);
				missionscrollPane.setVisible(false);
				missiontable.setVisible(false);
				deliveryInfoPanel.setVisible(false);
				deliveryInfotable.setVisible(false);
				try {
					ArrayList<ArrayList<String>> cardList = cdao.cardAll();

					DefaultTableModel model = (DefaultTableModel) cardInfotable.getModel();
					model.setRowCount(0); // ���̺� �ʱ�ȭ

					for (ArrayList<String> card : cardList) {
						model.addRow(card.toArray());
					}
				} catch (SQLException ev) {
					ev.printStackTrace();
				}
			}
		});

		cardinfo.setFont(new Font("�������", Font.PLAIN, 18));
		cardinfo.setBounds(60, 345, 142, 31);
		myPageMain.add(cardinfo);

		JButton editinfo = new JButton("��������");
		editinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifypanel.setVisible(true);
				lbpw.setVisible(true);
				lbnick.setVisible(true);
				lbtel.setVisible(true);
				lbaddr.setVisible(true);
				passwordField.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				lb010.setVisible(true);
				btnmodify.setVisible(true);
				cardInfoJPanel.setVisible(false);
				cardInfotable.setVisible(false);
				missionpanel.setVisible(false);
				missioncomboBox.setVisible(false);
				missionscrollPane.setVisible(false);
				missiontable.setVisible(false);
				deliveryInfoPanel.setVisible(false);
				deliveryInfotable.setVisible(false);
			}
		});

		editinfo.setFont(new Font("�������", Font.PLAIN, 18));
		editinfo.setBounds(60, 386, 142, 31);
		myPageMain.add(editinfo);

		JButton mission = new JButton("�̼�");
		mission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				missionpanel.setVisible(true);
				missioncomboBox.setVisible(true);
				missionscrollPane.setVisible(true);
				missiontable.setVisible(true);
				cardInfoJPanel.setVisible(false);
				cardInfotable.setVisible(false);
				modifypanel.setVisible(false);
				lbpw.setVisible(false);
				lbnick.setVisible(false);
				lbtel.setVisible(false);
				lbaddr.setVisible(false);
				passwordField.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				lb010.setVisible(false);
				btnmodify.setVisible(false);
				deliveryInfoPanel.setVisible(false);
				deliveryInfotable.setVisible(false);
			}
		});

		mission.setFont(new Font("�������", Font.PLAIN, 18));
		mission.setBounds(60, 427, 142, 31);
		myPageMain.add(mission);

		JButton attend = new JButton("�⼮üũ��Ȳ");
		attend.setFont(new Font("�������", Font.PLAIN, 18));
		attend.setBounds(60, 468, 142, 31);
		myPageMain.add(attend);

		attend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		attend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AttendView AttendView = new AttendView(pk, nick, point);
				AttendView.setVisible(true);

			}
		});

		JButton logo = new JButton("");
		logo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MainHomeView plantview = new MainHomeView(pk, nick, point);
				plantview.setVisible(true);

			}
		});
		logo.setBounds(642, 23, 97, 97);
		myPageMain.add(logo);

	}

	// �ֹ� ����
	void deliveryInfo() {
	}

	// ī�� ����
	void cardInfo() {
		cardInfoJPanel = new JPanel();
		cardInfoJPanel.setBounds(233, 153, 1093, 609);
		myPageMain.add(cardInfoJPanel);
		cardInfoJPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 36, 1019, 480);
		cardInfoJPanel.add(scrollPane);

		cardInfotable = new JTable();
		cardInfotable.setFont(new Font("�������", Font.PLAIN, 15));
		cardInfotable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ī���", "ī���ȣ", "��ȿ�Ⱓ" }));
		cardInfotable.getColumnModel().getColumn(1).setMinWidth(75);
		scrollPane.setViewportView(cardInfotable);

		JButton attend = new JButton("�߰�");
		attend.setFont(new Font("�������", Font.PLAIN, 15));
		attend.setBounds(392, 538, 121, 31);
		cardInfoJPanel.add(attend);

		JButton attend_1 = new JButton("����");
		attend_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = cardInfotable.getSelectedRow(); // ���õ� row�� �ε��� ��������

				if (selectedRow != -1) { // ���õ� row�� �ִ� ���
					DefaultTableModel model = (DefaultTableModel) cardInfotable.getModel();
					String cNumString = (String) model.getValueAt(selectedRow, 5); // ���õ� row�� ī���ȣ �� ��������

					try {
						model.removeRow(selectedRow);
						cdao.deleteCard(cNumString); // ī���ȣ�� ����Ͽ� ī�� ���� ����
						JOptionPane.showMessageDialog(null, "ī������ ���� ����!");
					} catch (Exception ev) {
						JOptionPane.showMessageDialog(null, "ī������ ���� ����: " + ev.getMessage());
					}

				}
			}
		});
		attend_1.setFont(new Font("�������", Font.PLAIN, 15));
		attend_1.setBounds(525, 538, 121, 31);
		cardInfoJPanel.add(attend_1);

		JLabel lblNewLabel_1 = new JLabel(nick + "��");
		lblNewLabel_1.setFont(new Font("�������", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(57, 153, 116, 31);
		myPageMain.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(point + "��");
		lblNewLabel_2.setFont(new Font("�������", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(57, 194, 97, 31);
		myPageMain.add(lblNewLabel_2);

	}

	// �̼�
	void missionInfo() {
	}

	void offSwitchDeli() {
		deliveryInfoPanel.setVisible(false);
		deliveryInfotable.setVisible(false);
	}

	void offSwitchmission() {
		missionpanel.setVisible(false);
		missioncomboBox.setVisible(false);
		missionscrollPane.setVisible(false);
		missiontable.setVisible(false);
	}

	void offSwitchmodify() {
		modifypanel.setVisible(false);
		lbnick.setVisible(false);
		lbtel.setVisible(false);
		lbaddr.setVisible(false);
		passwordField.setVisible(false);
		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		lb010.setVisible(false);
		btnmodify.setVisible(false);
	}

	void offSwitchCard() {
		cardInfoJPanel.setVisible(false);
	}

//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		 Object o = e.getSource();
//		 if(o == tfMissionSearch) {
//			 MissionselectTable();
//		 }
//	}

	// �̼� �Ϸ� �޼ҵ�
	void missionSearch() {
		int membercode = pk;
		// String text = textField.getText();
		try {

			list = mdao.missionSearch(membercode);
			tmmission.data = list;
			missiontable.setModel(tmmission);
			tmmission.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "��������: " + e.getMessage());
		}

	}

	// �̼� �̿Ϸ� �޼ҵ�
	void missionmiSearch() {
		int sel = missioncomboBox.getSelectedIndex();
		String text = textField.getText();

		try {
			list = mdao.missionmiSearch(sel, text);

			tmmission.data = list;
			missiontable.setModel(tmmission);
			tmmission.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "��������: " + e.getMessage());
		}
	}

	class MissionTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "�̼Ǹ�", "�̼� ����Ʈ" };

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}