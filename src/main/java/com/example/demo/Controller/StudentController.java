package com.example.demo.Controller;


import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/students")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping("/save")
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO){
       return studentService.saveStudent(studentDTO);
    }

    @GetMapping("/getAll")
    public List<StudentDTO> getStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/update")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO);
    }
    //@PostMapping("/delete")
    @DeleteMapping("/delete")
    public boolean deleteStudent(@RequestBody StudentDTO studentDTO){
        return studentService.deleteStudent(studentDTO);
    }

    //public List<StudentDTO> getStudentById(@RequestParam String id){
    @GetMapping("/getid")
        public StudentDTO getStudentById(@RequestParam String id){
       // StudentDTO s=studentService.getStudentById(id);


            return studentService.getStudentById(id);

    }

    @GetMapping("/getCount")
    public long getCount(){
        long l=studentService.getCount();
       // if(l==2){
       //     throw  new ResourceNotFoundException("not found resource");
      //  }else {

           // return studentService.getCount();
            return l;
      //  }
    }

    @GetMapping("/test")
    public String test(){
        return "Test Success";
    }

}
