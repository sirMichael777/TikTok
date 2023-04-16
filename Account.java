import java.util.ArrayList;
public class Account implements Comparable<Account>{
    protected String Name;
    protected String Description;
    public String toString(){
        return this.Name;
    }public ArrayList<String> Posts = new ArrayList<String>();
    public Account(String name, String description){
        this.Description = description;
        this.Name = name;
    }
    public int compareTo(Account Another){
        return this.Name.compareTo(Another.Name);
    }
}