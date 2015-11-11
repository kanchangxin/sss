/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Salesrecord.java 2015-11-11 11:46:42 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.BaseDomain;

import java.util.*;

public class Salesrecord extends BaseDomain<Integer>{
    /**  */
    private Integer shopHistoryId;
    /**  */
    private Integer productId;
    /**  */
    private Double price;
    /**  */
    private Double salesVolume;
    /**  */
    private Double subtotal;
    /**  */
    private Double output;
    /**  */
    private Long expiredTime;
    /**  */
    private Long salesDate;

	public Salesrecord(){
	}
    public void setShopHistoryId(Integer value) {
        this.shopHistoryId = value;
    }

    public Integer getShopHistoryId() {
        return this.shopHistoryId;
    }
    public void setProductId(Integer value) {
        this.productId = value;
    }

    public Integer getProductId() {
        return this.productId;
    }
    public void setPrice(Double value) {
        this.price = value;
    }

    public Double getPrice() {
        return this.price;
    }
    public void setSalesVolume(Double value) {
        this.salesVolume = value;
    }

    public Double getSalesVolume() {
        return this.salesVolume;
    }
    public void setSubtotal(Double value) {
        this.subtotal = value;
    }

    public Double getSubtotal() {
        return this.subtotal;
    }
    public void setOutput(Double value) {
        this.output = value;
    }

    public Double getOutput() {
        return this.output;
    }
    public void setExpiredTime(Long value) {
        this.expiredTime = value;
    }

    public Long getExpiredTime() {
        return this.expiredTime;
    }
    public void setSalesDate(Long value) {
        this.salesDate = value;
    }

    public Long getSalesDate() {
        return this.salesDate;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ShopHistoryId",getShopHistoryId())
			.append("ProductId",getProductId())
			.append("Price",getPrice())
			.append("SalesVolume",getSalesVolume())
			.append("Subtotal",getSubtotal())
			.append("Output",getOutput())
			.append("ExpiredTime",getExpiredTime())
			.append("SalesDate",getSalesDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Salesrecord == false) return false;
		if(this == obj) return true;
		Salesrecord other = (Salesrecord)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

