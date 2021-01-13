package com.assignment.nosql.repository;

import com.assignment.nosql.model.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface blogRepository extends CrudRepository<Blog,String> {

    List<Blog> findByAuthor(String author);

    //	@Override
    List<Blog> findByTags(String tag);

    List<Blog> deleteByTopicAndAuthor(String title, String author);


}
