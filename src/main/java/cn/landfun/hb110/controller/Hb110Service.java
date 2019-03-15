package cn.landfun.hb110.controller;

import cn.landfun.hb110.client.FlowService;
import cn.landfun.hb110.service.CommonService;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class Hb110Service {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://192.168.124.32:8080/flow_ws/services/FlowService?wsdl");
        //服务描述中服务端点的限定名称  两个参数分别为 命名空间 服务名
        QName qName = new QName("http://ws.service.flow.neusoft.com", "FlowServiceService");
        //创建服务对象
        javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qName);
        //获得Hiservice的实现类对象
        FlowService hiService = service.getPort(new QName("http://ws.service.flow.neusoft.com","FlowService"),FlowService.class);
        //调用WebService方法
        System.out.println(hiService.message(getName()));
    }

    public static String getName(){
        // String xml = "<?xml version=\\\"1.0\\\"?><flow xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\" xmlns:xsd=\\\"http://www.w3.org/2001/XMLSchema\\\"><head><fid>F003001001</fid><sid /><cd>3</cd><rcode xsi:nil=\\\"true\\\" /><pk>20171101003</pk><key>3a53a53c9c52793a578b24014cad8532</key></head><body><pkey><![CDATA[0241001|2017-10-31 07至2017-11-01 07|TSP]]></pkey><fankui_info><![CDATA[沈河区:行政区域：于洪区，考核时效：2017-10-31 07至2017-11-01 07，污染源名称：沈阳市于洪焱丞供暖有限公司(南里锅炉房)，排口名称：南里锅炉房总出口，污染物名称：TSP，排放标准：30，平均值：46.204，超标倍数：0.54倍，超标小时数：8]]></fankui_info><sourceType><![CDATA[quxian]]></sourceType></body></flow>";
        String xml = "<flow><head><fid>F003001001</fid><pk>20171101001</pk><time>20171101151109</time><cd>1</cd><key>3a53a53c9c52793a578b24014cad8532</key></head><body><pk><![CDATA[0241001|2017-10-31 07至2017-11-01 07|TSP]]></pk><rtype><![CDATA[污染源在线监控]]></rtype><pcode><![CDATA[大气污染]]></pcode><info><![CDATA[行政区域：于洪区，考核时效：2017-10-31 07至2017-11-01 07，污染源名称：沈阳市于洪焱丞供暖有限公司(南里锅炉房)，排口名称：南里锅炉房总出口，污染物名称：TSP，排放标准：30，平均值：46.204，超标倍数：0.54倍，超标小时数：8]]></info><fname><![CDATA[沈阳市于洪焱丞供暖有限公司(南里锅炉房)]]></fname><address><![CDATA[沈阳市于洪焱丞供暖有限公司洪湖街1-1甲]]></address></body></flow>";
        return xml;
    }
}
