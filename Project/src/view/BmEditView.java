package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
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

public class BmEditView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static int pk;
	static String nick;
	static int point;
	private JTextField textField_1;
	MarketVO vo;
	MarketDAO dao;

	/**
	 * Create the frame.
	 * 
	 * @param vo
	 */
	public BmEditView(MarketVO vo, int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		this.vo = vo;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("돌아가기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnNewButton.setBounds(619, 422, 113, 43);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("제목 : ");
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(74, 46, 51, 30);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(119, 46, 365, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(vo.getBmname());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(74, 99, 658, 286);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		scrollPane.setViewportView(textArea);
		textArea.setText(vo.getBmcontent());

		JButton btnNewButton_1 = new JButton("수정 완료");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					vo.setMembercode(pk);
					vo.setBmarketcode(vo.getBmarketcode());
					vo.setBmname(textField.getText());
					vo.setBmprice(textField_1.getText());
					vo.setBmcontent(textArea.getText());

					dao = new MarketDAO();
					dao.bmupdate(vo);
					JOptionPane.showMessageDialog(null, "수정이 완료 되었습니다.");
					dispose();

				} catch (Exception e2) {
					// TODO: handle exception.
					JOptionPane.showConfirmDialog(null, "글이 수정 되지 않았습니다." + e2.getMessage());
				}

			}
		});
		btnNewButton_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnNewButton_1.setBounds(479, 422, 113, 43);
		contentPane.add(btnNewButton_1);

		JLabel pricelabel = new JLabel("금액 : ");
		pricelabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		pricelabel.setBounds(517, 46, 59, 30);
		contentPane.add(pricelabel);

		textField_1 = new JTextField();
		textField_1.setBounds(568, 48, 164, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(vo.getBmprice());
	}
}
