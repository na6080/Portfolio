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

	// ����
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

	// DB ����
	public CardAddView(int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		addLayout();

		try {
			cdao = new CardDAO();
			cvo = new CardVO();
			System.out.println("DB ���� ����!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DB ���� ���� : " + e.getMessage());
		}

	}

	// layout
	public void addLayout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setFont(new Font("�����ٸ����", Font.PLAIN, 12));
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

		JLabel cname = new JLabel("ī���");
		cname.setBounds(111, 116, 42, 15);
		cname.setBackground(new Color(89, 159, 121));
		cname.setFont(new Font("�������", Font.PLAIN, 15));
		card.add(cname);

		JComboBox cnameBox = new JComboBox();
		cnameBox.setModel(new DefaultComboBoxModel(
				new String[] { "����", "�Ե�ī��", "�Ｚī��", "�츮ī��", "����ī��", "����ī��", "�츮ī��", "����ī��" }));
		cnameBox.setFont(new Font("�������", Font.PLAIN, 15));
		cnameBox.setBounds(165, 112, 169, 23);
		card.add(cnameBox);

		JLabel cno = new JLabel("ī�� ��ȣ");
		cno.setFont(new Font("�������", Font.PLAIN, 15));
		cno.setBackground(new Color(89, 159, 121));
		cno.setBounds(91, 154, 62, 15);
		card.add(cno);

		cnoTextField = new JTextField();
		cnoTextField.setFont(new Font("�������", Font.PLAIN, 15));
		cnoTextField.setToolTipText("");
		cnoTextField.setColumns(10);
		cnoTextField.setBounds(165, 149, 169, 25);
		card.add(cnoTextField);

		JLabel cdate = new JLabel("������ (MM/YY)");
		cdate.setFont(new Font("�������", Font.PLAIN, 15));
		cdate.setBackground(new Color(89, 159, 121));
		cdate.setBounds(41, 188, 112, 15);
		card.add(cdate);

		JComboBox cdateBox1 = new JComboBox();
		cdateBox1.setFont(new Font("�������", Font.PLAIN, 15));
		cdateBox1.setModel(new DefaultComboBoxModel(
				new String[] { "����", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		cdateBox1.setBounds(165, 184, 74, 23);
		card.add(cdateBox1);

		JLabel slash = new JLabel("/");
		slash.setFont(new Font("�������", Font.PLAIN, 18));
		slash.setBackground(new Color(89, 159, 121));
		slash.setBounds(246, 188, 22, 15);
		card.add(slash);

		JComboBox cdateBox2 = new JComboBox();
		cdateBox2.setModel(new DefaultComboBoxModel(new String[] { "����", "23", "24", "25", "26", "27", "28" }));
		cdateBox2.setFont(new Font("�������", Font.PLAIN, 15));
		cdateBox2.setBounds(260, 184, 74, 23);
		card.add(cdateBox2);

		JLabel cvc = new JLabel("CVC");
		cvc.setFont(new Font("�������", Font.PLAIN, 15));
		cvc.setBackground(new Color(89, 159, 121));
		cvc.setBounds(123, 225, 30, 15);
		card.add(cvc);

		cvcpasswordField = new JPasswordField();
		cvcpasswordField.setFont(new Font("�������", Font.PLAIN, 15));
		cvcpasswordField.setBounds(165, 220, 74, 25);
		card.add(cvcpasswordField);

		// ī�� �߰� ��ư Ŭ�� �̺�Ʈ
		JButton addbtnNewButton = new JButton("Ȯ��");
		addbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardAddView cardaddview = new CardAddView(pk, nick, point);
				cardaddview.setVisible(false);
			}
		});
		addbtnNewButton.setBackground(new Color(169, 219, 162));
		addbtnNewButton.setFont(new Font("�������", Font.PLAIN, 15));
		addbtnNewButton.setBounds(131, 296, 81, 23);
		card.add(addbtnNewButton);

		// ��� ��ư Ŭ�� �̺�Ʈ
		JButton canclebtnNewButton = new JButton("���");
		canclebtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CardAddView cardaddview = new CardAddView(pk, nick, point);
				cardaddview.setVisible(false);
			}
		});
		canclebtnNewButton.setFont(new Font("�������", Font.PLAIN, 15));
		canclebtnNewButton.setBackground(new Color(169, 219, 162));
		canclebtnNewButton.setBounds(233, 296, 81, 23);
		card.add(canclebtnNewButton);

		// ī�� �߰� �̺�Ʈ
		addbtnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				if (o == addbtnNewButton) {
					String cname = (String) cnameBox.getSelectedItem();
					String cno = cnoTextField.getText();
					String cdate = (String) cdateBox1.getSelectedItem() + "/" + (String) cdateBox2.getSelectedItem();
					String cvc = cvcpasswordField.getText();
					// ī�� �߰� �� null���� �߻��ϸ� �޼��� �˾�
					if (cname.equals("����")) {
						JOptionPane.showMessageDialog(null, "ī��縦 �������ּ���!");
					} else if (cno.length() == 0) {
						JOptionPane.showMessageDialog(null, "ī���ȣ�� �Է����ּ���!");
					} else if (cdate.equals("����")) {
						JOptionPane.showMessageDialog(null, "�������� �������ּ���!");
					} else if (cvc.length() == 0) {
						JOptionPane.showMessageDialog(null, "CVC�� �Է����ּ���!");
					} else {
						// ��� ������ ������ ��쿡�� ī�� �߰��� ����
						try {
							cvo.setCname(cname);
							cvo.setCno(cno);
							cvo.setCdate(cdate);
							cvo.setCvc(cvc);

							cdao.cardAdd(cvo);
							JOptionPane.showMessageDialog(null, "ī�� �߰� �Ϸ�!");
							dispose();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "ī�� �߰� ����");
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
