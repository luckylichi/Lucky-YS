package day01taskDomain;

import java.util.Date;

public class ChangeUse {
	int adminId;
	String number;
	String rank;
	String chang;
	int EmpId;
	Date changTime;
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getChang() {
		return chang;
	}
	public void setChang(String chang) {
		this.chang = chang;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public Date getChangTime() {
		return changTime;
	}
	public void setChangTime(Date changTime) {
		this.changTime = changTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + EmpId;
		result = prime * result + adminId;
		result = prime * result + ((chang == null) ? 0 : chang.hashCode());
		result = prime * result
				+ ((changTime == null) ? 0 : changTime.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChangeUse other = (ChangeUse) obj;
		if (EmpId != other.EmpId)
			return false;
		if (adminId != other.adminId)
			return false;
		if (chang == null) {
			if (other.chang != null)
				return false;
		} else if (!chang.equals(other.chang))
			return false;
		if (changTime == null) {
			if (other.changTime != null)
				return false;
		} else if (!changTime.equals(other.changTime))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChangeUse [EmpId=" + EmpId + ", adminId=" + adminId
				+ ", chang=" + chang + ", changTime=" + changTime + ", number="
				+ number + ", rank=" + rank + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
