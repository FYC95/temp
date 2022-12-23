package fyc.epss.service;

import fyc.epss.dao.BusinessMapper;
import fyc.epss.dao.CommonMapper;
import fyc.epss.dao.FoodMapper;
import fyc.epss.dao.OrdermapMapper;
import fyc.epss.domain.Business;
import fyc.epss.domain.BusinessExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface BusinessService extends CommonService<Business, BusinessExample> {

}
