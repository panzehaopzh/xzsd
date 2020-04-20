package com.xzsd.pc.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVo;
import com.xzsd.pc.user.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CustomerService
 * @Description 客户管理
 * @author panzehao
 * @date 2020-04-11
 */
@Service
public class CustomerService {

    @Resource
    private CustomerDao customerDao;

    @Resource
    private UserDao userDao;

    /**
     * customer 查询客户列表
     * @param customerInfo
     * @return 客户列表
     * @author panzehao
     * @date 2020-04-11
     */
    public AppResponse listCustomer(CustomerInfo customerInfo){
        PageHelper.startPage(customerInfo.getPageNum(),customerInfo.getPageSize());
        //获取用户角色
        customerInfo.setRole(userDao.getRoleById(customerInfo.getUserId()));
        List<CustomerVo> customerVoList = customerDao.listCustomer(customerInfo);
        //包装Page对象
        PageInfo<CustomerVo> pageDate = new PageInfo<>(customerVoList);
        return AppResponse.success("查询成功！",pageDate);
    }
}
