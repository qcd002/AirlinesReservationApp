/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shsu.airline;

/**
 *
 * @author QUAN DO
 */

public class Customer{
	private int dl_num;
	private String name;
	private String stre;
	private String email;
	private int phone;
        private int zip;

	public Customer (){
		name = stre = email = "unknown";
	}

	public Customer(int startDl, String startName, String startEmail,int startPhone,
		  String startStre,int sZip){
			dl_num = startDl;
			name = startName;
			stre = startStre;
			email = startEmail;
			phone = startPhone;
                        zip = sZip;
		}

	public int getDL(){
		return dl_num;}
	public String getName(){
      	return name;}
	public String getStre(){
		return stre;}
	public String getEmail(){
		return email;
	}
	public int getPhone(){
		return phone;
	}

        public int getZip(){
            return zip;
        }



















/*		public void input(Scanner in) {
	    if ( in.hasNext() ) {
		    dl_num = in.nextInt();
			name = in.nextLine();
			addr = in.nextLine();
			email = in.nextLine();
			phone = in.nextInt();
		} // end if
	}
	public static Customer read(Scanner in) {
	    Customer result = new Customer();
	    result.input(in);
	    return result;
    }
*/



}