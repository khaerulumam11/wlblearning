package com.wlb.framework.learning.data.local.db.dao.course;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.wlb.framework.learning.data.model.db.Course;
import com.wlb.framework.learning.data.model.db.User;

import java.util.List;

@Dao
public interface CourseDao {
    @Delete
    void delete(Course course);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Course course);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Course> courseList);

    @Query("SELECT * FROM courses")
    List<Course> loadAll();

    @Query("SELECT * FROM courses WHERE id = :userId")
    List<Course> loadAllByIds(Long userId);

}
