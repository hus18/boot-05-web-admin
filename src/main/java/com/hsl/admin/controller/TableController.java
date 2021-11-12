package com.hsl.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hsl.admin.bean.User;
import com.hsl.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {

//        int i = 10/0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn" ,defaultValue = "1") Integer pn ,Model model) {

//        List<User> list = userService.list();
//        model.addAttribute("users",list);

        //构造分页参数
        Page<User> page = new Page<>(pn, 2);
        //调用page进行分页
        Page<User> userPage = userService.page(page, null);


//        userPage.getRecords()
//        userPage.getCurrent()
//        userPage.getPages()


        model.addAttribute("users", userPage);
        return "table/dynamic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes redirectAttributes){
        userService.removeById(id);

        redirectAttributes.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }
    @GetMapping("/editable_table")
    public String editable_table() {
        System.out.println("editable_table");
        return "table/editable_table";
    }

    @GetMapping("responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }
}
