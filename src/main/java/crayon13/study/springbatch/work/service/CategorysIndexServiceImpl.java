package crayon13.study.springbatch.work.service;

import crayon13.study.springbatch.work.search.Index;
import crayon13.study.springbatch.work.search.IndexHelper;
import crayon13.study.springbatch.work.search.SearchFactory;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategorysIndexServiceImpl implements CategorysIndexService {
    public static final Index index = Index.CATEGORYS;

    @Autowired
    private SearchFactory searchFactory;

    @Autowired
    private IndexHelper indexHelper;

    @Override
    public Response createIndex() throws Exception {
        log.info("CategorysIndexServiceImpl > createIndex");
        return indexHelper.createIndex(searchFactory, index);
    }

    @Override
    public Response insertBulk(String bulk) throws Exception {
        return indexHelper.insertBulk(searchFactory, bulk);
    }

    @Override
    public Response getLatestUpdateDate() throws Exception {
        return null;
    }
}
