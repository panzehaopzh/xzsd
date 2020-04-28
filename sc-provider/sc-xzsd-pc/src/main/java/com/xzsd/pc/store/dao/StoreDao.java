package com.xzsd.pc.store.dao;

import com.xzsd.pc.dictionary.DictionaryInfo;
import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.store.entity.StoreDTO;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName StoreDao
 * @Description store
 * @author panzehao
 * @date 2020-04-12
 */
@Mapper
public interface StoreDao {
    /**
     * 检验店长编号是否存在
     * @param storeInfo
     * @return
     */
    int countUserCode(StoreInfo storeInfo);

    /**
     * 检验店长是否已绑定门店
     * @param storeInfo
     * @return
     */
    int countStore(StoreInfo storeInfo);

    /**
     * 检验营业执照编码是否存在
     * @param storeInfo
     * @return
     */
    int countBusiness(StoreInfo storeInfo);

    /**
     * 检验邀请码是否存在
     * @param inviteCode
     * @return
     */
    int countInviteCode(@Param("inviteCode") String inviteCode);

    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    int addStore(StoreInfo storeInfo);

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 删除门店
     * @param listCode 选中的门店编号集合
     * @param userId 更新人
     * @return
     */
    int deleteStore(@Param("listCode")List<String> listCode,@Param("userId") String userId);

    /**
     * 查询门店信息详情
     * @param storeId
     * @return
     */
    StoreVo getStore(@Param("storeId") String storeId);

    /**
     * 查询门店信息列表
     * @param storeInfo
     * @return
     */
    List<StoreDTO> listStoreByPage(StoreInfo storeInfo);

    /**
     * 查询省市区列表
     * @param areaId
     * @return
     */
    List<AreaInfo> listArea(@Param("areaId") String areaId);
}
