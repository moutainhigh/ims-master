package com.yianju.ims.server.process.service;

import com.yianju.ims.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传下载管理器
 */
public interface FIleUploadManager {


    /**
     * 文件上传
     * @param uploadFile
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Result upload(MultipartFile uploadFile);

}
