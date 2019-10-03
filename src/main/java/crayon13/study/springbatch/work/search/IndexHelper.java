package crayon13.study.springbatch.work.search;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@Slf4j
public class IndexHelper {
    public Response createIndex(SearchFactory searchFactory, Index index) throws Exception {
        log.info(" +++ IndexHelper > createIndex ");
        Response response = null;
        return response;
    }


    public Response insertBulk(SearchFactory searchFactory, String bulk) throws Exception {
        Response response = null;

        try (RestClient restClient = searchFactory.getSearch()) {

            HttpEntity entity = new NStringEntity(
                bulk,
                ContentType.APPLICATION_JSON
            );

            response = restClient.performRequest(
                "PUT",
                "/_bulk",
                Collections.<String, String>emptyMap(),
                entity
            );


        } catch (Exception e) {
            log.error(e.toString(), e);
            //exception 던져 batch가 중단 됨.
            throw new Exception(e);
        }

        return response;
    }
}
