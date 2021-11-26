package crud.packages.model.Done;

import javax.persistence.*;

@Entity
@Table(name = "actors")
public class Actor {

    private long id;
    private Movie movie;
    private String name;

    public Actor (){}

    public Actor (String name, Movie movie) {
        this.name = name;
        this.movie = movie;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId(){return id;}
    public void setId(long id) {this.id = id;}

    @Column(name = "name", nullable = false)
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    @ManyToOne
    @JoinColumn(name="movie_id")
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
