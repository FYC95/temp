package fyc.epss.service.impl;

import fyc.epss.dao.OrdermapMapper;
import fyc.epss.domain.Ordermap;
import fyc.epss.domain.OrdermapExample;
import fyc.epss.service.CommonService;
import fyc.epss.service.OrdermapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ordermapService")
public class OrdermapServiceImpl implements OrdermapService {
    @Autowired
    private OrdermapMapper orderMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public Ordermap selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Ordermap> selectByExample(OrdermapExample example) {
        return null;
    }
}
