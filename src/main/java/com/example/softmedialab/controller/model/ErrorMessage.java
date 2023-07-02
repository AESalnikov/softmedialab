package com.example.softmedialab.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;

import java.util.List;

/**
 * @author Anton Salnikov
 */
@Builder
@Tag(name = "Сообщения об ошибках")
public class ErrorMessage {

    @Schema(name = "error_message",
            example = "[\"Студент уже существует!\"]")
    @JsonProperty("error_messages")
    List<String> messages;

}
