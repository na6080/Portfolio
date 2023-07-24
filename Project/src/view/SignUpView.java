package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.AttributeSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import model.SignUpDAO;
import model.rec.SignUpVO;

public class SignUpView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField juminbunho;
	private JButton idgood;
	private JButton nickgood;
	private SignUpDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView frame = new SignUpView();
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

	public SignUpView() {

		// DB����
		try {
			dao = new SignUpDAO();
			System.out.println("[!] DB ���� ����!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "[!] DB ���� ���� : " + e.getMessage());
			System.out.println(e.getMessage());
		}

		initialize();
	}

	public void initialize() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\koreait\\Desktop\\Downloads\\222222222222222.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel.setBounds(453, 128, 41, 65);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PW :");
		lblNewLabel_1.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(453, 188, 57, 53);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uB2C9\uB124\uC784 :");
		lblNewLabel_2.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(453, 296, 78, 65);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("�̸� :");
		lblNewLabel_2_1.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(453, 353, 57, 65);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("\uC8FC\uBBFC\uBC88\uD638 :");
		lblNewLabel_2_1_1.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(453, 411, 100, 65);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("�ּ� :");
		lblNewLabel_2_1_1_1.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1.setBounds(453, 483, 57, 65);
		contentPane.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("��ȭ��ȣ :");
		lblNewLabel_2_1_1_1_1.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1_1.setBounds(453, 546, 100, 65);
		contentPane.add(lblNewLabel_2_1_1_1_1);

		textField = new JTextField();
		textField.setDocument(new JTextFieldLimit(14));
		textField.setBounds(560, 137, 288, 47);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setDocument(new JTextFieldLimit(12));
		textField_2.setColumns(10);
		textField_2.setBounds(560, 308, 288, 47);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(560, 365, 288, 47);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setDocument(new JTextFieldLimit(9));
		textField_4.setBounds(622, 558, 226, 47);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setDocument(new JTextFieldLimit(6));
		textField_5.setColumns(10);
		textField_5.setBounds(560, 427, 124, 47);
		contentPane.add(textField_5);

		passwordField = new JPasswordField();
		passwordField.setDocument(new JTextFieldLimit(15));
		passwordField.setBounds(560, 194, 288, 47);
		contentPane.add(passwordField);

		JButton btnga = new JButton("ȸ�� ����");
		btnga.setFont(new Font("�������", Font.PLAIN, 20));
		btnga.setBounds(601, 639, 131, 65);
		contentPane.add(btnga);
		btnga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String password = new String(passwordField.getPassword());
				String nickname = textField_2.getText();
				String name = textField_3.getText();
				String jumin = textField_5.getText() + "-" + juminbunho.getText();
				String tel = textField_4.getText();
				String addr = textField_7.getText();

				// ȸ�� ���� ���� ȣ��
				registerCustomer(id, password, nickname, name, jumin, tel, addr);

				// ȸ�� ���� �� �ʵ� �ʱ�ȭ
				textField.setText("");
				passwordField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_4.setText("");
//                textField_6.setText("");
			}

			private void registerCustomer(String id, String password, String nickname, String name, String jumin,
					String tel, String addr) {
				// TODO Auto-generated method stub

			}
		});

		// ...

		JLabel lblNewLabel_3 = new JLabel("PW Ȯ�� :");
		lblNewLabel_3.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(453, 239, 100, 65);
		contentPane.add(lblNewLabel_3);

		passwordField_1 = new JPasswordField();
		passwordField_1.setDocument(new JTextFieldLimit(15));
		passwordField_1.setBounds(560, 251, 288, 47);
		contentPane.add(passwordField_1);

		textField_7 = new JTextField();
		textField_7.setBounds(560, 495, 288, 47);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(""));
		lblNewLabel_4.setBounds(601, 10, 108, 118);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("-");
		lblNewLabel_5.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(696, 440, 57, 15);
		contentPane.add(lblNewLabel_5);

		juminbunho = new JPasswordField();
		juminbunho.setDocument((new JTextFieldLimit(7)));
		juminbunho.setBounds(717, 427, 132, 47);
		contentPane.add(juminbunho);

		JLabel lblNewLabel_6 = new JLabel("010 -");
		lblNewLabel_6.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(565, 574, 57, 15);
		contentPane.add(lblNewLabel_6);

		JButton idgood = new JButton("\uC911\uBCF5\uD655\uC778");
		idgood.setFont(new Font("�������", Font.PLAIN, 18));
		idgood.setBounds(867, 146, 124, 31);
		contentPane.add(idgood);

		JButton nickgood = new JButton("\uC911\uBCF5\uD655\uC778");
		nickgood.setFont(new Font("�������", Font.PLAIN, 18));
		nickgood.setBounds(867, 314, 124, 31);
		contentPane.add(nickgood);

		// ���̵� �ߺ�Ȯ�� ��ư �̺�Ʈ �߻�
		idgood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();

				try {
					String memId = dao.checkId(id);
					if (textField.getText().length() < 4) {
						JOptionPane.showMessageDialog(null, "[!] �ּ� 4�� �̻���̵� �Է����ּ���!");
					} else {
						if (memId == null) {
							JOptionPane.showMessageDialog(null, "[!] ��� ������ ���̵��Դϴ�.");
						} else {
							JOptionPane.showMessageDialog(null, "[!] �̹� ���� ���̵��Դϴ�.");
							textField.setText("");
						}
					}
				} catch (Exception e1) {
				}
				// dispose();
			}
		});

		// �г��� �ߺ�Ȯ�� ��ư �̺�Ʈ �߻�
		nickgood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nick = textField_2.getText();

				try {
					String memnick = dao.checkNick(nick);
					if (textField_2.getText().length() < 2) {
						JOptionPane.showMessageDialog(null, "[!] �ּ� 2���̻� �Է����ּ���!");
					} else {
						if (memnick == null) {
							JOptionPane.showMessageDialog(null, "[!] ��� ������ �г����Դϴ�.");
						} else {
							JOptionPane.showMessageDialog(null, "[!] �̹� ���� �г����Դϴ�.");
							textField_2.setText("");
						}
					}
				} catch (Exception e1) {
				}
				// dispose();
			}
		});

		// ��й�ȣ Ȯ�� ��ư �̺�Ʈ �߻�
		nickgood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = passwordField_1.getText();

				try {
					String memnick = dao.checkPass(pass);
					if (passwordField_1.getText().equals(passwordField)) {
						JOptionPane.showMessageDialog(null, "[!] ��й�ȣ�� ��ġ�մϴ�");
					} else {
						if (pass == null) {
							JOptionPane.showMessageDialog(null, "[!] ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						} else {
							JOptionPane.showMessageDialog(null, "[!] ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
							passwordField_1.setText("");
						}
					}
				} catch (Exception e1) {
				}
				// dispose();
			}
		});

		// ȸ������ ��ư�� ������ �� �̺�Ʈ �߻� + �ߺ��� ���� �Ұ��� ���
		btnga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpVO vo = new SignUpVO();

				String id = textField.getText();
				String pw = passwordField.getText();
				String nickname = textField_2.getText();
				String name = textField_3.getText();
				String idnum = textField_5.getText() + "-" + juminbunho.getText();
				String tel = "010-" + textField_4.getText();
				String addr = textField_7.getText();

				vo.setId(id);
				vo.setPw(pw);
				vo.setNick(nickname);
				vo.setName(name);
				vo.setJumin(idnum);
				vo.setTel(tel);
				vo.setAddr(addr);

				while (true) {

					if (textField.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���!");
						break;
					} else if (passwordField.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���!");
						break;
					} else if (textField_2.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "�г����� �Է����ּ���!");
						break;
					} else if (textField_3.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���!");
						break;
					} else if (textField_5.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "�ֹι�ȣ�� �Է����ּ���!");
						break;
					} else if (juminbunho.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "�ֹι�ȣ�� �Է����ּ���!");
						break;
					} else if (textField_4.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "�ּҸ� �Է����ּ���!");
						break;
					} else if (textField_7.getText().length() > 7) {
						JOptionPane.showMessageDialog(null, "����ó�� �Է����ּ���!");
						break;
					}
					try {
						String memnick = dao.checkNick(nickname);
						String memId = dao.checkId(id);
						if (memId != null) {
							JOptionPane.showMessageDialog(null, "�̹� ���� ���̵� �Դϴ�!");
							break;
						}
						if (memnick == null) {
							dao.join(vo);
							JOptionPane.showMessageDialog(null, "[!] ȸ������ ����!");
							clearScreen();
							
							break;
						} else {
							JOptionPane.showMessageDialog(null, "�̹� ������ �г��� �Դϴ�!");
							break;
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "ȸ�� ���� ����!", "[!] ERROR ", JOptionPane.ERROR_MESSAGE);
						System.out.println(e1.getMessage());
					}

					// dispose();
					break;

				}
			}

		});

		// ȸ�������� �����ϸ� �α��� â���� �̵�
		btnga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // ���� ȭ�� �ݱ�
				LoginView LoginView = new LoginView(); // ȸ������ ȭ�� ��ü ����
				LoginView.setVisible(true); // �α���â ȭ�� ���̱�

			}
		});

	}

	// Ŭ���� ��ũ�� �޼ҵ�
	public void clearScreen() {
		textField.setText("");
		passwordField.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_5.setText("");
		juminbunho.setText("");
		textField_4.setText("");
		textField_7.setText("");
	}

	class JTextFieldLimit extends PlainDocument {
		private int limit;
		private boolean toUppercase = false;

		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		JTextFieldLimit(int limit, boolean upper) {
			super();
			this.limit = limit;
			this.toUppercase = upper;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null) {
				return;
			}

			if ((getLength() + str.length()) <= limit) {
				if (toUppercase) {
					str = str.toUpperCase();
				}
				super.insertString(offset, str, (javax.swing.text.AttributeSet) attr);
			}
		}
	}
}
