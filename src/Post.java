
/**
 * Class that represents Posts in the TokTik app,a post is made of video,title and likes
 * created 17 April 2023
 *@author Michael Maseko
 */
public class Post {
    /**
     * 
     */
    String Video,Title;
    protected  int Likes;
    public Post(String video,String title, int likes){
        this.Title = title;
        this.Video = video;
        this.Likes = likes;
    }
    public String toString(){
        return "Title: " + Title + "\nVideo: " + Video +"\nNumber of Likes: " + Likes;
    }

}