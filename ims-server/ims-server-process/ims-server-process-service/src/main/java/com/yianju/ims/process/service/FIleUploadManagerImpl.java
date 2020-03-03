package com.yianju.ims.process.service;

import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.server.process.service.FIleUploadManager;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件管理实现
 */
@RestController
@ConfigurationProperties("file.config")
public class FIleUploadManagerImpl implements FIleUploadManager {


    private String path;

    public void setPath(String path){
        this.path = path;
    }


    @Override
    public Result upload(MultipartFile uploadFile) {


        System.out.println(path);
        System.out.println(uploadFile);
        System.out.println(uploadFile.getName());

    // 文件新路径
    String fileName = uploadFile.getOriginalFilename();
    String filePath = getFilePath(fileName);
    // 生成图片的绝对引用地址
    String picUrl = StringUtils.replace(StringUtils.substringAfter(filePath, path), "\\", "/");

        File newFile = new File(filePath); // 写文件到磁盘

        try {
            uploadFile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(ResultCode.FAIL);
        }

        return new Result(ResultCode.SUCCESS,path+picUrl);
    }


    private String getFilePath(String sourceFileName) {
        String baseFolder = path;
        Date nowDate = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int year = new Date().getYear();



        // yyyy/MM/dd
        String fileFolder = baseFolder + File.separator + year
                + File.separator + format.format(new Date());
        File file = new File(fileFolder);
        if (!file.isDirectory()) {
            // 如果目录不存在，则创建目录
            file.mkdirs();
        }
        // 生成新的文件名
        String fileName = sourceFileName;
        return fileFolder + File.separator + fileName;
    }

}
