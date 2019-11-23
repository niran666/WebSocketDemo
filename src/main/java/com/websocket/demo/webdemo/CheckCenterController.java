package com.websocket.demo.webdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @ClassName : CheckCenterController
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/11/12
 **/

@RestController
@RequestMapping("/api")
public class CheckCenterController {

    //页面请求
    @GetMapping("/socket/pushall")
    public String socket(String message) {
        return "123";
    }
    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public String pushToWeb(@PathVariable String cid,String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            return cid+"#"+e.getMessage();
        }
        return cid;
    }
}
