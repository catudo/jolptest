package com.test.jolptest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultData {
	@JsonProperty("data")
	Data data;
	
}

class  Data {
	@JsonProperty("updated_at")
	String updated_at;
	@JsonProperty("latest_data")
	Latest latest_data;
}

class Latest {
	@JsonProperty("deaths")
	private int deaths;
	@JsonProperty("confirmed")
	private int confirmed;
	@JsonProperty("recovered")
	private int recovered;
	@JsonProperty("critical")
	
	private int critical;
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	public int getCritical() {
		return critical;
	}
	public void setCritical(int critical) {
		this.critical = critical;
	}
    
    
    
    
}

class Calculated {
	@JsonProperty("death_rate")
	private double death_rate;
	@JsonProperty("recovery_rate")
	private double recovery_rate;
	@JsonProperty("recovered_vs_death_ratio")
	private double recovered_vs_death_ratio;
	@JsonProperty("cases_per_million_population")
	private double cases_per_million_population;
	public double getDeath_rate() {
		return death_rate;
	}
	public void setDeath_rate(double death_rate) {
		this.death_rate = death_rate;
	}
	public double getRecovery_rate() {
		return recovery_rate;
	}
	public void setRecovery_rate(double recovery_rate) {
		this.recovery_rate = recovery_rate;
	}
	public double getRecovered_vs_death_ratio() {
		return recovered_vs_death_ratio;
	}
	public void setRecovered_vs_death_ratio(double recovered_vs_death_ratio) {
		this.recovered_vs_death_ratio = recovered_vs_death_ratio;
	}
	public double getCases_per_million_population() {
		return cases_per_million_population;
	}
	public void setCases_per_million_population(double cases_per_million_population) {
		this.cases_per_million_population = cases_per_million_population;
	}
	
	
	
}