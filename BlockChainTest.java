public class BlockChainTest {

    public static void main(String[] args){

        //first block
        Block firstBlock = new Block("0","This is my first block");
        firstBlock.mineBlock(5);
        System.out.println("Hash of first block: "+firstBlock.hash);

        //second block
        Block secondBlock = new Block(firstBlock.hash,"This is my second block");
        secondBlock.mineBlock(5);
        System.out.println("Hash of second block: "+secondBlock.hash);

        //third block
        Block thirdBlock = new Block(secondBlock.hash,"This is my third block");
        thirdBlock.mineBlock(5);
        System.out.println("Hash of third block: "+thirdBlock.hash);

        //fourth block
        Block fourthBlock = new Block(thirdBlock.hash, "This is my fourth block");
        fourthBlock.mineBlock(5);
        System.out.println("Hash of first block: "+fourthBlock.hash);
    }
}
