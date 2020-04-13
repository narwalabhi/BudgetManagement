package com.abhisheknarwal.budgetmanagement;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Transaction.class}, version = 1)
@TypeConverters({Converter.class})
public abstract class TransactionDatabase extends RoomDatabase {
    private static volatile TransactionDatabase INSTANCE;
    public abstract TransactionDAO getTransactionDAO();

    public static TransactionDatabase getDatabase(Context context){
        if(INSTANCE == null){
            synchronized (TransactionDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),TransactionDatabase.class,"transaction_database")
                            .addCallback(dbCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback dbCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
        }
    };
}
