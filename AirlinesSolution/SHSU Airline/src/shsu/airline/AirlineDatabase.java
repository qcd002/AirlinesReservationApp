package shsu.airline;

import java.sql.*;
import java.util.ArrayList;

public class AirlineDatabase {

    private Connection conn = null;
    private PreparedStatement insertCustomer = null;
    private PreparedStatement findCustomer = null;
    private PreparedStatement insertFlight = null;
    private PreparedStatement findAcraft = null;
    private PreparedStatement findFlight = null;
    private PreparedStatement insertAport = null;
    private PreparedStatement findDepart = null;
    private PreparedStatement findArrive = null;
    private PreparedStatement insertDepart = null;
    private PreparedStatement insertArrive = null;
    private PreparedStatement findConf = null;
    private static final String url = "jdbc:sqlite:C:/Airline Database/Airlines.s3db";
    private ResultSet rs = null;
    private ResultSet rs1 = null;
    private ArrayList<Customer> listC = null;
    private ArrayList<Flight> listF = null;
    private ArrayList<Depart> listD = null;
    private ArrayList<Arrive> listA = null;
    private String listCus ="";
    private String searchCus="";





    public void AirlineDatabase(String connectionString) throws ClassNotFoundException {

		//load();
	}


	public void load() throws ClassNotFoundException {

		try{
			Class.forName("org.sqlite.JDBC");
			   conn = DriverManager.getConnection(url);
               System.out.println ("Database connection established");
		}
		catch(SQLException e)
	    {

	      System.err.println(e.getMessage());
	    }

	}

        //adding Customer
	public void addCustomer(Customer c) throws Exception
	{
		try{

		if (insertCustomer == null){
			insertCustomer = conn.prepareStatement("INSERT INTO Customer(dl, name,email,phone,street,zip ) "+
		                                       "VALUES (?, ?, ?, ?, ?,?)");

		    insertCustomer.setInt(1, c.getDL());
		    insertCustomer.setString(2, c.getName());
                    insertCustomer.setString(3, c.getEmail());
                    insertCustomer.setInt(4, c.getPhone());
		    insertCustomer.setString(5, c.getStre());
		    insertCustomer.setInt(6, c.getZip());
		    
		    insertCustomer.executeUpdate();



		    System.out.println("New customer is added!!");
		}
		}
		catch (Exception e){

			throw e;
		}
                save();

	}

// search customer
	public void searchCustomer(int dl) throws Exception{
         listC = new ArrayList<Customer>();
            int dla,ph,zi;
            String na, em,str;
            try{
                
                if(findCustomer == null){
                        findCustomer = conn.prepareStatement("SELECT * FROM Customer WHERE dl = ?");
                        findCustomer.setInt(1, dl);
                        rs = findCustomer.executeQuery();
                        
                        while(rs.next()){
                            dla = rs.getInt(1);
                            na = rs.getString(2);
                            em = rs.getString(3);
                            ph = rs.getInt(4);
                            str = rs.getString(5);
                            zi = rs.getInt(6);
                            
                            Customer ca = new Customer(dl,na,em,ph,str,zi);
       
                            listC.add(ca);

                       
                                      }
                               for (Customer c : listC){
                               searchCus += ("FLIGHT#: "+c.getDL()+"\tNAME: "+c.getName()+
                                        "\tEMAIL: "+c.getEmail()+"\tPHONE: "+c.getPhone()+
                                        "\tSTREET: "+c.getStre()+"\tZIP: "+c.getZip()+"\n");
                              }
                               listC.clear();
                                                          
                       
                        rs.close();
                
                }         
	
            }
		catch (Exception e)
		{
			throw e;
		}
                save();


        }
        
        //listing Customers
        
        public void listCustomer() throws Exception {
             listC = new ArrayList<Customer>();
            int dl,ph,zi;
            String na, em,str;
            try{
                
                if(findCustomer == null){
                        findCustomer = conn.prepareStatement("SELECT * FROM Customer");
                        rs = findCustomer.executeQuery();
                        
                        while(rs.next()){
                            dl = rs.getInt(1);
                            na = rs.getString(2);
                            em = rs.getString(3);
                            ph = rs.getInt(4);
                            str = rs.getString(5);
                            zi = rs.getInt(6);
                            
                            Customer ca = new Customer(dl,na,em,ph,str,zi);
       
                            listC.add(ca);

                       
                                      }
                               for (Customer c : listC){
                               listCus += ("\tFLIGHT#: "+c.getDL()+"\tNAME: "+c.getName()+
                                        "\tEMAIL: "+c.getEmail()+"\tPHONE: "+c.getPhone()+
                                        "\tSTREET: "+c.getStre()+"\tZIP: "+c.getZip()+"\n");
                              }
                               listC.clear();
                                                          
                       
                        rs.close();
                
                }
            
            }catch(Exception e){
                throw e;
            }
            save();
        
        }
        
