package com.bcp.democosmosdb.core.service.impl;

import com.bcp.democosmosdb.core.documents.AdrressDocument;
import com.bcp.democosmosdb.core.documents.StudentDocument;
import com.bcp.democosmosdb.core.dto.AdrressDto;
import com.bcp.democosmosdb.core.dto.StudentDto;
import com.bcp.democosmosdb.core.exception.StudentNotFoundException;
import com.bcp.democosmosdb.core.repository.StudentRepository;
import com.bcp.democosmosdb.core.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public StudentDto saveStudent(StudentDto dto) {
        StudentDocument studentDocument = new StudentDocument();
        BeanUtils.copyProperties(dto, studentDocument);
        AdrressDocument adrressDocument = new AdrressDocument();
        adrressDocument.setDistrict(dto.getAddress().getDistrict());
        adrressDocument.setNumber(dto.getAddress().getNumber());
        adrressDocument.setStreet(dto.getAddress().getStreet());
        studentDocument.setAddress(adrressDocument);
        StudentDocument save = studentRepository.save(studentDocument);
        dto.setId(save.getId());
        return dto;
    }


    @Override
    @Transactional
    public void deleteStudent(StudentDto dto) {
        StudentDocument studentDocument = new StudentDocument();
        studentDocument.setId(dto.getId());
        studentDocument.setLastName(dto.getLastName());
        BeanUtils.copyProperties(dto, studentDocument);
        AdrressDocument adrressDocument = new AdrressDocument();
        if (dto.getAddress() != null) {
            adrressDocument.setDistrict(dto.getAddress().getDistrict());
            adrressDocument.setNumber(dto.getAddress().getNumber());
            adrressDocument.setStreet(dto.getAddress().getStreet());
            studentDocument.setAddress(adrressDocument);
        }
        studentRepository.delete(studentDocument);
    }

    @Override
    public List<StudentDto> getStudents() {
        List<StudentDto> studentDtos = new ArrayList<>();

        studentRepository.findAll().forEach(document -> {
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(document, studentDto);
            if (document.getAddress() != null) {

                AdrressDto adress = new AdrressDto();
                adress.setDistrict(document.getAddress().getDistrict());
                adress.setStreet(document.getAddress().getStreet());
                adress.setNumber(document.getAddress().getNumber());
                studentDto.setAddress(adress);
            }
            studentDtos.add(studentDto);
        });
        return studentDtos;
    }

    @Override
    public StudentDto getStudent(String id) {
        StudentDto studentDto = new StudentDto();
        //StudentDocument document = studentRepository.findById(id).orElseThrow(NotFoundException::new);
        StudentDocument document = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

        BeanUtils.copyProperties(document, studentDto);
        if (document.getAddress() != null) {

            AdrressDto adress = new AdrressDto();
            adress.setDistrict(document.getAddress().getDistrict());
            adress.setStreet(document.getAddress().getStreet());
            adress.setNumber(document.getAddress().getNumber());
            studentDto.setAddress(adress);
        }

        return studentDto;
    }
}
