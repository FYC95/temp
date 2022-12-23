package fyc.epss.controller;

import fyc.epss.utils.DataFlexPacking;
import fyc.epss.utils.UpFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@ResponseBody
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/uploadone")
    // 必须要有MultipartFile类型参数。而且参数名必须与表单file控件名一致
    public String upload(@RequestParam(value = "upfile" ,required = false )MultipartFile upfile) {
        //上传图片存储目录
        String path = "G:/A/upload";
//        String path = "d:/upload";
        //获取文件名并使用UUID生成新文件名
        String fileName = upfile.getOriginalFilename();
        String newFileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        //在指定上传图片存储目录中创建新文件
        File targetFile = new File(path, newFileName);
        //如果找不到指定目录和文件，就新创建此目录和文件
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //将文件写入硬盘（myFile在内存中）
        try {
            upfile.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }


    @RequestMapping("/uploads")
    // 必须要有MultipartFile类型参数。而且参数名必须与表单file控件名一致
    public DataFlexPacking uploads(@RequestParam(value = "upfiles" ,required = false )MultipartFile[] upfiles) {
        List<String> retFileName = new ArrayList<>();
        if (upfiles!=null && upfiles.length>0){
            String path = "G:/A/upload";
            //循环遍历上传文件
            for (int i = 0; i < upfiles.length; i++) {
                retFileName.add(UpFileUtil.saveFile(upfiles[i],path));
            }
            System.out.println(retFileName);
        }
        return DataFlexPacking.success("上传成功").add("nameList",retFileName);
    }


}
