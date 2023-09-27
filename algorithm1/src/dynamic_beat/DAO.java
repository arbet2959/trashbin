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
		conn = getConnection();
	}
	
	private static class DAOHolder{
		private static final DAO INSTANCE = new DAO();
	}
	public static DAO getInstance() {
		return DAOHolder.INSTANCE;
	}
	
	private Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/javaProject";
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
				
		sql = "select * from dynamicUser where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setAge(rs.getInt("age"));
				dto.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			rsClose();
		}
		return dto;
	}

	public int setSignUp(IdDTO idDTO) {
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
		}
		return res;
	}

	
}
