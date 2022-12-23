package fyc.epss.service;

import fyc.epss.dao.CommonMapper;
import fyc.epss.dao.InfoMapper;
import fyc.epss.domain.Info;
import fyc.epss.domain.InfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface InfoService extends CommonService<Info, InfoExample> {

}
