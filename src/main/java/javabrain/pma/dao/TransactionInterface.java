package javabrain.pma.dao;

import org.springframework.data.repository.CrudRepository;

import javabrain.pma.entities.Transaction;

public interface TransactionInterface extends CrudRepository<Transaction, Long>
{

}
