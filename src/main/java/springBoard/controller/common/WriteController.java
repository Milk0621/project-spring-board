package springBoard.controller.common;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBoard.entity.Users;
import springBoard.service.jdbc.JDBCBoardService;
import springBoard.service.jdbc.JDBCNoticeService;

@Controller
@RequestMapping("/common/")
public class WriteController {
	
	@Autowired
	private JDBCNoticeService noticeService;
	
	@Autowired
	private JDBCBoardService boardService;
	
	@GetMapping("write")
	public String writePage(HttpSession session, Model model, @RequestParam String type, @RequestParam(required = false) Integer no) throws SQLException {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
	        return "redirect:/common/login";
	    }
		
		if(no != null) {	
			if("notice".equals(type)) {
				model.addAttribute("post", noticeService.noticePost(no));
			}else if("board".equals(type)) {
				model.addAttribute("post", boardService.boardPost(no));
			}
			model.addAttribute("mode", "edit");
		}else {
			model.addAttribute("mode", "write");
		}
		
		model.addAttribute("type", type);
		
		if(user.getUserType().equals("0")) {
			return "adminWrite";
		}else {
			return "customerWrite";
		}
	}
	
	//새로운 글 작성
	@PostMapping("write")
	public String write(HttpSession session, @RequestParam String type, @RequestParam String title, @RequestParam String content) throws SQLException {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
	        return "redirect:/common/login";
	    }
		
		String author = user.getId();
		String userType = user.getUserType().equals("0") ? "admin" : "customer";
		
		if("notice".equals(type)) {
			noticeService.noticeWrite(title, content, author);
		}else if("board".equals(type)) {
			boardService.boardWrite(title, content, author);
		}
		return "redirect:/" + userType + "/" + type + "/list";
	}
	
	//글 수정
	@PostMapping("update")
	public String update(HttpSession session, @RequestParam String type, @RequestParam Integer no, @RequestParam String title, @RequestParam String content) throws SQLException {
		Users user = (Users) session.getAttribute("user");
		if (user == null) {
	        return "redirect:/common/login";
	    }
		
		if("notice".equals(type)) {
			noticeService.noticeUpdate(title, content, no);
		}else if("board".equals(type)) {
			boardService.boardUpdate(title, content, no);
		}
		
		String userType = user.getUserType().equals("0") ? "admin" : "customer";
		return "redirect:/common/post?type="+type+"&no="+no;
	}
	
	
}
