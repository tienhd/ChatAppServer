package xyz.yoloz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.yoloz.model.UserAccount;

/**
 * Created by tienhd on 11/2/16.
 */
@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    UserAccount findByUsername(String username);
}
