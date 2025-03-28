package dev.rsd.LogLLMSummary;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan
public class LogSummaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogSummaryApplication.class, args);
    }
}

}
