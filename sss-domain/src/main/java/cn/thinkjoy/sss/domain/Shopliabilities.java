/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Shopliabilities.java 2015-11-11 11:46:42 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.BaseDomain;

import java.util.*;

public class Shopliabilities extends BaseDomain<Integer>{
    /**  */
    private Integer shopId;
    /**  */
    private String name;
    /**  */
    private Double cost;
    /**  */
    private String period;
    /**  */
    private Integer order;
    /**  */
    private Long repaymentDate;
    /**  */
    private Double nterest;
    /**  */
    private Long startDate;
    /**  */
    private Long endDate;

	public Shopliabilities(){
	}
    public void setShopId(Integer value) {
        this.shopId = value;
    }

    public Integer getShopId() {
        return this.shopId;
    }
    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }
    public void setCost(Double value) {
        this.cost = value;
    }

    public Double getCost() {
        return this.cost;
    }
    public void setPeriod(String value) {
        this.period = value;
    }

    public String getPeriod() {
        return this.period;
    }
    public void setOrder(Integer value) {
        this.order = value;
    }

    public Integer getOrder() {
        return this.order;
    }
    public void setRepaymentDate(Long value) {
        this.repaymentDate = value;
    }

    public Long getRepaymentDate() {
        return this.repaymentDate;
    }
    public void setNterest(Double value) {
        this.nterest = value;
    }

    public Double getNterest() {
        return this.nterest;
    }
    public void setStartDate(Long value) {
        this.startDate = value;
    }

    public Long getStartDate() {
        return this.startDate;
    }
    public void setEndDate(Long value) {
        this.endDate = value;
    }

    public Long getEndDate() {
        return this.endDate;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ShopId",getShopId())
			.append("Name",getName())
			.append("Cost",getCost())
			.append("Period",getPeriod())
			.append("Order",getOrder())
			.append("RepaymentDate",getRepaymentDate())
			.append("Nterest",getNterest())
			.append("StartDate",getStartDate())
			.append("EndDate",getEndDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Shopliabilities == false) return false;
		if(this == obj) return true;
		Shopliabilities other = (Shopliabilities)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

