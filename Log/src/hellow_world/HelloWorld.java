package hellow_world;

/**
 * @author youzh
 * @version 1.0
 * @project JavaStudy
 * @description a hello world for logback
 * @date 2022/10/13 20:20:23
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

/*
 * @author: youzh
 * @Date: 2022/10/13 20:20
 * @Version: 1.0
 */
public class HelloWorld {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("hellow_world.HelloWorld");
        logger.debug("Hello world.");

        // print internal state
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
        /*
        failed to find logback-test.xml and logback.xml
        
        20:27:02.473 [main] DEBUG hellow_world.HelloWorld - Hello world.
        20:27:02,421 |-INFO in ch.qos.logback.classic.LoggerContext[default] - This is logback-classic version 1.4.4
        20:27:02,449 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback-test.xml]
        20:27:02,449 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.xml]
        20:27:02,451 |-INFO in ch.qos.logback.classic.BasicConfigurator@5b1d2887 - Setting up default configuration.
        */
    }
}
