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
 * A data object class directly models database table <tt>MB_SYS_LTECELL_INFO_T</tt>.
 *
 *
 * @author gaoqs
 */
public class MbSysLtecellInfoTDO {
    private static final long serialVersionUID = 741231858441822688L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>INT_ID</tt>.
	 */
	private String intId;

	/**
	 * This property corresponds to db column <tt>OBJECT_RDN</tt>.
	 */
	private String objectRdn;

	/**
	 * This property corresponds to db column <tt>NAME</tt>.
	 */
	private String name;

	/**
	 * This property corresponds to db column <tt>ZH_NAME</tt>.
	 */
	private String zhName;

	/**
	 * This property corresponds to db column <tt>OMC_ID</tt>.
	 */
	private Integer omcId;

	/**
	 * This property corresponds to db column <tt>VENDOR_ID</tt>.
	 */
	private String vendorId;

	/**
	 * This property corresponds to db column <tt>CITY_ID</tt>.
	 */
	private String cityId;

	/**
	 * This property corresponds to db column <tt>TIME_STAMP</tt>.
	 */
	private Date timeStamp;

	/**
	 * This property corresponds to db column <tt>UPDATE_STAMP</tt>.
	 */
	private Date updateStamp;

	/**
	 * This property corresponds to db column <tt>CONFIRMED</tt>.
	 */
	private String confirmed;

	/**
	 * This property corresponds to db column <tt>STATE</tt>.
	 */
	private String state;

	/**
	 * This property corresponds to db column <tt>RELATED_ENODEB</tt>.
	 */
	private String relatedEnodeb;

	/**
	 * This property corresponds to db column <tt>CGI</tt>.
	 */
	private String cgi;

	/**
	 * This property corresponds to db column <tt>EUTRANCELL_ID</tt>.
	 */
	private String eutrancellId;

	/**
	 * This property corresponds to db column <tt>CELL_IDENTITY</tt>.
	 */
	private Integer cellIdentity;

	/**
	 * This property corresponds to db column <tt>CELL_TYPE</tt>.
	 */
	private String cellType;

	/**
	 * This property corresponds to db column <tt>CELLSIZE</tt>.
	 */
	private String cellsize;

	/**
	 * This property corresponds to db column <tt>PLMNIDLIST</tt>.
	 */
	private String plmnidlist;

	/**
	 * This property corresponds to db column <tt>TAC</tt>.
	 */
	private Integer tac;

	/**
	 * This property corresponds to db column <tt>PCI</tt>.
	 */
	private Integer pci;

	/**
	 * This property corresponds to db column <tt>PCILIST</tt>.
	 */
	private String pcilist;

	/**
	 * This property corresponds to db column <tt>MAXIMUMTRANSMISSIONPOWER</tt>.
	 */
	private Float maximumtransmissionpower;

	/**
	 * This property corresponds to db column <tt>REFERENCESIGNALPOWER</tt>.
	 */
	private Float referencesignalpower;

	/**
	 * This property corresponds to db column <tt>PB</tt>.
	 */
	private Float pb;

	/**
	 * This property corresponds to db column <tt>PART_OF_SECTORPOWER</tt>.
	 */
	private Float partOfSectorpower;

	/**
	 * This property corresponds to db column <tt>ADMINISTRATIVESTATE</tt>.
	 */
	private Integer administrativestate;

	/**
	 * This property corresponds to db column <tt>OPERATIONALSTATE</tt>.
	 */
	private Integer operationalstate;

	/**
	 * This property corresponds to db column <tt>CELLLOCALID</tt>.
	 */
	private Integer celllocalid;

	/**
	 * This property corresponds to db column <tt>RELATEDRRULIST</tt>.
	 */
	private String relatedrrulist;

	/**
	 * This property corresponds to db column <tt>RELATEDANTENNALIST</tt>.
	 */
	private String relatedantennalist;

	/**
	 * This property corresponds to db column <tt>CELLRESVINFO</tt>.
	 */
	private String cellresvinfo;

