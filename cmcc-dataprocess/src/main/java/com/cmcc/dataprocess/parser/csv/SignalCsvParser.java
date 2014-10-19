package com.cmcc.dataprocess.parser.csv;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.dataprocess.hbase.SignalTypeEnum;
import com.cmcc.optimize.dataaccess.util.UrlUtil;
import com.cmcc.optimize.datamodel.signal.SignalHttpModel;
import com.cmcc.optimize.datamodel.signal.SignalMMSModel;
import com.cmcc.optimize.datamodel.signal.SignalSigModel;
import com.cmcc.optimize.datamodel.signal.SignalTcpModel;
import com.cmcc.optimize.datamodel.signal.SignalUdpModel;
import com.cmcc.optimize.datamodel.signal.SignalWSPModel;

public class SignalCsvParser {

    private final static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final static SimpleDateFormat hour = new SimpleDateFormat("HH");

    private UrlUtil urlUtil = new UrlUtil();

    public static Logger logger = LoggerFactory.getLogger(SignalCsvParser.class);// 日志

    /**
     * csv行记录转换为对象
     * 
     * @param line 行记录
     * @param type 类型
     * @return 对象
     */
    public Object parser(String line, SignalTypeEnum type) {
        if (type == null || StringUtils.isBlank(line)) {
            return null;
        }

        if (type == SignalTypeEnum.SIGNAL_HTTP_MODEL) {
            return httpParser(line);
        } else if (type == SignalTypeEnum.SIGNAL_MMS_MODEL) {
            return mmsParser(line);
        } else if (type == SignalTypeEnum.SIGNAL_SIG_MODEL) {
            return sigParser(line);
        } else if (type == SignalTypeEnum.SIGNAL_TCP_MODEL) {
            return tcpParser(line);
        } else if (type == SignalTypeEnum.SIGNAL_UDP_MODEL) {
            return udpParser(line);
        } else if (type == SignalTypeEnum.SIGNAL_WSP_MODEL) {
            return wspParser(line);
        } else {
            return null;
        }
    }

    /**
     * http类型的csv记录转换为可入库之对象
     * 
     * @param csvRecord
     * @return bool
     */
    public SignalHttpModel httpParser(String csvRecord) {

        String[] baseRecord = new String[32];
        baseRecord = Arrays.copyOf(csvRecord.split(","), 32); // copy数组

        SignalHttpModel httpModel = new SignalHttpModel(); // 新建model

        try {

            char[] chars = baseRecord[0].toCharArray();
            chars[10] = ' ';
            Date date = sdf.parse(new String(chars));
            httpModel.setTime(date.getTime());
            httpModel.setHour(hour.format(date));

            httpModel.setImsi(baseRecord[1]);
            httpModel.setHttpSession(baseRecord[3]);
            if (StringUtils.isNotBlank(baseRecord[4]))
                httpModel.setEvent(Integer.parseInt(baseRecord[4]));
            if (StringUtils.isNotBlank(baseRecord[6]))
                httpModel.setLac(Integer.parseInt(baseRecord[6]));
            if (StringUtils.isNotBlank(baseRecord[7]))
                httpModel.setCell(Integer.parseInt(baseRecord[7]));
            if (StringUtils.isNotBlank(baseRecord[9]))
                httpModel.setSubSession(Integer.parseInt(baseRecord[9]));
            if (StringUtils.isNotBlank(baseRecord[10]))
                httpModel.setAppSession(Integer.parseInt(baseRecord[10]));
            if (StringUtils.isNotBlank(baseRecord[16]))
                httpModel.setUpByte(Integer.parseInt(baseRecord[16]));
            if (StringUtils.isNotBlank(baseRecord[18]))
                httpModel.setDownByte(Integer.parseInt(baseRecord[18]));
            if (StringUtils.isNotBlank(baseRecord[19]))
                httpModel.setRespondTime(Integer.parseInt(baseRecord[19]));
            if (StringUtils.isNotBlank(baseRecord[20]))
                httpModel.setMethod(Integer.parseInt(baseRecord[20]));
            if (StringUtils.isNotBlank(baseRecord[21]))
                httpModel.setResponseStatus(Integer.parseInt(baseRecord[21]));
            if (StringUtils.isNotBlank(baseRecord[22]))
                httpModel.setMobileType(baseRecord[22]);
            if (StringUtils.isNotBlank(baseRecord[23]))
                httpModel.setMobileMMSFlag(Integer.parseInt(baseRecord[23]));
            if (StringUtils.isNotBlank(baseRecord[24]))
                httpModel.setBusiType(urlUtil.urlParse(baseRecord[24]));
            if (StringUtils.isNotBlank(baseRecord[31]))
                httpModel.setNetType(Integer.parseInt(baseRecord[31]));

            String[] urlPart = urlSplit(baseRecord[24]);// URL单独处理过程
            httpModel.setUrl(urlPart[0] == null ? "" : urlPart[0]);
            httpModel.setUrl1(urlPart[1] == null ? "" : urlPart[1]);
            httpModel.setUrl2(urlPart[2] == null ? "" : urlPart[2]);
            httpModel.setUrl3(urlPart[3] == null ? "" : urlPart[3]);
            httpModel.setUrl4(urlPart[4] == null ? "" : urlPart[4]);

        } catch (Exception e) {
            logger.error("parser httpModel error:" + csvRecord, e);
            return null;
        }

        return httpModel;
    }

