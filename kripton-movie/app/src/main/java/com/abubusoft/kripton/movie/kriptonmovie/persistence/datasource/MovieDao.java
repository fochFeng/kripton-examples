package com.abubusoft.kripton.movie.kriptonmovie.persistence.datasource;

import android.arch.lifecycle.LiveData;

import com.abubusoft.kripton.android.annotation.BindDao;
import com.abubusoft.kripton.android.annotation.BindSqlDelete;
import com.abubusoft.kripton.android.annotation.BindSqlInsert;
import com.abubusoft.kripton.android.annotation.BindSqlSelect;
import com.abubusoft.kripton.android.annotation.BindSqlUpdate;
import com.abubusoft.kripton.android.sqlite.ConflictAlgorithmType;
import com.abubusoft.kripton.movie.kriptonmovie.model.Movie;
import com.abubusoft.kripton.movie.kriptonmovie.model.MovieWithDirector;

import java.util.List;

@BindDao(Movie.class)
public interface MovieDao {
    @BindSqlSelect(where="title = :title LIMIT 1")
    Movie findMovieByTitle(String title);

    @BindSqlInsert(conflictAlgorithm = ConflictAlgorithmType.IGNORE)
    void insert(List<Movie> movies);

    @BindSqlInsert(conflictAlgorithm = ConflictAlgorithmType.IGNORE)
    void insert(String title, long directorId);

    @BindSqlUpdate(conflictAlgorithm = ConflictAlgorithmType.IGNORE)
    void update(Movie director);

    @BindSqlDelete
    void deleteAll();

    @BindSqlSelect(jql="select Movie.title title, director.fullName fullName from Movie, Director where director.did=movie.directorId order By title ASC")
    LiveData<List<MovieWithDirector>> getAllMovies();
}