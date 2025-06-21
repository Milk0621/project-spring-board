package springBoard.controller.common;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBoard.entity.Users;
import springBoard.service.jdbc.JDBCUsersService;

@Controller
@RequestMapping("/common/")
public class LoginController {

	@Autowired
    private JDBCUsersService usersService;
	
	@GetMapping("login")
	public String loginPage() {
		return "common/login";
	}
	
	@PostMapping("login")
	public String login(@RequestParam String id, @RequestParam String pw, HttpSession session, Model model) throws SQLException {
		//인증
		Users user = usersService.login(id, pw);
		
		if(user != null) {
			session.setAttribute("user", user);
			return "redirect:/home";
		}else {
			model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
			return "common/login";
		}
		
	}
	
}
