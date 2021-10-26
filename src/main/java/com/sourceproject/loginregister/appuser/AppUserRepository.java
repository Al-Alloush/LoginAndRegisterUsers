package com.sourceproject.loginregister.appuser;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// to query from database
@Repository // annotate this interface as Repository
@Transactional(readOnly = true)
public interface AppUserRepository {
	
	Optional<AppUser> findByEmail(String Email);

}
