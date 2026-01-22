/*
 This program implements a Singly Linked List for managing Social Media Friend Connections.
 Each user node stores basic details and a linked list of friend IDs.
*/

public class socialmediafriendconnectionslist {

    // Node for Friend ID list
    static class FriendNode {
        int friendId;
        FriendNode next;

        FriendNode(int friendId) {
            this.friendId = friendId;
            this.next = null;
        }
    }

    // Node for User list
    static class UserNode {
        int userId;
        String name;
        int age;
        FriendNode friends;   // head of friend list
        UserNode next;

        UserNode(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = null;
            this.next = null;
        }
    }

    // Singly Linked List for Users
    static class UserList {
        UserNode head;

        // Add a new user
        void addUser(int id, String name, int age) {
            UserNode newUser = new UserNode(id, name, age);
            newUser.next = head;
            head = newUser;
        }

        // Find user by ID
        UserNode findUserById(int id) {
            UserNode temp = head;
            while (temp != null) {
                if (temp.userId == id)
                    return temp;
                temp = temp.next;
            }
            return null;
        }

        // Find user by name
        UserNode findUserByName(String name) {
            UserNode temp = head;
            while (temp != null) {
                if (temp.name.equalsIgnoreCase(name))
                    return temp;
                temp = temp.next;
            }
            return null;
        }

        // Add friend connection (both ways)
        void addFriendConnection(int id1, int id2) {
            UserNode u1 = findUserById(id1);
            UserNode u2 = findUserById(id2);

            if (u1 == null || u2 == null) {
                System.out.println("User not found");
                return;
            }

            addFriend(u1, id2);
            addFriend(u2, id1);
            System.out.println("Friend connection added");
        }

        // Helper to add friend to friend list
        void addFriend(UserNode user, int friendId) {
            FriendNode newFriend = new FriendNode(friendId);
            newFriend.next = user.friends;
            user.friends = newFriend;
        }

        // Remove friend connection
        void removeFriendConnection(int id1, int id2) {
            UserNode u1 = findUserById(id1);
            UserNode u2 = findUserById(id2);

            if (u1 == null || u2 == null) {
                System.out.println("User not found");
                return;
            }

            removeFriend(u1, id2);
            removeFriend(u2, id1);
            System.out.println("Friend connection removed");
        }

        // Helper to remove friend from list
        void removeFriend(UserNode user, int friendId) {
            FriendNode temp = user.friends, prev = null;

            while (temp != null) {
                if (temp.friendId == friendId) {
                    if (prev == null)
                        user.friends = temp.next;
                    else
                        prev.next = temp.next;
                    return;
                }
                prev = temp;
                temp = temp.next;
            }
        }

        // Display all friends of a user
        void displayFriends(int userId) {
            UserNode user = findUserById(userId);
            if (user == null) {
                System.out.println("User not found");
                return;
            }

            System.out.println("Friends of " + user.name + ":");
            FriendNode temp = user.friends;
            if (temp == null) {
                System.out.println("No friends");
                return;
            }

            while (temp != null) {
                System.out.println("Friend ID: " + temp.friendId);
                temp = temp.next;
            }
        }

        // Find mutual friends between two users
        void findMutualFriends(int id1, int id2) {
            UserNode u1 = findUserById(id1);
            UserNode u2 = findUserById(id2);

            if (u1 == null || u2 == null) {
                System.out.println("User not found");
                return;
            }

            System.out.println("Mutual Friends:");
            FriendNode f1 = u1.friends;

            while (f1 != null) {
                FriendNode f2 = u2.friends;
                while (f2 != null) {
                    if (f1.friendId == f2.friendId) {
                        System.out.println("Friend ID: " + f1.friendId);
                    }
                    f2 = f2.next;
                }
                f1 = f1.next;
            }
        }

        // Count number of friends for each user
        void countFriends() {
            UserNode temp = head;
            while (temp != null) {
                int count = 0;
                FriendNode f = temp.friends;
                while (f != null) {
                    count++;
                    f = f.next;
                }
                System.out.println(temp.name + " has " + count + " friends");
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {

        UserList users = new UserList();

        // Adding users
        users.addUser(1, "Aryan", 21);
        users.addUser(2, "Rahul", 22);
        users.addUser(3, "Neha", 20);
        users.addUser(4, "Kunal", 23);

        // Adding friend connections
        users.addFriendConnection(1, 2);
        users.addFriendConnection(1, 3);
        users.addFriendConnection(2, 3);
        users.addFriendConnection(2, 4);

        // Display friends
        users.displayFriends(1);

        // Find mutual friends
        users.findMutualFriends(1, 2);

        // Remove friend connection
        users.removeFriendConnection(1, 3);

        // Display updated friends
        users.displayFriends(1);

        // Count friends for each user
        users.countFriends();
    }
}
