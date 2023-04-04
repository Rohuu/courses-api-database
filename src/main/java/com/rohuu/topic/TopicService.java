package com.rohuu.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class TopicService {
    // first get TopicRepository instance to my topic so that we can make calls to topic repository from topic service

    @Autowired
    private TopicRepository topicRepository;

    private final List<Topic> topics=new ArrayList<>(Arrays.asList(
             new Topic("spring","Spring Framework","Spring framework description"),
                new Topic("java","Core Java","Core Java description"),
                new Topic("javaScript","JavaScript","JavaScript description")
        ));

     public List getAllTopics(){
         List<Topic> topics=new ArrayList<>();
     topicRepository.findAll().forEach(topics::add);
     return topics;
     }

    public Optional<Topic> getTopic(String id) {
//         return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
         return topicRepository.findById(id);
     }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for (int i = 0; i < topics.size(); i++) {
//                Topic topicToUpdate=topics.get(i);
//                if(topicToUpdate.getId().equals(id)){
//                    topics.set(i,topic);
//                    return;
//                }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(Topic topic) {
//        for (int i = 0; i < topics.size(); i++) {
//            Topic topicToBeDeleted=topics.get(i);
//            if(topicToBeDeleted.getId().equals(id)){
//                topics.remove(i);
//            }
//        }

        topicRepository.delete(topic);
    }
}
