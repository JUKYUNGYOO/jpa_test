package me.whiteship.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {
        @Autowired
        PostRepository postRepository;

        @Test
        @Rollback(false)
        public void crudRepository(){
            //Given 이 조건에
            Post post = new Post();
            post.setTitle("hello spring boot common");
            assertThat(post.getId()).isNull();
            //Transient상태일 때 id는 null


            //When 이 때
            Post newPost = postRepository.save(post);

            //Then 기대한다.
            assertThat(newPost.getId()).isNotNull();


            //When
            List<Post> posts = postRepository.findAll();

            //Then
            assertThat(posts.size()).isEqualTo(1);
            assertThat(posts).contains(newPost);

            //When
            Page<Post> page=postRepository.findAll(PageRequest.of(0,10));
            assertThat(page.getTotalElements()).isEqualTo(1);
            assertThat(page.getNumber()).isEqualTo(0);
            assertThat(page.getSize()).isEqualTo(10); //최대 size 10
            assertThat(page.getNumberOfElements()).isEqualTo(1);
            //현재 페이지에 들어 올 수 있는 갯수 한개

            //when
            page = postRepository.findByTitleContains("spring",PageRequest.of(0,10));
            assertThat(page.getTotalElements()).isEqualTo(1);
            assertThat(page.getNumber()).isEqualTo(0);
            assertThat(page.getSize()).isEqualTo(10); //최대 size 10
            assertThat(page.getNumberOfElements()).isEqualTo(1);


            //When
            long spring = postRepository.countByTitleContaining("spring");
            //Then
            assertThat(spring).isEqualTo(1);
        }

}










