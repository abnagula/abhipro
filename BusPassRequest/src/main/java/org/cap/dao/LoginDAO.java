package org.cap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.cap.model.LoginBean;
import org.cap.model.PassRequestForm;
import org.cap.model.Routetable;
import org.cap.model.TransactionBean;

public class LoginDAO implements ILoginDAO {

	@Override
	public boolean checkUser(LoginBean loginBean) {
		String sql="select * from adminLogin where username=? and userpassword=?";

		try(PreparedStatement ps =getSQLConnection().prepareStatement(sql);){

			ps.setString(1, loginBean.getUsername());
			ps.setString(2, loginBean.getPassword());
			ResultSet rs =ps.executeQuery();
			System.out.println("resultset");
			if(rs.next()) {
				System.out.println("resultset1");
				return true;
				

			}

		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("resultset exception");
		}
		return false;


	}
	private Connection getSQLConnection()
	{
		Connection con=null;
		try{


			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/capdb","root","India123");
			return con;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception e1) {
			e1.printStackTrace();
		}

		return con;
	}
	@Override
	public PassRequestForm createRequest(PassRequestForm passRequestBean) {
		String sql="insert into BusPassRequest(EmployeeId,firstname,lastname,gender,address,email,dateofjoin,location,pickuploc,pickuptime,status,designation)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pst = getSQLConnection().prepareStatement(sql);){
			pst.setString(1, passRequestBean.getEmployeeid());
			pst.setString(2, passRequestBean.getFirstname());
			pst.setString(3, passRequestBean.getLastname());
			pst.setString(4, passRequestBean.getGender());
			pst.setString(5, passRequestBean.getAddress());
			pst.setString(6, passRequestBean.getEmail());
			pst.setDate(7, Date.valueOf(passRequestBean.getDoj()));
			pst.setString(8, passRequestBean.getLocation());
			pst.setString(9, passRequestBean.getPickUpLoc());
			pst.setTime(10, Time.valueOf(passRequestBean.getPickUpTime()));

			pst.setString(11, passRequestBean.getStatus());
			pst.setString(12, passRequestBean.getDesignation());

			int count=pst.executeUpdate();
			if(count>0) {
				return passRequestBean;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Routetable> listAllRoutes() {
		String sql="select * from route";
		int routeCount=0;
		try(

				Statement statement=getSQLConnection().createStatement();

				){
			ResultSet resultSet=statement.executeQuery(sql);
			List<Routetable> routeList=new ArrayList<>();
			while(resultSet.next()){
				routeCount++;
				Routetable route=new Routetable();
				populateRoute(route,resultSet);

				routeList.add(route);

			}
			if(routeCount>0){
				return routeList;
			}else{
				return null;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	private void populateRoute(Routetable route, ResultSet resultSet) throws SQLException {
		route.setRoute_id(resultSet.getInt(1));
		route.setRoute_path(resultSet.getString(2));
		route.setNo_of_seats_occupied(resultSet.getInt(3));
		route.setTotal_seats(resultSet.getInt(4));
		route.setBus_no(resultSet.getString(5));
		route.setDriver_name(resultSet.getString(6));
		route.setTotal_km(resultSet.getDouble(7));


	}
	@Override
	public Routetable addRoute(Routetable newroute) {
		String sql="insert into route(route_path,no_of_seats_occupied,total_seats,bus_no,driver_name,total_km) values(?,?,?,?,?,?)";
		try(PreparedStatement pst = getSQLConnection().prepareStatement(sql);){
			pst.setString(1, newroute.getRoute_path());
			pst.setInt(2, newroute.getNo_of_seats_occupied());
			pst.setInt(3, newroute.getTotal_seats());
			pst.setString(4, newroute.getBus_no());
			pst.setString(5, newroute.getDriver_name());
			pst.setDouble(6, newroute.getTotal_km());

			int n=pst.executeUpdate();
			System.out.println("update executed");
			System.out.println(n);
			if(n>0) {
				System.out.println(n);
				return newroute;
			}
			else {
				return null;
			}



		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<String> PendingReqServlet() {
		String sql="select EmployeeId from BusPassRequest where status='pending'";

		try(Statement statement =getSQLConnection().createStatement();){

			ResultSet rs= statement.executeQuery(sql);
			List<String> empList=new ArrayList<>();
			while(rs.next()) {
				empList.add(rs.getString(1));

			}
			return empList;

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;

	}
	
	private void populateRoute(PassRequestForm bus, ResultSet rs) throws SQLException {
		bus.setEmployeeid(rs.getString(2));
		bus.setFirstname(rs.getString(3));
		bus.setLastname(rs.getString(4));
		bus.setGender(rs.getString(5));
		bus.setAddress(rs.getString(6));
		bus.setEmail(rs.getString(7));
		
		java.sql.Date sqlDate=rs.getDate(8);
		 java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		 Instant instant = Instant.ofEpochMilli(utilDate.getTime()); 
		 LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
		 LocalDate localDate = localDateTime.toLocalDate();
	
		bus.setDoj(localDate);

		bus.setLocation(rs.getString(9));
		bus.setPickUpLoc(rs.getString(10));
		Time time=rs.getTime(11);
		LocalTime localTime=time.toLocalTime();
		bus.setPickUpTime(localTime);

		bus.setStatus(rs.getString(12));
		bus.setDesignation(rs.getString(13));




	}
	@Override
	public List<PassRequestForm> pendingDetails() {


		String sql="select * from BusPassRequest where status='pending'";
		int pendingCount=0;
		try(

				Statement statement=getSQLConnection().createStatement();

				){
			ResultSet resultSet=statement.executeQuery(sql);
			List<PassRequestForm> pendingList=new ArrayList<>();
			while(resultSet.next()){
				pendingCount++;
				PassRequestForm busBean=new PassRequestForm();
				populateRoute(busBean,resultSet);

				pendingList.add(busBean);

			}
			if(pendingCount>0){
				return pendingList;
			}else{
				return null;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	








@Override
public List<PassRequestForm> pendingDetailsOfEmp(String empid) {
	String sql="select * from BusPassRequest where EmployeeId=?";
	int pendingCount=0;
	try(

			PreparedStatement preparedStatement=getSQLConnection().prepareStatement(sql);

			){
		preparedStatement.setString(1,empid);
		ResultSet resultSet=preparedStatement.executeQuery();
		List<PassRequestForm> pendingList=new ArrayList<>();
		while(resultSet.next()){
			pendingCount++;
			PassRequestForm busBean=new PassRequestForm();
			populateRoute(busBean,resultSet);

			pendingList.add(busBean);

		}
		if(pendingCount>0){
			return pendingList;
		}else{
			return null;
		}

	}catch(SQLException e){
		e.printStackTrace();
	}
	return null;


}
@Override
public Integer transaction(TransactionBean transaction) {
	String sql="insert into transaction(employeeId,transaction_date,calculated_km,monthly_fare,route_id) values(?,?,?,?,?)";
	String sql1="update BusPassRequest set status=? where EmployeeId=?";
	String sql2="update route set no_of_seats_occupied=no_of_seats_occupied+1 where route_id=?";
	try(PreparedStatement preparedStatement = getSQLConnection().prepareStatement(sql);
			PreparedStatement preparedStatement2 = getSQLConnection().prepareStatement(sql1);
			PreparedStatement preparedStatement1 = getSQLConnection().prepareStatement("select transaction_id from transaction where employeeId=?");
			PreparedStatement preparedStatement3 = getSQLConnection().prepareStatement(sql2);
			){
		preparedStatement.setString(1,transaction.getEmp_id());
		preparedStatement.setDate(2, Date.valueOf(transaction.getTransaction_date()));
		preparedStatement.setDouble(3, transaction.getTotal_km());
		preparedStatement.setInt(4, transaction.getMonthly_fare());
		preparedStatement.setInt(5, transaction.getRoute_id());
		
		preparedStatement1.setString(1,transaction.getEmp_id());
		preparedStatement2.setString(1,"Approved");
		preparedStatement2.setString(2, transaction.getEmp_id());
		
		preparedStatement3.setInt(1,transaction.getRoute_id());
		
		int n=preparedStatement.executeUpdate();
		
		if(n>0) {
			ResultSet resultSet = preparedStatement1.executeQuery();
			if(resultSet.next()) {
				Integer transaction_id = resultSet.getInt(1);
				int n1=preparedStatement2.executeUpdate();
				int n2=preparedStatement3.executeUpdate();
				if(n1>0 && n2>0)
					return transaction_id;
			}
		}
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
}
@Override
public List<TransactionBean> monthlyReport(LocalDate fromDate, LocalDate toDate) {
	
	String sql="select * from transaction where transaction_date between ? and ?";
	int tCount=0;
	try(
			
			PreparedStatement preparedStatement=getSQLConnection().prepareStatement(sql);

			){
		preparedStatement.setDate(1,Date.valueOf(fromDate));
		preparedStatement.setDate(2,Date.valueOf(toDate));
		
		ResultSet resultSet=preparedStatement.executeQuery();
		List<TransactionBean> tList=new ArrayList<>();
		while(resultSet.next()){
			tCount++;
			TransactionBean tBean=new TransactionBean();
			tBean.setTransaction_id(resultSet.getInt(1));
			tBean.setEmp_id(resultSet.getString(2));
			java.sql.Date sqlDate=resultSet.getDate("transaction_date");
			 java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
			 Instant instant = Instant.ofEpochMilli(utilDate.getTime()); 
			 LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
			 LocalDate localDate = localDateTime.toLocalDate();
			tBean.setTransaction_date(localDate);
			tBean.setTotal_km(resultSet.getDouble(4));
			tBean.setMonthly_fare(resultSet.getInt(5));
			tBean.setRoute_id(resultSet.getInt(6));
			

			tList.add(tBean);
			
		}
		if(tCount>0){
			return tList;
		}else{
			return null;
		}

	}catch(SQLException e){
		e.printStackTrace();
	}
	return null;
	
	
}


private void populateReport(TransactionBean bean, ResultSet rs) {
	// TODO Auto-generated method stub
	
	try {
		bean.setTransaction_id(rs.getInt(1));
		bean.setEmp_id(rs.getString(2));
		
		java.sql.Date sqlDate=rs.getDate(3);
		 java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		 Instant instant = Instant.ofEpochMilli(utilDate.getTime()); 
		 LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
		 LocalDate localDate = localDateTime.toLocalDate();
		 
		 bean.setTransaction_date(localDate);
		 
		 bean.setTotal_km(rs.getDouble(4));
		 bean.setMonthly_fare(rs.getInt(5));
		 bean.setRoute_id(rs.getInt(6));
		 
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
@Override
public List<TransactionBean> getReport(LocalDate from, LocalDate to) {
	String sql="select *from transaction where transaction_date between ? and ?";
	int Count=0;
	try(PreparedStatement pt=getSQLConnection().prepareStatement(sql);){
		pt.setDate(1, Date.valueOf(from));
		pt.setDate(2, Date.valueOf(to));
		
		ResultSet rs=pt.executeQuery();
		List<TransactionBean> List=new ArrayList<>();
		while(rs.next()) {
			
			Count++;
			TransactionBean bean=new TransactionBean();
			populateReport(bean,rs);
			List.add(bean);

		}
		if(Count!=0){
			return List;
		}else{
			return null;
		}
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	return null;
} 
} 
}

