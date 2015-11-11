/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  DemoController.java 2015-11-06 15:47:17 $
 */

package cn.thinkjoy.sss.controller;


import cn.thinkjoy.common.managerui.controller.helpers.BaseServiceMaps;
import cn.thinkjoy.common.managerui.controller.AbstractCommonController;

import cn.thinkjoy.common.service.IBaseService;
import cn.thinkjoy.sss.common.ServiceMaps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/sss")
public class CommonController extends AbstractCommonController{
    @Autowired
    private ServiceMaps serviceMaps;

    @Override
    protected BaseServiceMaps getServiceMaps() {
        return serviceMaps;
    }

    @Override
    protected IBaseService getExportService() {
        return null;
    }

    @Override
    public boolean getEnableDataPerm() {
        return false;
    }
}
