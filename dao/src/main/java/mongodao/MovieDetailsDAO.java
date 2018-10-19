package mongodao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bson.types.ObjectId;
import orm.MovieDetailsORM;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MovieDetailsDAO extends AbstractDAO<MovieDetailsORM>{



    public MovieDetailsDAO(){
        super("movies","movieDetails");

    }

    @Override
    public MovieDetailsORM findFirst(){

        Document doc = collection.find().first();

        return  ORMConverterUtil.convertToORM(doc);
    }

    @Override
    public List<MovieDetailsORM> findAll(){

        List<MovieDetailsORM> orms = new ArrayList<>();

        for(Document document : collection.find().into(new ArrayList<>()))
            orms.add(ORMConverterUtil.convertToORM(document));

        return orms;
    }

    @Override
    public MovieDetailsORM findOne(String id) {
        Document document = collection.find(eq("_id", new ObjectId(id))).first();
        return ORMConverterUtil.convertToORM(document);
    }

    @Override
    public void insert(MovieDetailsORM orm) {

        Document doc = collection.find(eq("const",orm.getConstant())).first();

        if(doc == null){
            collection.insertOne(ORMConverterUtil.convertToDocument(orm));
        } else {
            System.out.println("Document already exists");
        }

    }

    //TODO Implement
    @Override
    public void insertAll(List<MovieDetailsORM> orms) {

    }

    //TODO Implement
    @Override
    public void update(MovieDetailsORM orm) {

    }


    @Override
    public void deleteOne(String id) {
        collection.deleteOne(eq("_id",new ObjectId(id)));
    }

  
}
