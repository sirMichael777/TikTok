
/**
 * Class that represents Posts in the TokTik app,a post is made of video,title and likes
 * created 17 April 2023
 *@author Michael Maseko
 */
public class Post {
    /**
     * Video is the video that the user wants to post then title is the title of the post
     */
    protected String Video,Title;
    /**
     * The number of likes a video contains
     */
    protected  int Likes;
    /**
     * Constructor to create an object of post type
     * @param video The video of the post that the user wants to post
     * @param title The title of the post
     * @param likes The number of likes that the user have
     */
    public Post(String video,String title, int likes){
        this.Title = title;
        this.Video = video;
        this.Likes = likes;
    }
    public String toString(){
        return "Title: " + Title + "\nVideo: " + Video +"\nNumber of Likes: " + Likes;
    }

}