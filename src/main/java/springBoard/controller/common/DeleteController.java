package springBoard.controller.common;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBoard.entity.Users;
import springBoard.service.jdbc.JDBCBoardService;
import springBoard.service.jdbc.JDBCNoticeService;

@Controller
@RequestMapping("/common/")
public class DeleteController {
	
	@Autowired
	private JDBCNoticeService noticeService;
	
	@Autowired
	private JDBCBoardService boardService;
	
	@RequestMapping("delete")
	public String delete(HttpSession session, @RequestParam int no, @RequestParam String type) throws SQLException {
		
		Users user = (Users) session.getAttribute("user");
		String userType = user.getUserType().equals("0") ? "admin" : "customer";
		
		if("notice".equals(type)) {
			noticeService.noticeDelete(no);
		}else if("board".equals(type)) {
			boardService.boardDelete(no);
		}
		
		return "redirect:/" + userType + "/" + type + "/list";
	}
	
}