    /**
     * mms类型的csv记录转换为可入库之对象 目前使用前27列
     * 
     * @param csvRecord
     * @return bool
     */
    public SignalMMSModel mmsParser(String csvRecord) {

        // 如果originalRecord长度不够27（即csv）这一行记录最后一列的下标不到31时，如何处理? -->交换数组元素
        String[] baseRecord = new String[27];
        baseRecord = Arrays.copyOf(csvRecord.split(","), 27); // copy数组

        SignalMMSModel mmsModel = new SignalMMSModel();

        try {
            char[] chars = baseRecord[0].toCharArray();
            chars[10] = ' ';
            Date date = sdf.parse(new String(chars));
            mmsModel.setTime(date.getTime());
            mmsModel.setHour(hour.format(date));

            mmsModel.setImsi(baseRecord[1]);
            mmsModel.setMmsSession(baseRecord[3]);
            if (StringUtils.isNotBlank(baseRecord[4]))
                mmsModel.setEvent(Integer.parseInt(baseRecord[4]));
            if (StringUtils.isNotBlank(baseRecord[6]))
                mmsModel.setLac(Integer.parseInt(baseRecord[6]));
            if (StringUtils.isNotBlank(baseRecord[7]))
                mmsModel.setCell(Integer.parseInt(baseRecord[7]));
            if (StringUtils.isNotBlank(baseRecord[9]))
                mmsModel.setSubSession(Integer.parseInt(baseRecord[9]));
            if (StringUtils.isNotBlank(baseRecord[10]))
                mmsModel.setAppSession(Integer.parseInt(baseRecord[10]));
            if (StringUtils.isNotBlank(baseRecord[11]))
                mmsModel.setMmsByte(Integer.parseInt(baseRecord[11]));
            if (StringUtils.isNotBlank(baseRecord[18]))
                mmsModel.setErrorType(Integer.parseInt(baseRecord[18]));
            if (StringUtils.isNotBlank(baseRecord[19]))
                mmsModel.setWspHttpResponse(Integer.parseInt(baseRecord[19]));
            if (StringUtils.isNotBlank(baseRecord[20]))
                mmsModel.setMmsResponse(Integer.parseInt(baseRecord[20]));
            if (StringUtils.isNotBlank(baseRecord[21]))
                mmsModel.setMmsStatus(Integer.parseInt(baseRecord[21]));
            if (StringUtils.isNotBlank(baseRecord[22]))
                mmsModel.setRespondTime(Integer.parseInt(baseRecord[22]));
            mmsModel.setMobileType(baseRecord[23]);
            if (StringUtils.isNotBlank(baseRecord[24]))
                mmsModel.setMobileMMSFlag(Integer.parseInt(baseRecord[24]));
            if (StringUtils.isNotBlank(baseRecord[25]))
                mmsModel.setBusiType(urlUtil.urlParse(baseRecord[25]));
            if (StringUtils.isNotBlank(baseRecord[26]))
                mmsModel.setNetType(Integer.parseInt(baseRecord[26]));

            String[] urlPart = urlSplit(baseRecord[25]);
            mmsModel.setUrl(urlPart[0] == null ? "" : urlPart[0]);
            mmsModel.setUrl1(urlPart[1] == null ? "" : urlPart[1]);
            mmsModel.setUrl2(urlPart[2] == null ? "" : urlPart[2]);
            mmsModel.setUrl3(urlPart[3] == null ? "" : urlPart[3]);
            mmsModel.setUrl4(urlPart[4] == null ? "" : urlPart[4]);

        } catch (Exception e) {
            logger.error("parser mmsModel error:" + csvRecord, e);
            return null;
        }
        return mmsModel;
    }

