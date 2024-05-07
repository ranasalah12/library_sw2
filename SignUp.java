package com.example.Library.Management.Service;

import com.example.Library.Management.models.Member;
import com.example.Library.Management.models.RepositoryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUp {

    @Autowired
    private RepositoryAPI repositoryAPI;

//sign in
String name="";
    public void save(Member member){
        repositoryAPI.save(member);
        name = member.getName();
    }


    public String getName() {
        return name;
    }
}
