import java.util.Date;

public class Block {

    // current block hash
    public String hash;

    //previous block hash
    public String previousHash;

    //current block data
    private String data;

    //time stamp
    private long timeStamp;

    private int nonce;

    public Block (String hash, String previousHash, String data){
        this.hash = hash;
        this.previousHash = previousHash;
        this.data = data;
    }

    public Block (String previousHash, String data){
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash(){
        String calculateHash = StringUtil.applySha256(
                previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data
        );
        return calculateHash;
    }

    /*
    calculate hash until get a block satisfy the difficulty requirement
     */
    public void mineBlock (int difficulty){
        //Create a String with difficulty * 0
        String target = new String (new char[difficulty]).replace('\0','0');
        while (!hash.substring(0,difficulty).equals(target)){
            nonce ++;
            hash = calculateHash();
        }
    }
}
