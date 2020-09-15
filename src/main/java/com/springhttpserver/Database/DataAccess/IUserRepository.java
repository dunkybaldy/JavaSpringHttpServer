package com.springhttpserver.Database.DataAccess;

import com.springhttpserver.Models.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserProfile, String> {
}
