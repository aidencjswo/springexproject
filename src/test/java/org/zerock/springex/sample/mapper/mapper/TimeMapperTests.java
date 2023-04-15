package org.zerock.springex.sample.mapper.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.mapper.TimeMapper;
import org.zerock.springex.mapper.TimeMapper2;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests {
    @Autowired(required = false)//required=false 설정 : 객체를 주입 받지 못해도 예외가 발생하지 않는다.
    private TimeMapper2 timeMapper2;

    @Test
    public void testNow(){
        log.info(timeMapper2.getNow());
    }

}
