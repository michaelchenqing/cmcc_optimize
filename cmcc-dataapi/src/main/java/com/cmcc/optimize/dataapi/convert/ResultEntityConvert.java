/**  
 * Convert.java
 * convert
 * 
 * @author gaoqs
 * @date 2014年6月30日 上午10:34:54
 * 版权所有
 */
package com.cmcc.optimize.dataapi.convert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cmcc.optimize.dataaccess.dao.dataobject.MbOmcLoLaDO;
import com.cmcc.optimize.dataaccess.dao.dataobject.MbPlanLtecellInfoDO;
import com.cmcc.optimize.dataaccess.dao.dataobject.MbPlanLtesiteInfoDO;
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellInfoDO;
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtecellInfoTDO;
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtesiteInfoTDO;
import com.cmcc.optimize.dataaccess.dao.dataobject.MbSysLtesiteParamDO;
import com.cmcc.optimize.dataapi.entity.CellInfoEntity;
import com.cmcc.optimize.dataapi.entity.EnbInfoEntity;
import com.cmcc.optimize.dataapi.entity.OmcLoLaEntity;
import com.cmcc.optimize.dataapi.entity.PlanEnbParameterEntity;
import com.cmcc.optimize.dataapi.entity.PlanLteCellEntity;
import com.cmcc.optimize.dataapi.entity.PlanParameterEntity;
import com.cmcc.optimize.datamodel.paging.PageList;

/**
 * 数据库do转实体entity
 * 
 * @author gaoqs
 * @date 2014年6月30日 上午10:34:54
 */

public class ResultEntityConvert {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");// 时间转换

    /**
     * 小区信息DO转换成Entity
     * 
     * @param infoDo do对象
     * @return　entity对象
     */
    public static CellInfoEntity cellInfoConvert(MbSysLtecellInfoDO infoDo) {
        if (infoDo == null) {
            return null;
        }
        CellInfoEntity cellInfoEntity = new CellInfoEntity();
        cellInfoEntity.setCgi(infoDo.getCgi() == null ? null : infoDo.getCgi());
        cellInfoEntity.setChname(infoDo.getCellName() == null ? null : infoDo.getCellName());
        cellInfoEntity.setEnbid(infoDo.getEnodebGlbId() == null ? null : infoDo.getEnodebGlbId().toString());
        cellInfoEntity.setEnname(infoDo.getCellEnglishName() == null ? null : infoDo.getCellEnglishName());
        cellInfoEntity.setTs(infoDo.getUpdateTime() == null ? null : sdf.format(infoDo.getUpdateTime()));
        return cellInfoEntity;
    }

    /**
     * 小区信息DO转换成Entity 临时的 后续可能会删除
     * 
     * @param infoDo do对象
     * @return　entity对象
     */
    public static CellInfoEntity cellInfoConvert(MbSysLtecellInfoTDO infoDo) {
        if (infoDo == null) {
            return null;
        }
        CellInfoEntity cellInfoEntity = new CellInfoEntity();
        cellInfoEntity.setCgi(infoDo.getCgi() == null ? null : infoDo.getCgi());
        cellInfoEntity.setChname(infoDo.getZhName() == null ? null : infoDo.getZhName());
        cellInfoEntity.setEnbid(infoDo.getRelatedEnodeb() == null ? null : infoDo.getRelatedEnodeb());
        cellInfoEntity.setEnname(infoDo.getName() == null ? null : infoDo.getName());
        cellInfoEntity.setTs(infoDo.getRecordTime() == null ? null : sdf.format(infoDo.getRecordTime()));
        cellInfoEntity.setCity(infoDo.getCityId() == null ? null : infoDo.getCityId());
        cellInfoEntity.setCid(infoDo.getIntId() == null ? null : infoDo.getIntId());
        cellInfoEntity.setOpestate(infoDo.getOperationalstate());
        cellInfoEntity.setVid(infoDo.getVendorId()==null?null:infoDo.getVendorId());
        return cellInfoEntity;
    }

