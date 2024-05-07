package com.example.Library.Management.Service;

import com.example.Library.Management.models.Member;
import com.example.Library.Management.models.RepositoryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingInService {
    @Autowired
    private RepositoryAPI repo1;


    public Member login(String username, String password) {
        return repo1.findByUserNameAndPassword(username, password);
    }



}
