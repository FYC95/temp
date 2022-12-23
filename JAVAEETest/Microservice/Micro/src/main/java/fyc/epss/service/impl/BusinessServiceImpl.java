package fyc.epss.service.impl;

import fyc.epss.domain.Business;
import fyc.epss.mapper.BusinessMapper;
import fyc.epss.service.IBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商家信息表 服务实现类
 * </p>
 *
 * @author fangyuchao
 * @since 2022-12-12
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {

}
