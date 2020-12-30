package com.wxd.my_mall.dto;

import com.wxd.my_mall.mbg.model.OmsOrder;
import com.wxd.my_mall.mbg.model.OmsOrderItem;
import com.wxd.my_mall.mbg.model.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 *
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    @ApiModelProperty("订单商品列表")
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    @ApiModelProperty("订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}
