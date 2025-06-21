package springBoard.service;

import java.sql.SQLException;
import java.util.List;

import springBoard.entity.Notice;

public interface NoticeService {
	public List<Notice> noticeList(int page) throws SQLException;

}
