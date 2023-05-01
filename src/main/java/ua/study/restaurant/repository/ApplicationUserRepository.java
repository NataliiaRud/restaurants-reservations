package ua.study.restaurant.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.study.restaurant.model.ApplicationUser;

/**
 * Application user repository
 */

@Repository
public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Integer> {
    @Query("Select u from ApplicationUser u WHERE u.userName=:username")
    ApplicationUser findByUsername(@Param("username") String username);
}
