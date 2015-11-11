/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Marketingrecord.java 2015-11-11 11:46:40 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.BaseDomain;

import java.util.*;

public class Marketingrecord extends BaseDomain<Integer>{
    /**  */
    private Integer shopHistoryId;
    /**  */
    private Integer marketingId;
    /**  */
    private Double cost;
    /**  */
    private Double activEffect;

	public Marketingrecord(){
	}
    public void setShopHistoryId(Integer value) {
        this.shopHistoryId = value;
    }

    public Integer getShopHistoryId() {
        return this.shopHistoryId;
    }
    public void setMarketingId(Integer value) {
        this.marketingId = value;
    }

    public Integer getMarketingId() {
        return this.marketingId;
    }
    public void setCost(Double value) {
        this.cost = value;
    }

    public Double getCost() {
        return this.cost;
    }
    public void setActivEffect(Double value) {
        this.activEffect = value;
    }

    public Double getActivEffect() {
        return this.activEffect;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ShopHistoryId",getShopHistoryId())
			.append("MarketingId",getMarketingId())
			.append("Cost",getCost())
			.append("ActivEffect",getActivEffect())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Marketingrecord == false) return false;
		if(this == obj) return true;
		Marketingrecord other = (Marketingrecord)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

