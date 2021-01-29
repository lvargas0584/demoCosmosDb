package com.bcp.democosmosdb.api;

import com.bcp.democosmosdb.core.dto.StudentDto;
import com.bcp.democosmosdb.core.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController extends BaseController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    StudentService studentService;

    @PostMapping//[POST]/v1/student
    public ResponseEntity saveStudent(@RequestBody StudentDto dto) {
        logger.info("CALL TO SAVE STUDENT");
        return buildSuccessResponse(studentService.saveStudent(dto));
    }

    @GetMapping
    public ResponseEntity getStudents() {
        List<StudentDto> dtos = studentService.getStudents();
        logger.info("CALL TO GET STUDENT " + dtos.size());
        return buildSuccessResponse(dtos);
    }

    @PutMapping
    public ResponseEntity updateStudents(@RequestBody StudentDto dto) {
        logger.info("CALL TO UPDATE STUDENT");
        studentService.saveStudent(dto);
        return buildSuccessResponse();
    }

    @DeleteMapping
    public ResponseEntity deleteStudent(@RequestBody StudentDto dto) {
        logger.info("CALL TO DELETE STUDENT");
        studentService.deleteStudent(dto);
        return buildSuccessResponse();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getStudent(@PathVariable("id") String id) {
        logger.info("CALL TO GET STUDENT " + id);
        return buildSuccessResponse(studentService.getStudent(id));
    }
}