    /**
     * sig类型的csv记录转换为可入库之对象 目前使用前21列
     * 
     * @param csvRecord
     * @return bool
     */
    public SignalSigModel sigParser(String csvRecord) {

        // 如果originalRecord长度不够21（即csv）这一行记录最后一列的下标不到31时，如何处理? -->交换数组元素
        String[] baseRecord = new String[21];
        baseRecord = Arrays.copyOf(csvRecord.split(","), 21); // copy数组

        SignalSigModel sigModel = new SignalSigModel();

        try {

            char[] chars = baseRecord[0].toCharArray();
            chars[10] = ' ';
            Date date = sdf.parse(new String(chars));
            sigModel.setTime(date.getTime());
            sigModel.setHour(hour.format(date));

            sigModel.setImsi(baseRecord[3]);
            sigModel.setSigSession(baseRecord[4]);
            if (StringUtils.isNotBlank(baseRecord[5]))
                sigModel.setEvent(Integer.parseInt(baseRecord[5]));
            if (StringUtils.isNotBlank(baseRecord[7]))
                sigModel.setLac(Integer.parseInt(baseRecord[7]));
            if (StringUtils.isNotBlank(baseRecord[8]))
                sigModel.setCell(Integer.parseInt(baseRecord[8]));
            if (StringUtils.isNotBlank(baseRecord[10]))
                sigModel.setSubSession(Integer.parseInt(baseRecord[10]));
            if (StringUtils.isNotBlank(baseRecord[6]))
                sigModel.setPcu(Integer.parseInt(baseRecord[6]));
            if (StringUtils.isNotBlank(baseRecord[9]))
                sigModel.setRac(Integer.parseInt(baseRecord[9]));
            if (StringUtils.isNotBlank(baseRecord[11]))
                sigModel.setResult(Integer.parseInt(baseRecord[11]));
            if (StringUtils.isNotBlank(baseRecord[12]))
                sigModel.setFailReason(Integer.parseInt(baseRecord[12]));
            if (StringUtils.isNotBlank(baseRecord[13]))
                sigModel.setSigDuration(Integer.parseInt(baseRecord[13]));
            if (StringUtils.isNotBlank(baseRecord[14]))
                sigModel.setChannelType(Integer.parseInt(baseRecord[14]));
            if (StringUtils.isNotBlank(baseRecord[15]))
                sigModel.setBusiType(Integer.parseInt(baseRecord[15]));
            if (StringUtils.isNotBlank(baseRecord[19]))
                sigModel.setEventType(Integer.parseInt(baseRecord[19]));
            if (StringUtils.isNotBlank(baseRecord[20]))
                sigModel.setNetType(Integer.parseInt(baseRecord[20]));

            sigModel.setApn(baseRecord[16]);
            sigModel.setApnIpv4(baseRecord[17]);
            sigModel.setImei(baseRecord[18]);
        } catch (Exception e) {
            logger.error("parser sigModel error:" + csvRecord, e);
            return null;
        }
        return sigModel;
    }

