package problems;

import java.util.HashMap;
import java.util.Map;

public class StudentCourseManagement {
	
	private static class DLL {
		DLL next;
		DLL prev;
		int studentEnrollNo;
		DLL(int studentEnrollNo) {
			this.studentEnrollNo = studentEnrollNo;
		}
	}
	
	//Handler
	private static class StudentCourseHandler {
		
		//key = hashcode(course, student), value = DLL node with student id.
		private Map<Integer, DLL> studentMap;
		
		//key = courseId, value = DLL node with all student of respective course.
		private Map<Integer, DLL> courseToStudentMap;
		
		StudentCourseHandler() {
			this.studentMap = new HashMap<>();
			this.courseToStudentMap = new HashMap<>();
		}
		
		//insert student for a course
		void insertStudent(int courseId, int studentEnrollNo) {

			int hashcode = generateHashCode(courseId, studentEnrollNo);
			
			if(studentMap.containsKey(hashcode))
				return;
			
			DLL node = new DLL(studentEnrollNo);
			if(courseToStudentMap.containsKey(courseId)) {
			
				DLL olderNode = courseToStudentMap.get(courseId);
				olderNode.prev = node;
				node.next = olderNode;
			}
			
			courseToStudentMap.put(courseId, node);
			studentMap.put(hashcode, node);
		}
		
		//delete student from a course
		void deleteStudent(int courseId, int studentEnrollNo) {

			int hashcode = generateHashCode(courseId, studentEnrollNo);
			
			if(!studentMap.containsKey(hashcode))
				return;
			
			DLL studentNode = studentMap.get(hashcode);
			
			if(studentNode.prev == null && studentNode.next == null) {
				courseToStudentMap.remove(courseId);
			}
			else if(studentNode.prev == null) {
				studentNode = studentNode.next;
			}
			else if(studentNode.next == null) {
				studentNode.prev.next = null;
			}
			else {
				studentNode.prev.next = studentNode.next;
			}
			
			studentMap.remove(hashcode);
		}
		
		//search pair of course and student
		boolean search(int courseId, int studentEnrollNo) {
			
			return studentMap.containsKey(generateHashCode(courseId, studentEnrollNo));
		}
		
		//retreive last enrolled student for given course
		int getLastEnrolled(int courseId) {

			return courseToStudentMap.containsKey(courseId) ? courseToStudentMap.get(courseId).studentEnrollNo : -1;
		}
		
		private int generateHashCode(int courseId, int studentEnrollNo) {
			
			return (String.valueOf(courseId) + String.valueOf(studentEnrollNo)).hashCode();
		}
	}
	
	//Driver
	public static void main(String[] args) {
		
		StudentCourseHandler handler = new StudentCourseHandler();
		
		handler.insertStudent(1, 1);
		handler.insertStudent(2, 1);
		handler.insertStudent(2, 2);
		handler.insertStudent(3, 2);
		
		System.out.println(handler.getLastEnrolled(2));
	}
}
