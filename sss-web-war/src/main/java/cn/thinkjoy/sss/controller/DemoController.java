package cn.thinkjoy.sss.controller;

import cn.thinkjoy.common.domain.StringWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 范例
 * Created by jimkan on 15-10-30.
 */
@Controller
@RequestMapping(value="/demo")
public class DemoController
{
    public static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    /**
     * 本方法示范：
     * 对应url:/demo/下根目录访问
     * 返回string对象被认为是一个freemarker模板路径
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(HttpServletRequest request,HttpServletResponse response) {
        logger.debug("index ");
        return  "hello world" ;//模板名
    }

    /**
     * 本方法示范：
     * 对应url:/demo/helloFreemarker  访问,必须大小写一致
     * 返回hello world模板(freemarker),带入变量
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/helloFreemarker", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView helloFreemarker(HttpServletRequest request,HttpServletResponse response) {
        logger.debug("helloFreemarker");
        ModelAndView mav=new ModelAndView("hello world");
        mav.addObject("title", "我是变量");
        return mav;
    }

    /**
     * 本方法示范：
     * 返回一个string转化的Json对象
     * 加了 @ResponseBody 表示返回的是内容啦
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/helloStringJson", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public StringWrapper helloStringJson(HttpServletRequest request,HttpServletResponse response) {
        logger.debug("helloStringJson");
        return new StringWrapper("hello world");
    }


    /**
     * 本方法示范：
     * 返回一个Map转化的Json对象
     * @return
     */
    @RequestMapping("/helloObjJson")
    @ResponseBody
    public Map<String, Object> helloObjJson() {
        logger.debug("helloObjJson");

        Map<String, Object> map = new HashMap<String, Object>();
        List<String> list=new ArrayList<String>();
        list.add("zhong");
        list.add("s斯蒂芬");
        map.put("list", list);
        return map;
    }
}
