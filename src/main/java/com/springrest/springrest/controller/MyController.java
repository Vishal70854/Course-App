package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.service.CourseService;

@RestController
public class MyController {
	@Autowired // create the object of CourseService implementing class on our behalf as per dependency injection rule
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "Welcome to Courses Application";
	}
	
	// get all courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return courseService.getCourses();
	}
	
	// get course by id
	@GetMapping("/courses/{courseId}")
	public Course getCourseById(@PathVariable String courseId) {
		return courseService.getCourseById(Long.parseLong(courseId));
	}
	
	// add a course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	// update a course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}
	
	// delete a course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
