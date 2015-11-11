package cn.thinkjoy.sss.test.ucenter;

import cn.thinkjoy.common.domain.ListWrapper;
import cn.thinkjoy.common.protocol.ResponseT;
import com.qtone.open.QTOpenApi;
import com.qtone.open.QTOpenApiConfig;
import com.qtone.open.api.basedata.dto.BaseDataDto;
import com.qtone.open.remote.http.IUserStubService;

/**
 * Created by jimkan on 15-11-3.
 */
public class AuthTest {


    public static void main(String[] args) {
        String client_id  = "demo";

        String client_secret = "demo";

        String secret = "demo";

        //以上参数联系管理员获取

        QTOpenApiConfig config = new QTOpenApiConfig();
        config.setClient_id(client_id);
        config.setClient_secret(client_secret);
        config.setSecret(secret);
        config.setServerUri("http://uww-dev.thinkjoy.com.cn");
        QTOpenApi.getInstance(config);
        ResponseT<ListWrapper<BaseDataDto>> list= QTOpenApi.getBaseDataService().childAgency("code", null, null);
        System.out.println(list.getMsg());
        //IUserStubService s=QTOpenApi.getUserService();
    }
}
