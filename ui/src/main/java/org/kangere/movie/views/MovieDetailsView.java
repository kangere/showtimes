package org.kangere.movie.views;

import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
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

        GridLayout layout = new GridLayout();




        return null;
    }
}
