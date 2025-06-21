package springBoard.service.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoard.entity.Users;
import springBoard.service.UsersService;

@Service
public class JDBCUsersService implements UsersService{
	
	@Autowired
	private DataSource dataSource;
	
	//회원 수 조회
	public int getUsersCount() throws SQLException {
		String sql = "SELECT COUNT(*) AS CNT FROM USERS WHERE USER_TYPE != 0";
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		int count = 0;
		if(rs.next()) {
			count = rs.getInt("CNT");
		}
		
		rs.close();
		st.close();
		con.close();
		
		return count;
	}
	
	//회원가입
	public void join(String id, String pw, String name, String number) throws SQLException {
		
		String sql = "INSERT INTO USERS (ID, PW, NAME, PHONE_NUMBER) VALUES (?, ?, ?, ?)";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, pw);
		st.setString(3, name);
		st.setString(4, number);
		st.executeUpdate();
		
		st.close();
		con.close();
	}
	
	//로그인
	public Users login(String id, String pw) throws SQLException {
		
		String sql = "SELECT * FROM USERS WHERE ID = ? AND PW = ? AND USER_TYPE != 99";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, pw);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			Users user = new Users();
			
			user.setId(rs.getString("ID"));
			user.setPw(rs.getString("PW"));
			user.setName(rs.getString("NAME"));
			user.setPhoneNumber(rs.getString("PHONE_NUMBER"));
			user.setCreateDate(rs.getString("CREATE_DATE"));
			user.setUpdateDate(rs.getString("UPDATE_DATE"));
			user.setDeleteDate(rs.getString("DELETE_DATE"));
			user.setUserType(rs.getString("USER_TYPE"));
			
			return user;
		}
		return null;
	}
	
	//회원 탈퇴(개인회원)
	public void userDelete(String id, String pw) throws SQLException {
		
		String sql ="UPDATE USERS SET USER_TYPE = 99, DELETE_DATE = SYSDATE WHERE ID = ? AND PW = ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, pw);
		st.executeUpdate();
		
	}
	
	//회원 탈퇴(관리자)
	public void adminUserDelete(String id) throws SQLException {
	
		String sql = "UPDATE USERS SET USER_TYPE = 99, DELETE_DATE = SYSDATE WHERE ID = ?";
	
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.executeUpdate();
	}
	
	//회원 조회
	public List<Users> userList(int page) throws SQLException {
		
		int start = 1 + (page-1)*10;
		int end = 10*page; 
		
		String sql = "SELECT * FROM USERS_VIEW WHERE NUM BETWEEN ? AND ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, start);
		st.setInt(2, end);
		ResultSet rs = st.executeQuery();
		
		List<Users> list = new ArrayList<Users>();
		
		while(rs.next()) {
			String id = rs.getString("ID");
			String pw = rs.getString("PW");
			String name = rs.getString("NAME");
			String phoneNumber = rs.getString("PHONE_NUMBER");
			String createDate = rs.getString("CREATE_DATE");
			String updateDate = rs.getString("UPDATE_DATE");
			String deleteDate = rs.getString("DELETE_DATE");
			String userType = rs.getString("USER_TYPE");
			
			Users user = new Users(id, pw, name, phoneNumber, createDate, updateDate, deleteDate, userType);
			list.add(user);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

}
