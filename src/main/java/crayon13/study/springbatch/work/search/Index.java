package crayon13.study.springbatch.work.search;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public enum Index {
    CATEGORYS(Arrays.asList("categorys.0"), "", "/categorys/json_body/mapping.json");

    private String alias;
    private List<String> indeces;
    private String mappingJsonPath;

    Index(List<String> indeces, String alias, String mappingJsonPath) {
        this.indeces = indeces;
        this.alias = alias;
        this.mappingJsonPath = mappingJsonPath;

        if ( StringUtils.isBlank(this.alias) ) {
            this.alias = this.indeces.get(0);
        }
    }


    public String getMappingJsonPath() {
        return mappingJsonPath;
    }

    public String getAlias() {
        return alias;
    }
}
