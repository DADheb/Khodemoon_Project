import java.util.ArrayList;

public class Post {
    String postMessage;
    //User user;
    //ArrayList<User> likes = new ArrayList<User>();
    //ArrayList<Post> comments = new ArrayList<Post>();
    // برای کاربر تجاری باید زمان ذخیره شه؟؟
    public Post(String postMessage , User user) {
        this.postMessage = postMessage;
        this.user = user;
        // todo اضافه کردن لیست ها
        // این پست به پست های یوزر ادد بشه user.posts.add....
    }

    public void showPost(){
        System.out.println(postMessage);
    }
    public void showLikes (){
        System.out.println(likes.size());
    }
    public void showComments (){
        for (int i = 0; i < comments.size(); i++) {
            System.out.println(comments.get(i).postMessage + " " + comments.get(i).likes.size());
        }
    }
    public void like(User user){
        likes.add(user);
    }
}
