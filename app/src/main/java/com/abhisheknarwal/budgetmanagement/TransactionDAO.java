package com.abhisheknarwal.budgetmanagement;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.Date;
import java.util.List;

@Dao
public interface TransactionDAO{
    @Query("SELECT * FROM transaction_table WHERE date BETWEEN :start AND :end")
    LiveData<List<Transaction>> fetchAll(Date start, Date end);

    @Query("DELETE FROM transaction_table")
    void deleteAllTransactions();

    @Insert
    void insert(Transaction transaction);

    @Delete
    void delete(Transaction transaction);

    @Update
    void update(Transaction transaction);

}