	/**
	 * This property corresponds to db column <tt>BANDINDICATOR</tt>.
	 */
	private Integer bandindicator;

	/**
	 * This property corresponds to db column <tt>EARFCN</tt>.
	 */
	private Integer earfcn;

	/**
	 * This property corresponds to db column <tt>BANDWIDTH</tt>.
	 */
	private Integer bandwidth;

	/**
	 * This property corresponds to db column <tt>SFASSIGNMENT</tt>.
	 */
	private Integer sfassignment;

	/**
	 * This property corresponds to db column <tt>SPECIALSFPATTERNS</tt>.
	 */
	private Integer specialsfpatterns;

	/**
	 * This property corresponds to db column <tt>MBMSSWITCH</tt>.
	 */
	private Integer mbmsswitch;

	/**
	 * This property corresponds to db column <tt>ADJ_TD_NUM</tt>.
	 */
	private Integer adjTdNum;

	/**
	 * This property corresponds to db column <tt>ADJ_LTE_NUM</tt>.
	 */
	private Integer adjLteNum;

	/**
	 * This property corresponds to db column <tt>ADJ_GSM_NUM</tt>.
	 */
	private Integer adjGsmNum;

	/**
	 * This property corresponds to db column <tt>U_SF_NUM</tt>.
	 */
	private Integer USfNum;

	/**
	 * This property corresponds to db column <tt>D_SF_NUM</tt>.
	 */
	private Integer DSfNum;

	/**
	 * This property corresponds to db column <tt>TOTALPRB</tt>.
	 */
	private Integer totalprb;

	/**
	 * This property corresponds to db column <tt>ECARRIER_NUM</tt>.
	 */
	private Integer ecarrierNum;

	/**
	 * This property corresponds to db column <tt>DWPTS_OVER_9</tt>.
	 */
	private Integer dwptsOver9;

	/**
	 * This property corresponds to db column <tt>ADJ_LTE_FRQLST</tt>.
	 */
	private String adjLteFrqlst;

	/**
	 * This property corresponds to db column <tt>ADJ_TD_FRQLST</tt>.
	 */
	private String adjTdFrqlst;

	/**
	 * This property corresponds to db column <tt>ADJ_GSM_FRQLST</tt>.
	 */
	private String adjGsmFrqlst;

	/**
	 * This property corresponds to db column <tt>CELL_GLB_ID</tt>.
	 */
	private String cellGlbId;

	/**
	 * This property corresponds to db column <tt>RECORD_TIME</tt>.
	 */
	private Date recordTime;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>intId</tt>.
     *
     * @return property value of intId
     */
	public String getIntId() {
		return intId;
	}
	
	/**
	 * Setter method for property <tt>intId</tt>.
	 * 
	 * @param intId value to be assigned to property intId
     */
	public void setIntId(String intId) {
		this.intId = intId;
	}

    /**
     * Getter method for property <tt>objectRdn</tt>.
     *
     * @return property value of objectRdn
     */
	public String getObjectRdn() {
		return objectRdn;
	}
	
	/**
	 * Setter method for property <tt>objectRdn</tt>.
	 * 
	 * @param objectRdn value to be assigned to property objectRdn
     */
	public void setObjectRdn(String objectRdn) {
		this.objectRdn = objectRdn;
	}

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter method for property <tt>name</tt>.
	 * 
	 * @param name value to be assigned to property name
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * Getter method for property <tt>zhName</tt>.
     *
     * @return property value of zhName
     */
	public String getZhName() {
		return zhName;
	}
	
	/**
	 * Setter method for property <tt>zhName</tt>.
	 * 
	 * @param zhName value to be assigned to property zhName
     */
	public void setZhName(String zhName) {
		this.zhName = zhName;
	}

    /**
     * Getter method for property <tt>omcId</tt>.
     *
     * @return property value of omcId
     */
	public Integer getOmcId() {
		return omcId;
	}
	
