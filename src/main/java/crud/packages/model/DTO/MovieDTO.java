package crud.packages.model.DTO;






public class MovieDTO {

    private String title;
    private String description;
    private String genre;
    private String director;
    private String language;
    private String subtitleLanguage;
    private int lengthInMinutes;
    private int year;
    private String posterSrc;


    public MovieDTO() {
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }


    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }


    public String getSubtitleLanguage() {return subtitleLanguage;}
    public void setSubtitleLanguage (String subtitleLanguage) {this.subtitleLanguage = subtitleLanguage;}


    public int getLengthInMinutes() {
        return lengthInMinutes;
    }
    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }


    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }


    public String getPosterSrc() {
        return posterSrc;
    }
    public void setPosterSrc(String posterSrc) {
        this.posterSrc = posterSrc;
    }


}
