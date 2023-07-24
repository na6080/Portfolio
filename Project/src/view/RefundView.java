package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.CardDAO;
import model.DeliveryDAO;
import model.RefundDAO;
import model.rec.CardVO;
import model.rec.DeliveryVO;
import model.rec.RefundVO;

public class RefundView extends JFrame {

	JPanel refund;
	JTextField buyNo;
	DeliveryVO dvo;
	DeliveryDAO ddao;
	MyPageView mview;
	CardDAO cdao;
	CardVO cvo;
	RefundDAO rdao;
	RefundVO rvo;
	static String refundItem;
	JTable refundtable;
	String rfreason;
	static int pk;
	static String nick;
	static int point;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPageView mview = new MyPageView(pk, nick, point);
					RefundView frame = new RefundView(refundItem, pk, nick, point);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RefundView(String refundItem, int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		this.refundItem = refundItem;
		addLayout();
		buyNo.setText(refundItem);

		try {
			System.out.println("DB ���� ����!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DB ���� ���� : " + e.getMessage());
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 144, 261, 74);
		refund.add(scrollPane);

		refundtable = new JTable();
		refundtable.setFont(new Font("�������", Font.PLAIN, 14));
		refundtable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "��ǰ��", "��ǰ����" }));
		refundtable.getColumnModel().getColumn(0).setMinWidth(75);
		refundtable.getColumnModel().getColumn(1).setMinWidth(75);
		scrollPane.setViewportView(refundtable);
		try {
			try {
				rdao = new RefundDAO();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// DeliveryDAO�� deliveryDetail() �޼��� ȣ���Ͽ� ������ ��������
			ArrayList<ArrayList<String>> list = rdao.refundItem(refundItem);

			// ������ �����͸� JTable�� �߰��ϱ�
			DefaultTableModel tableModel = (DefaultTableModel) refundtable.getModel();
			for (ArrayList<String> row : list) {
				Object[] rowData = row.toArray();
				tableModel.addRow(rowData);
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

	}

	// layout
	public void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		refund = new JPanel();
		refund.setBackground(new Color(220, 240, 217));
		refund.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(refund);
		refund.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(RefundView.class.getResource("")));
		logo.setBounds(200, 25, 55, 55);
		refund.add(logo);

		JLabel refundreason_1 = new JLabel("���ž����۹�ȣ");
		refundreason_1.setFont(new Font("�������", Font.PLAIN, 15));
		refundreason_1.setBackground(new Color(89, 159, 121));
		refundreason_1.setBounds(83, 112, 98, 15);
		refund.add(refundreason_1);

		// ���Ź�ȣ ������ �ؽ�Ʈ�ʵ�
		buyNo = new JTextField();
		buyNo.setHorizontalAlignment(SwingConstants.CENTER);
		buyNo.setFont(new Font("�������", Font.PLAIN, 15));
		buyNo.setEditable(false);
		buyNo.setBounds(193, 106, 151, 27);
		refund.add(buyNo);
		buyNo.setColumns(10);
		buyNo.setText(refundItem);

		JLabel refundreason = new JLabel("ȯ�� ����");
		refundreason.setFont(new Font("�������", Font.PLAIN, 15));
		refundreason.setBackground(new Color(89, 159, 121));
		refundreason.setBounds(119, 234, 66, 15);
		refund.add(refundreason);

		JComboBox refundcomboBox = new JComboBox();
		refundcomboBox.setModel(new DefaultComboBoxModel(new String[] { "����", "�ܼ�����", "��ǰ �߰� �� �籸��", "��Ÿ" }));
		refundcomboBox.setFont(new Font("�������", Font.PLAIN, 15));
		refundcomboBox.setBounds(193, 228, 151, 27);
		refund.add(refundcomboBox);

		// ȯ�� Ȯ�� ��ư Ŭ�� �̺�Ʈ
		JButton btnNewButton = new JButton("Ȯ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("�������", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(169, 219, 162));
		btnNewButton.setBounds(131, 296, 81, 23);
		refund.add(btnNewButton);

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
		refund.add(canclebtnNewButton);

		// ȯ�� �̺�Ʈ
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				Object o = ev.getSource();
				if (o == btnNewButton) {
					String buycode = buyNo.getText();
					String rfreason = (String) refundcomboBox.getSelectedItem();
					// ȯ�� �� null���� �߻��ϸ� �޼��� �˾�
					if (rfreason.equals("����")) {
						JOptionPane.showMessageDialog(null, "ȯ�һ����� �������ּ���!");
					} else {
						// ���õ� �׸� ���� rfreason ���� ����
						if (rfreason.equals("�ܼ�����")) {
							rfreason = "2";
						} else if (rfreason.equals("��ǰ �߰� �� �籸��")) {
							rfreason = "3";
						} else if (rfreason.equals("��Ÿ")) {
							rfreason = "4";
						}

						// ��� ������ ������ ��쿡�� ȯ���� ����
						try {
							rvo = new RefundVO();
							rvo.setBuycode(buycode);
							rvo.setRfreasoncode(rfreason);

							rdao.refundAdd(rvo);
							rdao.refundDelete(rvo);
							JOptionPane.showMessageDialog(null, "ȯ�� �Ϸ�!");
							dispose();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "ȯ�� ����");
						}
					}
				}
			}
		});

	}
}
