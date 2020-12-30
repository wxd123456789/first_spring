package com.wxd.my_mall.services;

import com.wxd.my_mall.dto.OmsOrderReturnApplyResult;
import com.wxd.my_mall.dto.OmsReturnApplyQueryParam;
import com.wxd.my_mall.dto.OmsUpdateStatusParam;
import com.wxd.my_mall.mbg.model.OmsOrderReturnApply;

import java.util.List;

/**
 * 退货申请管理Service

 */
public interface OmsOrderReturnApplyService {
    /**
     * 分页查询申请
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量删除申请
     */
    int delete(List<Long> ids);

    /**
     * 修改申请状态
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

    /**
     * 获取指定申请详情
     */
    OmsOrderReturnApplyResult getItem(Long id);
}
