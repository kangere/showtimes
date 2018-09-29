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

        addComponent(grid);
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
        TextField title = new TextField();
        TextField genre = new TextField();
        TextField director = new TextField();
        TextField release_date = new TextField();
        TextField rating = new TextField();
        TextField runtime = new TextField();
        TextField url = new TextField();
        TextField votes = new TextField();

        layout.addComponent(constant,0,0);
        layout.addComponent(title,1,0);
        layout.addComponent(genre,2,0);





        return null;
    }
}
