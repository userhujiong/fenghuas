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
 * 实现思路:
 *  前台每一张图片都会请求一次该Controller
 *  Controller获取到文件的上传文件MultipartFile(文件二进制和文件名称)
 *  根据MultipartFile中的文件名,获取到文件的拓展名,然后将文件上传到FastFDS,采用二进制流+拓展名的方式
 *  上传成功后返回图片在FastFDS中的存储位置,要想访问图片服务器中的该图片还需要根据图片所在服务器的IP来访问:http://服务器ip/服务器图片地址
 *  返回图片地址,前台使用返回的地址访问图片并回显
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
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);//jpg
            //上传到图片服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resources/client.conf");
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);//上传图片服务器成功后的获得的图片地址:group1/M00/00/00/wKgZhVzR11mALKbgAA9Pxso1WKY658.jpg
            url = IMAGE_SERVER_URL + url;//图片的访问地址(ip访问):http://192.168.25.133/group1/M00/00/00/wKgZhVzR11mALKbgAA9Pxso1WKY658.jpg
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
