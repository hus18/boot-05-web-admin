package com.hsl.admin.controller;

import com.hsl.admin.bean.Account;
import com.hsl.admin.bean.City;
import com.hsl.admin.bean.User;
import com.hsl.admin.service.AccountService;
import com.hsl.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {



    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountService;

    @Autowired
    CityService cityService;

    @PostMapping("/city")
    public City saveCity(City city){
        cityService.insert(city);
        return city;
    }
    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Long id) {
        System.out.println(id);
        return accountService.getAcctByid(id);
    }


    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }


    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) { //RedirectAttributes

        if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())) {
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser", user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            //回到登录页面
            return "login";
        }

    }

    /**
     * 去main页面
     *
     * @return
     */
    @GetMapping(value = {"/main.html", "main"})
    public String mainPage(HttpSession session, Model model) {
        return "main";
    }
}


