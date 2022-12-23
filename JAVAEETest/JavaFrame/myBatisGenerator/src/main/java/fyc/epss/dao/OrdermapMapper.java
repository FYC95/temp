package fyc.epss.dao;

import fyc.epss.domain.Ordermap;
import fyc.epss.domain.OrdermapExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface OrdermapMapper extends CommonMapper<Ordermap, OrdermapExample> {

}