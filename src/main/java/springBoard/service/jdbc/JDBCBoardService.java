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
import springBoard.service.BoardService;

@Service
public class JDBCBoardService implements BoardService{
	
	@Autowired
	private DataSource dataSource;
	
	//자유게시판 갯수 조회
	public int getBoardCount() throws SQLException {
		String sql = "SELECT COUNT(*) AS CNT FROM BOARD";
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
		
	//자유게시판 조회
	public List<Board> boardList(int page) throws SQLException{
		int start = 1 + (page-1)*10;
		int end = 10*page; 

		String sql = "SELECT * FROM BOARD_VIEW WHERE NUM BETWEEN ? AND ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, start);
		st.setInt(2, end);
		ResultSet rs = st.executeQuery();
		
		List<Board> list = new ArrayList<Board>();
		
		while(rs.next()) {
			int no = rs.getInt("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String author = rs.getString("AUTHOR");
			String createDate = rs.getString("CREATE_DATE");
			String updateDate = rs.getString("UPDATE_DATE");
			String deleteDate = rs.getString("DELETE_DATE");
			
			Board board = new Board(no, title, content, author, createDate, updateDate, deleteDate);
			list.add(board);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	//자유게시판 작성
	public void boardWrite(String title, String content, String author) throws SQLException {
		
		String sql = "INSERT INTO BOARD (TITLE, CONTENT, AUTHOR) VALUES (?, ?, ?)";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, author);
		st.executeUpdate();
		
		st.close();
		con.close();
		
		
	}
	
	//자유게시판 상세페이지
	public Board boardPost(int bno) throws SQLException {
		
		String sql = "SELECT * FROM BOARD WHERE NO = ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, bno);
		ResultSet rs = st.executeQuery();
		
		Board board = null;
		
		if(rs.next()) {
			int no = rs.getInt("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String author = rs.getString("AUTHOR");
			String createDate = rs.getString("CREATE_DATE");
			String updateDate = rs.getString("UPDATE_DATE");
			String deleteDate = rs.getString("DELETE_DATE");
			
			board = new Board(no, title, content, author, createDate, updateDate, deleteDate);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return board;
		
	}
	
	//자유게시판 수정
	public void boardUpdate(String title, String content, int no) throws SQLException {
		
		String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, UPDATE_DATE = SYSDATE WHERE NO = ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setInt(3, no);
		st.executeUpdate();
		
		st.close();
		con.close();
		
	}
	
	//자유게시판 삭제
	public void boardDelete(int no) throws SQLException {
		
		String sql="DELETE FROM BOARD WHERE NO = ?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, no);
		st.executeUpdate();
		
		st.close();
		con.close();
		
	}
}
