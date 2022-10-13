package configuration;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author youzh
 * @version 1.0
 * @project JavaStudy
 * @description how to configurate the logback.xml
 * @date 2022/10/13 20:49:31
 */

/*
 * @author: youzh
 * @Date: 2022/10/13 20:49
 * @Version: 1.0
 */
public class LogbackConfig {
    final static Logger logger = LoggerFactory.getLogger(LogbackConfig.class);

    public static void main(String[] args) {
        /*
            after a OnConsoleStatusListener configurated in
            onConsoleStatusListener.xml, no need to call StatusPrinter.print()
            explicitly.
        */
        // LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        // StatusPrinter.print(lc);

        /* logback`s internal messages
        21:23:20,633 |-INFO in ch.qos.logback.classic.LoggerContext[default] - This is logback-classic version 1.4.4
        21:23:20,660 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Found resource [logback-test.xml] at [file:/D:/JAVA/JavaStudy/out/production/Log/logback-test.xml]
        21:23:20,753 |-INFO in ch.qos.logback.core.model.processor.AppenderModelHandler - Processing appender named [STDOUT]
        21:23:20,753 |-INFO in ch.qos.logback.core.model.processor.AppenderModelHandler - About to instantiate appender of type [ch.qos.logback.core.ConsoleAppender]
        21:23:20,790 |-INFO in ch.qos.logback.classic.model.processor.RootLoggerModelHandler - Setting level of ROOT logger to DEBUG
        21:23:20,790 |-INFO in ch.qos.logback.core.model.processor.AppenderRefModelHandler - Attaching appender named [STDOUT] to Logger[ROOT]
        21:23:20,791 |-INFO in ch.qos.logback.core.model.processor.DefaultProcessor@70beb599 - End of configuration.
        21:23:20,792 |-INFO in ch.qos.logback.classic.joran.JoranConfigurator@4e41089d - Registering current configuration as safe fallback point
        */

        logger.info("Entering application.");

        String s = "This is a string.";
        char[] chars = s.toCharArray(); // no errors
        logger.debug("String -> char[]");

        int a = 3, b = 0;
        try {
            int c = a / b;
        } catch (Exception e) {
            // e.printStackTrace();
            logger.error("error: " + e);
        }

        // make .log file exceed the maxFileSize=1KB
//        for (int i = 0; i < 100000; i++) {
//            logger.debug("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        }
        

        logger.info("Exiting application.");

        /* first logback-test.xml, if not, then logback.xml
        21:18:53.763 [main] INFO  configuration.LogbackConfig - Entering application.
        21:18:53.765 [main] DEBUG configuration.LogbackConfig - String -> char[]
        21:18:53.765 [main] INFO  configuration.LogbackConfig - Exiting application.
        java.lang.ArithmeticException: / by zero
	        at configuration.LogbackConfig.main(LogbackConfig.java:31)
        */
    }
}
