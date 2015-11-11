/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  PurchaserecordController.java 2015-11-11 11:46:42 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IPurchaserecordService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;


import cn.thinkjoy.sss.domain.Purchaserecord;
import cn.thinkjoy.sss.service.IPurchaserecordService;

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
public class apiPurchaserecordController{
    private static final Logger logger = LoggerFactory.getLogger(apiPurchaserecordController.class);

    @Autowired
    private IPurchaserecordService purchaserecordService;

   /**
     * 新增 资源
     * @param purchaserecord
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/purchaserecord", method = RequestMethod.POST)
    public Object addPurchaserecord(@RequestBody Purchaserecord purchaserecord) {
        try {
            String msg = "";

            if(purchaserecord==null) {
                msg = "添加资源参数不正确";
            }else if(purchaserecord.getShopHistoryId() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getMaterialsId() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getPrice() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getPurchaseAmount() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getPurchaseSubtotal() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getUsageAmount() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getUsageSubtota() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getStockAmount() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getStockSubtotal() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getPurchaseDate() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=purchaserecordService.add(purchaserecord);
            if(row > 0) {
                return new StringWrapper( purchaserecord.getId().toString());
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
     * @param {purchaserecordId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/purchaserecord/{purchaserecordId}" ,method = RequestMethod.DELETE)
    public Object delPurchaserecord(@PathVariable String purchaserecordId) {
        try {
            if(StringUtils.isBlank(purchaserecordId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=purchaserecordService.deleteByProperty("id", purchaserecordId);
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
     * @param purchaserecord 提交上来的资源JSON数据
     * @param purchaserecordId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/purchaserecord/{purchaserecordId}", method = RequestMethod.PATCH)
    public StringWrapper editPurchaserecord(@RequestBody Purchaserecord purchaserecord, @PathVariable String purchaserecordId) {
        try {
            String msg = "";
            if(purchaserecord==null) {
                msg = "添加资源参数不正确";
            }else if(purchaserecord.getShopHistoryId() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getMaterialsId() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getPrice() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getPurchaseAmount() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getPurchaseSubtotal() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getUsageAmount() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getUsageSubtota() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getStockAmount() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getStockSubtotal() != null){
                msg = "资源不能为空";
            }else if(purchaserecord.getPurchaseDate() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Purchaserecord purchaserecord_old = (Purchaserecord) purchaserecordService.findOne("id",purchaserecordId);
            if(purchaserecord==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(purchaserecord.getId() != null){
                purchaserecord_old.setId(purchaserecord.getId());
            }
            if(purchaserecord.getShopHistoryId() != null){
                purchaserecord_old.setShopHistoryId(purchaserecord.getShopHistoryId());
            }
            if(purchaserecord.getMaterialsId() != null){
                purchaserecord_old.setMaterialsId(purchaserecord.getMaterialsId());
            }
            if(purchaserecord.getPrice() != null){
                purchaserecord_old.setPrice(purchaserecord.getPrice());
            }
            if(purchaserecord.getPurchaseAmount() != null){
                purchaserecord_old.setPurchaseAmount(purchaserecord.getPurchaseAmount());
            }
            if(purchaserecord.getPurchaseSubtotal() != null){
                purchaserecord_old.setPurchaseSubtotal(purchaserecord.getPurchaseSubtotal());
            }
            if(purchaserecord.getUsageAmount() != null){
                purchaserecord_old.setUsageAmount(purchaserecord.getUsageAmount());
            }
            if(purchaserecord.getUsageSubtota() != null){
                purchaserecord_old.setUsageSubtota(purchaserecord.getUsageSubtota());
            }
            if(purchaserecord.getStockAmount() != null){
                purchaserecord_old.setStockAmount(purchaserecord.getStockAmount());
            }
            if(purchaserecord.getStockSubtotal() != null){
                purchaserecord_old.setStockSubtotal(purchaserecord.getStockSubtotal());
            }
            if(purchaserecord.getExpiredTime() != null){
                purchaserecord_old.setExpiredTime(purchaserecord.getExpiredTime());
            }
            if(purchaserecord.getPurchaseDate() != null){
                purchaserecord_old.setPurchaseDate(purchaserecord.getPurchaseDate());
            }


            int row=purchaserecordService.edit(purchaserecord_old);
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
     * @param purchaserecordId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/purchaserecord/{purchaserecordId}", method = RequestMethod.GET)
    public Purchaserecord getPurchaserecord(@PathVariable String purchaserecordId) {
        try {
            if(StringUtils.isBlank(purchaserecordId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", purchaserecordId);
            Purchaserecord purchaserecord= (Purchaserecord) purchaserecordService.queryOne(whereParams);
            if(null == purchaserecord){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return purchaserecord;
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
     * @param purchaserecord 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/purchaserecordlist", method = RequestMethod.POST)
    public BizData4Page purchaserecordlist(Purchaserecord purchaserecord, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(purchaserecord.getId() != null){
                whereParams.put("id", new SearchField("id", "=", purchaserecord.getId()));
            }
            if(purchaserecord.getShopHistoryId() != null){
                whereParams.put("shopHistoryId", new SearchField("shopHistoryId", "=", purchaserecord.getShopHistoryId()));
            }
            if(purchaserecord.getMaterialsId() != null){
                whereParams.put("materialsId", new SearchField("materialsId", "=", purchaserecord.getMaterialsId()));
            }
            if(purchaserecord.getPrice() != null){
                whereParams.put("price", new SearchField("price", "=", purchaserecord.getPrice()));
            }
            if(purchaserecord.getPurchaseAmount() != null){
                whereParams.put("purchaseAmount", new SearchField("purchaseAmount", "=", purchaserecord.getPurchaseAmount()));
            }
            if(purchaserecord.getPurchaseSubtotal() != null){
                whereParams.put("purchaseSubtotal", new SearchField("purchaseSubtotal", "=", purchaserecord.getPurchaseSubtotal()));
            }
            if(purchaserecord.getUsageAmount() != null){
                whereParams.put("usageAmount", new SearchField("usageAmount", "=", purchaserecord.getUsageAmount()));
            }
            if(purchaserecord.getUsageSubtota() != null){
                whereParams.put("usageSubtota", new SearchField("usageSubtota", "=", purchaserecord.getUsageSubtota()));
            }
            if(purchaserecord.getStockAmount() != null){
                whereParams.put("stockAmount", new SearchField("stockAmount", "=", purchaserecord.getStockAmount()));
            }
            if(purchaserecord.getStockSubtotal() != null){
                whereParams.put("stockSubtotal", new SearchField("stockSubtotal", "=", purchaserecord.getStockSubtotal()));
            }
            if(purchaserecord.getExpiredTime() != null){
                whereParams.put("expiredTime", new SearchField("expiredTime", "=", purchaserecord.getExpiredTime()));
            }
            if(purchaserecord.getPurchaseDate() != null){
                whereParams.put("purchaseDate", new SearchField("purchaseDate", "=", purchaserecord.getPurchaseDate()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            purchaserecordService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