        public String getListCus(){
          
                return listCus;
        }
        public String getSearchCus(){
                return searchCus;
        }
        
        
        

	//adding Flight
	public void addFlight(Flight f, Depart d, Arrive a) throws Exception{
		try{
			if(insertFlight == null){
				insertFlight =
					conn.prepareStatement("INSERT INTO Flight(fnum, price, cabin, meal, status, acraft) " +
                                                                                      "VALUES (?, ?, ?, ?, ?,?)");

				insertFlight.setInt(1, f.getFnum());
				insertFlight.setInt(2, f.getPrice());
				insertFlight.setString(3, f.getCab());
				insertFlight.setString(4, f.getMeal());
				insertFlight.setString(5, f.getSta());
				insertFlight.setString(6, f.getArc());
				insertFlight.executeUpdate();
				System.out.println("New flight is added!");
			}

			if(insertDepart == null){
				insertDepart =
					conn.prepareStatement("INSERT INTO Depart(fnum, apcode, ddate, dtime ) "+
											"VALUES (?,?,?,?)");
					insertDepart.setInt(1, f.getFnum());
					insertDepart.setString(2, d.getAp());
					insertDepart.setString(3, d.getDdate());
					insertDepart.setString(4, d.getDtime());
					insertDepart.executeUpdate();

					System.out.println("New Deaprt is added!");
			}
			if(insertArrive == null){
				insertArrive =
					conn.prepareStatement("INSERT INTO Arrive(fnum, apcode, adate, atime) "+
											"VALUES (?,?,?,?)");
					insertArrive.setInt(1, f.getFnum());
					insertArrive.setString(2, a.getAp());
					insertArrive.setString(3, a.getAdate());
					insertArrive.setString(4, a.getAtime());
					insertArrive.executeUpdate();

					System.out.println("New Deaprt is added!");
			}

		}
		catch(Exception e){
			throw e;
		}
                   save();
	}
        
        //check flight status
        /* check for configuration number
         * if conf# does not match, return -1
         * if delayed, return 1
         * if onging, return 0
         */
        
        public int checkStatus(int co) throws Exception {
        
            int result = -1;
            String query = ("select status from flight,reservationflig ")+
                            ("where flight.fnum = reservationflig.fnum and conf = ?");
            String query1 = ("select conf from reservationflig ")+
                               ("where conf = ?");

        try{

            if(findConf == null){
 
                findConf = conn.prepareStatement(query1); 
                findConf.setInt(1, co);
                rs1 = findConf.executeQuery();
                //System.out.println(rs1.getInt(1));
           
                
                
                if(rs1.next()){          
                    if( rs1.getInt(1) == co){                        
                        if(findFlight == null){                  
                        findFlight = conn.prepareStatement(query);
                        findFlight.setInt(1, co);
                        rs = findFlight.executeQuery();
                     
                        while(rs.next()){
                            
                            if((rs.getString(1)).equals("delayed")){                  
                                rs.close();
                                rs1.close();
                                result = 1;
                            
                                
                                }
                            else {
                                rs.close();
                                rs1.close();
                                 result = 0;
                               
                                } 
                                            }
                        }
                       
                    }
         
                    
                        
                } 
        }
            
            }catch (Exception e){
            throw e;
             } 
        
       
            save();
            System.out.println("save");
            return result;
            
            
            }
        
        //check Flight Detail method
        
