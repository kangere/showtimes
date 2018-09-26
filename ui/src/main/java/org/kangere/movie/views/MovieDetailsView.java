package org.kangere.movie.views;

import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import orm.MovieDetailsORM;

public class MovieDetailsView extends VerticalLayout {

    private Grid<MovieDetailsORM> grid = getGrid();
    
    public MovieDetailsView(){

    }


    private Grid<MovieDetailsORM> getGrid(){

        return null;
    }
}
