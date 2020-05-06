package model;

import java.sql.*;

public class Payment {
	// A common method to connect to the DB
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/restdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertPayments(String code, String type, String amount, String desc) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into payment(`paymentID`,`paymentCode`,`paymentType`,`paymentAmount`,`paymentDesc`)"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, code);
			preparedStmt.setString(3, type);
			preparedStmt.setDouble(4, Double.parseDouble(amount));
			preparedStmt.setString(5, desc);
			// execute the statement
			preparedStmt.execute();
			con.close();
			//output = "Inserted successfully";
			
			String newPayments = readPayments();
			output = "{\"status\":\"success\", \"data\": \"" + newPayments + "\"}";
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the payment.\"}";
			 System.err.println(e.getMessage()); 
		}
		return output;
	}

	public String readPayments() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Payment Code</th><th>Payment Type</th><th>Payment Amount</th>"+ "<th>Payment Description</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from payment";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String paymentID = Integer.toString(rs.getInt("paymentID"));
				String paymentCode = rs.getString("paymentCode");
				String paymentType = rs.getString("paymentType");
				String paymentAmount = Double.toString(rs.getDouble("paymentAmount"));
				String paymentDesc = rs.getString("paymentDesc");
				// Add into the html table
				output += "<tr><td><input id='hidPaymentIDUpdate'name='hidPaymentIDUpdate' type='hidden'value='" + paymentID + "'>" + paymentCode + "</td>";
				output += "<td>" + paymentType + "</td>";
				output += "<td>" + paymentAmount + "</td>";
				output += "<td>" + paymentDesc + "</td>";
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-paymentid='"+ paymentID + "'>" + "</td></tr>"; 			
				}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the payments.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatePayments(String ID, String code, String type, String amount, String desc) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE payment SET paymentCode=?,paymentType=?,paymentAmount=?,paymentDesc=? WHERE paymentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, code);
			preparedStmt.setString(2, type);
			preparedStmt.setDouble(3, Double.parseDouble(amount));
			preparedStmt.setString(4, desc);
			preparedStmt.setInt(5, Integer.parseInt(ID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			//output = "Updated successfully";
			
			String newPayments = readPayments();
			 output = "{\"status\":\"success\", \"data\": \"" +
			 newPayments + "\"}"; 
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the payment.\"}";
			 System.err.println(e.getMessage()); 
		}
		return output;
	}

	public String deletePayment(String paymentID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from payment where paymentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(paymentID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			//output = "Deleted successfully";
			
			String newPayments = readPayments();
			 output = "{\"status\":\"success\", \"data\": \"" +
			 newPayments + "\"}"; 
			
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the payment.\"}";
			 System.err.println(e.getMessage());
		}
		return output;
	}

}