    /**
     * tcp类型的csv记录转换为可入库之对象 目前使用前29列
     * 
     * @param csvRecord
     * @return bool
     */
    public SignalTcpModel tcpParser(String csvRecord) {

        // 如果originalRecord长度不够29（即csv）这一行记录最后一列的下标不到31时，如何处理? -->交换数组元素
        String[] baseRecord = new String[29];
        baseRecord = Arrays.copyOf(csvRecord.split(","), 29); // copy数组
        SignalTcpModel tcpModel = new SignalTcpModel();

        try {

            char[] chars = baseRecord[0].toCharArray();
            chars[10] = ' ';
            Date date = sdf.parse(new String(chars));
            tcpModel.setTime(date.getTime());
            tcpModel.setHour(hour.format(date));
            // tcpModel.setId(SignalHbaseImport.getCachedUuId());// UidGenerator.generate());
            tcpModel.setImsi(baseRecord[1]);
            tcpModel.setTcpSession(baseRecord[3]);
            if (StringUtils.isNotBlank(baseRecord[4]))
                tcpModel.setEvent(Integer.parseInt(baseRecord[4]));
            if (StringUtils.isNotBlank(baseRecord[6]))
                tcpModel.setLac(Integer.parseInt(baseRecord[6]));
            if (StringUtils.isNotBlank(baseRecord[7]))
                tcpModel.setCell(Integer.parseInt(baseRecord[7]));
            if (StringUtils.isNotBlank(baseRecord[9]))
                tcpModel.setSubSession(Integer.parseInt(baseRecord[9]));
            if (StringUtils.isNotBlank(baseRecord[20]))
                tcpModel.setUpByte(Integer.parseInt(baseRecord[20]));
            if (StringUtils.isNotBlank(baseRecord[21]))
                tcpModel.setUpResponseTime(Integer.parseInt(baseRecord[21]));
            if (StringUtils.isNotBlank(baseRecord[24]))
                tcpModel.setDownByte(Integer.parseInt(baseRecord[24]));
            if (StringUtils.isNotBlank(baseRecord[25]))
                tcpModel.setDownResponseTime(Integer.parseInt(baseRecord[25]));
            if (StringUtils.isNotBlank(baseRecord[28]))
                tcpModel.setNetType(Integer.parseInt(baseRecord[28]));
        } catch (Exception e) {
            logger.error("parser tcpModel error:" + csvRecord, e);
            return null;
        }
        return tcpModel;
    }

    /**
     * udp类型的csv记录转换为可入库之对象 目前使用记录前23列
     * 
     * @param csvRecord
     * @return bool
     */
    public SignalUdpModel udpParser(String csvRecord) {

        // 如果originalRecord长度不够23（即csv）这一行记录最后一列的下标不到31时，如何处理? -->交换数组元素
        String[] baseRecord = new String[23];
        baseRecord = Arrays.copyOf(csvRecord.split(","), 23); // copy数组
        SignalUdpModel udpModel = new SignalUdpModel();

        try {

            char[] chars = baseRecord[0].toCharArray();
            chars[10] = ' ';
            Date date = sdf.parse(new String(chars));
            udpModel.setTime(date.getTime());
            udpModel.setHour(hour.format(date));
            // udpModel.setId(SignalHbaseImport.getCachedUuId());// UidGenerator.generate());
            udpModel.setImsi(baseRecord[1]);
            udpModel.setUdpSession(baseRecord[3]);
            if (StringUtils.isNotBlank(baseRecord[4]))
                udpModel.setEvent(Integer.parseInt(baseRecord[4]));
            if (StringUtils.isNotBlank(baseRecord[6]))
                udpModel.setLac(Integer.parseInt(baseRecord[6]));
            if (StringUtils.isNotBlank(baseRecord[7]))
                udpModel.setCell(Integer.parseInt(baseRecord[7]));
            if (StringUtils.isNotBlank(baseRecord[17]))
                udpModel.setUpByte(Integer.parseInt(baseRecord[17]));
            if (StringUtils.isNotBlank(baseRecord[18]))
                udpModel.setDownByte(Integer.parseInt(baseRecord[18]));
            udpModel.setMobileIp(baseRecord[13]);
            if (StringUtils.isNotBlank(baseRecord[15]))
                udpModel.setMobilePort(Integer.parseInt(baseRecord[15]));
            udpModel.setOppsiteIp(baseRecord[14]);
            if (StringUtils.isNotBlank(baseRecord[16]))
                udpModel.setOppsitePort(Integer.parseInt(baseRecord[16]));
            if (StringUtils.isNotBlank(baseRecord[19]))
                udpModel.setResponseTime(Integer.parseInt(baseRecord[19]));
            if (StringUtils.isNotBlank(baseRecord[22]))
                udpModel.setNetType(Integer.parseInt(baseRecord[22]));
        } catch (Exception e) {
            logger.error("parser udpModel error:" + csvRecord, e);
            return null;

        }
        return udpModel;
    }

