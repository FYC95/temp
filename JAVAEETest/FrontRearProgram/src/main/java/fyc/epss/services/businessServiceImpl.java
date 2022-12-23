package fyc.epss.services;

import fyc.epss.dao.BusinessDao;
import fyc.epss.dao.CommonDao;
import fyc.epss.domain.BusinessVO;
import fyc.epss.domain.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class businessServiceImpl implements CommonService<business, BusinessVO>{
    private CommonDao<business> commonDao = new BusinessDao();
    @Override
    public Map<String,Object> queryAll(Integer startR, Integer pageSize, BusinessVO bvo) {

        String condition = "where 1=1 ";
        if (bvo==null){
            System.out.println("没有符合搜索条件的记录");
        }else {
            if (bvo.getCon()!=null && bvo.getId()!=null){
                String symbol="";
                switch (bvo.getCon()){
                    case "大于":symbol = ">";break;
                    case "等于":symbol = "=";break;
                    case "小于":symbol = "<";break;
                }
                condition += "and id" +symbol +bvo.getId();
            }
            if (bvo.getBusinessName()!=null){
                condition += "and businessName like '%" +bvo.getBusinessName() +"%'";
            }
        }

//        condition += "where id " +bvo.getCon() +bvo.getId()
//        and bname like %bvo.getBusinessName()%

        Integer count = commonDao.count(condition);
        List<business> businessList = commonDao.selectAll(startR, pageSize,condition);
        //返回多个：1    MessageAndData，2    集合框架  map，3 分页信息类组装数据
        Map<String, Object> content = new HashMap<>();
        content.put("startNum",startR);
        content.put("pageSize",pageSize);
        content.put("total",count);
        content.put("pageListLength",5);
        content.put("list",businessList);
        return content;
    }
    @Override
    public Boolean deleteOne(Integer id){
        Boolean b = commonDao.deleteByPrimaryKey(id);
        return b;
    }

    public Boolean addOne(business obj){
        Boolean b = commonDao.insertSelective(obj);
        return b;
    }

    public Integer updateOne(business obj){
        int i = commonDao.updateSelective(obj);
        return i;
    }

    public business selectOne(Integer id){
        business bu = commonDao.selectByPrimaryKey(id);
        return bu;
    }


}
