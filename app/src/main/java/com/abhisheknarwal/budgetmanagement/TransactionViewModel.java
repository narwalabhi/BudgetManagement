package com.abhisheknarwal.budgetmanagement;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.room.PrimaryKey;

public class TransactionViewModel extends AndroidViewModel {
    private TransactionRepository transactionRepository;

    public TransactionViewModel(@NonNull Application application) {
        super(application);
        this.transactionRepository = new TransactionRepository(application);

    }
}
