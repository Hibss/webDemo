package com.jfz.thymeleaf.controller.dataController;

import com.jfz.thymeleaf.model.YTXCallBack;
import com.jfz.thymeleaf.service.YTXCallService;
import com.jfz.thymeleaf.util.dataTable.RtPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/7 18:05
 */
@RestController
public class DataTableDataController {
    @Autowired
    private YTXCallService ytxCallService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public RtPageInfo  queryData(
            @RequestParam(required = false, name = "pageSize") Integer pageSize,
            @RequestParam(required = false, name = "startIndex") Integer startIndex,
            @RequestParam(required = false, name = "pageIndex") Integer pageIndex){
        List<YTXCallBack> records = ytxCallService.getAllCallBack();
        RtPageInfo pageInfo = new RtPageInfo();
        pageInfo.setData(records);//这里是数据内容 List
        pageInfo.setPageNum(startIndex/pageSize);//Integer
        pageInfo.setPageSize(pageSize);//pageSize
        pageInfo.setTotalCount(records.size());//BigInteger
        return pageInfo ;
    }
}
