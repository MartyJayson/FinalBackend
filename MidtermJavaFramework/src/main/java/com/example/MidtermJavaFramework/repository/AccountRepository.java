package com.example.MidtermJavaFramework.repository;

import com.example.MidtermJavaFramework.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long>  {

    @Query(value = "SELECT s FROM Account s WHERE s.username LIKE %?1%",
            nativeQuery = false)
    public List<Account> searchAccount(String keyword);

    Account findByUsername(String username);
}
