/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  IngredientsController.java 2015-11-11 11:46:39 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IIngredientsService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;


import cn.thinkjoy.sss.domain.Ingredients;
import cn.thinkjoy.sss.service.IIngredientsService;

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
public class apiIngredientsController{
    private static final Logger logger = LoggerFactory.getLogger(apiIngredientsController.class);

    @Autowired
    private IIngredientsService ingredientsService;

   /**
     * 新增 资源
     * @param ingredients
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/ingredients", method = RequestMethod.POST)
    public Object addIngredients(@RequestBody Ingredients ingredients) {
        try {
            String msg = "";

            if(ingredients==null) {
                msg = "添加资源参数不正确";
            }else if(ingredients.getProductId() != null){
                msg = "资源不能为空";
            }else if(ingredients.getMaterialsId() != null){
                msg = "资源不能为空";
            }else if(ingredients.getConsumption() != null){
                msg = "资源不能为空";
            }else if(ingredients.getCreator() != null){
                msg = "资源不能为空";
            }else if(ingredients.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(ingredients.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(ingredients.getLastModDate() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=ingredientsService.add(ingredients);
            if(row > 0) {
                return new StringWrapper(  ingredients.getId().toString() );
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
     * @param {ingredientsId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ingredients/{ingredientsId}" ,method = RequestMethod.DELETE)
    public Object delIngredients(@PathVariable String ingredientsId) {
        try {
            if(StringUtils.isBlank(ingredientsId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=ingredientsService.deleteByProperty("id", ingredientsId);
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
     * @param ingredients 提交上来的资源JSON数据
     * @param ingredientsId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/ingredients/{ingredientsId}", method = RequestMethod.PATCH)
    public StringWrapper editIngredients(@RequestBody Ingredients ingredients, @PathVariable String ingredientsId) {
        try {
            String msg = "";
            if(ingredients==null) {
                msg = "添加资源参数不正确";
            }else if(ingredients.getProductId() != null){
                msg = "资源不能为空";
            }else if(ingredients.getMaterialsId() != null){
                msg = "资源不能为空";
            }else if(ingredients.getConsumption() != null){
                msg = "资源不能为空";
            }else if(ingredients.getCreator() != null){
                msg = "资源不能为空";
            }else if(ingredients.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(ingredients.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(ingredients.getLastModDate() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Ingredients ingredients_old = (Ingredients) ingredientsService.findOne("id",ingredientsId);
            if(ingredients==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(ingredients.getId() != null){
                ingredients_old.setId(ingredients.getId());
            }
            if(ingredients.getProductId() != null){
                ingredients_old.setProductId(ingredients.getProductId());
            }
            if(ingredients.getMaterialsId() != null){
                ingredients_old.setMaterialsId(ingredients.getMaterialsId());
            }
            if(ingredients.getConsumption() != null){
                ingredients_old.setConsumption(ingredients.getConsumption());
            }
            if(ingredients.getCreator() != null){
                ingredients_old.setCreator(ingredients.getCreator());
            }
            if(ingredients.getCreatDate() != null){
                ingredients_old.setCreatDate(ingredients.getCreatDate());
            }
            if(ingredients.getLastModifier() != null){
                ingredients_old.setLastModifier(ingredients.getLastModifier());
            }
            if(ingredients.getLastModDate() != null){
                ingredients_old.setLastModDate(ingredients.getLastModDate());
            }


            int row=ingredientsService.edit(ingredients_old);
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
     * @param ingredientsId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ingredients/{ingredientsId}", method = RequestMethod.GET)
    public Ingredients getIngredients(@PathVariable String ingredientsId) {
        try {
            if(StringUtils.isBlank(ingredientsId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", ingredientsId);
            Ingredients ingredients= (Ingredients) ingredientsService.queryOne(whereParams);
            if(null == ingredients){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return ingredients;
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
     * @param ingredients 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/ingredientslist", method = RequestMethod.POST)
    public BizData4Page ingredientslist(Ingredients ingredients, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(ingredients.getId() != null){
                whereParams.put("id", new SearchField("id", "=", ingredients.getId()));
            }
            if(ingredients.getProductId() != null){
                whereParams.put("productId", new SearchField("productId", "=", ingredients.getProductId()));
            }
            if(ingredients.getMaterialsId() != null){
                whereParams.put("materialsId", new SearchField("materialsId", "=", ingredients.getMaterialsId()));
            }
            if(ingredients.getConsumption() != null){
                whereParams.put("consumption", new SearchField("consumption", "=", ingredients.getConsumption()));
            }
            if(ingredients.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", ingredients.getCreator()));
            }
            if(ingredients.getCreatDate() != null){
                whereParams.put("creatDate", new SearchField("creatDate", "=", ingredients.getCreatDate()));
            }
            if(ingredients.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", ingredients.getLastModifier()));
            }
            if(ingredients.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", ingredients.getLastModDate()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            ingredientsService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