    /**
     * 规划工参DO转换成Entity
     * 
     * @param planLtesiteInfoDO do对象
     * @return　entity对象
     */
    public static PlanEnbParameterEntity planEnbParameterConvert(MbPlanLtesiteInfoDO planLtesiteInfoDO) {
        if (planLtesiteInfoDO == null) {
            return null;
        }
        PlanEnbParameterEntity parameterEntity = new PlanEnbParameterEntity();
        parameterEntity.setName(planLtesiteInfoDO.getPenodebname() == null ? null : planLtesiteInfoDO.getPenodebname());
        parameterEntity.setCity(planLtesiteInfoDO.getCityName() == null ? null : planLtesiteInfoDO.getCityName());
        parameterEntity.setTown(planLtesiteInfoDO.getPenodebid() == null ? null : planLtesiteInfoDO.getPenodebid());
        parameterEntity.setLon(planLtesiteInfoDO.getLongitude());
        parameterEntity.setLat(planLtesiteInfoDO.getLatitude());
        parameterEntity.setEnbtype(planLtesiteInfoDO.getCoveragecharacter() == null ? null : planLtesiteInfoDO.getCoveragecharacter());
        parameterEntity.setPhase(planLtesiteInfoDO.getProjectphase() == null ? null : planLtesiteInfoDO.getProjectphase());
        parameterEntity.setFrequency(planLtesiteInfoDO.getWorkFrqband() == null ? null : planLtesiteInfoDO.getWorkFrqband());
        parameterEntity.setCname(planLtesiteInfoDO.getIsnodebname() == null ? null : planLtesiteInfoDO.getIsnodebname());
        parameterEntity.setH1(planLtesiteInfoDO.getHeightcell1());
        parameterEntity.setH2(planLtesiteInfoDO.getHeightcell2());
        parameterEntity.setH3(planLtesiteInfoDO.getHeightcell3());
        parameterEntity.setEtilt1(planLtesiteInfoDO.getElectricaldowntiltcell1());
        parameterEntity.setEtilt2(planLtesiteInfoDO.getElectricaldowntiltcell2());
        parameterEntity.setEtilt3(planLtesiteInfoDO.getElectricaldowntiltcell3());
        parameterEntity.setAzimuth1(planLtesiteInfoDO.getAzimuthcell1());
        parameterEntity.setAzimuth2(planLtesiteInfoDO.getAzimuthcell2());
        parameterEntity.setAzimuth3(planLtesiteInfoDO.getAzimuthcell3());
        parameterEntity.setDtilt1(planLtesiteInfoDO.getDowntiltcell1());
        parameterEntity.setDtilt2(planLtesiteInfoDO.getDowntiltcell2());
        parameterEntity.setDtilt3(planLtesiteInfoDO.getDowntiltcell3());
        parameterEntity.setTs(planLtesiteInfoDO.getRecordTime() == null ? null : sdf.format(planLtesiteInfoDO.getRecordTime()));
        parameterEntity.setPenbid(planLtesiteInfoDO.getPenodebid() == null ? null : planLtesiteInfoDO.getPenodebid());
        parameterEntity.setRegiontype(planLtesiteInfoDO.getRegiontype() == null ? null : planLtesiteInfoDO.getRegiontype());
        parameterEntity.setTown(planLtesiteInfoDO.getCountryName() == null ? null : planLtesiteInfoDO.getCountryName());
        return parameterEntity;
    }

    /**
     * 基站信息DO转换成Entity
     * 
     * @param ltesiteParamDO do对象
     * @return　entity对象
     */
    public static EnbInfoEntity enbInfoConvert(MbSysLtesiteParamDO ltesiteParamDO) {
        if (ltesiteParamDO == null) {
            return null;
        }
        EnbInfoEntity enbInfoEntity = new EnbInfoEntity();
        enbInfoEntity.setChname(ltesiteParamDO.getEnodebName() == null ? null : ltesiteParamDO.getEnodebName());
        enbInfoEntity.setEnbid(ltesiteParamDO.getEnodebGlbId() == null ? null : ltesiteParamDO.getEnodebGlbId());
        enbInfoEntity.setEnname(ltesiteParamDO.getEnodebName() == null ? null : ltesiteParamDO.getEnodebName());// TODO
                                                                                                                // 表中没有英文名称字段：mb_sys_ltesite_param
        enbInfoEntity.setTs(ltesiteParamDO.getUpdateTime() == null ? null : sdf.format(ltesiteParamDO.getUpdateTime()));
        return enbInfoEntity;
    }

    /**
     * 基站信息DO转换成Entity
     * 
     * @param ltesiteParamDO do对象
     * @return　entity对象
     */
    public static EnbInfoEntity enbInfoConvert(MbSysLtesiteInfoTDO ltesiteParamDO) {
        if (ltesiteParamDO == null) {
            return null;
        }
        EnbInfoEntity enbInfoEntity = new EnbInfoEntity();
        enbInfoEntity.setChname(ltesiteParamDO.getZhName() == null ? null : ltesiteParamDO.getZhName());
        enbInfoEntity.setEnbid(ltesiteParamDO.getIntId() == null ? null : ltesiteParamDO.getIntId());
        enbInfoEntity.setEnname(ltesiteParamDO.getName() == null ? null : ltesiteParamDO.getName());// TODO
        // 表中没有英文名称字段：mb_sys_ltesite_param
        enbInfoEntity.setTs(ltesiteParamDO.getRecordTime() == null ? null : sdf.format(ltesiteParamDO.getRecordTime()));
        enbInfoEntity.setCity(ltesiteParamDO.getCityId() == null ? null : ltesiteParamDO.getCityId());

        return enbInfoEntity;
    }

