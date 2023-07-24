package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.MarketDAO;
import model.rec.MarketVO;

public class BmSangseView extends JFrame {

	JPanel contentPane;
//	ReviewTableModel tmReview;
	JTable reviewtable;
	JTextField tfGname, tfGprice, tfGcontent;
	JButton bReviewgo, bBack, bCartin;
	JLabel lbGimage;

	MarketDAO dao;
	MarketVO vo;
	ArrayList list = null;
	static int pk;
	static String nick;
	static int point;

	public BmSangseView(MarketVO vo, int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		this.vo = vo;

		try {
			System.out.println("상품상세 디비 연결 성공");
			dao = new MarketDAO();
			reviewtable = new JTable();
//			reviewTable();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "상품상세 디비 연결 실패 : " + e.getMessage());
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton bReviewgo = new JButton("뒤로가기");
		bReviewgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarketView marketview = new MarketView(pk, nick, point);
				marketview.setVisible(true);
				dispose();
			}
		});
		bReviewgo.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		bReviewgo.setBounds(457, 470, 207, 77);
		contentPane.add(bReviewgo);

		JLabel Label_1 = new JLabel("상품명 : ");
		Label_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		Label_1.setBounds(64, 70, 95, 32);
		contentPane.add(Label_1);

		tfGname = new JTextField();
		tfGname.setEditable(false);
		tfGname.setBounds(138, 68, 207, 41);
		contentPane.add(tfGname);
		tfGname.setColumns(10);
		tfGname.setText(vo.getBmname());

		tfGprice = new JTextField();
		tfGprice.setEditable(false);
		tfGprice.setColumns(10);
		tfGprice.setBounds(123, 478, 104, 41);
		contentPane.add(tfGprice);
		tfGprice.setText(vo.getBmprice());

		JLabel Label_2 = new JLabel("상품설명");
		Label_2.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		Label_2.setBounds(64, 165, 95, 32);
		contentPane.add(Label_2);

		tfGcontent = new JTextField();
		tfGcontent.setEditable(false);
		tfGcontent.setColumns(10);
		tfGcontent.setBounds(64, 207, 281, 209);
		contentPane.add(tfGcontent);
		tfGcontent.setText(vo.getBmcontent());

		JLabel Label_3 = new JLabel("판매가 :                             원");
		Label_3.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		Label_3.setBounds(64, 481, 229, 32);
		contentPane.add(Label_3);

		JButton bReviewgo_1 = new JButton("연락처남기기");
		bReviewgo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessageView messageview = new MessageView(pk, nick, point);
				messageview.setVisible(true);
				dispose();
			}
		});
		bReviewgo_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		bReviewgo_1.setBounds(457, 360, 207, 77);
		contentPane.add(bReviewgo_1);
	}

}