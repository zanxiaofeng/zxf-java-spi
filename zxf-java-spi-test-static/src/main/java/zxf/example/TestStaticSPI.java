package zxf.example;

import java.util.ServiceLoader;
import zxf.example.spi.ＭyService;

public class TestStaticSPI {
    public static void main(String[] args) {
        ServiceLoader<ＭyService> serviceLoader = ServiceLoader.load(ＭyService.class);
        serviceLoader.forEach((myService)->{
            myService.execute("Test Java SPI");
        });
    }
}