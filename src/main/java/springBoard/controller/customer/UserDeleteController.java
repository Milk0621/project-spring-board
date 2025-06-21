package springBoard.controller.customer;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBoard.entity.Users;
import springBoard.service.jdbc.JDBCUsersService;

@Controller
@RequestMapping("/customer/")
public class UserDeleteController {

	@Autowired
	private JDBCUsersService userService;
	
	@RequestMapping("userDelete")
	public String userDelete(HttpSession session, String pw) throws SQLException {
		
		Users user = (Users) session.getAttribute("user");
		String id = user.getId();
		userService.userDelete(id, pw);
		return "redirect:/common/login";
	}
	
}
