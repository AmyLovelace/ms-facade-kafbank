package com.ppj.acl.config;


import com.ppj.acl.config.property.KafkaProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;


@Configuration
@Slf4j
public class KafkaConfig {

    private final KafkaProperty kafkaProperty;

    public KafkaConfig(KafkaProperty kafkaProperty) {
        this.kafkaProperty = kafkaProperty;
    }

    @Bean
    public NewTopic accountTopic(){
        Map<String,String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, kafkaProperty.getRetentionMsConfig());
        log.error(kafkaProperty.getDummy());

        return TopicBuilder.name(kafkaProperty.getTopicName())
                .configs(configurations)
                .build();
    }
}
