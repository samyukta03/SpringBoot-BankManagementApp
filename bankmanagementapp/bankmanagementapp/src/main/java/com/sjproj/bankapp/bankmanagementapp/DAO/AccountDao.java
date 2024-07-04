//this is not usual DAO this is Spring JPA repository
/*
 * in case of tradition DAO for account entity itll be something like an DAO interface and its implementation class
 * public interface AccountDao {
    Account findById(Long id);
    List<Account> findAll();
    Account save(Account account);
    void delete(Long id);
}

public class AccountDaoImpl implements AccountDao {
    // Implementation of the methods with database access logic
}
     * 
     * instead of this spring JPA providing ready-to-use implementations of common database operations through the JpaRepository interface. You only need to create an interface that extends JpaRepository, and Spring Data JPA provides the implementation at runtime.
     * ie) spring JPA provides the Automatic Implementation for the methods defined in JpaRepository, such as save(), findById(), findAll(), and deleteById().
     * You don't need to write the implementation for basic CRUD operations like in trad DAO


 */

package com.sjproj.bankapp.bankmanagementapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjproj.bankapp.bankmanagementapp.entity.Account;

public interface AccountDao extends JpaRepository<Account, Long> {

}
