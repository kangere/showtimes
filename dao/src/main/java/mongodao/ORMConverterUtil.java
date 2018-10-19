package mongodao;


import org.bson.Document;
import orm.MovieDetailsORM;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ORMConverterUtil {

    //TODO find generic way of conversion
    public static MovieDetailsORM convertToORM(Document document){

        MovieDetailsORM orm = new MovieDetailsORM();

        orm.setId(document.getObjectId("_id").toString());

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

        orm.setRelease_date(document.getDate("release_date"));

        ((List<String>)document.get("genres")).forEach(orm::setGenres);

        ((List<String>)document.get("directors")).forEach(director -> {
            orm.setDirectors(director);
        });


        return orm;
    }

    public static Document convertToDocument(MovieDetailsORM orm){
        Document document = new Document();

        document.append("const",orm.getConstant());
        document.append("title",orm.getTitle());
        document.append("url",orm.getUrl());
        document.append("imdb_rating",orm.getConstant());
        document.append("runtime",orm.getRuntime());
        document.append("genres",orm.getGenres());
        document.append("num_votes",orm.getVotes());
        document.append("release_date",orm.getRelease_date());
        document.append("directors",orm.getDirectors());

        return document;
    }
}