	/**
	 * Setter method for property <tt>omcId</tt>.
	 * 
	 * @param omcId value to be assigned to property omcId
     */
	public void setOmcId(Integer omcId) {
		this.omcId = omcId;
	}

    /**
     * Getter method for property <tt>vendorId</tt>.
     *
     * @return property value of vendorId
     */
	public String getVendorId() {
		return vendorId;
	}
	
	/**
	 * Setter method for property <tt>vendorId</tt>.
	 * 
	 * @param vendorId value to be assigned to property vendorId
     */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

    /**
     * Getter method for property <tt>cityId</tt>.
     *
     * @return property value of cityId
     */
	public String getCityId() {
		return cityId;
	}
	
	/**
	 * Setter method for property <tt>cityId</tt>.
	 * 
	 * @param cityId value to be assigned to property cityId
     */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

    /**
     * Getter method for property <tt>timeStamp</tt>.
     *
     * @return property value of timeStamp
     */
	public Date getTimeStamp() {
		return timeStamp;
	}
	
	/**
	 * Setter method for property <tt>timeStamp</tt>.
	 * 
	 * @param timeStamp value to be assigned to property timeStamp
     */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

    /**
     * Getter method for property <tt>updateStamp</tt>.
     *
     * @return property value of updateStamp
     */
	public Date getUpdateStamp() {
		return updateStamp;
	}
	
	/**
	 * Setter method for property <tt>updateStamp</tt>.
	 * 
	 * @param updateStamp value to be assigned to property updateStamp
     */
	public void setUpdateStamp(Date updateStamp) {
		this.updateStamp = updateStamp;
	}

    /**
     * Getter method for property <tt>confirmed</tt>.
     *
     * @return property value of confirmed
     */
	public String getConfirmed() {
		return confirmed;
	}
	
	/**
	 * Setter method for property <tt>confirmed</tt>.
	 * 
	 * @param confirmed value to be assigned to property confirmed
     */
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

    /**
     * Getter method for property <tt>state</tt>.
     *
     * @return property value of state
     */
	public String getState() {
		return state;
	}
	
	/**
	 * Setter method for property <tt>state</tt>.
	 * 
	 * @param state value to be assigned to property state
     */
	public void setState(String state) {
		this.state = state;
	}

    /**
     * Getter method for property <tt>relatedEnodeb</tt>.
     *
     * @return property value of relatedEnodeb
     */
	public String getRelatedEnodeb() {
		return relatedEnodeb;
	}
	
	/**
	 * Setter method for property <tt>relatedEnodeb</tt>.
	 * 
	 * @param relatedEnodeb value to be assigned to property relatedEnodeb
     */
	public void setRelatedEnodeb(String relatedEnodeb) {
		this.relatedEnodeb = relatedEnodeb;
	}

    /**
     * Getter method for property <tt>cgi</tt>.
     *
     * @return property value of cgi
     */
	public String getCgi() {
		return cgi;
	}
	
	/**
	 * Setter method for property <tt>cgi</tt>.
	 * 
	 * @param cgi value to be assigned to property cgi
     */
	public void setCgi(String cgi) {
		this.cgi = cgi;
	}

    /**
     * Getter method for property <tt>eutrancellId</tt>.
     *
     * @return property value of eutrancellId
     */
	public String getEutrancellId() {
		return eutrancellId;
	}
	
	/**
	 * Setter method for property <tt>eutrancellId</tt>.
	 * 
	 * @param eutrancellId value to be assigned to property eutrancellId
     */
	public void setEutrancellId(String eutrancellId) {
		this.eutrancellId = eutrancellId;
	}

    /**
     * Getter method for property <tt>cellIdentity</tt>.
     *
     * @return property value of cellIdentity
     */
	public Integer getCellIdentity() {
		return cellIdentity;
	}
	
	/**
	 * Setter method for property <tt>cellIdentity</tt>.
	 * 
	 * @param cellIdentity value to be assigned to property cellIdentity
     */
	public void setCellIdentity(Integer cellIdentity) {
		this.cellIdentity = cellIdentity;
	}

