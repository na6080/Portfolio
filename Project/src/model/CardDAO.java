package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.CardVO;

public class CardDAO {
	// 멤버변수 선언
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl"; // ip:port:DB명
//	   private String url="jdbc:oracle:thin:@192.168.0.16:1521:orcl";		// ip:port:DB명
	private String id = "s1";
	private String pass = "s1";
//	   private String id ="ss";
//	   private String pass="ss";
	PreparedStatement ps = null;
	Statement stmt = null;
	CardVO vo = null;
	ArrayList list = null;

	// constructor
	public CardDAO() throws Exception {
		connectDB();
	}

	// DB control method
	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pass);

	}

	public void cardAdd(CardVO vo) throws SQLException {

		String sql = "insert into card(CARDCODE, CNO, CNAME, CVC, MEMBERCODE, CDATE) values(seq_card.nextval,?,?,?,2,?)";
		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getCno());
		ps.setString(2, vo.getCname());
		ps.setString(3, vo.getCvc());
		ps.setString(4, vo.getCdate());

		ps.executeUpdate();
		ps.close();

	}

	public ArrayList cardAll() throws SQLException {

		String sql = "select c.cname, c.cno, c.cdate from card c, member m where m.membercode = c.membercode and m.membercode = 2";
		list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("cname"));
			temp.add(rs.getString("cno"));
			temp.add(rs.getString("cdate"));

			list.add(temp);

		}

		rs.close();
		stmt.close();
		return list;

	}

	public void deleteCard(String cNum) throws SQLException {

		String sql = "delete from card where cno= ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, cNum);
		ps.executeUpdate();
	}

	public ArrayList myCardAll() throws SQLException {

		String sql = "select cno from card where memberno = ''";
		list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("cno"));

			list.add(temp);

		}

		rs.close();
		stmt.close();
		return list;

	}

}
