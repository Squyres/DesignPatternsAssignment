
public abstract class CreditCard {

	private String cardNumber;
	private String cardExpiration;
	private String cardHolder;

	public CreditCard(String cardNumber, String cardExpiration, String cardHolder) {
		this.cardNumber = cardNumber;
		this.cardExpiration = cardExpiration;
		this.cardHolder = cardHolder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpiration() {
		return cardExpiration;
	}

	public void setCardExpiration(String cardExpiration) {
		this.cardExpiration = cardExpiration;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	@Override
	public String toString() {
		return "CreditCard [cardNumber=" + cardNumber + ", cardExpiration=" + cardExpiration + ", cardHolder="
				+ cardHolder + "]";
	}

}
