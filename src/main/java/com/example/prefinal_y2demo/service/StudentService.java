package com.example.prefinal_y2demo.service;

import com.example.prefinal_y2demo.DTO.StudentRequestDTO;
import com.example.prefinal_y2demo.entity.Student;
import com.example.prefinal_y2demo.execeptions.CustomExceptionBadRequest;
import com.example.prefinal_y2demo.execeptions.CustomExceptionNotFound;
import com.example.prefinal_y2demo.execeptions.ErrorResponse;
import com.example.prefinal_y2demo.repository.StudentRepository;
import com.example.prefinal_y2demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
//    private final Path fileStorageLocation;
//    @Autowired
//    public StudentService(FileStorageProperties fileStorageProperties) {
//        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
//                .toAbsolutePath().normalize();
//        try {
//            Files.createDirectories(this.fileStorageLocation);
//        } catch (Exception ex) {
//            throw new RuntimeException(
//                    "Could not create the directory where the uploaded files will be stored.", ex);
//        }
//
//    }

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private SubjectRepository subjectRepository ; 
    
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public  Student findStudentByID(Integer studentNumber){
        return studentRepository.findById(studentNumber).orElseThrow(()->new CustomExceptionNotFound("student number: "+studentNumber,"studentNumber" ));
    }
    public Student AddStudent(StudentRequestDTO studentDTO){
        Student student = new Student();
        return getStudent(studentDTO, student);
    }

    private Student getStudent(StudentRequestDTO studentDTO, Student student) {
        CustomExceptionBadRequest error = new CustomExceptionBadRequest("Error") ;
        if( studentDTO.getFirstName().length()>10) {
            error.addListError(new ErrorResponse.ValidationError("FirstName","FirstName invalid"));
        }
        if(studentDTO.getLastName().length()>10){
            error.addListError(new ErrorResponse.ValidationError("LastName invalid","LastName"));
        }




        if(error.getListError().size()!=0){throw error ;}
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setMajor(studentDTO.getMajor());
        student.setSubjectId(subjectRepository.findById(studentDTO.getSubjectId()).orElseThrow(()->new CustomExceptionNotFound( "subject id : " +studentDTO.getSubjectId(),"SubjectId")));
        return studentRepository.saveAndFlush(student);
    }

    public void DeleteStudent(Integer studentNumber){
        studentRepository.deleteById(studentNumber);
    }

    public Student updateStudent(Integer studentNumber ,StudentRequestDTO studentDtoUpdate){
         Student studentExist =  studentRepository.findById(studentNumber).orElseThrow(()->new CustomExceptionNotFound("student id : "+studentNumber,"studentNumber" )) ;
        return getStudent(studentDtoUpdate, studentExist);
    }


}
