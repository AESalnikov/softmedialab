package com.example.softmedialab.controller;

import com.example.softmedialab.controller.model.ErrorMessage;
import com.example.softmedialab.controller.model.Student;
import com.example.softmedialab.controller.request.MarksEditRequest;
import com.example.softmedialab.controller.response.StudentGetAllResponse;
import com.example.softmedialab.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Anton Salnikov
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
@Tag(name = "Справочник студентов")
public class StudentController {

    private final StudentService service;

    @Operation(
            description = "Получить список всех студентов",
            responses = {
                    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = StudentGetAllResponse.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "409", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")})
            })
    @GetMapping("/get_all")
    public ResponseEntity<StudentGetAllResponse> getAll() {
        StudentGetAllResponse response = new StudentGetAllResponse();
        response.setStudents(service.getAllStudents());
        return ResponseEntity.ok(response);
    }

    @Operation(
            description = "Добавить нового студента",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = Student.class))),
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "409", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")})
            })
    @PostMapping("/add_new")
    public ResponseEntity<Void> addNew(@Valid @RequestBody Student request) {
        service.addNewStudent(request);
        return ResponseEntity.ok().build();
    }

    @Operation(
            description = "Удалить студента",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "409", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")})
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            description = "Редактировать студента",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = Student.class))),
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "409", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")})
            })
    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody Student request) {
        service.editStudent(request);
        return ResponseEntity.ok().build();
    }

    @Operation(
            description = "Редактировать успеваемость",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = Student.class))),
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "409", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")}),
                    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json")})
            })
    @PutMapping("/edit_marks")
    public ResponseEntity<Void> edit(@RequestBody MarksEditRequest request) {
        service.editMarks(request);
        return ResponseEntity.ok().build();
    }

}
