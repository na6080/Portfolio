package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import model.MarketDAO;
import model.rec.MarketVO;

public class SWritingView extends JFrame {

	JPanel panel;
	JTextField tftitle;
	JTextField tfprice;
	JTextArea tacontent;

	static int pk;
	static String nick;
	static int point;

	JButton btnNewButton;

	MarketVO vo = null;
	MarketDAO dao = null;

	/**
	 * Launch the application.
	 */
	public SWritingView(int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		newObject();
		addLayout();

		try {
			dao = new MarketDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					SWritingView frame = new SWritingView(pk, nick, point);
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
	void newObject() {

		tfprice = new JTextField(30);
		tftitle = new JTextField(30);
		tacontent = new JTextArea(15, 3);

		btnNewButton = new JButton("글올리기");

	}

	void addLayout() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(SWritingView.class.getResource("")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 555);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("제목 : ");
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		lblNewLabel.setBounds(281, 74, 49, 35);
		panel.add(lblNewLabel);

		tftitle = new JTextField();
		tftitle.setBounds(342, 76, 336, 35);
		panel.add(tftitle);
		tftitle.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(117, 119, 742, 287);
		panel.add(scrollPane);

		JTextArea areacontent = new JTextArea();
		areacontent.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		scrollPane.setViewportView(areacontent);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "삽니다", "팝니다" }));
		comboBox.setBounds(117, 75, 72, 37);
		panel.add(comboBox);

		JComboBox palntcombo = new JComboBox();
		palntcombo.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		palntcombo.setModel(new DefaultComboBoxModel(new String[] { "식물", "과일", "채소" }));
		palntcombo.setBounds(205, 74, 64, 37);
		panel.add(palntcombo);

		tfprice = new JTextField();
		tfprice.setColumns(10);
		tfprice.setBounds(738, 74, 121, 35);
		panel.add(tfprice);

		JButton btnNewButton = new JButton("글 올리기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int membercode = pk;
				String plant = (String) palntcombo.getSelectedItem();
				int plantcode = 0;

				if (comboBox.getSelectedIndex() == 0) {
					String bmname = tftitle.getText();
					String bmprice = tfprice.getText();
					String bmcontent = areacontent.getText();
					vo = new MarketVO();
					vo.setBmname(bmname);
					vo.setBmprice(bmprice);
					vo.setBmcontent(bmcontent);
					vo.setMembercode(membercode);

					if (plant == "식물") {
						plantcode = 2;
						vo.setPlantcode(plantcode);

					} else if (plant == "과일") {
						plantcode = 3;
						vo.setPlantcode(plantcode);
					} else {
						plantcode = 4;
						vo.setPlantcode(plantcode);
					}
					try {
						dao.bmregist(vo);
						JOptionPane.showMessageDialog(null, "글이 등록 되었습니다.");
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showConfirmDialog(null, "글올리기 실패" + e2.getMessage());
					}
				} else {
					String smname = tftitle.getText();
					String smprice = tfprice.getText();
					String smcontent = areacontent.getText();
					vo = new MarketVO();
					vo.setSmname(smname);
					vo.setSmprice(smprice);
					vo.setSmcontent(smcontent);
					vo.setMembercode(membercode);
					if (plant == "식물") {
						plantcode = 2;
						vo.setPlantcode(plantcode);
					} else if (plant == "과일") {
						plantcode = 3;
						vo.setPlantcode(plantcode);
					} else {
						plantcode = 4;
						vo.setPlantcode(plantcode);
					}
					try {

						dao.smregist(vo);
						JOptionPane.showMessageDialog(null, "글이 등록 되었습니다.");
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showConfirmDialog(null, "글올리기 실패" + e2.getMessage());
					}
				}

				dispose();
				MarketView marketview = new MarketView(pk, nick, point);
				marketview.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnNewButton.setBounds(739, 424, 121, 31);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("돌아가기");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MarketView markertview = new MarketView(pk, nick, point);
				markertview.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnNewButton_1.setBounds(612, 424, 121, 31);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("금액 : ");
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(680, 73, 64, 37);
		panel.add(lblNewLabel_1);

	}

}
