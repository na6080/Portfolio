package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.SellVO;

public class SellDAO {
   Connection conn = null;
   String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl";
   String id = "s5";
   String pwd = "s5";
   PreparedStatement ps = null;
   Statement stmt = null;
   ArrayList list = null;
   SellVO vo;
   SellDAO dao;

   public SellDAO() throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection(url, id, pwd);
      dao = this;
   }

   // ��ǰ ��ü ��� �޼ҵ�
   public ArrayList goodsAll() throws Exception {
      String sql = "select c.gcname, g.gname, g.gprice from goods g, gcategory c "
            + "where g.gcategorycode = c.gcategorycode";
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      list = new ArrayList();

      while (rs.next()) {
         ArrayList temp = new ArrayList();
         temp.add(rs.getString(1));
         temp.add(rs.getString(2));
         temp.add(rs.getString(3));
         list.add(temp);
      }
      rs.close();
      stmt.close();
      return list;
   }

   // ��ǰ ��ü + Ű���� �˻� �޼ҵ�
   public ArrayList goodsAllSearch(String text) throws Exception {
      String sql = "select c.gcname, g.gname, g.gprice from goods g, gcategory c "
            + "where g.gcategorycode = c.gcategorycode and gname like '%" + text + "%'";
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      list = new ArrayList();

      while (rs.next()) {
         ArrayList temp = new ArrayList();
         temp.add(rs.getString(1));
         temp.add(rs.getString(2));
         temp.add(rs.getString(3));
         list.add(temp);
      }
      rs.close();
      stmt.close();
      return list;
   }

   // ī�װ��� �˻� �޼ҵ�
   public ArrayList goodsByCategory(String category) throws Exception {
      String sql = "select c.gcname, g.gname, g.gprice from goods g, gcategory c "
            + "where g.gcategorycode = c.gcategorycode and c.gcname = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, category);
      ResultSet rs = stmt.executeQuery();
      list = new ArrayList();

      while (rs.next()) {
         ArrayList temp = new ArrayList();
         temp.add(rs.getString(1));
         temp.add(rs.getString(2));
         temp.add(rs.getString(3));
         list.add(temp);
      }
      rs.close();
      stmt.close();
      return list;
   }

   // ī�װ� + Ű���� �˻� �޼ҵ�
   public ArrayList goodsByCategorySearch(String category, String text) throws Exception {
      String sql = "select c.gcname, g.gname, g.gprice from goods g, gcategory c "
            + "where g.gcategorycode = c.gcategorycode and c.gcname = ? and g.gname like '%" + text + "%'";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, category);
      ResultSet rs = stmt.executeQuery();
      list = new ArrayList();

      while (rs.next()) {
         ArrayList temp = new ArrayList();
         temp.add(rs.getString(1));
         temp.add(rs.getString(2));
         temp.add(rs.getString(3));
         list.add(temp);
      }
      rs.close();
      stmt.close();
      return list;
   }

   // �ı� ��ü ��������
   public ArrayList reviewAll() throws Exception {
      String sql = "select g.gname, r.rstar, r.rcontent, r.rdate from goods g, review r, buy b"
            + " where r.buycode = b.buycode and b.goodscode = g.goodscode";
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      list = new ArrayList();

      while (rs.next()) {
         ArrayList temp = new ArrayList();
         temp.add(rs.getString("gname"));
         temp.add(rs.getString("rstar"));
         temp.add(rs.getString("rcontent"));
         temp.add(rs.getString("rdate"));
         list.add(temp);
      }
      rs.close();
      stmt.close();
      return list;
   }

   // �ı� �˻� �żҵ�
   public ArrayList reviewSearch(String text) throws Exception {
      String sql = "select g.gname, r.rstar, r.rcontent, r.rdate from goods g, review r, buy b"
            + " where r.buycode = b.buycode and b.goodscode = g.goodscode and gname like '%" + text + "%'";
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      list = new ArrayList();
      while (rs.next()) {
         ArrayList temp = new ArrayList();
         temp.add(rs.getString("gname"));
         temp.add(rs.getString("rstar"));
         temp.add(rs.getString("rcontent"));
         temp.add(rs.getString("rdate"));
         list.add(temp);
      }
      rs.close();
      stmt.close();
      return list;
   }

   // �ı� �ۼ� �żҵ�
   public void reviewAdd(SellVO vo) throws Exception {
      String sql = "insert into review(REVIEWCODE, RSTAR, RCONTENT, RDATE, BUYCODE) values(seq_review.nextval, ?, ?, sysdate, ?)";
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, vo.getRstar());
            ps.setString(2, vo.getRcontent());
            ps.setString(3, vo.getBuycode());
            
            ps.executeUpdate();
             ps.close();
             
            }
   
   // �ı� �ۼ� ���� Ȯ�� �żҵ�
   public boolean hasReview(String buycode) {
        boolean hasReview = false;
        try {
            // �ı� ��ȸ SQL ����
            String sql = "SELECT * FROM review WHERE buycode = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, buycode);
            ResultSet rs = pstmt.executeQuery();

            // �ıⰡ ��ȸ�Ǹ� hasReview�� true�� ����
            if (rs.next()) {
                hasReview = true;
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasReview;
    }
   
   // ��ٱ��� ��������
   public ArrayList<SellVO> cartMain() throws Exception {
      String sql = "select g.gname, c.ccount, g.gprice from goods g, cart c where g.goodscode = c.goodscode";
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      ArrayList<SellVO> list = new ArrayList();

       while (rs.next()) {
              SellVO vo = new SellVO();
              vo.setGname(rs.getString("gname"));
              vo.setCcount(rs.getString("ccount"));
              vo.setGprice(rs.getString("gprice"));
              list.add(vo);
          }
      rs.close();
      stmt.close();
      return list;
   }

   // gname���� goodscode ������� �żҵ�
   public int getGoodsCodeByGname(String gname) throws Exception {
      String sql = "SELECT goodscode FROM goods WHERE gname = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, gname);
      ResultSet rs = stmt.executeQuery();
      int goodscode = -1; // �⺻�� ����

      if (rs.next()) {
         goodscode = rs.getInt("goodscode");
      }

      rs.close();
      stmt.close();

      return goodscode;
   }

   // ��ٱ��� �߰� �޼ҵ�
   public int cartAdd(SellVO vo, int goodscode) throws Exception {
      // goodscode ���� �����ϴ��� Ȯ��
      String checkSql = "SELECT COUNT(*) FROM goods WHERE goodscode = ?";
      PreparedStatement checkStmt = conn.prepareStatement(checkSql);
      checkStmt.setInt(1, goodscode);
      ResultSet checkResult = checkStmt.executeQuery();
      checkResult.next();
      int count = checkResult.getInt(1);

      if (count == 0) {
         // �ش� goodscode�� �������� �ʴ� ���, ���� ó�� �Ǵ� ����ڿ��� �˸�
         throw new Exception("Invalid goodscode: " + goodscode);
      }

      checkResult.close();
      checkStmt.close();

      // cart ���̺� ������ ����
      String insertSql = "INSERT INTO cart(cartcode, ccount, membercode, goodscode) VALUES(?, ?, ?, ?)";
      PreparedStatement insertStmt = conn.prepareStatement(insertSql);
      insertStmt.setInt(1, getCartCode());
      insertStmt.setString(2, vo.getCcount());
      insertStmt.setInt(3, vo.getMembercode());
      insertStmt.setInt(4, goodscode);
      insertStmt.executeUpdate();
      insertStmt.close();

      // ���� �߰��� cart�� goodscode ���� ��ȯ
      String selectSql = "SELECT goodscode FROM cart WHERE cartcode = ?";
      PreparedStatement selectStmt = conn.prepareStatement(selectSql);
      selectStmt.setInt(1, getCartCode());
      ResultSet selectResult = selectStmt.executeQuery();
      int addedGoodscode = -1; // �⺻�� ����

      if (selectResult.next()) {
         addedGoodscode = selectResult.getInt("goodscode");
         System.out.println(goodscode);
      }

      selectResult.close();
      selectStmt.close();

      return addedGoodscode;

   }

   // ��������ȣ �������� �ż���
   public int getCartCode() throws Exception {
      String selectSql = "SELECT seq_cart.nextval FROM dual";
      PreparedStatement selectStmt = conn.prepareStatement(selectSql);
      ResultSet selectResult = selectStmt.executeQuery();
      int cartCode = -1; // �⺻�� ����

      if (selectResult.next()) {
         cartCode = selectResult.getInt(1);
      }

      selectResult.close();
      selectStmt.close();

      return cartCode;
   }

   // ��ٱ��� ���� �޼ҵ�
   public void cartDelete(int memberCode) throws Exception {
      String sql = "DELETE FROM cart WHERE membercode =" + memberCode;
      PreparedStatement pstmt = conn.prepareStatement(sql);

      int rowNum = pstmt.executeUpdate();
      pstmt.close();
   }

   // ��ǰ ������ �żҵ�
   public SellVO getInfo(String gname) throws Exception {
      String sql = "select gname, gimage, gprice, gcontent from goods where gname =?";
      ps = conn.prepareStatement(sql);
      ps.setString(1, gname);
      ResultSet rs = ps.executeQuery();
      SellVO vo = new SellVO();

      while (rs.next()) {
         vo.setGname(rs.getString(1));
         vo.setGimage(rs.getString(2));
         vo.setGprice(rs.getString(3));
         vo.setGcontent(rs.getString(4));
      }
      System.out.println(vo);
      ps.close();
      rs.close();
      return vo;

   }
}