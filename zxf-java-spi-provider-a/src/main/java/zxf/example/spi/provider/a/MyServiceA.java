package zxf.example.spi.provider.a;

import zxf.example.spi.ＭyService;

public class MyServiceA implements ＭyService {
    @Override
    public void execute(String name) {
        System.out.println("MyServiceA.execute('" + name + "')");
    }
}
