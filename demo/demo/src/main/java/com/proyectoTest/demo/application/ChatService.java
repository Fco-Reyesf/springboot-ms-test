package com.proyectoTest.demo.application;

import com.proyectoTest.demo.domain.ChatMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMessage(ChatMessage chatMessage) {
        // Envía el mensaje a todos los suscriptores del tema "/topic/chat"
        messagingTemplate.convertAndSend("/topic/chat", chatMessage);
    }
}