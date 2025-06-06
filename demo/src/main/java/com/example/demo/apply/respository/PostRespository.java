package com.example.demo.apply.respository;

import com.example.demo.apply.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRespository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findByAuthor_Id(Long authorId);
    List<PostEntity> findByCategory_Name(String categoryName);
}
