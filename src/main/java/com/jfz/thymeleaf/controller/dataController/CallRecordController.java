package com.jfz.thymeleaf.controller.dataController;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.jfz.thymeleaf.mapper.PageInfo.Page;
import com.jfz.thymeleaf.model.CallRecord;
import com.jfz.thymeleaf.model.TransferUtil;
import com.jfz.thymeleaf.model.YTXCallRecord;
import com.jfz.thymeleaf.service.CallRecordService;
import com.jfz.thymeleaf.service.YTXCallService;
import com.jfz.thymeleaf.util.Errors;
import com.jfz.thymeleaf.util.RestResponse;
import com.jfz.thymeleaf.util.dataTable.PageInfoUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/3 14:15
 * @author steven.sheng
 */
@RestController
public class CallRecordController {

    private static final String ALL_TYPE="0";

    @Autowired
    private YTXCallService ytxCallService;

    @Autowired
    private CallRecordService callRecordService;

    @RequestMapping(value = {"/downloadYTXCalls"},method = RequestMethod.POST)
    public RestResponse downloadYTXCalls(HttpServletRequest request){
        String callId = request.getParameter("callId");
        if(ALL_TYPE.equals(callId)){
            return RestResponse.createSuccess(new Gson().toJson(ytxCallService.getAllUndownloadFile()));
        }
        YTXCallRecord record = ytxCallService.findByCallId(callId);
        if(Objects.isNull(record)){
            return RestResponse.createFailed(Errors.ILLEGAL_PARAMETER.getCode(),"无对应呼叫记录");
        }
        return RestResponse.createSuccess(new Gson().toJson(record));
    }

    @RequestMapping(value = "/callRecord/list" , method = RequestMethod.GET)
    @ResponseBody
    public String getAllUser(javax.servlet.http.HttpServletRequest request) throws Exception {
        Map<String, String[]> requestMap = request.getParameterMap();
        Page page = PageInfoUtil.getPage(requestMap);
        CallRecord record = new CallRecord();
        TransferUtil.setParameter(requestMap,CallRecord.class,record);
        List<CallRecord> users = callRecordService.getPageList(page,record);
        Long count = callRecordService.getCount(record);
        Map<String,Object> res = Maps.newHashMap();
        res.put("data",users);
        res.put("recordsTotal",count);
        res.put("recordsFiltered",count);
        String result = new Gson().toJson(res);
        return result;
    }

}
