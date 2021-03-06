/**
 * Copyright (c) 2016, 59store. All rights reserved.
 */
package com.store59.kylin.monitor.atals;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.metrics.atlas.AtlasTagProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:chenyb@59store.com">山人</a>
 * @version 1.0 16/8/15
 * @since 1.0
 */
@Configuration
@ConditionalOnBean(AtlasAutoConfiguration.class)
public class AtlasTagProviderConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(AtlasTagProviderConfiguration.class);

    @Bean
    AtlasTagProvider atlasCommonTags(@Value("${spring.application.name}") String appName) {
        return () -> {
            Map<String, String> map = new HashMap();
            map.put("app", appName);
            map.put("ip", InetUtils.getFirstNonLoopbackHostInfo().getIpAddress());
            return map;
        };
    }

}
