package dao.MemberDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import member.Member;

/*
 * Dao(Data[DataBase] Access Object)객체
 * 		- member(회원) 데이타를 저장하고 있는 테이블에
 *        CRUD(Create,Read,Update,Delete)작업을 할수있는 
 *        단위 메쏘드를 가지고 있는 클래스
 */

public class MemberDao {
    
	public MemberDao() {
		
	}
	
	public int insert(Member newMember) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper44";
		String password ="jdeveloper44";
		String insertSQL = "insert into member("
		+ "m_id, m_password, m_name, m_address, m_age, m_married, m_regdate)"
		+ "values('"+newMember.getM_id()+"', '"+newMember.getM_password()
		+ "', '"+newMember.getM_name()+"', '"+newMember.getM_address()
		+ "', '"+newMember.getM_age()+"', '"+newMember.getM_married()
		+"', sysdate)";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSQL);
		
		stmt.close();
		con.close();
		return rowCount;
	}
	
	public int update(Member updateMember) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper44";
		String password ="jdeveloper44";
		String updateSQL = "update member set m_password='"+updateMember.getM_password()
		+ "', m_name = '"+updateMember.getM_name()+"', m_address = '"+updateMember.getM_address()
		+ "', m_age = '"+updateMember.getM_age()+"', m_married = '"+updateMember.getM_married()
		+ "', m_regdate = sysdate where m_id='"+updateMember.getM_id()+"'";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSQL);
		
		stmt.close();
		con.close();
		return rowCount;
	}
	
	public int delete(String m_id) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper44";
		String password ="jdeveloper44";
		String deleteSQL = "delete from member where m_id = '"+m_id+"'";		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSQL);
		
		stmt.close();
		con.close();
		return rowCount;
	}
	
	public Member findByPrimaryKey(String m_id) throws Exception {
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		String selectSQL = "select m_id, m_password, m_name, m_address, m_age, m_married, m_regdate "
		+ "from member where m_id = '"+m_id+"'";		
		Member findMember = null;			
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSQL);		
		if (rs.next()) {
			String id = rs.getString("m_id");
			String m_password = rs.getString("m_password");
			String m_name = rs.getString("m_name");
			String m_address = rs.getString("m_address");
			int m_age = rs.getInt("m_age");
			String m_married = rs.getString("m_married"); 
			Date m_regdate = rs.getDate("m_regdate");
			findMember = new Member(id, m_password, m_name, m_address, m_age, m_married, m_regdate);
		}else {
			findMember = null;
		}
		
		rs.close();
		stmt.close();
		con.close();
		return findMember;
	}
	
    public List<Member> findAll() throws Exception {		
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		String selectSQL = "select m_id, m_password, m_name, m_address, m_age, m_married, m_regdate from member";		
		List<Member> memberList = new ArrayList<Member>();	
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSQL);		
		if (rs.next()) {
			do {
				String m_id = rs.getString("m_id");
				String m_password = rs.getString("m_password");
				String m_name = rs.getString("m_name");
				String m_address = rs.getString("m_address");
				int m_age = rs.getInt("m_age");
				String m_married = rs.getString("m_married"); 
				Date m_regdate = rs.getDate("m_regdate");
				Member findMember = new Member(m_id, m_password, m_name, m_address, m_age, m_married, m_regdate);
				memberList.add(findMember);
			} while (rs.next());
		}else {			
		}
		rs.close();
		stmt.close();
		con.close();
		return memberList;
	}
}