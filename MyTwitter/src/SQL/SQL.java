package SQL;

import java.sql.Connection;
import java.sql.SQLException;

public class SQL {

    private static final DatabaseInitializer  databaseInitializer = new DatabaseInitializer();

    private static final UserRepository userRepository = new UserRepository();
    private static final PostRepository postRepository = new PostRepository();
    private static final ChatRepository chatRepository = new ChatRepository();
    private static final GroupRepository groupRepository = new GroupRepository();
    private static final CommentRepository commentRepository = new CommentRepository();
    private static final LikeRepository likeRepository = new LikeRepository();
    private static final MessageRepository messageRepository = new MessageRepository();
    private static final FollowersRepository followersRepository = new FollowersRepository();
    private static final FollowRequestRepository followRequestRepository = new FollowRequestRepository();
    private static final ViewerOfPostRepository viewerOfPostRepository = new ViewerOfPostRepository();
    private static final DataPDOfPostRepository dataPDOfPostRepository = new DataPDOfPostRepository();
    private static final ViewPDOfUserRepository viewPDOfUserRepository = new ViewPDOfUserRepository();
    private static final InterestRepository interestRepository = new InterestRepository();
    private static final BlockRepository blockRepository = new BlockRepository();

    public static void loadAll(Connection connection) throws SQLException {
        userRepository.loadUsers(connection);
        postRepository.loadPosts(connection);
        chatRepository.loadChats(connection);
        groupRepository.loadGroup(connection);
        commentRepository.loadComment(connection);
        likeRepository.loadLike(connection);
        messageRepository.loadMessage(connection);
        followersRepository.loadFollowers(connection);
        followRequestRepository.loadFollowRequest(connection);
        viewerOfPostRepository.loadViewerOfPost(connection);
        dataPDOfPostRepository.loadDataPDOfPost(connection);
        viewPDOfUserRepository.loadViewPDOfUser(connection);
        interestRepository.loadInterest(connection);
        blockRepository.loadBlock(connection);
    }
    public static void insertAll(Connection connection) throws SQLException {
        userRepository.insertUsers(connection);
        postRepository.insertPost(connection);
        chatRepository.insertChats(connection);
        groupRepository.insertGroup(connection);
        commentRepository.insertComment(connection);
        likeRepository.insertLike(connection);
        messageRepository.insertMessage(connection);
        followersRepository.insertFollowers(connection);
        followRequestRepository.insertFollowRequest(connection);
        viewerOfPostRepository.insertViewerOfPost(connection);
        dataPDOfPostRepository.insertDataPDOfPost(connection);
        viewPDOfUserRepository.insertViewPDOfUser(connection);
        interestRepository.insertViewPDOfUser(connection);
        blockRepository.insertBlock(connection);
    }
    public static DatabaseInitializer getDatabaseInitializer() { return databaseInitializer; }

    public PostRepository getPostRepository() {
        return postRepository;
    }

    public ChatRepository getChatRepository() {
        return chatRepository;
    }

    public GroupRepository getGroupRepository() {
        return groupRepository;
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

    public LikeRepository getLikeRepository() {
        return likeRepository;
    }

    public MessageRepository getMessageRepository() {
        return messageRepository;
    }

    public FollowersRepository getFollowersRepository() {
        return followersRepository;
    }

    public FollowRequestRepository getFollowRequestRepository() {
        return followRequestRepository;
    }

    public ViewerOfPostRepository getViewerOfPostRepository() {
        return viewerOfPostRepository;
    }

    public DataPDOfPostRepository getDataPDOfPostRepository() {
        return dataPDOfPostRepository;
    }

    public ViewPDOfUserRepository getViewPDOfUserRepository() {
        return viewPDOfUserRepository;
    }

    public InterestRepository getInterestRepository() {
        return interestRepository;
    }

    public BlockRepository getBlockRepository() {
        return blockRepository;
    }


    public UserRepository getUserRepository() { return userRepository; }

}
