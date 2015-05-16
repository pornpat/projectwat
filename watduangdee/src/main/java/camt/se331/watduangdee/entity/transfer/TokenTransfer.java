package camt.se331.watduangdee.entity.transfer;

/**
 * Created by Dell on 2/5/2558.
 */
public class TokenTransfer {
private final String token;
    public TokenTransfer(String token) {
        this.token = token;
    }
    public String  getToken(){
        return this.token;
    }
}
