package lab7.lab7.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import lab7.lab7.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String>{}
