package fyc.epss.service.impl;

import fyc.epss.domain.Info;
import fyc.epss.mapper.InfoMapper;
import fyc.epss.service.IInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 详细信息表 服务实现类
 * </p>
 *
 * @author fangyuchao
 * @since 2022-12-12
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

}
