package com.atuluttam.SpringDataJPABasicCRUD.repository;


import com.atuluttam.SpringDataJPABasicCRUD.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


 //Dynamic Query Methods
 public List<Student> findByname(String name);
 public List<Student> findByemail(String email);
 public List<Student> findByage(Integer age);
 public List<Student> findByAgeGreaterThan(Integer age);
 // Find by email containing certain text (like)
 List<Student> findByEmailContaining(String email);
 // Find by age between certain values
 List<Student> findByAgeBetween(int startAge, int endAge);

 // Count students by course
 Long countByAge(Integer age);

 // Count students with marks greater than a specific value
 Long countByAgeGreaterThan(Integer age);

 // Count students of a certain age range
 Long countByAgeBetween(Integer startAge, Integer endAge);

 // Find SUM of age
 @Query("SELECT SUM(s.age) FROM Student s")
 Integer findSumOfAge();

 // Find AVG (average) of age
 @Query("SELECT AVG(s.age) FROM Student s")
 Double findAverageOfAge();

 // Find MIN (minimum) age
 @Query("SELECT MIN(s.age) FROM Student s")
 Integer findMinAge();

 // Find MAX (maximum) age
 @Query("SELECT MAX(s.age) FROM Student s")
 Integer findMaxAge();

 // Find Top 3 students with highest age
 List<Student> findTop3ByOrderByAgeDesc();


 public void deleteAll();

 // Find SUM of age grouped by course
 @Query("SELECT s.course, SUM(s.age) FROM Student s GROUP BY s.course")
 List<Object[]> findSumOfAgeGroupByCourse();

 // Find AVG of age grouped by course
 @Query("SELECT s.course, AVG(s.age) FROM Student s GROUP BY s.course")
 List<Object[]> findAverageOfAgeGroupByCourse();

 // Find MIN of age grouped by course
 @Query("SELECT s.course, MIN(s.age) FROM Student s GROUP BY s.course")
 List<Object[]> findMinAgeGroupByCourse();

 // Find MAX of age grouped by course
 @Query("SELECT s.course, MAX(s.age) FROM Student s GROUP BY s.course")
 List<Object[]> findMaxAgeGroupByCourse();

 // Find Top 3 students with highest age in each course
 @Query("SELECT s FROM Student s WHERE s.age IN (SELECT MAX(s2.age) FROM Student s2 GROUP BY s2.course)")
 List<Student> findTop3ByHighestAgeGroupByCourse();



//Custom Query methods
 @Query("SELECT s FROM Student s WHERE s.name LIKE CONCAT(?1, '%')")
 public List<Student> findBynamelike(String namelike);






}