        public void ListFlightDetail(int c) throws Exception{
         listF = new ArrayList<Flight>();
        listD = new ArrayList<Depart>();
        listA = new ArrayList<Arrive>();           
            String query = ("SELECT f.fnum,price,cabin,meal,status,acraft,")+
                            ("ddate,dtime,d.apcode,adate,atime,a.apcode ")+
                            ("FROM flight f, reservationflig r, arrive a, depart d ")+
                            ("WHERE f.fnum = r.fnum and f.fnum = a.fnum and ")+
                            ("f.fnum = d.fnum and r.fnum = a.fnum and ")+
                            ("r.fnum = d.fnum and a.fnum = d.fnum and ")+
                            ("r.conf = ?");
            
            String query1 = ("select conf from reservationflig ")+
                               ("where conf = ?"); 
            int f = 0;
            int p = 0;
            String ca,m,s,a,ac,dd,dt,da,ad,at,aa = "";
            
            
            try{
            if(findConf == null){
 
                findConf = conn.prepareStatement(query1); 
                findConf.setInt(1, c);
                rs1 = findConf.executeQuery();
                
                if(rs1.next()){          
                    if( rs1.getInt(1) == c){                        
                        if(findFlight == null){                  
                        findFlight = conn.prepareStatement(query);
                        findFlight.setInt(1, c);
                        rs = findFlight.executeQuery();
                        
                        while(rs.next()){
                            f = rs.getInt(1);
                            p = rs.getInt(2);
                            ca = rs.getString(3);
                            m = rs.getString(4);
                            s = rs.getString(5);
                            ac = rs.getString(6);
                            dd = rs.getString(7);
                            dt = rs.getString(8);
                            da = rs.getString(9);
                            ad = rs.getString(10);        
                            at = rs.getString(11);
                            aa = rs.getString(12);
                            
                            Flight fl = new Flight(f,p,ca,m,s,ac);                          
                            listF.add(fl);                                                    
                            Depart de = new Depart(dd,dt,da);                         
                            listD.add(de);
                            Arrive arr = new Arrive(ad,at,aa);                          
                            listA.add(arr);
                            
                            
                        }
                        rs.close();
                        
                        
                        }
                    }
                }
            }
            }catch(Exception e){}
            save();
            
        }
        
        
        
       
        //getFlight
        public Flight getFlight(){
            
            Flight fA = new Flight();

            for (Flight curr : listF){
                fA = curr;
                System.out.println(fA.getFnum());
            }
            listF.clear();
            return fA;               
        }
        
        
        //remove Flight
        public void removeFLight(int fnum) throws Exception{
            String q1 = "DELETE FROM Flight WHERE fnum = ?";
            String q2 = "DELETE FROM Depart WHERE fnum = ?";
            String q3 = "DELETE FROM Arrive WHERE fnum = ?";
            try{
                   if(findFlight == null){
                       findFlight = conn.prepareStatement(q1);
                       findFlight.setInt(1,fnum);
                       findFlight.executeUpdate();
                  
                   }
                    if(findDepart == null){
                       findDepart = conn.prepareStatement(q2);
                       findDepart.setInt(1,fnum);
                       findDepart.executeUpdate();
                     
                   }
                   if(findArrive == null){
                       findArrive = conn.prepareStatement(q3);
                       findArrive.setInt(1,fnum);
                       findArrive.executeUpdate();
                      
                   }
        }catch(Exception e){
            throw e;}
        
        
        save();
        }
        
        
        
        
        //getDepart
        public Depart getDepart(){
 
            
            Depart dA = new Depart();
            for (Depart curr : listD){
                dA = curr;
            }
            listD.clear();
            return dA;               
        }        
        
        //getArrive
        public Arrive getArrive(){

            Arrive aA = new Arrive();
            for (Arrive curr : listA){
                aA = curr;
            }
            listA.clear();
            return aA;               
        }    
        

        
        //save method
        	private void save() throws Exception{
		try{
                        if(findCustomer != null){
                            
                            findCustomer.close();
                        }
                        
                        if(findDepart != null){
                            findDepart.close();
                        }
                        if(findArrive != null){
                            findArrive.close();
                        }
                        if(findConf != null){
                            findConf.close();
                        }
                        if(findFlight != null){
                            findFlight.close();
                        }

			if(insertFlight != null)
			{
				insertFlight.close();
			}
			if(insertDepart != null)
			{
				insertDepart.close();
			}
			if(insertArrive != null)
			{
				insertArrive.close();
			}
                        if(findCustomer != null){
                                findCustomer.close();
                        }
			if(conn != null){
				conn.close();
			}
		} catch(Exception e){
                    throw e;

		}
	}

                







}

// PRINT searchCustomer: is not finished (display the list)
