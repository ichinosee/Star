package la.bean;

import java.io.Serializable;

public class StarBean  implements Serializable{
	private String star;



	public StarBean(String star) {
		this.star = star;
	}

	public StarBean() {

		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}



}
