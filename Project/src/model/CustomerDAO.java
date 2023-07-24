package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.CustomerVO;

public class CustomerDAO extends Exception {

	// ������� ����
	int membercode;
	String Id;
	String Pw;
	String Nick;
	String Name;
	String Jumin;
	String Tel;
	String Addr;
	int Point;

	Connection conn = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl";
	String id = "s1";
	String pass = "s1";
	PreparedStatement ps = null;
	Statement stmt = null;
	ArrayList list = null;
	CustomerVO vo = null;
	ResultSet rs = null;

	// constructor
	public CustomerDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pass);
	}

	public ArrayList login(String id, String pw) throws Exception {
		int res = 0;
		/*
		 * 1. sql �ۼ��ϱ� ( insert �� �ۼ� : ����ʵ带 ������ �����Ͽ� ) 2. sql ���۰�ü ������ (
		 * PreparedStatement�� �� ������ �� ) 3. sql ���� ( �������� ?�� ���� ) 4. �ݱ� ( Connection�� ������
		 * �ȵ� )
		 */

		String sql = "SELECT membercode, id, pw, nick, point FROM member WHERE id = ? AND pw = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);

		ResultSet rs = ps.executeQuery();
		list = new ArrayList();
		// ������ ã���� res���� 0�� �ƴ� ���� �ڵ带 ����ֱ� - [JIN]
		if (rs.next()) {
//			ArrayList temp = new ArrayList();
			list.add(rs.getInt("membercode"));
			list.add(rs.getString("id"));
			list.add(rs.getString("pw"));
			list.add(rs.getString("nick"));
			list.add(rs.getString("point"));
//			vo.setMembercode(rs.getInt("membercode"));
//			vo.setId(rs.getString("id"));
//			vo.setPw(rs.getString("pw"));
//			vo.setNick(rs.getString("nick"));
//			vo.setPoint(rs.getString("point"));
//			list.add(temp);
		}

		rs.close();
		ps.close();

		return list;
	}

	public CustomerVO info(int code) throws Exception {
		/*
		 * 1. sql �ۼ��ϱ� ( update �� �ۼ� : ����ʵ带 ������ �����Ͽ� ) 2. sql ���۰�ü ������ (
		 * PreparedStatement�� �� ������ �� ) 3. sql ���� ( �������� ?�� ���� ) 4. �ݱ� ( Connection�� ������
		 * �ȵ� )
		 */

		CustomerVO res = null;
		String sql = "SELECT membercode, id, pw, nick, name, jumin, tel, tel, point FROM member WHERE MEMBERCODE = "
				+ code;

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		// �α��� ������
		if (rs.next()) {
			int membercode = rs.getInt("membercode");
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String nick = rs.getString("nick");
			String name = rs.getString("name");
			String jumin = rs.getString("jumin");
			String tel = rs.getString("tel");
			String addr = rs.getString("addr");
			int point = rs.getInt("point");

			// CustomerVO Ÿ������ ��� ���� ����ֱ�
			res = new CustomerVO(membercode, id, pw, nick, name, jumin, tel, addr, point);
		}
		stmt.close();
		rs.close();

		return res;
	}

	// ���� ��� �޼ҵ�
	public ArrayList<CustomerVO> custFind(int code) throws Exception {
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();

		String sql = "SELECT pw, nick, tel, addr FROM member WHERE membercode =" + code;

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			CustomerVO vo = new CustomerVO();
			vo.setPw(rs.getString(1));
			vo.setNick(rs.getString(2));
			vo.setTel(rs.getString(3));
			vo.setAddr(rs.getString(4));

			list.add(vo);
		}
		stmt.close();
		rs.close();

		return list;
	}

	// ���� ����
	public void updateInfo(CustomerVO vo) throws Exception {
		String sql = "UPDATE member SET pw =?, nick =?, tel =?, addr =? WHERE membercode = " + vo.getMembercode();
		System.out.println(vo.getMembercode());
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getPw());
		ps.setString(2, vo.getNick());
		ps.setString(3, vo.getTel());
		ps.setString(4, vo.getAddr());
//			ps.setInt(5, vo.getMembercode());

		ps.executeUpdate();

		ps.close();

	}

	public ArrayList custAll() throws SQLException {
		String sql = "select membercode, id, pw, nick, name, jumin, tel, addr, point from member";
		list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("membercode"));
			temp.add(rs.getString("id"));
			temp.add(rs.getString("pw"));
			temp.add(rs.getString("nick"));
			temp.add(rs.getString("name"));
			temp.add(rs.getString("jumin"));
			temp.add(rs.getString("tel"));
			temp.add(rs.getString("addr"));
			temp.add(rs.getString("point"));

			list.add(temp);

		}
		rs.close();
		stmt.close();
		return list;

	}

	public CustomerVO loginug(int pk, String id, String nick, String point) throws Exception {

		String sql = "select membercode from member where id =? and pw = ? and nick =? and point = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setInt(2, pk);
		ps.setString(3, nick);
		ps.setString(4, point);
		ResultSet rs = ps.executeQuery();

		CustomerVO vo = new CustomerVO();

		while (rs.next()) {
			vo.setId(rs.getString("membercode"));

		}
		return vo;

	}

}
