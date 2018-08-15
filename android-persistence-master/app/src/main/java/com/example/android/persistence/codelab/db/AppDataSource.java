package com.example.android.persistence.codelab.db;

import com.abubusoft.kripton.android.annotation.BindDataSource;
import com.abubusoft.kripton.android.annotation.BindDataSourceOptions;
import com.abubusoft.kripton.android.annotation.BindSqlAdapter;
import com.abubusoft.kripton.android.sqlite.adapters.DateMillisecondsTypeAdapter;


@BindDataSourceOptions(inMemory = true)
@BindDataSource(fileName = "app.db", version = 1, daoSet = {BookDao.class, LoanDao.class, UserDao.class},
        typeAdapters = {@BindSqlAdapter(adapter = DateMillisecondsTypeAdapter.class)},
        asyncTask = true
        )
public interface AppDataSource {


}

