package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.SellDAO;
import model.rec.SellVO;

public class ReviewWriteView extends JFrame {

   JPanel contentPane;
   JTextField tfRcontent, tfRdate;
   JComboBox comBuycode, comGname, comRstar;
   
   SellDAO dao = null;
   SellVO vo = null;
   static int pk;
   static String nick;
   static String gname;
   static int point;
   static String reviewItem; 
   JTextField tfBuycode;
   JTextField tfGname;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MyPageView mview = new MyPageView(pk, nick, point);
               ReviewWriteView frame = new ReviewWriteView(reviewItem, gname, pk, nick, point);
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    * @param gname 
    */
   public ReviewWriteView(String reviewItem, String gname, int pk, String nick, int point) {
      this.pk = pk;
      this.nick = nick;
      this.point = point;
      this.gname = gname;   
      this.reviewItem = reviewItem;
      
      
      try {
         System.out.println("DB ���� ����!");
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "DB ���� ���� : " + e.getMessage());
      }

      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 466, 524);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);

      //���ž����۹�ȣ
      JLabel Label_1 = new JLabel("���Ű� : ");
      Label_1.setFont(new Font("�������", Font.PLAIN, 18));
      Label_1.setBounds(56, 41, 142, 44);
      contentPane.add(Label_1);
      
      tfBuycode = new JTextField();
      tfBuycode.setHorizontalAlignment(SwingConstants.CENTER);
      tfBuycode.setEditable(false);
      tfBuycode.setFont(new Font("�������", Font.PLAIN, 15));
      tfBuycode.setColumns(10);
      tfBuycode.setBounds(144, 44, 108, 44);
      contentPane.add(tfBuycode);
      tfBuycode.setText(reviewItem);
      try {
         dao = new SellDAO();
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      //���Ż�ǰ��
      JLabel Label_2 = new JLabel("��ǰ�� : ");
      Label_2.setBounds(56, 96, 66, 44);
      Label_2.setFont(new Font("�������", Font.PLAIN, 18));
      contentPane.add(Label_2);
      
      tfGname = new JTextField();
      tfGname.setEditable(false);
      tfGname.setFont(new Font("�������", Font.PLAIN, 15));
      tfGname.setColumns(10);
      tfGname.setBounds(144, 98, 108, 44);
      contentPane.add(tfGname);
      tfGname.setText(gname);
      try {
         dao = new SellDAO();
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      //�ۼ���
      JLabel Label_3 = new JLabel("�ۼ��� : ");
      Label_3.setBounds(56, 150, 66, 44);
      Label_3.setFont(new Font("�������", Font.PLAIN, 18));
      contentPane.add(Label_3);

      tfRdate = new JTextField();
      tfRdate.setEditable(false);
      tfRdate.setBounds(144, 152, 108, 44);
      tfRdate.setFont(new Font("�������", Font.PLAIN, 15));
      tfRdate.setColumns(10);
      contentPane.add(tfRdate);
      setCurrentDate();

      //����      
      JLabel Label_4 = new JLabel("���� : ");
      Label_4.setBounds(73, 204, 49, 44);
      Label_4.setFont(new Font("�������", Font.PLAIN, 18));
      contentPane.add(Label_4);
      
      JComboBox comRstar = new JComboBox();
      comRstar.setBounds(144, 210, 108, 38);
      comRstar.setFont(new Font("�������", Font.PLAIN, 15));
      comRstar.setModel(new DefaultComboBoxModel(new String[] { "�ڡڡڡڡ�", "�ڡڡڡ�", "�ڡڡ�", "�ڡ�", "��" }));
      contentPane.add(comRstar);
      
      //�ı��Ϲ�ư

      JButton btnNewButton = new JButton("�ı���");
      btnNewButton.setBounds(147, 386, 171, 61);
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            try {
               String rstar = (String) comRstar.getSelectedItem();
               String rcontent = tfRcontent.getText();
               String rdate = tfRdate.getText();
               String buycode = tfBuycode.getText();
            
               vo = new SellVO();
               vo.setRstar(rstar);
               vo.setRcontent(rcontent);
               vo.setRdate(rdate);
               vo.setBuycode(buycode);
               
               dao.reviewAdd(vo);
                              
               JOptionPane.showMessageDialog(null, "�ıⰡ ��ϵǾ����ϴ�.");
               dispose();
               ReviewView review = new ReviewView(pk, nick, point);
               review.setVisible(true);
            } catch (Exception e2) {
               e2.printStackTrace();
            }
         }
      });
      btnNewButton.setFont(new Font("�������", Font.PLAIN, 18));
      contentPane.add(btnNewButton);

   

      JLabel Label_5 = new JLabel("�ı⳻�� : ");
      Label_5.setBounds(34, 262, 88, 44);
      Label_5.setFont(new Font("�������", Font.PLAIN, 18));
      contentPane.add(Label_5);

      tfRcontent = new JTextField();
      tfRcontent.setBounds(142, 265, 241, 88);
      tfRcontent.setColumns(10);
      contentPane.add(tfRcontent);
      

      
      
      
      
      
      
      
      
   
      

      
      
      
   

   }

   // ���糯¥ �޾ƿ��� �żҵ�
   void setCurrentDate() {
      LocalDate currentDate = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      tfRdate.setText(currentDate.format(formatter));
   }

}