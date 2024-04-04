package com.swyxl.common.controller;

import com.swyxl.common.service.ChatService;
import com.swyxl.model.dto.chat.ChatDto;
import com.swyxl.model.vo.service.chat.ChatVo;
import com.swyxl.model.vo.common.Result;
import com.swyxl.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service/common/auth/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping
    public Result chat(String question){
        String answer = chatService.chat(question);
        return Result.build(answer, ResultCodeEnum.SUCCESS);
    }
}
