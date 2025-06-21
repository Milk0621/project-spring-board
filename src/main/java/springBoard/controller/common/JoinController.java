package springBoard.controller.common;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBoard.service.jdbc.JDBCUsersService;

@Controller
@RequestMapping("/common/")
public class JoinController {
	
	@Autowired
    private JDBCUsersService usersService;
	
	@GetMapping("join")
	public String joinPage() {
		return "common/join";
	}
	
	@PostMapping("join")
	public String join(@RequestParam String id, @RequestParam String pw, @RequestParam String name, @RequestParam String number) throws SQLException {
		usersService.join(id, pw, name, number);
		System.out.println("이름:" + name);
		
		for (byte b : name.getBytes()) {
	        System.out.print(String.format("%02X ", b));
	    }
	    System.out.println();
	    
		return "redirect:/common/login";
	}
	
}
