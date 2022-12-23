package fyc.epss.services;

import fyc.epss.dao.CommonDao;
import fyc.epss.dao.infoDao;
import fyc.epss.dao.orderMapDao;
import fyc.epss.domain.info;
import fyc.epss.domain.infoVO;
import fyc.epss.domain.orderMap;
import fyc.epss.domain.orderMapVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class orderMapServiceImpl implements CommonService<orderMap, orderMapVO>{
    private CommonDao<orderMap> commonDao = new orderMapDao();
    @Override
    public Map<String,Object> queryAll(Integer startR, Integer pageSize, orderMapVO bvo) {

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
                condition += " and id " +symbol +bvo.getId();
            }
            if (bvo.getAid()!=null){
                condition += "and aid like '% " +bvo.getAid() +" %'";
            }
        }


        Integer count = commonDao.count(condition);
        System.out.println(count);
        List<orderMap> ordermapList = commonDao.selectAll(startR, pageSize,condition);
        //返回多个：1    MessageAndData，2    集合框架  map，3 分页信息类组装数据
        Map<String, Object> content = new HashMap<>();
        content.put("startNum",startR);
        content.put("pageSize",pageSize);
        content.put("total",count);
        content.put("pageListLength",5);
        content.put("list",ordermapList);
        return content;
    }
    @Override
    public Boolean deleteOne(Integer id){
        Boolean b = commonDao.deleteByPrimaryKey(id);
        return b;
    }

    public Boolean addOne(orderMap obj){
        Boolean b = commonDao.insertSelective(obj);
        return b;
    }

    public Integer updateOne(orderMap obj){
        int i = commonDao.updateSelective(obj);
        return i;
    }

    public orderMap selectOne(Integer id){
        orderMap bu = commonDao.selectByPrimaryKey(id);
        return bu;
    }
}




