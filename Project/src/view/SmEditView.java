package view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
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

public class SmEditView extends JFrame {

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
	public SmEditView(MarketVO vo, int pk, String nick, int point) {
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

		JButton btnNewButton = new JButton("µ¹¾Æ°¡±â");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 18));
		btnNewButton.setBounds(619, 422, 113, 43);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Á¦¸ñ : ");
		lblNewLabel.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		lblNewLabel.setBounds(74, 46, 51, 30);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(119, 46, 365, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(vo.getSmname());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(335, 99, 397, 286);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		scrollPane.setViewportView(textArea);
		textArea.setText(vo.getSmcontent());

		JButton btnNewButton_1 = new JButton("¼öÁ¤ ¿Ï·á");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					vo.setMembercode(pk);
					vo.setSmarketcode(vo.getSmarketcode());
					vo.setSmname(textField.getText());
					vo.setSmprice(textField_1.getText());
					vo.setSmcontent(textArea.getText());

					dao = new MarketDAO();
					dao.smupdate(vo);
					JOptionPane.showMessageDialog(null, "¼öÁ¤ÀÌ ¿Ï·á µÇ¾ú½À´Ï´Ù.");
					dispose();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 18));
		btnNewButton_1.setBounds(479, 422, 113, 43);
		contentPane.add(btnNewButton_1);

		JLabel pricelabel = new JLabel("±Ý¾× : ");
		pricelabel.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		pricelabel.setBounds(517, 46, 59, 30);
		contentPane.add(pricelabel);

		textField_1 = new JTextField();
		textField_1.setBounds(568, 48, 164, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(vo.getSmprice());

		JLabel smiamge = new JLabel("ÀÌ¹ÌÁö ÀÚ¸®");
		smiamge.setBounds(66, 99, 250, 286);
		contentPane.add(smiamge);
		String imagePath = vo.getSmimage();
		ImageIcon imageIcon = new ImageIcon(imagePath);
		smiamge.setIcon(imageIcon);

	}

}
