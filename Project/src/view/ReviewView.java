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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.SellDAO;
import model.rec.SellVO;

public class ReviewView extends JFrame implements ActionListener {
   GoodsView goods;
   JPanel contentPane;
   JTextField tfSearch;
   ReviewTableModel tmReview;
   JTable reviewtable = null;
   ArrayList list = null;
   SellDAO dao = null;
   SellVO vo = null;

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               ReviewView frame = new ReviewView();
//               frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   /**
    * Create the frame.
    */
   public ReviewView(int pk, String nick, int point) {
      try {
         System.out.println("후기 디비 연결 성공");
         dao = new SellDAO();
//         reviewtable = new JTable();   
         list = dao.reviewAll();
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "상품 디비 연결 실패 : " + e.getMessage());
      }

      // tmReview 초기화
      tmReview = new ReviewTableModel(list);
      reviewtable = new JTable(tmReview);
      tfSearch = new JTextField("");

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 700, 650);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);

      JLabel Label_1 = new JLabel("상품후기목록");
      Label_1.setBounds(41, 73, 160, 24);
      Label_1.setFont(new Font("나눔고딕", Font.PLAIN, 20));
      contentPane.add(Label_1);

      JLabel lblNewLabel = new JLabel("상품명 : ");
      lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 18));
      lblNewLabel.setBounds(401, 70, 109, 32);
      contentPane.add(lblNewLabel);

      tfSearch = new JTextField();
      tfSearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String text = tfSearch.getText();
            if (text.equals("")) {
               reviewTable();
            } else {
               try {
                  ArrayList filteredList = dao.reviewSearch(text);
                  tmReview.data = filteredList;
                  tmReview.fireTableDataChanged();
//                  reviewtable.setModel(tmReview);
               } catch (Exception e2) {
                  JOptionPane.showMessageDialog(null, "후기 검색 실패: " + e2.getMessage());
               }
            }

         }
      });
      tfSearch.setColumns(10);
      tfSearch.setBounds(480, 70, 171, 37);
      contentPane.add(tfSearch);

      JScrollPane Reviewpane = new JScrollPane();
      Reviewpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      Reviewpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      Reviewpane.setBounds(41, 128, 610, 374);
      contentPane.add(Reviewpane);

      reviewtable = new JTable(tmReview);
      Reviewpane.setViewportView(reviewtable);

      JButton bBack = new JButton("쇼핑계속하기");
      bBack.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            dispose();
            SellView sell = new SellView(pk, nick, point);
            sell.setVisible(true);
         }
      });
      bBack.setFont(new Font("나눔고딕", Font.PLAIN, 18));
      bBack.setBounds(130, 528, 171, 56);
      contentPane.add(bBack);

      JButton bWrite = new JButton("후기쓰러가기");
      bWrite.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            dispose();
            MyPageView mypage = new MyPageView(pk, nick, point);
            mypage.setVisible(true);
         }
      });
      bWrite.setFont(new Font("나눔고딕", Font.PLAIN, 18));
      bWrite.setBounds(417, 528, 171, 56);
      contentPane.add(bWrite);
   }

   void reviewTable() {
      try {
         String text = tfSearch.getText();
         list = dao.goodsAllSearch(text);
         tmReview = new ReviewTableModel(list);
//         reviewtable.setModel(tmReview);
         tmReview.fireTableDataChanged();

      } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "리뷰 검색 실패: " + e.getMessage());
      }
   }

   class ReviewTableModel extends AbstractTableModel {

      ArrayList data;
      String[] columnNames = { "상품명", "별점", "내용", "작성일" };

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

      public String getColumnName(int col) {
         return columnNames[col];
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method st
   }
}