/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  DemoController.java 2015-11-06 15:47:17 $
 */

package cn.thinkjoy.sss.controller;

import cn.thinkjoy.sss.service.IDemoService;
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
public class DemoController extends AbstractAdminController<IDemoService>{


    @Autowired
    private IDemoService demoService;

    /**
     * 页面主请求
     * @param request
     * @param response
     * @return  返回菜单数据、表格描述元数据、当前主描述  如本页面为org
     */
    @RequestMapping(value="/demo")
    public ModelAndView renderMainView(HttpServletRequest request,HttpServletResponse response){


        return doRenderMainView(request, response);
    }

    /**
     * 获取所有的组织信息
     * @return
     */
    @RequestMapping(value="/demos")
    @ResponseBody
    public BizData4Page findAllDemos(HttpServletRequest request,HttpServletResponse response){
        return doPage(request, response);
    }

    @Override
    protected IDemoService getMainService() {
        return demoService;
    }

    @Override
    protected String getBizSys() {
        return "sss";
    }

    @Override
    protected String getMainObjName() {
        return "demo";
    }

    @Override
    protected String getViewTitle() {
        return "范例代码";
    }

    @Override
    protected String getParentTitle() {
        return "范例代码管理";
    }

    @Override
    public boolean getEnableDataPerm() {
        return true;
    }
}
