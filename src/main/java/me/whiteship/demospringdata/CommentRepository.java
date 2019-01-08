package me.whiteship.demospringdata;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;
import java.util.stream.Stream;

public interface CommentRepository extends MyRepository<Commentt,Long> {

Stream<Commentt> findByCommentContainsIgnoreCase
        (String keyword,Pageable pageable);


}
