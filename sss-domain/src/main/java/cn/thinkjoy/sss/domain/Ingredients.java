/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Ingredients.java 2015-11-11 11:46:39 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.CreateBaseDomain;

import java.util.*;

public class Ingredients extends CreateBaseDomain<Integer>{
    /**  */
    private Integer productId;
    /**  */
    private Integer materialsId;
    /**  */
    private Double consumption;
    /**  */
    private Long creatDate;

	public Ingredients(){
	}
    public void setProductId(Integer value) {
        this.productId = value;
    }

    public Integer getProductId() {
        return this.productId;
    }
    public void setMaterialsId(Integer value) {
        this.materialsId = value;
    }

    public Integer getMaterialsId() {
        return this.materialsId;
    }
    public void setConsumption(Double value) {
        this.consumption = value;
    }

    public Double getConsumption() {
        return this.consumption;
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
			.append("ProductId",getProductId())
			.append("MaterialsId",getMaterialsId())
			.append("Consumption",getConsumption())
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
		if(obj instanceof Ingredients == false) return false;
		if(this == obj) return true;
		Ingredients other = (Ingredients)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

