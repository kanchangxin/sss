/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Purchaserecord.java 2015-11-11 11:46:42 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.BaseDomain;

import java.util.*;

public class Purchaserecord extends BaseDomain<Integer>{
    /**  */
    private Integer shopHistoryId;
    /**  */
    private Integer materialsId;
    /**  */
    private Double price;
    /**  */
    private Double purchaseAmount;
    /**  */
    private Double purchaseSubtotal;
    /**  */
    private Double usageAmount;
    /**  */
    private Double usageSubtota;
    /**  */
    private Double stockAmount;
    /**  */
    private Double stockSubtotal;
    /**  */
    private Long expiredTime;
    /**  */
    private Long purchaseDate;

	public Purchaserecord(){
	}
    public void setShopHistoryId(Integer value) {
        this.shopHistoryId = value;
    }

    public Integer getShopHistoryId() {
        return this.shopHistoryId;
    }
    public void setMaterialsId(Integer value) {
        this.materialsId = value;
    }

    public Integer getMaterialsId() {
        return this.materialsId;
    }
    public void setPrice(Double value) {
        this.price = value;
    }

    public Double getPrice() {
        return this.price;
    }
    public void setPurchaseAmount(Double value) {
        this.purchaseAmount = value;
    }

    public Double getPurchaseAmount() {
        return this.purchaseAmount;
    }
    public void setPurchaseSubtotal(Double value) {
        this.purchaseSubtotal = value;
    }

    public Double getPurchaseSubtotal() {
        return this.purchaseSubtotal;
    }
    public void setUsageAmount(Double value) {
        this.usageAmount = value;
    }

    public Double getUsageAmount() {
        return this.usageAmount;
    }
    public void setUsageSubtota(Double value) {
        this.usageSubtota = value;
    }

    public Double getUsageSubtota() {
        return this.usageSubtota;
    }
    public void setStockAmount(Double value) {
        this.stockAmount = value;
    }

    public Double getStockAmount() {
        return this.stockAmount;
    }
    public void setStockSubtotal(Double value) {
        this.stockSubtotal = value;
    }

    public Double getStockSubtotal() {
        return this.stockSubtotal;
    }
    public void setExpiredTime(Long value) {
        this.expiredTime = value;
    }

    public Long getExpiredTime() {
        return this.expiredTime;
    }
    public void setPurchaseDate(Long value) {
        this.purchaseDate = value;
    }

    public Long getPurchaseDate() {
        return this.purchaseDate;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ShopHistoryId",getShopHistoryId())
			.append("MaterialsId",getMaterialsId())
			.append("Price",getPrice())
			.append("PurchaseAmount",getPurchaseAmount())
			.append("PurchaseSubtotal",getPurchaseSubtotal())
			.append("UsageAmount",getUsageAmount())
			.append("UsageSubtota",getUsageSubtota())
			.append("StockAmount",getStockAmount())
			.append("StockSubtotal",getStockSubtotal())
			.append("ExpiredTime",getExpiredTime())
			.append("PurchaseDate",getPurchaseDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Purchaserecord == false) return false;
		if(this == obj) return true;
		Purchaserecord other = (Purchaserecord)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

