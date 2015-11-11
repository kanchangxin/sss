/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Product.java 2015-11-11 11:46:41 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.CreateBaseDomain;

import java.util.*;

public class Product extends CreateBaseDomain<Integer>{
    /**  */
    private String name;
    /**  */
    private Double cost;
    /**  */
    private Double oldPrice;
    /**  */
    private Integer oldSalesVolume;
    /**  */
    private Integer order;
    /**  */
    private Integer shelfLife;
    /**  */
    private Long creatDate;

	public Product(){
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
    public void setOldPrice(Double value) {
        this.oldPrice = value;
    }

    public Double getOldPrice() {
        return this.oldPrice;
    }
    public void setOldSalesVolume(Integer value) {
        this.oldSalesVolume = value;
    }

    public Integer getOldSalesVolume() {
        return this.oldSalesVolume;
    }
    public void setOrder(Integer value) {
        this.order = value;
    }

    public Integer getOrder() {
        return this.order;
    }
    public void setShelfLife(Integer value) {
        this.shelfLife = value;
    }

    public Integer getShelfLife() {
        return this.shelfLife;
    }
    public void setCreatDate(Long value) {
        this.creatDate = value;
    }

    public Long getCreatDate() {
        return this.creatDate;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("Cost",getCost())
			.append("OldPrice",getOldPrice())
			.append("OldSalesVolume",getOldSalesVolume())
			.append("Order",getOrder())
			.append("ShelfLife",getShelfLife())
			.append("Creator",getCreator())
			.append("CreatDate",getCreatDate())
			.append("LastModifier",getLastModifier())
			.append("LastModDate",getLastModDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Product == false) return false;
		if(this == obj) return true;
		Product other = (Product)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

