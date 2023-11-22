package com.sis.rest.respository;

import com.sis.rest.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository <Movies, Long> {
    @Query(value = "SELECT * FROM movies WHERE id =:id" , nativeQuery = true)
    Movies findByid(@Param("id") Long id);


}
