/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  IngredientsService.java 2015-11-11 11:46:39 $
 */

package cn.thinkjoy.sss.service;
import cn.thinkjoy.common.dao.IBaseDAO;
import cn.thinkjoy.common.domain.BaseDomain;
import cn.thinkjoy.common.service.IBaseService;
import cn.thinkjoy.common.service.IPageService;

public interface IIngredientsService<D extends IBaseDAO<T>, T extends BaseDomain> extends IBaseService<D, T>,IPageService<D, T>{

}
