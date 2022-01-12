package {package}.{project.name}.bootstrap;

import com.cic.irc.utils.id.snowflake.SnowFlakeGenerator;
import io.openmessaging.api.MessagingAccessPoint;
import io.openmessaging.api.OMS;
import io.openmessaging.api.OMSBuiltinKeys;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Properties;

@SpringBootApplication(scanBasePackages = "{package}")
@MapperScan("{package}.{project.name}.infrastructure.repository.mapper")
@EnableAsync
public class BootstrapApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(BootstrapApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
        LOGGER.info("init success");
    }
}
