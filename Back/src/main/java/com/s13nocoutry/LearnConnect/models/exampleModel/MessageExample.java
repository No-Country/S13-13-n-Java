package com.s13nocoutry.LearnConnect.models.exampleModel;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageExample {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private StatusExample status;
}
