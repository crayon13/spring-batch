package crayon13.study.springbatch.work.db;

import org.springframework.batch.item.database.AbstractPagingItemReader;
import org.springframework.dao.DataAccessResourceFailureException;

import javax.persistence.EntityManager;
import java.util.concurrent.CopyOnWriteArrayList;


public class QuerydslItemReader<T> extends AbstractPagingItemReader<T> {

    private EntityManager entityManager;

    public QuerydslItemReader() {
    }

    @Override
    protected void doOpen() throws Exception {
        super.doOpen();


    }

    @Override
    protected void doReadPage() {

    }

    @Override
    protected void doJumpToPage(int itemIndex) {

    }

    @Override
    protected void doClose() throws Exception {
        entityManager.clear();
        super.doClose();
    }
}
