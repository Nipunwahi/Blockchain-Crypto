import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;

public class Wallet {
	public PublicKey publickey;
	public PrivateKey privatekey;
	public String name;
	public Wallet(String name) {
		generateKeyPair();
		this.name=name;
	}
	
	public void generateKeyPair() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			// Initialize the key generator and generate a KeyPair
			keyGen.initialize(ecSpec, random); //256 
	        KeyPair keyPair = keyGen.generateKeyPair();
	        // Set the public and private keys from the keyPair
	        privatekey = keyPair.getPrivate();
	        publickey = keyPair.getPublic();
	        
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Transaction sendData(PublicKey receiver,String senderName,String receiverName,String data) {
		Transaction newTransaction = new Transaction(publickey,receiver,senderName,receiverName,data);
		newTransaction.generateSignature(privatekey);
		return newTransaction;
	}
}
