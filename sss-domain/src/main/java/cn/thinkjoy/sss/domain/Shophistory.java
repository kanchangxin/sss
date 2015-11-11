/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Shophistory.java 2015-11-11 11:46:42 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.CreateBaseDomain;

import java.util.*;

public class Shophistory extends CreateBaseDomain<Integer>{
    /**  */
    private Integer shopId;
    /**  */
    private Long recordDate;
    /**  */
    private Integer round;
    /**  */
    private Double beginBalance;
    /**  */
    private Double endBalance;
    /**  */
    private Double revenues;
    /**  */
    private Double consumeCost;
    /**  */
    private Double marketingCost;
    /**  */
    private Integer employeeNum;
    /**  */
    private Double salaryCost;
    /**  */
    private Double rentCost;
    /**  */
    private Double depreciationCost;
    /**  */
    private Double interestCost;
    /**  */
    private Double miscCost;
    /**  */
    private Long creatDate;

	public Shophistory(){
	}
    public void setShopId(Integer value) {
        this.shopId = value;
    }

    public Integer getShopId() {
        return this.shopId;
    }
    public void setRecordDate(Long value) {
        this.recordDate = value;
    }

    public Long getRecordDate() {
        return this.recordDate;
    }
    public void setRound(Integer value) {
        this.round = value;
    }

    public Integer getRound() {
        return this.round;
    }
    public void setBeginBalance(Double value) {
        this.beginBalance = value;
    }

    public Double getBeginBalance() {
        return this.beginBalance;
    }
    public void setEndBalance(Double value) {
        this.endBalance = value;
    }

    public Double getEndBalance() {
        return this.endBalance;
    }
    public void setRevenues(Double value) {
        this.revenues = value;
    }

    public Double getRevenues() {
        return this.revenues;
    }
    public void setConsumeCost(Double value) {
        this.consumeCost = value;
    }

    public Double getConsumeCost() {
        return this.consumeCost;
    }
    public void setMarketingCost(Double value) {
        this.marketingCost = value;
    }

    public Double getMarketingCost() {
        return this.marketingCost;
    }
    public void setEmployeeNum(Integer value) {
        this.employeeNum = value;
    }

    public Integer getEmployeeNum() {
        return this.employeeNum;
    }
    public void setSalaryCost(Double value) {
        this.salaryCost = value;
    }

    public Double getSalaryCost() {
        return this.salaryCost;
    }
    public void setRentCost(Double value) {
        this.rentCost = value;
    }

    public Double getRentCost() {
        return this.rentCost;
    }
    public void setDepreciationCost(Double value) {
        this.depreciationCost = value;
    }

    public Double getDepreciationCost() {
        return this.depreciationCost;
    }
    public void setInterestCost(Double value) {
        this.interestCost = value;
    }

    public Double getInterestCost() {
        return this.interestCost;
    }
    public void setMiscCost(Double value) {
        this.miscCost = value;
    }

    public Double getMiscCost() {
        return this.miscCost;
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
			.append("ShopId",getShopId())
			.append("RecordDate",getRecordDate())
			.append("Round",getRound())
			.append("BeginBalance",getBeginBalance())
			.append("EndBalance",getEndBalance())
			.append("Revenues",getRevenues())
			.append("ConsumeCost",getConsumeCost())
			.append("MarketingCost",getMarketingCost())
			.append("EmployeeNum",getEmployeeNum())
			.append("SalaryCost",getSalaryCost())
			.append("RentCost",getRentCost())
			.append("DepreciationCost",getDepreciationCost())
			.append("InterestCost",getInterestCost())
			.append("MiscCost",getMiscCost())
			.append("Creator",getCreator())
			.append("CreatDate",getCreatDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Shophistory == false) return false;
		if(this == obj) return true;
		Shophistory other = (Shophistory)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

