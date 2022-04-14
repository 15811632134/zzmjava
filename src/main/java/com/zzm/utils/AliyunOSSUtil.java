package com.zzm.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.zzm.config.AliyunOSSConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author huangxiaoming
 * @description 上传图片工具类
 * @date 2019/7/16 0016 下午 20:26
 */
@Slf4j
@Component
public class AliyunOSSUtil {

    private static OSSClient ossClients;

    @Autowired
    public AliyunOSSUtil(OSSClient ossClients) {
        AliyunOSSUtil.ossClients = ossClients;
    }

    @Autowired
    private AliyunOSSConfig aliyunOSSConfig;

    /**
     * 上传文件
     *
     * @param file
     * @param path
     * @return
     * @throws IOException
     */
    public String upload(MultipartFile file, String path) throws IOException {
        log.info("=========>OSS文件上传开始：" + file.getName());
        String bucketName = aliyunOSSConfig.getBucketName();
        if (null == file) {
            return null;
        }
        OSSClient ossClient = ossClients;
        try {
            //容器不存在，就创建
            if (!ossClient.doesBucketExist(bucketName)) {
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //创建文件路径
            String fileUrl = path + "/" + file.getOriginalFilename();
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl,
                    file.getInputStream()));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            fileUrl = aliyunOSSConfig.getFilehost() + "/" + fileUrl;
            if (null != result) {
                log.info("==========>OSS文件上传成功,OSS地址：" + fileUrl);
                return fileUrl;
            }
        } catch (OSSException oe) {
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.error(ce.getMessage());
        }
        return null;
    }

    /**
     * 删除文件
     *
     * @param fileName
     */
    public void delete(String fileName) {
        // 根据BucketName,fileName删除文件
        ossClients.deleteObject(aliyunOSSConfig.getBucketName(), fileName);
    }

    /**
     * 文件列表
     *
     * @param path
     * @return
     */
    public List<OSSObjectSummary> list(String path) {
        // 设置最大个数。
        final int maxKeys = 200;
        // 列举文件。
        ObjectListing objectListing = ossClients.listObjects(aliyunOSSConfig.getBucketName(), path);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        return sums;
    }


    /**
     * 下载文件
     *
     * @param os
     * @param fileName
     * @throws IOException
     */
    public void downLoad(OutputStream os, String fileName) throws IOException {
        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = ossClients.getObject(aliyunOSSConfig.getBucketName(), fileName);
        // 读取文件内容。
        BufferedInputStream in = new BufferedInputStream(ossObject.getObjectContent());
        BufferedOutputStream out = new BufferedOutputStream(os);
        byte[] buffer = new byte[1024];
        int lenght = 0;
        while ((lenght = in.read(buffer)) != -1) {
            out.write(buffer, 0, lenght);
        }
        if (out != null) {
            out.flush();
            out.close();
        }
        if (in != null) {
            in.close();
        }
    }
}
