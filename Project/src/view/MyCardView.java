package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CardDAO;
import model.rec.CardVO;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MyCardView extends JFrame {

	JPanel myCard;
	JLabel logo;
	JLabel myCardNo;
	JComboBox myCards;
	JButton btnNewButton;
	JButton canclebtnNewButton;
	CardDAO cdao;
	CardVO cvo;
	ArrayList myCardList;
	static int pk;
	static String nick;
	static int point;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCardView frame = new MyCardView(pk, nick, point);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MyCardView(int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		myCardList = new ArrayList();
		try {
			cdao = new CardDAO();
			myCardList = cdao.myCardAll();
			System.out.println("DB ¿¬°á ¼º°ø!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DB ¿¬°á ½ÇÆÐ : " + e.getMessage());
		}
		addLayout();
	}

	public void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		myCard = new JPanel();
		myCard.setBackground(new Color(220, 240, 217));
		myCard.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(myCard);
		myCard.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(CardAddView.class.getResource("")));
		logo.setBounds(200, 25, 55, 55);
		myCard.add(logo);

		JLabel myCardNo = new JLabel("³» Ä«µå ¼±ÅÃ");
		myCardNo.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 18));
		myCardNo.setBackground(new Color(89, 159, 121));
		myCardNo.setBounds(165, 129, 108, 23);
		myCard.add(myCardNo);

		JComboBox myCards = new JComboBox();
		myCards.setModel(new DefaultComboBoxModel<>(myCardList.toArray(new String[0])));
		myCards.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		myCards.setBounds(131, 176, 183, 23);
		myCard.add(myCards);

		JButton btnNewButton = new JButton("È®ÀÎ");
		btnNewButton.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(169, 219, 162));
		btnNewButton.setBounds(131, 296, 81, 23);
		myCard.add(btnNewButton);

		JButton canclebtnNewButton = new JButton("Ãë¼Ò");
		canclebtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CardAddView cardaddview = new CardAddView(pk, nick, point);
				cardaddview.setVisible(false);
			}
		});
		canclebtnNewButton.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 15));
		canclebtnNewButton.setBackground(new Color(169, 219, 162));
		canclebtnNewButton.setBounds(233, 296, 81, 23);
		myCard.add(canclebtnNewButton);

	}
}
