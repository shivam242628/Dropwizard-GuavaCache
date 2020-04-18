package org.example.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import org.example.model.Student;
import org.example.service.StudentService;
import java.util.concurrent.TimeUnit;

public class CacheConfigManager {

    private static CacheConfigManager cacheConfigManager = new CacheConfigManager();

    public static CacheConfigManager getInstance() {
        return cacheConfigManager;
    }

    private static LoadingCache<String, Student> studentCache;

    public void initStudentCache(StudentService studentService) {
        if (studentCache == null) {
            studentCache =
                    CacheBuilder.newBuilder()
                            .concurrencyLevel(10)
                            .maximumSize(200) // Maximum of 200 records can be cached
                            .expireAfterAccess(30, TimeUnit.SECONDS) // Cache will expire after 30 minutes
                            .recordStats()
                            .build(new CacheLoader<String, Student>() {

                                @Override
                                public Student load(String universityId) throws Exception {
                                    System.out.println("Fetching Student Data from DB/ Cache Miss");
                                    return StudentService.getFromDatabase(universityId);
                                }
                            });
        }
    }

    public Student getStudentDataFromCache(String key) {
        try {
            CacheStats cacheStats = studentCache.stats();
            System.out.println("CacheStats =  " + cacheStats);
            return studentCache.get(key);
        } catch (Exception e) {
            System.out.println("Error Retrieving Elements from the Student Cache"
                    + e.getMessage());
        }
        return null;
    }
}
