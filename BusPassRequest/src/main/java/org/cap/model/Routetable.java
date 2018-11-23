package org.cap.model;

public class Routetable {
	private Integer route_id;
	private String route_path;
	private Integer no_of_seats_occupied;
	private Integer total_seats;
	private String bus_no;
	private String driver_name;
	private Double total_km;
	public Routetable(Integer route_id, String route_path, Integer no_of_seats_occupied, Integer total_seats,
			String bus_no, String driver_name, Double total_km) {
		super();
		this.route_id = route_id;
		this.route_path = route_path;
		this.no_of_seats_occupied = no_of_seats_occupied;
		this.total_seats = total_seats;
		this.bus_no = bus_no;
		this.driver_name = driver_name;
		this.total_km = total_km;
	}
	public Routetable() {
		super();
	}
	public Integer getRoute_id() {
		return route_id;
	}
	public void setRoute_id(Integer route_id) {
		this.route_id = route_id;
	}
	public String getRoute_path() {
		return route_path;
	}
	public void setRoute_path(String route_path) {
		this.route_path = route_path;
	}
	public Integer getNo_of_seats_occupied() {
		return no_of_seats_occupied;
	}
	public void setNo_of_seats_occupied(Integer no_of_seats_occupied) {
		this.no_of_seats_occupied = no_of_seats_occupied;
	}
	public Integer getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(Integer total_seats) {
		this.total_seats = total_seats;
	}
	public String getBus_no() {
		return bus_no;
	}
	public void setBus_no(String bus_no) {
		this.bus_no = bus_no;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public Double getTotal_km() {
		return total_km;
	}
	public void setTotal_km(Double total_km) {
		this.total_km = total_km;
	}
	@Override
	public String toString() {
		return "Routetable [route_id=" + route_id + ", route_path=" + route_path + ", no_of_seats_occupied="
				+ no_of_seats_occupied + ", total_seats=" + total_seats + ", bus_no=" + bus_no + ", driver_name="
				+ driver_name + ", total_km=" + total_km + "]";
	}
	
	
	

}
