package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	//조건에 맞게 프라이빗 작성 
	private String studentId;
	private String name;
	private String major;
	private int grade;

	//학생 정보를 받아 초기값을 설정하는 생성자 작성
	public Student(String studentId, String name, String major, int grade)
			throws InvalidGradeException {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		//생성할 때도 학년 조건을 확인하도록 setter 사용
		setGrade(grade);
	}

	//Source를 이용해서 getter와 setter를 한 번에 생성
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) throws InvalidGradeException {
		//조건에 맞게 학년이 1~4 범위를 벗어나면 예외 발생
		if (grade < 1 || grade > 4) {
			throw new InvalidGradeException("학년은 1~4 사이의 값이어야 합니다.");
		}
		this.grade = grade;
	}
}
