package com.abhisheknarwal.budgetmanagement;
import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.Date;
import java.util.List;

public class TransactionRepository {
    private TransactionDAO transactionDAO;
    private LiveData<List<Transaction>> allTransaction;

    TransactionRepository(Application application){
        TransactionDatabase database = TransactionDatabase.getDatabase(application);
        transactionDAO = database.getTransactionDAO();
        Date sDAte =  new Date();
        sDAte.setHours(0);
        sDAte.setMinutes(0);
        sDAte.setSeconds(0);
        Date eDAte =  new Date();
        eDAte.setHours(0);
        eDAte.setMinutes(0);
        eDAte.setSeconds(0);
        allTransaction = transactionDAO.fetchAll(sDAte,eDAte);
    }

    public void insert(Transaction transaction){
        new InsertTransactionAsyncTask(transactionDAO).execute(transaction);
    }

    public void update(Transaction transaction){
        new UpdateTransactionAsyncTask(transactionDAO).execute(transaction);
    }

    public void delete(Transaction transaction){
        new DeleteTransactionAsyncTask(transactionDAO).execute(transaction);
    }

    public void delteAll(Transaction transaction){
        new DeleteAllTransactionsAsyncTask(transactionDAO).execute();
    }

    class InsertTransactionAsyncTask extends AsyncTask<Transaction,Void,Void>{
        TransactionDAO mTransactionDAO;

        public InsertTransactionAsyncTask(TransactionDAO mTransactionDAO) {
            this.mTransactionDAO = mTransactionDAO;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            mTransactionDAO.insert(transactions[0]);
            return null;
        }
    }

    class UpdateTransactionAsyncTask extends AsyncTask<Transaction,Void,Void>{
        TransactionDAO mTransactionDAO;

        public UpdateTransactionAsyncTask(TransactionDAO mTransactionDAO) {
            this.mTransactionDAO = mTransactionDAO;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            return null;
        }
    }

    class DeleteTransactionAsyncTask extends AsyncTask<Transaction, Void, Void>{

        TransactionDAO mTransactionDAO;

        public DeleteTransactionAsyncTask(TransactionDAO mTransactionDAO) {
            this.mTransactionDAO = mTransactionDAO;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            return null;
        }
    }

    class DeleteAllTransactionsAsyncTask extends AsyncTask<Void,Void,Void>{
        TransactionDAO transactionDAO;

        public DeleteAllTransactionsAsyncTask(TransactionDAO transactionDAO) {
            this.transactionDAO = transactionDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            transactionDAO.deleteAllTransactions();
            return null;
        }
    }
}
