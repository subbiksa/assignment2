package application;

import java.util.*;
import allExceptions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
* 
*  
* @author  Richa Rawat
* @version 2.0
* @classDescription Displays the relations of any two persons on the Mininet social network  
*                   extending Application class to show JavaFX functionality .
* 					 
* 
*/
            public class Connect{
            public static void connection(String title,String msg ){
			Stage frame = new Stage();
	        frame.initModality(Modality.APPLICATION_MODAL);
	        frame.setTitle(title);
	        frame.setWidth(300);
	        //label set with title value from main
	        Label l1 = new Label(title);
	        Button viewFriends = new Button("View Friends"); //to display two friends
			Button viewParents = new Button("View Parents"); //to display parents of a child
			Button viewCouples = new Button("View Couples"); //to display couples
			Button viewColleagues = new Button("View Colleagues"); //to display colleagues				Button viewClassmates = new Button("View Classmates"); //to display classmates
			Button viewClassmates = new Button("View Classmates");	
			    viewFriends.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						@SuppressWarnings("resource")
						Scanner sc= new Scanner(System.in);
						 System.out.println("Enter name of first person");
						 String name1= sc.nextLine();
						 System.out.println("Enter name of second person");
					     String name2= sc.nextLine();
						
						int person1Age = 0, person2Age = 0;
						try {
							
					    	// 1.connection  to database
					    	  Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
					    	
					    	  System.out.println("Enter name of first person");
						        
					    	    	  // 2.creation of stats
					    	  Statement myst1 = mycon.createStatement(); 
					    	  Statement myst2 = mycon.createStatement();
					    	 
					    	  String query1 = "select age from profile where name= '"+ name1 +"'";
					    	  String query2 = "select age from profile where name= '"+ name2 +"'";
					  
					    	  myst1.executeQuery(query1);
					    	  myst2.executeQuery(query2);
					    	// 3. execution of sql 
					    	  ResultSet myres1 = myst1.executeQuery(query1);
					    	  ResultSet myres2 = myst2.executeQuery(query2);

						    	// 4. Process the resultset  
						          while(myres1.next() && myres2.next()) {
						        	  person1Age = myres1.getInt("age");
						        	  System.out.println(person1Age);
						        	  person2Age = myres2.getInt("age"); 
						        	  System.out.println(person2Age);
					          }
					      }
					      catch(Exception e) {
					    	  System.out.println(e);
					    	  //e.printStackTrace();
					      }
						
						
						if(person1Age<=2||person2Age<=2)
						{
								System.out.println(person2Age);
								try {
									throw new TooYoungException("Too Young to be friends");
								} catch (TooYoungException e) {
									//e.printStackTrace();
								System.out.println(e);
								}
						
						}
						else if(((person1Age <= 16 && person2Age >= 17)||(person1Age >= 17 && person2Age <= 16)))
							{
								try {
									throw new NotToBeFriendsException("Trying to make an adult and a child friend who cannot be friends!!");
								} 
								catch (NotToBeFriendsException e) {
									//e.printStackTrace();
									System.out.println(e);
								}
							}
							else if(person1Age <= 16 && person2Age <= 16)
							{
								if((Math.abs(person1Age-person2Age)>3))
								{
									try {
										throw new NotToBeFriendsException("Age gap between the children is larger than 3 years so they cannot be friends!!");
									} catch (NotToBeFriendsException e) {
										//e.printStackTrace();
										System.out.println(e);
									}
								}
							}
							else
							{ 
								String query3 = "insert into Friends(Name1, Name2)" + "values(?, ?)";
								try {
									Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
									PreparedStatement statement = mycon.prepareStatement(query3);
									statement.setString(1, name1 );
									statement.setString(2, name2 );
									statement.executeUpdate();
									System.out.println("Friends!!");
								} catch (Exception e) {
									e.printStackTrace();
									System.out.println(e);
								}
							}
						}		
				});
				
               viewParents.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						@SuppressWarnings("resource")
						Scanner sc= new Scanner(System.in);
						 System.out.println("Enter name of child");
						 String child= sc.nextLine();
						 System.out.println("Enter name of first person");
						 String father= sc.nextLine();
						 System.out.println("Enter name of second person");
					     String mother= sc.nextLine();
						int c1 = 0, c2 = 0; //to count the number of times the member of a couple comes in the couple table 
						 try {
						    	// 1.connection  to database
						Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
						   
                        /*
                         **
                         * queries to check if the parents entered exist in the couple table
                         */
						String query1 = "Select count(*) from couple where coupleName1= '"+ father + "'"; 
						String query2 = "Select count(*) from couple where coupleName2= '"+ mother + "'";

					 	  // 2.creation of stats
						PreparedStatement statement1 = mycon.prepareStatement(query1);
						statement1.setString(1, father);
						PreparedStatement statement2 = mycon.prepareStatement(query2);
						statement2.setString(2, mother);
			
						

					//3. execution of sql 
					
					ResultSet myres1= statement1.executeQuery(query1);
					
					ResultSet myres2 = statement2.executeQuery(query2);
					
						// 4. Process the resultset  
					    while(myres1.next()) {
					      c1 = myres1.getInt(1);
					  	  System.out.println(c1);
					  	  }
					    
					      while(myres2.next()) {
					  	  c2 = myres2.getInt(1); 
					  	  System.out.println(c2);
					  	  }
					
						 }
						 catch (Exception e) {
								System.out.println(e);
								//e.printStackTrace();
							
							
					}
					    if(c1 < 1||c2 < 1)
						 {
							 try {
									throw new NoParentException(child+" "+ "has either no or one parent!!");
								} catch (NoParentException e) {
									System.out.println(e);
									//e.printStackTrace();
								}
						
					}
						 else
							{
								String query3 = "insert into Parent(childName,fatherName,motherName)"+" values(?,?,?)";
								try {
									Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
									PreparedStatement statement = mycon.prepareStatement(query3);
									statement.setString(1, child );
									statement.setString(2, father );
									statement.setString(3, mother );
									statement.executeUpdate();
									System.out.println("Parents of child" + child + "successfully added!!");
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
					}

					});
               
               viewCouples.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						@SuppressWarnings("resource")
						Scanner sc= new Scanner(System.in);
						 System.out.println("Enter name of first person");
						 String coupleName1= sc.nextLine();
						 System.out.println("Enter name of second person");
					     String coupleName2= sc.nextLine();
						int coupleAge1 = 0, coupleAge2 = 0; 
						 try {
						    	// 1.connection  to database
						    	  Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
						    	
						    	    	  // 2.creation of stats
						    	  Statement myst1 = mycon.createStatement(); 
						    	  Statement myst2 = mycon.createStatement();
						    	 
						    	  String query1 = "select age from profile where name= '"+coupleName1 +"'";
						    	  String query2 = "select age from profile where name= '"+coupleName2 +"'";
						  
						    	  myst1.executeQuery(query1);
						    	  myst2.executeQuery(query2);
						    	// 3. execution of sql 
						    	  ResultSet myres1 = myst1.executeQuery(query1);
						    	  ResultSet myres2 = myst2.executeQuery(query2);

							    	// 4. Process the resultset  
							          while(myres1.next() && myres2.next()) {
							        	  coupleAge1 = myres1.getInt("age");
							        	  System.out.println(coupleAge1);
							        	  coupleAge2 = myres2.getInt("age"); 
							        	  System.out.println(coupleAge2);
						          }
						 }
							          catch(Exception e) {
							        	  System.out.println("Couples Added");
							        	  //e.printStackTrace();
							          }
						 if(coupleAge1 <= 16||coupleAge2 <= 16)
						 {
							 try {
									throw new NotToBeCoupledException("One of the members is not an adult and they cannot be a couple!!");
								} catch (NotToBeCoupledException e) {
									System.out.println(e);
									//e.printStackTrace();
								}
						 }
						
						 else {
							 
							 int c1 =0 , c2 = 0; //to count the number of times the member of a couple comes in the couple table
							 try {
							 
							// 1.connection  to database
					   	  Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
					   	
					   	    	  // 2.creation of stats
					   	  Statement myst1 = mycon.createStatement(); 
					   	  Statement myst2 = mycon.createStatement();
					   	 
					   	String query3 = "Select count(*) from couple where coupleName1= '"+ coupleName1 + "'";
						 String query4 = "Select count(*) from couple where coupleName2= '"+ coupleName2 + "'";
					 
					   	  myst1.executeQuery(query3);
					   	  myst2.executeQuery(query4);
					   	// 3. execution of sql 
					   	  ResultSet myres1 = myst1.executeQuery(query3);
					   	  ResultSet myres2 = myst2.executeQuery(query4);

						    	// 4. Process the resultset  
						          while(myres1.next() && myres2.next()) {
						        	  c1 = myres1.getInt("coupleName1");
						        	  System.out.println(c1);
						        	  c2 = myres2.getInt("coupleName2"); 
						        	  System.out.println(c2);
					         }
					     }
					     
						 catch(Exception e) {
					   	  System.out.println(e);
					   	  //e.printStackTrace();
					     }

							 if(c1 >= 1 || c2 >= 1) {
								 {
									 try {
											throw new NoAvailableException("One of the person is already coupled with someone else !!");
										} catch (NoAvailableException e) {
											System.out.println(e);
											//e.printStackTrace();
										}
								 } }
									 else {
										 String query5 = "Insert into couple(coupleName1, coupleName2)" + "values(?, ?)";
											try {
												Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
												PreparedStatement statement = mycon.prepareStatement(query5);
												statement.setString(1, coupleName1 );
												statement.setString(2, coupleName2);
												statement.executeUpdate();
												System.out.println(coupleName1 +" " + "and" + " " + coupleName2 + " added as a couple successfully!!");
											} catch (Exception e) {
												System.out.println(e);
												//e.printStackTrace();
									 
							 
						 }
					}
					}
					 }
               });

               viewColleagues.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						@SuppressWarnings("resource")
						Scanner sc= new Scanner(System.in);
						 System.out.println("Enter name of first person");
						 String colleague1= sc.nextLine();
						 System.out.println("Enter name of second person");
					     String colleague2= sc.nextLine();
					
							int colleague1Age = 0, colleague2Age = 0;
						try {
								
						    	// 1.connection  to database
						    	  Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
						    	
						    	    	  // 2.creation of stats
						    	  Statement myst1 = mycon.createStatement(); 
						    	  Statement myst2 = mycon.createStatement();
						    	 
						    	  String query1 = "select age from profile where name= '"+ colleague1 +"'";
						    	  String query2 = "select age from profile where name= '"+ colleague2 +"'";
						  
						    	  myst1.executeQuery(query1);
						    	  myst2.executeQuery(query2);
						    	// 3. execution of sql 
						    	  ResultSet myres1 = myst1.executeQuery(query1);
						    	  ResultSet myres2 = myst2.executeQuery(query2);

							    	// 4. Process the resultset  
							          while(myres1.next() && myres2.next()) {
							        	  colleague1Age = myres1.getInt("age");
							        	  System.out.println(colleague1Age);
							        	  colleague2Age = myres2.getInt("age"); 
							        	  System.out.println(colleague2Age);
						          }
						      }
						      catch(Exception e) {
						    	  System.out.println(e);
						    	  System.out.println(e);
						    	  //e.printStackTrace();
						      }
						if( colleague1Age <= 16 || colleague2Age <= 16)
						{
							 try {
									throw new NotToBeColleaguesException("One of the persons is a child and cannot be a colleague!!");
								} catch (NotToBeColleaguesException e) {
									System.out.println(e);
									//e.printStackTrace();
								}
						}
							 else {
								 
										String query3 = "Insert into colleagues(colleague1, colleague2)" + "values(?, ?)";
										try {
											Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
											PreparedStatement statement = mycon.prepareStatement(query3);
											statement.setString(1, colleague1 );
											statement.setString(2, colleague2);
											statement.executeUpdate();
											System.out.println("Colleagues " + colleague1 +" " + "and" + " " + colleague2 + " are added successfully!!");
										} catch (Exception e) {
											System.out.println(e);
											//e.printStackTrace();


									}
							 }

					}
               });
               
               viewClassmates.setOnAction(new EventHandler<ActionEvent>() {
            	   @Override
					public void handle(ActionEvent event) {
						@SuppressWarnings("resource")
						Scanner sc= new Scanner(System.in);
						 System.out.println("Enter name of first person");
						 String cm1= sc.nextLine(); //classmate1
						 System.out.println("Enter name of second person");
					     String cm2= sc.nextLine(); //classmate2
					
              int cm1Age = 0, cm2Age = 0; //to store ages of classmates
              try {
              		
                  	// 1.connection  to database
                  	  Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
                  	
                  	    	  // 2.creation of stats
                  	  Statement myst1 = mycon.createStatement(); 
                  	  Statement myst2 = mycon.createStatement();
                  	 
                  	  String query1 = "select age from profile where name= '"+ cm1 +"'";
                  	  String query2 = "select age from profile where name= '"+ cm2 +"'";
                
                  	  myst1.executeQuery(query1);
                  	  myst2.executeQuery(query2);
                  	// 3. execution of sql 
                  	  ResultSet myres1 = myst1.executeQuery(query1);
                  	  ResultSet myres2 = myst2.executeQuery(query2);

              	    	// 4. Process the resultset  
              	          while(myres1.next() && myres2.next()) {
              	        	  cm1Age = myres1.getInt("age");
              	        	  System.out.println(cm1Age);
              	        	  cm2Age = myres2.getInt("age"); 
              	        	  System.out.println(cm2Age);
                        }
                    }
                    catch(Exception e) {
                  	  System.out.println(e);
                  	System.out.println(e);
                  	  //e.printStackTrace();
                    }
              if( cm1Age <= 2|| cm2Age <= 2 )
              {
              	 try {
              			throw new NotToBeClassmatesException("One of the persons is a young child and cannot be a classmate!!");
              		} catch (NotToBeClassmatesException e) {
              			System.out.println(e);
              			e.printStackTrace();
              		}
              }
              else {
              	String query3 = "Insert into classmates(classMate1, classMate2)" + "values(?, ?)";
              	try {
              		Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
              		PreparedStatement statement = mycon.prepareStatement(query3);
              		statement.setString(1, cm1 );
              		statement.setString(2, cm2);
              		statement.executeUpdate();
              		System.out.println("Classmates " + cm1 +" " + "and" + " " + cm2 + " are added successfully!!");
              	} catch (Exception e) {
              		System.out.println(e);
              		//e.printStackTrace();
              	}
              }
               }
               });
					
  
               VBox layout = new VBox(30);
               layout.getChildren().addAll(l1,viewFriends, viewParents,viewCouples, viewColleagues, viewClassmates);
               layout.setPadding(new Insets(30,30,30,30));
               layout.setAlignment(Pos.CENTER);
               Scene scene = new Scene(layout);
               frame.setScene(scene);
               frame.showAndWait();
              
			}
		
            }	
	