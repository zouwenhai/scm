package com.qhkj.scm.common.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

/**
 * @author zouwenhai
 * @date 2021/4/1 10:04
 */
@Configuration
public class CustomerJackSon {


    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            builder.serializationInclusion(JsonInclude.Include.NON_ABSENT);
            builder.timeZone(TimeZone.getDefault());
            builder.featuresToDisable(new Object[]{DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS});
            builder.featuresToDisable(new Object[]{SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS});
            builder.featuresToDisable(new Object[]{DeserializationFeature.ACCEPT_FLOAT_AS_INT});
            builder.featuresToEnable(new Object[]{DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY});
            builder.featuresToEnable(new Object[]{MapperFeature.PROPAGATE_TRANSIENT_MARKER});
        };
    }
}
