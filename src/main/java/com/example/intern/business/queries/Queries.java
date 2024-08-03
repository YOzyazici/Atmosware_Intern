package com.example.intern.business.queries;

public class Queries {
    public static class Batchman{
        public static final String batchmanQuery = "SELECT * FROM aziz.BATCHMAN b WHERE " +
                "LOWER(b.batch_id) LIKE LOWER('%' || :searchTerm || '%') OR " +
                "LOWER(b.batch_desc) LIKE LOWER('%' || :searchTerm || '%') OR " +
                "LOWER(b.script) LIKE LOWER('%' || :searchTerm || '%') OR " +
                "LOWER(DBMS_LOB.SUBSTR(b.script_clob, 4000, 1)) LIKE LOWER('%' || :searchTerm || '%')";
    }

    public static class ExtractFeed{
        public static final String extractFeedQuery = "SELECT * FROM yasin.EXTRACT_FEED e WHERE " +
                "LOWER(e.feed_id) LIKE LOWER('%' || :searchTerm || '%') OR " +
                "LOWER(e.feed_desc) LIKE LOWER('%' || :searchTerm || '%') OR " +
                "LOWER(e.feed_file_name) LIKE LOWER('%' || :searchTerm || '%') OR " +
                "LOWER(e.ex_sql) LIKE LOWER('%' || :searchTerm || '%') OR " +
                "LOWER(e.post_script) LIKE LOWER('%' || :searchTerm || '%') OR " +
                "LOWER(DBMS_LOB.SUBSTR(e.prev_script, 4000, 1)) LIKE LOWER('%' || :searchTerm || '%')";

    }
}
