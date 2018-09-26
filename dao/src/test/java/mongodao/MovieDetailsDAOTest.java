package mongodao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import orm.MovieDetailsORM;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
        assertEquals("Thu Jun 15 00:00:00 EDT 2017", orm.getRelease_date());
        assertEquals(5,orm.getGenres().size());
        assertEquals(1,orm.getDirectors().size());
    }

    @Test
    public void findAllTest (){
        List<MovieDetailsORM> orms = dao.findAll();


        assertEquals(22, orms.size());
    }

    @AfterAll
    public static void after() {
            dao.close();
    }
}
