package com.jfz.thymeleaf.mapper.erp;

import com.jfz.thymeleaf.mapper.PageInfo.Page;
import com.jfz.thymeleaf.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/15 10:24
 */
@Mapper
public interface UserMapper {
    @Select("select * from sys_user")
    List<User> getAll();

    @SelectProvider(type=UserDaoSelectProvider.class,method = "getCount")
    Long getCount(User user);

    @SelectProvider(type=UserDaoSelectProvider.class,method = "getPageList")
    List<User> getPageList(Page page, User user);

    class UserDaoSelectProvider {
        public String getPageList(Page page,User user){
            String sql = "SELECT * FROM sys_user";
            sql += " where 1=1";
            if(StringUtils.isNotBlank(user.getMobile())){
                sql += " and mobile regexp '"+ user.getMobile()+"'";
            }
            if(StringUtils.isNotBlank(user.getFullname())){
                sql += " and fullname regexp '"+ user.getFullname()+"'";
            }
            if(StringUtils.isNotBlank(page.getOrderField())&&StringUtils.isNotBlank(page.getOrderSeq())){
                sql += " order by " ;
                sql += page.getOrderField();
                sql += " ";
                sql += page.getOrderSeq();
                sql += " ";
            }
            sql += " limit ";
            sql += page.getStart();
            sql += " ,";
            sql += page.getLength();
            return sql;
        }

        public String getCount(User user){
            String sql = "SELECT count(1) FROM sys_user";
            sql += " where 1=1";
            if(StringUtils.isNotBlank(user.getMobile())){
                sql += " and mobile regexp '"+ user.getMobile()+"'";
            }
            if(StringUtils.isNotBlank(user.getFullname())){
                sql += " and fullname regexp '"+ user.getFullname()+"'";
            }
            return sql;
        }
    }
}
