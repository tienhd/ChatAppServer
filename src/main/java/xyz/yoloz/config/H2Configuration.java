package xyz.yoloz.config;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * Created by tienhd on 24/2/16.
 */
public class H2Configuration {

    Logger logger = LoggerFactory.getLogger(H2Configuration.class);

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        logger.info("H2 Db Server started");
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "8091", "-webAllowOthers");
    }
}
