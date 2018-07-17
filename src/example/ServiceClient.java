package example;

import com.webservice.TestInterfaceImpl;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: XieLiang
 * @Date : 2018/7/17
 * @Comment : service编程调用方式
 */
public class ServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        /** 1.创建服务视图 */
        /** 创建wsdl的url */
        URL url = new URL("http://localhost:8081/TestService?wsdl");
        /**
         * 创建Qname - 服务名称
         * namespaceURL - 命名空间地址,<types>标签内的import namespace值
         * localpart - 服务视图名,<service>标签的name值
         */
        QName qName = new QName("http://interfaces.example/","TestInterfaceImplService");
        Service service = Service.create(url,qName);

        /** 2.获取服务实现类,<binding>标签的type值 */
        TestInterfaceImpl testInterface = service.getPort(TestInterfaceImpl.class);

        /** 3.调用实现类的方法 */
        String result = testInterface.getName("red");
        System.out.println(result);
    }


}
