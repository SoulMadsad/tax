package tax;

public class calculator {
	int allowance = 132000;
	int totalAllowance = allowance * 2;
	double mpfRate = 0.05;
	double[] taxRate = { 0.02, 0.06, 0.1, 0.14, 0.17 };
	double[] taxRateLimit = { 50000, 100000, 150000, 200000 };
	double[] taxPay = { 1000, 4000, 9000, 16000 };
	double standardRate = 0.15;
	int mpfLimit = 18000;
	int noMpf = 85200;

	public int husbandMpfC(int husbandIncome) {
		double husbandMpf = husbandIncome * mpfRate;
		if (husbandMpf >= mpfLimit) {
			husbandMpf = mpfLimit;
		} else if (husbandIncome < noMpf) {
			husbandMpf = 0;
		}
		return (int) husbandMpf;
	}

	public int wifeMpfC(int wifeIncome) {
		double wifeMpf = wifeIncome * mpfRate;
		if (wifeMpf > mpfLimit) {
			wifeMpf = mpfLimit;
		} else if (wifeIncome < noMpf) {
			wifeMpf = 0;
		}
		return (int) wifeMpf;
	}

	public int husbandTaxPay(int husbandIncome) {

		double husbandMpf = husbandMpfC(husbandIncome);

		;
		double husbandStand = (husbandIncome - husbandMpf) * standardRate;
		double husNetCharIncome = husbandIncome - husbandMpf - allowance;
		double husbandTax = 0;

		if (husNetCharIncome < taxRateLimit[0]) {
			husbandTax = husNetCharIncome * taxRate[0];
		} else if (husNetCharIncome <= taxRateLimit[1]) {
			husbandTax = (husNetCharIncome - taxRateLimit[0]) * taxRate[1] + taxPay[0];
		} else if (husNetCharIncome <= taxRateLimit[2]) {
			husbandTax = (husNetCharIncome - taxRateLimit[1]) * taxRate[2] + taxPay[1];
		} else if (husNetCharIncome <= taxRateLimit[3]) {
			husbandTax = (husNetCharIncome - taxRateLimit[2]) * taxRate[3] + taxPay[2];
		} else if (husNetCharIncome > taxRateLimit[3]) {
			husbandTax = (husNetCharIncome - taxRateLimit[3]) * taxRate[4] + taxPay[3];
		}
		;
		if (husbandStand < husbandTax) {
			husbandTax = husbandStand;
		} else if (husbandTax <= 0) {
			husbandTax = 0;
		}
		return (int) husbandTax;
	}

	public int wifeTaxPay(int wifeIncome) {
		double wifeTax = 0;
		double wifeMpf = wifeMpfC(wifeIncome);

		double wifeStand = (wifeIncome - wifeMpf) * standardRate;
		double wifeNetCharIncome = wifeIncome - wifeMpf - allowance;
		if (wifeNetCharIncome < taxRateLimit[0]) {
			wifeTax = wifeNetCharIncome * taxRate[0];
		} else if (wifeNetCharIncome <= taxRateLimit[1]) {
			wifeTax = (wifeNetCharIncome - taxRateLimit[0]) * taxRate[1] + taxPay[0];
		} else if (wifeNetCharIncome <= taxRateLimit[2]) {
			wifeTax = (wifeNetCharIncome - taxRateLimit[1]) * taxRate[2] + taxPay[1];
		} else if (wifeNetCharIncome <= taxRateLimit[3]) {
			wifeTax = (wifeNetCharIncome - taxRateLimit[2]) * taxRate[3] + taxPay[2];
		} else if (wifeNetCharIncome > taxRateLimit[3]) {
			wifeTax = (wifeNetCharIncome - taxRateLimit[3]) * taxRate[4] + taxPay[3];
		}
		;
		if (wifeStand < wifeTax) {
			wifeTax = wifeStand;
		} else if (wifeTax <= 0) {
			wifeTax = 0;
		}
		return (int) wifeTax;
	}

	public int joinTaxPay(int wifeIncome, int husbandIncome) {
		double totalTax = 0;
		double totalIncome = husbandIncome + wifeIncome;
		double husbandMpf = husbandMpfC(husbandIncome);
		double wifeMpf = wifeMpfC(wifeIncome);
		double totalMpf = husbandMpf + wifeMpf;
		double totalStand = (totalIncome - totalMpf) * standardRate;

		double totalNetCharIncome = totalIncome - totalMpf - totalAllowance;
		if (totalNetCharIncome < taxRateLimit[0]) {
			totalTax = totalNetCharIncome * taxRate[0];
		} else if (totalNetCharIncome <= taxRateLimit[1]) {
			totalTax = (totalNetCharIncome - taxRateLimit[0]) * taxRate[1] + taxPay[0];
		} else if (totalNetCharIncome <= taxRateLimit[2]) {
			totalTax = (totalNetCharIncome - taxRateLimit[1]) * taxRate[2] + taxPay[1];
		} else if (totalNetCharIncome <= taxRateLimit[3]) {
			totalTax = (totalNetCharIncome - taxRateLimit[2]) * taxRate[3] + taxPay[2];
		} else if (totalNetCharIncome > taxRateLimit[3]) {
			totalTax = (totalNetCharIncome - taxRateLimit[3]) * taxRate[4] + taxPay[3];
		}
		;
		if (totalStand < totalTax) {
			totalTax = totalStand;
		} else if (totalTax <= 0) {
			totalTax = 0;
		}
		return (int) totalTax;
	}
}
