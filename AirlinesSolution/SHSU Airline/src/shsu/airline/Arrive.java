/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shsu.airline;

/**
 *
 * @author QUAN DO
 */
public class Arrive {
    private String ap ;
	private String adate ;
	private String atime;
        
            public Arrive(){
            ap = "";
            adate = "";
            atime = "";
        }

	public Arrive(String sAp, String sAdate, String sAtime){
		ap = sAp;
		adate = sAdate;
		atime = sAtime;
	}

	public String getAp(){
		return ap;
	}
	public String getAdate(){
		return adate;
	}
	public String getAtime(){
		return atime;
	}
    
}
