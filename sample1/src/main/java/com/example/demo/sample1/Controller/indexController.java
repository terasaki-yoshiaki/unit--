package com.example.demo.sample1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@SessionAttributes
public class indexController {

//	sample1DAO dao = new sample1DAO();
//	@GetMapping("")
//	public String index(Model model) {
//	List<sample1DTO> list = dao.select();
//	model.addAttribute("staff",list);
//	return "index.html";
//}
//}


@PostMapping("/sif")
public String index() {
    	return "insert.html";
	}
}
