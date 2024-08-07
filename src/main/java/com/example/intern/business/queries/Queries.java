package com.example.intern.business.queries;

public class Queries {
    public static class Batchman{
        public static final String batchmanQuery = "SELECT * FROM aziz.BATCHMAN b WHERE " +
                "(:searchTerms) IS NULL OR " +
                "EXISTS (SELECT 1 FROM (SELECT REGEXP_SUBSTR(:searchTerms, '[^ ]+', 1, LEVEL) AS keyword FROM dual CONNECT BY REGEXP_SUBSTR(:searchTerms, '[^ ]+', 1, LEVEL) IS NOT NULL) WHERE " +
                "LOWER(b.batch_id) LIKE LOWER('%' || keyword || '%') OR " +
                "LOWER(b.batch_desc) LIKE LOWER('%' || keyword || '%') OR " +
                "LOWER(b.script) LIKE LOWER('%' || keyword || '%') OR " +
                "LOWER(DBMS_LOB.SUBSTR(b.script_clob, 4000, 1)) LIKE LOWER('%' || keyword || '%'))";
    }

    public static class ExtractFeed{
        public static final String extractFeedQuery = "SELECT * FROM yasin.EXTRACT_FEED e WHERE " +
                "(:searchTerms) IS NULL OR " +
                "EXISTS (SELECT 1 FROM (SELECT REGEXP_SUBSTR(:searchTerms, '[^ ]+', 1, LEVEL) AS keyword FROM dual CONNECT BY REGEXP_SUBSTR(:searchTerms, '[^ ]+', 1, LEVEL) IS NOT NULL) WHERE " +
                "LOWER(e.feed_id) LIKE LOWER('%' || keyword || '%') OR " +
                "LOWER(e.feed_desc) LIKE LOWER('%' || keyword || '%') OR " +
                "LOWER(e.feed_file_name) LIKE LOWER('%' || keyword || '%') OR " +
                "LOWER(e.ex_sql) LIKE LOWER('%' || keyword || '%') OR " +
                "LOWER(e.post_script) LIKE LOWER('%' || keyword || '%') OR " +
                "LOWER(DBMS_LOB.SUBSTR(e.prev_script, 4000, 1)) LIKE LOWER('%' || keyword || '%'))";

    }

    public static class DbaSource{

        public static final String dbaSourceQuery = "";
    }
}
