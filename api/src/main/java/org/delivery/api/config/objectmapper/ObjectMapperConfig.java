package org.delivery.api.config.objectmapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper(){
        var objectMapper = new ObjectMapper();

        objectMapper.registerModule(new Jdk8Module());

        objectMapper.registerModule(new JavaTimeModule());

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //모르는 JSON FIELD에 대해서는 무시
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        //날짜 관련 직려로하
        objectMapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);

        //스네이크 케이스
        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());

        return objectMapper;
    }

}
