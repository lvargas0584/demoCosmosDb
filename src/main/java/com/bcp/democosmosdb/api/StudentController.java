package com.bcp.democosmosdb.api;

import com.bcp.democosmosdb.core.dto.StudentDto;
import com.bcp.democosmosdb.core.exception.StudentNotFoundException;
import com.bcp.democosmosdb.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/student")
public class StudentController extends BaseController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity saveStudent(@RequestBody StudentDto dto) {
        studentService.saveStudent(dto);
        return buildSuccessResponse();
    }

    @GetMapping
    public ResponseEntity getStudents() {
        return buildSuccessResponse(studentService.getStudents());
    }

    @PutMapping
    public ResponseEntity updateStudents(@RequestBody StudentDto dto) {
        studentService.saveStudent(dto);
        return buildSuccessResponse();
    }

    @DeleteMapping
    @RequestMapping("/{id}/{lastName}")
    public ResponseEntity deleteStudent(@PathVariable String id, @PathVariable String lastName) {
        studentService.deleteStudent(id, lastName);
        return buildSuccessResponse();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity getStudent(@PathVariable String id) {
        return buildSuccessResponse(studentService.getStudent(id));
    }
}
