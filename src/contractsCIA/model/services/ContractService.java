package contractsCIA.model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	// Inversão de controle -Não deixar a classe responsavel pelo controle de qual
	// classe vai
	// instanciar
	private OnlinePaymentService onlinePaymentService;

	// Ingeção de dependencia será feita pelo Program
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		for (int i = 1; i <= months; i++) {
			Date date = addMonth(contract.getDate(), i);
			double updatedQuota = basicQuota + onlinePaymentService.Interest(basicQuota, i);
			Date dueDate = addMonth(contract.getDate(), i);
			double fullQuota = updatedQuota + onlinePaymentService.PaymentFee(updatedQuota);
			contract.getInstallments().add(new Installment(dueDate, fullQuota));
		}
	}

	private Date addMonth(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();

	}
}
