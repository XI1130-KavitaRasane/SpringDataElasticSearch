package com.example.springdataelasticdemo.repository;

import com.example.springdataelasticdemo.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersRepository extends ElasticsearchRepository<User, Long> {
    List<User> findByName(String text);
    List<User> findBySalary(Long salary);
}