    /**
     * Getter method for property <tt>cellType</tt>.
     *
     * @return property value of cellType
     */
	public String getCellType() {
		return cellType;
	}
	
	/**
	 * Setter method for property <tt>cellType</tt>.
	 * 
	 * @param cellType value to be assigned to property cellType
     */
	public void setCellType(String cellType) {
		this.cellType = cellType;
	}

    /**
     * Getter method for property <tt>cellsize</tt>.
     *
     * @return property value of cellsize
     */
	public String getCellsize() {
		return cellsize;
	}
	
	/**
	 * Setter method for property <tt>cellsize</tt>.
	 * 
	 * @param cellsize value to be assigned to property cellsize
     */
	public void setCellsize(String cellsize) {
		this.cellsize = cellsize;
	}

    /**
     * Getter method for property <tt>plmnidlist</tt>.
     *
     * @return property value of plmnidlist
     */
	public String getPlmnidlist() {
		return plmnidlist;
	}
	
	/**
	 * Setter method for property <tt>plmnidlist</tt>.
	 * 
	 * @param plmnidlist value to be assigned to property plmnidlist
     */
	public void setPlmnidlist(String plmnidlist) {
		this.plmnidlist = plmnidlist;
	}

    /**
     * Getter method for property <tt>tac</tt>.
     *
     * @return property value of tac
     */
	public Integer getTac() {
		return tac;
	}
	
	/**
	 * Setter method for property <tt>tac</tt>.
	 * 
	 * @param tac value to be assigned to property tac
     */
	public void setTac(Integer tac) {
		this.tac = tac;
	}

    /**
     * Getter method for property <tt>pci</tt>.
     *
     * @return property value of pci
     */
	public Integer getPci() {
		return pci;
	}
	
	/**
	 * Setter method for property <tt>pci</tt>.
	 * 
	 * @param pci value to be assigned to property pci
     */
	public void setPci(Integer pci) {
		this.pci = pci;
	}

    /**
     * Getter method for property <tt>pcilist</tt>.
     *
     * @return property value of pcilist
     */
	public String getPcilist() {
		return pcilist;
	}
	
	/**
	 * Setter method for property <tt>pcilist</tt>.
	 * 
	 * @param pcilist value to be assigned to property pcilist
     */
	public void setPcilist(String pcilist) {
		this.pcilist = pcilist;
	}

    /**
     * Getter method for property <tt>maximumtransmissionpower</tt>.
     *
     * @return property value of maximumtransmissionpower
     */
	public Float getMaximumtransmissionpower() {
		return maximumtransmissionpower;
	}
	
	/**
	 * Setter method for property <tt>maximumtransmissionpower</tt>.
	 * 
	 * @param maximumtransmissionpower value to be assigned to property maximumtransmissionpower
     */
	public void setMaximumtransmissionpower(Float maximumtransmissionpower) {
		this.maximumtransmissionpower = maximumtransmissionpower;
	}

    /**
     * Getter method for property <tt>referencesignalpower</tt>.
     *
     * @return property value of referencesignalpower
     */
	public Float getReferencesignalpower() {
		return referencesignalpower;
	}
	
	/**
	 * Setter method for property <tt>referencesignalpower</tt>.
	 * 
	 * @param referencesignalpower value to be assigned to property referencesignalpower
     */
	public void setReferencesignalpower(Float referencesignalpower) {
		this.referencesignalpower = referencesignalpower;
	}

    /**
     * Getter method for property <tt>pb</tt>.
     *
     * @return property value of pb
     */
	public Float getPb() {
		return pb;
	}
	
	/**
	 * Setter method for property <tt>pb</tt>.
	 * 
	 * @param pb value to be assigned to property pb
     */
	public void setPb(Float pb) {
		this.pb = pb;
	}

