package org.cap.model;
import java.time.LocalDate;

	public class TransactionBean {
		private Integer transaction_id;
		private Integer route_id;
		private String emp_id;
		private LocalDate transaction_date;
		private Double total_km;
		private Integer monthly_fare;
		
		
		public TransactionBean() {
			super();
		}

		public TransactionBean(Integer route_id, String emp_id, LocalDate transaction_date, Double total_km,
				Integer monthly_fare) {
			super();
			this.route_id = route_id;
			this.emp_id = emp_id;
			this.transaction_date = transaction_date;
			this.total_km = total_km;
			this.monthly_fare = monthly_fare;
		}
		
		
		public TransactionBean(Integer transaction_id, Integer route_id, String emp_id, LocalDate transaction_date,
				Double total_km, Integer monthly_fare) {
			super();
			this.transaction_id = transaction_id;
			this.route_id = route_id;
			this.emp_id = emp_id;
			this.transaction_date = transaction_date;
			this.total_km = total_km;
			this.monthly_fare = monthly_fare;
		}


		public Integer getTransaction_id() {
			return transaction_id;
		}


		public void setTransaction_id(Integer transaction_id) {
			this.transaction_id = transaction_id;
		}


		public Integer getRoute_id() {
			return route_id;
		}


		public void setRoute_id(Integer route_id) {
			this.route_id = route_id;
		}


		public String getEmp_id() {
			return emp_id;
		}


		public void setEmp_id(String emp_id) {
			this.emp_id = emp_id;
		}


		public LocalDate getTransaction_date() {
			return transaction_date;
		}


		public void setTransaction_date(LocalDate transaction_date) {
			this.transaction_date = transaction_date;
		}


		public Double getTotal_km() {
			return total_km;
		}


		public void setTotal_km(Double total_km) {
			this.total_km = total_km;
		}


		public Integer getMonthly_fare() {
			return monthly_fare;
		}


		public void setMonthly_fare(Integer monthly_fare) {
			this.monthly_fare = monthly_fare;
		}


		@Override
		public String toString() {
			return "TransactionBean [transaction_id=" + transaction_id + ", route_id=" + route_id + ", emp_id=" + emp_id
					+ ", transaction_date=" + transaction_date + ", total_km=" + total_km + ", monthly_fare=" + monthly_fare
					+ "]";
		}


		
		

	}


