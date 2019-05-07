package com.fenghua.controller;

import com.fenghua.common.utils.JsonUtils;
import com.fenghua.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传Controller
 */
@Controller
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String picUpload(MultipartFile uploadFile) {
        try {
            //接收上传的文件
            //获取文件拓展名
            String originalFilename = uploadFile.getOriginalFilename();//dnf.jpg
            System.out.println(originalFilename);
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);//jpg
            System.out.println(extName);
            //上传到图片服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resources/client.conf");
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);//上传图片服务器成功后的获得的图片地址:group1/M00/00/00/wKgZhVzR11mALKbgAA9Pxso1WKY658.jpg
            System.out.println(url);
            url = IMAGE_SERVER_URL + url;//图片的访问地址(ip访问):http://192.168.25.133/group1/M00/00/00/wKgZhVzR11mALKbgAA9Pxso1WKY658.jpg
            System.out.println(url);
            //响应上传图片的url
            Map result = new HashMap<>();
            result.put("error", 0);
            result.put("url", url);
            return JsonUtils.objectToJson(result);/*解决浏览器兼容性问题*/
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return JsonUtils.objectToJson(result);/*解决浏览器兼容性问题*/
        }

    }
}
