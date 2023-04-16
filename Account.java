import java.util.ArrayList;
import java.util.Stack;
public class Account implements Comparable<Account>{
    protected String Name;
    protected String Description;
    public String toString(){
        return this.Name;
    }
    Stack<String> Posts = new Stack<String>();
    public Account(String name, String description){
        this.Description = description;
        this.Name = name;
    }
    public String getDescription(Account account){
        return "The profile description is " + Description;
    }
    public Account (String name){
        this.Name = name;
    }
    public int compareTo(Account Another){
        return this.Name.compareTo(Another.Name);
    }
    
}