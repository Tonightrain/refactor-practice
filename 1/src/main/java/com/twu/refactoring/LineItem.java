package com.twu.refactoring;

public class LineItem {
	private String desc;
	private double p;
	private int qty;

	public LineItem(String desc, double p, int qty) {
		super();
		this.desc = desc;
		this.p = p;
		this.qty = qty;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

    double totalAmount() {
        return p * qty;
    }

	public String toString(){
		return desc+"\t"+p+"\t"+qty+"\t"+totalAmount()+"\n";
	}

}