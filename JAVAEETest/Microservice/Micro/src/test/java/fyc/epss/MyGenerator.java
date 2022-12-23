package fyc.epss;
import java.util.Collections;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MyGenerator {

    private static final String URL = "jdbc:mysql://localhost:3310/ele_se?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "000000";
    private static final String PACKAGE_NAME = "fyc.epss";
    private static final String AUTHOR_NAME = "fangyuchao";
    private static final String OUTDIR_JAVA = "D:\\JAVAProgram\\JAVAEETest\\Microservice\\Micro\\src\\main\\java";
    private static final String OUTDIR_XML = "D:\\JAVAProgram\\JAVAEETest\\Microservice\\Micro\\src\\main\\resources\\mapper";

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author(AUTHOR_NAME) // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(OUTDIR_JAVA) // 指定输出目录
                            .disableOpenDir();    // 禁止打开输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(PACKAGE_NAME) // 设置包名
                            .entity("domain")         //设置实体类包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, OUTDIR_XML)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("admin","info","business","ordermap","food") // 设置需要生成的表名
                            .controllerBuilder()   //这里写controllerBuilder，表示将开始controller配置
                            .enableRestStyle();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}