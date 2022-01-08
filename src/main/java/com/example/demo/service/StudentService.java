package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO saveStudent(StudentDTO dto){
    studentRepo.save(modelMapper.map(dto, Student.class));
    return dto;
    }

    public List<StudentDTO> getAllStudents(){
        List<Student> studentList=studentRepo.findAll();
       return modelMapper.map(studentList,new TypeToken<List<StudentDTO>>(){}.getType());
    }

    public StudentDTO updateStudent(StudentDTO studentDTO){
        studentRepo.save(modelMapper.map(studentDTO,Student.class));
        return studentDTO;

    }

    public boolean deleteStudent(StudentDTO studentDTO){
        studentRepo.delete(modelMapper.map(studentDTO,Student.class));
       return true;
    }

    public StudentDTO getStudentById(String id){
       Student s= studentRepo.getById(Integer.parseInt(id));
       StudentDTO ss=new StudentDTO();
       ss.setId(s.getId());
       ss.setName(s.getName());
       ss.setAddress(s.getAddress());
       ss.setDob(s.getDob());
       ss.setMobile(s.getMobile());
       ss.setEmail(s.getEmail());
        return ss;

    }

    public long getCount(){
        return studentRepo.count();

    }





}
