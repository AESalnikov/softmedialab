package com.example.softmedialab.controller.request;

import com.example.softmedialab.controller.model.MarkEdit;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.util.List;

/**
 * @author Anton Salnikov
 */
@Data
@Tag(name = "Запрос на редактирование успеваемости")
public class MarksEditRequest {

    private List<MarkEdit> marks;

}
