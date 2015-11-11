/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Postrecord.java 2015-11-11 11:46:41 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.BaseDomain;

import java.util.*;

public class Postrecord extends BaseDomain<Integer>{
    /**  */
    private Integer shopHistoryId;
    /**  */
    private Integer postId;
    /**  */
    private Double salary;

	public Postrecord(){
	}
    public void setShopHistoryId(Integer value) {
        this.shopHistoryId = value;
    }

    public Integer getShopHistoryId() {
        return this.shopHistoryId;
    }
    public void setPostId(Integer value) {
        this.postId = value;
    }

    public Integer getPostId() {
        return this.postId;
    }
    public void setSalary(Double value) {
        this.salary = value;
    }

    public Double getSalary() {
        return this.salary;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ShopHistoryId",getShopHistoryId())
			.append("PostId",getPostId())
			.append("Salary",getSalary())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Postrecord == false) return false;
		if(this == obj) return true;
		Postrecord other = (Postrecord)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

