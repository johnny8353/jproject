package callCCGWebService;

import java.io.Serializable;


public class GetDataWebServiceBO implements Serializable
{
	private long contractId ;
	
	private long userId;

	public long getContractId() {
		return contractId;
	}

	public void setContractId(long contractId) {
		this.contractId = contractId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}