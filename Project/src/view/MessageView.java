package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MessageView extends JFrame {

	JPanel contentPane;
	static int pk;
	static String nick;
	static int point;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageView frame = new MessageView(pk, nick, point);
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
	public MessageView(int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("메세지 전송");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "메세지 전송 성공");
					MarketView marketview = new MarketView(pk, nick, point);
					marketview.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "메세지 전송 실패 :" + e2.getMessage());
				}

			}
		});
		btnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btnNewButton.setBounds(343, 209, 129, 44);
		contentPane.add(btnNewButton);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(54, 49, 418, 132);
		contentPane.add(textArea);
	}
}
