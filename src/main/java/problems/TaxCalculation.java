package problems;

import java.util.LinkedList;
import java.util.List;

public class TaxCalculation {

	public static void main(String[] args) {
		Integer sal = 3000000;
		boolean isNewRegime = true;
		TaxRegime regime = new TaxRegime(sal, isNewRegime);
		System.out.println(regime.getTotalTax());
	}

}

class TaxRange {
	int lower;
	int higher;
	double percentage;

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	TaxRange(int l, int h, double d) {
		this.higher = h;
		this.lower = l;
		this.percentage = d;
	}

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getHigher() {
		return higher;
	}

	public void setHigher(int higher) {
		this.higher = higher;
	}

	@Override
	public String toString() {
		return "\nTaxRange [lower=" + lower + ", higher=" + higher + ", percentage=" + percentage + "]";
	}

}

class TaxRegime {
	private List<TaxRange> taxList = new LinkedList<TaxRange>();
	private Integer salary;

	TaxRegime(Integer sal, boolean isNewRegime) {
		this.salary = sal;
		double[] percent = getPercent(isNewRegime);
		taxList.add(new TaxRange(0, 250000, percent[0]));
		taxList.add(new TaxRange(250001, 500000, percent[1]));
		taxList.add(new TaxRange(500001, 750000, percent[2]));
		taxList.add(new TaxRange(750001, 1000000, percent[3]));
		taxList.add(new TaxRange(1000001, 1250000, percent[4]));
		taxList.add(new TaxRange(1250001, 1500000, percent[5]));
		taxList.add(new TaxRange(1500000, -1, percent[6]));
	}

	private double[] getPercent(boolean isNewRegime) {
		if (isNewRegime) {
			double[] percent = { 0, 5, 10, 15, 20, 25, 30 };
			return percent;
		} else {
			double[] percent = { 0, 5, 20, 20, 30, 30, 30 };
			return percent;
		}

	}

	public double getTotalTax() {
		int offset = 0;
		return compute(offset);
	}

	private double compute(int offset) {
		int l = taxList.get(offset).lower;
		int h = taxList.get(offset).higher;
		double t = taxList.get(offset).percentage * 0.01;
		if (h == -1) {
			return t * (salary - l);
		} else if (salary > l && salary < h) {
			return t * (salary - l) + compute(offset + 1);
		} else {
			return t * (h - l) + compute(offset + 1);
		}
	}

}
