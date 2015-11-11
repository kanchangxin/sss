package cn.thinkjoy.sss.common;


import cn.thinkjoy.common.domain.UserDomain;
import cn.thinkjoy.common.utils.UserContext;
import com.qtone.open.api.uic.dto.AccountDto;

import com.qtone.open.ucm.BaseRequest;
import com.qtone.open.ucm.client.IQTOAuthListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Ucenter认证回调监听
 * Created by jimkan on 15-11-3.
 */
public class AuthListener implements IQTOAuthListener {
    public static final Logger logger = LoggerFactory.getLogger(AuthListener.class);

    @Override
    public void authenticatornSuccess(AccountDto accountDto) {
        logger.debug(accountDto.toString());
        UserDomain<String> userDomain = new UserDomain<>();
        if (accountDto != null) {
            userDomain.setName(accountDto.getName());
            userDomain.setId(accountDto.getUid());
            UserContext.setCurrentUser(userDomain);
        }
    }

    @Override
    public void authenticatornError(BaseRequest baseRequest, RuntimeException ex) {
        logger.warn(ex.getMessage());
    }

    @Override
    public void logout(AccountDto currentUser) {
        UserContext.removeCurrentUser();
    }
}