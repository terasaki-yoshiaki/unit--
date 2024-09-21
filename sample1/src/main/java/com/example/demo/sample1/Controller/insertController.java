package com.example.demo.sample1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.sample1.Model.DAO.sample1DAO;
import com.example.demo.sample1.Model.DTO.sample1DTO;

@Controller
public class insertController {

    private final sample1DAO dao;

    @Autowired
    public insertController(sample1DAO dao) {
        this.dao = dao;
    }

    @PostMapping("/si")
    public String insertform(@ModelAttribute sample1DTO dto, Model model) {
        if (dto == null) {
            return "insert.html";
        } else {
            dao.insert(dto); // モックされたDAOを使用
            List<sample1DTO> list = dao.select();
            model.addAttribute("staff", list);
            return "index.html";
        }
    }

    @GetMapping("/")
    public String index() {
        return "insert.html";
    }
}
