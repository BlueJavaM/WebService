package example;

import com.webservice.TestInterfaceImpl;
import com.webservice.TestInterfaceImplService;

public class HelloWorldClient {
  public static void main(String[] argv) {
      TestInterfaceImplService testInterfaceImplService = new TestInterfaceImplService();
      TestInterfaceImpl service = testInterfaceImplService.getPort(TestInterfaceImpl.class);


      //invoke business method
      String result = service.getName("Blue");
      System.out.print(result);
  }
}
