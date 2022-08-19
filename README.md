# JavaBlockChain

This is a project about block chain, which is based on java language and uses Gson jar to implement display data of each block.

Block class is the basic block object, it can be initiated with hash+previous block hash + data or previous block hash + data. And the mineBlock method is used to calculate the hash which satisfies the difficulty required for the current block.

BlockChainListTest using Gson jar to list all information of each block. isChainValid method can use to decide whether the block satisfies the requirements of the block.