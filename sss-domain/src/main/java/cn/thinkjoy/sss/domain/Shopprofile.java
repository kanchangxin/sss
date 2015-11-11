/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Shopprofile.java 2015-11-11 11:46:43 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.CreateBaseDomain;

import java.util.*;

public class Shopprofile extends CreateBaseDomain<Integer>{
    /**  */
    private String keyType;
    /**  */
    private String keyName;
    /**  */
    private String keyValue;
    /**  */
    private String valueUnit;
    /**  */
    private Long creatDate;

	public Shopprofile(){
	}
    public void setKeyType(String value) {
        this.keyType = value;
    }

    public String getKeyType() {
        return this.keyType;
    }
    public void setKeyName(String value) {
        this.keyName = value;
    }

    public String getKeyName() {
        return this.keyName;
    }
    public void setKeyValue(String value) {
        this.keyValue = value;
    }

    public String getKeyValue() {
        return this.keyValue;
    }
    public void setValueUnit(String value) {
        this.valueUnit = value;
    }

    public String getValueUnit() {
        return this.valueUnit;
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
			.append("KeyType",getKeyType())
			.append("KeyName",getKeyName())
			.append("KeyValue",getKeyValue())
			.append("ValueUnit",getValueUnit())
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
		if(obj instanceof Shopprofile == false) return false;
		if(this == obj) return true;
		Shopprofile other = (Shopprofile)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

