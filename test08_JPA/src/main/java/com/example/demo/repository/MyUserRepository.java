package com.example.demo.repository;

import com.example.demo.entity.MyUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MyUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(MyUser myUser) {
        entityManager.persist(myUser);
    }

    public MyUser find(int num) {
        MyUser myUser = entityManager.find(MyUser.class,num);
        return myUser;
    }

    public MyUser update(MyUser m) {
        MyUser myUser = entityManager.find(MyUser.class,m.getNum());
        myUser.setName(m.getName());
        myUser.setPhone(m.getPhone());
        myUser.setAddr(m.getAddr());
        return myUser;
    }

    public void delete(int num) {
        MyUser delMyUser = entityManager.find(MyUser.class,num);
        entityManager.remove(delMyUser);
    }

}
