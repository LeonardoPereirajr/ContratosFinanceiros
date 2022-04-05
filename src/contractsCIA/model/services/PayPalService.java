package contractsCIA.model.services;

public class PayPalService implements OnlinePaymentService {

	private static final double PAYMENT_FEE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;

	@Override
	public Double PaymentFee(Double amount) {
		return amount * PAYMENT_FEE;
	}

	@Override
	public Double Interest(Double amount, Integer months) {
		return amount * months * MONTHLY_INTEREST;
	}

}
