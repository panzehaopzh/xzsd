package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName CustomerDao
 * @Description customer
 * @author panzehao
 * @date 2020-03-10
 */
@Mapper
public interface CustomerDao {
    /**
     * 查询客户列表
     * @param customerInfo
     * @return 客户列表
     */
    List<CustomerVo> listCustomer(CustomerInfo customerInfo);
}
