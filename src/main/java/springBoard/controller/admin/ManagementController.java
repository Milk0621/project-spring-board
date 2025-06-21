package springBoard.controller.admin;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBoard.entity.Users;
import springBoard.service.jdbc.JDBCUsersService;

@Controller
@RequestMapping("/admin/")
public class ManagementController {
	
	@Autowired
	private JDBCUsersService userService;
	
	//회원조회
	@GetMapping("management")
	public String list(HttpSession session, Model model, @RequestParam(value = "p", defaultValue = "1") int page) throws SQLException {
		
		Users user = (Users) session.getAttribute("user");
		String userType = user.getUserType().equals("0") ? "admin" : "customer";
		if(!userType.equals("admin")) {
			return "redirect:/common/login";
		}
		
		int pageSize = 10;
		int totalCount = userService.getUsersCount();
		int totalPage = (int) Math.ceil(totalCount / (double)pageSize);
		
		model.addAttribute("list", userService.userList(page));
		model.addAttribute("curPage", page);
		model.addAttribute("totalPage", totalPage);
		
		return "management";
	}
	
	//회원탈퇴
	@RequestMapping("userDelete")
	public String userDelete(String id) throws SQLException {
		
		userService.adminUserDelete(id);
		
		return "redirect:/admin/management";
	}
	
}
