package com.proyectoTest.demo.infrastructure;

import com.proyectoTest.demo.application.ChatService;
import com.proyectoTest.demo.domain.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final ChatService chatService;

    public WebSocketController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/chat")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        // Envía el mensaje a través del servicio
        chatService.sendMessage(chatMessage);
        return chatMessage;
    }
}