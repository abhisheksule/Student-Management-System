package edu.cjc.sms.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cjc.sms.app.model.Student;

public interface StudentRepositary extends JpaRepository<Student, Integer> {

}
