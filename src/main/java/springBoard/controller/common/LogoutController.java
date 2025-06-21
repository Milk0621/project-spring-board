package springBoard.controller.common;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBoard.service.jdbc.JDBCUsersService;

@Controller
@RequestMapping("/common/")
public class LogoutController {
	
	@Autowired
	private JDBCUsersService usersService;
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/common/login";
	}
}
