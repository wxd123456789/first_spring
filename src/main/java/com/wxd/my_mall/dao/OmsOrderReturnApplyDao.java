package com.wxd.my_mall.dao;

import com.wxd.my_mall.dto.OmsOrderReturnApplyResult;
import com.wxd.my_mall.dto.OmsReturnApplyQueryParam;
import com.wxd.my_mall.mbg.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单退货申请自定义Dao
 *
 */
public interface OmsOrderReturnApplyDao {
    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id") Long id);
}
