package fyc.epss.dao;

import fyc.epss.domain.Info;
import fyc.epss.domain.InfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface InfoMapper extends CommonMapper<Info, InfoExample> {
    //
    Info selectByPrimaryKeyWithObj(Integer id);
}