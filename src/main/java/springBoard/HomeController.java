package springBoard;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springBoard.entity.Users;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping("home")
	public String home(HttpSession session) {
		Users user = (Users)session.getAttribute("user");
		
		if(user == null) {
			return "common/home";			
		}
		String userType = user.getUserType();
		if(userType.equals("0")) {
			return "admin/home";
		}else {
			return "customer/home";			
		}
	}
}
