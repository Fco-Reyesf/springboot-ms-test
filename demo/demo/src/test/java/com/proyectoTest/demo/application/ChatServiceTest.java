package com.proyectoTest.demo.application;

import com.proyectoTest.demo.domain.ChatMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ChatServiceTest {

    @Mock
    private SimpMessagingTemplate messagingTemplate;

    @InjectMocks
    private ChatService chatService;

    @Test
    public void testSendMessage() {
        // Crear un mensaje de prueba
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSender("Alice");
        chatMessage.setContent("Hello, Bob!");

        // Llamar al método bajo prueba
        chatService.sendMessage(chatMessage);

        // Verificar que el mensaje se envió correctamente
        verify(messagingTemplate).convertAndSend("/topic/chat", chatMessage);
    }
}