    /**
     * Getter method for property <tt>partOfSectorpower</tt>.
     *
     * @return property value of partOfSectorpower
     */
	public Float getPartOfSectorpower() {
		return partOfSectorpower;
	}
	
	/**
	 * Setter method for property <tt>partOfSectorpower</tt>.
	 * 
	 * @param partOfSectorpower value to be assigned to property partOfSectorpower
     */
	public void setPartOfSectorpower(Float partOfSectorpower) {
		this.partOfSectorpower = partOfSectorpower;
	}

    /**
     * Getter method for property <tt>administrativestate</tt>.
     *
     * @return property value of administrativestate
     */
	public Integer getAdministrativestate() {
		return administrativestate;
	}
	
	/**
	 * Setter method for property <tt>administrativestate</tt>.
	 * 
	 * @param administrativestate value to be assigned to property administrativestate
     */
	public void setAdministrativestate(Integer administrativestate) {
		this.administrativestate = administrativestate;
	}

    /**
     * Getter method for property <tt>operationalstate</tt>.
     *
     * @return property value of operationalstate
     */
	public Integer getOperationalstate() {
		return operationalstate;
	}
	
	/**
	 * Setter method for property <tt>operationalstate</tt>.
	 * 
	 * @param operationalstate value to be assigned to property operationalstate
     */
	public void setOperationalstate(Integer operationalstate) {
		this.operationalstate = operationalstate;
	}

    /**
     * Getter method for property <tt>celllocalid</tt>.
     *
     * @return property value of celllocalid
     */
	public Integer getCelllocalid() {
		return celllocalid;
	}
	
	/**
	 * Setter method for property <tt>celllocalid</tt>.
	 * 
	 * @param celllocalid value to be assigned to property celllocalid
     */
	public void setCelllocalid(Integer celllocalid) {
		this.celllocalid = celllocalid;
	}

    /**
     * Getter method for property <tt>relatedrrulist</tt>.
     *
     * @return property value of relatedrrulist
     */
	public String getRelatedrrulist() {
		return relatedrrulist;
	}
	
	/**
	 * Setter method for property <tt>relatedrrulist</tt>.
	 * 
	 * @param relatedrrulist value to be assigned to property relatedrrulist
     */
	public void setRelatedrrulist(String relatedrrulist) {
		this.relatedrrulist = relatedrrulist;
	}

    /**
     * Getter method for property <tt>relatedantennalist</tt>.
     *
     * @return property value of relatedantennalist
     */
	public String getRelatedantennalist() {
		return relatedantennalist;
	}
	
	/**
	 * Setter method for property <tt>relatedantennalist</tt>.
	 * 
	 * @param relatedantennalist value to be assigned to property relatedantennalist
     */
	public void setRelatedantennalist(String relatedantennalist) {
		this.relatedantennalist = relatedantennalist;
	}

    /**
     * Getter method for property <tt>cellresvinfo</tt>.
     *
     * @return property value of cellresvinfo
     */
	public String getCellresvinfo() {
		return cellresvinfo;
	}
	
	/**
	 * Setter method for property <tt>cellresvinfo</tt>.
	 * 
	 * @param cellresvinfo value to be assigned to property cellresvinfo
     */
	public void setCellresvinfo(String cellresvinfo) {
		this.cellresvinfo = cellresvinfo;
	}

    /**
     * Getter method for property <tt>bandindicator</tt>.
     *
     * @return property value of bandindicator
     */
	public Integer getBandindicator() {
		return bandindicator;
	}
	
	/**
	 * Setter method for property <tt>bandindicator</tt>.
	 * 
	 * @param bandindicator value to be assigned to property bandindicator
     */
	public void setBandindicator(Integer bandindicator) {
		this.bandindicator = bandindicator;
	}

    /**
     * Getter method for property <tt>earfcn</tt>.
     *
     * @return property value of earfcn
     */
	public Integer getEarfcn() {
		return earfcn;
	}
	
