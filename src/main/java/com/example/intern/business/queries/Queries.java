package com.example.intern.business.queries;

public class Queries {
    public static class Batchman{
        public static final String batchmanQuery = "SELECT b FROM Batchman b WHERE " +
                "LOWER(b.batchId) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(b.batchDesc) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(b.batchName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(b.batchChapter) LIKE LOWER(CONCAT('%', :searchTerm, '%'))";
    }

    public static class ExtractFeed{
        public static final String extractFeedQuery = "SELECT e FROM ExtractFeed e WHERE " +
                "LOWER(e.feedId) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(e.feedDesc) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(e.feedFileName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
                "LOWER(e.feedFileExt) LIKE LOWER(CONCAT('%', :searchTerm, '%'))";

    }
}
