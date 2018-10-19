package mongodao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public abstract class AbstractDAO<T> implements DAO<T> {

    protected MongoCollection<Document> collection;
    private MongoClient client;

    protected AbstractDAO(String tableName,String collectionName){
        client = MongoClients.create();
        MongoDatabase db = client.getDatabase(tableName);
        collection = db.getCollection(collectionName);
    }

    public void close(){
        client.close();
    }
}
