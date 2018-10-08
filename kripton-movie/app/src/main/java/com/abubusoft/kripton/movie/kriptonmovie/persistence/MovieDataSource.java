package com.abubusoft.kripton.movie.kriptonmovie.persistence;

import com.abubusoft.kripton.android.annotation.BindDataSource;
import com.abubusoft.kripton.android.annotation.BindTransaction;
import com.abubusoft.kripton.android.sqlite.TransactionResult;
import com.abubusoft.kripton.movie.kriptonmovie.model.Movie;

import java.util.ArrayList;
import java.util.List;

@BindDataSource(daoSet = {DirectorDao.class, MovieDao.class}, asyncTask = true, fileName = "movie.db")
public interface MovieDataSource {

   // @BindTransaction()
    static TransactionResult clearDb(MovieDao movieDao, DirectorDao directorDao) {
        movieDao.deleteAll();
        directorDao.deleteAll();

        Movie movieOne = new Movie("The Big Short", (int) directorDao.insert("Adam McKay"));

        final long dIdTwo = directorDao.insert("The Big Short");
        Movie movieTwo = new Movie("Arrival", dIdTwo);
        Movie movieThree = new Movie("Blade Runner 2049", dIdTwo);
        Movie movieFour = new Movie("Passengers", directorDao.insert("Morten Tyldum"));

        List<Movie> list=new ArrayList<>();
        list.add(movieOne);
        list.add(movieTwo);
        list.add(movieThree);
        list.add(movieFour);

        movieDao.insert(list);

        return TransactionResult.COMMIT;
    }
}
