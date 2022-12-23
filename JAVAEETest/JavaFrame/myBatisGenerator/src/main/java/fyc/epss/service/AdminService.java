package fyc.epss.service;

import fyc.epss.dao.*;
import fyc.epss.domain.Admin;
import fyc.epss.domain.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface AdminService extends CommonService<Admin, AdminExample>{
    Admin loginCheck(Admin admin);
}
