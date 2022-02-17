package com.example.demo.Controller;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/attendance")
@CrossOrigin
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark")
    public AttendanceDTO markAttendance(@RequestBody AttendanceDTO dto){
        attendanceService.markAttendance(dto);
        return dto;
    }

    @GetMapping("/getAll")
    public List<AttendanceDTO> getAll(){
        return attendanceService.getAll();
    }

    @GetMapping("/studentid")
    public  AttendanceDTO getbyStudentid(@RequestParam String id){
       return attendanceService.getBystudentId(id);
    }

    @GetMapping("/test")
    public String test(){
        return "Test ok";
    }

    @GetMapping("/getDate")
    public List<AttendanceDTO> getByDate(@RequestParam String date){

        return attendanceService.getByDate(date);


    }

}
