/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shsu.airline;

/**
 *
 * @author QUAN DO
 */
public class Depart {
    private String ap ;
	private String ddate ;
	private String dtime;
        
        public Depart(){
            ap = "";
            ddate = "";
            dtime = "";
        }

	public Depart(String sAp, String sDdate, String sDtime){
		ap = sAp;
		ddate = sDdate;
		dtime = sDtime;
	}

	public String getAp(){
		return ap;
	}
	public String getDdate(){
		return ddate;
	}
	public String getDtime(){
		return dtime;
	}
}
