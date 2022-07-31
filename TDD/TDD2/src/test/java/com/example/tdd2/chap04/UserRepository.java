package com.example.tdd2.chap04;

public interface UserRepository {

    void save(User user);

    User findById(String id);
}
