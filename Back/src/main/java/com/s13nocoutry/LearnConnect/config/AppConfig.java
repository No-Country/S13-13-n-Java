package com.s13nocoutry.LearnConnect.config;

import com.s13nocoutry.LearnConnect.models.Chat.Chat;
import com.s13nocoutry.LearnConnect.models.Chat.ChatResponse;
import com.s13nocoutry.LearnConnect.models.Message.Message;
import com.s13nocoutry.LearnConnect.models.Message.MessageResponse;
import com.s13nocoutry.LearnConnect.models.photo.Photo;
import com.s13nocoutry.LearnConnect.models.photo.PhotoResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setSkipNullEnabled(true);

        // Configuración personalizada para mapear listas de mensajes
        modelMapper.createTypeMap(Chat.class, ChatResponse.class)
                .addMapping(src -> src.getMessages(), ChatResponse::setMessages)
                .addMapping(src -> src.getPhotos(), ChatResponse::setPhotos);

        modelMapper.createTypeMap(Message.class, MessageResponse.class);
        modelMapper.createTypeMap(Photo.class, PhotoResponse.class);


        /*
        // Configuración personalizada para el campo 'hour'
        modelMapper.createTypeMap(Message.class, MessageResponse.class)
                .addMappings(mapper -> mapper.using(ctx -> dateToString((Date) ctx.getSource())).map(Message::getHour, MessageResponse::setHour));
        */
        return new ModelMapper();
    }


}
