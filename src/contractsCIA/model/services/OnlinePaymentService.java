package contractsCIA.model.services;

public interface OnlinePaymentService {

	Double PaymentFee(Double amount);

	Double Interest(Double amount, Integer months);

}
