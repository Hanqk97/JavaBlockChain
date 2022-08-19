import java.util.ArrayList;

public class BlockChainListTest {

    //block chain
    public static ArrayList<Block> blockChain = new ArrayList<>();

    //difficulty of mine block, how many zeros in the front digit of hash
    public static int difficulty = 4;

    public static void main (String[] args){
        blockChain.add(new Block("0","This is my first block"));
        blockChain.get(0).mineBlock(difficulty);

        blockChain.add(new Block(blockChain.get(blockChain.size()-1).hash,"This is my second block"));
        blockChain.get(1).mineBlock(difficulty);

        blockChain.add(new Block(blockChain.get(blockChain.size()-1).hash,"This is my third block"));
        blockChain.get(2).mineBlock(difficulty);

        blockChain.add(new Block(blockChain.get(blockChain.size()-1).hash,"This is my fourth block"));
        blockChain.get(3).mineBlock(difficulty);

        System.out.println("Is Block Chain Valid: "+ isChainValid());
        System.out.println(JsonUtil.toJson(blockChain));
    }

    public static Boolean isChainValid(){

        Block currentBlock;
        Block previousBlock;
        boolean flag = true;
        String hashTarget = new String(new char[difficulty]).replace('\0','0');

        for(int i = 1; i < blockChain.size(); i++){
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);

            if(!currentBlock.hash.equals(currentBlock.calculateHash())){
                System.out.println("current hash not equal.");
                flag = false;
            }

            if(!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("previous hash not equal.");
                flag = false;
            }

            if(!currentBlock.hash.substring(0,difficulty).equals(hashTarget)){
                System.out.println("this block has already been mined.");
                flag = false;
            }
        }

        return flag;
    }

}
