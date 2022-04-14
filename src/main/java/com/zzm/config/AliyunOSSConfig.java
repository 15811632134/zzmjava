package com.zzm.config;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangxiaoming
 * @description 阿里云OSS配置
 * @date 2019/7/16 0016 下午 20:26
 */
@Data
@Configuration
@ConfigurationProperties("aliyun.oss")
public class AliyunOSSConfig {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private Integer expire;
    private Integer maxSize;
    private String filehost;


    @Bean("ossClients")
    public OSSClient ossClients(){
        return new OSSClient(endpoint,accessKeyId,accessKeySecret);
    }
}
