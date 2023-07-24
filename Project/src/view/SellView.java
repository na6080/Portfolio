package view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.SellDAO;
import model.rec.SellVO;

public class SellView extends JFrame implements ActionListener {
   JTable goodstable;
   JButton bCartin, bCartgo, bMypage, bGohome;
   JTextField tfSearch;
   JComboBox combox;
   JScrollPane Goodspane;

   SellDAO dao = null;
   SellVO vo = null;
   GoodsTableModel tmGoods;
   ArrayList list;
   static int pk;
   static String nick;
   static int point;

   public SellView(int pk, String nick, int point) {
      try {
         System.out.println("��ǰ ��� ���� ����");
         dao = new SellDAO();
         goodstable = new JTable();
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "��ǰ ��� ���� ���� : " + e.getMessage());
      }

      // list �ʱ�ȭ
      list = new ArrayList();

      // tmGoods �ʱ�ȭ
      tmGoods = new GoodsTableModel(list);
      goodstable.setModel(tmGoods);
      tfSearch = new JTextField("");

      setIconImage(Toolkit.getDefaultToolkit().getImage(SellView.class.getResource("")));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1380, 820);
      getContentPane().setLayout(null);

      JScrollPane Goodspane = new JScrollPane();
      Goodspane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      Goodspane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      Goodspane.setBounds(274, 154, 1040, 570);
      getContentPane().add(Goodspane);

      goodstable = new JTable();
      goodstable.setFont(new Font("�������", Font.PLAIN, 15));
      goodstable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ī�װ�", "��ǰ��", "����" }));
      Goodspane.setViewportView(goodstable);
      goodstable.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            dispose();
            int col = 1;
            int row = goodstable.getSelectedRow();
            String gname = (String) goodstable.getValueAt(row, col);

            try {
               vo = dao.getInfo(gname);
               GoodsView goods = new GoodsView(vo, pk, nick, point);
               goods.setVisible(true);
            } catch (Exception e2) {
               JOptionPane.showConfirmDialog(null, "�������� ����: " + e2.getMessage());
            }
         }
      });

      JButton bMypage = new JButton("����������");
      bMypage.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
         dispose();
         MyPageView mypage = new MyPageView(pk, nick, point);
         mypage.setVisible(true);
         }
      });
      bMypage.setBounds(1215, 26, 99, 99);
      bMypage.setIcon(null);
      getContentPane().add(bMypage);

      JButton bGohome = new JButton("Ȩ��ư");
      bGohome.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            dispose();
            MainHomeView home = new MainHomeView(pk, nick, point);
            home.setVisible(true);
         }
      });
      bGohome.setBounds(665, 26, 99, 99);
      bGohome.setIcon(null);
      getContentPane().add(bGohome);
      selectTable();

      JButton bCartgo = new JButton("��ٱ��� ����");
      bCartgo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
            CartView cart = new CartView(pk, nick, point);
            cart.setVisible(true);
            goodstable.getModel();

         }
      });
      bCartgo.setFont(new Font("�������", Font.PLAIN, 18));
      bCartgo.setBounds(58, 441, 175, 82);
      getContentPane().add(bCartgo);

      JLabel lblNewLabel_1 = new JLabel("��ǰ ī�װ�");
      lblNewLabel_1.setFont(new Font("�������", Font.PLAIN, 18));
      lblNewLabel_1.setBounds(52, 179, 126, 25);
      getContentPane().add(lblNewLabel_1);

      JComboBox combox = new JComboBox();
      combox.setModel(new DefaultComboBoxModel(new String[] { "��ü", "����", "���", "������", "����ǰ" }));
      combox.setFont(new Font("�������", Font.PLAIN, 15));
      combox.setBounds(62, 214, 171, 47);
      getContentPane().add(combox);
      combox.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            String text = tfSearch.getText();
            String selectedCategory = combox.getSelectedItem().toString();

            if (selectedCategory.equals("��ü")) {
               selectTable();
               clearScreen();

            } else if (selectedCategory.equals("����")) {
               try {
                  ArrayList filteredList = dao.goodsByCategory(selectedCategory);
                  tmGoods.data = filteredList;
                  goodstable.setModel(tmGoods);
                  clearScreen();
               } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "��ǰ �˻� ����: " + ex.getMessage());
               }
            } else if (selectedCategory.equals("���")) {
               try {
                  ArrayList filteredList = dao.goodsByCategory(selectedCategory);
                  tmGoods.data = filteredList;
                  goodstable.setModel(tmGoods);
                  clearScreen();
               } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "��ǰ �˻� ����: " + ex.getMessage());
               }
            } else if (selectedCategory.equals("������")) {
               try {
                  ArrayList filteredList = dao.goodsByCategory(selectedCategory);
                  tmGoods.data = filteredList;
                  goodstable.setModel(tmGoods);
                  clearScreen();
               } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "��ǰ �˻� ����: " + ex.getMessage());
               }
            } else if (selectedCategory.equals("����")) {
               try {
                  ArrayList filteredList = dao.goodsByCategory(selectedCategory);
                  tmGoods.data = filteredList;
                  goodstable.setModel(tmGoods);
                  clearScreen();
               } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "��ǰ �˻� ����: " + ex.getMessage());
               }
            } else {
               try {
                  ArrayList filteredList = dao.goodsByCategory(selectedCategory);
                  tmGoods.data = filteredList;
                  goodstable.setModel(tmGoods);
               } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "��ǰ �˻� ����: " + ex.getMessage());
               }
            }
         }
      });

      JLabel lblNewLabel = new JLabel("��ǰ�˻�");
      lblNewLabel.setFont(new Font("�������", Font.PLAIN, 18));
      lblNewLabel.setBounds(52, 277, 109, 32);
      getContentPane().add(lblNewLabel);

      tfSearch = new JTextField();
      tfSearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String selectedCategory = combox.getSelectedItem().toString();
            String text = tfSearch.getText();
            if (selectedCategory.equals("��ü")) {
               selectTable();
            } else if (selectedCategory.equals("����")) {
               try {
                  ArrayList filteredList = dao.goodsByCategorySearch(selectedCategory, text);
                  tmGoods.data = filteredList;
                  goodstable.setModel(tmGoods);
               } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "��ǰ �˻� ����: " + ex.getMessage());
               }
            } else if (selectedCategory.equals("���")) {
               try {
                  ArrayList filteredList = dao.goodsByCategorySearch(selectedCategory, text);
                  tmGoods.data = filteredList;
                  goodstable.setModel(tmGoods);
               } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "��ǰ �˻� ����: " + ex.getMessage());
               }
            } else if (selectedCategory.equals("������")) {
               try {
                  ArrayList filteredList = dao.goodsByCategorySearch(selectedCategory, text);
                  tmGoods.data = filteredList;
                  goodstable.setModel(tmGoods);
               } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "��ǰ �˻� ����: " + ex.getMessage());
               }
            } else if (selectedCategory.equals("����")) {
               try {
                  ArrayList filteredList = dao.goodsByCategorySearch(selectedCategory, text);
                  tmGoods.data = filteredList;
                  goodstable.setModel(tmGoods);
               } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "��ǰ �˻� ����: " + ex.getMessage());
               }
            } else {
               try {
                  ArrayList filteredList = dao.goodsByCategorySearch(selectedCategory, text);
                  tmGoods.data = filteredList;
                  goodstable.setModel(tmGoods);
               } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "��ǰ �˻� ����: " + ex.getMessage());
               }
            }
         }
      });
      tfSearch.setColumns(10);
      tfSearch.setBounds(62, 319, 171, 47);
      getContentPane().add(tfSearch);

   }

   void eventProc() {
      tfSearch.addActionListener(this);
      combox.addActionListener(this);
      bCartin.addActionListener(this);
   }

   void selectTable() {
      try {
         String text = tfSearch.getText();
         list = dao.goodsAllSearch(text);
         tmGoods = new GoodsTableModel(list);
         goodstable.setModel(tmGoods);

      } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "��ǰ �˻� ����: " + e.getMessage());
      }

   }

   class GoodsTableModel extends AbstractTableModel {

      ArrayList data = new ArrayList();
      String[] columnNames = { "ī�װ�", "��ǰ��", "��ǰ����" };

      public GoodsTableModel(ArrayList data) {
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

   void clearScreen() {
      tfSearch.setText("");

   }

   @Override
   public void actionPerformed(ActionEvent e) {
   }
}