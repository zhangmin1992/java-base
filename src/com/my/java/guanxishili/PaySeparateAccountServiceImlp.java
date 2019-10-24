package com.my.java.guanxishili;

public abstract class PaySeparateAccountServiceImlp implements IPaySeparateAccountService {

	public boolean check() {
		System.out.println("检查是否可以对账");
		return false;
	}

}
