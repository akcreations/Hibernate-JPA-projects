package com.akcreations.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akcreations.jpademo.entity.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course, Integer>{

}
