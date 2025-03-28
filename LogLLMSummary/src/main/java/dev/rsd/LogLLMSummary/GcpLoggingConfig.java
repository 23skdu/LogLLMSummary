package dev.rsd.LogLLMSummary;
import com.google.cloud.logging.v2.LoggingClient;
import com.google.cloud.logging.v2.LoggingSettings;
import com.google.cloud.logging.v2.MetricServiceV2Client;
import com.google.cloud.logging.v2.MetricServiceV2Settings;
import com.google.cloud.logging.v2.stub.LoggingServiceV2StubSettings;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ConfigurationProperties(prefix = "gcp.logging")
@Data
public class GcpLoggingConfig {

    private String projectId;
    private String logName;
    private int batchSize;
    private String filter;
    private int logRetrievalLimit;

    //Create Logging Client
    public LoggingClient loggingClient() throws IOException {
        LoggingServiceV2StubSettings.Builder builder = LoggingServiceV2StubSettings.newBuilder();
        LoggingSettings.Builder settingsBuilder = LoggingSettings.newBuilder();
        settingsBuilder.setStubSettings(builder);
        return LoggingClient.create(settingsBuilder.build());
    }

    //Create Metric Service Client
    public MetricServiceV2Client metricClient() throws IOException {
        return MetricServiceV2Client.create(
                MetricServiceV2Settings.newBuilder().build());
    }
}
