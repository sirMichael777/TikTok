import java.util.Stack;
/**
 * Class that is used for TokTik users account creation. 
 * created 17 April
 * @author Michael
 */
public class Account implements Comparable<Account> {
    String Name;
    String Description;

    public String toString() {
        return this.Name;
    }

    Stack<Post> Posts = new Stack<Post>();
    /**
     * Constructor for creating a new account
     * @param name The name of the account or username
     * @param description The account's description
     */
    public Account(String name, String description) {
        this.Description = description;
        this.Name = name;
    }

    public String getDescription(Account account) {
        return "The profile description of " + Name + " is: " + Description;
    }
    /**
     * Constructor for creating a temporary account which is then used for comparison or searching purposes only
     * @param name The name of the account or username
     */
    public Account(String name) {
        this.Name = name;
    }

    public int compareTo(Account Another) {
        return this.Name.compareTo(Another.Name);
    }
}
