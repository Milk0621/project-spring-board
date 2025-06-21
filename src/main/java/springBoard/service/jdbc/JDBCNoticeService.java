package springBoard.service.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoard.entity.Board;
import springBoard.entity.Notice;
import springBoard.service.NoticeService;

@Service
public class JDBCNoticeService implements NoticeService {
	
	@Autowired
	private DataSource dataSource;
	
	//공지사항 갯수 조회
	public int getNoticeCount() throws SQLException {
		String sql = "SELECT COUNT(*) AS CNT FROM NOTICE";
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
	
	//공지사항 조회
	public List<Notice> noticeList(int page) throws SQLException{
		int start = 1 + (page-1)*10;
		int end = 10*page; 

		String sql = "SELECT * FROM NOTICE_VIEW WHERE NUM BETWEEN ? AND ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, start);
		st.setInt(2, end);
		ResultSet rs = st.executeQuery();
		
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()) {
			int no = rs.getInt("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String author = rs.getString("AUTHOR");
			String createDate = rs.getString("CREATE_DATE");
			String updateDate = rs.getString("UPDATE_DATE");
			String deleteDate = rs.getString("DELETE_DATE");
			
			Notice notice = new Notice(no, title, content, author, createDate, updateDate, deleteDate);
			list.add(notice);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	//공지사항 작성
	public void noticeWrite(String title, String content, String author) throws SQLException {
		
		String sql = "INSERT INTO NOTICE (TITLE, CONTENT, AUTHOR) VALUES (?, ?, ?)";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, author);
		st.executeUpdate();
		
		st.close();
		con.close();
		
	}
	
	//공지사항 상세페이지
	public Notice noticePost(int nno) throws SQLException {
		
		String sql = "SELECT * FROM NOTICE WHERE NO = ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, nno);
		ResultSet rs = st.executeQuery();
		
		Notice notice = null;
		
		if(rs.next()) {
			int no = rs.getInt("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String author = rs.getString("AUTHOR");
			String createDate = rs.getString("CREATE_DATE");
			String updateDate = rs.getString("UPDATE_DATE");
			String deleteDate = rs.getString("DELETE_DATE");
			
			notice = new Notice(no, title, content, author, createDate, updateDate, deleteDate);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return notice;
		
	}
	
	//공지사항 수정
	public void noticeUpdate(String title, String content, int no) throws SQLException {
		
		String sql = "UPDATE NOTICE SET TITLE = ?, CONTENT = ?, UPDATE_DATE = SYSDATE WHERE NO = ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setInt(3, no);
		st.executeUpdate();
		
		st.close();
		con.close();
		
	}
	
	//공지사항 삭제
	public void noticeDelete(int no) throws SQLException {
		
		String sql="DELETE FROM NOTICE WHERE NO = ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		st.executeUpdate();
		
		st.close();
		con.close();
		
	}
}
