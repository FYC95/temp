package fyc.epss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fyc.epss.domain.food;
import fyc.epss.domain.info;
import fyc.epss.services.foodServiceImpl;
import fyc.epss.services.infoServiceImpl;
import fyc.epss.utils.DataFlexPacking;
import fyc.epss.utils.Upload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//该Serlet的目的是添加商家
@WebServlet(urlPatterns = "/info/addOneWithFile1.do")
public class infoAddServletWithFile1 extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        Map<String, String> aList = new HashMap<>();//存储表单字符字段的map
        List<FileItem> list = null;//储存提交数据的段
        String filename = null;//文件名

        try {
            list = upload.parseRequest(req);//当前例子中， list有2段
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


        for (FileItem item : list) {
            //如果fileitem中封装的是普通输入项的数据
            if (item.isFormField()) {//普通的表单字段
                String name = item.getFieldName();//infoData
                String value = item.getString("UTF-8");//businessName=helloworld&password=123&businessExplain=234
                value = URLDecoder.decode(value, "utf-8");
                for (String s : value.split("&")) {
                    String[] args = s.split("=");
                    aList.put(args[0], args[1]);
                }

                //System.out.println("name" + name + "value" + value);
                continue;
            } else {//如果fileitem中封装的是上传文件
                InputStream stream = item.getInputStream();//上传文件需要的文件流参数
                filename = item.getName();   //上传文件需要的参数


                //String savepath = getServletContext().getRealPath("/WEB-INF/upload");
                String savepath = "G:\\A\\upload";
                File path = new File(savepath);  //这个要自己写具体的路径，是需要上传文件需要的参数
                Upload.uploadFile(stream, path, filename);   //调用工具类方法
//                if (filename == null || filename.trim().equals("")) {
//                    //判空处理}
//                    continue;
            }
        }
        //开始顺序取非文件参数



        //获取客户端传递过来的数据值
        Integer businessName = Integer.valueOf(aList.get("businessName"));
        Boolean password = Boolean.valueOf(aList.get("password"));
        String businessExplain = aList.get("businessExplain");
        String businessAddress = filename;


        info info = new info(businessName,businessExplain,businessAddress,password);
        //调用service执行查询业务
        infoServiceImpl infoService = new infoServiceImpl();
        Boolean num = infoService.addOne(info);
        //封装查询结果
        DataFlexPacking mad = null;
        if (!num)
            mad = DataFlexPacking.fail("添加信息失败");
        else
            mad = DataFlexPacking.success("添加信息成功");
        //转换为JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String ret = objectMapper.writeValueAsString(mad);
        //返回给view,因为是前后端分离，交互JSON数据，需要告知客户端
        PrintWriter writer = resp.getWriter();
        writer.print(ret);
        writer.flush();
        writer.close();
    }
}
