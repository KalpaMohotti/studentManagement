package com.example.demo.service;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Attendance;
import com.example.demo.entity.Student;
import com.example.demo.repo.AttendanceRepo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AttendanceService {
    @Autowired
    private AttendanceRepo attendanceRepo;
    @Autowired
    private ModelMapper modelMapper;

    public AttendanceDTO markAttendance(AttendanceDTO dto){
        attendanceRepo.save(modelMapper.map(dto, Attendance.class));
        return dto;
    }

    public List<AttendanceDTO> getAll(){
        List<Attendance> attendanceList=attendanceRepo.findAll();
        return modelMapper.map(attendanceList, new TypeToken<List<AttendanceDTO>>(){}.getType());
    }

    public AttendanceDTO getBystudentId(String id){
        List<Attendance> attendanceList=attendanceRepo.findAll();
        for(Attendance a: attendanceList){
            if(a.getStudentID()==Integer.parseInt(id)){
                AttendanceDTO d=new AttendanceDTO();
                d.setId(a.getId());
                d.setStudentID(a.getStudentID());
                d.setDate(a.getDate());
                d.setTime(a.getTime());
                return d;
            }
        }
        return null;
    }
}
