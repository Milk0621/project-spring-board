package springBoard.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springBoard.entity.Users;

@Controller
@RequestMapping("/customer/")
public class MypageController {
	
	@RequestMapping("mypage")
	public String mypage(HttpSession session) {
		
		Users user = (Users) session.getAttribute("user");
		if(user == null) {
			return "redirect:/common/login";
		}
		
		return "mypage";
	}
	
}
