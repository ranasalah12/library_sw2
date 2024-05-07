package com.example.Library.Management.Service;

import com.example.Library.Management.models.Member;
import com.example.Library.Management.models.RepositoryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PasswordService {
    @Autowired
    private RepositoryAPI repo2;



    //pawword
    public boolean noRepeatingPassword(String password){
        List<Member> users = new ArrayList<Member>();
        for(Member user : repo2.findAll()) {
            users.add(user);
        }
        boolean ch=true;

        for (Member m : users) {
            if(m.getPassword().equals(password)){
                ch=false;
                return ch;
            }
        }
        return ch;
    }

    public boolean goodPassword(String password){
        boolean ch=true;
        if(password.length() <= 6){
            ch=false;
            return ch;
        }

        return ch;
    }

}
