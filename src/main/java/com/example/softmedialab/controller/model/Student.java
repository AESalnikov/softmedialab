package com.example.softmedialab.controller.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author Anton Salnikov
 */

@Getter
@Builder
@Tag(name = "Студент")
public class Student {

    @Schema(name = "id",
            example = "123",
            description = "Идентификатор студента")
    @NotNull(message = "Поле id не заполнено")
    private Long id;

    @Schema(name = "fio",
            example = "Иванов Иван Иванович",
            description = "ФИО студента")
    @NotNull(message = "Поле fio не заполнено")
    private String fio;

    @Schema(name = "birthday",
            example = "2002-01-01",
            description =  "Дата рождения студента")
    @NotNull(message = "Поле birthday не заполнено")
    private LocalDate birthday;

    @Schema(name = "mark",
            example = "уд",
            description =  "Успеваемость")
    private String mark;

}
