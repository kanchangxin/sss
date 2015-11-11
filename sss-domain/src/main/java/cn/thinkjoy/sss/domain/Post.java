/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  Post.java 2015-11-11 11:46:41 $
 */





package cn.thinkjoy.sss.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.CreateBaseDomain;

import java.util.*;

public class Post extends CreateBaseDomain<Integer>{
    /**  */
    private String name;
    /**  */
    private Double salary;
    /**  */
    private String desc;
    /**  */
    private Long creatDate;

	public Post(){
	}
    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }
    public void setSalary(Double value) {
        this.salary = value;
    }

    public Double getSalary() {
        return this.salary;
    }
    public void setDesc(String value) {
        this.desc = value;
    }

    public String getDesc() {
        return this.desc;
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
			.append("Salary",getSalary())
			.append("Desc",getDesc())
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
		if(obj instanceof Post == false) return false;
		if(this == obj) return true;
		Post other = (Post)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

