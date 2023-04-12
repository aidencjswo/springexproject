package org.zerock.springex.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("select now()") //@Select("쿼리") 작성 후 어떠한 매퍼 인터페이스를 설정했는지 root-context.xml에 등록해주어야함.
    String getTime();
}
/**
 * 위 방식은 추후 어노테이션이 변경 되면 프로젝트 전체를 리빌딩 해야 하는 우려가 있기 때문에 권장하지 않는 방식임.
 */