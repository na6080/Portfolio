package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.CustomerVO;
import model.rec.MissionVO;

public class MissionDAO {
	Connection conn = null;
//  private String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl";
	String id = "s1";
	String pwd = "s1";
	CustomerVO cvo = null;
	PreparedStatement ps = null;
	Statement stmt = null;
	ArrayList list = null;

	public MissionDAO() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pwd);
		System.out.println("DB���� ����!");
	}

	// �̼� ��ü ��� �޼ҵ�
	public ArrayList missionAll() throws Exception {
		String sql = "select mname, miname, mipoint from mcategory c, mission m"
				+ "where c.mcategorycode = m.mcategorycode";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString(1));
			temp.add(rs.getString(2));
			temp.add(rs.getInt(3));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// �̼� �Ϸ� �޼ҵ�
	public ArrayList missionSearch(int membercode) throws Exception {
		String sql = "SELECT m.miname, m.mipoint FROM mission m, mlist l WHERE m.missioncode = l.missioncode AND l.mlfinish = 'Y' and l.membercode = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, membercode);
		ResultSet rs = stmt.executeQuery();

		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("miname"));
			temp.add(rs.getString("mipoint"));
			list.add(temp);
		}

		rs.close();
		stmt.close();
		return list;
	}

	// �̼� �̿Ϸ� �޼ҵ�
	public ArrayList missionmiSearch(int sel, String text) throws Exception {
		String sql = "SELECT m.miname, m.mipoint FROM mission m, mlist l"
				+ "WHERE m.missioncode = l.missioncode AND mlfinish = 'N'";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("miname"));
			temp.add(rs.getString("mipoint"));

			list.add(temp);
		}

		rs.close();
		stmt.close();
		return list;
	}

}
