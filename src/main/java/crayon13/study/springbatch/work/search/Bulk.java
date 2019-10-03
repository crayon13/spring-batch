package crayon13.study.springbatch.work.search;

public enum Bulk {
    INDEX("index") {
    },
    UPDATE("update") {
    }, DELETE("delete") {
        @Override
        public String getBodyJsonString(String bodyJsonString) {
            return System.lineSeparator();
        }
    };

    private String event;

    Bulk(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public String getHeadJsonString(String headJsonString){
        return "{\"" + event + "\": " + headJsonString + "}" + System.lineSeparator();
    }

    public String getBodyJsonString(String bodyJsonString) {
        return "{\"doc\": " + bodyJsonString + ", \"doc_as_upsert\" : true}" + System.lineSeparator();
    }
}
