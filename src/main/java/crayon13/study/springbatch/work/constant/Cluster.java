package crayon13.study.springbatch.work.constant;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
public enum Cluster {
    CLUSTER_1("cluster-1");

    private String clusterName;
    private String host;
    private int port;

    Cluster(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getClusterName() {
        return clusterName;
    }

    private void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    private void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    @Component
    public static class ClusterInforInjector {
        @Autowired
        Environment environment;

        @PostConstruct
        public void postConstruct() {
            for (Cluster cluster : Cluster.values()) {
                String environmentPrefix = "elasticsearch.cluster." + cluster.getClusterName() + ".";

                cluster.setHost(environment.getProperty(environmentPrefix + "host", ""));
                cluster.setPort(NumberUtils.toInt(environment.getProperty(environmentPrefix + "port")));

                log.debug(">>>>>>>>>>>>>>>> {} {} {}", environmentPrefix, cluster.getHost(), cluster.getPort());
            }

        }
    }
}
