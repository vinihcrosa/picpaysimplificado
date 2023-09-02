package com.vinihcrosa.picpaysimplificado.repositories;

import com.vinihcrosa.picpaysimplificado.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
