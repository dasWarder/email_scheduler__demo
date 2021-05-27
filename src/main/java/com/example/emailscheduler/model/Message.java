package com.example.emailscheduler.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String to;

    private String body;

    private String topic;
}
