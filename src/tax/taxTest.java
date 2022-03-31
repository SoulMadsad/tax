package tax;

import static org.junit.Assert.*;

import org.junit.Test;

public class taxTest {

	@Test
	public void test() {
		int[] expect = { 970, 3760, 7400, 14740, 21100, 522300 };
		int[] joinExpect = { 3820, 14880, 27560, 46940, 60200, 1044600 };
		int[] income = { 190000, 240000, 280000, 340000, 380000, 3500000 };
		calculator taxTest = new calculator();
		System.out.println("Starting test husband Tax Pay" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		for (int i = 0; i < 6; i++) {
			assertEquals(expect[i], taxTest.husbandTaxPay(income[i]));

		}
		System.out.println("Ending test husband Tax Pay" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		System.out.println("Starting test wife Tax Pay" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		for (int i = 0; i < 6; i++) {

			assertEquals(expect[i], taxTest.wifeTaxPay(income[i]));

		}
		System.out.println("Ending test wife Tax Pay" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		System.out.println("Starting test join Tax Pay" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		for (int i = 0; i < 6; i++) {

			assertEquals(joinExpect[i], taxTest.joinTaxPay(income[i], income[i]));

		}
		System.out.println("Ending test join Tax Pay" + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

}
