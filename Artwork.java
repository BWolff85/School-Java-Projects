package artwork;

/**
 *
 * @author Brittany Wolff
 */
public class Artwork {

    private String id;
    private String artist;
    private Integer year;
    private String location;
    
    /**
     *
     * @param id
     * @param artist
     * @param year
     * @param location
     */
    public Artwork(String id, String artist, int year, String location) {
        this.id = id;
        this.artist = artist;
        this.year = year;
        this.location = location;
    }
    
    /**
     *
     * @return
     */
    public String getID() {
        return id;
    }
    
    /**
     *
     * @return
     */
    public String getArtist() {
        return artist;
    }
    
    /**
     *
     * @return
     */
    public int getYear() {
        return year;
    }
    
    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }
    
    /**
     *
     * @param id
     */
    public void setID(String id) {
        this.id = id;
    }
    
    /**
     *
     * @param artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    /**
     *
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    
    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    /**
     *
     * @return
     */
    public String getTest() {
        String test = "Hello world!";
        return test;
    }
    
    /**
     *
     * @return
     */
    public String toString() {
        String art = "id: "+id+" \nartist: "+artist+"\nyear: "+year+"\nlocation: "+location;
        return art;
    }
}
