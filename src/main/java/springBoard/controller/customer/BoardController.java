package springBoard.controller.customer;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBoard.service.jdbc.JDBCBoardService;

@Controller
@RequestMapping("/customer/board/")
public class BoardController {
	
	@Autowired
	private JDBCBoardService boardService;
	
	@RequestMapping("list")
	public String list(Model model, HttpSession session, @RequestParam(value = "p", defaultValue = "1") int page) throws SQLException {
		
		if (session.getAttribute("user") == null) {
	        return "redirect:/common/login";
	    }
		
		int pageSize = 10;
		int totalCount = boardService.getBoardCount();
		int totalPage = (int) Math.ceil(totalCount / (double)pageSize);
		
		model.addAttribute("list", boardService.boardList(page));
		model.addAttribute("curPage", page);
		model.addAttribute("totalPage", totalPage);
		
		return "customerBoard.board.list";
	}
	
}
