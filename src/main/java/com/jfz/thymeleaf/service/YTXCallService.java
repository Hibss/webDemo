package com.jfz.thymeleaf.service;

import com.jfz.thymeleaf.mapper.cc.YTXCallBackMapper;
import com.jfz.thymeleaf.mapper.cc.YTXCallRecordMapper;
import com.jfz.thymeleaf.model.YTXCallBack;
import com.jfz.thymeleaf.model.YTXCallRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/3/6 11:39
 */
@Slf4j
@Service
public class YTXCallService {

    @Autowired
    private YTXCallRecordMapper ytxCallRecordMapper;

    @Autowired
    private YTXCallBackMapper ytxCallBackMapper;


    public List<YTXCallRecord> getUnDownloadCallRecord(Date date) {
        return ytxCallRecordMapper.getUnDownloadCallRecord(date);
    }

    public YTXCallRecord findByCallId(String callId) {
        return ytxCallRecordMapper.findByCallId(callId);
    }

    public List<YTXCallRecord> getAllUndownloadFile() {
        return ytxCallRecordMapper.getAllUnDownloadCallRecord();
    }

    public List<YTXCallBack> getAllCallBack() {
        return ytxCallBackMapper.getAll();
    }
}
