/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  RoleUserController.java 2015-11-06 15:47:20 $
 */

package cn.thinkjoy.sss.controller;

import cn.thinkjoy.common.managerui.service.IRoleUserService;
import cn.thinkjoy.common.managerui.dao.IResourceGridDAO;
import cn.thinkjoy.common.managerui.service.IResourceGridService;
import cn.thinkjoy.common.domain.view.BizData4Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import cn.thinkjoy.common.managerui.controller.AbstractAdminController;

@Controller
@RequestMapping(value="/admin/sss")
public class RoleUserController extends AbstractAdminController<IRoleUserService>{


    @Autowired
    private IRoleUserService roleUserService;

    /**
     * 页面主请求
     * @param request
     * @param response
     * @return  返回菜单数据、表格描述元数据、当前主描述  如本页面为org
     */
    @RequestMapping(value="/roleuser")
    public ModelAndView renderMainView(HttpServletRequest request,HttpServletResponse response){


        return doRenderMainView(request, response);
    }

    /**
     * 获取所有的组织信息
     * @return
     */
    @RequestMapping(value="/roleusers")
    @ResponseBody
    public BizData4Page findAllRoleUsers(HttpServletRequest request,HttpServletResponse response){
        return doPage(request, response);
    }

    @Override
    protected IRoleUserService getMainService() {
        return roleUserService;
    }

    @Override
    protected String getBizSys() {
        return "sss";
    }

    @Override
    protected String getMainObjName() {
        return "roleuser";
    }

    @Override
    protected String getViewTitle() {
        return "用户角色分配";
    }

    @Override
    protected String getParentTitle() {
        return "基础管理";
    }

    @Override
    public boolean getEnableDataPerm() {
        return true;
    }
}