	/**
	 * Setter method for property <tt>earfcn</tt>.
	 * 
	 * @param earfcn value to be assigned to property earfcn
     */
	public void setEarfcn(Integer earfcn) {
		this.earfcn = earfcn;
	}

    /**
     * Getter method for property <tt>bandwidth</tt>.
     *
     * @return property value of bandwidth
     */
	public Integer getBandwidth() {
		return bandwidth;
	}
	
	/**
	 * Setter method for property <tt>bandwidth</tt>.
	 * 
	 * @param bandwidth value to be assigned to property bandwidth
     */
	public void setBandwidth(Integer bandwidth) {
		this.bandwidth = bandwidth;
	}

    /**
     * Getter method for property <tt>sfassignment</tt>.
     *
     * @return property value of sfassignment
     */
	public Integer getSfassignment() {
		return sfassignment;
	}
	
	/**
	 * Setter method for property <tt>sfassignment</tt>.
	 * 
	 * @param sfassignment value to be assigned to property sfassignment
     */
	public void setSfassignment(Integer sfassignment) {
		this.sfassignment = sfassignment;
	}

    /**
     * Getter method for property <tt>specialsfpatterns</tt>.
     *
     * @return property value of specialsfpatterns
     */
	public Integer getSpecialsfpatterns() {
		return specialsfpatterns;
	}
	
	/**
	 * Setter method for property <tt>specialsfpatterns</tt>.
	 * 
	 * @param specialsfpatterns value to be assigned to property specialsfpatterns
     */
	public void setSpecialsfpatterns(Integer specialsfpatterns) {
		this.specialsfpatterns = specialsfpatterns;
	}

    /**
     * Getter method for property <tt>mbmsswitch</tt>.
     *
     * @return property value of mbmsswitch
     */
	public Integer getMbmsswitch() {
		return mbmsswitch;
	}
	
	/**
	 * Setter method for property <tt>mbmsswitch</tt>.
	 * 
	 * @param mbmsswitch value to be assigned to property mbmsswitch
     */
	public void setMbmsswitch(Integer mbmsswitch) {
		this.mbmsswitch = mbmsswitch;
	}

    /**
     * Getter method for property <tt>adjTdNum</tt>.
     *
     * @return property value of adjTdNum
     */
	public Integer getAdjTdNum() {
		return adjTdNum;
	}
	
	/**
	 * Setter method for property <tt>adjTdNum</tt>.
	 * 
	 * @param adjTdNum value to be assigned to property adjTdNum
     */
	public void setAdjTdNum(Integer adjTdNum) {
		this.adjTdNum = adjTdNum;
	}

    /**
     * Getter method for property <tt>adjLteNum</tt>.
     *
     * @return property value of adjLteNum
     */
	public Integer getAdjLteNum() {
		return adjLteNum;
	}
	
	/**
	 * Setter method for property <tt>adjLteNum</tt>.
	 * 
	 * @param adjLteNum value to be assigned to property adjLteNum
     */
	public void setAdjLteNum(Integer adjLteNum) {
		this.adjLteNum = adjLteNum;
	}

    /**
     * Getter method for property <tt>adjGsmNum</tt>.
     *
     * @return property value of adjGsmNum
     */
	public Integer getAdjGsmNum() {
		return adjGsmNum;
	}
	
	/**
	 * Setter method for property <tt>adjGsmNum</tt>.
	 * 
	 * @param adjGsmNum value to be assigned to property adjGsmNum
     */
	public void setAdjGsmNum(Integer adjGsmNum) {
		this.adjGsmNum = adjGsmNum;
	}

    /**
     * Getter method for property <tt>USfNum</tt>.
     *
     * @return property value of USfNum
     */
	public Integer getUSfNum() {
		return USfNum;
	}
	
	/**
	 * Setter method for property <tt>USfNum</tt>.
	 * 
	 * @param USfNum value to be assigned to property USfNum
     */
	public void setUSfNum(Integer USfNum) {
		this.USfNum = USfNum;
	}

