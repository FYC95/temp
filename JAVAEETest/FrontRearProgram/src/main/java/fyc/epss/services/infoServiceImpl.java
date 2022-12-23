package fyc.epss.services;

import fyc.epss.dao.CommonDao;
import fyc.epss.dao.foodDao;
import fyc.epss.dao.infoDao;
import fyc.epss.domain.FoodVO;
import fyc.epss.domain.food;
import fyc.epss.domain.info;
import fyc.epss.domain.infoVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class infoServiceImpl implements CommonService<info, infoVO>{
    private CommonDao<info> commonDao = new infoDao();
    @Override
    public Map<String,Object> queryAll(Integer startR, Integer pageSize, infoVO bvo) {

        String condition = " where 1=1 ";
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
                condition += "and id " +symbol +bvo.getId();
            }
            if (bvo.getPhone()!=null){
                condition += " and phone like '% " +bvo.getPhone() +" %'";
            }
        }


        Integer count = commonDao.count(condition);
        System.out.println(count);
        List<info> infoList = commonDao.selectAll(startR, pageSize,condition);
        //返回多个：1    MessageAndData，2    集合框架  map，3 分页信息类组装数据
        Map<String, Object> content = new HashMap<>();
        content.put("startNum",startR);
        content.put("pageSize",pageSize);
        content.put("total",count);
        content.put("pageListLength",5);
        content.put("list",infoList);
        return content;
    }
    @Override
    public Boolean deleteOne(Integer id){
        Boolean b = commonDao.deleteByPrimaryKey(id);
        return b;
    }

    public Boolean addOne(info obj){
        Boolean b = commonDao.insertSelective(obj);
        return b;
    }

    public Integer updateOne(info obj){
        int i = commonDao.updateSelective(obj);
        return i;
    }

    public info selectOne(Integer id){
        info bu = commonDao.selectByPrimaryKey(id);
        return bu;
    }
}




