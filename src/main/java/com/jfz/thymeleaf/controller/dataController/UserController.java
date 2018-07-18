package com.jfz.thymeleaf.controller.dataController;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.jfz.thymeleaf.mapper.PageInfo.Page;
import com.jfz.thymeleaf.model.User;
import com.jfz.thymeleaf.service.UserService;
import com.jfz.thymeleaf.util.dataTable.PageInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/16 20:29
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/user/all" , method = RequestMethod.GET)
    @ResponseBody
    public String getAllUser(HttpServletRequest request) throws Exception {
        Map<String, String[]> requestMap = request.getParameterMap();
        Page page = PageInfoUtil.getPage(requestMap);
        User user = new User();
        user.setParameter(requestMap);
        List<User> users = userService.getPageList(page,user);
        Long count = userService.getCount(user);
        Map<String,Object> res = Maps.newHashMap();
        res.put("data",users);
        res.put("recordsTotal",count);
        res.put("recordsFiltered",count);
        String result = new Gson().toJson(res);
        return result;
    }


}
