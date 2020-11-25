package org.java.web;

import org.java.entity.Prd;
import org.java.service.PrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: 马果
 * @Date: 2018/12/5 16:46
 * @Description:
 */
@Controller
public class PrdController {

    @Autowired
    private PrdService prdService;

    @RequestMapping("/load")
    public String init(Model model){
        List<Prd> list = prdService.getList();
        model.addAttribute("list", list);
        return "/show";
    }
    @RequestMapping("/showDetails/{pid}")
    public String showDetails(@PathVariable("pid")String pid,Model model){
        Prd p =  prdService.findById(pid);
        model.addAttribute("prd", p);
        return "/showDetail";
    }
}
