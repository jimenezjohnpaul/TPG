package com.exam.tpg;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    
	public int compare(Student o1, Student o2) {
		Double gpa1 = o1.getGpa();
		Double gpa2 = o2.getGpa();
        int value1 = gpa1.compareTo(gpa2);
        if (value1 == 0) {
            int value2 = o1.getName().compareTo(o2.getName());
            if (value2 == 0) {
            	Integer id1 = o1.getId();
            	Integer id2 = o2.getId();
                return id1.compareTo(id2);
            } else {
                return value2;
            }
        }
        return value1;
    }
	
}