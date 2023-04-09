package org.zerock.springex.sample;


import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@ToString //toString 메소드 작성

/**
 * @root-context.xml에서 component-scan 설정을 달았을 경우
 * @Service annotation을 달지 않을 경우 @Autowired가 객체를 찾지 못하면서 compile error 발생
 */
@Service
@RequiredArgsConstructor //생성자 주입 어노테이션
public class SampleService {
    private final SampleDAO sampleDAO;
}
