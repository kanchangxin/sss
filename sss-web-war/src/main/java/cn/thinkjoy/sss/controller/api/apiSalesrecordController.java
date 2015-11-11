/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  SalesrecordController.java 2015-11-11 11:46:42 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.ISalesrecordService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;


import cn.thinkjoy.sss.domain.Salesrecord;
import cn.thinkjoy.sss.service.ISalesrecordService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/api")
public class apiSalesrecordController{
    private static final Logger logger = LoggerFactory.getLogger(apiSalesrecordController.class);

    @Autowired
    private ISalesrecordService salesrecordService;

   /**
     * 新增 资源
     * @param salesrecord
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/salesrecord", method = RequestMethod.POST)
    public Object addSalesrecord(@RequestBody Salesrecord salesrecord) {
        try {
            String msg = "";

            if(salesrecord==null) {
                msg = "添加资源参数不正确";
            }else if(salesrecord.getShopHistoryId() != null){
                msg = "资源不能为空";
            }else if(salesrecord.getProductId() != null){
                msg = "资源不能为空";
            }else if(salesrecord.getPrice() != null){
                msg = "资源不能为空";
            }else if(salesrecord.getSalesVolume() != null){
                msg = "资源不能为空";
            }else if(salesrecord.getSubtotal() != null){
                msg = "资源不能为空";
            }else if(salesrecord.getOutput() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=salesrecordService.add(salesrecord);
            if(row > 0) {
                return new StringWrapper( salesrecord.getId().toString());
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "新增资源异常");
        }
    }


    /**
     * 删除 资源
     *
     * @param {salesrecordId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/salesrecord/{salesrecordId}" ,method = RequestMethod.DELETE)
    public Object delSalesrecord(@PathVariable String salesrecordId) {
        try {
            if(StringUtils.isBlank(salesrecordId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=salesrecordService.deleteByProperty("id", salesrecordId);
            if(row > 0) {
                return new StringWrapper( "删除资源成功" );
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源异常");
        }
    }


    /**
     * 修改资源数据
     * @param salesrecord 提交上来的资源JSON数据
     * @param salesrecordId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/salesrecord/{salesrecordId}", method = RequestMethod.PATCH)
    public StringWrapper editSalesrecord(@RequestBody Salesrecord salesrecord, @PathVariable String salesrecordId) {
        try {
            String msg = "";
            if(salesrecord==null) {
                msg = "添加资源参数不正确";
            }else if(salesrecord.getShopHistoryId() != null){
                msg = "资源不能为空";
            }else if(salesrecord.getProductId() != null){
                msg = "资源不能为空";
            }else if(salesrecord.getPrice() != null){
                msg = "资源不能为空";
            }else if(salesrecord.getSalesVolume() != null){
                msg = "资源不能为空";
            }else if(salesrecord.getSubtotal() != null){
                msg = "资源不能为空";
            }else if(salesrecord.getOutput() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Salesrecord salesrecord_old = (Salesrecord) salesrecordService.findOne("id",salesrecordId);
            if(salesrecord==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(salesrecord.getId() != null){
                salesrecord_old.setId(salesrecord.getId());
            }
            if(salesrecord.getShopHistoryId() != null){
                salesrecord_old.setShopHistoryId(salesrecord.getShopHistoryId());
            }
            if(salesrecord.getProductId() != null){
                salesrecord_old.setProductId(salesrecord.getProductId());
            }
            if(salesrecord.getPrice() != null){
                salesrecord_old.setPrice(salesrecord.getPrice());
            }
            if(salesrecord.getSalesVolume() != null){
                salesrecord_old.setSalesVolume(salesrecord.getSalesVolume());
            }
            if(salesrecord.getSubtotal() != null){
                salesrecord_old.setSubtotal(salesrecord.getSubtotal());
            }
            if(salesrecord.getOutput() != null){
                salesrecord_old.setOutput(salesrecord.getOutput());
            }
            if(salesrecord.getExpiredTime() != null){
                salesrecord_old.setExpiredTime(salesrecord.getExpiredTime());
            }
            if(salesrecord.getSalesDate() != null){
                salesrecord_old.setSalesDate(salesrecord.getSalesDate());
            }


            int row=salesrecordService.edit(salesrecord_old);
            if(row > 0) {
                return new StringWrapper("修改资源成功");
            }else{
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改资源失败");
            }
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改资源数据异常");
        }
    }


    /**
     * 获取单资源实体
     *
     * @param salesrecordId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/salesrecord/{salesrecordId}", method = RequestMethod.GET)
    public Salesrecord getSalesrecord(@PathVariable String salesrecordId) {
        try {
            if(StringUtils.isBlank(salesrecordId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", salesrecordId);
            Salesrecord salesrecord= (Salesrecord) salesrecordService.queryOne(whereParams);
            if(null == salesrecord){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return salesrecord;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "获取单资源实体异常");
        }
    }


    /**
     * 资源数据输出 带分页
     *
     * @param salesrecord 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/salesrecordlist", method = RequestMethod.POST)
    public BizData4Page salesrecordlist(Salesrecord salesrecord, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(salesrecord.getId() != null){
                whereParams.put("id", new SearchField("id", "=", salesrecord.getId()));
            }
            if(salesrecord.getShopHistoryId() != null){
                whereParams.put("shopHistoryId", new SearchField("shopHistoryId", "=", salesrecord.getShopHistoryId()));
            }
            if(salesrecord.getProductId() != null){
                whereParams.put("productId", new SearchField("productId", "=", salesrecord.getProductId()));
            }
            if(salesrecord.getPrice() != null){
                whereParams.put("price", new SearchField("price", "=", salesrecord.getPrice()));
            }
            if(salesrecord.getSalesVolume() != null){
                whereParams.put("salesVolume", new SearchField("salesVolume", "=", salesrecord.getSalesVolume()));
            }
            if(salesrecord.getSubtotal() != null){
                whereParams.put("subtotal", new SearchField("subtotal", "=", salesrecord.getSubtotal()));
            }
            if(salesrecord.getOutput() != null){
                whereParams.put("output", new SearchField("output", "=", salesrecord.getOutput()));
            }
            if(salesrecord.getExpiredTime() != null){
                whereParams.put("expiredTime", new SearchField("expiredTime", "=", salesrecord.getExpiredTime()));
            }
            if(salesrecord.getSalesDate() != null){
                whereParams.put("salesDate", new SearchField("salesDate", "=", salesrecord.getSalesDate()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            salesrecordService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
