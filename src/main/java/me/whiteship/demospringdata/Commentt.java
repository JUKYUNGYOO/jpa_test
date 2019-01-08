package me.whiteship.demospringdata;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Commentt {
@Id
@GeneratedValue
private Long id;
private String comment;
@ManyToOne
private Post post;
/*
Comment의 정보를 로딩할 때 post의 정보를 같이 가지고 옴.
 */
    private Date created;

    private Integer likeCount=0;


    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