    /**
     * 基站信息　将pagelist:MbSysLtesiteParamDO成list
     * 
     * @param dos do分页对象
     * @return
     */
    public static List<EnbInfoEntity> enbInfoConvertWithList(PageList dos) {
        if (dos == null || dos.size() <= 0) {
            return null;
        }

        List<EnbInfoEntity> list = new ArrayList<EnbInfoEntity>();
        for (Object object : dos) {
            MbSysLtesiteParamDO doObj = (MbSysLtesiteParamDO) object;
            list.add(enbInfoConvert(doObj));
        }
        return list;
    }

    /**
     * 基站信息　将pagelist:MbSysLtesiteParamDO成list
     * 
     * @param dos do分页对象
     * @return
     */
    public static List<EnbInfoEntity> enbInfoTConvertWithList(PageList dos) {
        if (dos == null || dos.size() <= 0) {
            return null;
        }

        List<EnbInfoEntity> list = new ArrayList<EnbInfoEntity>();
        for (Object object : dos) {
            MbSysLtesiteInfoTDO doObj = (MbSysLtesiteInfoTDO) object;
            list.add(enbInfoConvert(doObj));
        }
        return list;
    }

    /**
     * 规划工参　将pagelist:MbPlanLtesiteInfoDO转成list
     * 
     * @param dos do分页对象
     * @return
     */
    public static List<PlanEnbParameterEntity> planEnbParameterConvertWithList(PageList dos) {
        if (dos == null || dos.size() <= 0) {
            return null;
        }

        List<PlanEnbParameterEntity> list = new ArrayList<PlanEnbParameterEntity>();
        for (Object object : dos) {
            MbPlanLtesiteInfoDO doObj = (MbPlanLtesiteInfoDO) object;
            list.add(planEnbParameterConvert(doObj));
        }
        return list;
    }

    /**
     * 小区信息　将pagelist:MbSysLtecellInfoDO转成list
     * 
     * @param dos do分页对象
     * @return
     */
    public static List<CellInfoEntity> cellInfoConvertWithList(PageList dos) {
        if (dos == null || dos.size() <= 0) {
            return null;
        }

        List<CellInfoEntity> list = new ArrayList<CellInfoEntity>();
        for (Object object : dos) {
            MbSysLtecellInfoDO doObj = (MbSysLtecellInfoDO) object;
            list.add(cellInfoConvert(doObj));
        }
        return list;
    }

    /**
     * 小区信息　将pagelist:MbSysLtecellInfoDO转成list 临时的 后续可能会删除
     * 
     * @param dos do分页对象
     * @return
     */
    public static List<CellInfoEntity> cellInfoTConvertWithList(PageList dos) {
        if (dos == null || dos.size() <= 0) {
            return null;
        }

        List<CellInfoEntity> list = new ArrayList<CellInfoEntity>();
        for (Object object : dos) {
            MbSysLtecellInfoTDO doObj = (MbSysLtecellInfoTDO) object;
            list.add(cellInfoConvert(doObj));
        }
        return list;
    }

    /**
     * OMC小区经纬度　将pagelist:MbOmcLoLaDO转成list
     * 
     * @param dos do分页对象
     * @return
     */
    public static List<OmcLoLaEntity> omcLoLaConvertWithList(PageList dos) {
        if (dos == null || dos.size() <= 0) {
            return null;
        }

        List<OmcLoLaEntity> list = new ArrayList<OmcLoLaEntity>();
        for (Object object : dos) {
            MbOmcLoLaDO mbOmcLoLaDO = (MbOmcLoLaDO) object;
            list.add(omcloLaConvert(mbOmcLoLaDO));
        }
        return list;
    }

    /**
     * OMC小区经纬度DO转换成Entity
     * 
     * @param infoDo do对象
     * @return　entity对象
     */
    public static OmcLoLaEntity omcloLaConvert(MbOmcLoLaDO infoDo) {
        if (infoDo == null) {
            return null;
        }
        OmcLoLaEntity omcLoLaEntity = new OmcLoLaEntity();
        omcLoLaEntity.setCity(infoDo.getCity() == null ? null : infoDo.getCity());
        omcLoLaEntity.setEnbid(infoDo.getEnodebId() == null ? null : infoDo.getEnodebId());
        omcLoLaEntity.setEnbname(infoDo.getEnodebName() == null ? null : infoDo.getEnodebName());
        omcLoLaEntity.setLa(infoDo.getLatitude());
        omcLoLaEntity.setLo(infoDo.getLongitude());
        omcLoLaEntity.setTs(infoDo.getRecordTime()==null?null:sdf.format(infoDo.getRecordTime()));
        return omcLoLaEntity;
    }

