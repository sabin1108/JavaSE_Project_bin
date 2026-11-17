package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
		try {
			//학생 객체 생성
			Student student = new Student("20261117", "김민수", "컴퓨터공학", 3);
			System.out.println(student.getName() + " / " + student.getMajor()+ " / " + student.getGrade() + "학년");

			//5학년 예외 처리 확인용 코드 
			System.out.println("5학년으로 변경");
			student.setGrade(5);
			
		} catch (InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
	}
}
