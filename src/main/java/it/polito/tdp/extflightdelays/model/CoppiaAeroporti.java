package it.polito.tdp.extflightdelays.model;

public class CoppiaAeroporti {
	
	private Airport a1;
	private Airport a2;
	private Integer distanzaMedia;
	
	
	/**
	 * @param a1
	 * @param a2
	 * @param distanzaMedia
	 */
	public CoppiaAeroporti(Airport a1, Airport a2, Integer distanzaMedia) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.distanzaMedia = distanzaMedia;
	}
	/**
	 * @return the a1
	 */
	public Airport getA1() {
		return a1;
	}
	/**
	 * @param a1 the a1 to set
	 */
	public void setA1(Airport a1) {
		this.a1 = a1;
	}
	/**
	 * @return the a2
	 */
	public Airport getA2() {
		return a2;
	}
	/**
	 * @param a2 the a2 to set
	 */
	public void setA2(Airport a2) {
		this.a2 = a2;
	}
	/**
	 * @return the distanzaMedia
	 */
	public Integer getDistanzaMedia() {
		return distanzaMedia;
	}
	/**
	 * @param distanzaMedia the distanzaMedia to set
	 */
	public void setDistanzaMedia(Integer distanzaMedia) {
		this.distanzaMedia = distanzaMedia;
	}
	@Override
	public String toString() {
		return "CoppiaAeroporti [a1=" + a1 + ", a2=" + a2 + ", distanzaMedia=" + distanzaMedia + "]";
	}
	
	

}
