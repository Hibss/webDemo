package com.jfz.thymeleaf.util.dataTable;

import com.jfz.thymeleaf.mapper.PageInfo.Page;

import java.util.Map;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/18 9:47
 */
public class PageInfoUtil {

    private static String preFixField = "columns[";
    private static String suffixField = "][name]";
    public static Page getPage(Map<String, String[]> request) {
        String start = request.get("start")[0];
        String length = request.get("length")[0];
        String columnNumber = request.get("order[0][column]")[0];
        String columnDesc = preFixField + columnNumber + suffixField;
        String orderField = request.get(columnDesc)[0];
        String orderSeq = request.get("order[0][dir]")[0];
        return new Page(start,length,orderField,orderSeq);
    }
}
