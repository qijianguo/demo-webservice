package cn.landfun.hb110;

public class Test {

    /*public static void main(String[] args) {
        WebServiceDemoService_Service serviceDemoService_service = new WebServiceDemoService_Service();
        WebServiceDemoService webServiceDemoService = serviceDemoService_service.getWebServiceDemoServiceImplPort();

        String result = webServiceDemoService.hello("hello");
        System.out.println(result);
    }*/

    public static void main(String[] args) {
        CommonService_Service serviceDemoService_service = new CommonService_Service();
        CommonService webServiceDemoService = serviceDemoService_service.getCommonServiceImplPort();

        String result = webServiceDemoService.sayHello("hello");
        System.out.println(result);
    }
}
