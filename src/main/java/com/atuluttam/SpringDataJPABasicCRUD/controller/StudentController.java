package com.atuluttam.SpringDataJPABasicCRUD.controller;


import com.atuluttam.SpringDataJPABasicCRUD.Model.Student;
import com.atuluttam.SpringDataJPABasicCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;



    @GetMapping()
    public List<Student> getAllStudent()
    {
         return studentService.getAllStudents();
    }

    @GetMapping("/id/{id}")
    public Student getById(@PathVariable Long id)
    {
            return studentService.getStudentById(id);
    }

    @GetMapping("/name/{name}")
    public List<Student> getByName(@PathVariable String name)
    {

        return studentService.getStudentByName(name);
    }

    @GetMapping("/namelike/{namelike}")
    public List<Student> getByNameLike(@PathVariable String namelike)
    {
        return studentService.getStudentByNameLike(namelike);
    }

    @GetMapping("/email/{email}")
    public List<Student> getByEmail(@PathVariable String email)
    {
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/emailcontains/{email}")
    public List<Student> getByEmailLike(@PathVariable String email)
    {
        return studentService.getStudentByEmailContaining(email);
    }

    @GetMapping("/age/{age}")
    public List<Student> getByAge(@PathVariable Integer age)
    {
        return studentService.getStudentByAge(age);
    }

    @GetMapping("/agegt/{age}")
    public List<Student> getByAgeGreaterthan(@PathVariable Integer age)
    {
        return studentService.getStudentByAgeGreaterthan(age);
    }

    @GetMapping("/total")
    public String allStudentCount()
    {
        return "Total Students"+studentService.totalStudents();
    }


    @GetMapping("/totalbetweenage")
    public String totalStudentBetweenAge(@RequestParam("start") Integer start, @RequestParam("end") Integer end )
    {
        return "Total Students in Age Group "+studentService.totalStudentsbetweenAge(start, end);
    }
//    http://localhost:8080/api/students/totalbetweenage?start=0&end=100


    @GetMapping("/avgage")
    public Double averageAge()
    {
        return studentService.averageOfAge();
    }


    @GetMapping("/avgagebycourse")
    public List<Object[]> avgagebycourse()
    {
        return studentService.avgAgeByCourse();
    }

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }

    @PostMapping("/saveall")
    public List<Student> createAllStudent(@RequestBody List<Student> students)
    {
        return studentService.saveAllStudent(students);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student)
    {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/id/{id}")
    public void deleteStudent(@PathVariable  Long id)
    {
        studentService.deleteStudent(id);
    }


    @DeleteMapping("/all")
    public void removeAllStudent()
    {
        studentService.deleteTotalStudent();
    }
}
