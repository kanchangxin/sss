/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  ShophistoryController.java 2015-11-11 11:46:42 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IShophistoryService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;
import cn.thinkjoy.sss.domain.Shophistory;
import cn.thinkjoy.sss.service.IShophistoryService;

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
public class apiShophistoryController{
    private static final Logger logger = LoggerFactory.getLogger(apiShophistoryController.class);

    @Autowired
    private IShophistoryService shophistoryService;

   /**
     * 新增 资源
     * @param shophistory
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/shophistory", method = RequestMethod.POST)
    public Object addShophistory(@RequestBody Shophistory shophistory) {
        try {
            String msg = "";

            if(shophistory==null) {
                msg = "添加资源参数不正确";
            }else if(shophistory.getShopId() != null){
                msg = "资源不能为空";
            }else if(shophistory.getRecordDate() != null){
                msg = "资源不能为空";
            }else if(shophistory.getRound() != null){
                msg = "资源不能为空";
            }else if(shophistory.getBeginBalance() != null){
                msg = "资源不能为空";
            }else if(shophistory.getEndBalance() != null){
                msg = "资源不能为空";
            }else if(shophistory.getRevenues() != null){
                msg = "资源不能为空";
            }else if(shophistory.getConsumeCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getMarketingCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getEmployeeNum() != null){
                msg = "资源不能为空";
            }else if(shophistory.getSalaryCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getRentCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getDepreciationCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getInterestCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getMiscCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getCreator() != null){
                msg = "资源不能为空";
            }else if(shophistory.getCreatDate() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=shophistoryService.add(shophistory);
            if(row > 0) {
                return new StringWrapper(  shophistory.getId().toString() );
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
     * @param {shophistoryId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/shophistory/{shophistoryId}" ,method = RequestMethod.DELETE)
    public Object delShophistory(@PathVariable String shophistoryId) {
        try {
            if(StringUtils.isBlank(shophistoryId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=shophistoryService.deleteByProperty("id", shophistoryId);
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
     * @param shophistory 提交上来的资源JSON数据
     * @param shophistoryId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/shophistory/{shophistoryId}", method = RequestMethod.PATCH)
    public StringWrapper editShophistory(@RequestBody Shophistory shophistory, @PathVariable String shophistoryId) {
        try {
            String msg = "";
            if(shophistory==null) {
                msg = "添加资源参数不正确";
            }else if(shophistory.getShopId() != null){
                msg = "资源不能为空";
            }else if(shophistory.getRecordDate() != null){
                msg = "资源不能为空";
            }else if(shophistory.getRound() != null){
                msg = "资源不能为空";
            }else if(shophistory.getBeginBalance() != null){
                msg = "资源不能为空";
            }else if(shophistory.getEndBalance() != null){
                msg = "资源不能为空";
            }else if(shophistory.getRevenues() != null){
                msg = "资源不能为空";
            }else if(shophistory.getConsumeCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getMarketingCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getEmployeeNum() != null){
                msg = "资源不能为空";
            }else if(shophistory.getSalaryCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getRentCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getDepreciationCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getInterestCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getMiscCost() != null){
                msg = "资源不能为空";
            }else if(shophistory.getCreator() != null){
                msg = "资源不能为空";
            }else if(shophistory.getCreatDate() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Shophistory shophistory_old = (Shophistory) shophistoryService.findOne("id",shophistoryId);
            if(shophistory==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(shophistory.getId() != null){
                shophistory_old.setId(shophistory.getId());
            }
            if(shophistory.getShopId() != null){
                shophistory_old.setShopId(shophistory.getShopId());
            }
            if(shophistory.getRecordDate() != null){
                shophistory_old.setRecordDate(shophistory.getRecordDate());
            }
            if(shophistory.getRound() != null){
                shophistory_old.setRound(shophistory.getRound());
            }
            if(shophistory.getBeginBalance() != null){
                shophistory_old.setBeginBalance(shophistory.getBeginBalance());
            }
            if(shophistory.getEndBalance() != null){
                shophistory_old.setEndBalance(shophistory.getEndBalance());
            }
            if(shophistory.getRevenues() != null){
                shophistory_old.setRevenues(shophistory.getRevenues());
            }
            if(shophistory.getConsumeCost() != null){
                shophistory_old.setConsumeCost(shophistory.getConsumeCost());
            }
            if(shophistory.getMarketingCost() != null){
                shophistory_old.setMarketingCost(shophistory.getMarketingCost());
            }
            if(shophistory.getEmployeeNum() != null){
                shophistory_old.setEmployeeNum(shophistory.getEmployeeNum());
            }
            if(shophistory.getSalaryCost() != null){
                shophistory_old.setSalaryCost(shophistory.getSalaryCost());
            }
            if(shophistory.getRentCost() != null){
                shophistory_old.setRentCost(shophistory.getRentCost());
            }
            if(shophistory.getDepreciationCost() != null){
                shophistory_old.setDepreciationCost(shophistory.getDepreciationCost());
            }
            if(shophistory.getInterestCost() != null){
                shophistory_old.setInterestCost(shophistory.getInterestCost());
            }
            if(shophistory.getMiscCost() != null){
                shophistory_old.setMiscCost(shophistory.getMiscCost());
            }
            if(shophistory.getCreator() != null){
                shophistory_old.setCreator(shophistory.getCreator());
            }
            if(shophistory.getCreatDate() != null){
                shophistory_old.setCreatDate(shophistory.getCreatDate());
            }


            int row=shophistoryService.edit(shophistory_old);
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
     * @param shophistoryId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/shophistory/{shophistoryId}", method = RequestMethod.GET)
    public Shophistory getShophistory(@PathVariable String shophistoryId) {
        try {
            if(StringUtils.isBlank(shophistoryId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", shophistoryId);
            Shophistory shophistory= (Shophistory) shophistoryService.queryOne(whereParams);
            if(null == shophistory){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return shophistory;
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
     * @param shophistory 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/shophistorylist", method = RequestMethod.POST)
    public BizData4Page shophistorylist(Shophistory shophistory, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(shophistory.getId() != null){
                whereParams.put("id", new SearchField("id", "=", shophistory.getId()));
            }
            if(shophistory.getShopId() != null){
                whereParams.put("shopId", new SearchField("shopId", "=", shophistory.getShopId()));
            }
            if(shophistory.getRecordDate() != null){
                whereParams.put("recordDate", new SearchField("recordDate", "=", shophistory.getRecordDate()));
            }
            if(shophistory.getRound() != null){
                whereParams.put("round", new SearchField("round", "=", shophistory.getRound()));
            }
            if(shophistory.getBeginBalance() != null){
                whereParams.put("beginBalance", new SearchField("beginBalance", "=", shophistory.getBeginBalance()));
            }
            if(shophistory.getEndBalance() != null){
                whereParams.put("endBalance", new SearchField("endBalance", "=", shophistory.getEndBalance()));
            }
            if(shophistory.getRevenues() != null){
                whereParams.put("revenues", new SearchField("revenues", "=", shophistory.getRevenues()));
            }
            if(shophistory.getConsumeCost() != null){
                whereParams.put("consumeCost", new SearchField("consumeCost", "=", shophistory.getConsumeCost()));
            }
            if(shophistory.getMarketingCost() != null){
                whereParams.put("marketingCost", new SearchField("marketingCost", "=", shophistory.getMarketingCost()));
            }
            if(shophistory.getEmployeeNum() != null){
                whereParams.put("employeeNum", new SearchField("employeeNum", "=", shophistory.getEmployeeNum()));
            }
            if(shophistory.getSalaryCost() != null){
                whereParams.put("salaryCost", new SearchField("salaryCost", "=", shophistory.getSalaryCost()));
            }
            if(shophistory.getRentCost() != null){
                whereParams.put("rentCost", new SearchField("rentCost", "=", shophistory.getRentCost()));
            }
            if(shophistory.getDepreciationCost() != null){
                whereParams.put("depreciationCost", new SearchField("depreciationCost", "=", shophistory.getDepreciationCost()));
            }
            if(shophistory.getInterestCost() != null){
                whereParams.put("interestCost", new SearchField("interestCost", "=", shophistory.getInterestCost()));
            }
            if(shophistory.getMiscCost() != null){
                whereParams.put("miscCost", new SearchField("miscCost", "=", shophistory.getMiscCost()));
            }
            if(shophistory.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", shophistory.getCreator()));
            }
            if(shophistory.getCreatDate() != null){
                whereParams.put("creatDate", new SearchField("creatDate", "=", shophistory.getCreatDate()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            shophistoryService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
