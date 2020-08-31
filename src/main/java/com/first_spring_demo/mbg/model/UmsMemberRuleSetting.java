package com.first_spring_demo.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class UmsMemberRuleSetting implements Serializable {
    private Long id;

    @ApiModelProperty(value = "è¿žç»­ç­¾åˆ°å¤©æ•°")
    private Integer continueSignDay;

    @ApiModelProperty(value = "è¿žç»­ç­¾åˆ°èµ é€æ•°é‡")
    private Integer continueSignPoint;

    @ApiModelProperty(value = "æ¯æ¶ˆè´¹å¤šå°‘å…ƒèŽ·å–1ä¸ªç‚¹")
    private BigDecimal consumePerPoint;

    @ApiModelProperty(value = "æœ€ä½ŽèŽ·å–ç‚¹æ•°çš„è®¢å•é‡‘é¢")
    private BigDecimal lowOrderAmount;

    @ApiModelProperty(value = "æ¯ç¬”è®¢å•æœ€é«˜èŽ·å–ç‚¹æ•°")
    private Integer maxPointPerOrder;

    @ApiModelProperty(value = "ç±»åž‹ï¼š0->ç§¯åˆ†è§„åˆ™ï¼›1->æˆé•¿å€¼è§„åˆ™")
    private Integer type;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getContinueSignDay() {
        return continueSignDay;
    }

    public void setContinueSignDay(Integer continueSignDay) {
        this.continueSignDay = continueSignDay;
    }

    public Integer getContinueSignPoint() {
        return continueSignPoint;
    }

    public void setContinueSignPoint(Integer continueSignPoint) {
        this.continueSignPoint = continueSignPoint;
    }

    public BigDecimal getConsumePerPoint() {
        return consumePerPoint;
    }

    public void setConsumePerPoint(BigDecimal consumePerPoint) {
        this.consumePerPoint = consumePerPoint;
    }

    public BigDecimal getLowOrderAmount() {
        return lowOrderAmount;
    }

    public void setLowOrderAmount(BigDecimal lowOrderAmount) {
        this.lowOrderAmount = lowOrderAmount;
    }

    public Integer getMaxPointPerOrder() {
        return maxPointPerOrder;
    }

    public void setMaxPointPerOrder(Integer maxPointPerOrder) {
        this.maxPointPerOrder = maxPointPerOrder;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", continueSignDay=").append(continueSignDay);
        sb.append(", continueSignPoint=").append(continueSignPoint);
        sb.append(", consumePerPoint=").append(consumePerPoint);
        sb.append(", lowOrderAmount=").append(lowOrderAmount);
        sb.append(", maxPointPerOrder=").append(maxPointPerOrder);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}