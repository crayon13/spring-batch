package crayon13.study.springbatch.work.search;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SearchFactory {

    private String host;

    private int port;

    private String clusterName;

    public RestClient getSearch() {
        RestClient restClient = RestClient.builder(
            new HttpHost(host, port, "http")).build();

        return restClient;
    }
}