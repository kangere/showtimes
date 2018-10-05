package org.kangere.movie.views;

import com.vaadin.ui.*;
import mongodao.DAO;
import mongodao.MovieDetailsDAO;
import orm.MovieDetailsORM;

import java.util.List;

public class MovieDetailsView extends VerticalLayout {

    private Grid<MovieDetailsORM> grid = getGrid();

    private Layout form = getInsertUpdateForm();

    public MovieDetailsView(){

        grid.setSizeFull();

        addComponents(grid,form);
    }


    private Grid<MovieDetailsORM> getGrid(){

        Grid<MovieDetailsORM> grid = new Grid<>();

        DAO<MovieDetailsORM> dao = new MovieDetailsDAO();

        List<MovieDetailsORM> movie_details = dao.findAll();

        grid.setItems(movie_details);

        grid.addColumn(MovieDetailsORM::getConstant).setCaption("Constant");
        grid.addColumn(MovieDetailsORM::getTitle).setCaption("Movie Title");
        grid.addColumn(MovieDetailsORM::getGenres).setCaption("Genres");
        grid.addColumn(MovieDetailsORM::getDirectors).setCaption("Directors");
        grid.addColumn(MovieDetailsORM::getRelease_date).setCaption("Release Date");
        grid.addColumn(MovieDetailsORM::getRating).setCaption("Rating");
        grid.addColumn(MovieDetailsORM::getRuntime).setCaption("Runtime");
        grid.addColumn(MovieDetailsORM::getUrl).setCaption("URL");
        grid.addColumn(MovieDetailsORM::getVotes).setCaption("Votes");





        return grid;
    }

    private Layout getInsertUpdateForm(){

        GridLayout layout = new GridLayout(3,4);

        TextField constant = new TextField();
        constant.setPlaceholder("IMDB Constant");

        TextField title = new TextField();
        title.setPlaceholder("Movie Title");

        TextField genre = new TextField();
        genre.setPlaceholder("Movie Genres");

        TextField director = new TextField();
        director.setPlaceholder("Directors");

        TextField release_date = new TextField();
        release_date.setPlaceholder("Release Date");

        TextField rating = new TextField();
        rating.setPlaceholder("Rating");

        TextField runtime = new TextField();
        runtime.setPlaceholder("Runtime");

        TextField url = new TextField();
        url.setPlaceholder("IMDB url");

        TextField votes = new TextField();
        votes.setPlaceholder("Ratings votes");

        layout.addComponent(constant,0,0);
        layout.addComponent(title,1,0);
        layout.addComponent(genre,2,0);
        layout.addComponent(director,0,1);
        layout.addComponent(release_date,1,1);
        layout.addComponent(rating,2,1);
        layout.addComponent(runtime,0,2);
        layout.addComponent(url,1,2);
        layout.addComponent(votes,2,2);




        layout.setSpacing(true);

        return layout;
    }
}
