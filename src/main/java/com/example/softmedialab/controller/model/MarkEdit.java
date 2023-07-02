package com.example.softmedialab.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

/**
 * @author Anton Salnikov
 */
@Data
@Tag(name = "Успеваемость")
public class MarkEdit {

    @Schema(name = "id",
            example = "123",
            description = "Идентификатор студента")
    private Long id;

    @Schema(name = "mark",
            example = "хор",
            description = "Успеваемость студента")
    @JsonProperty("text")
    private String mark;

}
