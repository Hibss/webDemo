package com.jfz.thymeleaf.mapper.PageInfo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/17 20:02
 */
@Data
@AllArgsConstructor
public class Page {
    protected String start;
    protected String length;
    protected String orderField;
    protected String orderSeq;
}
