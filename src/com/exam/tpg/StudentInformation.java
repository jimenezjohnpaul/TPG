package com.exam.tpg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentInformation {

	public StudentInformation() {
		// TODO Auto-generated constructor stub
	}
	
	public static void sort() {
	
		startTime = System.currentTimeMillis();
		
		System.out.println("\n********** StudentInformation **********\n");
		
		listStudents = getStudentList();
		
		Collections.sort(listStudents,new StudentComparator());
		
		System.out.println("Sort List\n");
		
		for (Student student:listStudents){
			
			System.out.println(student.getGpa()+" "+student.getName()+" "+student.getId());
		
		}
		
		endTime = System.currentTimeMillis();
		
		elapseTime = endTime - startTime;
		
		System.out.println("\nElapse Time:\t" + elapseTime + " Milliseconds\n");
		System.out.println("*****************************************");
		
	}
	
	private static List<Student> getStudentList(){
		
		List<Student> studentList = new ArrayList<Student>();
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new InputStreamReader(StudentInformation.class.getResourceAsStream(TpgMain.getProp().getProperty(STUDENT_INFO)), "UTF-8"));

			String currentLine;

			while ((currentLine = br.readLine()) != null) {
				
				String[] data = currentLine.split(",");
				
				studentList.add(new Student(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2])));
				
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
		return studentList;
		
	}
	
	private static final String STUDENT_INFO = "TEST_DATA_STUDENT_INFORMATION";
	private static List<Student> listStudents = new ArrayList<Student>();
	
	private static long startTime;
	private static long endTime;
	private static long elapseTime;
	
}
