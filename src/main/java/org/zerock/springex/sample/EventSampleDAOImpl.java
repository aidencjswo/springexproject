package org.zerock.springex.sample;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
/**
 * @Primary 어노테이션의 역할 : 결합도가 낮은 객체를 주입 받을 때, 어떤 객체를 주입 받을지 지정 해주는  역할
 */
@Qualifier("event")
public class EventSampleDAOImpl implements SampleDAO{
}
