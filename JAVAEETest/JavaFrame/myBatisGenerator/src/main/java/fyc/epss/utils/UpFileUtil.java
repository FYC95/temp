package fyc.epss.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class UpFileUtil {
    public static String saveFile(MultipartFile upfile,String path){
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
        return newFileName;
    }
}
