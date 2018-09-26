package mongodao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.sun.istack.internal.NotNull;
import org.bson.Document;
import orm.MovieDetailsORM;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MovieDetailsDAO implements DAO{

    private MongoCollection<Document> movieDetails;
    private MongoClient client;

    public MovieDetailsDAO(){
        client = MongoClients.create();
        MongoDatabase db = client.getDatabase("movies");
        movieDetails = db.getCollection("movieDetails");
    }

    public MovieDetailsORM findFirst(){

        Document doc = movieDetails.find().first();

        return  convertToORM(doc);
    }

    public List<MovieDetailsORM> findAll(){

        List<MovieDetailsORM> orms = new ArrayList<>();

        for(Document document : movieDetails.find().into(new ArrayList<>()))
            orms.add(convertToORM(document));

        return orms;
    }


    private MovieDetailsORM convertToORM(@NotNull Document document){

        MovieDetailsORM orm = new MovieDetailsORM();

        orm.setConstant(document.getString("const"));

        orm.setTitle(document.getString("title"));

        try {
            orm.setUrl(new URL(document.getString("url")));
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        orm.setRating(document.getDouble("imdb_rating"));

        orm.setRuntime(document.getDouble("runtime"));

        orm.setVotes(document.getDouble("num_votes"));

        orm.setRelease_date(document.getDate("release_date").toString());

        ((List<String>)document.get("genres")).forEach(orm::setGenres);

        ((List<String>)document.get("directors")).forEach(orm::setDirectors);


        return orm;
    }

    public void close() {
        client.close();
    }
}
