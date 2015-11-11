/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Materials.java 2015-11-11 11:46:41 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.CreateBaseDomain;

import java.util.*;

public class Materials extends CreateBaseDomain<Integer>{
    /**  */
    private String name;
    /**  */
    private String unit;
    /**  */
    private Integer shelfLife;
    /**  */
    private Integer order;
    /**  */
    private Long creatDate;

	public Materials(){
	}
    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }
    public void setUnit(String value) {
        this.unit = value;
    }

    public String getUnit() {
        return this.unit;
    }
    public void setShelfLife(Integer value) {
        this.shelfLife = value;
    }

    public Integer getShelfLife() {
        return this.shelfLife;
    }
    public void setOrder(Integer value) {
        this.order = value;
    }

    public Integer getOrder() {
        return this.order;
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
			.append("Unit",getUnit())
			.append("ShelfLife",getShelfLife())
			.append("Order",getOrder())
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
		if(obj instanceof Materials == false) return false;
		if(this == obj) return true;
		Materials other = (Materials)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

