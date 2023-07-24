package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.CustomerDAO;
import model.rec.CustomerVO;

public class LoginView extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JPasswordField passwordField;

	CustomerDAO dao;
	CustomerVO vo;
	int point;
	String nick;
	ArrayList list;
	static int pk;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() {
		this.nick = nick;
		this.point = point;

		try {
			dao = new CustomerDAO(); // CustomerDAO ��ü �ʱ�ȭ
		} catch (Exception e) {
			e.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(LoginView.class.getResource("")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel.setBounds(456, 376, 47, 50);
		contentPane.add(lblNewLabel);

		JLabel lblPw = new JLabel("PW :");
		lblPw.setFont(new Font("�������", Font.PLAIN, 20));
		lblPw.setBounds(456, 436, 47, 50);
		contentPane.add(lblPw);

		JButton btnNewButton = new JButton("�α���");

		btnNewButton.setFont(new Font("�������", Font.PLAIN, 20));
		btnNewButton.setBounds(371, 541, 230, 137);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ȸ������");
		btnNewButton_1.setFont(new Font("�������", Font.PLAIN, 20));
		btnNewButton_1.setBounds(743, 541, 230, 137);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(515, 385, 366, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(""));
		lblNewLabel_1.setBounds(624, 84, 109, 157);
		contentPane.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(515, 449, 366, 32);
		contentPane.add(passwordField);

		// �α��� ��ư �׼�
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String pw = passwordField.getText();

				try {
//					int MEMBERCODE = dao.login(id, pw); // �����ϴ� �������� Ȯ���Ͽ� ���� �⺻Ű(�ڵ�)�� ������
//					vo = new CustomerVO();
//					vo = dao.login(id, pw);
					list = dao.login(id, pw);
					int MEMBERCODE = Integer.parseInt(String.valueOf(list.get(0)));
					nick = String.valueOf(list.get(3));
					int point = Integer.parseInt(String.valueOf(list.get(4)));
//					System.out.println(MEMBERCODE+ " "+ nick+ " "+ point);

					if (MEMBERCODE == 0) { // �ƹ� ���� �������� ������ ���
						JOptionPane.showMessageDialog(null, "[!] ID, PW�� Ȯ�����ּ���!");

					} else {
						JOptionPane.showMessageDialog(null, "[!] " + id + "�� ȯ���մϴ�!");
						dispose();

						MainHomeView plantview = new MainHomeView(MEMBERCODE, nick, point);
						plantview.setVisible(true);

						// frame.setVisible(false); // ���� â ����
						// new MainView(acct_code); // Main â ����
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "[!] �α��� ���� : " + ex.getMessage());
				}

			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpView frame = new SignUpView();
			}
		});

		// frame.setVisible(true);

		// �α��� ��ư Ŭ�� �̺�Ʈ ó��
//        btnNewButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String username = textField.getText();
//                String password = new String(passwordField.getPassword());
		// �α��� ó�� ���� ����

		// ����: �α����� �����ϸ� ���� ȭ������ �̵�
//                dispose(); // ���� ȭ�� �ݱ�
//                NextView nextView = new NextView(); // ���� ȭ�� ��ü ����
//                nextView.setVisible(true); // ���� ȭ�� ���̱�
//            }
//        });

		// ȸ������ ��ư Ŭ�� �̺�Ʈ ó��
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // ���� ȭ�� �ݱ�
				SignUpView registerView = new SignUpView(); // ȸ������ ȭ�� ��ü ����
				registerView.setVisible(true); // ȸ������ ȭ�� ���̱�
			}
		});

	}
}