    /**
     * Getter method for property <tt>DSfNum</tt>.
     *
     * @return property value of DSfNum
     */
	public Integer getDSfNum() {
		return DSfNum;
	}
	
	/**
	 * Setter method for property <tt>DSfNum</tt>.
	 * 
	 * @param DSfNum value to be assigned to property DSfNum
     */
	public void setDSfNum(Integer DSfNum) {
		this.DSfNum = DSfNum;
	}

    /**
     * Getter method for property <tt>totalprb</tt>.
     *
     * @return property value of totalprb
     */
	public Integer getTotalprb() {
		return totalprb;
	}
	
	/**
	 * Setter method for property <tt>totalprb</tt>.
	 * 
	 * @param totalprb value to be assigned to property totalprb
     */
	public void setTotalprb(Integer totalprb) {
		this.totalprb = totalprb;
	}

    /**
     * Getter method for property <tt>ecarrierNum</tt>.
     *
     * @return property value of ecarrierNum
     */
	public Integer getEcarrierNum() {
		return ecarrierNum;
	}
	
	/**
	 * Setter method for property <tt>ecarrierNum</tt>.
	 * 
	 * @param ecarrierNum value to be assigned to property ecarrierNum
     */
	public void setEcarrierNum(Integer ecarrierNum) {
		this.ecarrierNum = ecarrierNum;
	}

    /**
     * Getter method for property <tt>dwptsOver9</tt>.
     *
     * @return property value of dwptsOver9
     */
	public Integer getDwptsOver9() {
		return dwptsOver9;
	}
	
	/**
	 * Setter method for property <tt>dwptsOver9</tt>.
	 * 
	 * @param dwptsOver9 value to be assigned to property dwptsOver9
     */
	public void setDwptsOver9(Integer dwptsOver9) {
		this.dwptsOver9 = dwptsOver9;
	}

    /**
     * Getter method for property <tt>adjLteFrqlst</tt>.
     *
     * @return property value of adjLteFrqlst
     */
	public String getAdjLteFrqlst() {
		return adjLteFrqlst;
	}
	
	/**
	 * Setter method for property <tt>adjLteFrqlst</tt>.
	 * 
	 * @param adjLteFrqlst value to be assigned to property adjLteFrqlst
     */
	public void setAdjLteFrqlst(String adjLteFrqlst) {
		this.adjLteFrqlst = adjLteFrqlst;
	}

    /**
     * Getter method for property <tt>adjTdFrqlst</tt>.
     *
     * @return property value of adjTdFrqlst
     */
	public String getAdjTdFrqlst() {
		return adjTdFrqlst;
	}
	
	/**
	 * Setter method for property <tt>adjTdFrqlst</tt>.
	 * 
	 * @param adjTdFrqlst value to be assigned to property adjTdFrqlst
     */
	public void setAdjTdFrqlst(String adjTdFrqlst) {
		this.adjTdFrqlst = adjTdFrqlst;
	}

    /**
     * Getter method for property <tt>adjGsmFrqlst</tt>.
     *
     * @return property value of adjGsmFrqlst
     */
	public String getAdjGsmFrqlst() {
		return adjGsmFrqlst;
	}
	
	/**
	 * Setter method for property <tt>adjGsmFrqlst</tt>.
	 * 
	 * @param adjGsmFrqlst value to be assigned to property adjGsmFrqlst
     */
	public void setAdjGsmFrqlst(String adjGsmFrqlst) {
		this.adjGsmFrqlst = adjGsmFrqlst;
	}

    /**
     * Getter method for property <tt>cellGlbId</tt>.
     *
     * @return property value of cellGlbId
     */
	public String getCellGlbId() {
		return cellGlbId;
	}
	
	/**
	 * Setter method for property <tt>cellGlbId</tt>.
	 * 
	 * @param cellGlbId value to be assigned to property cellGlbId
     */
	public void setCellGlbId(String cellGlbId) {
		this.cellGlbId = cellGlbId;
	}

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
}
