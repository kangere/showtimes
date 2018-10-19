package org.kangere.movie;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;

@ApplicationScoped
public class MovieDetailsService {

    private static final String  API_KEY = "b77f8b481c130820a2d86b0d51c21f04";


    private Client client;
    private WebTarget target;

    public MovieDetailsService(){

    }

    @PostConstruct
    protected void init(){
        client = ClientBuilder.newClient();

        target = client.target(URI.create("https://api.themoviedb.org/3/movie"))
                .path("{movie_id}")
                .resolveTemplate("movie_id","550")
                .queryParam("api_key", API_KEY);
    }


    public String getJson(){
        return target.request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    public void close(){
        client.close();
    }
}
