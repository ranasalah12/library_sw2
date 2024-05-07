package com.example.Library.Management.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAPI extends CrudRepository<Member, Long> {
    Member findByUserNameAndPassword(String username, String password);

}