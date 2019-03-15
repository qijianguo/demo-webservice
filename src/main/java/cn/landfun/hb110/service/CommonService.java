package cn.landfun.hb110.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "CommonService", // 暴露服务名称
        targetNamespace = "http://www.WebService.hb110.landfun.cn")   //命名空间,一般是接口的包名倒序
public interface CommonService {
    @WebMethod
    @WebResult(name = "String",targetNamespace = "feedback")
    public String feedback(@WebParam(name = "Message") String name);
}