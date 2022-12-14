package ru.demoChat.demoChat.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private int id;
    private LocalDateTime sendingTime;
    private User sender;
    private User receiver;
    private String text;
}
