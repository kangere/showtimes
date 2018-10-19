package org.kangere.movie.views;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.kangere.movie.MovieDetailsService;

import javax.inject.Inject;

public class MoviesView extends VerticalLayout {

    @Inject
    MovieDetailsService service;

    public MoviesView(){

        Label label = new Label(service.getJson());

        addComponent(label);
    }

}
