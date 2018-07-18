package com.jfz.thymeleaf.controller.viewController;

import com.jfz.thymeleaf.redis.RedisUtil;
import com.jfz.thymeleaf.controller.baseController.BaseController;
import com.jfz.thymeleaf.model.User;
import com.jfz.thymeleaf.model.YTXCallRecord;
import com.jfz.thymeleaf.service.UserService;
import com.jfz.thymeleaf.service.YTXCallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Author : steven.sheng
 * Description : TODO
 * Date : 2018/4/27 19:48
 */
@Controller
public class ThymeleafController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(ThymeleafController.class);

    @Autowired
    private YTXCallService ytxCallService;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JedisPool jedisPool;
    /**
     * 测试hello
     * @return
     */
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        return "test";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String listDemo(Model model) {
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        List<YTXCallRecord> list = ytxCallService.getAllUndownloadFile();
        model.addAttribute("records",list);
        return "list";
    }

    @RequestMapping(value = "/dataList",method = RequestMethod.GET)
    public String dataList(Model model) {
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        return "dataList";
    }

    @RequestMapping(value = "/addRows",method = RequestMethod.GET)
    public String addRows(Model model) {
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        return "addRows";
    }

    @RequestMapping(value = "/basicOperationList",method = RequestMethod.GET)
    public String basicOperationList(Model model) {
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        return "basicOperationList";
    }

    @RequestMapping(value = "/mutiTable",method = RequestMethod.GET)
    public String mutiTable(Model model) {
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        return "mutiTable";
    }

    @RequestMapping(value = "/advancedOperationList",method = RequestMethod.GET)
    public String advancedOperationList(Model model) {
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        return "advancedOperationList";
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String users(Model model) {
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        List<User> list = userService.getAll();
        model.addAttribute("records",list);
        return "users";
    }

    @RequestMapping(value = "/loadUsers",method = RequestMethod.GET)
    public String loadUsers(Model model) {
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        return "loadUsers";
    }

    @RequestMapping(value = "/loadCallRecords",method = RequestMethod.GET)
    public String loadCallRecords(Model model) {
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        return "loadCallRecords";
    }

    @RequestMapping(value = "/testRedis",method = RequestMethod.GET)
    public String testRedis(Model model) {
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        int count = 0;
        String key = "testCount";
        if(redisUtil.hasKey(key)){
            Object testCount = redisUtil.get(key);
            String count1 = testCount.toString();
            count = Integer.parseInt(count1);
        }
        model.addAttribute("count",count);
//        redisUtil.set("testCount",count+1);
        Jedis jedis = jedisPool.getResource();
        try{
            if(!jedis.exists(key)){
                System.out.println(jedis.setex(key,10, String.valueOf(count+1)));
            }else {
                jedis.del(key);
                System.out.println(jedis.setex(key,10, String.valueOf(count+1)));
            }
        }catch(Exception e){
            logger.error("addRedisTimer error",e);
        }finally {
            jedis.close();
        }
        return "testRedis";
    }



}
