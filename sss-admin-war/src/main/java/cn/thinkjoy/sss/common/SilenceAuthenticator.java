//package cn.thinkjoy.sss.common;
//
//import cn.thinkjoy.common.filter.context.DefaultUserContextImpl;
//import cn.thinkjoy.common.filter.context.IUserContext;
//import cn.thinkjoy.common.filter.context.UserContextHolder;
//import cn.thinkjoy.common.managerui.iauth.client.DefaultAuthenticator;
//import cn.thinkjoy.common.managerui.iauth.client.token.AccessToken;
//import cn.thinkjoy.common.managerui.iauth.client.token.storage.RedisTokenStore;
//import cn.thinkjoy.common.managerui.iauth.client.token.storage.UserStore;
//import cn.thinkjoy.common.managerui.iauth.core.BaseRequest;
//import cn.thinkjoy.common.managerui.iauth.core.exception.TokenNotExistException;
//import cn.thinkjoy.common.managerui.iauth.core.handler.TokenHandler;
//import cn.thinkjoy.dap.service.IAccessService;
//import cn.thinkjoy.dap.service.IUserAccessService;
//import com.google.common.base.Strings;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by wdong on 15/6/18.
// */
//public class SilenceAuthenticator extends DefaultAuthenticator {
//    public SilenceAuthenticator(List<TokenHandler> tokenHandlers) {
//        super(tokenHandlers);
//    }
//
//    @Autowired
//    private RedisTokenStore tokenStore;
//
//    @Autowired
//    private UserStore userStore;
//
//
//    @Autowired
//    private IUserAccessService userAccessService;
//
//    @Autowired
//    private IAccessService accessService;
//
//
//    @Override
//    public boolean isNeedAuthentication(BaseRequest baseRequest) {
//        if (!isSilence(baseRequest)) return true;
//
//        String key =baseRequest.getRequest().getParameter("access_token");
//
//        if(!Strings.isNullOrEmpty(key)) {
//            AccessToken accessToken = (AccessToken) tokenStore.readToken(key);
//            if(accessToken != null) {
//
//                //供 analytics filter使用
//                IUserContext userContext = new DefaultUserContextImpl();
//                Map<String, Object> datas = new HashMap<>(4);
//                datas.put(IUserContext.UID, accessToken.getUserId());
//                ((DefaultUserContextImpl)userContext).setContexts(datas);
//                UserContextHolder.setUserContext(userContext);
//
//
//                return false;
//            }
//        } else {
//            throw new TokenNotExistException();
//        }
//        return true;
//    }
//
//
//
//    private boolean isSilence(BaseRequest baseRequest){
//        return "true".equals(baseRequest.getRequest().getHeader("silence"));
//    }
//}
