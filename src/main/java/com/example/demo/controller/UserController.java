package com.example.demo.controller;

import com.example.demo.po.User;
import com.example.demo.service.UserService;
import com.maxwellnie.velox.sql.core.natives.dao.BaseDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Maxwell Nie
 */
@Controller("/")
public class UserController {
    @Resource
    private BaseDao<User> userDao;
    @Resource
    private UserService userService;

    @GetMapping("/test")
    public void test(HttpServletResponse response) throws IOException {
        response.getWriter().println(userService.selectAll().size());
    }
}
