package fyc.epss.service;

import fyc.epss.dao.CommonMapper;
import fyc.epss.dao.OrdermapMapper;
import fyc.epss.domain.Ordermap;
import fyc.epss.domain.OrdermapExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface OrdermapService extends CommonService<Ordermap, OrdermapExample> {

}
