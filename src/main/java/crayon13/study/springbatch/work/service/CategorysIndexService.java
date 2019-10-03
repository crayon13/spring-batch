package crayon13.study.springbatch.work.service;

import org.elasticsearch.client.Response;

public interface CategorysIndexService {
    Response createIndex() throws Exception;
    Response insertBulk(String bulk) throws Exception;
    Response getLatestUpdateDate() throws Exception;
}
