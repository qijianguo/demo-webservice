package cn.landfun.hb110.service.impl;

import cn.landfun.hb110.service.CommonService;
import cn.landfun.hb110.utils.HttpUtil;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

/**接口实现
 * @作者 Administrator
 * @创建日期 2018/6/23 0023
 * @创建时间 11:26.
 */
@WebService(serviceName = "CommonService",//与前面接口一致
        targetNamespace = "www.WebService.hb110.landfun.cn",  //与前面接口一致
        endpointInterface = "cn.landfun.hb110.service.CommonService")  //接口地址
@Component
public class CommonServiceImpl implements CommonService {
    @Override
    public String feedback(String feedback) {
        // 发送反馈到阿里云
        Map<String, String> map = new HashMap<>();
        map.put("info", feedback);
        String response = HttpUtil.sendPost("http://shenyang.hbjk.com.cn:8080/v4/service/alertInfosFeedback", map);
        return "feedback! --->"+response;
    }
}