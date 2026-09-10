import java.util.Scanner;
public class Main {
    private static Scanner input = new Scanner(System.in);
    private static UserManager manager = new UserManager();
    private static int nextId = 1;
    public static void main(String[] args) {
        seedSampleUsers();
        boolean running = true;
        while (running) {
            showMenu();
            String choice = input.nextLine().trim();
            if (choice.equals(&quot;1&quot;)) {
                addUser();
            } else if (choice.equals(&quot;2&quot;)) {
                manager.listAll();
            } else if (choice.equals(&quot;3&quot;)) {
                searchUser();
            } else if (choice.equals(&quot;4&quot;)) {
                deleteUser();
            } else if (choice.equals(&quot;5&quot;)) {
                manager.exportAll();
            } else if (choice.equals(&quot;6&quot;)) {
                System.out.println(&quot;Goodbye!&quot;);
                running = false;
            } else {
                System.out.println(&quot;Invalid choice. Please enter 1 to 6.&quot;);
            }
            System.out.println();
        }
    }
    private static void showMenu() {
        System.out.println(&quot;===== USER MANAGEMENT SYSTEM =====&quot;);
        System.out.println(&quot;1. Add user&quot;);
        System.out.println(&quot;2. List all users&quot;);
        System.out.println(&quot;3. Search user by ID&quot;);
        System.out.println(&quot;4. Delete user by ID&quot;);
        System.out.println(&quot;5. Export all users&quot;);
        System.out.println(&quot;6. Exit&quot;);
        System.out.print(&quot;Choose an option: &quot;);
    }
    private static void addUser() {
        System.out.println(&quot;Type of user: 1 = Admin 2 = Teacher 3 = Student&quot;);
        System.out.print(&quot;Choose type: &quot;);
        String type = input.nextLine().trim();
        System.out.print(&quot;Name: &quot;);
        String name = input.nextLine().trim();
        System.out.print(&quot;Email: &quot;);

        String email = input.nextLine().trim();
        User user; // the variable is the ABSTRACT type
        if (type.equals(&quot;1&quot;)) {
            user = new Admin(nextId, name, email);
        } else if (type.equals(&quot;2&quot;)) {
            System.out.print(&quot;Department: &quot;);
            String dept = input.nextLine().trim();
            user = new Teacher(nextId, name, email, dept);
        } else if (type.equals(&quot;3&quot;)) {
            System.out.print(&quot;Course: &quot;);
            String course = input.nextLine().trim();
            user = new Student(nextId, name, email, course);
        } else {
            System.out.println(&quot;Unknown type. User was not added.&quot;);
            return;
        }
        manager.add(user);
        nextId++;
    }
    private static void searchUser() {
        System.out.print(&quot;Enter ID to search: &quot;);
        int id = readInt();
        User found = manager.findById(id);
        if (found == null) {
            System.out.println(&quot;No user found with ID &quot; + id + &quot;.&quot;);
        } else {
            System.out.println(&quot;Found:&quot;);
            found.display();
        }
    }
    private static void deleteUser() {
        System.out.print(&quot;Enter ID to delete: &quot;);
        int id = readInt();
        if (manager.deleteById(id)) {
            System.out.println(&quot;User &quot; + id + &quot; was deleted.&quot;);
        } else {
            System.out.println(&quot;No user found with ID &quot; + id + &quot;.&quot;);
        }
    }
    private static int readInt() {
        while (true) {
            String line = input.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print(&quot;That is not a number. Try again: &quot;);
            }
        }
    }
    private static void seedSampleUsers() {
        manager.add(new Admin(nextId, &quot;Razz&quot;, &quot;razz@liceo.edu.ph&quot;));
        nextId++;
        manager.add(new Teacher(nextId, &quot;Maria&quot;, &quot;maria@liceo.edu.ph&quot;, &quot;CIT&quot;));
        nextId++;
        manager.add(new Student(nextId, &quot;Ana&quot;, &quot;ana@liceo.edu.ph&quot;, &quot;BSIT&quot;));
        nextId++;
        System.out.println();
    }
}