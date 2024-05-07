package com.example.Library.Management.Service;
import com.example.Library.Management.models.Member;
import com.example.Library.Management.models.RepositoryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmailService {
    @Autowired
    RepositoryAPI repo;




    //Email
    public boolean noRepeatingEmail(String email){
        List<Member> users = new ArrayList<Member>();
        for(Member user : repo.findAll()) {
            users.add(user);
        }
        boolean ch=true;
        for (Member m : users) {
            if(m.getEmail().equals(email)){
                ch=false;
                return ch;
            }
        }
        return ch;
    }


}
