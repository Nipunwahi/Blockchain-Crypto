# Blockchain-Crypto
# Team
- Nipun Wahi
- Ameetesh Sharma
- Mir Ameen Mohideen

# Installation Instructions
For Linux<br>
javac -cp ".:gson-2.6.2.jar:bcprov-jdk15to18-165.jar" Gui.java <br>
<br>
For Windows <br>
javac -cp ".;gson-2.6.2.jar;bcprov-jdk15to18-165.jar" Gui.java <br>


## How does the project Work
### StringUtil
We have defined StringUtil Class for utility functions related to strings , and to make signatures for every Transaction. <br>
We are using ECDSA signatures for this which is provided by BouncyCastleProvider which is in bcprov-jdk15to18-165.jar. <br>
It alse verifies public key and private key pairs of ecdsa signatures and also signs them. <br>
Other simple helper functions are also there. <br>
### Block
Block Contains two Important functions: <br>
- CalcHash:
>> It applies SHA256 defines in StringUtil class to the data
- MineBlock:
>> It mines the block according to some difficulty value. Basically it keeps changing the nonce until it has some number of zeroes as
a prefix to the hash. The number of zeroes is the difficulty value.
### Transaction
Transaction class holds all the details related to a Transaction in the Blockchain.
Basically the sender's and receiver public key, signature, data etc.

### Wallet
Wallet class is basically what the user is. It contains public and private key of the user.
It has an Important method called sendData
This method returns a new Transaction Taking in public key of sender and receiver and data as input.

### Blockchain
This class is the most Important class and most of the work is done here. <br>
The constructor calls the method createGenesisBlock which when initializing creates the genesis block <br>
It has an attribute called undoneTransaction which is an arraylist of Transactions and holds the new
Transactions which arent in any block yet <br>
After a certain number of new Transactions a new block is created , the blockchain holds all the blocks in
an arraylist. <br>

### VerifyTransactions:
This method verifies all the Transactions in the undoneTransaction arraylist using ECDSA signature
verification. <br>
### CreateBlock :
This method creates a new block , puts all the undoneTransaction in it and mines the new block. It
creates new block only after Verifying Transactions.<br>
After that it puts the new block in the chain arraylist and empties undoneTransaction arraylist. <br>
### ViewUser:
This method shows all the Transactions of a user sent or received. Basically it loops through all the
blocks and all the Transactions in them
and prints those whose publickey matches the user.


### Functions and their classes :
- MineBlock: Block Class
- VerifyTransactions : Blockchain Class
- CreateBlock : Blockchain Class.
- ViewUser : Blockchain Class
