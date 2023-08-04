package www.dream.bb.model;

import java.util.ArrayList;
import java.util.List;

import www.dream.framework.display.FieldDispaly;
import www.dream.framework.display.VODisplayer;
import www.dream.framework.display.ViewType;

public class BillVO {
	// L형 캡션줘 : 내용, 수입, 지출 //LRCU순서
	// R : 내용, 지출
	// C : 내용, 지출, 수입
	// U : 수입

	@FieldDispaly(order = { 0, 0, 0, -1 }, caption = "내용")
	private String title; // 내용
	@FieldDispaly(order = { 2, 1, 1, -1 }, caption = "지출")
	private int outAmount; // 지출
	@FieldDispaly(order = { 1, -1, 2, 0 }, caption = "수입")
	private int inAmount; // 수입
	

	
	public static List<BillVO> getData(){
		List<BillVO> ret = new ArrayList<>();
		ret.add(new BillVO("adsf",3,5));
		ret.add(new BillVO("fdas",-3,-5));
		return ret;
	}
	
	public BillVO() {
		super();
	}
	
	public BillVO(String title, int outAmount, int inAmount) {
		super();
		this.title = title;
		this.outAmount = outAmount;
		this.inAmount = inAmount;
	}
	public static void main(String[] args) {
		List<String> list = VODisplayer.getCaptionList(BillVO.class, ViewType.List);
		for (String s : list) {
			System.out.println(s);
		}
		list = VODisplayer.getCaptionList(BillVO.class, ViewType.Update);
		for (String s : list) {
			System.out.println(s);
		}

	}

}
