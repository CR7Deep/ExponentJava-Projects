package com.controller;

import com.service.ServiceImpl;
import com.service.Services;

public class HomeController {
	
	public static void main(String[] args) {
		
		Services s= new ServiceImpl();
		

		s.addStudentWithSubjects();
//		s.deleteStudentOnly();
//		s.deleteStudentWithSubjects();
//		s.deleteSubjectOnly();
//		s.AddExistingPersonToExistingAadharcard();
		

	}

}
