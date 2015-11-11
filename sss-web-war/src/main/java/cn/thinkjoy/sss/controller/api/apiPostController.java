/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: sss
 * $Id:  PostController.java 2015-11-11 11:46:41 $
 */

package cn.thinkjoy.sss.controller.api;

import cn.thinkjoy.sss.service.IPostService;
import cn.thinkjoy.common.domain.SearchField;
import cn.thinkjoy.common.domain.StringWrapper;
import cn.thinkjoy.common.domain.view.BizData4Page;
import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.common.utils.RtnCodeEnum;


import cn.thinkjoy.sss.domain.Post;
import cn.thinkjoy.sss.service.IPostService;

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
public class apiPostController{
    private static final Logger logger = LoggerFactory.getLogger(apiPostController.class);

    @Autowired
    private IPostService postService;

   /**
     * 新增 资源
     * @param post
     * @return  处理条数
     */
    @ResponseBody
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Object addPost(@RequestBody Post post) {
        try {
            String msg = "";

            if(post==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(post.getName())){
                msg = "资源不能为空";
            }else if(post.getName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(post.getSalary() != null){
                msg = "资源不能为空";
            }else if(post.getCreator() != null){
                msg = "资源不能为空";
            }else if(post.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(post.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(post.getLastModDate() != null){
                msg = "资源不能为空";
            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            int row=postService.add(post);
            if(row > 0) {
                return new StringWrapper( post.getId().toString());
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
     * @param {postId} 资源ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/post/{postId}" ,method = RequestMethod.DELETE)
    public Object delPost(@PathVariable String postId) {
        try {
            if(StringUtils.isBlank(postId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "删除资源失败，参数不正确");
            }
            int row=postService.deleteByProperty("id", postId);
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
     * @param post 提交上来的资源JSON数据
     * @param postId  资源ID
     * @return  修改条数
     */
    @ResponseBody
    @RequestMapping(value = "/post/{postId}", method = RequestMethod.PATCH)
    public StringWrapper editPost(@RequestBody Post post, @PathVariable String postId) {
        try {
            String msg = "";
            if(post==null) {
                msg = "添加资源参数不正确";
            }else if(StringUtils.isBlank(post.getName())){
                msg = "资源不能为空";
            }else if(post.getName().length() > 50){
                msg = "资源长度不可超过50";
            }else if(post.getSalary() != null){
                msg = "资源不能为空";
            }else if(post.getCreator() != null){
                msg = "资源不能为空";
            }else if(post.getCreatDate() != null){
                msg = "资源不能为空";
            }else if(post.getLastModifier() != null){
                msg = "资源不能为空";
            }else if(post.getLastModDate() != null){
                msg = "资源不能为空";

            }

            if(StringUtils.isNotBlank(msg)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), msg);
            }

            Post post_old = (Post) postService.findOne("id",postId);
            if(post==null) {
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "修改失败，系统未找到相关数据");
            }

            if(post.getId() != null){
                post_old.setId(post.getId());
            }
            if(!StringUtils.isBlank(post.getName())){
                post_old.setName(post.getName());
            }
            if(post.getSalary() != null){
                post_old.setSalary(post.getSalary());
            }
            if(!StringUtils.isBlank(post.getDesc())){
                post_old.setDesc(post.getDesc());
            }
            if(post.getCreator() != null){
                post_old.setCreator(post.getCreator());
            }
            if(post.getCreatDate() != null){
                post_old.setCreatDate(post.getCreatDate());
            }
            if(post.getLastModifier() != null){
                post_old.setLastModifier(post.getLastModifier());
            }
            if(post.getLastModDate() != null){
                post_old.setLastModDate(post.getLastModDate());
            }


            int row=postService.edit(post_old);
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
     * @param postId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
    public Post getPost(@PathVariable String postId) {
        try {
            if(StringUtils.isBlank(postId)){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "参数不正确！");
            }
            Map<String,Object> whereParams = new HashMap<String, Object>();
            whereParams.put("id", postId);
            Post post= (Post) postService.queryOne(whereParams);
            if(null == post){
                throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "系统未找到资源相关数据！");
            }
            return post;
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
     * @param post 过滤条件
     * @param page      第几页
     * @return 业务数据列表实体，最终转换为json数据输出
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/postlist", method = RequestMethod.POST)
    public BizData4Page postlist(Post post, Integer page) {
        try {
            Map<String, Object> whereParams = new HashMap<String, Object>();
            if(post.getId() != null){
                whereParams.put("id", new SearchField("id", "=", post.getId()));
            }
            if(!StringUtils.isBlank(post.getName())){
                whereParams.put("name", new SearchField("name", "like", "%" + post.getName() + "%"));
            }
            if(post.getSalary() != null){
                whereParams.put("salary", new SearchField("salary", "=", post.getSalary()));
            }
            if(!StringUtils.isBlank(post.getDesc())){
                whereParams.put("desc", new SearchField("desc", "like", "%" + post.getDesc() + "%"));
            }
            if(post.getCreator() != null){
                whereParams.put("creator", new SearchField("creator", "=", post.getCreator()));
            }
            if(post.getCreatDate() != null){
                whereParams.put("creatDate", new SearchField("creatDate", "=", post.getCreatDate()));
            }
            if(post.getLastModifier() != null){
                whereParams.put("lastModifier", new SearchField("lastModifier", "=", post.getLastModifier()));
            }
            if(post.getLastModDate() != null){
                whereParams.put("lastModDate", new SearchField("lastModDate", "=", post.getLastModDate()));
            }


            //other props filter
            whereParams.put("groupOp", "and");

            BizData4Page bizData4Page = new BizData4Page();
            bizData4Page.setConditions(whereParams);
            if (page != null) {
                bizData4Page.setPage(page);
            }

            postService.queryPageByDataPerm(bizData4Page);
            return bizData4Page;
        } catch (BizException bize) {
            throw bize;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BizException(RtnCodeEnum.UNKNOW.getValue(), "查询资源数据异常");
        }
    }
}
