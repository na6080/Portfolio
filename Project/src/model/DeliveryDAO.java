package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.DeliveryVO;
import view.DeliveryDetailView;

public class DeliveryDAO {
	// ������� ����
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl"; // ip:port:DB��
//	   private String url="jdbc:oracle:thin:@192.168.0.16:1521:orcl";		// ip:port:DB��
	private String id = "s1";
	private String pass = "s1";
//	   private String id ="ss";
//	   private String pass="ss";
	PreparedStatement ps = null;
	Statement stmt = null;
	DeliveryVO vo = null;
	ArrayList list = null;
	DeliveryDAO dao = this;
	DeliveryDetailView dview = null;

	// constructor
	public DeliveryDAO() throws Exception {

		connectDB();
	}

	// DB control method
	void connectDB() throws Exception {
		/*
		 * 1. ����̹��� ����̹��޴����� ��� 2. ���� ��ü ������
		 */
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pass);

	}

	public ArrayList deliveryAll() throws SQLException {
		String sql = "select o.ordernocode, o.odate, b.buycode, g.gname, b.bcount, d.devcode, d.ddate, dvn.dvncondition "
				+ "from orderno o, buy b, goods g, deilverynow dvn, deilvery d, card c, member m "
				+ "where m.membercode=c.membercode and c.cardcode=o.cardcode and o.ordernocode=d.ordernocode and b.ordernocode=d.ordernocode and b.goodscode=g.goodscode and dvn.dvnowcode=d.dvnowcode "
				+ "and m.membercode = 2";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		this.list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("ordernocode"));
			temp.add(rs.getString("odate"));
			temp.add(rs.getString("buycode"));
			temp.add(rs.getString("gname"));
			temp.add(rs.getString("bcount"));
			temp.add(rs.getString("devcode"));
			temp.add(rs.getString("ddate"));
			temp.add(rs.getString("dvncondition"));
			this.list.add(temp);
		}
		rs.close();
		stmt.close();
		return this.list;
	}

	public ArrayList deliveryDetail(String devcode) throws SQLException {
		String sql = "select dv.dvcompany, dv.dvname, dv.dvtel from deilver dv, deilvery d, orderno o  "
				+ "where dv.dvcode = d.dvcode and o.ordernocode = d.ordernocode " + "and d.devcode = ?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, devcode);
		ResultSet rs = ps.executeQuery();
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("dvcompany"));
			temp.add(rs.getString("dvname"));
			temp.add(rs.getString("dvtel"));
			list.add(temp);
		}

		ps.close();
		rs.close();
		return list;
	}
}
