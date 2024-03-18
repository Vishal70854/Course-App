package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entity.Course;

@Service // spring will identify it as a service class which contains business logic
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
//	List<Course> list;	// used for understanding purpose
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(132, "Core Java", "This course contains basics of java"));
//		list.add(new Course(431, "Shell Scripting", "This course contains basics of shell scripting"));
//		list.add(new Course(87, "Groovy", "This course contains basics of groovy"));
//		list.add(new Course(94, "Advanced Java", "This course contains advance java concepts"));
//		list.add(new Course(5378, "Rest API", "Creating Rest Api using spring boot"));
	}

	// get all courses
	@Override
	public List<Course> getCourses() {
		return courseDao.findAll(); // fetch from db
	}
	
	// get course by Id
	@Override
	public Course getCourseById(long courseId) {
//		Course c = null;
//		for(Course course : list) {
//			if (course.getId() == courseId) {
//				c = course; // course found
//				break;
//			}
//		}
//		return c;
		return courseDao.findById(courseId).get(); // since the returntype of findById(id) is optional thats why we used .get() to get the object.
	}

	// add a course
	@Override
	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
		
		courseDao.save(course);
		return course;
	}

	// update a course
	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course); // it will update course if already present in db or else add new course if not present in db
		return course;
		
//		list.forEach(e -> {		// update course using lambda expresssions.
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
//		return course;
		
		// another implementation of updateCourse without using lambda expression
//		for (Course course : list) {
//			if (course.getId() == updatedCourse.getId()) {
//				course.setTitle(updatedCourse.getTitle());
//				course.setDescription(updatedCourse.getDescription());
//				break;
//			}
//			
//		}
//		// search for the updated course and return the course as object
//		Course c = null;
//		for(Course course : list) {
//			if (course.getId() == updatedCourse.getId()) {
//				c = course;
//				break;
//			}
//		}
//		System.out.println(c);
//		return c; // return the updated course
	
	}
	
	// delete a courses
	@Override
	public void deleteCourse(long courseId) {
		Course entity = courseDao.findById(courseId).get();
		courseDao.delete(entity);
		
		// using lambda expressions
//		list = list.stream()
//					.filter(e -> e.getId() != courseId).collect(Collectors.toList());
		
		// another implementation of deleteCourse without using lambda expression
//		for(Course course : list) {
//			if (course.getId() == courseId) {
//				list.remove(course);
//				
//			}
//		}
//		
	}


}
