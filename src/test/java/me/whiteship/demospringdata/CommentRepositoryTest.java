package me.whiteship.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {
        this.createComment(100,"spring data jpa");
        this.createComment(55,"HIBERNATE SPRING");

        PageRequest pageRequest = PageRequest.of(0,10,
                Sort.by(Sort.Direction.DESC, "LikeCount"));



    try(Stream<Commentt> commentts =
            commentRepository.findByCommentContainsIgnoreCase("Spring",pageRequest)){
               Commentt firstComment = commentts.findFirst().get();
                assertThat(firstComment.getLikeCount()).isEqualTo(100);

    }


    }


    public void createComment(int likeCount,String comment) {
        Commentt newCommentt = new Commentt();
        newCommentt.setLikeCount(likeCount);
        newCommentt.setComment("spring data jpa");
        commentRepository.save(newCommentt);

    }
}













