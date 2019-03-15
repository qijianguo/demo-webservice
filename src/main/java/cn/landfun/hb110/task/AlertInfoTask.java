package cn.landfun.hb110.task;

import ch.qos.logback.core.util.TimeUtil;
import cn.landfun.hb110.client.FlowService;
import cn.landfun.hb110.domain.AlertInfo;
import cn.landfun.hb110.domain.Result;
import cn.landfun.hb110.utils.HttpUtil;
import cn.landfun.hb110.utils.JsonUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import net.sf.json.JSONArray;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class AlertInfoTask {

    /**
     * 计算所有监测站的五分钟均值
     */
//    @Scheduled(cron = "0 2/5 * * * *")
    @Scheduled(cron = "0 0/1 * * * *")
    public void getAlertInfo() {
        String message = HttpUtil.sendGet("http://shenyang.hbjk.com.cn:8080/v4/service/alertInfos");
        List<String> alertInfos = convertPm25InData(message);
        List<String> result = new ArrayList<>();
        if (alertInfos != null) {
            // 发送web service
            alertInfos.forEach(alertInfo -> {
                String bak = sendService(alertInfo);
                result.add(bak);
            });
        }
        // HttpUtil.send
    }


    private List<String> convertPm25InData(String message) {
        Result result1 = JsonUtils.parseJsonToObj(message, Result.class);
        if (result1 != null) {
            return result1.getData();
        }
        return null;
    }

    private String sendService(String message) {
        URL url = null;
        try {
            url = new URL("http://192.168.124.32:8080/flow_ws/services/FlowService?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //服务描述中服务端点的限定名称  两个参数分别为 命名空间 服务名
        QName qName = new QName("http://ws.service.flow.neusoft.com", "FlowServiceService");
        //创建服务对象
        javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qName);
        //获得Hiservice的实现类对象
        FlowService hiService = service.getPort(new QName("http://ws.service.flow.neusoft.com","FlowService"),FlowService.class);
        //调用WebService方法
        String recvMsg = hiService.message(message);
        System.out.println(recvMsg);
        return recvMsg;
    }

}
