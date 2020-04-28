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
     * @param customerVo
     * @return 客户列表
     * @author panzehao
     * @date 2020-04-11
     */
    public AppResponse listCustomer(CustomerVo customerVo){
        PageHelper.startPage(customerVo.getPageNum(),customerVo.getPageSize());
        //获取用户角色
        customerVo.setRole(userDao.getRoleById(customerVo.getUserId()));
        List<CustomerVo> customerVoList = customerDao.listCustomerByPage(customerVo);
        //包装Page对象
        PageInfo<CustomerVo> pageDate = new PageInfo<CustomerVo>(customerVoList);
        return AppResponse.success("查询成功！",pageDate);
    }
}
