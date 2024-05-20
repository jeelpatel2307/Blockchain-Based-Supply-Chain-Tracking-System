import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Class to represent a block in the blockchain
class Block {
    public String hash;
    public String previousHash;
    private String data; // Supply chain transaction data
    private long timeStamp;
    private int nonce;

    // Block Constructor
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); // Calculate the hash
    }

    // Calculate the hash based on block's contents
    public String calculateHash() {
        String input = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data;
        return applySHA256(input);
    }

    // Apply SHA-256 hashing algorithm
    public static String applySHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Mine the block with a certain difficulty
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); // Create a string with difficulty * "0"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}

// Class to represent the blockchain
class Blockchain {
    public static List<Block> blockchain = new ArrayList<>();
    public static int difficulty = 4;

    // Add a new block to the blockchain
    public static void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
    }

    // Check if the blockchain is valid
    public static boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        // Loop through blockchain to check hashes
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            // Compare registered hash and calculated hash
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }

            // Compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }

            // Check if hash is solved
            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }
}

// Class to represent the supply chain tracking system
public class SupplyChainTrackingSystem {
    public static void main(String[] args) {
        // Adding blocks to the blockchain
        System.out.println("Trying to Mine block 1... ");
        Blockchain.addBlock(new Block("Transaction 1 Data", "0"));

        System.out.println("Trying to Mine block 2... ");
        Blockchain.addBlock(new Block("Transaction 2 Data", Blockchain.blockchain.get(Blockchain.blockchain.size() - 1).hash));

        System.out.println("Trying to Mine block 3... ");
        Blockchain.addBlock(new Block("Transaction 3 Data", Blockchain.blockchain.get(Blockchain.blockchain.size() - 1).hash));

        // Check if the blockchain is valid
        System.out.println("\nBlockchain is Valid: " + Blockchain.isChainValid());

        // Print the blockchain
        for (Block block : Blockchain.blockchain) {
            System.out.println("\nBlock:");
            System.out.println("Hash: " + block.hash);
            System.out.println("Previous Hash: " + block.previousHash);
            System.out.println("Data: " + block.data);
            System.out.println("Timestamp: " + block.timeStamp);
        }
    }
}
