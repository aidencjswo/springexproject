package org.zerock.springex.sample;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
/**
 * ExtendWith : JUnit5에서 제공
 * 테스트 실행시 테스트 클래스 또는 메소드를 확장 할 수 있는 방법 제공
 * SpringExtension.class -> SpringFramework에서 제공하는 기능을 활용할 수 있는 확장을 적용 할 수 있음.
 */
@ExtendWith(SpringExtension.class)
/**
 * ContextConfiguration : 스프링 테스트 프레임워크에서 제공하는 어노테이션임.
 * 테스트 실행 시 ApplicationContext를 생성하고 설정 파일을 로드하는 방법을 지정
 * locations 나 value 설정으로 컨텍스트 설정 파일의 위치 지정 가능
 * 지정된 설정 파일은 테스트 실행 시 ApplicationContext를 생성할 때 로드되어 테스트에서 사용할 수 있는 Bean으로 등록
 */
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {
    @Autowired
    private SampleService sampleService;

    @Test
    public void testService1(){
        log.info(sampleService);
        /**
         * Asssertions : JUnit5에서 제공
         * 1. 결과 검증
         * 2. assertNotNull : 객체가 null이 아님을 검증하는 method
         * 2-1. 검증하고자 하는 객체가 null이라면 AssertionError를 발생
         */
        Assertions.assertNotNull(sampleService);
    }

}
