package com.lockbur.visit.controller;

import com.lockbur.visit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2017/3/23.
 */
@Controller
public class DashboardController {


    @Resource
    UserService userService;

    @RequestMapping("/dashboard")
    public String index(Model model) {

        return "index";
    }
}
