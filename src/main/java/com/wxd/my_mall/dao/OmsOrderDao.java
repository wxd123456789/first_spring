package com.wxd.my_mall.dao;

import com.wxd.my_mall.dto.OmsOrderDeliveryParam;
import com.wxd.my_mall.dto.OmsOrderDetail;
import com.wxd.my_mall.dto.OmsOrderQueryParam;
import com.wxd.my_mall.mbg.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 *
 */
public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
