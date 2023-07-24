package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.MainHomeDAO;
import model.rec.MainHomeVO;

public class MainHomeView extends JFrame {

	JPanel contentPane;
	JTextField textField;

	JTable sctable;

	MainHomeDAO dao = null;
	MainHomeVO vo = null;

	JTextField tfHomename, tfHomeavgtime, tflevel, tfcost, tfprice, tfproflt;
	JLabel nicklabel;

	JTextField tfHomeSearch;
	HomeTableModel tmHome;
	JTextArea taHomeContent;
	JComboBox comboBox_1;
	ArrayList list;
	private AbstractButton textFieldmem;
	static int pk;
	static String nick;
	static int point;

	/**
	 * Launch the application.
	 */
	public MainHomeView(int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		newObject();
		addLayout(pk, nick, point);

		try {
			dao = new MainHomeDAO();
			System.out.println("비디오연결성공");
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "연결실패:" + e.getMessage());
			// TODO: handle exception
		}
	}

//	public MainHomeView() {
//		newObject();
//		addLayout();
//		this.pk = pk;
//		
//		try {
//			dao = new MainHomeDAO();
//			System.out.println("비디오연결성공");
//		} catch (Exception e) {
//			JOptionPane.showConfirmDialog(null, "연결실패:" + e.getMessage());
//			// TODO: handle exception
//		}
//	}
	void newObject() {
		tfHomename = new JTextField(30);
		tfHomeavgtime = new JTextField(30);
		tflevel = new JTextField(30);
		tfcost = new JTextField(30);
		tfprice = new JTextField(30);
		tfproflt = new JTextField(30);

		taHomeContent = new JTextArea(15, 3);

		tfHomeSearch = new JTextField(30);

		tmHome = new HomeTableModel();
		sctable = new JTable(tmHome);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainHomeView frame = new MainHomeView(pk, nick, point);
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

	void addLayout(int pk, String nick, int point) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(""));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(""));
		lblNewLabel_1.setBounds(86, 175, 110, 130);
		contentPane.add(lblNewLabel_1);

		JButton shoppingbt = new JButton("쇼핑하기");
		shoppingbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SellView sellview = new SellView(pk, nick, point);
				sellview.setVisible(true);
			}
		});
		shoppingbt.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		shoppingbt.setBounds(244, 382, 217, 104);
		contentPane.add(shoppingbt);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(""));
		lblNewLabel_1_1.setBounds(86, 366, 110, 130);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(""));
		lblNewLabel_1_2.setBounds(86, 555, 110, 130);
		contentPane.add(lblNewLabel_1_2);

		JButton btnNewButton_1_2 = new JButton("미니 텃밭 예약");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GardenView gardenview = new GardenView(pk, nick, point);
				gardenview.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnNewButton_1_2.setBounds(244, 566, 217, 104);
		contentPane.add(btnNewButton_1_2);

		JButton jangtbt = new JButton("장터 이용");
		jangtbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jangtbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MarketView markertview = new MarketView(pk, nick, point);
				markertview.setVisible(true);

			}

		});

		jangtbt.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		jangtbt.setBounds(244, 187, 217, 104);
		contentPane.add(jangtbt);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AttendView attendview = new AttendView(pk, nick, point);
				attendview.setVisible(true);

			}
		});
		btnNewButton_2.setIcon(new ImageIcon(""));
		btnNewButton_2.setBounds(88, 46, 84, 72);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(""));
		btnNewButton_5.setBounds(608, 46, 110, 78);
		contentPane.add(btnNewButton_5);

		comboBox_1 = new JComboBox();

		comboBox_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "식물", "과일", "채소" }));
		comboBox_1.setBounds(543, 187, 65, 45);
		contentPane.add(comboBox_1);
		// 무슨기능을 작동시키기 위한 메소드
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainHomeselectTable();
			}
		});
		textField.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(620, 187, 201, 45);
		contentPane.add(textField);

		// 검색 마우스 클릭 시 이벤트
		JButton btnNewButton_8 = new JButton("검색");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainHomeselectTable();

			}
		});

		btnNewButton_8.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btnNewButton_8.setBounds(833, 187, 65, 45);
		contentPane.add(btnNewButton_8);

		JLabel lblNewLabel = new JLabel("    출석체크");
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(86, 116, 86, 23);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyPageView mypageview = new MyPageView(pk, nick, point);
				mypageview.setVisible(true);

			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon(""));
		btnNewButton_2_1.setBounds(1157, 58, 84, 72);
		contentPane.add(btnNewButton_2_1);

		JScrollPane sc = new JScrollPane();
		sc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sc.setBounds(543, 256, 714, 412);
		contentPane.add(sc);

		sctable = new JTable();
		sctable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		sctable.setModel(tmHome);

		sc.setViewportView(sctable);

		JLabel nicklabel = new JLabel(nick + "님");
		nicklabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));

		nicklabel.setBounds(1157, 125, 187, 33);
		contentPane.add(nicklabel);

	}

	// 검색 메소드
	void MainHomeselectTable() {
		int sel = comboBox_1.getSelectedIndex();
		String text = textField.getText();

		try {
			list = dao.homeSearch(sel, text);
			tmHome.data = list;
			sctable.setModel(tmHome);
			tmHome.fireTableDataChanged();
		} catch (Exception e2) {
			JOptionPane.showConfirmDialog(null, "검색실패:" + e2.getMessage());
			// TODO: handle exception
		}
	}
}

class HomeTableModel extends AbstractTableModel {

	ArrayList data = new ArrayList();
	String[] columnNames = { "식물 이름", "키우는 평균 시간", "난이도", "초기비용", "거래가", "예상수익률" };

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		ArrayList temp = (ArrayList) data.get(row);
		return temp.get(col);
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

}
