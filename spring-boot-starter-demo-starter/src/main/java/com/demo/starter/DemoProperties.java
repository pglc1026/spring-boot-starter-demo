package com.demo.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Will Liu
 * @date 2022/1/11
 */
@Data
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {

    private String host;

    private String port;

    private Long connectTimeout;

    private Long readTimeout;

    private Long writeTimeout;

}
