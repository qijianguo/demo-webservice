package cn.landfun.hb110.controller;

import cn.landfun.hb110.service.CommonService;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class Service {
    public static void main(String[] args) throws MalformedURLException {
        //wsdl网络路径
        URL url = new URL("http://192.168.124.31:8080/services/CommonService?wsdl");
        //服务描述中服务端点的限定名称  两个参数分别为 命名空间 服务名
        QName qName = new QName("www.WebService.hb110.landfun.cn", "CommonService");
        //创建服务对象
        javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qName);
        //获得Hiservice的实现类对象
        CommonService hiService = service.getPort(new QName("www.WebService.hb110.landfun.cn","CommonServiceImplPort"),CommonService.class);
        //调用WebService方法
        System.out.println(hiService.feedback("xiaoming"));


        // wsimport -keep -d /Users/qijianguo/Angus/IdeaProjects/hb110/src/main/java -p cn.landfun.hb110.client -verbose http://192.168.124.32:8080/flow_ws/services/FlowService?wsdl

        // wsimport -keep -d /Users/qijianguo/Angus/test -p com.neusoft.flow.service.client.fankuiYc -verbose http://192.168.124.32:8080/flow_ws/services/FlowService?wsdl
    }  
} 