package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.dictionary.DictionaryInfo;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.store.entity.StoreDTO;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVo;
import com.xzsd.pc.user.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StoreService
 * @Description 门店管理
 * @author panzehao
 * @date 2020-04-12
 */
@Service
public class StoreService {

    @Resource
    private StoreDao storeDao;

    @Resource
    private UserDao userDao;

    /**
     * store 新增门店
     * @param storeInfo
     * @return
     * @author panzehao
     * @date 2020-04-12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo){
        //检验店长编号是否存在
        int countUserCode = storeDao.countUserCode(storeInfo);
        if(0 == countUserCode){
            return AppResponse.bizError("该店长编号不存在，请重新输入！");
        }
        //检验店长是否已绑定门店
        int countStore = storeDao.countStore(storeInfo);
        if(0 != countStore){
            return AppResponse.bizError("该店长已有门店存在，请重新输入！");
        }
        //检验营业执照编码是否存在
        int countBusiness = storeDao.countBusiness(storeInfo);
        if(0 != countBusiness){
            return AppResponse.bizError("该营业执照编码已存在，请重新输入！");
        }
        storeInfo.setStoreId(StringUtil.getCommonCode(2));
        storeInfo.setInviteCode(StringUtil.getInviteCode());
        ///新增门店
        int count = storeDao.addStore(storeInfo);
        if(0 == count){
            return AppResponse.versionError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * store 修改门店信息
     * @param storeInfo
     * @return
     * @author panzehao
     * @date 2020-04-12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo){
        //检验店长编号是否存在
        int countUserCode = storeDao.countUserCode(storeInfo);
        if(0 == countUserCode){
            return AppResponse.bizError("该店长编号不存在，请重新输入！");
        }
        //检验店长是否已绑定门店
        int countStore = storeDao.countStore(storeInfo);
        if(0 != countStore){
            return AppResponse.bizError("该店长已有门店存在，请重新输入！");
        }
        //检验营业执照编码是否存在
        int countBusiness = storeDao.countBusiness(storeInfo);
        if(0 != countBusiness){
            return AppResponse.bizError("该营业执照编码已存在，请重新输入！");
        }
        //修改门店信息
        int count = storeDao.updateStore(storeInfo);
        if(0 == count){
            return AppResponse.versionError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * store 删除门店
     * @param storeId
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeId,String userId){
        List<String> listCode = Arrays.asList(storeId.split(","));
        //删除门店
        int count = storeDao.deleteStore(listCode,userId);
        if(0 == count){
            return AppResponse.versionError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * store 查询门店信息详情
     * @param storeId
     * @return
     * @author panzehao
     * @date 2020-04-12
     */
    public AppResponse getStore(String storeId){
        StoreVo storeVo = storeDao.getStore(storeId);
        return AppResponse.success("查询成功！",storeVo);
    }

    /**
     * store 查询门店信息列表
     * @param storeInfo
     * @return
     * @author panzehao
     * @date 2020-04-12
     */
    public AppResponse listStore(StoreInfo storeInfo){
        PageHelper.startPage(storeInfo.getPageNum(),storeInfo.getPageSize());
        //获取登录用户的角色
        storeInfo.setRole(userDao.getRoleById(storeInfo.getUserId()));
        List<StoreDTO> storeDTOList = storeDao.listStore(storeInfo);
        //包装Page对象
        PageInfo<StoreDTO> pageDate = new PageInfo<>(storeDTOList);
        return AppResponse.success("查询成功！",pageDate);
    }

    /**
     * store 查询省市区列表
     * @param areaId
     * @return
     * @author panzehao
     * @date 2020-04-12
     */
    public AppResponse listArea(String areaId){
        List<AreaInfo> areaList = storeDao.listArea(areaId);
        return AppResponse.success("查询成功！",areaList);
    }
}
