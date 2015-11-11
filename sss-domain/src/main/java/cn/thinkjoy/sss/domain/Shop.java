/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Shop.java 2015-11-11 11:46:42 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.CreateBaseDomain;

import java.util.*;

public class Shop extends CreateBaseDomain<Integer>{
    /**  */
    private String shopName;
    /**  */
    private String difficulty;
    /**  */
    private Double roundBest;
    /**  */
    private Double overallBest;
    /**  */
    private Long creatDate;

	public Shop(){
	}
    public void setShopName(String value) {
        this.shopName = value;
    }

    public String getShopName() {
        return this.shopName;
    }
    public void setDifficulty(String value) {
        this.difficulty = value;
    }

    public String getDifficulty() {
        return this.difficulty;
    }
    public void setRoundBest(Double value) {
        this.roundBest = value;
    }

    public Double getRoundBest() {
        return this.roundBest;
    }
    public void setOverallBest(Double value) {
        this.overallBest = value;
    }

    public Double getOverallBest() {
        return this.overallBest;
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
			.append("ShopName",getShopName())
			.append("Difficulty",getDifficulty())
			.append("RoundBest",getRoundBest())
			.append("OverallBest",getOverallBest())
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
		if(obj instanceof Shop == false) return false;
		if(this == obj) return true;
		Shop other = (Shop)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

