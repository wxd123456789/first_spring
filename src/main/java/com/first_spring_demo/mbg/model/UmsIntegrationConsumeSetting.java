package com.first_spring_demo.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsIntegrationConsumeSetting implements Serializable {
    private Long id;

    @ApiModelProperty(value = "æ¯ä¸€å…ƒéœ€è¦æŠµæ‰£çš„ç§¯åˆ†æ•°é‡")
    private Integer deductionPerAmount;

    @ApiModelProperty(value = "æ¯ç¬”è®¢å•æœ€é«˜æŠµç”¨ç™¾åˆ†æ¯”")
    private Integer maxPercentPerOrder;

    @ApiModelProperty(value = "æ¯æ¬¡ä½¿ç”¨ç§¯åˆ†æœ€å°å•ä½100")
    private Integer useUnit;

    @ApiModelProperty(value = "æ˜¯å¦å¯ä»¥å’Œä¼˜æƒ åˆ¸åŒç”¨ï¼›0->ä¸å¯ä»¥ï¼›1->å¯ä»¥")
    private Integer couponStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeductionPerAmount() {
        return deductionPerAmount;
    }

    public void setDeductionPerAmount(Integer deductionPerAmount) {
        this.deductionPerAmount = deductionPerAmount;
    }

    public Integer getMaxPercentPerOrder() {
        return maxPercentPerOrder;
    }

    public void setMaxPercentPerOrder(Integer maxPercentPerOrder) {
        this.maxPercentPerOrder = maxPercentPerOrder;
    }

    public Integer getUseUnit() {
        return useUnit;
    }

    public void setUseUnit(Integer useUnit) {
        this.useUnit = useUnit;
    }

    public Integer getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deductionPerAmount=").append(deductionPerAmount);
        sb.append(", maxPercentPerOrder=").append(maxPercentPerOrder);
        sb.append(", useUnit=").append(useUnit);
        sb.append(", couponStatus=").append(couponStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}