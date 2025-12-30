package edu.cjc.sms.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.repositary.StudentRepositary;
import edu.cjc.sms.app.servicei.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI {
	
	@Autowired
	StudentRepositary sr;
	@Override
	public void saveStudentData(Student s) {
		
			sr.save(s);
	
		
	}
	@Override
	public List<Student> getAllStudent() {
		
		return sr.findAll();
	}
	@Override
	public void deleteStudent(int rollno) {
		sr.deleteById(rollno);
	
		
	}
	
	
	@Override
	public List<Student> editStudentByRollno() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void editStudent(int rollno) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Student> searchStudentByBatch(String batchNumber, String batchMode) {
		
		 	return sr.findAllByBatchNumberAndBatchMode(batchNumber,batchMode);
	}
	@Override
	public Student getSingleStudent(int studentId) {
	
		return sr.findById(studentId).get();
	}
	@Override
	public void payFees(int studentId, double ammount) {
				Optional<Student> op =sr.findById(studentId);	
				
				if(op.isPresent()) {
					Student s=op.get();
					s.setFeesPaid(s.getFeesPaid()+ammount);
					
					sr.save(s);
				}else {
					throw new ArithmeticException("No Student Id Found");
				}
	}
	
	


}
