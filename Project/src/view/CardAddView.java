package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.CardDAO;
import model.rec.CardVO;

public class CardAddView extends JFrame implements ActionListener {

	JPanel card;
	JTextField cnoTextField;
	JPasswordField cvcpasswordField;
	JComboBox cnameBox, cdateBox1, cdateBox2;
	JButton addbtnNewButton, canclebtnNewButton;
	CardDAO cdao;
	CardVO cvo;
	static int pk;
	static String nick;
	static int point;

	// 메인
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardAddView frame = new CardAddView(pk, nick, point);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// DB 연결
	public CardAddView(int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		addLayout();

		try {
			cdao = new CardDAO();
			cvo = new CardVO();
			System.out.println("DB 연결 성공!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DB 연결 실패 : " + e.getMessage());
		}

	}

	// layout
	public void addLayout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		setBackground(new Color(89, 159, 121));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		card = new JPanel();
		card.setForeground(UIManager.getColor("Button.darkShadow"));
		card.setBackground(new Color(226, 243, 224));
		card.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(card);
		card.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(CardAddView.class.getResource("")));
		logo.setBounds(192, 43, 50, 36);
		card.add(logo);

		JLabel cname = new JLabel("카드사");
		cname.setBounds(111, 116, 42, 15);
		cname.setBackground(new Color(89, 159, 121));
		cname.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		card.add(cname);

		JComboBox cnameBox = new JComboBox();
		cnameBox.setModel(new DefaultComboBoxModel(
				new String[] { "선택", "롯데카드", "삼성카드", "우리카드", "국민카드", "농협카드", "우리카드", "신한카드" }));
		cnameBox.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		cnameBox.setBounds(165, 112, 169, 23);
		card.add(cnameBox);

		JLabel cno = new JLabel("카드 번호");
		cno.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		cno.setBackground(new Color(89, 159, 121));
		cno.setBounds(91, 154, 62, 15);
		card.add(cno);

		cnoTextField = new JTextField();
		cnoTextField.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		cnoTextField.setToolTipText("");
		cnoTextField.setColumns(10);
		cnoTextField.setBounds(165, 149, 169, 25);
		card.add(cnoTextField);

		JLabel cdate = new JLabel("만료일 (MM/YY)");
		cdate.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		cdate.setBackground(new Color(89, 159, 121));
		cdate.setBounds(41, 188, 112, 15);
		card.add(cdate);

		JComboBox cdateBox1 = new JComboBox();
		cdateBox1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		cdateBox1.setModel(new DefaultComboBoxModel(
				new String[] { "선택", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		cdateBox1.setBounds(165, 184, 74, 23);
		card.add(cdateBox1);

		JLabel slash = new JLabel("/");
		slash.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		slash.setBackground(new Color(89, 159, 121));
		slash.setBounds(246, 188, 22, 15);
		card.add(slash);

		JComboBox cdateBox2 = new JComboBox();
		cdateBox2.setModel(new DefaultComboBoxModel(new String[] { "선택", "23", "24", "25", "26", "27", "28" }));
		cdateBox2.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		cdateBox2.setBounds(260, 184, 74, 23);
		card.add(cdateBox2);

		JLabel cvc = new JLabel("CVC");
		cvc.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		cvc.setBackground(new Color(89, 159, 121));
		cvc.setBounds(123, 225, 30, 15);
		card.add(cvc);

		cvcpasswordField = new JPasswordField();
		cvcpasswordField.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		cvcpasswordField.setBounds(165, 220, 74, 25);
		card.add(cvcpasswordField);

		// 카드 추가 버튼 클릭 이벤트
		JButton addbtnNewButton = new JButton("확인");
		addbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardAddView cardaddview = new CardAddView(pk, nick, point);
				cardaddview.setVisible(false);
			}
		});
		addbtnNewButton.setBackground(new Color(169, 219, 162));
		addbtnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		addbtnNewButton.setBounds(131, 296, 81, 23);
		card.add(addbtnNewButton);

		// 취소 버튼 클릭 이벤트
		JButton canclebtnNewButton = new JButton("취소");
		canclebtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CardAddView cardaddview = new CardAddView(pk, nick, point);
				cardaddview.setVisible(false);
			}
		});
		canclebtnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		canclebtnNewButton.setBackground(new Color(169, 219, 162));
		canclebtnNewButton.setBounds(233, 296, 81, 23);
		card.add(canclebtnNewButton);

		// 카드 추가 이벤트
		addbtnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				if (o == addbtnNewButton) {
					String cname = (String) cnameBox.getSelectedItem();
					String cno = cnoTextField.getText();
					String cdate = (String) cdateBox1.getSelectedItem() + "/" + (String) cdateBox2.getSelectedItem();
					String cvc = cvcpasswordField.getText();
					// 카드 추가 시 null값이 발생하면 메세지 팝업
					if (cname.equals("선택")) {
						JOptionPane.showMessageDialog(null, "카드사를 선택해주세요!");
					} else if (cno.length() == 0) {
						JOptionPane.showMessageDialog(null, "카드번호를 입력해주세요!");
					} else if (cdate.equals("선택")) {
						JOptionPane.showMessageDialog(null, "만료일을 선택해주세요!");
					} else if (cvc.length() == 0) {
						JOptionPane.showMessageDialog(null, "CVC를 입력해주세요!");
					} else {
						// 모든 조건을 충족한 경우에만 카드 추가를 진행
						try {
							cvo.setCname(cname);
							cvo.setCno(cno);
							cvo.setCdate(cdate);
							cvo.setCvc(cvc);

							cdao.cardAdd(cvo);
							JOptionPane.showMessageDialog(null, "카드 추가 완료!");
							dispose();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "카드 추가 실패");
						}
					}
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
