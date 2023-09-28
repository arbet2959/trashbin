package dynamic_beat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DAO {
	
private Connection conn;
private PreparedStatement pstmt;
private ResultSet rs;
private IdDTO idDTO;
private PlayRecordDTO prDTO;
int res=0;
private String sql;
	
	private DAO() {
		
	}
	
	private static class DAOHolder{
		private static final DAO INSTANCE = new DAO();
	}
	public static DAO getInstance() {
		return DAOHolder.INSTANCE;
	}
	
	private Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/javaProject3";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버검색실패");
		} catch (SQLException e) {
			System.out.println("DB연동실패");		
		}
		return conn;
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {	}
	}
	
	public void pstmtClose() {
		try {
			if(pstmt!=null)pstmt.close();
		} catch (Exception e) {	}
	}
	
	public void rsClose() {
		try {
			if(rs!=null)rs.close();
		} catch (Exception e) {	}
		try {
			if(pstmt!=null)pstmt.close();
		} catch (Exception e) {	}
		
	}

	//ID로검색
	public IdDTO getSearchId(IdDTO dto) {
		conn = getConnection();
		IdDTO dto2 = new IdDTO();
		sql = "select * from dynamicUser where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto2.setId(rs.getString("id"));
				dto2.setPassword(rs.getString("password"));
				dto2.setAge(rs.getInt("age"));
				dto2.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			rsClose();
			connClose();
		}
		return dto2;
	}

	public int setSignUp(IdDTO idDTO) {
		conn = getConnection();
		int res =0;
		sql = "insert into dynamicUser values(?,?,?,?,default,default)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idDTO.getId());
			pstmt.setString(2, idDTO.getPassword());
			pstmt.setInt(3, idDTO.getAge());
			pstmt.setString(4, idDTO.getEmail());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			pstmtClose();
			connClose();
		}
		return res;
	}

	public int setInsertScore(PlayRecordDTO prDTO) {
		conn = getConnection();
		int res =0;
		sql = "insert into playRecord values(default,?,?,?,default,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prDTO.getID());
			pstmt.setString(2, prDTO.getTitle());
			pstmt.setString(3, prDTO.getDifficulty());
			pstmt.setInt(4, prDTO.getScore());
			System.out.println(prDTO.toString());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			pstmtClose();
			connClose();
		}
		return res;
		
	}

	
}
