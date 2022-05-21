package com.cdelf.oauthserver.Repository;

import com.cdelf.oauthserver.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findById(long id);
    User deleteById(long id);



}
