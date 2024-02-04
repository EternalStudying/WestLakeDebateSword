package com.swyxl.model.dto.chat;

import com.swyxl.model.entity.chat.RequestMessage;
import lombok.Data;

@Data
public class ChatDto {
    private RequestMessage requestMessage;
    private String question;
}
