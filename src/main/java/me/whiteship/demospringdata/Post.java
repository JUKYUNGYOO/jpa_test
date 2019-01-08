package me.whiteship.demospringdata;




import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    /*

     */

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Commentt> commentts = new HashSet<>();

    public void addComment(Commentt commentt){
        this.getCommentts().add(commentt);
        commentt.setPost(this);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Commentt> getCommentts() {
        return commentts;
    }

    public void setCommentts(Set<Commentt> commentts) {
        this.commentts = commentts;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                '}';
    }
}
