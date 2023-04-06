package com.rohuu.course;

import com.rohuu.topic.Topic;
import com.rohuu.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class CourseService {
    // first get TopicRepository instance to my topic so that we can make calls to topic repository from topic service

    @Autowired
    private CourseRepository courseRepository;

    private final List<com.rohuu.topic.Topic> topics=new ArrayList<>(Arrays.asList(
             new com.rohuu.topic.Topic("spring","Spring Framework","Spring framework description"),
                new com.rohuu.topic.Topic("java","Core Java","Core Java description"),
                new com.rohuu.topic.Topic("javaScript","JavaScript","JavaScript description")
        ));

     public List<Course> getAllCourses(String topicId){
         List<Course> courses=new ArrayList<>();
         courseRepository.findByTopicId(topicId)
                 .forEach(courses::add);
     return courses;
     }

    public Optional<com.rohuu.course.Course> getCourse(String id) {
         return courseRepository.findById(id);
     }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Course course) {
         courseRepository.delete(course);
    }
}
