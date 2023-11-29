package zxf.example.spi.provider.b;

import zxf.example.spi.ＭyService;

public class MyServiceB2  implements ＭyService {
    @Override
    public void execute(String name) {
        System.out.println("MyServiceB2.execute('" + name + "')");
    }
}
