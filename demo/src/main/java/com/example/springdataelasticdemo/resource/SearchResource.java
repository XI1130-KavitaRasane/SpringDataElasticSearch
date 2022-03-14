package com.example.springdataelasticdemo.resource;

import com.example.springdataelasticdemo.model.User;
import com.example.springdataelasticdemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@RestController
@RequestMapping("/rest/users")
public class SearchResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/{id}" ,produces = {MediaType.APPLICATION_JSON_VALUE})
    public User searchById(@PathVariable final Long id) {
        return usersRepository.findById(id).get();
    }


    @GetMapping(value = "salary/{salary}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> searchBySalary(@PathVariable final Long salary) {
        return usersRepository.findBySalary(salary);
    }


    @GetMapping(value = "/all" ,produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> searchAll() {
        List<User> usersList = new ArrayList<>();
        Iterable<User> users = usersRepository.findAll();
        users.forEach(usersList::add);
        return usersList;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public User saveUser(@RequestBody User users) {
        System.out.println("Inside savePerson method of controller PersonController with {}"+users);
        User user = usersRepository.save(users);

        //System.out.println("immediate het user by Id.......");
        User u = usersRepository.findById(users.getId()).get();
        System.out.println("immediate get user by Id" + u);
        return user;
    }

    @PutMapping(value = "/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public User updateUser(@PathVariable("id") long id ,@RequestBody User user) {
        System.out.println("Inside savePerson method of controller PersonController with {}"+user);
        User oldUser = usersRepository.findById(id).get();
        ofNullable(user.getName()).ifPresent(oldUser::setName);
        ofNullable(user.getSalary()).ifPresent(oldUser::setSalary);
        ofNullable(user.getTeamName()).ifPresent(oldUser::setTeamName);
        User u = usersRepository.save(user);
        System.out.println("immediate get user by Id" + u);
        User updatedUser = usersRepository.findById(user.getId()).get();
        System.out.println("immediate get user by Id" + updatedUser);
        //postman runner 100 req
        //disable refresh permission on elastic
        // query builder with (criteria)
        //according to env it needs to fetch index

        return updatedUser;
    }


}
