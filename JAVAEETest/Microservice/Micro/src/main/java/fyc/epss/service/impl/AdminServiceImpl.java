package fyc.epss.service.impl;

import fyc.epss.domain.Admin;
import fyc.epss.mapper.AdminMapper;
import fyc.epss.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author fangyuchao
 * @since 2022-12-12
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
