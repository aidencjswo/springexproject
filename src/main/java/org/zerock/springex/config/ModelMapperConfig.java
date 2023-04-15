package org.zerock.springex.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 자바 클래스를 구성 요소로 선언하여 스프링 애플리케이션 컨텍스트에서 구성을 정의 하는데 사용
 * -> xml에서 <Bean></Bean> 태그를 사용하지 않고 자바 어노테이션을 사용하여 Bean을 등록할 수 있다.
 * -> 가독성과 유지보수가 좋아짐.
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        //@Bean 어노테이션을 사용하면 return되는 객체를 스프링의 Bean으로 등록할 수 있다.
        return modelMapper;
    }
}
