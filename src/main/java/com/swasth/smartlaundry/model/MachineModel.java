package com.swasth.smartlaundry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "machine")
public class MachineModel {
		
		@Id
		@Column(name = "macUniqueId", length = 25)
		private String macUniqueId;
		
		@Column(name = "totalSlots")
		private Integer totalSlots;
			
		@Column(name = "macName", length = 25)
		private String macName;

		@Column(name = "ownerId")
		private Integer ownerId;

		public String getMacUniqueId() {
			return macUniqueId;
		}

		public void setMacUniqueId(String macUniqueId) {
			this.macUniqueId = macUniqueId;
		}

		public Integer getTotalSlots() {
			return totalSlots;
		}

		public void setTotalSlots(Integer totalSlots) {
			this.totalSlots = totalSlots;
		}

		public String getMacName() {
			return macName;
		}

		public void setMacName(String macName) {
			this.macName = macName;
		}

		public Integer getOwnerId() {
			return ownerId;
		}

		public void setOwnerId(Integer ownerId) {
			this.ownerId = ownerId;
		}

		@Override
		public String toString() {
			return "MachineModel [macUniqueId=" + macUniqueId + ", totalSlots=" + totalSlots
					+ ", macName=" + macName + ", ownerId=" + ownerId + "]";
		}
}
		