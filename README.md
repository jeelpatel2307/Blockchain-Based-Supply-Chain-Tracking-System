# Blockchain-Based Supply Chain Tracking System

## Overview

This project implements a Blockchain-Based Supply Chain Tracking System in Java. The system uses blockchain technology to ensure transparency, security, and immutability of supply chain data. Each block in the blockchain contains information about a supply chain transaction, making it easy to track and verify the history of goods and materials.

## Features

- **Blockchain Implementation:** Basic blockchain implementation using Java, with support for block creation, hashing, and mining.
- **Supply Chain Transactions:** Simulates supply chain transactions and adds them to the blockchain.
- **Data Integrity:** Ensures the integrity and immutability of supply chain data through cryptographic hashing.
- **Blockchain Validation:** Provides methods to validate the blockchain and ensure all blocks are correctly linked and mined.

## Getting Started

1. **Clone the Repository:**
    
    ```bash
    git clone <https://github.com/yourusername/blockchain-supply-chain-tracking.git>
    
    ```
    
2. **Compile and Run:**
    
    ```bash
    cd blockchain-supply-chain-tracking
    javac SupplyChainTrackingSystem.java
    java SupplyChainTrackingSystem
    
    ```
    
3. **Follow On-Screen Instructions:**
    
    The program will simulate the creation of blocks with supply chain transaction data, mine the blocks, and then validate the blockchain.
    

## Usage

1. **Simulate Transactions:**
    
    The system adds sample supply chain transactions to the blockchain. Each transaction is represented as a block with data, a timestamp, and links to the previous block.
    
2. **Validate Blockchain:**
    
    The system validates the blockchain by checking the integrity of each block's hash, the linkage between blocks, and ensuring that all blocks have been correctly mined according to the set difficulty.
    

## Sample Output

When you run the program, you will see output similar to the following:

```
Trying to Mine block 1...
Block Mined!!! : <hash_of_block_1>

Trying to Mine block 2...
Block Mined!!! : <hash_of_block_2>

Trying to Mine block 3...
Block Mined!!! : <hash_of_block_3>

Blockchain is Valid: true

Block:
Hash: <hash_of_block_1>
Previous Hash: 0
Data: Transaction 1 Data
Timestamp: <timestamp_of_block_1>

Block:
Hash: <hash_of_block_2>
Previous Hash: <hash_of_block_1>
Data: Transaction 2 Data
Timestamp: <timestamp_of_block_2>

Block:
Hash: <hash_of_block_3>
Previous Hash: <hash_of_block_2>
Data: Transaction 3 Data
Timestamp: <timestamp_of_block_3>

```

## Contributors

- Jeel patel