    /**
     * wsp类型的csv记录转换为可入库之对象 目前使用前31列
     * 
     * @param csvRecord
     * @return bool
     */
    public SignalWSPModel wspParser(String csvRecord) {

        // 如果originalRecord长度不够32（即csv）这一行记录最后一列的下标不到31时，如何处理?
        String[] baseRecord = Arrays.copyOf(csvRecord.split(","), 32); // copy数组
        SignalWSPModel wspModel = new SignalWSPModel();

        try {
            char[] chars = baseRecord[0].toCharArray();
            chars[10] = ' ';
            Date date = sdf.parse(new String(chars));
            wspModel.setTime(date.getTime());
            wspModel.setHour(hour.format(date));
            // wspModel.setId(SignalHbaseImport.getCachedUuId());// UidGenerator.generate());
            wspModel.setImsi(baseRecord[1]);
            wspModel.setWspSession(baseRecord[3]);
            if (StringUtils.isNotBlank(baseRecord[4]))
                wspModel.setEvent(Integer.parseInt(baseRecord[4]));
            if (StringUtils.isNotBlank(baseRecord[6]))
                wspModel.setLac(Integer.parseInt(baseRecord[6]));
            if (StringUtils.isNotBlank(baseRecord[7]))
                wspModel.setCell(Integer.parseInt(baseRecord[7]));
            if (StringUtils.isNotBlank(baseRecord[9]))
                wspModel.setSubSession(Integer.parseInt(baseRecord[9]));
            if (StringUtils.isNotBlank(baseRecord[10]))
                wspModel.setAppSession(Integer.parseInt(baseRecord[10]));
            if (StringUtils.isNotBlank(baseRecord[20]))
                wspModel.setUpByte(Integer.parseInt(baseRecord[20]));
            if (StringUtils.isNotBlank(baseRecord[22]))
                wspModel.setDownByte(Integer.parseInt(baseRecord[22]));
            if (StringUtils.isNotBlank(baseRecord[23]))
                wspModel.setRespondTime(Integer.parseInt(baseRecord[23]));
            if (StringUtils.isNotBlank(baseRecord[24]))
                wspModel.setMethod(Integer.parseInt(baseRecord[24]));
            if (StringUtils.isNotBlank(baseRecord[25]))
                wspModel.setWtpAbortReason(Integer.parseInt(baseRecord[25]));
            if (StringUtils.isNotBlank(baseRecord[26]))
                wspModel.setWspResponseStatus(Integer.parseInt(baseRecord[26]));
            if (StringUtils.isNotBlank(baseRecord[28]))
                wspModel.setMobileMMSFlag(Integer.parseInt(baseRecord[28]));
            if (StringUtils.isNotBlank(baseRecord[29]))
                wspModel.setBusiType(urlUtil.urlParse(baseRecord[29]));
            if (StringUtils.isNotBlank(baseRecord[30]))
                wspModel.setNetType(Integer.parseInt(baseRecord[30]));

            wspModel.setMobileType(baseRecord[27]);
            String[] urlPart = urlSplit(baseRecord[29]);
            wspModel.setUrl(urlPart[0] == null ? "" : urlPart[0]);
            wspModel.setUrl1(urlPart[1] == null ? "" : urlPart[1]);
            wspModel.setUrl2(urlPart[2] == null ? "" : urlPart[2]);
            wspModel.setUrl3(urlPart[3] == null ? "" : urlPart[3]);
            wspModel.setUrl4(urlPart[4] == null ? "" : urlPart[4]);
        } catch (Exception e) {
            logger.error("parser wspModel error:" + csvRecord, e);
            return null;

        }
        return wspModel;
    }

    /**
     * URL處理過程：去掉URL頭http://，以"/"為分隔將URL分成最多5部份，入庫5個字段
     * 
     * @param string
     * @return String數組
     */
    private static String[] urlSplit(String inStr) {
        String string = inStr.substring(inStr.indexOf("//") + 1);
        String[] args = Arrays.copyOf(string.split("/"), 5);
        return args;
    }
}
