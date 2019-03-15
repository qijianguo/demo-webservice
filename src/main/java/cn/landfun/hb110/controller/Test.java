package cn.landfun.hb110.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws IOException {
        test2();
    }  
 
 
    public static String getXML(String phone){  
    	
    	String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"  
    	        +"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2003/XMLSchema-instance\" " 
    			+"xmlns:web=\"http://WebXml.com.cn/\"  " 
    	        +"xmlns:xsd=\"http://www.w3.org/2003/XMLSchema\" " 
    			+"xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"  
    	            +"<soap:Body>"  
    	              +"<web:getMobileCodeInfo>"    
    	              +phone
    	              +"</web:getMobileCodeInfo>"  
    	            +"</soap:Body>"  
    	        +"</soap:Envelope>";  
        return soapXML;  
    }


    private static void test1() throws IOException {
        //第一步：创建服务地址
        URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
        //第二步：打开一个通向服务地址的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //第三步：设置参数
        //3.1发送方式设置：POST必须大写
        connection.setRequestMethod("POST");
        //3.2设置数据格式：content-type
        connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
        connection.setRequestProperty("soapaction", "");
        //3.3设置输入输出，因为默认新创建的connection没有读写权限，
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //第四步：组织SOAP数据，发送请求
        String soapXML = getXML("17321242779");
        //将信息以流的方式发送出去
        OutputStream os = connection.getOutputStream();
        os.write(soapXML.getBytes());
        //第五步：接收服务端响应，打印
        int responseCode = connection.getResponseCode();
        if(200 == responseCode){//表示服务端响应成功
            //获取当前连接请求返回的数据流
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String temp = null;
            while(null != (temp = br.readLine())){
                sb.append(temp);
            }

            /**
             * 打印结果
             */
            System.out.println(sb.toString());

            is.close();
            isr.close();
            br.close();
        }
        os.close();
    }

    private static void test2() throws IOException {
        //第一步：创建服务地址
        URL url = new URL("http://192.168.124.32:8080/flow_ws/services/FlowService?wsdl");
        //第二步：打开一个通向服务地址的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //第三步：设置参数
        //3.1发送方式设置：POST必须大写
        connection.setRequestMethod("POST");
        //3.2设置数据格式：content-type
        connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
        //3.3设置输入输出，因为默认新创建的connection没有读写权限，
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //第四步：组织SOAP数据，发送请求
        String soapXML = getName("name");
        //将信息以流的方式发送出去
        OutputStream os = connection.getOutputStream();
        os.write(soapXML.getBytes());
        //第五步：接收服务端响应，打印
        int responseCode = connection.getResponseCode();
        if(200 == responseCode){//表示服务端响应成功
            //获取当前连接请求返回的数据流
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String temp = null;
            while(null != (temp = br.readLine())){
                sb.append(temp);
            }

            /**
             * 打印结果
             */
            System.out.println(sb.toString());

            is.close();
            isr.close();
            br.close();
        }
        os.close();
    }

    public static String getName(String phone){

        // String xml = "<?xml version=\\\"1.0\\\"?><flow xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\" xmlns:xsd=\\\"http://www.w3.org/2001/XMLSchema\\\"><head><fid>F003001001</fid><sid /><cd>3</cd><rcode xsi:nil=\\\"true\\\" /><pk>20171101003</pk><key>3a53a53c9c52793a578b24014cad8532</key></head><body><pkey><![CDATA[0241001|2017-10-31 07至2017-11-01 07|TSP]]></pkey><fankui_info><![CDATA[沈河区:行政区域：于洪区，考核时效：2017-10-31 07至2017-11-01 07，污染源名称：沈阳市于洪焱丞供暖有限公司(南里锅炉房)，排口名称：南里锅炉房总出口，污染物名称：TSP，排放标准：30，平均值：46.204，超标倍数：0.54倍，超标小时数：8]]></fankui_info><sourceType><![CDATA[quxian]]></sourceType></body></flow>";
        String xml = "<flow><head><fid>F003001001</fid><pk>20171101001</pk><time>20171101151109</time><cd>1</cd><key>3a53a53c9c52793a578b24014cad8532</key></head><body><pk><![CDATA[0241001|2017-10-31 07至2017-11-01 07|TSP]]></pk><rtype><![CDATA[污染源在线监控]]></rtype><pcode><![CDATA[大气污染]]></pcode><info><![CDATA[行政区域：于洪区，考核时效：2017-10-31 07至2017-11-01 07，污染源名称：沈阳市于洪焱丞供暖有限公司(南里锅炉房)，排口名称：南里锅炉房总出口，污染物名称：TSP，排放标准：30，平均值：46.204，超标倍数：0.54倍，超标小时数：8]]></info><fname><![CDATA[沈阳市于洪焱丞供暖有限公司(南里锅炉房)]]></fname><address><![CDATA[沈阳市于洪焱丞供暖有限公司洪湖街1-1甲]]></address></body></flow>";
        return xml;
    }

    public static String getXML1(String phone){

        String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                +"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2003/XMLSchema-instance\" "
                +"xmlns:web=\"http://ws.service.flow.neusoft.com/\"  "
                +"xmlns:xsd=\"http://www.w3.org/2003/XMLSchema\" "
                +"xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                +"<soap:Body>"
                +"<web:messageResponse>"
                +phone
                +"</web:messageResponse>"
                +"</soap:Body>"
                +"</soap:Envelope>";
        return soapXML;
    }

}