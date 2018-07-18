package com.jfz.thymeleaf.service;

import com.jfz.thymeleaf.mapper.PageInfo.Page;
import com.jfz.thymeleaf.mapper.erp.CallRecordMapper;
import com.jfz.thymeleaf.model.CallRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/22 15:24
 */
@Service
@Slf4j
public class CallRecordService {

    @Autowired
    private CallRecordMapper callRecordMapper;


    public List<CallRecord> getPageList(Page page, CallRecord record) {
        return callRecordMapper.getPageList(page,record);
    }

    public Long getCount(CallRecord record) {
        return callRecordMapper.getCount(record);
    }
}
