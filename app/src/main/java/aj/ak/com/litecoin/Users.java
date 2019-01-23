package aj.ak.com.litecoin;

/**
 * Created by abrar on 3/12/2018.
 */

public class Users {
    String userId;
    public String name;
    public String email;
    public long coins;
    public String bitAddress;
    public String xapoAddress;
    public long Winnercoin;
    public Users(){

    }
    public Users(String userId, String name , String email, long coins, String bitAddress, String xapoAddress, long Winnercoin){
        this.userId =  userId;
        this.name = name;
        this.email = email;
        this.coins = coins;
        this.bitAddress =  bitAddress;
        this.xapoAddress = xapoAddress;
        this.Winnercoin = Winnercoin;

    }
}
