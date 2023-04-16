public class Post {
    protected String Video, Title;
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