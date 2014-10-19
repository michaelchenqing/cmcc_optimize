/*
 * generated dao ibatis class
 *
 * @author gaoqs
 * Copyright (c) 2014 All Rights Reserved.
 */
package com.cmcc.optimize.dataaccess.dao.dataobject;

// auto generated imports
import java.util.Date;

/**
 * A data object class directly models database table <tt>MB_PLAN_LTESITE_INFO</tt>.
 *
 *
 * @author gaoqs
 */
public class MbPlanLtesiteInfoDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

	/**
	 * This property corresponds to db column <tt>PENODEBCLASS</tt>.
	 */
	private String penodebclass;

	/**
	 * This property corresponds to db column <tt>PENODEBNAME</tt>.
	 */
	private String penodebname;

	/**
	 * This property corresponds to db column <tt>PROVINCE_NAME</tt>.
	 */
	private String provinceName;

	/**
	 * This property corresponds to db column <tt>CITY_NAME</tt>.
	 */
	private String cityName;

	/**
	 * This property corresponds to db column <tt>LONGITUDE</tt>.
	 */
	private Float longitude;

	/**
	 * This property corresponds to db column <tt>LATITUDE</tt>.
	 */
	private Float latitude;

	/**
	 * This property corresponds to db column <tt>COUNTRY_NAME</tt>.
	 */
	private String countryName;

	/**
	 * This property corresponds to db column <tt>REGIONTYPE</tt>.
	 */
	private String regiontype;

	/**
	 * This property corresponds to db column <tt>PROJECTPHASE</tt>.
	 */
	private String projectphase;

	/**
	 * This property corresponds to db column <tt>PENODEBID</tt>.
	 */
	private String penodebid;

	/**
	 * This property corresponds to db column <tt>ISOPEN</tt>.
	 */
	private String isopen;

	/**
	 * This property corresponds to db column <tt>COVERAGECHARACTER</tt>.
	 */
	private String coveragecharacter;

	/**
	 * This property corresponds to db column <tt>WORK_FRQBAND</tt>.
	 */
	private String workFrqband;

	/**
	 * This property corresponds to db column <tt>ISCHECK</tt>.
	 */
	private String ischeck;

	/**
	 * This property corresponds to db column <tt>ISNODEBNAME</tt>.
	 */
	private String isnodebname;

	/**
	 * This property corresponds to db column <tt>ISCHECKLON</tt>.
	 */
	private Float ischecklon;

	/**
	 * This property corresponds to db column <tt>ISCHECKLAT</tt>.
	 */
	private Float ischecklat;

	/**
	 * This property corresponds to db column <tt>AZIMUTHCELL1</tt>.
	 */
	private Integer azimuthcell1;

	/**
	 * This property corresponds to db column <tt>AZIMUTHCELL2</tt>.
	 */
	private Integer azimuthcell2;

	/**
	 * This property corresponds to db column <tt>AZIMUTHCELL3</tt>.
	 */
	private Integer azimuthcell3;

	/**
	 * This property corresponds to db column <tt>HEIGHTCELL1</tt>.
	 */
	private Integer heightcell1;

	/**
	 * This property corresponds to db column <tt>HEIGHTCELL2</tt>.
	 */
	private Integer heightcell2;

	/**
	 * This property corresponds to db column <tt>HEIGHTCELL3</tt>.
	 */
	private Integer heightcell3;

	/**
	 * This property corresponds to db column <tt>DOWNTILTCELL1</tt>.
	 */
	private Integer downtiltcell1;

	/**
	 * This property corresponds to db column <tt>DOWNTILTCELL2</tt>.
	 */
	private Integer downtiltcell2;

	/**
	 * This property corresponds to db column <tt>DOWNTILTCELL3</tt>.
	 */
	private Integer downtiltcell3;

	/**
	 * This property corresponds to db column <tt>ELECTRICALDOWNTILTCELL1</tt>.
	 */
	private Integer electricaldowntiltcell1;

	/**
	 * This property corresponds to db column <tt>ELECTRICALDOWNTILTCELL2</tt>.
	 */
	private Integer electricaldowntiltcell2;

	/**
	 * This property corresponds to db column <tt>ELECTRICALDOWNTILTCELL3</tt>.
	 */
	private Integer electricaldowntiltcell3;

	/**
	 * This property corresponds to db column <tt>ISCHECKTYPE</tt>.
	 */
	private String ischecktype;

	/**
	 * This property corresponds to db column <tt>NETGRNAME</tt>.
	 */
	private String netgrname;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>recordTime</tt>.
     *
     * @return property value of recordTime
     */
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * Setter method for property <tt>recordTime</tt>.
	 * 
	 * @param recordTime value to be assigned to property recordTime
     */
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

    /**
     * Getter method for property <tt>penodebclass</tt>.
     *
     * @return property value of penodebclass
     */
	public String getPenodebclass() {
		return penodebclass;
	}
	
	/**
	 * Setter method for property <tt>penodebclass</tt>.
	 * 
	 * @param penodebclass value to be assigned to property penodebclass
     */
	public void setPenodebclass(String penodebclass) {
		this.penodebclass = penodebclass;
	}

    /**
     * Getter method for property <tt>penodebname</tt>.
     *
     * @return property value of penodebname
     */
	public String getPenodebname() {
		return penodebname;
	}
	
	/**
	 * Setter method for property <tt>penodebname</tt>.
	 * 
	 * @param penodebname value to be assigned to property penodebname
     */
	public void setPenodebname(String penodebname) {
		this.penodebname = penodebname;
	}

    /**
     * Getter method for property <tt>provinceName</tt>.
     *
     * @return property value of provinceName
     */
	public String getProvinceName() {
		return provinceName;
	}
	
	/**
	 * Setter method for property <tt>provinceName</tt>.
	 * 
	 * @param provinceName value to be assigned to property provinceName
     */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

    /**
     * Getter method for property <tt>cityName</tt>.
     *
     * @return property value of cityName
     */
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * Setter method for property <tt>cityName</tt>.
	 * 
	 * @param cityName value to be assigned to property cityName
     */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

    /**
     * Getter method for property <tt>longitude</tt>.
     *
     * @return property value of longitude
     */
	public Float getLongitude() {
		return longitude;
	}
	
	/**
	 * Setter method for property <tt>longitude</tt>.
	 * 
	 * @param longitude value to be assigned to property longitude
     */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

    /**
     * Getter method for property <tt>latitude</tt>.
     *
     * @return property value of latitude
     */
	public Float getLatitude() {
		return latitude;
	}
	
	/**
	 * Setter method for property <tt>latitude</tt>.
	 * 
	 * @param latitude value to be assigned to property latitude
     */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

    /**
     * Getter method for property <tt>countryName</tt>.
     *
     * @return property value of countryName
     */
	public String getCountryName() {
		return countryName;
	}
	
	/**
	 * Setter method for property <tt>countryName</tt>.
	 * 
	 * @param countryName value to be assigned to property countryName
     */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

    /**
     * Getter method for property <tt>regiontype</tt>.
     *
     * @return property value of regiontype
     */
	public String getRegiontype() {
		return regiontype;
	}
	
	/**
	 * Setter method for property <tt>regiontype</tt>.
	 * 
	 * @param regiontype value to be assigned to property regiontype
     */
	public void setRegiontype(String regiontype) {
		this.regiontype = regiontype;
	}

    /**
     * Getter method for property <tt>projectphase</tt>.
     *
     * @return property value of projectphase
     */
	public String getProjectphase() {
		return projectphase;
	}
	
	/**
	 * Setter method for property <tt>projectphase</tt>.
	 * 
	 * @param projectphase value to be assigned to property projectphase
     */
	public void setProjectphase(String projectphase) {
		this.projectphase = projectphase;
	}

    /**
     * Getter method for property <tt>penodebid</tt>.
     *
     * @return property value of penodebid
     */
	public String getPenodebid() {
		return penodebid;
	}
	
	/**
	 * Setter method for property <tt>penodebid</tt>.
	 * 
	 * @param penodebid value to be assigned to property penodebid
     */
	public void setPenodebid(String penodebid) {
		this.penodebid = penodebid;
	}

    /**
     * Getter method for property <tt>isopen</tt>.
     *
     * @return property value of isopen
     */
	public String getIsopen() {
		return isopen;
	}
	
	/**
	 * Setter method for property <tt>isopen</tt>.
	 * 
	 * @param isopen value to be assigned to property isopen
     */
	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}

    /**
     * Getter method for property <tt>coveragecharacter</tt>.
     *
     * @return property value of coveragecharacter
     */
	public String getCoveragecharacter() {
		return coveragecharacter;
	}
	
	/**
	 * Setter method for property <tt>coveragecharacter</tt>.
	 * 
	 * @param coveragecharacter value to be assigned to property coveragecharacter
     */
	public void setCoveragecharacter(String coveragecharacter) {
		this.coveragecharacter = coveragecharacter;
	}

    /**
     * Getter method for property <tt>workFrqband</tt>.
     *
     * @return property value of workFrqband
     */
	public String getWorkFrqband() {
		return workFrqband;
	}
	
	/**
	 * Setter method for property <tt>workFrqband</tt>.
	 * 
	 * @param workFrqband value to be assigned to property workFrqband
     */
	public void setWorkFrqband(String workFrqband) {
		this.workFrqband = workFrqband;
	}

    /**
     * Getter method for property <tt>ischeck</tt>.
     *
     * @return property value of ischeck
     */
	public String getIscheck() {
		return ischeck;
	}
	
	/**
	 * Setter method for property <tt>ischeck</tt>.
	 * 
	 * @param ischeck value to be assigned to property ischeck
     */
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}

    /**
     * Getter method for property <tt>isnodebname</tt>.
     *
     * @return property value of isnodebname
     */
	public String getIsnodebname() {
		return isnodebname;
	}
	
	/**
	 * Setter method for property <tt>isnodebname</tt>.
	 * 
	 * @param isnodebname value to be assigned to property isnodebname
     */
	public void setIsnodebname(String isnodebname) {
		this.isnodebname = isnodebname;
	}

    /**
     * Getter method for property <tt>ischecklon</tt>.
     *
     * @return property value of ischecklon
     */
	public Float getIschecklon() {
		return ischecklon;
	}
	
	/**
	 * Setter method for property <tt>ischecklon</tt>.
	 * 
	 * @param ischecklon value to be assigned to property ischecklon
     */
	public void setIschecklon(Float ischecklon) {
		this.ischecklon = ischecklon;
	}

    /**
     * Getter method for property <tt>ischecklat</tt>.
     *
     * @return property value of ischecklat
     */
	public Float getIschecklat() {
		return ischecklat;
	}
	
	/**
	 * Setter method for property <tt>ischecklat</tt>.
	 * 
	 * @param ischecklat value to be assigned to property ischecklat
     */
	public void setIschecklat(Float ischecklat) {
		this.ischecklat = ischecklat;
	}

    /**
     * Getter method for property <tt>azimuthcell1</tt>.
     *
     * @return property value of azimuthcell1
     */
	public Integer getAzimuthcell1() {
		return azimuthcell1;
	}
	
	/**
	 * Setter method for property <tt>azimuthcell1</tt>.
	 * 
	 * @param azimuthcell1 value to be assigned to property azimuthcell1
     */
	public void setAzimuthcell1(Integer azimuthcell1) {
		this.azimuthcell1 = azimuthcell1;
	}

    /**
     * Getter method for property <tt>azimuthcell2</tt>.
     *
     * @return property value of azimuthcell2
     */
	public Integer getAzimuthcell2() {
		return azimuthcell2;
	}
	
	/**
	 * Setter method for property <tt>azimuthcell2</tt>.
	 * 
	 * @param azimuthcell2 value to be assigned to property azimuthcell2
     */
	public void setAzimuthcell2(Integer azimuthcell2) {
		this.azimuthcell2 = azimuthcell2;
	}

    /**
     * Getter method for property <tt>azimuthcell3</tt>.
     *
     * @return property value of azimuthcell3
     */
	public Integer getAzimuthcell3() {
		return azimuthcell3;
	}
	
	/**
	 * Setter method for property <tt>azimuthcell3</tt>.
	 * 
	 * @param azimuthcell3 value to be assigned to property azimuthcell3
     */
	public void setAzimuthcell3(Integer azimuthcell3) {
		this.azimuthcell3 = azimuthcell3;
	}

    /**
     * Getter method for property <tt>heightcell1</tt>.
     *
     * @return property value of heightcell1
     */
	public Integer getHeightcell1() {
		return heightcell1;
	}
	
	/**
	 * Setter method for property <tt>heightcell1</tt>.
	 * 
	 * @param heightcell1 value to be assigned to property heightcell1
     */
	public void setHeightcell1(Integer heightcell1) {
		this.heightcell1 = heightcell1;
	}

    /**
     * Getter method for property <tt>heightcell2</tt>.
     *
     * @return property value of heightcell2
     */
	public Integer getHeightcell2() {
		return heightcell2;
	}
	
	/**
	 * Setter method for property <tt>heightcell2</tt>.
	 * 
	 * @param heightcell2 value to be assigned to property heightcell2
     */
	public void setHeightcell2(Integer heightcell2) {
		this.heightcell2 = heightcell2;
	}

    /**
     * Getter method for property <tt>heightcell3</tt>.
     *
     * @return property value of heightcell3
     */
	public Integer getHeightcell3() {
		return heightcell3;
	}
	
	/**
	 * Setter method for property <tt>heightcell3</tt>.
	 * 
	 * @param heightcell3 value to be assigned to property heightcell3
     */
	public void setHeightcell3(Integer heightcell3) {
		this.heightcell3 = heightcell3;
	}

    /**
     * Getter method for property <tt>downtiltcell1</tt>.
     *
     * @return property value of downtiltcell1
     */
	public Integer getDowntiltcell1() {
		return downtiltcell1;
	}
	
	/**
	 * Setter method for property <tt>downtiltcell1</tt>.
	 * 
	 * @param downtiltcell1 value to be assigned to property downtiltcell1
     */
	public void setDowntiltcell1(Integer downtiltcell1) {
		this.downtiltcell1 = downtiltcell1;
	}

    /**
     * Getter method for property <tt>downtiltcell2</tt>.
     *
     * @return property value of downtiltcell2
     */
	public Integer getDowntiltcell2() {
		return downtiltcell2;
	}
	
	/**
	 * Setter method for property <tt>downtiltcell2</tt>.
	 * 
	 * @param downtiltcell2 value to be assigned to property downtiltcell2
     */
	public void setDowntiltcell2(Integer downtiltcell2) {
		this.downtiltcell2 = downtiltcell2;
	}

    /**
     * Getter method for property <tt>downtiltcell3</tt>.
     *
     * @return property value of downtiltcell3
     */
	public Integer getDowntiltcell3() {
		return downtiltcell3;
	}
	
	/**
	 * Setter method for property <tt>downtiltcell3</tt>.
	 * 
	 * @param downtiltcell3 value to be assigned to property downtiltcell3
     */
	public void setDowntiltcell3(Integer downtiltcell3) {
		this.downtiltcell3 = downtiltcell3;
	}

    /**
     * Getter method for property <tt>electricaldowntiltcell1</tt>.
     *
     * @return property value of electricaldowntiltcell1
     */
	public Integer getElectricaldowntiltcell1() {
		return electricaldowntiltcell1;
	}
	
	/**
	 * Setter method for property <tt>electricaldowntiltcell1</tt>.
	 * 
	 * @param electricaldowntiltcell1 value to be assigned to property electricaldowntiltcell1
     */
	public void setElectricaldowntiltcell1(Integer electricaldowntiltcell1) {
		this.electricaldowntiltcell1 = electricaldowntiltcell1;
	}

    /**
     * Getter method for property <tt>electricaldowntiltcell2</tt>.
     *
     * @return property value of electricaldowntiltcell2
     */
	public Integer getElectricaldowntiltcell2() {
		return electricaldowntiltcell2;
	}
	
	/**
	 * Setter method for property <tt>electricaldowntiltcell2</tt>.
	 * 
	 * @param electricaldowntiltcell2 value to be assigned to property electricaldowntiltcell2
     */
	public void setElectricaldowntiltcell2(Integer electricaldowntiltcell2) {
		this.electricaldowntiltcell2 = electricaldowntiltcell2;
	}

    /**
     * Getter method for property <tt>electricaldowntiltcell3</tt>.
     *
     * @return property value of electricaldowntiltcell3
     */
	public Integer getElectricaldowntiltcell3() {
		return electricaldowntiltcell3;
	}
	
	/**
	 * Setter method for property <tt>electricaldowntiltcell3</tt>.
	 * 
	 * @param electricaldowntiltcell3 value to be assigned to property electricaldowntiltcell3
     */
	public void setElectricaldowntiltcell3(Integer electricaldowntiltcell3) {
		this.electricaldowntiltcell3 = electricaldowntiltcell3;
	}

    /**
     * Getter method for property <tt>ischecktype</tt>.
     *
     * @return property value of ischecktype
     */
	public String getIschecktype() {
		return ischecktype;
	}
	
	/**
	 * Setter method for property <tt>ischecktype</tt>.
	 * 
	 * @param ischecktype value to be assigned to property ischecktype
     */
	public void setIschecktype(String ischecktype) {
		this.ischecktype = ischecktype;
	}

    /**
     * Getter method for property <tt>netgrname</tt>.
     *
     * @return property value of netgrname
     */
	public String getNetgrname() {
		return netgrname;
	}
	
	/**
	 * Setter method for property <tt>netgrname</tt>.
	 * 
	 * @param netgrname value to be assigned to property netgrname
     */
	public void setNetgrname(String netgrname) {
		this.netgrname = netgrname;
	}
}
