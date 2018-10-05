package orm;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class MovieDetailsORM {

    private String id;

    private String constant;

    private String title;

    private URL url;

    private double rating;

    private double votes;

    private double runtime;

    private List<String> directors = new ArrayList<>();

    private List<String> genres = new ArrayList<>();

    private Date release_date;


    public MovieDetailsORM(){ }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getVotes() {
        return votes;
    }

    public void setVotes(double votes) {
        this.votes = votes;
    }

    public double getRuntime() {
        return runtime;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(String...strings){
        setDirectors(Arrays.asList(strings));
    }
    public void setDirectors(List<String> directors) {
        this.directors.addAll(directors);
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(String...strings){
        setGenres(Arrays.asList(strings));
    }
    public void setGenres(List<String> genres) {
        this.genres.addAll(genres);
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
}