    /**
     * 规划小区　将pagelist:MbOmcLoLaDO转成list
     * 
     * @param dos do分页对象
     * @return
     */
    public static List<PlanLteCellEntity> planLteCellConvertWithList(PageList dos) {
        if (dos == null || dos.size() <= 0) {
            return null;
        }

        List<PlanLteCellEntity> list = new ArrayList<PlanLteCellEntity>();
        for (Object object : dos) {
            MbPlanLtecellInfoDO planLtecellInfoDO = (MbPlanLtecellInfoDO) object;
            list.add(planCellConvert(planLtecellInfoDO));
        }
        return list;
    }

    /**
     * 规划小区DO转换成Entity
     * 
     * @param infoDo do对象
     * @return　entity对象
     */
    public static PlanLteCellEntity planCellConvert(MbPlanLtecellInfoDO infoDo) {
        if (infoDo == null) {
            return null;
        }
        PlanLteCellEntity planLteCellEntity = new PlanLteCellEntity();
        planLteCellEntity.setCity(infoDo.getCity() == null ? null : infoDo.getCity());
        planLteCellEntity.setTown(infoDo.getContry() == null ? null : infoDo.getContry());
        planLteCellEntity.setPcellid(infoDo.getCellId() == null ? null : infoDo.getCellId());
        planLteCellEntity.setCtype(infoDo.getCoverType() == null ? null : infoDo.getCoverType());
        planLteCellEntity.setLo(infoDo.getLongitude());
        planLteCellEntity.setLa(infoDo.getLatitude());
        planLteCellEntity.setMindis(infoDo.getMinDistance());
        planLteCellEntity.setPeriod(infoDo.getProjectphase() == null ? null : infoDo.getProjectphase());
        planLteCellEntity.setHeight(infoDo.getHigh());
        planLteCellEntity.setTs(infoDo.getRecordTime() == null ? null : sdf.format(infoDo.getRecordTime()));
        return planLteCellEntity;
    }
    /**
     * 规划工参　将pagelist:MbPlanLtesiteInfoDO转成list
     * 
     * @param dos do分页对象
     * @return
     */
    public static List<PlanParameterEntity> planParameterConvertWithList(PageList dos) {
        if (dos == null || dos.size() <= 0) {
            return null;
        }

        List<PlanParameterEntity> list = new ArrayList<PlanParameterEntity>();
        for (Object object : dos) {
            MbPlanLtesiteInfoDO doObj = (MbPlanLtesiteInfoDO) object;
            list.add(planParameterConvert(doObj));
        }
        return list;
    }

    /**
     * 规划工参DO转换成Entity
     * 
     * @param planLtesiteInfoDO do对象
     * @return　entity对象
     */
    public static PlanParameterEntity planParameterConvert(MbPlanLtesiteInfoDO infoDO) {
        if (infoDO == null) {
            return null;
        }
        PlanParameterEntity entity = new PlanParameterEntity();
        entity.setPenbclass(infoDO.getPenodebclass()==null?null:infoDO.getPenodebclass());
        entity.setPenbid(infoDO.getPenodebid());
        entity.setName(infoDO.getPenodebname());
        entity.setTac(null);
        entity.setPhase(infoDO.getProjectphase());
        entity.setProv(infoDO.getProvinceName());
        entity.setCity(infoDO.getCityName());
        entity.setTown(infoDO.getCountryName());
        entity.setLon(infoDO.getLongitude());
        entity.setLat(infoDO.getLatitude());
        entity.setMindis(null);
        entity.setCovertype(null);
        entity.setRegiontype(infoDO.getRegiontype());
        entity.setFrequency(infoDO.getWorkFrqband());
        entity.setBcheck(infoDO.getIscheck());
        entity.setBname(infoDO.getIsnodebname());
        entity.setBtype("新址新建");
        entity.setBlon(infoDO.getIschecklon());
        entity.setBlat(infoDO.getIschecklat());
        entity.setH1(infoDO.getHeightcell1());
        entity.setH2(infoDO.getHeightcell2());
        entity.setH3(infoDO.getHeightcell3());
        entity.setEtilt1(infoDO.getElectricaldowntiltcell1());
        entity.setEtilt2(infoDO.getElectricaldowntiltcell2());
        entity.setEtilt3(infoDO.getElectricaldowntiltcell3());
        entity.setAzimuth1(infoDO.getAzimuthcell1());
        entity.setAzimuth2(infoDO.getAzimuthcell2());
        entity.setAzimuth3(infoDO.getAzimuthcell3());
        entity.setDtilt1(infoDO.getDowntiltcell1());
        entity.setDtilt2(infoDO.getDowntiltcell2());
        entity.setDtilt3(infoDO.getDowntiltcell3());
        entity.setTs(infoDO.getRecordTime() == null ? null : sdf.format(infoDO.getRecordTime()));
        return entity;
    }
}
