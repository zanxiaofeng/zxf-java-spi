package zxf.example.spi.provider.b;

import zxf.example.spi.ＭyService;

public class MyServiceB1  implements ＭyService {
    @Override
    public void execute(String name) {
        System.out.println("MyServiceB1.execute('" + name + "')");
    }
}
