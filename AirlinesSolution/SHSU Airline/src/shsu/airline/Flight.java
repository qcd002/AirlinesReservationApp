package shsu.airline;
public class Flight{
		private int fnum;
		private int price;
		private String cab;
		private String meal;
		private String sta;
		private String acr;

	public Flight(){
		cab="";
		meal = "";
		sta = "";

	}

	public Flight(int sFnum, int sPrice, String sCab,
						String sMeal, String sSta, String aAcr){
			fnum = sFnum;
			price = sPrice;
			cab = sCab;
			meal = sMeal;
			sta = sSta;
			acr = aAcr;
	}

	public int getFnum(){
		return fnum;
	}
	public int getPrice(){
		return price;
	}

	public String getCab(){
		return cab;
	}
	public String getMeal(){
		return meal;
	}

	public String getSta(){
		return sta;
	}
		public String getArc(){
		return acr;
	}


















}