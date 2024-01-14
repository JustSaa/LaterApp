package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final List<User> userList = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public User save(User user) {
        userList.add(user);
        return user;
    }
}
