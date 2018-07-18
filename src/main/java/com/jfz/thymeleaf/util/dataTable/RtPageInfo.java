package com.jfz.thymeleaf.util.dataTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/10 17:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RtPageInfo<T> {
    protected List<T> data;
    protected Integer pageNum;
    protected Integer totalCount;
    protected Integer pageSize;
}
