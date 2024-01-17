package zxf.example;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.ServiceLoader;

import zxf.example.spi.ＭyService;

public class TestDynamicSPI {
    public static void main(String[] args) throws IOException {
        URL[] depends = new URL[]{
                new URL("file:" + Paths.get("zxf-java-spi-test-dynamic/libraries/zxf-java-spi-provider-a-1.0-SNAPSHOT.jar").toAbsolutePath()),
                new URL("file:" + Paths.get("zxf-java-spi-test-dynamic/libraries/zxf-java-spi-provider-b-1.0-SNAPSHOT.jar").toAbsolutePath())};
        System.out.println(depends[0]);

        ClassLoader originClassloader = Thread.currentThread().getContextClassLoader();
        try (URLClassLoader urlClassLoader = new URLClassLoader(depends)) {
            Thread.currentThread().setContextClassLoader(urlClassLoader);

            // ServiceLoader use ContextClassLoader to support load SPI dynamic
            ServiceLoader<ＭyService> serviceLoader = ServiceLoader.load(ＭyService.class);
            serviceLoader.forEach((myService) -> {
                myService.execute("Test Java SPI");
            });
        } finally {
            Thread.currentThread().setContextClassLoader(originClassloader);
        }
    }
}