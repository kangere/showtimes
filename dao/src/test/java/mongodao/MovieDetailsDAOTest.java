package mongodao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import orm.MovieDetailsORM;

import java.net.URL;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


public class MovieDetailsDAOTest {

    private static MovieDetailsDAO dao;

    @BeforeAll
    public static void before(){
        dao = new MovieDetailsDAO();
    }


    @Test
    public void findOneTest() throws Exception{
        MovieDetailsORM orm = dao.findFirst();
        assertEquals("tt0451279",orm.getConstant());
        assertEquals("Wonder Woman",orm.getTitle());
        assertEquals(7.5,orm.getRating());
        assertEquals(141,orm.getRuntime());
        assertEquals(390613,orm.getVotes());
        assertEquals(new URL("https://www.imdb.com/title/tt0451279/"),orm.getUrl());
        assertEquals("Thu Jun 15 00:00:00 EDT 2017", orm.getRelease_date().toString());
        assertEquals(5,orm.getGenres().size());
        assertEquals(1,orm.getDirectors().size());
    }

    @Test
    public void findAllTest (){
        List<MovieDetailsORM> orms = dao.findAll();


        assertEquals(22, orms.size());
    }

    @Test
    public void findByIdTest() throws Exception{
        MovieDetailsORM orm = dao.findOne("5adbda9601fa59726002b175");

        assertEquals("tt0451279",orm.getConstant());
        assertEquals("Wonder Woman",orm.getTitle());
        assertEquals(7.5,orm.getRating());
        assertEquals(141,orm.getRuntime());
        assertEquals(390613,orm.getVotes());
        assertEquals(new URL("https://www.imdb.com/title/tt0451279/"),orm.getUrl());
        assertEquals("Thu Jun 15 00:00:00 EDT 2017", orm.getRelease_date().toString());
        assertEquals(5,orm.getGenres().size());
        assertEquals(1,orm.getDirectors().size());
        assertNotNull(orm);
    }

    @Test
    public void insertTest(){
        MovieDetailsORM orm = new MovieDetailsORM();

        String constant = UUID.randomUUID().toString();

        orm.setTitle("Some Title");
        orm.setConstant(constant);
        orm.setRelease_date(Date.from(Instant.now()));

        dao.insert(orm);

        MongoClient c = MongoClients.create();
        MongoCollection<Document> movieDetailsCollection = c.
                getDatabase("movies").getCollection("movieDetails");

        //check if document was inserted into collection
        Document doc = movieDetailsCollection.find(eq("const",constant)).first();

        assertNotNull(doc);

        //delete test insert document
        movieDetailsCollection.deleteOne(eq("_id",doc.getObjectId("_id")));

        //check if test document was deleted
        Document doc2 = movieDetailsCollection.find(eq("_id",doc.getObjectId("_id"))).first();

        assertNull(doc2);

        c.close();
    }

    @Test
    public void deleteOneTest(){
        Document document = new Document();

        String constant = UUID.randomUUID().toString();

        document.append("title","Some Title");
        document.append("const",constant);
        document.append("release_date",Date.from(Instant.now()));

        MongoClient c = MongoClients.create();
        MongoCollection<Document> movieDetailsCollection = c.
                getDatabase("movies").getCollection("movieDetails");

        //insert test document to delete
        movieDetailsCollection.insertOne(document);
        Document doc1 = movieDetailsCollection.find(eq("const",constant)).first();
        assertNotNull(doc1);

        dao.deleteOne(doc1.getObjectId("_id").toString());

        //check if document was deleted
        Document doc2 = movieDetailsCollection.find(eq("_id",doc1.getObjectId("_id"))).first();
        assertNull(doc2);

        c.close();
    }

    @AfterAll
    public static void after() {
            dao.close();
    }
}
