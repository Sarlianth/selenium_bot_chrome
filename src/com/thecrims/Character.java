package com.thecrims;

public class Character extends Core{

	private String nickname;
	private String job;
	private String spirit;
	private Integer respect;
	private Integer tickets;
	private Integer stamina;
	private Integer addiction;
	
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	
	/**
	 * @return the spirit
	 */
	public String getSpirit() {
		return spirit;
	}
	
	/**
	 * @param spirit the spirit to set
	 */
	public void setSpirit(String spirit) {
		this.spirit = spirit;
	}
	
	/**
	 * @return the respect
	 */
	public Integer getRespect() {
		return respect;
	}
	
	/**
	 * @param respect the respect to set
	 */
	public void setRespect(Integer respect) {
		this.respect = respect;
	}
	
	/**
	 * @return the tickets
	 */
	public Integer getTickets() {
		return tickets;
	}
	
	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}
	
	/**
	 * @return the stamina
	 */
	public Integer getStamina() {
		return stamina;
	}
	
	/**
	 * @param stamina the stamina to set
	 */
	public void setStamina(Integer stamina) {
		this.stamina = stamina;
	}
	
	/**
	 * @return the addiction
	 */
	public Integer getAddiction() {
		return addiction;
	}
	
	/**
	 * @param addiction the addiction to set
	 */
	public void setAddiction(Integer addiction) {
		this.addiction = addiction;
	}
	
	public String getStaminaString() {
		return this.getElementValueById("user-profile-stamina").replace("Stamina: ", "").replace("%", "");
	}
	
	public String getAddictionString() {
		return this.getElementValueById("user-profile-addiction").replace("Addiction: ", "").replace("%", "");
	}
	
	public Character populateCharacter() 
	{
		this.setNickname(this.getElementValueById("user-profile-username"));
		this.setJob(this.getElementValueById("user-profile-level"));
		this.setSpirit(this.getElementValueByXpath("//*[@id=\"user-profile-info\"]/div[3]/span"));
		this.setRespect(Integer.parseInt(this.getElementValueByXpath("//*[@id=\"user-profile-info\"]/div[4]/span")));
		this.setTickets(Integer.parseInt(this.getElementValueByXpath("//*[@id=\"user-profile-info\"]/div[5]/span")));
		
		String stamina = this.getStaminaString();		
		this.setStamina(Integer.parseInt(stamina));
		
		String addiction = this.getAddictionString();
		this.setAddiction(Integer.parseInt(addiction));
		
		return this;
	}
	
}
