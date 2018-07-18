package com.jfz.thymeleaf.service;

import com.github.pagehelper.PageHelper;
import com.jfz.thymeleaf.mapper.PageInfo.Page;
import com.jfz.thymeleaf.mapper.erp.UserMapper;
import com.jfz.thymeleaf.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/15 10:26
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public List<User> getAll() {
        PageHelper.startPage(0,10);
        return userMapper.getAll();
    }

    public List<User> getPageList(Page page, User user) {
        return userMapper.getPageList(page,user);
    }

    public Long getCount(User user) {
        return userMapper.getCount(user);
    }
}
