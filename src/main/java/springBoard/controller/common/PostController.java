package springBoard.controller.common;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBoard.entity.Users;
import springBoard.service.jdbc.JDBCBoardService;
import springBoard.service.jdbc.JDBCNoticeService;

@Controller
@RequestMapping("/common/")
public class PostController {
	
	@Autowired
	private JDBCBoardService boardService;
	
	@Autowired
	private JDBCNoticeService noticeService;
	
	@RequestMapping("post")
	public String postPage(@RequestParam("type") String type, @RequestParam("no") int no, Model model, HttpSession session) throws SQLException {
		
		Users user = (Users) session.getAttribute("user");
		if(user == null) {
			return "redirect:/common/login";
		}
		
		if("board".equals(type)) {
			model.addAttribute("post", boardService.boardPost(no));
		}else if("notice".equals(type)) {
			model.addAttribute("post", noticeService.noticePost(no));
		}
		
		model.addAttribute("type", type);
		
		String userType = user.getUserType();
		if(userType.equals("0")) {
			return "adminPost";
		}else {
			return "customerPost";
		}
		
	}
}
