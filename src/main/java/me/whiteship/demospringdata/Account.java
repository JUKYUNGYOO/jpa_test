package me.whiteship.demospringdata;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
도메인 클래스가 Entity 라서
자동으로 테이블로 매핑
 */

//하이버네이트 내부에서 Entity 이름 myAccount ,객체 세상에서만 사용
@Entity
public class Account {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable=false, unique=true)
    private String username;

    private String password;

    @ManyToOne
    private Account owner;
    /*
    Study 의 주인이 누구냐? = owner
    owner가 FK를 가지고 있음.
     */

    /*
    한 Account는 여러개의 study를 만들 수 있다.
     */
    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }






    @Temporal(TemporalType.TIME)
    private Date created = new Date();

    private String yes;

    @Transient //일시적,컬럼으로 매핑을 안해 줌.
    private String no;



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street",
                    column = @Column(name="home_street"))
    })
    private Address address;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void addStudy(Study study) {
         this.getStudies().add(study);
        study.setOwner(this);

    }
    public void removeStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(null);

    }
}
