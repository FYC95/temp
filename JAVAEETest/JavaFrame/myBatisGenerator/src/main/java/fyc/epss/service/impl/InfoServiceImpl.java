package fyc.epss.service.impl;

import fyc.epss.dao.InfoMapper;
import fyc.epss.domain.Info;
import fyc.epss.domain.InfoExample;
import fyc.epss.service.CommonService;
import fyc.epss.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "infoService")
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public Info selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<Info> selectByExample(InfoExample example) {
        return null;
    }
}
