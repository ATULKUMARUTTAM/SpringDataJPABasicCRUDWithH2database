package com.atuluttam.SpringDataJPABasicCRUD.service;

import com.atuluttam.SpringDataJPABasicCRUD.Model.Student;
import com.atuluttam.SpringDataJPABasicCRUD.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public List<Student> getAllStudents(){
       return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getStudentByName(String name)
    {

        return studentRepository.findByname(name);
    }

    public List<Student> getStudentByNameLike(String name)
    {

        return studentRepository.findBynamelike(name);
    }

    public List<Student> getStudentByAge(Integer age)
    {
        return studentRepository.findByage(age);
    }

    public List<Student> getStudentByAgeGreaterthan(Integer age)
    {
        return studentRepository.findByAgeGreaterThan(age);
    }

    public List<Student> getStudentByEmail(String name)
    {

        return studentRepository.findByemail(name);
    }
    public List<Student> getStudentByEmailContaining(String emaillike)
    {
        return studentRepository.findByEmailContaining(emaillike);
    }

    public Long totalStudents()
    {
        return studentRepository.count();
    }

    public Long totalStudentsbetweenAge(Integer startage, Integer endage)
    {
        return studentRepository.countByAgeBetween(startage, endage);
    }

    public Long totalStudentofAge(Integer age)
    {
        return studentRepository.countByAge(age);
    }

    public Long totalStudentofAgeGreaterThan(Integer age)
    {
        return studentRepository.countByAgeGreaterThan(age);
    }

    public Double averageOfAge()
    {
        return studentRepository.findAverageOfAge();
    }

    public Integer minimumAge()
    {
        return studentRepository.findMinAge();
    }


    public List<Object[]> avgAgeByCourse()
    {
        return studentRepository.findAverageOfAgeGroupByCourse();
    }

    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }





    public List<Student> saveAllStudent(List<Student> LS)
    {
        return studentRepository.saveAll(LS);
    }

    public Student updateStudent(Long id, Student student)
    {
        Student st = getStudentById(id);
        if(st!=null)
        {
            st.setAge(student.getAge());
            st.setId(student.getId());
            st.setName(student.getName());
            st.setEmail(student.getEmail());
            st.setCourse(student.getCourse());
            return studentRepository.save(st);
        }
        return  null;
    }


    public void deleteStudent(Long id)
    {
        studentRepository.deleteById(id);
    }

    public void deleteTotalStudent()
    {
        studentRepository.deleteAll();
    }





}
