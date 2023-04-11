package org.zerock.springex.sample;


import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString //toString 메소드 작성
/**
 * @root-context.xml에서 component-scan 설정을 달았을 경우
 * @Service annotation을 달지 않을 경우 @Autowired가 객체를 찾지 못하면서 compile error 발생
 */
@RequiredArgsConstructor //생성자 주입 어노테이션
public class SampleService {

    @Qualifier("normal") //@Qualifier의 역할 : 결합도가 낮은 객체를 주입받을 때 두가지 이상의 객체가 하나의 클래스에 주입 하려고 할 때, @Qualifier 어노테이션을 사용하여 지정해준다.
    private final SampleDAO sampleDAO;
}
