import java.util.ArrayList;
import java.util.Scanner;
public class ExploreController {
   public void explore(Scanner scanner, User user) {
      //   باید پست های رندوم از فالوراش sout شه
      // اونایی که دارن نشون داده میشن با شمارشون به ترتیب ذخیره شن!
      ArrayList<Post> showingPost = new ArrayList<>();
      System.out.println("1.Choose A Post");
      System.out.println("2.Create Post");
      int num = scanner.nextInt();
      scanner.nextLine();
      if (num == 1) {
         System.out.println("Choose the Post Number:");
         int postNo = scanner.nextInt();
         scanner.nextLine();
         System.out.println("Choose One:");
         System.out.println("1.Like");
         System.out.println("2.Add Comment");
         // todo اگه کاربر تجاری باشه show state!
         int number = scanner.nextInt();
         scanner.nextLine();
         if (number == 1) {
            Post post = showingPost.get(postNo);
            post.likes.add(user);
            System.out.println("You Liked the Post!");
         }

         if (number == 2) {
            Post post = showingPost.get(postNo);
            System.out.println("Add Your Text:");
            String comment = scanner.nextLine();
            Post comment = new Post(comment, user);
            post.comments.add(comment);
         }
      }

      if(num == 2){
         System.out.println("Write Your Text:");
         String postMsg = scanner.nextLine();
         Post post = new Post(postMsg, user);
         System.out.println("Post Created Successfully!");
      }
   }
}
