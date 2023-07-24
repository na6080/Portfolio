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
			dao = new CustomerDAO(); // CustomerDAO 객체 초기화
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
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(456, 376, 47, 50);
		contentPane.add(lblNewLabel);

		JLabel lblPw = new JLabel("PW :");
		lblPw.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblPw.setBounds(456, 436, 47, 50);
		contentPane.add(lblPw);

		JButton btnNewButton = new JButton("로그인");

		btnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnNewButton.setBounds(371, 541, 230, 137);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setFont(new Font("나눔고딕", Font.PLAIN, 20));
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

		// 로그인 버튼 액션
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String pw = passwordField.getText();

				try {
//					int MEMBERCODE = dao.login(id, pw); // 존재하는 계정인지 확인하여 계정 기본키(코드)를 가져옴
//					vo = new CustomerVO();
//					vo = dao.login(id, pw);
					list = dao.login(id, pw);
					int MEMBERCODE = Integer.parseInt(String.valueOf(list.get(0)));
					nick = String.valueOf(list.get(3));
					int point = Integer.parseInt(String.valueOf(list.get(4)));
//					System.out.println(MEMBERCODE+ " "+ nick+ " "+ point);

					if (MEMBERCODE == 0) { // 아무 값도 가져오지 못했을 경우
						JOptionPane.showMessageDialog(null, "[!] ID, PW를 확인해주세요!");

					} else {
						JOptionPane.showMessageDialog(null, "[!] " + id + "님 환영합니다!");
						dispose();

						MainHomeView plantview = new MainHomeView(MEMBERCODE, nick, point);
						plantview.setVisible(true);

						// frame.setVisible(false); // 현재 창 종료
						// new MainView(acct_code); // Main 창 열기
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "[!] 로그인 실패 : " + ex.getMessage());
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

		// 로그인 버튼 클릭 이벤트 처리
//        btnNewButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String username = textField.getText();
//                String password = new String(passwordField.getPassword());
		// 로그인 처리 로직 구현

		// 예시: 로그인이 성공하면 다음 화면으로 이동
//                dispose(); // 현재 화면 닫기
//                NextView nextView = new NextView(); // 다음 화면 객체 생성
//                nextView.setVisible(true); // 다음 화면 보이기
//            }
//        });

		// 회원가입 버튼 클릭 이벤트 처리
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 현재 화면 닫기
				SignUpView registerView = new SignUpView(); // 회원가입 화면 객체 생성
				registerView.setVisible(true); // 회원가입 화면 보이기
			}
		});

	}
}
