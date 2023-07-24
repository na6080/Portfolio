package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.SellDAO;
import model.rec.SellVO;

public class GoodsView extends JFrame {

	JPanel contentPane;
	ReviewTableModel tmReview;
	JTable reviewtable;
	JTextField tfGname, tfGprice, tfGcontent, tfCcount;
	JButton bReviewgo, bBack, bCartin;
	JLabel lbGimage;

	SellDAO dao;
	SellVO vo;
	ArrayList list = null;
	static int pk;
	static String nick;
	static int point;

	public GoodsView(SellVO vo, int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		this.vo = vo;

		try {
			System.out.println("��ǰ�� ��� ���� ����");
			dao = new SellDAO();
			reviewtable = new JTable();
			reviewTable();

			// list �ʱ�ȭ
			list = dao.reviewAll();

//            //tmReview �ʱ�ȭ
			tmReview = new ReviewTableModel(list);
			reviewtable.setModel(tmReview);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "��ǰ�� ��� ���� ���� : " + e.getMessage());
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ��ǰ��
		JLabel Label_1 = new JLabel("��ǰ�� : ");
		Label_1.setFont(new Font("�������", Font.PLAIN, 18));
		Label_1.setBounds(64, 70, 95, 32);
		contentPane.add(Label_1);

		tfGname = new JTextField();
		tfGname.setEditable(false);
		tfGname.setBounds(138, 68, 207, 41);
		contentPane.add(tfGname);
		tfGname.setColumns(10);
		tfGname.setText(vo.getGname()); // gname��������

		// �̹���
		JLabel lbGimage = new JLabel();
		lbGimage.setBounds(64, 119, 250, 300);
		contentPane.add(lbGimage);
//      lbGimage.setText(vo.getGimage());

		String imagePath = vo.getGimage();
		ImageIcon imageIcon = new ImageIcon(imagePath);
		lbGimage.setIcon(imageIcon);

		// �ǸŰ�
		JLabel Label_3 = new JLabel("\uD310 \uB9E4 \uAC00 :                           \uC6D0");
		Label_3.setFont(new Font("�������", Font.PLAIN, 15));
		Label_3.setBounds(458, 73, 191, 32);
		contentPane.add(Label_3);

		tfGprice = new JTextField();
		tfGprice.setEditable(false);
		tfGprice.setColumns(10);
		tfGprice.setBounds(529, 70, 89, 41);
		contentPane.add(tfGprice);
		tfGprice.setText(vo.getGprice()); // gprice��������

		// ���ż���
		JLabel lblNewLabel = new JLabel("\uAD6C\uB9E4\uC218\uB7C9 :                          \uAC1C");
		lblNewLabel.setFont(new Font("�������", Font.PLAIN, 15));
		lblNewLabel.setBounds(454, 121, 195, 31);
		contentPane.add(lblNewLabel);

		tfCcount = new JTextField();
		tfCcount.setBounds(529, 115, 89, 37);
		contentPane.add(tfCcount);
		tfCcount.setText("1"); // �⺻�� ����
		tfCcount.setColumns(10);

		// ��ǰ����
		JLabel Label_2 = new JLabel("��ǰ����");
		Label_2.setFont(new Font("�������", Font.PLAIN, 18));
		Label_2.setBounds(64, 417, 95, 32);
		contentPane.add(Label_2);

		tfGcontent = new JTextField();
		tfGcontent.setEditable(false);
		tfGcontent.setColumns(10);
		tfGcontent.setBounds(64, 459, 585, 124);
		contentPane.add(tfGcontent);
		tfGcontent.setText(vo.getGcontent()); // gcontect��������

		// ��ٱ��ϴ�� ��ư
		JButton bCartin = new JButton("��ٱ��ϴ��");
		bCartin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String ccount = tfCcount.getText();
					int membercode = pk;
					String gname = tfGname.getText(); // ��ǰ�� ��������
					vo.setCcount(ccount);
					vo.setMembercode(membercode);
					int goodscode = dao.getGoodsCodeByGname(gname); // ��ǰ������ ��ǰ �ڵ� ��������
					dao.cartAdd(vo, goodscode);
					JOptionPane.showMessageDialog(null, "��ٱ��Ͽ� " + gname + " ��ǰ" + ccount + " ���� �����ϴ�!");
					dispose();
					SellView sell = new SellView(pk, nick, point);
					sell.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		bCartin.setFont(new Font("�������", Font.PLAIN, 18));
		bCartin.setBounds(458, 181, 191, 55);
		contentPane.add(bCartin);

		JButton bCartgo = new JButton("��ٱ��ϰ���");
		bCartgo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CartView cart = new CartView(pk, nick, point);
				cart.setVisible(true);
			}
		});
		bCartgo.setFont(new Font("�������", Font.PLAIN, 18));
		bCartgo.setBounds(458, 246, 191, 55);
		contentPane.add(bCartgo);

		// ���ΰ���ϱ� ��ư
		JButton bBack = new JButton("���ΰ���ϱ�");
		bBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				SellView sell = new SellView(pk, nick, point);
				sell.setVisible(true);
			}
		});
		bBack.setFont(new Font("�������", Font.PLAIN, 18));
		bBack.setBounds(458, 311, 191, 55);
		contentPane.add(bBack);

		// �ı⺸������ ��ư
		JButton bReviewgo = new JButton("�ı⺸������");
		bReviewgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ReviewView review = new ReviewView(pk, nick, point);
				review.setVisible(true);

			}
		});
		bReviewgo.setFont(new Font("�������", Font.PLAIN, 18));
		bReviewgo.setBounds(458, 376, 191, 55);
		contentPane.add(bReviewgo);

	}

	void reviewTable() {
		try {
			tmReview = new ReviewTableModel(list);
			reviewtable.setModel(tmReview);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� �˻� ����: " + e.getMessage());
		}
	}

	class ReviewTableModel extends AbstractTableModel {

		ArrayList data;
		String[] columnNames = { "��ǰ��", "����", "����", "�ۼ���" };

		public ReviewTableModel(ArrayList data) {
			this.data = data;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}
	}
}