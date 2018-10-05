package mongodao;

import org.bson.Document;

import java.util.List;

public interface DAO<T> {

    /**
     * finds first document in moviedetails collection
     * @return the first document
     */
    T findFirst();

    List<T> findAll();

    void insert(T orm);

    void insertAll(List<T> orms);

    void update(T orm);

    void deleteOne(String id);

    T findOne(String id);

}
