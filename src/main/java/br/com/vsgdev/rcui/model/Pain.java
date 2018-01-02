package br.com.vsgdev.rcui.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * this class represent an abdominal pain
 */
@Entity
public class Pain {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "The field 'created' cannot be null")
	@DateTimeFormat
	private LocalDateTime created;

	@NotNull(message = "The field 'painTime' cannot be null")
	@DateTimeFormat
	private LocalDateTime painTime;

	@NotNull(message = "The field 'intensity' cannot be null")
	private int intensity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getPainTime() {
		return painTime;
	}

	public void setPainTime(LocalDateTime painTime) {
		this.painTime = painTime;
	}

	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + intensity;
		result = prime * result + ((painTime == null) ? 0 : painTime.hashCode());
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
		Pain other = (Pain) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intensity != other.intensity)
			return false;
		if (painTime == null) {
			if (other.painTime != null)
				return false;
		} else if (!painTime.equals(other.painTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pain [id=" + id + ", created=" + created + ", painTime=" + painTime + ", intensity=" + intensity + "]";
	}

}
