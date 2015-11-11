/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  ProductController.java 2015-11-11 11:46:41 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IProductService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;


import cn.thinkjoy.sss.domain.Product;
import cn.thinkjoy.sss.service.IProductService;

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
public class apiProductController{
    private static final Logger logger = LoggerFactory.getLogger(apiProductController.class);

    @Autowired
    private IProductService productService;

   /**
     * 新增 资源
     * @param product
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Object addProduct(@RequestBody Product product) {
        try {
            String msg = "";

            if(product==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(product.getName())){
                msg = "资源不能为空";
            }else if(product.getName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(product.getOldPrice() != null){
                msg = "资源不能为空";
            }else if(product.getOldSalesVolume() != null){
                msg = "资源不能为空";
            }else if(product.getOrder() != null){
                msg = "资源不能为空";
            }else if(product.getShelfLife() != null){
                msg = "资源不能为空";
            }else if(product.getCreator() != null){
                msg = "资源不能为空";
            }else if(product.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(product.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(product.getLastModDate() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=productService.add(product);
            if(row > 0) {
                return new StringWrapper( product.getId().toString());
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
     * @param {productId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/product/{productId}" ,method = RequestMethod.DELETE)
    public Object delProduct(@PathVariable String productId) {
        try {
            if(StringUtils.isBlank(productId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=productService.deleteByProperty("id", productId);
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
     * @param product 提交上来的资源JSON数据
     * @param productId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.PATCH)
    public StringWrapper editProduct(@RequestBody Product product, @PathVariable String productId) {
        try {
            String msg = "";
            if(product==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(product.getName())){
                msg = "资源不能为空";
            }else if(product.getName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(product.getOldPrice() != null){
                msg = "资源不能为空";
            }else if(product.getOldSalesVolume() != null){
                msg = "资源不能为空";
            }else if(product.getOrder() != null){
                msg = "资源不能为空";
            }else if(product.getShelfLife() != null){
                msg = "资源不能为空";
            }else if(product.getCreator() != null){
                msg = "资源不能为空";
            }else if(product.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(product.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(product.getLastModDate() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Product product_old = (Product) productService.findOne("id",productId);
            if(product==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(product.getId() != null){
                product_old.setId(product.getId());
            }
            if(!StringUtils.isBlank(product.getName())){
                product_old.setName(product.getName());
            }
            if(product.getCost() != null){
                product_old.setCost(product.getCost());
            }
            if(product.getOldPrice() != null){
                product_old.setOldPrice(product.getOldPrice());
            }
            if(product.getOldSalesVolume() != null){
                product_old.setOldSalesVolume(product.getOldSalesVolume());
            }
            if(product.getOrder() != null){
                product_old.setOrder(product.getOrder());
            }
            if(product.getShelfLife() != null){
                product_old.setShelfLife(product.getShelfLife());
            }
            if(product.getCreator() != null){
                product_old.setCreator(product.getCreator());
            }
            if(product.getCreatDate() != null){
                product_old.setCreatDate(product.getCreatDate());
            }
            if(product.getLastModifier() != null){
                product_old.setLastModifier(product.getLastModifier());
            }
            if(product.getLastModDate() != null){
                product_old.setLastModDate(product.getLastModDate());
            }


            int row=productService.edit(product_old);
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
     * @param productId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String productId) {
        try {
            if(StringUtils.isBlank(productId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", productId);
            Product product= (Product) productService.queryOne(whereParams);
            if(null == product){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return product;
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
     * @param product 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/productlist", method = RequestMethod.POST)
    public BizData4Page productlist(Product product, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(product.getId() != null){
                whereParams.put("id", new SearchField("id", "=", product.getId()));
            }
            if(!StringUtils.isBlank(product.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + product.getName() + "%"));
            }
            if(product.getCost() != null){
                whereParams.put("cost", new SearchField("cost", "=", product.getCost()));
            }
            if(product.getOldPrice() != null){
                whereParams.put("oldPrice", new SearchField("oldPrice", "=", product.getOldPrice()));
            }
            if(product.getOldSalesVolume() != null){
                whereParams.put("oldSalesVolume", new SearchField("oldSalesVolume", "=", product.getOldSalesVolume()));
            }
            if(product.getOrder() != null){
                whereParams.put("order", new SearchField("order", "=", product.getOrder()));
            }
            if(product.getShelfLife() != null){
                whereParams.put("shelfLife", new SearchField("shelfLife", "=", product.getShelfLife()));
            }
            if(product.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", product.getCreator()));
            }
            if(product.getCreatDate() != null){
                whereParams.put("creatDate", new SearchField("creatDate", "=", product.getCreatDate()));
            }
            if(product.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", product.getLastModifier()));
            }
            if(product.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", product.getLastModDate()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            productService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
