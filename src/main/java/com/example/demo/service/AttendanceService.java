package com.example.demo.service;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.entity.Attendance;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.AttendanceRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    public List<AttendanceDTO> getByDate(String date){
        List<Attendance> attendanceList=attendanceRepo.findAll();
        List<AttendanceDTO> atd=new ArrayList<>();



        for(Attendance a:attendanceList){
            if(a.getDate().equals(date)){
               AttendanceDTO d=new AttendanceDTO();
               d.setId(a.getId());
               d.setDate(a.getDate());
               d.setTime(a.getTime());
               d.setStudentID(a.getStudentID());
               atd.add(d);

            }
        }

        if(atd.isEmpty()){
            throw  new ResourceNotFoundException("not found resource");
        }

        return atd;
    }
}
