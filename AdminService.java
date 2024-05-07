package com.example.Library.Management.Service;

import com.example.Library.Management.models.Member;
import com.example.Library.Management.models.RepositoryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private RepositoryAPI userRepository;


    public void saveMyUser(Member user ) {
        userRepository.save(user);
    }

    public List<Member> showAllUsers(){
        List<Member> users = new ArrayList<Member>();
        for(Member user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

//    public void deleteMyUser(int id) {
//        userRepository.delete(id);
//    }
}
