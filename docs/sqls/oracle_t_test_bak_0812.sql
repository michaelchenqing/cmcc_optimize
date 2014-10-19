-----------------------------------------------------
-- Export file for user T_TEST                     --
-- Created by Administrator on 2014/8/12, 16:37:01 --
-----------------------------------------------------

set define off
spool t_test_oracle_bak.log

prompt
prompt Creating table MB_API_REPORT_INFO
prompt =================================
prompt
create table MB_API_REPORT_INFO
(
  app_name         VARCHAR2(32),
  api_name         VARCHAR2(32),
  request_api_time TIMESTAMP(6),
  api_call_time    TIMESTAMP(6),
  call_state       NUMBER(1),
  call_ip          VARCHAR2(15)
)
;
comment on table MB_API_REPORT_INFO
  is '统计API用途，数据报表中心使用';
comment on column MB_API_REPORT_INFO.app_name
  is 'APP应用名';
comment on column MB_API_REPORT_INFO.api_name
  is '调用接口名';
comment on column MB_API_REPORT_INFO.request_api_time
  is '请求时间';
comment on column MB_API_REPORT_INFO.api_call_time
  is '请求处理时长';
comment on column MB_API_REPORT_INFO.call_state
  is '调用状态';
comment on column MB_API_REPORT_INFO.call_ip
  is '调用IP';

prompt
prompt Creating table MB_BIN_PROCESS_INFO
prompt ==================================
prompt
create table MB_BIN_PROCESS_INFO
(
  record_time         TIMESTAMP(6),
  type                VARCHAR2(32),
  province            VARCHAR2(32),
  city                VARCHAR2(32),
  original_record_num VARCHAR2(20),
  original_file_num   VARCHAR2(20),
  original_file_size  VARCHAR2(20),
  data_origin         VARCHAR2(256),
  data_generation     VARCHAR2(8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_BIN_PROCESS_INFO
  is '统计数据量用的，数据报表中心使用-中间表';
comment on column MB_BIN_PROCESS_INFO.record_time
  is '日期';
comment on column MB_BIN_PROCESS_INFO.type
  is '数据类型（现网工参、规划工参、路测、话统、mro、信令）';
comment on column MB_BIN_PROCESS_INFO.province
  is '省份';
comment on column MB_BIN_PROCESS_INFO.city
  is '城市';
comment on column MB_BIN_PROCESS_INFO.original_record_num
  is '原始数据数目
';
comment on column MB_BIN_PROCESS_INFO.original_file_num
  is '原始数据文件数
';
comment on column MB_BIN_PROCESS_INFO.original_file_size
  is '当日处理或存储数据量大小
';
comment on column MB_BIN_PROCESS_INFO.data_origin
  is '数据来源 文件名';
comment on column MB_BIN_PROCESS_INFO.data_generation
  is '2/3/4G 区别标识';
create index LTE_PROCESS_RT_INDEX on MB_BIN_PROCESS_INFO (RECORD_TIME);

prompt
prompt Creating table MB_BTS_TYPE
prompt ==========================
prompt
create table MB_BTS_TYPE
(
  record_time TIMESTAMP(6),
  cgi         VARCHAR2(256),
  eqp_type    VARCHAR2(256),
  drx_type    VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_BTS_TYPE.record_time
  is '时间';
comment on column MB_BTS_TYPE.cgi
  is 'CGI';
comment on column MB_BTS_TYPE.eqp_type
  is '设备类型';
comment on column MB_BTS_TYPE.drx_type
  is '载频类型';

prompt
prompt Creating table MB_DATA_BAK
prompt ==========================
prompt
create table MB_DATA_BAK
(
  record_time         TIMESTAMP(6),
  type                VARCHAR2(32),
  province            VARCHAR2(32),
  city                VARCHAR2(32),
  original_record_num VARCHAR2(20),
  clean_data_num      VARCHAR2(20),
  legal_data_num      VARCHAR2(20),
  original_file_num   VARCHAR2(20),
  original_file_size  VARCHAR2(20),
  data_origin         VARCHAR2(256)
)
;

prompt
prompt Creating table MB_DATA_REPORT_INFO
prompt ==================================
prompt
create table MB_DATA_REPORT_INFO
(
  record_time         TIMESTAMP(6),
  type                VARCHAR2(32),
  province            VARCHAR2(32),
  city                VARCHAR2(32),
  original_record_num VARCHAR2(20),
  clean_data_num      VARCHAR2(20),
  legal_data_num      VARCHAR2(20),
  original_file_num   VARCHAR2(20),
  original_file_size  VARCHAR2(20),
  data_origin         VARCHAR2(256)
)
;
comment on table MB_DATA_REPORT_INFO
  is '统计数据量用的，数据报表中心使用-结果表';
comment on column MB_DATA_REPORT_INFO.record_time
  is '日期';
comment on column MB_DATA_REPORT_INFO.type
  is '数据类型（现网工参、规划工参、路测、话统、mro、信令）';
comment on column MB_DATA_REPORT_INFO.province
  is '省份';
comment on column MB_DATA_REPORT_INFO.city
  is '城市';
comment on column MB_DATA_REPORT_INFO.original_record_num
  is '原始数据数目
';
comment on column MB_DATA_REPORT_INFO.clean_data_num
  is '清洗后数据数目
';
comment on column MB_DATA_REPORT_INFO.legal_data_num
  is '清洗后的有效数目';
comment on column MB_DATA_REPORT_INFO.original_file_num
  is '原始数据文件数
';
comment on column MB_DATA_REPORT_INFO.original_file_size
  is '当日处理或存储数据量大小
';
comment on column MB_DATA_REPORT_INFO.data_origin
  is '数据来源
文件名';

prompt
prompt Creating table MB_DT_RECORD
prompt ===========================
prompt
create table MB_DT_RECORD
(
  device         VARCHAR2(64),
  record_time    TIMESTAMP(6),
  lon            NUMBER(12,8),
  lat            NUMBER(12,8),
  scell_pci      NUMBER(16,8),
  scell_cellid   NUMBER(16,8),
  scell_enodebid NUMBER(16,8),
  crs_rsrp       NUMBER(16,8),
  crs_sinr       NUMBER(16,8),
  tm_mode        NUMBER(16,8),
  ri1            NUMBER(16,8),
  ri2            NUMBER(16,8),
  dl_code0_mcs   NUMBER(16,8),
  dl_code1_mcs   NUMBER(16,8),
  pdsch_tb       NUMBER(16,8),
  pdsch_rb       NUMBER(16,8),
  phy_dl         NUMBER(16,8),
  pdcp_dl        NUMBER(16,8),
  ncell1_pci     NUMBER(16,8),
  ncell1_cellid  NUMBER(16,8),
  ncell1_rsrp    NUMBER(16,8),
  ncell2_pci     NUMBER(16,8),
  ncell2_cellid  NUMBER(16,8),
  ncell2_rsrp    NUMBER(16,8),
  ncell3_pci     NUMBER(16,8),
  ncell3_cellid  NUMBER(16,8),
  ncell3_rsrp    NUMBER(16,8),
  ncell4_pci     NUMBER(16,8),
  ncell4_cellid  NUMBER(16,8),
  ncell4_rsrp    NUMBER(16,8),
  ncell5_pci     NUMBER(16,8),
  ncell5_cellid  NUMBER(16,8),
  ncell5_rsrp    NUMBER(16,8),
  ncell6_pci     NUMBER(16,8),
  ncell6_cellid  NUMBER(16,8),
  ncell6_rsrp    NUMBER(16,8),
  ncell7_pci     NUMBER(16,8),
  ncell7_cellid  NUMBER(16,8),
  ncell7_rsrp    NUMBER(16,8),
  ncell8_pci     NUMBER(16,8),
  ncell8_cellid  NUMBER(16,8),
  ncell8_rsrp    NUMBER(16,8),
  ncell9_pci     NUMBER(16,8),
  ncell9_cellid  NUMBER(16,8),
  ncell9_rsrp    NUMBER(16,8)
)
;
comment on table MB_DT_RECORD
  is '路测表';
comment on column MB_DT_RECORD.device
  is '测试设备ID';
comment on column MB_DT_RECORD.record_time
  is '记录时间';
comment on column MB_DT_RECORD.lon
  is '经度';
comment on column MB_DT_RECORD.lat
  is '纬度';
comment on column MB_DT_RECORD.scell_pci
  is '主服务小区PCI';
comment on column MB_DT_RECORD.scell_cellid
  is '主服务小区CI';
comment on column MB_DT_RECORD.scell_enodebid
  is '主服务小区ENodeBID';
comment on column MB_DT_RECORD.crs_rsrp
  is '主服务小区RSRP';
comment on column MB_DT_RECORD.crs_sinr
  is '主服务小区SINR';
comment on column MB_DT_RECORD.ncell1_pci
  is '邻区1PCI';
comment on column MB_DT_RECORD.ncell1_cellid
  is '邻区1CI';
comment on column MB_DT_RECORD.ncell1_rsrp
  is '邻区1RSRP';
comment on column MB_DT_RECORD.ncell2_pci
  is '邻区2PCI';
comment on column MB_DT_RECORD.ncell2_cellid
  is '邻区2CI';
comment on column MB_DT_RECORD.ncell2_rsrp
  is '邻区2RSRP';
comment on column MB_DT_RECORD.ncell3_pci
  is '邻区3PCI';
comment on column MB_DT_RECORD.ncell3_cellid
  is '邻区3CI';
comment on column MB_DT_RECORD.ncell3_rsrp
  is '邻区3RSRP';
comment on column MB_DT_RECORD.ncell4_pci
  is '邻区4PCI';
comment on column MB_DT_RECORD.ncell4_cellid
  is '邻区4CI';
comment on column MB_DT_RECORD.ncell4_rsrp
  is '邻区4RSRP';
comment on column MB_DT_RECORD.ncell5_pci
  is '邻区5PCI';
comment on column MB_DT_RECORD.ncell5_cellid
  is '邻区5CI';
comment on column MB_DT_RECORD.ncell5_rsrp
  is '邻区5RSRP';
comment on column MB_DT_RECORD.ncell6_pci
  is '邻区6PCI';
comment on column MB_DT_RECORD.ncell6_cellid
  is '邻区6CI';
comment on column MB_DT_RECORD.ncell6_rsrp
  is '邻区6RSRP';
comment on column MB_DT_RECORD.ncell7_pci
  is '邻区7PCI';
comment on column MB_DT_RECORD.ncell7_cellid
  is '邻区7CI';
comment on column MB_DT_RECORD.ncell7_rsrp
  is '邻区7RSRP';
comment on column MB_DT_RECORD.ncell8_pci
  is '邻区8PCI';
comment on column MB_DT_RECORD.ncell8_cellid
  is '邻区8CI';
comment on column MB_DT_RECORD.ncell8_rsrp
  is '邻区8RSRP';
comment on column MB_DT_RECORD.ncell9_pci
  is '邻区9PCI';
comment on column MB_DT_RECORD.ncell9_cellid
  is '邻区9CI';
comment on column MB_DT_RECORD.ncell9_rsrp
  is '邻区9RSRP';
create index LTE_DT_RECORD_RT_INDEX on MB_DT_RECORD (RECORD_TIME);

prompt
prompt Creating table MB_LTE_ST_FTP_TY
prompt ===============================
prompt
create table MB_LTE_ST_FTP_TY
(
  record_time        TIMESTAMP(6),
  city               VARCHAR2(265),
  network_type       VARCHAR2(265),
  business_type      VARCHAR2(265),
  avg_rate_ftp       NUMBER(24,2),
  con_suc_rate_ftp   NUMBER(24,2),
  land_suc_rate_ftp  NUMBER(24,2),
  trans_suc_rate_ftp NUMBER(24,2),
  throughput_ftp     NUMBER(24,2),
  time_amount_ftp    NUMBER(24,2),
  max_rate_ftp       NUMBER(24,2),
  min_rate_ftp       NUMBER(24,2),
  avg_rsrp_ftp       NUMBER(24,2)
)
partition by range (RECORD_TIME)
(
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_LTE_ST_FTP_TY
  is '本地手机测试ftp';
comment on column MB_LTE_ST_FTP_TY.record_time
  is '日期';
comment on column MB_LTE_ST_FTP_TY.city
  is '地市';
comment on column MB_LTE_ST_FTP_TY.network_type
  is '网络类型';
comment on column MB_LTE_ST_FTP_TY.business_type
  is '业务类型';
comment on column MB_LTE_ST_FTP_TY.avg_rate_ftp
  is 'FTP平均数据传输速率(kb/s)';
comment on column MB_LTE_ST_FTP_TY.con_suc_rate_ftp
  is 'FTP用户连接成功率';
comment on column MB_LTE_ST_FTP_TY.land_suc_rate_ftp
  is 'FTP登陆成功率';
comment on column MB_LTE_ST_FTP_TY.trans_suc_rate_ftp
  is 'FTP数据传输成功率';
comment on column MB_LTE_ST_FTP_TY.throughput_ftp
  is 'FTP数据量(KB)';
comment on column MB_LTE_ST_FTP_TY.time_amount_ftp
  is 'FTP下载总时长(s)';
comment on column MB_LTE_ST_FTP_TY.max_rate_ftp
  is 'FTP最大下载速率(kb/s)';
comment on column MB_LTE_ST_FTP_TY.min_rate_ftp
  is 'FTP最小下载速率(kb/s)';
comment on column MB_LTE_ST_FTP_TY.avg_rsrp_ftp
  is '平均电平(FTP)';

prompt
prompt Creating table MB_LTE_ST_FTP_TY_BAK
prompt ===================================
prompt
create table MB_LTE_ST_FTP_TY_BAK
(
  record_time        TIMESTAMP(6),
  city               VARCHAR2(265),
  network_type       VARCHAR2(265),
  business_type      VARCHAR2(265),
  avg_rate_ftp       NUMBER(24,2),
  con_suc_rate_ftp   NUMBER(24,2),
  land_suc_rate_ftp  NUMBER(24,2),
  trans_suc_rate_ftp NUMBER(24,2),
  throughput_ftp     NUMBER(24,2),
  time_amount_ftp    NUMBER(24,2),
  max_rate_ftp       NUMBER(24,2),
  min_rate_ftp       NUMBER(24,2),
  avg_rsrp_ftp       NUMBER(24,2)
)
partition by range (RECORD_TIME)
(
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST
);
comment on table MB_LTE_ST_FTP_TY_BAK
  is '本地手机测试ftp';
comment on column MB_LTE_ST_FTP_TY_BAK.record_time
  is '日期';
comment on column MB_LTE_ST_FTP_TY_BAK.city
  is '地市';
comment on column MB_LTE_ST_FTP_TY_BAK.network_type
  is '网络类型';
comment on column MB_LTE_ST_FTP_TY_BAK.business_type
  is '业务类型';
comment on column MB_LTE_ST_FTP_TY_BAK.avg_rate_ftp
  is 'FTP平均数据传输速率(kb/s)';
comment on column MB_LTE_ST_FTP_TY_BAK.con_suc_rate_ftp
  is 'FTP用户连接成功率';
comment on column MB_LTE_ST_FTP_TY_BAK.land_suc_rate_ftp
  is 'FTP登陆成功率';
comment on column MB_LTE_ST_FTP_TY_BAK.trans_suc_rate_ftp
  is 'FTP数据传输成功率';
comment on column MB_LTE_ST_FTP_TY_BAK.throughput_ftp
  is 'FTP数据量(KB)';
comment on column MB_LTE_ST_FTP_TY_BAK.time_amount_ftp
  is 'FTP下载总时长(s)';
comment on column MB_LTE_ST_FTP_TY_BAK.max_rate_ftp
  is 'FTP最大下载速率(kb/s)';
comment on column MB_LTE_ST_FTP_TY_BAK.min_rate_ftp
  is 'FTP最小下载速率(kb/s)';
comment on column MB_LTE_ST_FTP_TY_BAK.avg_rsrp_ftp
  is '平均电平（FTP）';

prompt
prompt Creating table MB_LTE_ST_HTTP_TY
prompt ================================
prompt
create table MB_LTE_ST_HTTP_TY
(
  record_time             TIMESTAMP(6),
  city                    VARCHAR2(265),
  network_type            VARCHAR2(265),
  business_type           VARCHAR2(265),
  avg_rate_http           NUMBER(24,2),
  first_req_suc_rate_http NUMBER(24,2),
  worst_req_duration_http NUMBER(24,2),
  max_download_rate_http  NUMBER(24,2),
  min_download_rate_http  NUMBER(24,2),
  avg_rsrp_http           NUMBER(24,2)
)
partition by range (RECORD_TIME)
(
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_LTE_ST_HTTP_TY
  is '本地手机测试http';
comment on column MB_LTE_ST_HTTP_TY.record_time
  is '日期';
comment on column MB_LTE_ST_HTTP_TY.city
  is '地市';
comment on column MB_LTE_ST_HTTP_TY.network_type
  is '网络类型';
comment on column MB_LTE_ST_HTTP_TY.business_type
  is '业务类型';
comment on column MB_LTE_ST_HTTP_TY.avg_rate_http
  is 'HTTP平均数据传输速率(kb/s)';
comment on column MB_LTE_ST_HTTP_TY.first_req_suc_rate_http
  is 'HTTP首次请求成功率';
comment on column MB_LTE_ST_HTTP_TY.worst_req_duration_http
  is 'HTTP最差请求时长(s)';
comment on column MB_LTE_ST_HTTP_TY.max_download_rate_http
  is 'HTTP最大下载速率(kb/s)';
comment on column MB_LTE_ST_HTTP_TY.min_download_rate_http
  is 'HTTP最小下载速率(kb/s)';
comment on column MB_LTE_ST_HTTP_TY.avg_rsrp_http
  is '平均电平(HTTP)';

prompt
prompt Creating table MB_LTE_ST_HTTP_TY_BAK
prompt ====================================
prompt
create table MB_LTE_ST_HTTP_TY_BAK
(
  record_time             TIMESTAMP(6),
  city                    VARCHAR2(265),
  network_type            VARCHAR2(265),
  business_type           VARCHAR2(265),
  avg_rate_http           NUMBER(24,2),
  first_req_suc_rate_http NUMBER(24,2),
  worst_req_duration_http NUMBER(24,2),
  max_download_rate_http  NUMBER(24,2),
  min_download_rate_http  NUMBER(24,2),
  avg_rsrp_http           NUMBER(24,2)
)
partition by range (RECORD_TIME)
(
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST
);
comment on table MB_LTE_ST_HTTP_TY_BAK
  is '本地手机测试http';
comment on column MB_LTE_ST_HTTP_TY_BAK.record_time
  is '日期';
comment on column MB_LTE_ST_HTTP_TY_BAK.city
  is '地市';
comment on column MB_LTE_ST_HTTP_TY_BAK.network_type
  is '网络类型';
comment on column MB_LTE_ST_HTTP_TY_BAK.business_type
  is '业务类型';
comment on column MB_LTE_ST_HTTP_TY_BAK.avg_rate_http
  is 'HTTP平均数据传输速率(kb/s)';
comment on column MB_LTE_ST_HTTP_TY_BAK.first_req_suc_rate_http
  is 'HTTP首次请求成功率';
comment on column MB_LTE_ST_HTTP_TY_BAK.worst_req_duration_http
  is 'HTTP最差请求时长(s)';
comment on column MB_LTE_ST_HTTP_TY_BAK.max_download_rate_http
  is 'HTTP最大下载速率(kb/s)
';
comment on column MB_LTE_ST_HTTP_TY_BAK.min_download_rate_http
  is 'HTTP最小下载速率(kb/s)
';
comment on column MB_LTE_ST_HTTP_TY_BAK.avg_rsrp_http
  is '平均电平（HTTP）
';

prompt
prompt Creating table MB_LTE_ST_PING_TY
prompt ================================
prompt
create table MB_LTE_ST_PING_TY
(
  record_time          TIMESTAMP(6),
  city                 VARCHAR2(32),
  network_type         VARCHAR2(32),
  business_type        VARCHAR2(32),
  suc_rate_ping        NUMBER(32,3),
  min_last_ping_packet NUMBER(32,3),
  max_last_ping_packet NUMBER(32,3),
  avg_last_ping_packet NUMBER(32,3),
  avg_rsrp_ping        NUMBER(32,3)
)
partition by range (RECORD_TIME)
(
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_LTE_ST_PING_TY
  is '本地手机测试ping';
comment on column MB_LTE_ST_PING_TY.record_time
  is '日期';
comment on column MB_LTE_ST_PING_TY.city
  is '地市';
comment on column MB_LTE_ST_PING_TY.network_type
  is '网络类型';
comment on column MB_LTE_ST_PING_TY.business_type
  is '业务类型';
comment on column MB_LTE_ST_PING_TY.suc_rate_ping
  is 'PING成功率(%)';
comment on column MB_LTE_ST_PING_TY.min_last_ping_packet
  is 'PING数据包接收最小历时(毫秒)';
comment on column MB_LTE_ST_PING_TY.max_last_ping_packet
  is 'PING数据包接收最大历时(毫秒)';
comment on column MB_LTE_ST_PING_TY.avg_last_ping_packet
  is 'PING数据包接收平均历时(毫秒)';
comment on column MB_LTE_ST_PING_TY.avg_rsrp_ping
  is '平时电平(PING)';

prompt
prompt Creating table MB_LTE_ST_PING_TY_BAK
prompt ====================================
prompt
create table MB_LTE_ST_PING_TY_BAK
(
  record_time          TIMESTAMP(6),
  city                 VARCHAR2(32),
  network_type         VARCHAR2(32),
  business_type        VARCHAR2(32),
  suc_rate_ping        NUMBER(32,3),
  min_last_ping_packet NUMBER(32,3),
  max_last_ping_packet NUMBER(32,3),
  avg_last_ping_packet NUMBER(32,3),
  avg_rsrp_ping        NUMBER(32,3)
)
partition by range (RECORD_TIME)
(
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST
);
comment on table MB_LTE_ST_PING_TY_BAK
  is '本地手机测试ping';
comment on column MB_LTE_ST_PING_TY_BAK.record_time
  is '日期';
comment on column MB_LTE_ST_PING_TY_BAK.city
  is '地市
';
comment on column MB_LTE_ST_PING_TY_BAK.network_type
  is '网络类型
';
comment on column MB_LTE_ST_PING_TY_BAK.business_type
  is '业务类型
';
comment on column MB_LTE_ST_PING_TY_BAK.suc_rate_ping
  is 'PING成功率(%)
';
comment on column MB_LTE_ST_PING_TY_BAK.min_last_ping_packet
  is 'PING数据包接收最小历时(毫秒)
';
comment on column MB_LTE_ST_PING_TY_BAK.max_last_ping_packet
  is 'PING数据包接收最大历时(毫秒)
';
comment on column MB_LTE_ST_PING_TY_BAK.avg_last_ping_packet
  is 'PING数据包接收平均历时(毫秒)
';
comment on column MB_LTE_ST_PING_TY_BAK.avg_rsrp_ping
  is '平均电平（PING）
';

prompt
prompt Creating table MB_LTE_ST_VIDEO_TY
prompt =================================
prompt
create table MB_LTE_ST_VIDEO_TY
(
  record_time                TIMESTAMP(6),
  city                       VARCHAR2(32),
  network_type               VARCHAR2(32),
  business_type              VARCHAR2(32),
  fluency_video              NUMBER(32,3),
  suc_rate_video_play        NUMBER(32,3),
  duration_first_cideo_video NUMBER(32,3),
  duration_wait              NUMBER(32,3)
)
partition by range (RECORD_TIME)
(
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_LTE_ST_VIDEO_TY
  is '本地手机测试video';
comment on column MB_LTE_ST_VIDEO_TY.record_time
  is '日期';
comment on column MB_LTE_ST_VIDEO_TY.city
  is '地市';
comment on column MB_LTE_ST_VIDEO_TY.network_type
  is '网络类型';
comment on column MB_LTE_ST_VIDEO_TY.business_type
  is '业务类型';
comment on column MB_LTE_ST_VIDEO_TY.fluency_video
  is '视频流畅度';
comment on column MB_LTE_ST_VIDEO_TY.suc_rate_video_play
  is '视频打开成功率(%)';
comment on column MB_LTE_ST_VIDEO_TY.duration_first_cideo_video
  is '首次视频缓冲时长(s)';
comment on column MB_LTE_ST_VIDEO_TY.duration_wait
  is '用户等待时长(s)';

prompt
prompt Creating table MB_LTE_ST_VIDEO_TY_BAK
prompt =====================================
prompt
create table MB_LTE_ST_VIDEO_TY_BAK
(
  record_time                TIMESTAMP(6),
  city                       VARCHAR2(32),
  network_type               VARCHAR2(32),
  business_type              VARCHAR2(32),
  fluency_video              NUMBER(32,3),
  suc_rate_video_play        NUMBER(32,3),
  duration_first_cideo_video NUMBER(32,3),
  duration_wait              NUMBER(32,3)
)
partition by range (RECORD_TIME)
(
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST
);
comment on table MB_LTE_ST_VIDEO_TY_BAK
  is '本地手机测试video';
comment on column MB_LTE_ST_VIDEO_TY_BAK.record_time
  is '日期';
comment on column MB_LTE_ST_VIDEO_TY_BAK.city
  is '地市';
comment on column MB_LTE_ST_VIDEO_TY_BAK.network_type
  is '网络类型
';
comment on column MB_LTE_ST_VIDEO_TY_BAK.business_type
  is '业务类型
';
comment on column MB_LTE_ST_VIDEO_TY_BAK.fluency_video
  is '视频流畅度
';
comment on column MB_LTE_ST_VIDEO_TY_BAK.suc_rate_video_play
  is '视频打开成功率(%)
';
comment on column MB_LTE_ST_VIDEO_TY_BAK.duration_first_cideo_video
  is '首次视频缓冲时长(s)
';
comment on column MB_LTE_ST_VIDEO_TY_BAK.duration_wait
  is '用户等待时长(s)
';

prompt
prompt Creating table MB_MR_RECORD
prompt ===========================
prompt
create table MB_MR_RECORD
(
  mmegroupid       VARCHAR2(128),
  mmecode          VARCHAR2(128),
  mmeues2apid      VARCHAR2(128),
  cellid           VARCHAR2(128),
  test_date        TIMESTAMP(6),
  test_time        TIMESTAMP(6),
  eventtype        VARCHAR2(128),
  mrltescrsrp      NUMBER(8),
  mrltencrsrp      NUMBER(8),
  mrltescrsrq      NUMBER(8),
  mrltencrsrq      NUMBER(8),
  mrltescrttd      NUMBER(8),
  mrltescphr       NUMBER(8),
  mrltescrip       NUMBER(8),
  mrltescaoa       NUMBER(8),
  mrltescplrdlqcix NUMBER(8),
  freq_band        NUMBER(8),
  mrltescsinrul    NUMBER(8),
  mrltescearfcn    NUMBER(8),
  mrltescpci       NUMBER(8)
)
partition by range (TEST_DATE)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_MR_RECORD
  is '网络质量MR数据';
comment on column MB_MR_RECORD.mmegroupid
  is 'MME组标识
';
comment on column MB_MR_RECORD.mmecode
  is 'MME码
';
comment on column MB_MR_RECORD.mmeues2apid
  is 'MME UE S1应用程序标识
';
comment on column MB_MR_RECORD.cellid
  is '小区标识
';
comment on column MB_MR_RECORD.test_date
  is '样本数据测量日期
';
comment on column MB_MR_RECORD.test_time
  is '样本数据测量时间
';
comment on column MB_MR_RECORD.eventtype
  is 'EventType样本数据测量事件类型
';
comment on column MB_MR_RECORD.mrltescrsrp
  is 'TD-LTE服务小区的参考信号接收功率
';
comment on column MB_MR_RECORD.mrltencrsrp
  is 'TD-LTE已定义邻区关系和未定义邻区关系小区的参考信号接收功率
';
comment on column MB_MR_RECORD.mrltescrsrq
  is 'TD-LTE服务小区的参考信号接收质量
';
comment on column MB_MR_RECORD.mrltencrsrq
  is 'TD-LTE已定义邻区关系和未定义邻区关系小区的参考信号接收质量
';
comment on column MB_MR_RECORD.mrltescrttd
  is 'TD-LTE服务小区的UE收发时间差
';
comment on column MB_MR_RECORD.mrltescphr
  is 'TD-LTE服务小区的UE发射功率余量
';
comment on column MB_MR_RECORD.mrltescrip
  is 'TD-LTE服务小区的eNB接收干扰功率
';
comment on column MB_MR_RECORD.mrltescaoa
  is 'TD-LTE服务小区的eNB天线到达角
';
comment on column MB_MR_RECORD.mrltescplrdlqcix
  is 'TD-LTE服务小区的上行信噪比
';
comment on column MB_MR_RECORD.freq_band
  is 'TD-LTE服务小区载波号
注：X=1…9';
comment on column MB_MR_RECORD.mrltescsinrul
  is 'TD-LTE服务小区的物理小区识别码
';
comment on column MB_MR_RECORD.mrltescearfcn
  is 'TD-LTE已定义邻区关系和未定义邻区关系的邻区载波号
';
comment on column MB_MR_RECORD.mrltescpci
  is 'TD-LTE已定义邻区关系和未定义邻区关系的物理小区识别码
';

prompt
prompt Creating table MB_OMC_LO_LA
prompt ===========================
prompt
create table MB_OMC_LO_LA
(
  city        VARCHAR2(32),
  enodeb_id   VARCHAR2(64),
  enodeb_name VARCHAR2(256),
  longitude   NUMBER(12,8),
  latitude    NUMBER(12,8),
  record_time TIMESTAMP(6)
)
;
comment on table MB_OMC_LO_LA
  is 'OMC提供的经纬度';
comment on column MB_OMC_LO_LA.city
  is '地市';
comment on column MB_OMC_LO_LA.enodeb_id
  is 'ENODEB_ID（OMC现网）';
comment on column MB_OMC_LO_LA.enodeb_name
  is '站名（OMC现网）';
comment on column MB_OMC_LO_LA.longitude
  is '经度';
comment on column MB_OMC_LO_LA.latitude
  is '纬度';
comment on column MB_OMC_LO_LA.record_time
  is '日期';

prompt
prompt Creating table MB_PERF_GSM_BUSISTAT
prompt ===================================
prompt
create table MB_PERF_GSM_BUSISTAT
(
  cell_glb_id VARCHAR2(256),
  cell_id     NUMBER(12),
  cell_name   VARCHAR2(256),
  cycle_date  TIMESTAMP(6),
  period      VARCHAR2(4),
  traffic     NUMBER(20,8),
  gprs_throu  NUMBER(20,8),
  egprs_throu NUMBER(20,8),
  oper_time   TIMESTAMP(6),
  record_time TIMESTAMP(6),
  city        VARCHAR2(32)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_PERF_GSM_BUSISTAT
  is 'GSM话统数据';
comment on column MB_PERF_GSM_BUSISTAT.cell_glb_id
  is 'GSM小区的全局ID编号
';
comment on column MB_PERF_GSM_BUSISTAT.cell_id
  is 'GSM小区ID
';
comment on column MB_PERF_GSM_BUSISTAT.cell_name
  is '小区名称
';
comment on column MB_PERF_GSM_BUSISTAT.cycle_date
  is '统计周期
';
comment on column MB_PERF_GSM_BUSISTAT.period
  is '统计粒度
';
comment on column MB_PERF_GSM_BUSISTAT.traffic
  is 'GSM话务量
';
comment on column MB_PERF_GSM_BUSISTAT.gprs_throu
  is 'Gprs流量
';
comment on column MB_PERF_GSM_BUSISTAT.egprs_throu
  is 'Egprs流量
';
comment on column MB_PERF_GSM_BUSISTAT.oper_time
  is '统计入库完成时间
';
comment on column MB_PERF_GSM_BUSISTAT.record_time
  is '记录时间';
comment on column MB_PERF_GSM_BUSISTAT.city
  is '城市';
create index GSM_TARFFIC_INDEX on MB_PERF_GSM_BUSISTAT (RECORD_TIME);

prompt
prompt Creating table MB_PERF_LTE_CELLBUSISTAT
prompt =======================================
prompt
create table MB_PERF_LTE_CELLBUSISTAT
(
  cell_glb_id         VARCHAR2(256),
  cell_id             VARCHAR2(32),
  cell_name           VARCHAR2(256),
  record_time         TIMESTAMP(6),
  period              VARCHAR2(32),
  pusch_prbs_used     NUMBER(20,8),
  uplink_prbs         NUMBER(20,8),
  pdsch_prbs_used     NUMBER(20,8),
  downlink_prbs       NUMBER(20,8),
  pdcp_uplink_throu   NUMBER(20,8),
  pdcp_downlink_throu NUMBER(20,8),
  oper_time           TIMESTAMP(6),
  city                VARCHAR2(32)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_PERF_LTE_CELLBUSISTAT
  is 'LTE话统数据';
comment on column MB_PERF_LTE_CELLBUSISTAT.cell_glb_id
  is '小区的全局ID编号
';
comment on column MB_PERF_LTE_CELLBUSISTAT.cell_id
  is '小区ID
';
comment on column MB_PERF_LTE_CELLBUSISTAT.cell_name
  is '小区名称
';
comment on column MB_PERF_LTE_CELLBUSISTAT.record_time
  is '记录时间';
comment on column MB_PERF_LTE_CELLBUSISTAT.period
  is '统计粒度
';
comment on column MB_PERF_LTE_CELLBUSISTAT.pusch_prbs_used
  is '小区载频PUSCH实际使用PRB个数
';
comment on column MB_PERF_LTE_CELLBUSISTAT.uplink_prbs
  is '小区上行信道可用的PRB个数
';
comment on column MB_PERF_LTE_CELLBUSISTAT.pdsch_prbs_used
  is '小区载频PDSCH实际使用PRB个数
';
comment on column MB_PERF_LTE_CELLBUSISTAT.downlink_prbs
  is '小区下行信道可用的PRB个数
';
comment on column MB_PERF_LTE_CELLBUSISTAT.pdcp_uplink_throu
  is '小区载频PDSCH实际使用PRB个数
';
comment on column MB_PERF_LTE_CELLBUSISTAT.pdcp_downlink_throu
  is '小区下行信道可用的PRB个数
';
comment on column MB_PERF_LTE_CELLBUSISTAT.oper_time
  is '统计入库完成时间
';
comment on column MB_PERF_LTE_CELLBUSISTAT.city
  is '城市';
create index LTE_TRAFFIC_INDEX on MB_PERF_LTE_CELLBUSISTAT (RECORD_TIME);

prompt
prompt Creating table MB_PERF_TDS_BUSISTAT
prompt ===================================
prompt
create table MB_PERF_TDS_BUSISTAT
(
  cell_glb_id VARCHAR2(32),
  cell_id     VARCHAR2(32),
  cell_name   VARCHAR2(256),
  period      VARCHAR2(32),
  traffic     NUMBER(20,8),
  hs_throu    NUMBER(20,8),
  r9_throu    NUMBER(20,8),
  oper_time   TIMESTAMP(6),
  record_time TIMESTAMP(6),
  city        VARCHAR2(32)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_PERF_TDS_BUSISTAT
  is 'TDS话统数据';
comment on column MB_PERF_TDS_BUSISTAT.cell_glb_id
  is 'TDS小区的全局ID编号
';
comment on column MB_PERF_TDS_BUSISTAT.cell_id
  is 'TDS小区ID
';
comment on column MB_PERF_TDS_BUSISTAT.cell_name
  is '小区名称
';
comment on column MB_PERF_TDS_BUSISTAT.period
  is '统计粒度
';
comment on column MB_PERF_TDS_BUSISTAT.traffic
  is 'TDS话务量
';
comment on column MB_PERF_TDS_BUSISTAT.hs_throu
  is 'HS流量
';
comment on column MB_PERF_TDS_BUSISTAT.r9_throu
  is 'R9流量
';
comment on column MB_PERF_TDS_BUSISTAT.oper_time
  is '统计入库完成时间
';
comment on column MB_PERF_TDS_BUSISTAT.record_time
  is '记录日期';
comment on column MB_PERF_TDS_BUSISTAT.city
  is '城市';
create index TDS_TRAFFIC_INDEX on MB_PERF_TDS_BUSISTAT (RECORD_TIME);

prompt
prompt Creating table MB_PLAN_7DAYS_ONLINE
prompt ===================================
prompt
create table MB_PLAN_7DAYS_ONLINE
(
  record_time      TIMESTAMP(6),
  city             VARCHAR2(32),
  project_period   VARCHAR2(32),
  enodeb_glb_id    VARCHAR2(256),
  online_mark7days NUMBER(2),
  penodebid        VARCHAR2(32)
)
partition by range (RECORD_TIME)
(
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_PLAN_7DAYS_ONLINE
  is '7天在线统计-存储过程  by huangc';
comment on column MB_PLAN_7DAYS_ONLINE.record_time
  is '日期';
comment on column MB_PLAN_7DAYS_ONLINE.city
  is '城市';
comment on column MB_PLAN_7DAYS_ONLINE.project_period
  is '工期号';
comment on column MB_PLAN_7DAYS_ONLINE.enodeb_glb_id
  is '基站全局ID';
comment on column MB_PLAN_7DAYS_ONLINE.online_mark7days
  is '是否连续7天在线';
comment on column MB_PLAN_7DAYS_ONLINE.penodebid
  is '基站ID';

prompt
prompt Creating table MB_PLAN_7DAYS_ONLINE_BAK
prompt =======================================
prompt
create table MB_PLAN_7DAYS_ONLINE_BAK
(
  record_time      TIMESTAMP(6),
  city             VARCHAR2(32),
  project_period   VARCHAR2(32),
  enodeb_glb_id    VARCHAR2(256),
  online_mark7days NUMBER(2),
  penodebid        VARCHAR2(32)
)
;

prompt
prompt Creating table MB_PLAN_LTECELL_INFO
prompt ===================================
prompt
create table MB_PLAN_LTECELL_INFO
(
  record_time  TIMESTAMP(6),
  cell_id      VARCHAR2(32),
  city         VARCHAR2(32),
  contry       VARCHAR2(32),
  min_distance NUMBER(16,8),
  projectphase VARCHAR2(32),
  cover_type   VARCHAR2(32),
  high         NUMBER(16,8),
  longitude    NUMBER(12,8),
  latitude     NUMBER(12,8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_PLAN_LTECELL_INFO
  is 'LTE规划小区数据';
comment on column MB_PLAN_LTECELL_INFO.record_time
  is '时间';
comment on column MB_PLAN_LTECELL_INFO.cell_id
  is '规划小区级唯一标识';
comment on column MB_PLAN_LTECELL_INFO.city
  is '地市';
comment on column MB_PLAN_LTECELL_INFO.contry
  is '区县';
comment on column MB_PLAN_LTECELL_INFO.min_distance
  is '最小站间距';
comment on column MB_PLAN_LTECELL_INFO.projectphase
  is '工程期别';
comment on column MB_PLAN_LTECELL_INFO.cover_type
  is '覆盖区域';
comment on column MB_PLAN_LTECELL_INFO.high
  is '天线挂高';
comment on column MB_PLAN_LTECELL_INFO.longitude
  is '经度';
comment on column MB_PLAN_LTECELL_INFO.latitude
  is '纬度';
create index PLAN_LTE_CELL_INDEX on MB_PLAN_LTECELL_INFO (RECORD_TIME);

prompt
prompt Creating table MB_PLAN_LTESITE_INFO
prompt ===================================
prompt
create table MB_PLAN_LTESITE_INFO
(
  record_time             TIMESTAMP(6),
  penodebclass            VARCHAR2(128),
  penodebname             VARCHAR2(128),
  province_name           VARCHAR2(64),
  city_name               VARCHAR2(64),
  longitude               NUMBER(12,8),
  latitude                NUMBER(12,8),
  country_name            VARCHAR2(64),
  regiontype              VARCHAR2(64),
  projectphase            VARCHAR2(64),
  penodebid               VARCHAR2(64),
  isopen                  VARCHAR2(64),
  coveragecharacter       VARCHAR2(64),
  work_frqband            VARCHAR2(64),
  ischeck                 VARCHAR2(64),
  isnodebname             VARCHAR2(128),
  ischecklon              NUMBER(12,8),
  ischecklat              NUMBER(12,8),
  azimuthcell1            NUMBER(8),
  azimuthcell2            NUMBER(8),
  azimuthcell3            NUMBER(8),
  heightcell1             NUMBER(8),
  heightcell2             NUMBER(8),
  heightcell3             NUMBER(8),
  downtiltcell1           NUMBER(8),
  downtiltcell2           NUMBER(8),
  downtiltcell3           NUMBER(8),
  electricaldowntiltcell1 NUMBER(8),
  electricaldowntiltcell2 NUMBER(8),
  electricaldowntiltcell3 NUMBER(8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_PLAN_LTESITE_INFO
  is 'LTE规划基站数据';
comment on column MB_PLAN_LTESITE_INFO.record_time
  is '时间
';
comment on column MB_PLAN_LTESITE_INFO.penodebclass
  is '规划编号(*必填)
';
comment on column MB_PLAN_LTESITE_INFO.penodebname
  is '规划站名(*必填)
';
comment on column MB_PLAN_LTESITE_INFO.province_name
  is '省份
';
comment on column MB_PLAN_LTESITE_INFO.city_name
  is '地市(*必填)
';
comment on column MB_PLAN_LTESITE_INFO.longitude
  is '规划经度
';
comment on column MB_PLAN_LTESITE_INFO.latitude
  is '规划纬度
';
comment on column MB_PLAN_LTESITE_INFO.country_name
  is '区县
';
comment on column MB_PLAN_LTESITE_INFO.regiontype
  is '区域类型
';
comment on column MB_PLAN_LTESITE_INFO.projectphase
  is '工程期别
';
comment on column MB_PLAN_LTESITE_INFO.penodebid
  is '规划基站标识
';
comment on column MB_PLAN_LTESITE_INFO.isopen
  is '是否开通
';
comment on column MB_PLAN_LTESITE_INFO.coveragecharacter
  is '基站类别(宏站、室分)
';
comment on column MB_PLAN_LTESITE_INFO.work_frqband
  is '使用频段
';
comment on column MB_PLAN_LTESITE_INFO.ischeck
  is '是否查勘
';
comment on column MB_PLAN_LTESITE_INFO.isnodebname
  is '查勘站名
';
comment on column MB_PLAN_LTESITE_INFO.ischecklon
  is '查勘经度
';
comment on column MB_PLAN_LTESITE_INFO.ischecklat
  is '查勘纬度
';
comment on column MB_PLAN_LTESITE_INFO.azimuthcell1
  is '现场查勘方向角CELL1
';
comment on column MB_PLAN_LTESITE_INFO.azimuthcell2
  is '现场查勘方向角CELL2
';
comment on column MB_PLAN_LTESITE_INFO.azimuthcell3
  is '现场查勘方向角CELL3
';
comment on column MB_PLAN_LTESITE_INFO.heightcell1
  is '现查勘挂高CELL1
';
comment on column MB_PLAN_LTESITE_INFO.heightcell2
  is '现查勘挂高CELL2
';
comment on column MB_PLAN_LTESITE_INFO.heightcell3
  is '现查勘挂高CELL3
';
comment on column MB_PLAN_LTESITE_INFO.downtiltcell1
  is '现场查勘总下倾角CELL1
';
comment on column MB_PLAN_LTESITE_INFO.downtiltcell2
  is '现场查勘总下倾角CELL2
';
comment on column MB_PLAN_LTESITE_INFO.downtiltcell3
  is '现场查勘总下倾角CELL3
';
comment on column MB_PLAN_LTESITE_INFO.electricaldowntiltcell1
  is '现场查勘电下倾角CELL1
';
comment on column MB_PLAN_LTESITE_INFO.electricaldowntiltcell2
  is '现场查勘电下倾角CELL2
';
comment on column MB_PLAN_LTESITE_INFO.electricaldowntiltcell3
  is '现场查勘电下倾角CELL3
';
create index PLAN_LTE_SITE_INDEX on MB_PLAN_LTESITE_INFO (RECORD_TIME);

prompt
prompt Creating table MB_SYS_GIS_GSMPERMISSION
prompt =======================================
prompt
create table MB_SYS_GIS_GSMPERMISSION
(
  province    VARCHAR2(64),
  city        VARCHAR2(64),
  county      VARCHAR2(256),
  bsc_name    VARCHAR2(256),
  site_name   VARCHAR2(256),
  netgrid     VARCHAR2(256),
  environ     VARCHAR2(256),
  vendor      VARCHAR2(256),
  record_time TIMESTAMP(6),
  update_time TIMESTAMP(6),
  update_user VARCHAR2(256),
  site_glb_id VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_GIS_GSMPERMISSION
  is '2G基站地理位置信息表';
comment on column MB_SYS_GIS_GSMPERMISSION.province
  is '省份
';
comment on column MB_SYS_GIS_GSMPERMISSION.city
  is '城市
';
comment on column MB_SYS_GIS_GSMPERMISSION.county
  is '区县
';
comment on column MB_SYS_GIS_GSMPERMISSION.bsc_name
  is 'bscname
';
comment on column MB_SYS_GIS_GSMPERMISSION.site_name
  is '基站名称
';
comment on column MB_SYS_GIS_GSMPERMISSION.netgrid
  is '网格
';
comment on column MB_SYS_GIS_GSMPERMISSION.environ
  is '场景
';
comment on column MB_SYS_GIS_GSMPERMISSION.vendor
  is '厂家
';
comment on column MB_SYS_GIS_GSMPERMISSION.record_time
  is '记录时间
';
comment on column MB_SYS_GIS_GSMPERMISSION.update_time
  is '更新时间
';
comment on column MB_SYS_GIS_GSMPERMISSION.update_user
  is '更新人
';
comment on column MB_SYS_GIS_GSMPERMISSION.site_glb_id
  is '基站的全局ID编号
';
create index SYS_GIS_GSMPERM_INDEX on MB_SYS_GIS_GSMPERMISSION (RECORD_TIME);

prompt
prompt Creating table MB_SYS_GIS_PERMISSION
prompt ====================================
prompt
create table MB_SYS_GIS_PERMISSION
(
  province      VARCHAR2(64),
  city          VARCHAR2(64),
  county        VARCHAR2(256),
  enodeb_glb_id VARCHAR2(32),
  enodeb_id     VARCHAR2(256),
  enodeb_name   VARCHAR2(256),
  netgrid       VARCHAR2(256),
  environ       VARCHAR2(256),
  vendor        VARCHAR2(256),
  record_time   TIMESTAMP(6),
  update_time   TIMESTAMP(6),
  update_user   VARCHAR2(32),
  address       VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_GIS_PERMISSION
  is '4G基站地理位置信息表';
comment on column MB_SYS_GIS_PERMISSION.province
  is '省份';
comment on column MB_SYS_GIS_PERMISSION.city
  is '城市';
comment on column MB_SYS_GIS_PERMISSION.county
  is '区县';
comment on column MB_SYS_GIS_PERMISSION.enodeb_glb_id
  is '基站全局标识';
comment on column MB_SYS_GIS_PERMISSION.enodeb_id
  is '基站标识';
comment on column MB_SYS_GIS_PERMISSION.enodeb_name
  is '基站名称';
comment on column MB_SYS_GIS_PERMISSION.netgrid
  is '网格';
comment on column MB_SYS_GIS_PERMISSION.environ
  is '场景';
comment on column MB_SYS_GIS_PERMISSION.vendor
  is '厂家';
comment on column MB_SYS_GIS_PERMISSION.record_time
  is '记录日期';
comment on column MB_SYS_GIS_PERMISSION.update_time
  is '更新时间';
comment on column MB_SYS_GIS_PERMISSION.update_user
  is '更新人';
comment on column MB_SYS_GIS_PERMISSION.address
  is '地址';
create index IDX_GIS_PERMISSION_ENGLBID on MB_SYS_GIS_PERMISSION (ENODEB_GLB_ID);
create index IDX_GIS_PERMISSION_RECORDT on MB_SYS_GIS_PERMISSION (RECORD_TIME);

prompt
prompt Creating table MB_SYS_GIS_TDSPERMISSION
prompt =======================================
prompt
create table MB_SYS_GIS_TDSPERMISSION
(
  province    VARCHAR2(64),
  city        VARCHAR2(64),
  county      VARCHAR2(256),
  rncid       VARCHAR2(256),
  site_oid    VARCHAR2(256),
  site_name   VARCHAR2(256),
  netgrid     VARCHAR2(256),
  environ     VARCHAR2(256),
  vendor      VARCHAR2(256),
  record_time TIMESTAMP(6),
  update_time TIMESTAMP(6),
  update_user VARCHAR2(256),
  site_glb_id VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_GIS_TDSPERMISSION
  is '3G基站地理位置信息表';
comment on column MB_SYS_GIS_TDSPERMISSION.province
  is '省份
';
comment on column MB_SYS_GIS_TDSPERMISSION.city
  is '城市
';
comment on column MB_SYS_GIS_TDSPERMISSION.county
  is '区县
';
comment on column MB_SYS_GIS_TDSPERMISSION.rncid
  is 'RNC标识
';
comment on column MB_SYS_GIS_TDSPERMISSION.site_oid
  is '基站标识
';
comment on column MB_SYS_GIS_TDSPERMISSION.site_name
  is '基站名称
';
comment on column MB_SYS_GIS_TDSPERMISSION.netgrid
  is '网格
';
comment on column MB_SYS_GIS_TDSPERMISSION.environ
  is '场景
';
comment on column MB_SYS_GIS_TDSPERMISSION.vendor
  is '厂家
';
comment on column MB_SYS_GIS_TDSPERMISSION.record_time
  is '记录时间
';
comment on column MB_SYS_GIS_TDSPERMISSION.update_time
  is '更新时间
';
comment on column MB_SYS_GIS_TDSPERMISSION.update_user
  is '更新人
';
comment on column MB_SYS_GIS_TDSPERMISSION.site_glb_id
  is '基站的全局ID编号
';
create index SYS_GIS_TDSPERM_INDEX on MB_SYS_GIS_TDSPERMISSION (RECORD_TIME);

prompt
prompt Creating table MB_SYS_GSMCELL_INFO
prompt ==================================
prompt
create table MB_SYS_GSMCELL_INFO
(
  cell_id                   NUMBER(12),
  cell_name                 VARCHAR2(256),
  cell_english_name         VARCHAR2(256),
  site_id                   VARCHAR2(32),
  cgi                       VARCHAR2(32),
  rru_remote                VARCHAR2(32),
  cell_longitude            NUMBER(8),
  cell_latitude             NUMBER(8),
  sector_id                 NUMBER(4),
  powerdivisiontype         VARCHAR2(32),
  powerdivisionindex        VARCHAR2(32),
  ncc                       VARCHAR2(32),
  bcc                       VARCHAR2(32),
  bcch                      VARCHAR2(32),
  covertype                 VARCHAR2(256),
  bandindicatorforfrequency VARCHAR2(256),
  rac                       VARCHAR2(256),
  record_time               TIMESTAMP(6),
  uptime_time               TIMESTAMP(6),
  update_user               VARCHAR2(256),
  cell_glb_id               VARCHAR2(256),
  site_glb_id               VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_GSMCELL_INFO
  is '2G小区信息表';
comment on column MB_SYS_GSMCELL_INFO.cell_id
  is '小区ID
';
comment on column MB_SYS_GSMCELL_INFO.cell_name
  is '小区名称
';
comment on column MB_SYS_GSMCELL_INFO.cell_english_name
  is '小区英文名称
';
comment on column MB_SYS_GSMCELL_INFO.site_id
  is '基站标识
';
comment on column MB_SYS_GSMCELL_INFO.cgi
  is '全球小区ID
';
comment on column MB_SYS_GSMCELL_INFO.rru_remote
  is '是否拉远小区
';
comment on column MB_SYS_GSMCELL_INFO.cell_longitude
  is '小区经度
';
comment on column MB_SYS_GSMCELL_INFO.cell_latitude
  is '小区纬度
';
comment on column MB_SYS_GSMCELL_INFO.sector_id
  is '本地小区标识
';
comment on column MB_SYS_GSMCELL_INFO.powerdivisiontype
  is '功分类型
';
comment on column MB_SYS_GSMCELL_INFO.powerdivisionindex
  is '功分索引
';
comment on column MB_SYS_GSMCELL_INFO.ncc
  is '网络色码
';
comment on column MB_SYS_GSMCELL_INFO.bcc
  is '基站色码
';
comment on column MB_SYS_GSMCELL_INFO.bcch
  is '主BCCH频点
';
comment on column MB_SYS_GSMCELL_INFO.covertype
  is '覆盖类型
';
comment on column MB_SYS_GSMCELL_INFO.bandindicatorforfrequency
  is '频带指示
';
comment on column MB_SYS_GSMCELL_INFO.rac
  is '小区路由区域码
';
comment on column MB_SYS_GSMCELL_INFO.record_time
  is '录入时间
';
comment on column MB_SYS_GSMCELL_INFO.uptime_time
  is '更新时间
';
comment on column MB_SYS_GSMCELL_INFO.update_user
  is '更新人
';
comment on column MB_SYS_GSMCELL_INFO.cell_glb_id
  is '小区的全局ID编号
';
comment on column MB_SYS_GSMCELL_INFO.site_glb_id
  is '基站的全局ID编号
';

prompt
prompt Creating table MB_SYS_GSMCELL_RF
prompt ================================
prompt
create table MB_SYS_GSMCELL_RF
(
  cell_id      NUMBER(8),
  cell_name    VARCHAR2(128),
  azimuth      NUMBER(8),
  height       NUMBER(8),
  mtilt        VARCHAR2(128),
  etilt        VARCHAR2(128),
  antenna      VARCHAR2(128),
  fake_antenna NUMBER(1),
  update_time  TIMESTAMP(6),
  record_time  TIMESTAMP(6),
  update_user  VARCHAR2(128),
  cell_glb_id  VARCHAR2(256),
  site_glb_id  VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_GSMCELL_RF
  is '2G小区RF表';
comment on column MB_SYS_GSMCELL_RF.cell_id
  is '小区ID
';
comment on column MB_SYS_GSMCELL_RF.cell_name
  is '小区中文名
';
comment on column MB_SYS_GSMCELL_RF.azimuth
  is '天线方向角
';
comment on column MB_SYS_GSMCELL_RF.height
  is '天线挂高
';
comment on column MB_SYS_GSMCELL_RF.mtilt
  is '天线机械下倾角
';
comment on column MB_SYS_GSMCELL_RF.etilt
  is '天线电子下倾角
';
comment on column MB_SYS_GSMCELL_RF.antenna
  is '天线型号
';
comment on column MB_SYS_GSMCELL_RF.fake_antenna
  is '是否美化
';
comment on column MB_SYS_GSMCELL_RF.update_time
  is '更新时间
';
comment on column MB_SYS_GSMCELL_RF.record_time
  is '记录时间
';
comment on column MB_SYS_GSMCELL_RF.update_user
  is '更新人
';
comment on column MB_SYS_GSMCELL_RF.cell_glb_id
  is '小区的全局ID编号
';
comment on column MB_SYS_GSMCELL_RF.site_glb_id
  is '基站的全局ID编号
';

prompt
prompt Creating table MB_SYS_GSMSITE_INFO
prompt ==================================
prompt
create table MB_SYS_GSMSITE_INFO
(
  bsc_id      VARCHAR2(64),
  site_id     VARCHAR2(256),
  site_name   VARCHAR2(256),
  lac         NUMBER(8),
  vendor      VARCHAR2(32),
  longitude   NUMBER(4,8),
  latitude    NUMBER(4,8),
  netgrid     NUMBER(4),
  environ     VARCHAR2(256),
  freq_band   VARCHAR2(8),
  cover_type  NUMBER(4),
  record_time TIMESTAMP(6),
  update_time TIMESTAMP(6),
  update_user VARCHAR2(256),
  site_glb_id VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_GSMSITE_INFO
  is '2G基站信息表';
comment on column MB_SYS_GSMSITE_INFO.bsc_id
  is 'BSC_name
';
comment on column MB_SYS_GSMSITE_INFO.site_id
  is '基站标识
';
comment on column MB_SYS_GSMSITE_INFO.site_name
  is '基站名称
';
comment on column MB_SYS_GSMSITE_INFO.lac
  is '跟踪区域码
';
comment on column MB_SYS_GSMSITE_INFO.vendor
  is '设备厂家
';
comment on column MB_SYS_GSMSITE_INFO.longitude
  is '经度
';
comment on column MB_SYS_GSMSITE_INFO.latitude
  is '纬度
';
comment on column MB_SYS_GSMSITE_INFO.netgrid
  is '网格号
';
comment on column MB_SYS_GSMSITE_INFO.environ
  is '场景
';
comment on column MB_SYS_GSMSITE_INFO.freq_band
  is '频段
';
comment on column MB_SYS_GSMSITE_INFO.cover_type
  is '覆盖类型
';
comment on column MB_SYS_GSMSITE_INFO.record_time
  is '录入时间
';
comment on column MB_SYS_GSMSITE_INFO.update_time
  is '参数更新时间
';
comment on column MB_SYS_GSMSITE_INFO.update_user
  is '更新人
';
comment on column MB_SYS_GSMSITE_INFO.site_glb_id
  is '基站的全局ID编号
';

prompt
prompt Creating table MB_SYS_LTECELL_GSMNBR
prompt ====================================
prompt
create table MB_SYS_LTECELL_GSMNBR
(
  cgi            VARCHAR2(128),
  name           VARCHAR2(128),
  object_rdn     VARCHAR2(256),
  zh_name        VARCHAR2(128),
  omc_id         VARCHAR2(128),
  city           VARCHAR2(128),
  vendor_id      VARCHAR2(128),
  time_stamp     TIMESTAMP(6),
  update_stamp   TIMESTAMP(6),
  confirmed      VARCHAR2(128),
  tac            VARCHAR2(128),
  pci            VARCHAR2(128),
  earfcn         VARCHAR2(128),
  adj_gsm_frqlst VARCHAR2(512),
  m_name         VARCHAR2(512),
  n_name         VARCHAR2(128),
  id             VARCHAR2(128),
  adjacentcellid VARCHAR2(128),
  bcch           VARCHAR2(128),
  ncc            VARCHAR2(128),
  bcc            VARCHAR2(128),
  rac            VARCHAR2(128),
  update_user    VARCHAR2(256),
  distance       NUMBER(8),
  record_time    TIMESTAMP(6)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_SYS_LTECELL_GSMNBR.cgi
  is '全球网络标识';
comment on column MB_SYS_LTECELL_GSMNBR.name
  is '用户友好名
';
comment on column MB_SYS_LTECELL_GSMNBR.object_rdn
  is '资源对象唯一标识
';
comment on column MB_SYS_LTECELL_GSMNBR.zh_name
  is '中文名称
';
comment on column MB_SYS_LTECELL_GSMNBR.omc_id
  is 'OMC_ID
';
comment on column MB_SYS_LTECELL_GSMNBR.city
  is '地市
';
comment on column MB_SYS_LTECELL_GSMNBR.vendor_id
  is '设备厂家ID
';
comment on column MB_SYS_LTECELL_GSMNBR.time_stamp
  is '数据采集时间戳
';
comment on column MB_SYS_LTECELL_GSMNBR.update_stamp
  is '数据更新时间戳
';
comment on column MB_SYS_LTECELL_GSMNBR.confirmed
  is '删除或增加的确认
';
comment on column MB_SYS_LTECELL_GSMNBR.tac
  is '源小区跟踪区标识
';
comment on column MB_SYS_LTECELL_GSMNBR.pci
  is '源小区物理小区标识
';
comment on column MB_SYS_LTECELL_GSMNBR.earfcn
  is '源小区中心载频的信道号
';
comment on column MB_SYS_LTECELL_GSMNBR.adj_gsm_frqlst
  is '邻区频点列表';
comment on column MB_SYS_LTECELL_GSMNBR.m_name
  is '主小区名称
';
comment on column MB_SYS_LTECELL_GSMNBR.n_name
  is '邻小区名称
';
comment on column MB_SYS_LTECELL_GSMNBR.id
  is '标识符
';
comment on column MB_SYS_LTECELL_GSMNBR.adjacentcellid
  is '相邻小区的标识
';
comment on column MB_SYS_LTECELL_GSMNBR.bcch
  is 'Bcch信道载频
';
comment on column MB_SYS_LTECELL_GSMNBR.ncc
  is '网络色码
';
comment on column MB_SYS_LTECELL_GSMNBR.bcc
  is '基站色码
';
comment on column MB_SYS_LTECELL_GSMNBR.rac
  is '路由区编码
';
comment on column MB_SYS_LTECELL_GSMNBR.update_user
  is '更新人';
comment on column MB_SYS_LTECELL_GSMNBR.distance
  is '距离';
comment on column MB_SYS_LTECELL_GSMNBR.record_time
  is '记录日期';

prompt
prompt Creating table MB_SYS_LTECELL_INFO
prompt ==================================
prompt
create table MB_SYS_LTECELL_INFO
(
  cell_glb_id       VARCHAR2(256),
  enodeb_glb_id     VARCHAR2(256),
  cell_id           VARCHAR2(256),
  cell_name         VARCHAR2(256),
  cell_english_name VARCHAR2(256),
  cgi               VARCHAR2(32),
  sector_id         NUMBER(4),
  pci               NUMBER(4),
  earfcn            NUMBER(8),
  rf_power          NUMBER(16,8),
  sfassign          VARCHAR2(16),
  sepcsfpattern     VARCHAR2(16),
  record_time       TIMESTAMP(6),
  update_time       TIMESTAMP(6),
  update_user       VARCHAR2(256),
  min_distance      NUMBER(16,8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_LTECELL_INFO
  is '4G小区信息表';
comment on column MB_SYS_LTECELL_INFO.cell_glb_id
  is '小区的全局ID编号
';
comment on column MB_SYS_LTECELL_INFO.enodeb_glb_id
  is '基站的全局ID编号
';
comment on column MB_SYS_LTECELL_INFO.cell_id
  is '小区ID
';
comment on column MB_SYS_LTECELL_INFO.cell_name
  is '小区名称
';
comment on column MB_SYS_LTECELL_INFO.cell_english_name
  is '小区英文名称
';
comment on column MB_SYS_LTECELL_INFO.cgi
  is '全球小区ID
';
comment on column MB_SYS_LTECELL_INFO.sector_id
  is '本地小区标识
';
comment on column MB_SYS_LTECELL_INFO.pci
  is '物理小区标识（PCI)
';
comment on column MB_SYS_LTECELL_INFO.earfcn
  is '下行频点
';
comment on column MB_SYS_LTECELL_INFO.rf_power
  is '参考信号功率
';
comment on column MB_SYS_LTECELL_INFO.sfassign
  is '上下行子帧配比
';
comment on column MB_SYS_LTECELL_INFO.sepcsfpattern
  is '特殊子帧配比
';
comment on column MB_SYS_LTECELL_INFO.record_time
  is '记录时间
';
comment on column MB_SYS_LTECELL_INFO.update_time
  is '更新时间
';
comment on column MB_SYS_LTECELL_INFO.update_user
  is '更新人
';
comment on column MB_SYS_LTECELL_INFO.min_distance
  is '最小站间距';
create index IDX_LTECELL_CELLGLBID on MB_SYS_LTECELL_INFO (CELL_GLB_ID);
create index IDX_SYSCELLSITE_ENGLBID on MB_SYS_LTECELL_INFO (ENODEB_GLB_ID);
create index IDX_SYSLTECELL_RECORDTIME on MB_SYS_LTECELL_INFO (RECORD_TIME);

prompt
prompt Creating table MB_SYS_LTECELL_INFO_T
prompt ====================================
prompt
create table MB_SYS_LTECELL_INFO_T
(
  int_id                   VARCHAR2(256),
  object_rdn               VARCHAR2(512),
  name                     VARCHAR2(256),
  zh_name                  VARCHAR2(256),
  omc_id                   NUMBER(8),
  vendor_id                VARCHAR2(16),
  city_id                  VARCHAR2(16),
  time_stamp               TIMESTAMP(6),
  update_stamp             TIMESTAMP(6),
  confirmed                VARCHAR2(16),
  state                    VARCHAR2(16),
  related_enodeb           VARCHAR2(256),
  cgi                      VARCHAR2(256),
  eutrancell_id            VARCHAR2(256),
  cell_identity            NUMBER(8),
  cell_type                VARCHAR2(16),
  cellsize                 VARCHAR2(16),
  plmnidlist               VARCHAR2(64),
  tac                      NUMBER(8),
  pci                      NUMBER(8),
  pcilist                  VARCHAR2(512),
  maximumtransmissionpower NUMBER(8,4),
  referencesignalpower     NUMBER(8,4),
  pb                       NUMBER(8,4),
  part_of_sectorpower      NUMBER(8,4),
  administrativestate      NUMBER(4),
  operationalstate         NUMBER(4),
  celllocalid              NUMBER(4),
  relatedrrulist           VARCHAR2(512),
  relatedantennalist       VARCHAR2(512),
  cellresvinfo             VARCHAR2(512),
  bandindicator            NUMBER(4),
  earfcn                   NUMBER(8),
  bandwidth                NUMBER(6),
  sfassignment             NUMBER(4),
  specialsfpatterns        NUMBER(4),
  mbmsswitch               NUMBER(4),
  adj_td_num               NUMBER(4),
  adj_lte_num              NUMBER(4),
  adj_gsm_num              NUMBER(4),
  u_sf_num                 NUMBER(4),
  d_sf_num                 NUMBER(4),
  totalprb                 NUMBER(4),
  ecarrier_num             NUMBER(4),
  dwpts_over_9             NUMBER(4),
  adj_lte_frqlst           VARCHAR2(512),
  adj_td_frqlst            VARCHAR2(512),
  adj_gsm_frqlst           VARCHAR2(512),
  cell_glb_id              VARCHAR2(32),
  record_time              TIMESTAMP(6)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_LTECELL_INFO_T
  is '4G小区信息临时表，会删除---by huangc';
comment on column MB_SYS_LTECELL_INFO_T.int_id
  is '唯一标识
';
comment on column MB_SYS_LTECELL_INFO_T.object_rdn
  is '小区DN号
';
comment on column MB_SYS_LTECELL_INFO_T.name
  is '小区英文名
';
comment on column MB_SYS_LTECELL_INFO_T.zh_name
  is '小区中文名
';
comment on column MB_SYS_LTECELL_INFO_T.omc_id
  is 'OMCID号
';
comment on column MB_SYS_LTECELL_INFO_T.vendor_id
  is '归属厂家
';
comment on column MB_SYS_LTECELL_INFO_T.city_id
  is '归属地市
';
comment on column MB_SYS_LTECELL_INFO_T.time_stamp
  is '更新时间
';
comment on column MB_SYS_LTECELL_INFO_T.update_stamp
  is '更新时间
';
comment on column MB_SYS_LTECELL_INFO_T.confirmed
  is '网元状态
';
comment on column MB_SYS_LTECELL_INFO_T.state
  is '设备维护状态
';
comment on column MB_SYS_LTECELL_INFO_T.related_enodeb
  is '归属基站INT_id号
';
comment on column MB_SYS_LTECELL_INFO_T.cgi
  is '全球小区识别码
';
comment on column MB_SYS_LTECELL_INFO_T.eutrancell_id
  is 'Eutrancell标识符
';
comment on column MB_SYS_LTECELL_INFO_T.cell_identity
  is '小区标识
';
comment on column MB_SYS_LTECELL_INFO_T.cell_type
  is '小区类型
';
comment on column MB_SYS_LTECELL_INFO_T.cellsize
  is '小区覆盖范围
';
comment on column MB_SYS_LTECELL_INFO_T.plmnidlist
  is 'PLMN标识的列表
';
comment on column MB_SYS_LTECELL_INFO_T.tac
  is '跟踪区码
';
comment on column MB_SYS_LTECELL_INFO_T.pci
  is '物理小区识别码
';
comment on column MB_SYS_LTECELL_INFO_T.pcilist
  is '物理小区识别码列表
';
comment on column MB_SYS_LTECELL_INFO_T.maximumtransmissionpower
  is '最大传输功率
';
comment on column MB_SYS_LTECELL_INFO_T.referencesignalpower
  is '参考信号功率
';
comment on column MB_SYS_LTECELL_INFO_T.pb
  is '天线端口信号功率比(PDSCH/RS的功率比值参数)
';
comment on column MB_SYS_LTECELL_INFO_T.part_of_sectorpower
  is '无线电传送功率中被请求的比例
';
comment on column MB_SYS_LTECELL_INFO_T.administrativestate
  is '管理状态
';
comment on column MB_SYS_LTECELL_INFO_T.operationalstate
  is '激活状态
';
comment on column MB_SYS_LTECELL_INFO_T.celllocalid
  is '本地小区标识
';
comment on column MB_SYS_LTECELL_INFO_T.relatedrrulist
  is '关联的RRU列表
';
comment on column MB_SYS_LTECELL_INFO_T.relatedantennalist
  is '相关联的天线列表
';
comment on column MB_SYS_LTECELL_INFO_T.bandindicator
  is '频段指示
';
comment on column MB_SYS_LTECELL_INFO_T.earfcn
  is '中心载频的信道号
';
comment on column MB_SYS_LTECELL_INFO_T.bandwidth
  is '小区带宽
';
comment on column MB_SYS_LTECELL_INFO_T.sfassignment
  is '上下行子帧配置
';
comment on column MB_SYS_LTECELL_INFO_T.specialsfpatterns
  is '特殊子帧模式
';
comment on column MB_SYS_LTECELL_INFO_T.mbmsswitch
  is '小区MBMS开关
';
comment on column MB_SYS_LTECELL_INFO_T.adj_td_num
  is 'LTE小区的TD邻区数量
';
comment on column MB_SYS_LTECELL_INFO_T.adj_lte_num
  is 'LTE小区的LTE邻区数量
';
comment on column MB_SYS_LTECELL_INFO_T.adj_gsm_num
  is 'LTE小区的GSM邻区数量
';
comment on column MB_SYS_LTECELL_INFO_T.u_sf_num
  is '上行子帧数
';
comment on column MB_SYS_LTECELL_INFO_T.d_sf_num
  is '下行子帧数
';
comment on column MB_SYS_LTECELL_INFO_T.totalprb
  is '小区PRB数
';
comment on column MB_SYS_LTECELL_INFO_T.ecarrier_num
  is '载频数量
';
comment on column MB_SYS_LTECELL_INFO_T.adj_lte_frqlst
  is 'EUTRANCELL的邻区频点列表
';
comment on column MB_SYS_LTECELL_INFO_T.adj_td_frqlst
  is '邻区频点列表
';
comment on column MB_SYS_LTECELL_INFO_T.adj_gsm_frqlst
  is 'GSM邻区频点列表
';
comment on column MB_SYS_LTECELL_INFO_T.cell_glb_id
  is 'CGI_MD5';
comment on column MB_SYS_LTECELL_INFO_T.record_time
  is '记录时间';
create index IDX_SYSLTECELL_CELLID on MB_SYS_LTECELL_INFO_T (CELL_GLB_ID);
create index IDX_SYSLTECELL_T_RECORDTIME on MB_SYS_LTECELL_INFO_T (RECORD_TIME);

prompt
prompt Creating table MB_SYS_LTECELL_LTENBR
prompt ====================================
prompt
create table MB_SYS_LTECELL_LTENBR
(
  cgi                          VARCHAR2(64),
  name                         VARCHAR2(256),
  object_rdn                   VARCHAR2(256),
  zh_name                      VARCHAR2(256),
  omc_id                       VARCHAR2(64),
  city                         VARCHAR2(64),
  vendor_id                    VARCHAR2(64),
  time_stamp                   TIMESTAMP(6),
  update_stamp                 TIMESTAMP(6),
  confirmed                    VARCHAR2(64),
  tac                          VARCHAR2(64),
  pci                          VARCHAR2(64),
  earfcn                       VARCHAR2(64),
  m_name                       VARCHAR2(256),
  n_name                       VARCHAR2(256),
  id                           VARCHAR2(64),
  tci                          VARCHAR2(64),
  ttac                         VARCHAR2(64),
  tpci                         VARCHAR2(64),
  isremoveallowed              VARCHAR2(64),
  ishoallowed                  VARCHAR2(64),
  isicicinformationsendallowed VARCHAR2(64),
  islballowed                  VARCHAR2(60),
  plmnidlist                   VARCHAR2(60),
  tearfcn                      VARCHAR2(60),
  cellindividualoffset         VARCHAR2(60),
  qoffsetcell                  VARCHAR2(60),
  update_user                  VARCHAR2(60),
  record_time                  TIMESTAMP(6)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_LTECELL_LTENBR
  is 'LTE邻LTE小区表';
comment on column MB_SYS_LTECELL_LTENBR.cgi
  is '全球网络标识
';
comment on column MB_SYS_LTECELL_LTENBR.name
  is '用户友好名
';
comment on column MB_SYS_LTECELL_LTENBR.object_rdn
  is '资源对象唯一标识
';
comment on column MB_SYS_LTECELL_LTENBR.zh_name
  is '中文名称
';
comment on column MB_SYS_LTECELL_LTENBR.omc_id
  is 'OMC_ID
';
comment on column MB_SYS_LTECELL_LTENBR.city
  is '城市
';
comment on column MB_SYS_LTECELL_LTENBR.vendor_id
  is '设备厂家';
comment on column MB_SYS_LTECELL_LTENBR.time_stamp
  is '数据采集时间戳
';
comment on column MB_SYS_LTECELL_LTENBR.update_stamp
  is '数据更新时间戳
';
comment on column MB_SYS_LTECELL_LTENBR.confirmed
  is '删除或增加的确认
';
comment on column MB_SYS_LTECELL_LTENBR.tac
  is '源小区跟踪区标识
';
comment on column MB_SYS_LTECELL_LTENBR.pci
  is '源小区物理小区标识
';
comment on column MB_SYS_LTECELL_LTENBR.earfcn
  is '源小区中心载频的信道号
';
comment on column MB_SYS_LTECELL_LTENBR.m_name
  is '主小区名称
';
comment on column MB_SYS_LTECELL_LTENBR.n_name
  is '邻小区名称
';
comment on column MB_SYS_LTECELL_LTENBR.id
  is '标识符
';
comment on column MB_SYS_LTECELL_LTENBR.tci
  is '目标小区标识';
comment on column MB_SYS_LTECELL_LTENBR.ttac
  is '目标小区跟踪区标识';
comment on column MB_SYS_LTECELL_LTENBR.tpci
  is '目标小区物理小区标识';
comment on column MB_SYS_LTECELL_LTENBR.isremoveallowed
  is '是否允许删除';
comment on column MB_SYS_LTECELL_LTENBR.ishoallowed
  is '是否允许切换出';
comment on column MB_SYS_LTECELL_LTENBR.isicicinformationsendallowed
  is '是否允许发送ICIC负载信息';
comment on column MB_SYS_LTECELL_LTENBR.islballowed
  is '负载均衡开关';
comment on column MB_SYS_LTECELL_LTENBR.plmnidlist
  is 'PLMN标识列表';
comment on column MB_SYS_LTECELL_LTENBR.tearfcn
  is '目标中心载频的信道号';
comment on column MB_SYS_LTECELL_LTENBR.cellindividualoffset
  is '小区个体偏移量';
comment on column MB_SYS_LTECELL_LTENBR.qoffsetcell
  is '小区偏置';
comment on column MB_SYS_LTECELL_LTENBR.update_user
  is '更新人';
comment on column MB_SYS_LTECELL_LTENBR.record_time
  is '记录日期';

prompt
prompt Creating table MB_SYS_LTECELL_PARAM
prompt ===================================
prompt
create table MB_SYS_LTECELL_PARAM
(
  cell_glb_id           VARCHAR2(256),
  cell_id               VARCHAR2(256),
  cell_name             VARCHAR2(256),
  operastate            VARCHAR2(8),
  csfb                  VARCHAR2(16),
  drx                   VARCHAR2(16),
  qci6_dur_len          VARCHAR2(16),
  qci7_dur_len          VARCHAR2(16),
  qci8_dur_len          VARCHAR2(16),
  qci9_dur_len          VARCHAR2(16),
  qci6_cont_timer       VARCHAR2(16),
  qci7_cont_timer       VARCHAR2(16),
  qci8_cont_timer       VARCHAR2(16),
  qci9_cont_timer       VARCHAR2(16),
  qci6_notrig_timer     VARCHAR2(16),
  qci7_notrig_timer     VARCHAR2(16),
  qci8_notrig_timer     VARCHAR2(16),
  qci9_notrig_timer     VARCHAR2(16),
  qci6_waitresend_timer VARCHAR2(16),
  qci7_waitresend_timer VARCHAR2(16),
  qci8_waitresend_timer VARCHAR2(16),
  qci9_waitresend_timer VARCHAR2(16),
  qci6_shortdur_len     VARCHAR2(16),
  qci7_shortdur_len     VARCHAR2(16),
  qci8_shortdur_len     VARCHAR2(16),
  qci9_shortdur_len     VARCHAR2(16),
  qci6_shortdur_timer   NUMBER(4),
  qci7_shortdur_timer   NUMBER(4),
  qci8_shortdur_timer   NUMBER(4),
  qci9_shortdur_timer   NUMBER(4),
  rrc_noact_timer       NUMBER(4),
  def_paging_dur        VARCHAR2(16),
  rf_sig_power          NUMBER(4),
  pdsch_rs_ratio        NUMBER(4),
  pa                    VARCHAR2(16),
  init_recv_power       VARCHAR2(16),
  preamble_max_count    VARCHAR2(16),
  power_inc_step        VARCHAR2(16),
  acc_ue_max_power      NUMBER(4),
  up_pucch_power_ctrl   NUMBER(4),
  pucch_optimal_power   NUMBER(4),
  up_pusch_power_ctrl   VARCHAR2(16),
  pathloss_comp_param   VARCHAR2(16),
  instant_optimal_power NUMBER(4),
  acc_min_level         NUMBER(4),
  cofreq_meas_start_th  VARCHAR2(16),
  q_offsetcell          VARCHAR2(16),
  q_hyst                VARCHAR2(16),
  a3_offset_hyst        VARCHAR2(16),
  a3_hyst               VARCHAR2(16),
  a3_time_trig          VARCHAR2(16),
  if_a2_th              VARCHAR2(16),
  irat_a2_tds_th        VARCHAR2(16),
  irat_a2_gsm_th        VARCHAR2(16),
  irat_a2_errdef_th     VARCHAR2(16),
  update_time           TIMESTAMP(6),
  update_user           VARCHAR2(256),
  enodeb_name           VARCHAR2(256),
  enodeb_id             VARCHAR2(64),
  enodeb_glb_id         VARCHAR2(256),
  record_time           TIMESTAMP(6)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_LTECELL_PARAM
  is '4G基站参数表';
comment on column MB_SYS_LTECELL_PARAM.cell_glb_id
  is '小区的全局ID编号
';
comment on column MB_SYS_LTECELL_PARAM.cell_id
  is '小区ID
';
comment on column MB_SYS_LTECELL_PARAM.cell_name
  is '小区名称
';
comment on column MB_SYS_LTECELL_PARAM.operastate
  is '状态
';
comment on column MB_SYS_LTECELL_PARAM.csfb
  is 'CSFB开关
';
comment on column MB_SYS_LTECELL_PARAM.drx
  is 'DRX开关
';
comment on column MB_SYS_LTECELL_PARAM.qci6_dur_len
  is 'DRX长周期的长度(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_dur_len
  is 'DRX长周期的长度(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_dur_len
  is 'DRX长周期的长度(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_dur_len
  is 'DRX长周期的长度(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.qci6_cont_timer
  is 'DRX持续时间定时器(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_cont_timer
  is 'DRX持续时间定时器(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_cont_timer
  is 'DRX持续时间定时器(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_cont_timer
  is 'DRX持续时间定时器(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.qci6_notrig_timer
  is 'DRX非激活定时器(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_notrig_timer
  is 'DRX非激活定时器(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_notrig_timer
  is 'DRX非激活定时器(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_notrig_timer
  is 'DRX非激活定时器(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.qci6_waitresend_timer
  is 'DRX等待重传数据的定时器(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_waitresend_timer
  is 'DRX等待重传数据的定时器(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_waitresend_timer
  is 'DRX等待重传数据的定时器(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_waitresend_timer
  is 'DRX等待重传数据的定时器(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.qci6_shortdur_len
  is 'DRX短周期的长度(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_shortdur_len
  is 'DRX短周期的长度(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_shortdur_len
  is 'DRX短周期的长度(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_shortdur_len
  is 'DRX短周期的长度(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.qci6_shortdur_timer
  is 'DRX短周期定时器(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_shortdur_timer
  is 'DRX短周期定时器(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_shortdur_timer
  is 'DRX短周期定时器(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_shortdur_timer
  is 'DRX短周期定时器(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.rrc_noact_timer
  is 'RRC连接不活动定时器(集团标准:10s)
';
comment on column MB_SYS_LTECELL_PARAM.def_paging_dur
  is '默认寻呼周期(集团标准:rf128)
';
comment on column MB_SYS_LTECELL_PARAM.rf_sig_power
  is '参考信号功率(集团标准:15)
';
comment on column MB_SYS_LTECELL_PARAM.pdsch_rs_ratio
  is '天线端口信号功率比(PDSCH/RS的功率比值参数,集团标准:1)
';
comment on column MB_SYS_LTECELL_PARAM.pa
  is 'Pa(集团标准:-3)
';
comment on column MB_SYS_LTECELL_PARAM.init_recv_power
  is '初始接收目标功率(集团标准:-100dBm~-104dBm)
';
comment on column MB_SYS_LTECELL_PARAM.preamble_max_count
  is '前导码最大传输次数(集团标准:n8，n10)
';
comment on column MB_SYS_LTECELL_PARAM.power_inc_step
  is '功率爬坡步长(集团标准:dB2，dB4)
';
comment on column MB_SYS_LTECELL_PARAM.acc_ue_max_power
  is '小区选择UE最大功率(集团标准:23dBm)
';
comment on column MB_SYS_LTECELL_PARAM.up_pucch_power_ctrl
  is '上行PUCCH闭环功控开关(集团标准:开启)
';
comment on column MB_SYS_LTECELL_PARAM.pucch_optimal_power
  is 'PUCCH期望功率(集团标准:-100dBm~ -105dBm)
';
comment on column MB_SYS_LTECELL_PARAM.up_pusch_power_ctrl
  is '上行PUSCH闭环功控开关(集团标准:开启)
';
comment on column MB_SYS_LTECELL_PARAM.pathloss_comp_param
  is '部分路损补偿系数(集团标准:0.8)
';
comment on column MB_SYS_LTECELL_PARAM.instant_optimal_power
  is '非持续调度期望功率(集团标准:-87)
';
comment on column MB_SYS_LTECELL_PARAM.acc_min_level
  is '小区选择最小接入电平(集团标准:室外-120dBm～-124dBm；室分-120dBm～-128dBm)
';
comment on column MB_SYS_LTECELL_PARAM.cofreq_meas_start_th
  is '同频测量启动门限(集团标准:-82dBm)
';
comment on column MB_SYS_LTECELL_PARAM.q_offsetcell
  is 'q-OffsetCell(集团标准:q-OffsetCell+q-Hyst是2~4dB)
';
comment on column MB_SYS_LTECELL_PARAM.q_hyst
  is 'q-Hyst(集团标准:q-OffsetCell+q-Hyst是2~4dB)
';
comment on column MB_SYS_LTECELL_PARAM.a3_offset_hyst
  is '同频 A3 offset + Hysteresis(集团标准:2~4dB)
';
comment on column MB_SYS_LTECELL_PARAM.a3_hyst
  is '同频 A3 Hysteresis(集团标准:同频 A3 offset+Hysteresis是2~4dB)
';
comment on column MB_SYS_LTECELL_PARAM.a3_time_trig
  is '同频 A3 Time-to-trigger(集团标准:320ms)
';
comment on column MB_SYS_LTECELL_PARAM.if_a2_th
  is '异频A2门限(目前无规范)
';
comment on column MB_SYS_LTECELL_PARAM.irat_a2_tds_th
  is '异系统A2门限(3G)(目前无规范)
';
comment on column MB_SYS_LTECELL_PARAM.irat_a2_gsm_th
  is '异系统A2门限(2G)(目前无规范)
';
comment on column MB_SYS_LTECELL_PARAM.irat_a2_errdef_th
  is '异系统A2门限(盲重定向)(集团标准:-118dBm～-126dBm)
';
comment on column MB_SYS_LTECELL_PARAM.update_time
  is '更新时间
';
comment on column MB_SYS_LTECELL_PARAM.update_user
  is '更新人';
comment on column MB_SYS_LTECELL_PARAM.enodeb_name
  is '现网基站名称
';
comment on column MB_SYS_LTECELL_PARAM.enodeb_id
  is '现网基站ID
';
comment on column MB_SYS_LTECELL_PARAM.enodeb_glb_id
  is '基站的全局ID编号';
comment on column MB_SYS_LTECELL_PARAM.record_time
  is '记录日期';

prompt
prompt Creating table MB_SYS_LTECELL_RF
prompt ================================
prompt
create table MB_SYS_LTECELL_RF
(
  cell_glb_id      VARCHAR2(256),
  azimuth          NUMBER(16,8),
  downtilt         NUMBER(16,8),
  m_downtilt       NUMBER(16,8),
  e_downtilt       NUMBER(16,8),
  height           NUMBER(16,8),
  altitude         NUMBER(16,8),
  antenna          VARCHAR2(128),
  fake_antenna     NUMBER(1),
  record_time      TIMESTAMP(6),
  update_time      TIMESTAMP(6),
  update_user      VARCHAR2(256),
  share_rfs        VARCHAR2(32),
  antenna_type_old VARCHAR2(64)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_LTECELL_RF
  is '4G小区RF表';
comment on column MB_SYS_LTECELL_RF.cell_glb_id
  is '小区的全局ID编号
';
comment on column MB_SYS_LTECELL_RF.azimuth
  is '方位角
';
comment on column MB_SYS_LTECELL_RF.downtilt
  is '总下倾角
';
comment on column MB_SYS_LTECELL_RF.m_downtilt
  is '机械下倾角
';
comment on column MB_SYS_LTECELL_RF.e_downtilt
  is '电子下倾角
';
comment on column MB_SYS_LTECELL_RF.height
  is '天线挂高
';
comment on column MB_SYS_LTECELL_RF.altitude
  is '海拔高度
';
comment on column MB_SYS_LTECELL_RF.antenna
  is '天线型号
';
comment on column MB_SYS_LTECELL_RF.fake_antenna
  is '是否美化
';
comment on column MB_SYS_LTECELL_RF.record_time
  is '记录时间
';
comment on column MB_SYS_LTECELL_RF.update_time
  is '更新时间
';
comment on column MB_SYS_LTECELL_RF.update_user
  is '更新人
';
comment on column MB_SYS_LTECELL_RF.share_rfs
  is '是否共天馈';
comment on column MB_SYS_LTECELL_RF.antenna_type_old
  is '天面方式';
create index IDX_SYSLTECELLRF_CELLGLBID on MB_SYS_LTECELL_RF (CELL_GLB_ID);
create index IDX_SYSLTECELL_RF_RECORDTIME on MB_SYS_LTECELL_RF (RECORD_TIME);

prompt
prompt Creating table MB_SYS_LTECELL_TDSNBR
prompt ====================================
prompt
create table MB_SYS_LTECELL_TDSNBR
(
  cgi             VARCHAR2(64),
  name            VARCHAR2(256),
  object_rdn      VARCHAR2(256),
  zh_name         VARCHAR2(256),
  omc_id          VARCHAR2(64),
  city            VARCHAR2(64),
  vendor_id       VARCHAR2(64),
  time_stamp      TIMESTAMP(6),
  update_stamp    TIMESTAMP(6),
  confirmed       VARCHAR2(64),
  tac             VARCHAR2(64),
  pci             VARCHAR2(64),
  earfcn          VARCHAR2(64),
  m_name          VARCHAR2(256),
  n_name          VARCHAR2(256),
  id              VARCHAR2(64),
  adj_cgi         VARCHAR2(64),
  adjacentcellid  VARCHAR2(64),
  lac             VARCHAR2(64),
  rac             VARCHAR2(64),
  uarfcn          VARCHAR2(64),
  cellparameterid VARCHAR2(64),
  update_user     VARCHAR2(256),
  record_time     TIMESTAMP(6)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_SYS_LTECELL_TDSNBR.cgi
  is '全球网络标识
';
comment on column MB_SYS_LTECELL_TDSNBR.name
  is '用户友好名
';
comment on column MB_SYS_LTECELL_TDSNBR.object_rdn
  is '资源对象唯一标识
';
comment on column MB_SYS_LTECELL_TDSNBR.zh_name
  is '中文名称
';
comment on column MB_SYS_LTECELL_TDSNBR.omc_id
  is 'OMC_ID
';
comment on column MB_SYS_LTECELL_TDSNBR.city
  is '地市
';
comment on column MB_SYS_LTECELL_TDSNBR.vendor_id
  is '设备厂家ID
';
comment on column MB_SYS_LTECELL_TDSNBR.time_stamp
  is '数据采集时间戳
';
comment on column MB_SYS_LTECELL_TDSNBR.update_stamp
  is '数据更新时间戳
';
comment on column MB_SYS_LTECELL_TDSNBR.confirmed
  is '删除或增加的确认
';
comment on column MB_SYS_LTECELL_TDSNBR.tac
  is '源小区跟踪区标识
';
comment on column MB_SYS_LTECELL_TDSNBR.pci
  is '源小区物理小区标识
';
comment on column MB_SYS_LTECELL_TDSNBR.earfcn
  is '源小区中心载频的信道号
';
comment on column MB_SYS_LTECELL_TDSNBR.m_name
  is '主小区名称
';
comment on column MB_SYS_LTECELL_TDSNBR.n_name
  is '邻小区名称
';
comment on column MB_SYS_LTECELL_TDSNBR.id
  is '标识符
';
comment on column MB_SYS_LTECELL_TDSNBR.adj_cgi
  is '目标全球网络标识';
comment on column MB_SYS_LTECELL_TDSNBR.adjacentcellid
  is '相邻小区的标识';
comment on column MB_SYS_LTECELL_TDSNBR.lac
  is '位置区编码';
comment on column MB_SYS_LTECELL_TDSNBR.rac
  is '路由区编码';
comment on column MB_SYS_LTECELL_TDSNBR.uarfcn
  is '频点';
comment on column MB_SYS_LTECELL_TDSNBR.cellparameterid
  is '小区参数标识';
comment on column MB_SYS_LTECELL_TDSNBR.update_user
  is '更新人 ';
comment on column MB_SYS_LTECELL_TDSNBR.record_time
  is '记录日期';

prompt
prompt Creating table MB_SYS_LTESITE_INFO
prompt ==================================
prompt
create table MB_SYS_LTESITE_INFO
(
  enodeb_glb_id  VARCHAR2(32),
  enodeb_id      VARCHAR2(64),
  enodeb_name    VARCHAR2(256),
  tac            NUMBER(8),
  vendor         VARCHAR2(32),
  longitude      NUMBER(12,8),
  latitude       NUMBER(12,8),
  netgrid        NUMBER(4),
  environ        VARCHAR2(256),
  freq_band      VARCHAR2(8),
  cover_type     VARCHAR2(32),
  project_period VARCHAR2(8),
  single_pass    NUMBER(4),
  init_time      TIMESTAMP(6),
  run_time       TIMESTAMP(6),
  record_time    TIMESTAMP(6),
  update_time    TIMESTAMP(6),
  update_user    VARCHAR2(256),
  regiontype     VARCHAR2(64)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_LTESITE_INFO
  is '4G基站信息表';
comment on column MB_SYS_LTESITE_INFO.enodeb_glb_id
  is '基站的全局基站的全局ID编号
';
comment on column MB_SYS_LTESITE_INFO.enodeb_id
  is '现网基站ID
';
comment on column MB_SYS_LTESITE_INFO.enodeb_name
  is '现网基站名称
';
comment on column MB_SYS_LTESITE_INFO.tac
  is '跟踪区域码
';
comment on column MB_SYS_LTESITE_INFO.vendor
  is '设备厂家
';
comment on column MB_SYS_LTESITE_INFO.longitude
  is '经度
';
comment on column MB_SYS_LTESITE_INFO.latitude
  is '纬度
';
comment on column MB_SYS_LTESITE_INFO.netgrid
  is '网格号
';
comment on column MB_SYS_LTESITE_INFO.environ
  is '场景
';
comment on column MB_SYS_LTESITE_INFO.freq_band
  is '频段
';
comment on column MB_SYS_LTESITE_INFO.cover_type
  is '覆盖类型
';
comment on column MB_SYS_LTESITE_INFO.project_period
  is '站点工期号
';
comment on column MB_SYS_LTESITE_INFO.single_pass
  is '单验是否通过
';
comment on column MB_SYS_LTESITE_INFO.init_time
  is '初始加载时间
';
comment on column MB_SYS_LTESITE_INFO.run_time
  is '首次开通时间
';
comment on column MB_SYS_LTESITE_INFO.record_time
  is '记录时间
';
comment on column MB_SYS_LTESITE_INFO.update_time
  is '更新时间
';
comment on column MB_SYS_LTESITE_INFO.update_user
  is '更新人
';
comment on column MB_SYS_LTESITE_INFO.regiontype
  is '区域类型';
create index IDX_LTESITE_ENGLBID on MB_SYS_LTESITE_INFO (ENODEB_GLB_ID);
create index IDX_LTESITE_RECORDT on MB_SYS_LTESITE_INFO (RECORD_TIME);

prompt
prompt Creating table MB_SYS_LTESITE_INFO_T
prompt ====================================
prompt
create table MB_SYS_LTESITE_INFO_T
(
  record_time            TIMESTAMP(6),
  int_id                 VARCHAR2(256),
  object_rdn             VARCHAR2(256),
  name                   VARCHAR2(256),
  zh_name                VARCHAR2(256),
  omc_id                 NUMBER(8),
  vendor_id              VARCHAR2(32),
  city_id                VARCHAR2(32),
  time_stamp             TIMESTAMP(6),
  update_stamp           TIMESTAMP(6),
  confirmed              VARCHAR2(16),
  state                  VARCHAR2(16),
  enodeb_id              VARCHAR2(64),
  enbid                  VARCHAR2(256),
  x2blacklist            VARCHAR2(512),
  x2whitelist            VARCHAR2(512),
  x2hoblacklist          VARCHAR2(512),
  cover_area_info        VARCHAR2(256),
  x2ipaddresslist        VARCHAR2(512),
  max_throughput_rate    NUMBER(8,4),
  administrativestate    VARCHAR2(32),
  operationalstate       VARCHAR2(32),
  x2_num                 NUMBER(4),
  integrityprotalgorithm VARCHAR2(256),
  cipheringalgorithm     VARCHAR2(256),
  related_me             VARCHAR2(64)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_LTESITE_INFO_T
  is '4G基站临时用表，会删除---by huangc';
comment on column MB_SYS_LTESITE_INFO_T.record_time
  is '记录时间';
comment on column MB_SYS_LTESITE_INFO_T.int_id
  is '唯一标识';
comment on column MB_SYS_LTESITE_INFO_T.object_rdn
  is '基站DN号';
comment on column MB_SYS_LTESITE_INFO_T.name
  is '基站英文名';
comment on column MB_SYS_LTESITE_INFO_T.zh_name
  is '基站中文名';
comment on column MB_SYS_LTESITE_INFO_T.omc_id
  is 'OMCID号';
comment on column MB_SYS_LTESITE_INFO_T.vendor_id
  is '归属厂家';
comment on column MB_SYS_LTESITE_INFO_T.city_id
  is '归属地市';
comment on column MB_SYS_LTESITE_INFO_T.time_stamp
  is '更新时间';
comment on column MB_SYS_LTESITE_INFO_T.update_stamp
  is '更新时间（同上，文件中有2个一模一样的）';
comment on column MB_SYS_LTESITE_INFO_T.confirmed
  is '网元状态';
comment on column MB_SYS_LTESITE_INFO_T.state
  is '设备维护状态';
comment on column MB_SYS_LTESITE_INFO_T.enodeb_id
  is 'Enodeb标识符';
comment on column MB_SYS_LTESITE_INFO_T.enbid
  is 'eNodeB网络标识符';
comment on column MB_SYS_LTESITE_INFO_T.x2blacklist
  is 'eNodeB黑名单列表';
comment on column MB_SYS_LTESITE_INFO_T.x2whitelist
  is 'eNodeB白名单列表';
comment on column MB_SYS_LTESITE_INFO_T.x2hoblacklist
  is 'X2接口切换eNodeB黑名单列表';
comment on column MB_SYS_LTESITE_INFO_T.cover_area_info
  is '覆盖区详细信息';
comment on column MB_SYS_LTESITE_INFO_T.x2ipaddresslist
  is 'X2接口IP地址列表';
comment on column MB_SYS_LTESITE_INFO_T.max_throughput_rate
  is '规划的最大吞吐率';
comment on column MB_SYS_LTESITE_INFO_T.administrativestate
  is '管理状态';
comment on column MB_SYS_LTESITE_INFO_T.operationalstate
  is '激活状态';
comment on column MB_SYS_LTESITE_INFO_T.x2_num
  is 'x2数量';
comment on column MB_SYS_LTESITE_INFO_T.integrityprotalgorithm
  is '完整性保护算法';
comment on column MB_SYS_LTESITE_INFO_T.cipheringalgorithm
  is '加密算法';
comment on column MB_SYS_LTESITE_INFO_T.related_me
  is '归属ME号';

prompt
prompt Creating table MB_SYS_LTESITE_PARAM
prompt ===================================
prompt
create table MB_SYS_LTESITE_PARAM
(
  enodeb_glb_id VARCHAR2(32),
  enodeb_id     VARCHAR2(64),
  enodeb_name   VARCHAR2(256),
  operastate    VARCHAR2(16),
  update_time   TIMESTAMP(6),
  record_time   TIMESTAMP(6)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_LTESITE_PARAM
  is '4G基站参数表';
comment on column MB_SYS_LTESITE_PARAM.enodeb_glb_id
  is '基站的全局ID编号
';
comment on column MB_SYS_LTESITE_PARAM.enodeb_id
  is '现网基站ID
';
comment on column MB_SYS_LTESITE_PARAM.enodeb_name
  is '现网基站名称
';
comment on column MB_SYS_LTESITE_PARAM.operastate
  is '状态
';
comment on column MB_SYS_LTESITE_PARAM.update_time
  is '更新时间
';
comment on column MB_SYS_LTESITE_PARAM.record_time
  is '记录日期';

prompt
prompt Creating table MB_SYS_TDSCELL_INFO
prompt ==================================
prompt
create table MB_SYS_TDSCELL_INFO
(
  cell_id                   NUMBER(12),
  cell_name                 VARCHAR2(256),
  site_oid                  VARCHAR2(256),
  cgi                       VARCHAR2(32),
  rru_remote                VARCHAR2(32),
  cell_longitude            NUMBER(8),
  cell_latitude             NUMBER(8),
  sector_id                 NUMBER(4),
  pci                       NUMBER(4),
  earfcn                    NUMBER(8),
  rf_power                  NUMBER(8),
  covertype                 VARCHAR2(256),
  bandindicatorforfrequency VARCHAR2(256),
  rac                       VARCHAR2(256),
  powerdivisiontype         VARCHAR2(256),
  powerdivisionindex        VARCHAR2(256),
  record_time               TIMESTAMP(6),
  uptime_time               TIMESTAMP(6),
  update_user               VARCHAR2(32),
  cell_glb_id               VARCHAR2(256),
  site_glb_id               VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_TDSCELL_INFO
  is '3G小区信息表';
comment on column MB_SYS_TDSCELL_INFO.cell_id
  is '小区ID
';
comment on column MB_SYS_TDSCELL_INFO.cell_name
  is '小区名称
';
comment on column MB_SYS_TDSCELL_INFO.site_oid
  is '基站标识
';
comment on column MB_SYS_TDSCELL_INFO.cgi
  is '全球小区ID
';
comment on column MB_SYS_TDSCELL_INFO.rru_remote
  is '是否拉远小区
';
comment on column MB_SYS_TDSCELL_INFO.cell_longitude
  is '小区经度
';
comment on column MB_SYS_TDSCELL_INFO.cell_latitude
  is '小区纬度
';
comment on column MB_SYS_TDSCELL_INFO.sector_id
  is '本地小区标识
';
comment on column MB_SYS_TDSCELL_INFO.pci
  is '物理小区标识（PCI)
';
comment on column MB_SYS_TDSCELL_INFO.earfcn
  is '下行频点
';
comment on column MB_SYS_TDSCELL_INFO.rf_power
  is '参考信号功率
';
comment on column MB_SYS_TDSCELL_INFO.covertype
  is '覆盖类型
';
comment on column MB_SYS_TDSCELL_INFO.bandindicatorforfrequency
  is '频带指示
';
comment on column MB_SYS_TDSCELL_INFO.rac
  is '小区路由区域码
';
comment on column MB_SYS_TDSCELL_INFO.powerdivisiontype
  is '功分类型
';
comment on column MB_SYS_TDSCELL_INFO.powerdivisionindex
  is '功分索引
';
comment on column MB_SYS_TDSCELL_INFO.record_time
  is '录入时间
';
comment on column MB_SYS_TDSCELL_INFO.uptime_time
  is '更新时间
';
comment on column MB_SYS_TDSCELL_INFO.update_user
  is '更新人
';
comment on column MB_SYS_TDSCELL_INFO.cell_glb_id
  is '小区的全局ID编号
';
comment on column MB_SYS_TDSCELL_INFO.site_glb_id
  is '基站的全局ID编号
';

prompt
prompt Creating table MB_SYS_TDSCELL_RF
prompt ================================
prompt
create table MB_SYS_TDSCELL_RF
(
  cell_id      NUMBER(8),
  cell_name    VARCHAR2(128),
  azimuth      NUMBER(8),
  height       NUMBER(8),
  mtilt        NUMBER(8),
  etilt        NUMBER(8),
  antenna      VARCHAR2(128),
  fake_antenna NUMBER(1),
  update_time  TIMESTAMP(6),
  record_time  TIMESTAMP(6),
  update_user  VARCHAR2(128),
  cell_glb_id  VARCHAR2(256),
  site_glb_id  VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_TDSCELL_RF
  is '3G小区RF表';
comment on column MB_SYS_TDSCELL_RF.cell_id
  is '小区ID
';
comment on column MB_SYS_TDSCELL_RF.cell_name
  is '小区名称
';
comment on column MB_SYS_TDSCELL_RF.azimuth
  is '天线方向角
';
comment on column MB_SYS_TDSCELL_RF.height
  is '天线挂高
';
comment on column MB_SYS_TDSCELL_RF.mtilt
  is '天线机械下倾角
';
comment on column MB_SYS_TDSCELL_RF.etilt
  is '天线电子下倾角
';
comment on column MB_SYS_TDSCELL_RF.antenna
  is '天线型号
';
comment on column MB_SYS_TDSCELL_RF.fake_antenna
  is '是否美化
';
comment on column MB_SYS_TDSCELL_RF.update_time
  is '更新时间
';
comment on column MB_SYS_TDSCELL_RF.record_time
  is '记录时间
';
comment on column MB_SYS_TDSCELL_RF.update_user
  is '更新人
';
comment on column MB_SYS_TDSCELL_RF.cell_glb_id
  is '小区的全局ID编号
';
comment on column MB_SYS_TDSCELL_RF.site_glb_id
  is '基站的全局ID编号
';

prompt
prompt Creating table MB_SYS_TDSSITE_INFO
prompt ==================================
prompt
create table MB_SYS_TDSSITE_INFO
(
  rnc_id      VARCHAR2(64),
  site_oid    VARCHAR2(64),
  site_name   VARCHAR2(256),
  lac         NUMBER(8),
  vendor      VARCHAR2(32),
  longitude   NUMBER(4,8),
  latitude    NUMBER(4,8),
  netgrid     NUMBER(4),
  environ     VARCHAR2(256),
  freq_band   VARCHAR2(8),
  cover_type  NUMBER(4),
  record_time TIMESTAMP(6),
  update_time TIMESTAMP(6),
  update_user VARCHAR2(256),
  site_glb_id VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140624 values less than (TIMESTAMP' 2014-06-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140629 values less than (TIMESTAMP' 2014-06-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140630 values less than (TIMESTAMP' 2014-07-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140701 values less than (TIMESTAMP' 2014-07-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140702 values less than (TIMESTAMP' 2014-07-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140703 values less than (TIMESTAMP' 2014-07-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140704 values less than (TIMESTAMP' 2014-07-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140705 values less than (TIMESTAMP' 2014-07-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140706 values less than (TIMESTAMP' 2014-07-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140707 values less than (TIMESTAMP' 2014-07-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140708 values less than (TIMESTAMP' 2014-07-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140709 values less than (TIMESTAMP' 2014-07-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140710 values less than (TIMESTAMP' 2014-07-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140711 values less than (TIMESTAMP' 2014-07-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140712 values less than (TIMESTAMP' 2014-07-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140713 values less than (TIMESTAMP' 2014-07-14 00:00:00')
    tablespace T_TEST,
  partition PART_20140714 values less than (TIMESTAMP' 2014-07-15 00:00:00')
    tablespace T_TEST,
  partition PART_20140715 values less than (TIMESTAMP' 2014-07-16 00:00:00')
    tablespace T_TEST,
  partition PART_20140716 values less than (TIMESTAMP' 2014-07-17 00:00:00')
    tablespace T_TEST,
  partition PART_20140717 values less than (TIMESTAMP' 2014-07-18 00:00:00')
    tablespace T_TEST,
  partition PART_20140718 values less than (TIMESTAMP' 2014-07-19 00:00:00')
    tablespace T_TEST,
  partition PART_20140719 values less than (TIMESTAMP' 2014-07-20 00:00:00')
    tablespace T_TEST,
  partition PART_20140720 values less than (TIMESTAMP' 2014-07-21 00:00:00')
    tablespace T_TEST,
  partition PART_20140721 values less than (TIMESTAMP' 2014-07-22 00:00:00')
    tablespace T_TEST,
  partition PART_20140722 values less than (TIMESTAMP' 2014-07-23 00:00:00')
    tablespace T_TEST,
  partition PART_20140723 values less than (TIMESTAMP' 2014-07-24 00:00:00')
    tablespace T_TEST,
  partition PART_20140724 values less than (TIMESTAMP' 2014-07-25 00:00:00')
    tablespace T_TEST,
  partition PART_20140725 values less than (TIMESTAMP' 2014-07-26 00:00:00')
    tablespace T_TEST,
  partition PART_20140726 values less than (TIMESTAMP' 2014-07-27 00:00:00')
    tablespace T_TEST,
  partition PART_20140727 values less than (TIMESTAMP' 2014-07-28 00:00:00')
    tablespace T_TEST,
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140802 values less than (TIMESTAMP' 2014-08-03 00:00:00')
    tablespace T_TEST,
  partition PART_20140803 values less than (TIMESTAMP' 2014-08-04 00:00:00')
    tablespace T_TEST,
  partition PART_20140804 values less than (TIMESTAMP' 2014-08-05 00:00:00')
    tablespace T_TEST,
  partition PART_20140805 values less than (TIMESTAMP' 2014-08-06 00:00:00')
    tablespace T_TEST,
  partition PART_20140806 values less than (TIMESTAMP' 2014-08-07 00:00:00')
    tablespace T_TEST,
  partition PART_20140807 values less than (TIMESTAMP' 2014-08-08 00:00:00')
    tablespace T_TEST,
  partition PART_20140808 values less than (TIMESTAMP' 2014-08-09 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on table MB_SYS_TDSSITE_INFO
  is '3G基站信息表';
comment on column MB_SYS_TDSSITE_INFO.rnc_id
  is 'RNC_name
';
comment on column MB_SYS_TDSSITE_INFO.site_oid
  is '基站标识
';
comment on column MB_SYS_TDSSITE_INFO.site_name
  is '基站名称
';
comment on column MB_SYS_TDSSITE_INFO.lac
  is '跟踪区域码
';
comment on column MB_SYS_TDSSITE_INFO.vendor
  is '设备厂家
';
comment on column MB_SYS_TDSSITE_INFO.longitude
  is '经度
';
comment on column MB_SYS_TDSSITE_INFO.latitude
  is '纬度
';
comment on column MB_SYS_TDSSITE_INFO.netgrid
  is '网格号
';
comment on column MB_SYS_TDSSITE_INFO.environ
  is '场景
';
comment on column MB_SYS_TDSSITE_INFO.freq_band
  is '频段
';
comment on column MB_SYS_TDSSITE_INFO.cover_type
  is '覆盖类型
';
comment on column MB_SYS_TDSSITE_INFO.record_time
  is '录入时间
';
comment on column MB_SYS_TDSSITE_INFO.update_time
  is '参数更新时间
';
comment on column MB_SYS_TDSSITE_INFO.update_user
  is '更新人
';
comment on column MB_SYS_TDSSITE_INFO.site_glb_id
  is '基站的全局ID编号
';

prompt
prompt Creating table MB_SYS_TRAFFIC_CELL
prompt ==================================
prompt
create table MB_SYS_TRAFFIC_CELL
(
  record_time  TIMESTAMP(6),
  city         VARCHAR2(20),
  cell_count   NUMBER(8),
  network_type VARCHAR2(10)
)
;
comment on table MB_SYS_TRAFFIC_CELL
  is '小区个数统计表';
comment on column MB_SYS_TRAFFIC_CELL.record_time
  is '时间';
comment on column MB_SYS_TRAFFIC_CELL.city
  is '城市';
comment on column MB_SYS_TRAFFIC_CELL.cell_count
  is '小区个数';
comment on column MB_SYS_TRAFFIC_CELL.network_type
  is '网络类型 2/3/4G';

prompt
prompt Creating table MB_TCC_CARRIER
prompt =============================
prompt
create table MB_TCC_CARRIER
(
  int_id            NUMBER(28),
  record_time       TIMESTAMP(6),
  related_utrancell NUMBER(28)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TCC_CARRIER.int_id
  is '载频级唯一标识';
comment on column MB_TCC_CARRIER.record_time
  is '时间';
comment on column MB_TCC_CARRIER.related_utrancell
  is '小区级唯一标识';

prompt
prompt Creating table MB_TCC_CELL
prompt ==========================
prompt
create table MB_TCC_CELL
(
  int_id      NUMBER(28),
  record_time TIMESTAMP(6),
  region_id   VARCHAR2(256),
  bts_name    VARCHAR2(256),
  vendor_id   VARCHAR2(256),
  trx_number  NUMBER(8),
  sdcch_num   VARCHAR2(256),
  bsc_name    VARCHAR2(256),
  btssm_name  VARCHAR2(256),
  cgi         VARCHAR2(256),
  sys_type    NUMBER(8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TCC_CELL.int_id
  is '小区级唯一标识
';
comment on column MB_TCC_CELL.record_time
  is '时间
';
comment on column MB_TCC_CELL.region_id
  is '地市
';
comment on column MB_TCC_CELL.bts_name
  is '所属BTS
';
comment on column MB_TCC_CELL.vendor_id
  is '厂家
';
comment on column MB_TCC_CELL.trx_number
  is '载频数量
';
comment on column MB_TCC_CELL.sdcch_num
  is 'SDCCH信道数
';
comment on column MB_TCC_CELL.bsc_name
  is '所属BSC
';
comment on column MB_TCC_CELL.btssm_name
  is '基站名称
';
comment on column MB_TCC_CELL.cgi
  is 'CGI
';
comment on column MB_TCC_CELL.sys_type
  is '所用频段
';

prompt
prompt Creating table MB_TCC_RNC
prompt =========================
prompt
create table MB_TCC_RNC
(
  int_id      NUMBER(28),
  record_time TIMESTAMP(6),
  name        VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TCC_RNC.int_id
  is '小区级唯一标识';
comment on column MB_TCC_RNC.record_time
  is '时间';
comment on column MB_TCC_RNC.name
  is 'RNC名称';

prompt
prompt Creating table MB_TCC_TCO_PRO_CELL
prompt ==================================
prompt
create table MB_TCC_TCO_PRO_CELL
(
  int_id      NUMBER(28),
  record_time TIMESTAMP(6),
  bsc_name    VARCHAR2(256),
  cgi         VARCHAR2(256),
  longitude   NUMBER(24,8),
  latitude    NUMBER(24,8),
  cover_type  VARCHAR2(256),
  ccch_num    NUMBER(8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TCC_TCO_PRO_CELL.int_id
  is '小区级唯一标识';
comment on column MB_TCC_TCO_PRO_CELL.record_time
  is '时间';
comment on column MB_TCC_TCO_PRO_CELL.bsc_name
  is '所属BSC';
comment on column MB_TCC_TCO_PRO_CELL.cgi
  is 'CGI';
comment on column MB_TCC_TCO_PRO_CELL.longitude
  is '经度';
comment on column MB_TCC_TCO_PRO_CELL.latitude
  is '纬度';
comment on column MB_TCC_TCO_PRO_CELL.cover_type
  is '覆盖类型';
comment on column MB_TCC_TCO_PRO_CELL.ccch_num
  is 'CCCH信道数';

prompt
prompt Creating table MB_TCC_TCO_PRO_UTRANCELL
prompt =======================================
prompt
create table MB_TCC_TCO_PRO_UTRANCELL
(
  int_id            NUMBER(28),
  record_time       TIMESTAMP(6),
  dt_region_type_id VARCHAR2(256),
  longitude         NUMBER(20,8),
  latitude          NUMBER(20,8),
  dir               NUMBER(8),
  indoor_support    VARCHAR2(256)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TCC_TCO_PRO_UTRANCELL.int_id
  is '小区级唯一标识';
comment on column MB_TCC_TCO_PRO_UTRANCELL.record_time
  is '时间';
comment on column MB_TCC_TCO_PRO_UTRANCELL.dt_region_type_id
  is '归属网格';
comment on column MB_TCC_TCO_PRO_UTRANCELL.longitude
  is '经度';
comment on column MB_TCC_TCO_PRO_UTRANCELL.latitude
  is '纬度';
comment on column MB_TCC_TCO_PRO_UTRANCELL.dir
  is '方位角';
comment on column MB_TCC_TCO_PRO_UTRANCELL.indoor_support
  is '覆盖室内';

prompt
prompt Creating table MB_TCC_UTRANCELL
prompt ===============================
prompt
create table MB_TCC_UTRANCELL
(
  int_id           NUMBER(28),
  record_time      TIMESTAMP(6),
  city_id          VARCHAR2(256),
  name             VARCHAR2(256),
  lac              NUMBER(8),
  cid              NUMBER(8),
  hcarrier_number  NUMBER(8),
  r4carrier_number NUMBER(8),
  rnc_name         VARCHAR2(256),
  cgi              VARCHAR2(256),
  confirmed        NUMBER(8),
  time_stamp       TIMESTAMP(6)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TCC_UTRANCELL.int_id
  is '小区级唯一标识';
comment on column MB_TCC_UTRANCELL.record_time
  is '时间';
comment on column MB_TCC_UTRANCELL.city_id
  is '地市';
comment on column MB_TCC_UTRANCELL.name
  is '小区名';
comment on column MB_TCC_UTRANCELL.lac
  is 'LAC';
comment on column MB_TCC_UTRANCELL.cid
  is 'CI';
comment on column MB_TCC_UTRANCELL.hcarrier_number
  is 'HSDPA载波数';
comment on column MB_TCC_UTRANCELL.r4carrier_number
  is 'R4载波数';
comment on column MB_TCC_UTRANCELL.rnc_name
  is '所属RNC';
comment on column MB_TCC_UTRANCELL.cgi
  is 'CGI';
comment on column MB_TCC_UTRANCELL.confirmed
  is '状态';
comment on column MB_TCC_UTRANCELL.time_stamp
  is '更新时间';

prompt
prompt Creating table MB_TER_CNT_CELL
prompt ==============================
prompt
create table MB_TER_CNT_CELL
(
  int_id      NUMBER(28),
  record_time TIMESTAMP(6),
  tavaacc     NUMBER(28),
  tavascan    NUMBER(28),
  cnuchcnt    NUMBER(28),
  tnuchcnt    NUMBER(28)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TER_CNT_CELL.int_id
  is '小区级唯一标识';
comment on column MB_TER_CNT_CELL.record_time
  is '时间';
comment on column MB_TER_CNT_CELL.tavaacc
  is 'TAVAACC';
comment on column MB_TER_CNT_CELL.tavascan
  is 'TAVASCAN';
comment on column MB_TER_CNT_CELL.cnuchcnt
  is 'CNUCHCNT';
comment on column MB_TER_CNT_CELL.tnuchcnt
  is 'TNUCHCNT';

prompt
prompt Creating table MB_TER_CNT_CELL_GPRS
prompt ===================================
prompt
create table MB_TER_CNT_CELL_GPRS
(
  int_id       NUMBER(28),
  record_time  TIMESTAMP(6),
  faildltbfest NUMBER(28),
  prejtfi      NUMBER(28)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TER_CNT_CELL_GPRS.int_id
  is '小区级唯一标识';
comment on column MB_TER_CNT_CELL_GPRS.record_time
  is '时间';
comment on column MB_TER_CNT_CELL_GPRS.faildltbfest
  is 'FAILDLTBFEST';
comment on column MB_TER_CNT_CELL_GPRS.prejtfi
  is 'PREJTFI';

prompt
prompt Creating table MB_TEST_SCANFREQ
prompt ===============================
prompt
create table MB_TEST_SCANFREQ
(
  task_id      VARCHAR2(64),
  cell_glb_id  VARCHAR2(256),
  cell_id      NUMBER(12),
  cell_name    VARCHAR2(256),
  pci          NUMBER(4),
  earfcn       NUMBER(8),
  rs_rp        NUMBER(4,4),
  rs_cinr_sinr NUMBER(4,4),
  test_time    TIMESTAMP(6)
)
;
comment on table MB_TEST_SCANFREQ
  is '扫频数据';
comment on column MB_TEST_SCANFREQ.task_id
  is '任务计划ID
';
comment on column MB_TEST_SCANFREQ.cell_glb_id
  is '小区的全局ID编号
';
comment on column MB_TEST_SCANFREQ.cell_id
  is '小区ID
';
comment on column MB_TEST_SCANFREQ.cell_name
  is '小区名称
';
comment on column MB_TEST_SCANFREQ.pci
  is '物理小区标识（PCI)
';
comment on column MB_TEST_SCANFREQ.earfcn
  is '下行频点
';
comment on column MB_TEST_SCANFREQ.rs_rp
  is '参考信号电平
';
comment on column MB_TEST_SCANFREQ.rs_cinr_sinr
  is 'RS有用信号与干扰(或噪声或干扰加噪声)相比强度
';
comment on column MB_TEST_SCANFREQ.test_time
  is '扫频测试时间
';

prompt
prompt Creating table MB_THW_CNT_CELL2_6K
prompt ==================================
prompt
create table MB_THW_CNT_CELL2_6K
(
  int_id      NUMBER(28),
  record_time TIMESTAMP(6),
  c1278469458 NUMBER(28,8),
  c1278469459 NUMBER(28,8),
  c1278469468 NUMBER(28,8),
  c1278469469 NUMBER(28,8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_THW_CNT_CELL2_6K.int_id
  is '小区级唯一标识';
comment on column MB_THW_CNT_CELL2_6K.record_time
  is '时间';
comment on column MB_THW_CNT_CELL2_6K.c1278469458
  is 'AR3010A:信道动态配置平均数目（SDCCH）（900/850小区）';
comment on column MB_THW_CNT_CELL2_6K.c1278469459
  is 'AR3010B:信道动态配置平均数目（SDCCH）（1800/1900小区）';
comment on column MB_THW_CNT_CELL2_6K.c1278469468
  is 'AR3020A:信道可用平均数目（SDCCH）（900/850小区）';
comment on column MB_THW_CNT_CELL2_6K.c1278469469
  is 'AR3020B:信道可用平均数目（SDCCH）（1800/1900小区）';

prompt
prompt Creating table MB_THW_CNT_CELL_GPRS_6K
prompt ======================================
prompt
create table MB_THW_CNT_CELL_GPRS_6K
(
  int_id      NUMBER(28),
  record_time TIMESTAMP(6),
  c1279175419 NUMBER(20,10),
  c1279176419 NUMBER(20,10)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_THW_CNT_CELL_GPRS_6K.int_id
  is '小区级唯一标识';
comment on column MB_THW_CNT_CELL_GPRS_6K.record_time
  is '时间';
comment on column MB_THW_CNT_CELL_GPRS_6K.c1279175419
  is 'A9203:无信道资源导致上行EGPRSTBF建立失败次数';
comment on column MB_THW_CNT_CELL_GPRS_6K.c1279176419
  is 'A9303:无信道资源导致下行EGPRSTBF建立失败次数';

prompt
prompt Creating table MB_THW_CNT_CELL_HO_6K
prompt ====================================
prompt
create table MB_THW_CNT_CELL_HO_6K
(
  int_id      NUMBER(28),
  record_time TIMESTAMP(6),
  c1278087446 NUMBER(28,8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_THW_CNT_CELL_HO_6K.int_id
  is '小区级唯一标识';
comment on column MB_THW_CNT_CELL_HO_6K.record_time
  is '时间';
comment on column MB_THW_CNT_CELL_HO_6K.c1278087446
  is 'RK3255:TRX载频可用率';

prompt
prompt Creating table MB_TNK_CNT_CELL_GPRS_PACK
prompt ========================================
prompt
create table MB_TNK_CNT_CELL_GPRS_PACK
(
  int_id              NUMBER(28),
  record_time         TIMESTAMP(6),
  no_rad_res_ava_ul_t NUMBER(28),
  no_rad_res_ava_dl_t NUMBER(28)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TNK_CNT_CELL_GPRS_PACK.int_id
  is '小区级唯一标识';
comment on column MB_TNK_CNT_CELL_GPRS_PACK.record_time
  is '时间';
comment on column MB_TNK_CNT_CELL_GPRS_PACK.no_rad_res_ava_ul_t
  is 'NO_RAD_RES_AVA_UL_T';
comment on column MB_TNK_CNT_CELL_GPRS_PACK.no_rad_res_ava_dl_t
  is 'NO_RAD_RES_AVA_DL_T';

prompt
prompt Creating table MB_TNK_CNT_CELL_RES_AVAIL
prompt ========================================
prompt
create table MB_TNK_CNT_CELL_RES_AVAIL
(
  int_id                     NUMBER(28),
  record_time                TIMESTAMP(6),
  ave_avail_tch_sum          NUMBER(28),
  ave_avail_tch_den          NUMBER(8),
  ave_gprs_channels_sum      NUMBER(28),
  ave_gprs_channels_den      NUMBER(8),
  ave_permanent_gprs_ch_sum  NUMBER(28),
  ave_permanent_gprs_ch_den  NUMBER(8),
  ave_non_avail_tch_timeslot NUMBER(28),
  non_avail_tch_denom        NUMBER(8),
  ave_sdcch_sub              NUMBER(28),
  res_av_denom3              NUMBER(8),
  ave_non_avail_sdcch        NUMBER(28)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TNK_CNT_CELL_RES_AVAIL.int_id
  is '小区级唯一标识';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.record_time
  is '时间';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.ave_avail_tch_sum
  is 'AVE_AVAIL_TCH_SUM';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.ave_avail_tch_den
  is 'AVE_AVAIL_TCH_DEN';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.ave_gprs_channels_sum
  is 'AVE_GPRS_CHANNELS_SUM';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.ave_gprs_channels_den
  is 'AVE_GPRS_CHANNELS_DEN';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.ave_permanent_gprs_ch_sum
  is 'AVE_PERMANENT_GPRS_CH_SUM';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.ave_permanent_gprs_ch_den
  is 'AVE_PERMANENT_GPRS_CH_DEN';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.ave_non_avail_tch_timeslot
  is 'AVE_NON_AVAIL_TCH_TIMESLOT';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.non_avail_tch_denom
  is 'NON_AVAIL_TCH_DENOM';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.ave_sdcch_sub
  is 'AVE_SDCCH_SUB';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.res_av_denom3
  is 'RES_AV_DENOM3';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.ave_non_avail_sdcch
  is 'AVE_NON_AVAIL_SDCCH';

prompt
prompt Creating table MB_TPA_STS_CELL_GPRS_NE
prompt ======================================
prompt
create table MB_TPA_STS_CELL_GPRS_NE
(
  int_id        NUMBER(28),
  record_time   TIMESTAMP(6),
  m_occupy_pdch NUMBER(28,8),
  static_pdch   NUMBER(8),
  sum_level     NUMBER(8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TPA_STS_CELL_GPRS_NE.int_id
  is '小区级唯一标识';
comment on column MB_TPA_STS_CELL_GPRS_NE.record_time
  is '时间';
comment on column MB_TPA_STS_CELL_GPRS_NE.m_occupy_pdch
  is '占用的PDCH的平均数目';
comment on column MB_TPA_STS_CELL_GPRS_NE.static_pdch
  is 'PDCH静态配置数';
comment on column MB_TPA_STS_CELL_GPRS_NE.sum_level
  is '时间粒度';

prompt
prompt Creating table MB_TPA_STS_CELL_NE
prompt =================================
prompt
create table MB_TPA_STS_CELL_NE
(
  int_id            NUMBER(28),
  record_time       TIMESTAMP(6),
  tch_traffic_half  NUMBER(28,8),
  tch_traffic       NUMBER(28,8),
  att_tch_ovrfl_nho NUMBER(28,8),
  tch_call_req_nho  NUMBER(28,8),
  att_tch_ovrfl     NUMBER(28,8),
  tch_call_req      NUMBER(28,8),
  tch_nbr           NUMBER(28,8),
  sum_level         NUMBER(8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TPA_STS_CELL_NE.int_id
  is '小区级唯一标识';
comment on column MB_TPA_STS_CELL_NE.record_time
  is '时间';
comment on column MB_TPA_STS_CELL_NE.tch_traffic_half
  is '半速率话音信道话务量';
comment on column MB_TPA_STS_CELL_NE.tch_traffic
  is '小区总话务量';
comment on column MB_TPA_STS_CELL_NE.att_tch_ovrfl_nho
  is '话音信道溢出次数（不含切换）';
comment on column MB_TPA_STS_CELL_NE.tch_call_req_nho
  is '话音信道试呼次数（不含切换)';
comment on column MB_TPA_STS_CELL_NE.att_tch_ovrfl
  is '话音信道溢出次数（含切换)';
comment on column MB_TPA_STS_CELL_NE.tch_call_req
  is '话音信道试呼次数（含切换)';
comment on column MB_TPA_STS_CELL_NE.tch_nbr
  is 'TCH信道配置数';
comment on column MB_TPA_STS_CELL_NE.sum_level
  is '时间粒度';

prompt
prompt Creating table MB_TPD_STS_CARRIER_Q
prompt ===================================
prompt
create table MB_TPD_STS_CARRIER_Q
(
  int_id        NUMBER(28),
  record_time   TIMESTAMP(6),
  meannbruser_d NUMBER(8),
  nbrassnbruul  NUMBER(28,8),
  nbrassnbrudl  NUMBER(28,8),
  nbravailbruul NUMBER(8),
  nbravailbrudl NUMBER(8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TPD_STS_CARRIER_Q.int_id
  is '载频级唯一标识
';
comment on column MB_TPD_STS_CARRIER_Q.record_time
  is '时间
';
comment on column MB_TPD_STS_CARRIER_Q.meannbruser_d
  is '载频HSDPA平均用户数
';
comment on column MB_TPD_STS_CARRIER_Q.nbrassnbruul
  is '载频上行业务占用的BRU总数
';
comment on column MB_TPD_STS_CARRIER_Q.nbrassnbrudl
  is '载频下行业务占用的BRU总数
';
comment on column MB_TPD_STS_CARRIER_Q.nbravailbruul
  is '载频上行可用的BRU总数
';
comment on column MB_TPD_STS_CARRIER_Q.nbravailbrudl
  is '载频下行可用的BRU总数
';

prompt
prompt Creating table MB_TPD_STS_UTRANCELL1_Q
prompt ======================================
prompt
create table MB_TPD_STS_UTRANCELL1_Q
(
  int_id             NUMBER(28),
  record_time        TIMESTAMP(6),
  vendor_id          VARCHAR2(256),
  failestabcs_20     NUMBER(28),
  failestabcs_114    NUMBER(28),
  failestabps_20     NUMBER(28),
  failestabps_114    NUMBER(28),
  failconnestab      NUMBER(28),
  failestabcs_53     NUMBER(28),
  failestabps_53     NUMBER(28),
  failconnestab_1    NUMBER(28),
  failconnestab_cong NUMBER(28)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TPD_STS_UTRANCELL1_Q.int_id
  is '小区级唯一标识';
comment on column MB_TPD_STS_UTRANCELL1_Q.record_time
  is '时间';
comment on column MB_TPD_STS_UTRANCELL1_Q.vendor_id
  is '厂家';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabcs_20
  is '原因为20的指配失败的电路域RAB数（小区级）';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabcs_114
  is '原因为114的指配失败的电路域RAB数（小区级）';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabps_20
  is '原因20的指配失败的分组域RAB数（小区级）';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabps_114
  is '原因为114的指配失败的分组域RAB数（小区级）';
comment on column MB_TPD_STS_UTRANCELL1_Q.failconnestab
  is 'RRC连接失败次数';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabcs_53
  is '原因为53的指配失败的电路域的RAB数（小区级）';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabps_53
  is '原因为53的指配失败的分组域RAB数（小区级）';
comment on column MB_TPD_STS_UTRANCELL1_Q.failconnestab_1
  is '原因为1的RRC连接失败次数';
comment on column MB_TPD_STS_UTRANCELL1_Q.failconnestab_cong
  is '原因为Cong的RRC连接失败次数';

prompt
prompt Creating table MB_TPD_STS_UTRANCELL2_Q
prompt ======================================
prompt
create table MB_TPD_STS_UTRANCELL2_Q
(
  record_time      TIMESTAMP(6),
  psuloct          NUMBER(28,8),
  psdloct          NUMBER(28,8),
  cstraffic_conv11 NUMBER(28,8),
  cstraffic_conv22 NUMBER(28,8),
  cstraffic_conv55 NUMBER(28,8),
  int_id           NUMBER(28)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TPD_STS_UTRANCELL2_Q.record_time
  is '时间';
comment on column MB_TPD_STS_UTRANCELL2_Q.psuloct
  is 'RLC层分组域上行流量';
comment on column MB_TPD_STS_UTRANCELL2_Q.psdloct
  is 'RLC层分组域下行流量';
comment on column MB_TPD_STS_UTRANCELL2_Q.cstraffic_conv11
  is 'RLC层电路域会话类窄带AMR话务量';
comment on column MB_TPD_STS_UTRANCELL2_Q.cstraffic_conv22
  is 'RLC层电路域会话类上下行12_2K话务量';
comment on column MB_TPD_STS_UTRANCELL2_Q.cstraffic_conv55
  is 'RLC层电路域会话类上下行64K话务量';
comment on column MB_TPD_STS_UTRANCELL2_Q.int_id
  is '小区级唯一标识';

prompt
prompt Creating table MB_TZX_CNT_CELL2_V3
prompt ==================================
prompt
create table MB_TZX_CNT_CELL2_V3
(
  int_id       NUMBER(28),
  record_time  TIMESTAMP(6),
  c90108000030 NUMBER(8),
  c90108000031 NUMBER(8),
  c90108000007 NUMBER(28,8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TZX_CNT_CELL2_V3.int_id
  is '小区级唯一标识';
comment on column MB_TZX_CNT_CELL2_V3.record_time
  is '时间';
comment on column MB_TZX_CNT_CELL2_V3.c90108000030
  is '载波总数';
comment on column MB_TZX_CNT_CELL2_V3.c90108000031
  is '完好载波总数';
comment on column MB_TZX_CNT_CELL2_V3.c90108000007
  is 'SDCCH静态配置可用个数';

prompt
prompt Creating table MB_TZX_CNT_CELL_GPRS_DL_V3
prompt =========================================
prompt
create table MB_TZX_CNT_CELL_GPRS_DL_V3
(
  int_id       NUMBER(28),
  record_time  TIMESTAMP(6),
  c90118000008 NUMBER(8)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TZX_CNT_CELL_GPRS_DL_V3.int_id
  is '小区级唯一标识';
comment on column MB_TZX_CNT_CELL_GPRS_DL_V3.record_time
  is '时间';
comment on column MB_TZX_CNT_CELL_GPRS_DL_V3.c90118000008
  is '下行EGPRS TBF建链请求数据库因RR资源拥塞失败次数';

prompt
prompt Creating table MB_TZX_CNT_CELL_GPRS_UL_V3
prompt =========================================
prompt
create table MB_TZX_CNT_CELL_GPRS_UL_V3
(
  int_id       NUMBER(28),
  record_time  TIMESTAMP(6),
  c90120000016 NUMBER(20)
)
partition by range (RECORD_TIME)
(
  partition PART_20140728 values less than (TIMESTAMP' 2014-07-29 00:00:00')
    tablespace T_TEST,
  partition PART_20140729 values less than (TIMESTAMP' 2014-07-30 00:00:00')
    tablespace T_TEST,
  partition PART_20140730 values less than (TIMESTAMP' 2014-07-31 00:00:00')
    tablespace T_TEST,
  partition PART_20140731 values less than (TIMESTAMP' 2014-08-01 00:00:00')
    tablespace T_TEST,
  partition PART_20140801 values less than (TIMESTAMP' 2014-08-02 00:00:00')
    tablespace T_TEST,
  partition PART_20140809 values less than (TIMESTAMP' 2014-08-10 00:00:00')
    tablespace T_TEST,
  partition PART_20140810 values less than (TIMESTAMP' 2014-08-11 00:00:00')
    tablespace T_TEST,
  partition PART_20140811 values less than (TIMESTAMP' 2014-08-12 00:00:00')
    tablespace T_TEST,
  partition PART_20140812 values less than (TIMESTAMP' 2014-08-13 00:00:00')
    tablespace T_TEST,
  partition PART_20140813 values less than (TIMESTAMP' 2014-08-14 00:00:00')
    tablespace T_TEST
);
comment on column MB_TZX_CNT_CELL_GPRS_UL_V3.int_id
  is '小区级唯一标识';
comment on column MB_TZX_CNT_CELL_GPRS_UL_V3.record_time
  is '时间';
comment on column MB_TZX_CNT_CELL_GPRS_UL_V3.c90120000016
  is '上行GPRS TBF建立请求数据库因RR资源拥塞失败次数';

prompt
prompt Creating table T1
prompt =================
prompt
create table T1
(
  cell_id      VARCHAR2(256),
  min_distance NUMBER(16,8),
  test1        TIMESTAMP(6)
)
;
create index IDX_T2_CELLID on T1 (CELL_ID);

prompt
prompt Creating table T2
prompt =================
prompt
create table T2
(
  val  INTEGER,
  test NUMBER(4)
)
;

prompt
prompt Creating procedure PROC_ADD_PARTITION
prompt =====================================
prompt
CREATE OR REPLACE PROCEDURE PROC_ADD_PARTITION
AS
 V_SQL_PARTION VARCHAR2(5000); --动态sql语句
 V_FALG_PARTION INT:=0;  -- 判断配置表是否已经入数据
 v_part_name varchar2(20);
 v_part_time varchar2(30);


BEGIN

        select to_char(trunc(sysdate+1),'yyyymmdd'),to_char(trunc(sysdate+2),'yyyy-mm-dd hh24:mi:ss')  into v_part_name,v_part_time from dual;
        --读取统计分区表数据,查询该表的分区是否已建
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_MR_RECORD' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_MR_RECORD add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


       select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_GSM_BUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PERF_GSM_BUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


              select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_LTE_CELLBUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PERF_LTE_CELLBUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_TDS_BUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PERF_TDS_BUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



       select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSSITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_TDSSITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


              select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSCELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_TDSCELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSCELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_TDSCELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_PARAM' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_PARAM add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_INFO_T' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_INFO_T add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_TDSNBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_TDSNBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_PARAM' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_PARAM add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_LTENBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_LTENBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_INFO_T' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_INFO_T add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_GSMNBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_GSMNBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMSITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GSMSITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMCELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GSMCELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMCELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GSMCELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_TDSPERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GIS_TDSPERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_PERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GIS_PERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_GSMPERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GIS_GSMPERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_LTESITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PLAN_LTESITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

          select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_LTECELL_INFO' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PLAN_LTECELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
   select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_7DAYS_ONLINE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PLAN_7DAYS_ONLINE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_BIN_PROCESS_INFO' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_BIN_PROCESS_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_PING_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_LTE_ST_PING_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_FTP_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_LTE_ST_FTP_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_VIDEO_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_LTE_ST_VIDEO_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_HTTP_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_LTE_ST_HTTP_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



         select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_TCO_PRO_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_TCO_PRO_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL_HO_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL_HO_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPA_STS_CELL_NE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TPA_STS_CELL_NE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPA_STS_CELL_GPRS_NE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TPA_STS_CELL_GPRS_NE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL_GPRS_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL_GPRS_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL_GPRS_UL_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL_GPRS_UL_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL_GPRS_DL_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL_GPRS_DL_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TNK_CNT_CELL_GPRS_PACK' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TNK_CNT_CELL_GPRS_PACK add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TER_CNT_CELL_GPRS' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TER_CNT_CELL_GPRS add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL2_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL2_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL2_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL2_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TER_CNT_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TER_CNT_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TNK_CNT_CELL_RES_AVAIL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TNK_CNT_CELL_RES_AVAIL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_BTS_TYPE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_BTS_TYPE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_UTRANCELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_UTRANCELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_TCO_PRO_UTRANCELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_TCO_PRO_UTRANCELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_RNC' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_RNC add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_UTRANCELL1_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TPD_STS_UTRANCELL1_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_UTRANCELL2_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TPD_STS_UTRANCELL2_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_CARRIER_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TPD_STS_CARRIER_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_CARRIER' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_CARRIER add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        end;
/

prompt
prompt Creating procedure PROC_ADD_PARTITION_BAK
prompt =========================================
prompt
CREATE OR REPLACE PROCEDURE PROC_ADD_PARTITION_bak
AS
 V_SQL_PARTION VARCHAR2(5000); --动态sql语句
 V_FALG_PARTION INT:=0;  -- 判断配置表是否已经入数据
 v_part_name varchar2(20);
 v_part_time varchar2(30);


BEGIN

        select to_char(trunc(sysdate),'yyyymmdd'),to_char(trunc(sysdate+1),'yyyy-mm-dd hh24:mi:ss')  into v_part_name,v_part_time from dual;
        --读取统计分区表数据,查询该表的分区是否已建
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_MR_RECORD' and t.partition_name='PART_'||v_part_name;
        dbms_output.put_line('v_part_name='||v_part_name);
        dbms_output.put_line('v_part_time='||v_part_time);

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_MR_RECORD add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


       select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_GSM_BUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PERF_GSM_BUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


              select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_LTE_CELLBUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PERF_LTE_CELLBUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_TDS_BUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PERF_TDS_BUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



       select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSSITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_TDSSITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


              select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSCELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_TDSCELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSCELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_TDSCELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_PARAM' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_PARAM add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_INFO_T' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_INFO_T add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_TDSNBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_TDSNBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_PARAM' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_PARAM add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_LTENBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_LTENBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_INFO_T' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_INFO_T add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_GSMNBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_GSMNBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMSITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GSMSITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMCELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GSMCELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMCELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GSMCELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_TDSPERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GIS_TDSPERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_PERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GIS_PERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_GSMPERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_SYS_GIS_GSMPERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_LTESITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PLAN_LTESITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

          select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_LTECELL_INFO' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PLAN_LTECELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
   select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_7DAYS_ONLINE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_PLAN_7DAYS_ONLINE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_BIN_PROCESS_INFO' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_BIN_PROCESS_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_PING_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_LTE_ST_PING_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_FTP_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_LTE_ST_FTP_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_VIDEO_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_LTE_ST_VIDEO_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_HTTP_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_LTE_ST_HTTP_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



         select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_TCO_PRO_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_TCO_PRO_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL_HO_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL_HO_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPA_STS_CELL_NE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TPA_STS_CELL_NE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPA_STS_CELL_GPRS_NE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TPA_STS_CELL_GPRS_NE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL_GPRS_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL_GPRS_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL_GPRS_UL_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL_GPRS_UL_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL_GPRS_DL_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL_GPRS_DL_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TNK_CNT_CELL_GPRS_PACK' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TNK_CNT_CELL_GPRS_PACK add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TER_CNT_CELL_GPRS' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TER_CNT_CELL_GPRS add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL2_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL2_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL2_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL2_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TER_CNT_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TER_CNT_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TNK_CNT_CELL_RES_AVAIL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TNK_CNT_CELL_RES_AVAIL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_BTS_TYPE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_BTS_TYPE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_UTRANCELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_UTRANCELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_TCO_PRO_UTRANCELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_TCO_PRO_UTRANCELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_RNC' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_RNC add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_UTRANCELL1_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TPD_STS_UTRANCELL1_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_UTRANCELL2_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TPD_STS_UTRANCELL2_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_CARRIER_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TPD_STS_CARRIER_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_CARRIER' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --建统计表的分区
             V_SQL_PARTION:='alter table MB_TCC_CARRIER add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        end;
/

prompt
prompt Creating procedure PROC_DATA_DEL
prompt ================================
prompt
create or replace procedure proc_data_del(tab_name char,part_ char) as
 v_sql varchar2(2000);
 begin

   v_sql :='alter table '||tab_name||' truncate partition(part_)'||part_;
   dbms_output.put_line(v_sql);
   exception
        when INVALID_NUMBER   then
              DBMS_OUTPUT.PUT_LINE('内嵌的sql语句不能将字符转换为数字');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('为定义对象');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('除数为0');
        when others then
             DBMS_OUTPUT.PUT_LINE('其他数据错误');
        rollback ;

 end;
/

prompt
prompt Creating procedure PROC_DATA_NUM
prompt ================================
prompt
create or replace procedure proc_data_num as   --规划工参和现网工参入库程序，在每日唐朝辉计算完成后调用
 v_insert varchar2(20000);--SQL
 v_part varchar2(30);  --分区名
 v_del varchar2(2000);

begin
  select 'part_'||to_char(sysdate-1,'yyyymmdd')  into v_part from dual;  --前一天的数据

  v_insert :='insert into MB_DATA_REPORT_INFO select b.record_time,b.type,b.province,b.city,a.original_record_num,b.sys_clean,b.sys_valid,a.original_file_num,a.original_file_size,a.data_origin from MB_BIN_PROCESS_INFO  partition('||v_part||')  a  ,(
select a.record_time,a.type ,a.province,a.city,a.sys_clean,b.sys_valid    from (
select b.province,b.city,a.record_time,count(*) sys_clean,''现网工参'' type from MB_SYS_LTECELL_INFO  partition('||v_part||') a,mb_sys_Gis_Permission  partition('||v_part||') b
where a.enodeb_glb_id = b.enodeb_glb_id(+) and b.city !=''unkonw region'' group by   b.province,b.city,a.record_time) a
left join (select b.province, b.city, a.record_time, count(*) sys_valid,''现网工参'' type
  from MB_SYS_LTECELL_INFO   partition('||v_part||') a,
       mb_sys_Gis_Permission  partition('||v_part||') b,
       MB_SYS_LTEsite_INFO   partition('||v_part||') c
 where a.enodeb_glb_id = b.enodeb_glb_id(+)
   and a.enodeb_glb_id = c.enodeb_glb_id(+)
   and c.longitude is not null
   and c.longitude >=80
   and c.latitude <80
   and c.latitude is not null
   and a.enodeb_glb_id is not null
   --and c.project_period is not null
   and c.tac is not null
   and a.pci is not null
   and b.city !=''unkonw region''
 group by b.province, b.city, a.record_time
)  b on a.record_time = b.record_time   and a.city =b.city
 union all
 select c.record_time,c.type ,c.province,c.city_name city,c.plan_clean,d.plan_valid from (
 select record_time,''四川省'' province,city_name,count(*) plan_clean ,''规划工参'' type from mb_plan_ltesite_info  partition('||v_part||') a group by record_time,city_name
) c    left join (
select record_time,''四川省'' province,city_name,count(*) plan_valid from mb_plan_ltesite_info  partition('||v_part||') a where    a.longitude is not null
   and a.longitude >=80
   and a.latitude <80
   and a.latitude is not null  and a.projectphase is not null group by record_time,city_name
) d on c.record_time = d.record_time  and c.city_name =d.city_name
) b where  a.record_time(+) = b.record_time and a.type(+) = b.type   and a.city(+) = b.city
 ';
 v_del :=' delete mb_data_report_info     where rowid in (select a.rowid from  mb_data_report_info  a,  mb_data_report_info   b 
 where a.rowid>b.rowid and a.record_time=b.record_time and a.city = b.city and a.data_origin = b.data_origin) ';
 dbms_output.put_line(v_insert);
 execute immediate v_insert;
 dbms_output.put_line(v_del);
 execute immediate v_del;
 commit;
 exception
        when INVALID_NUMBER   then
              DBMS_OUTPUT.PUT_LINE('内嵌的sql语句不能将字符转换为数字');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('为定义对象');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('除数为0');
        when others then
             DBMS_OUTPUT.PUT_LINE('其他数据错误');
        rollback ;

end;
/

prompt
prompt Creating procedure PROC_DATA_NUM_HOUR
prompt =====================================
prompt
create or replace procedure proc_data_num_hour(v_sttime varchar,v_edtime varchar,type varchar ) as
v_insert varchar2(5000);
 v_endtime varchar2(50);
v_del varchar2(2000);
v_part varchar2(40);
v_cell varchar2(5000);
begin
  select  'partition(part_'||substr(v_sttime,0,8)||')' into v_part from dual;
  v_endtime:=v_edtime;
  if v_sttime = v_edtime then
    v_endtime := to_char(to_date(v_sttime,'yyyymmdd hh24:mi:ss')+1/24,'yyyymmdd hh24:mi:ss');
  end if;
  dbms_output.put_line(v_sttime);
  dbms_output.put_line(v_endtime);
  if type='1' then   ----话统
  v_insert :='
   insert into MB_DATA_REPORT_INFO(Record_Time,Type,province,city,Original_Record_Num,CLEAN_DATA_NUM,Original_File_Num,Original_File_Size,DATA_ORIGIN)
select to_date(a.record_time,''yyyymmdd hh24:mi:ss'') record_time,a.type,a.province,a.city,b.original_record_num,a.clean,b.original_file_num,b.original_file_size,''文件'' from   (
select t1.record_time,t1.province,t1.city,nvl(t1.clean,0)+nvl(t2.clean,0)+nvl(t3.clean,0) clean,t1.type from (
select to_char(record_time,''yyyymmdd hh24'') record_time,''四川省'' province ,city,count(*) clean, ''话统'' type from mb_perf_lte_cellbusistat where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
 group by to_char(record_time,''yyyymmdd hh24''),city) t1 ,(select to_char(record_time,''yyyymmdd hh24'') record_time,''四川省'' province ,city,count(*) clean, ''话统'' type from MB_PERF_TDS_BUSISTAT where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
 group by to_char(record_time,''yyyymmdd hh24''),city )t2,(select to_char(record_time,''yyyymmdd hh24'') record_time,''四川省'' province ,city,count(*) clean, ''话统'' type from MB_PERF_GSM_BUSISTAT where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
 group by to_char(record_time,''yyyymmdd hh24''),city ) t3 where t1.record_time = t2.record_time(+) and t1.city = t2.city(+)  and  t1.record_time = t3.record_time(+) and t1.city = t3.city(+)  
 ) a left join (select to_char(record_time,''yyyymmdd hh24'') record_time,city,type,sum(t.original_record_num) original_record_num ,sum(t.original_file_num) original_file_num,
sum(t.original_file_size) original_file_size 
from MB_BIN_PROCESS_INFO t where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
 and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
group by to_char(record_time,''yyyymmdd hh24''),type,city) b on a.record_time = b.record_time  and  a.type = b.type and a.city =b.city
';
v_cell :='insert into mb_sys_traffic_cell select to_date(record_time,''yyyymmdd hh24''),city,count(*) cell_count,type from (
select distinct  to_char(record_time,''yyyymmdd hh24'') record_time,cell_glb_id ,city,''4G'' type  from mb_perf_lte_cellbusistat   where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
 and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
union all 
 select distinct  to_char(record_time,''yyyymmdd hh24'') ,cell_glb_id ,city,''3G'' type from MB_PERF_TDS_BUSISTAT  where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
 and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
 union all 
  select distinct  to_char(record_time,''yyyymmdd hh24'') ,cell_glb_id ,city ,''2G'' type from MB_PERF_GSM_BUSISTAT  where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
 and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'') 
  ) group by city,record_time,type';
end if;
 
if type='2' then   ----路测
    v_insert :='
insert into MB_DATA_REPORT_INFO(Record_Time,Type,Original_Record_Num,CLEAN_DATA_NUM,Original_File_Num,Original_File_Size,DATA_ORIGIN)
select to_date(a.record_time,''yyyymmdd hh24:mi:ss'') record_time,a.type,b.original_record_num,a.clean,b.original_file_num,b.original_file_size,b.data_origin from   (
 
select to_char(record_time,''yyyymmdd hh24'') record_time,count(*) clean,''路测'' type from mb_dt_record where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
 and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
group by to_char(record_time,''yyyymmdd hh24'')
) a left join (select to_char(record_time,''yyyymmdd hh24'') record_time,type, data_generation,sum(t.original_record_num) original_record_num ,sum(t.original_file_num) original_file_num,
sum(t.original_file_size) original_file_size,t.data_origin 
from MB_BIN_PROCESS_INFO t where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
 and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
group by to_char(record_time,''yyyymmdd hh24''),type, data_generation,data_origin) b on a.record_time = b.record_time  and  a.type = b.type
';
end if;
if type='3' then   ---MRO
      v_insert :='
insert into MB_DATA_REPORT_INFO(Record_Time,Type,Original_Record_Num,CLEAN_DATA_NUM,Original_File_Num,Original_File_Size,DATA_ORIGIN)
select to_date(a.record_time,''yyyymmdd hh24:mi:ss'') record_time,a.type,b.original_record_num,a.clean,b.original_file_num,b.original_file_size,b.data_origin from   (
 
select to_char(record_time,''yyyymmdd hh24'') record_time,count(*) clean,''路测'' type from mb_dt_record where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
 and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
group by to_char(record_time,''yyyymmdd hh24'')
) a left join (select to_char(record_time,''yyyymmdd hh24'') record_time,type, data_generation,sum(t.original_record_num) original_record_num ,sum(t.original_file_num) original_file_num,
sum(t.original_file_size) original_file_size,t.data_origin 
from MB_BIN_PROCESS_INFO t where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
 and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
group by to_char(record_time,''yyyymmdd hh24''),type, data_generation,data_origin) b on a.record_time = b.record_time  and  a.type = b.type
';
end if;  ----去重，暂时不用
v_del :=' delete mb_bin_process_info '||v_part||' where rowid in (select a.rowid from  mb_bin_process_info  '||v_part||'  a,  mb_bin_process_info  '||v_part||'  b 
 where a.rowid>b.rowid and a.record_time=b.record_time and a.city = b.city and a.data_generation = b.data_generation and a.type=b.type) ';
  
--dbms_output.put_line(v_del);
--execute immediate v_del;
dbms_output.put_line(v_insert);
execute immediate v_insert;
if length(v_cell) >0 then
dbms_output.put_line(v_cell);
execute immediate v_cell;
end if;
commit;
exception
        when INVALID_NUMBER   then
              DBMS_OUTPUT.PUT_LINE('内嵌的sql语句不能将字符转换为数字');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('为定义对象');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('除数为0');
        when others then
             DBMS_OUTPUT.PUT_LINE('其他数据错误');
        rollback ;
 end;
/

prompt
prompt Creating procedure PROC_DATA_NUM_TEST
prompt =====================================
prompt
create or replace procedure proc_data_num_test as   --规划工参和现网工参入库程序，在每日唐朝辉计算完成后调用
 v_insert varchar2(20000);--SQL
 v_part varchar2(30);  --分区名
 v_del varchar2(2000);

begin
  select 'part_'||to_char(sysdate-1,'yyyymmdd')  into v_part from dual;  --前一天的数据

  v_insert :='insert into MB_DATA_REPORT_INFO select b.record_time,b.type,b.province,b.city,a.original_record_num,b.sys_clean,b.sys_valid,a.original_file_num,a.original_file_size,a.data_origin from MB_BIN_PROCESS_INFO  partition('||v_part||')  a  ,(
select a.record_time,a.type ,a.province,a.city,a.sys_clean,b.sys_valid    from (
select b.province,b.city,a.record_time,count(*) sys_clean,''现网工参'' type from MB_SYS_LTECELL_INFO  partition('||v_part||') a,mb_sys_Gis_Permission  partition('||v_part||') b
where a.enodeb_glb_id = b.enodeb_glb_id(+) and b.city !=''unkonw region'' group by   b.province,b.city,a.record_time) a
left join (select b.province, b.city, a.record_time, count(*) sys_valid,''现网工参'' type
  from MB_SYS_LTECELL_INFO   partition('||v_part||') a,
       mb_sys_Gis_Permission  partition('||v_part||') b,
       MB_SYS_LTEsite_INFO   partition('||v_part||') c
 where a.enodeb_glb_id = b.enodeb_glb_id(+)
   and a.enodeb_glb_id = c.enodeb_glb_id(+)
   and c.longitude is not null
   and c.longitude >=80
   and c.latitude <80
   and c.latitude is not null
   and a.enodeb_glb_id is not null
   --and c.project_period is not null
   and c.tac is not null
   and a.pci is not null
   and b.city !=''unkonw region''
 group by b.province, b.city, a.record_time
)  b on a.record_time = b.record_time   and a.city =b.city
 union all
 select c.record_time,c.type ,c.province,c.city_name city,c.plan_clean,d.plan_valid from (
 select record_time,''四川省'' province,city_name,count(*) plan_clean ,''规划工参'' type from mb_plan_ltesite_info  partition('||v_part||') a group by record_time,city_name
) c    left join (
select record_time,''四川省'' province,city_name,count(*) plan_valid from mb_plan_ltesite_info  partition('||v_part||') a where    a.longitude is not null
   and a.longitude >=80
   and a.latitude <80
   and a.latitude is not null  and a.projectphase is not null group by record_time,city_name
) d on c.record_time = d.record_time  and c.city_name =d.city_name
) b where  a.record_time(+) = b.record_time and a.type(+) = b.type   and a.city(+) = b.city
 ';
 v_del :=' delete mb_data_report_info     where rowid in (select a.rowid from  mb_data_report_info  a,  mb_data_report_info   b
 where a.rowid>b.rowid and a.record_time=b.record_time and a.city = b.city and a.data_origin = b.data_origin) ';
 dbms_output.put_line(v_insert);
 execute immediate v_insert;
 dbms_output.put_line(v_del);
 execute immediate v_del;
 commit;
 exception
        when INVALID_NUMBER   then
              DBMS_OUTPUT.PUT_LINE('内嵌的sql语句不能将字符转换为数字');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('为定义对象');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('除数为0');
        when others then
             DBMS_OUTPUT.PUT_LINE('其他数据错误');
        rollback ;

end;
/

prompt
prompt Creating procedure PROC_DELROWS
prompt ===============================
prompt
create or replace procedure proc_delrows(table_n varchar,time_t varchar)--表名 ，不区分大小写； 时间，只允许20140606 或者2014-06-06两种格式
as
v_sql varchar2(2000); --去重SQL
num_a number(2); --某表是否存在ENODEB_GLB_ID列
num_b number(2);--某表是否存在CELL_GLB_ID列
table_name varchar2(300); --表名（包括分区）
v_tchar number(1);--表名标识，当那特定的3个表 时 此值为1
v_tchar2 number(1);--mb_plan_ltesite_info单独处理标识
v_tchar3 number(1);--mb_plan_ltesite_info单独处理标识



begin
  if lower(table_n) not in ('bz_test_insertprof','mb_dt_record','mb_mr_record','mb_omc_lo_la','mb_perf_gsm_busistat','mb_perf_lte_cellbusistat',
    'mb_perf_tds_busistat','mb_sys_ltecell_gsmnbr','mb_sys_ltecell_ltenbr','mb_sys_ltecell_tdsnbr','mb_test_scanfreq') then
  select count(1) into num_a from user_tab_columns where  table_name=upper(''||table_n||'') and column_name='ENODEB_GLB_ID';
   select count(1) into num_b from user_tab_columns where  table_name=upper(''||table_n||'') and column_name='CELL_GLB_ID';
   table_name :=table_n ||' partition(PART_'||replace(time_t,'-','')||')';
dbms_output.put_line(table_name);
if lower(table_n) ='mb_sys_gis_gsmpermission' or  lower(table_n) ='mb_sys_tdssite_info' or lower(table_n) ='mb_sys_gsmsite_info'
  then
   v_sql :='delete '||table_name||'  where rowid in (select a.rowid from '||table_name||' a, '||table_name||' b where a.rowid>b.rowid and a.SITE_GLB_ID=b.SITE_GLB_ID) ';
   v_tchar := 1;
else
if num_a =1
  then
    dbms_output.put_line(num_a);
    v_sql :='delete '||table_name||'  where rowid in (select a.rowid from '||table_name||' a, '||table_name||' b where a.rowid>b.rowid and a.ENODEB_GLB_ID=b.ENODEB_GLB_ID) ';
    end if;
if num_b =1
  then
      dbms_output.put_line(num_b);
    v_sql :='delete '||table_name||' where rowid in (select a.rowid from '||table_name||' a, '||table_name||' b where a.rowid>b.rowid and a.CELL_GLB_ID=b.CELL_GLB_ID) ';
end if;

end if;
if  lower(table_n)='mb_plan_ltesite_info' then
    v_sql :='delete '||table_name||' where rowid in (select a.rowid from '||table_name||' a, '||table_name||' b where a.rowid>b.rowid and a.PENODEBCLASS=b.PENODEBCLASS and  a.PENODEBNAME = b.PENODEBNAME and  a.PROVINCE_NAME = b.PROVINCE_NAME and  a.CITY_NAME = b.CITY_NAME and  a.COUNTRY_NAME=b.COUNTRY_NAME and  a.PENODEBID = b.PENODEBID) ';
    v_tchar2 := 1;
end if;
if  lower(table_n) in ('mb_sys_ltecell_info_t','mb_sys_ltesite_info_t') then
   v_sql :='delete '||table_name||' where rowid in (select a.rowid from '||table_name||' a, '||table_name||' b where a.rowid>b.rowid and a.int_id=b.int_id) ';
    v_tchar3 := 1;

end if;
if num_a !=0 or num_b!=0 or v_tchar!=0 or v_tchar2!=0 or v_tchar3!=0  then
   dbms_output.put_line(v_sql);
execute immediate v_sql;
   dbms_output.put_line(v_sql);
 commit;

 end if;
 end if;
  exception
        when INVALID_NUMBER   then
              DBMS_OUTPUT.PUT_LINE('内嵌的sql语句不能将字符转换为数字');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('为定义对象');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('除数为0');
        when others then
             DBMS_OUTPUT.PUT_LINE('其他数据错误');
        rollback ;

end;
/

prompt
prompt Creating procedure PROC_DELROWS4
prompt ================================
prompt
create or replace procedure proc_delrows4(table_n varchar,time_t varchar)--表名 ，不区分大小写； 时间，只允许20140606 或者2014-06-06两种格式
as---按照时间段去重
v_sql varchar2(20000); --去重SQL
num_a number(2); --某表是否存在ENODEB_GLB_ID列
num_b number(2);--某表是否存在CELL_GLB_ID列
table_name varchar2(3000); --表名（包括分区）
v_tchar number(1);--表名标识，当那特定的3个表 时 此值为1
v_tchar2 number(1);--mb_plan_ltesite_info单独处理标识
v_tchar3 number(1);--mb_plan_ltesite_info单独处理标识
time_e varchar2(100);--结束程序
v_tchar4 number(1);


begin
  if lower(table_n) not in ('bz_test_insertprof','mb_dt_record','mb_mr_record','mb_omc_lo_la','mb_perf_gsm_busistat','mb_perf_lte_cellbusistat',
    'mb_perf_tds_busistat','mb_sys_ltecell_gsmnbr','mb_sys_ltecell_ltenbr','mb_sys_ltecell_tdsnbr','mb_test_scanfreq') then
  select count(1) into num_a from user_tab_columns where  table_name=upper(''||table_n||'') and column_name='ENODEB_GLB_ID';
   select count(1) into num_b from user_tab_columns where  table_name=upper(''||table_n||'') and column_name='CELL_GLB_ID';
  select to_char(to_date(time_t,'yyyy-mm-dd')+1,'yyyy-mm-dd') into time_e from dual;
   table_name :=table_n;
dbms_output.put_line(table_name);
dbms_output.put_line(time_t);
 dbms_output.put_line(time_e);
if lower(table_n) ='mb_sys_gis_gsmpermission' or  lower(table_n) ='mb_sys_tdssite_info' or lower(table_n) ='mb_sys_gsmsite_info'
  then
   v_sql :='delete '||table_name||'  where rowid in (select a.rowid from '||table_name||' a, '||table_name||' b where a.rowid>b.rowid and a.SITE_GLB_ID=b.SITE_GLB_ID and a.record_time>=to_date('''||time_t||''',''yyyy-mm-dd'') and a.record_time<to_date('''||time_e||''',''yyyy-mm-dd'') and b.record_time>=to_date('''||time_t||''',''yyyy-mm-dd'') and b.record_time<to_date('''||time_e||''',''yyyy-mm-dd'')) ';
   v_tchar := 1;
else
if num_a =1
  then
    dbms_output.put_line(num_a);
    v_sql :='delete '||table_name||'  where rowid in (select a.rowid from '||table_name||' a, '||table_name||' b where a.rowid>b.rowid and a.ENODEB_GLB_ID=b.ENODEB_GLB_ID and a.record_time>=to_date('''||time_t||''',''yyyy-mm-dd'') and a.record_time<to_date('''||time_e||''',''yyyy-mm-dd'') and b.record_time>=to_date('''||time_t||''',''yyyy-mm-dd'') and b.record_time<to_date('''||time_e||''',''yyyy-mm-dd'')) ';
    end if;
if num_b =1
  then
      dbms_output.put_line(num_b);
    v_sql :='delete '||table_name||' where rowid in (select a.rowid from '||table_name||' a, '||table_name||' b where a.rowid>b.rowid and a.CELL_GLB_ID=b.CELL_GLB_ID and a.record_time>=to_date('''||time_t||''',''yyyy-mm-dd'') and a.record_time<to_date('''||time_e||''',''yyyy-mm-dd'') and b.record_time>=to_date('''||time_t||''',''yyyy-mm-dd'') and b.record_time<to_date('''||time_e||''',''yyyy-mm-dd'')) ';
end if;

end if;
if  lower(table_n)='mb_plan_ltesite_info' then
    v_sql :='delete '||table_name||' where rowid in (select a.rowid from '||table_name||' a, '||table_name||' b where a.rowid>b.rowid and a.PENODEBCLASS=b.PENODEBCLASS and  a.PENODEBNAME = b.PENODEBNAME and  a.PROVINCE_NAME = b.PROVINCE_NAME and  a.CITY_NAME = b.CITY_NAME and  a.COUNTRY_NAME=b.COUNTRY_NAME and  a.PENODEBID = b.PENODEBID and a.record_time>=to_date('''||time_t||''',''yyyy-mm-dd'') and a.record_time<to_date('''||time_e||''',''yyyy-mm-dd'') and b.record_time>=to_date('''||time_t||''',''yyyy-mm-dd'') and b.record_time<to_date('''||time_e||''',''yyyy-mm-dd'')) ';
    v_tchar2 := 1;
end if;
if  lower(table_n) in ('mb_sys_ltecell_info_t','mb_sys_ltesite_info_t') then
   v_sql :='delete '||table_name||' where rowid in (select a.rowid from '||table_name||' a, '||table_name||' b where a.rowid>b.rowid and a.int_id=b.int_id and a.record_time>=to_date('''||time_t||''',''yyyy-mm-dd'') and a.record_time<to_date('''||time_e||''',''yyyy-mm-dd'') and b.record_time>=to_date('''||time_t||''',''yyyy-mm-dd'') and b.record_time<to_date('''||time_e||''',''yyyy-mm-dd'')) ';
    v_tchar3 := 1;

end if;
 
if num_a !=0 or num_b!=0 or v_tchar!=0 or v_tchar2!=0 or v_tchar3!=0  then
   dbms_output.put_line(v_sql);
execute immediate v_sql;
   dbms_output.put_line(v_sql);
 commit;

 end if;
 end if;
  exception
        when INVALID_NUMBER   then
              DBMS_OUTPUT.PUT_LINE('内嵌的sql语句不能将字符转换为数字');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('为定义对象');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('除数为0');
        when others then
             DBMS_OUTPUT.PUT_LINE('其他数据错误');
        rollback ;

end;
/

prompt
prompt Creating procedure PROC_OPERASTATE
prompt ==================================
prompt
create or replace procedure proc_operastate(input varchar)  as
v_time1  varchar2(50);
v_time2 varchar2(50);
v_time3  varchar2(50);
v_time4 varchar2(50);
v_time5  varchar2(50);
v_time6 varchar2(50);
v_time7  varchar2(50);
v_sql varchar2(20000);
v_hour varchar2(10);
v_counter number(8);

begin
  if length(input) >4 then
select 'part_'||to_char(to_date(''||input||'','yyyymmdd')-1,'yyyymmdd')  into v_time1 from dual;
select 'part_'||to_char(to_date(''||input||'','yyyymmdd')-2,'yyyymmdd')  into v_time2 from dual;
select 'part_'||to_char(to_date(''||input||'','yyyymmdd')-3,'yyyymmdd')  into v_time3 from dual;
select 'part_'||to_char(to_date(''||input||'','yyyymmdd')-4,'yyyymmdd')  into v_time4 from dual;
select 'part_'||to_char(to_date(''||input||'','yyyymmdd')-5,'yyyymmdd')  into v_time5 from dual;
select 'part_'||to_char(to_date(''||input||'','yyyymmdd')-6,'yyyymmdd')  into v_time6 from dual;
select 'part_'||to_char(to_date(''||input||'','yyyymmdd')-7,'yyyymmdd')  into v_time7 from dual;
v_hour :='12';
select count(1) into v_counter from mb_plan_7days_online where record_time =trunc(to_date(''||input||'','yyyymmdd')-1) ;
else 
select 'part_'||to_char(sysdate-1,'yyyymmdd')  into v_time1 from dual;
select 'part_'||to_char(sysdate-2,'yyyymmdd')  into v_time2 from dual;
select 'part_'||to_char(sysdate-3,'yyyymmdd')  into v_time3 from dual;
select 'part_'||to_char(sysdate-4,'yyyymmdd')  into v_time4 from dual;
select 'part_'||to_char(sysdate-5,'yyyymmdd')  into v_time5 from dual;
select 'part_'||to_char(sysdate-6,'yyyymmdd')  into v_time6 from dual;
select 'part_'||to_char(sysdate-7,'yyyymmdd')  into v_time7 from dual;
select to_char(sysdate,'hh24') into v_hour from dual;
select count(1) into v_counter from mb_plan_7days_online where record_time >=trunc(sysdate-1) ;
end if;
dbms_output.put_line(v_counter);
if 1=1--v_counter =0 and (  v_hour = '12' or v_hour = '15'or v_hour = '18'or v_hour = '19'or v_hour = '17') 
  then
   v_sql := ' insert into mb_plan_7days_online
 select distinct record_time,city,project_period,enodeb_glb_id,case when nvl(online_mark1,0)+nvl(online_mark2,0)+nvl(online_mark3,0)
   +nvl(online_mark4,0)+nvl(online_mark5,0)+nvl(online_mark6,0)+nvl(online_mark7,0) =7 then 1 else 0 end
 online_mark7days,penodebid from (
 select t1.record_time,t1.city,t1.project_period,t1.enodeb_glb_id,t1.online_mark online_mark1,
 t2.online_mark online_mark2,t3.online_mark online_mark3,t4.online_mark online_mark4,t5.online_mark online_mark5,
 t6.online_mark online_mark6,t7.online_mark online_mark7,t1.penodebid from   (select   distinct a.record_time,city_name city,a.projectphase project_period,a.penodebid  ,b.enodeb_glb_id,b.online_mark  from mb_plan_ltesite_info partition('||v_time1||') a left join (
 select a.record_time,  b.city city,  d.project_period, a.enodeb_glb_id  enodeb_glb_id, substr(c.cgi,8,6) enodeb_id,   online_type online_mark
  from ( select a.record_time,     case   when sum(case when vendor_id like ''%中兴%'' then 1 else operationalstate end) > 0 then 1  else  0  end online_type,
         enodeb_glb_id from mb_sys_ltecell_info_t partition('||v_time1||') a ,mb_sys_ltecell_info partition('||v_time1||') b where a.cell_glb_id = b.cell_glb_id(+)
         group by a.record_time, enodeb_glb_id) a,
       mb_sys_gis_permission partition('||v_time1||') b,
       mb_sys_ltecell_info partition('||v_time1||') c,
       mb_sys_ltesite_info partition('||v_time1||') d 
 where a.enodeb_glb_id = b.enodeb_glb_id(+)
   and a.enodeb_glb_id = c.enodeb_glb_id(+)
   and a.enodeb_glb_id = d.enodeb_glb_id(+)
) b on a.penodebid = b.enodeb_id  
  ) t1 left join (select   distinct a.record_time,city_name city,a.projectphase project_period,a.penodebid  ,b.enodeb_glb_id,b.online_mark  from mb_plan_ltesite_info partition('||v_time2||') a left join (
 select a.record_time,  b.city city,  d.project_period, a.enodeb_glb_id  enodeb_glb_id, substr(c.cgi,8,6) enodeb_id,   online_type online_mark
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%中兴%'' then 1 else operationalstate end) > 0 then 1  else  0  end online_type,
         enodeb_glb_id from mb_sys_ltecell_info_t partition('||v_time2||') a ,mb_sys_ltecell_info partition('||v_time2||') b where a.cell_glb_id = b.cell_glb_id(+)
         group by a.record_time, enodeb_glb_id) a,
       mb_sys_gis_permission partition('||v_time2||') b,
       mb_sys_ltecell_info partition('||v_time2||') c,
       mb_sys_ltesite_info partition('||v_time2||') d 
 where a.enodeb_glb_id = b.enodeb_glb_id(+)
   and a.enodeb_glb_id = c.enodeb_glb_id(+)
   and a.enodeb_glb_id = d.enodeb_glb_id(+)
) b on a.penodebid = b.enodeb_id  
 ) t2  on   t1.enodeb_glb_id = t2.enodeb_glb_id
 left join  (select   distinct a.record_time,city_name city,a.projectphase project_period,a.penodebid  ,b.enodeb_glb_id,b.online_mark  from mb_plan_ltesite_info partition('||v_time3||') a left join (
 select a.record_time,  b.city city,  d.project_period, a.enodeb_glb_id  enodeb_glb_id, substr(c.cgi,8,6) enodeb_id,   online_type online_mark
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%中兴%'' then 1 else operationalstate end) > 0 then 1  else  0  end online_type,
         enodeb_glb_id from mb_sys_ltecell_info_t partition('||v_time3||') a ,mb_sys_ltecell_info partition('||v_time3||') b where a.cell_glb_id = b.cell_glb_id(+)
         group by a.record_time, enodeb_glb_id) a,
       mb_sys_gis_permission partition('||v_time3||') b,
       mb_sys_ltecell_info partition('||v_time3||') c,
       mb_sys_ltesite_info partition('||v_time3||') d 
 where a.enodeb_glb_id = b.enodeb_glb_id(+)
   and a.enodeb_glb_id = c.enodeb_glb_id(+)
   and a.enodeb_glb_id = d.enodeb_glb_id(+)
) b on a.penodebid = b.enodeb_id  
 ) t3 on   t1.enodeb_glb_id = t3.enodeb_glb_id left join
 (select   distinct a.record_time,city_name city,a.projectphase project_period,a.penodebid  ,b.enodeb_glb_id,b.online_mark  from mb_plan_ltesite_info partition('||v_time4||') a left join (
 select a.record_time,  b.city city,  d.project_period, a.enodeb_glb_id  enodeb_glb_id, substr(c.cgi,8,6) enodeb_id,   online_type online_mark
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%中兴%'' then 1 else operationalstate end)  > 0 then 1  else  0  end online_type,
         enodeb_glb_id from mb_sys_ltecell_info_t partition('||v_time4||') a ,mb_sys_ltecell_info partition('||v_time4||') b where a.cell_glb_id = b.cell_glb_id(+)
         group by a.record_time, enodeb_glb_id) a,
       mb_sys_gis_permission partition('||v_time4||') b,
       mb_sys_ltecell_info partition('||v_time4||') c,
       mb_sys_ltesite_info partition('||v_time4||') d 
 where a.enodeb_glb_id = b.enodeb_glb_id(+)
   and a.enodeb_glb_id = c.enodeb_glb_id(+)
   and a.enodeb_glb_id = d.enodeb_glb_id(+)
) b on a.penodebid = b.enodeb_id  
 ) t4 on   t1.enodeb_glb_id = t4.enodeb_glb_id
 left join (select   distinct a.record_time,city_name city,a.projectphase project_period,a.penodebid  ,b.enodeb_glb_id,b.online_mark  from mb_plan_ltesite_info partition('||v_time5||') a left join (
 select a.record_time,  b.city city,  d.project_period, a.enodeb_glb_id  enodeb_glb_id, substr(c.cgi,8,6) enodeb_id,   online_type online_mark
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%中兴%'' then 1 else operationalstate end)  > 0 then 1  else  0  end online_type,
         enodeb_glb_id from mb_sys_ltecell_info_t partition('||v_time5||') a ,mb_sys_ltecell_info partition('||v_time5||') b where a.cell_glb_id = b.cell_glb_id(+)
         group by a.record_time, enodeb_glb_id) a,
       mb_sys_gis_permission partition('||v_time5||') b,
       mb_sys_ltecell_info partition('||v_time5||') c,
       mb_sys_ltesite_info partition('||v_time5||') d 
 where a.enodeb_glb_id = b.enodeb_glb_id(+)
   and a.enodeb_glb_id = c.enodeb_glb_id(+)
   and a.enodeb_glb_id = d.enodeb_glb_id(+)
) b on a.penodebid = b.enodeb_id  
 ) t5 on   t1.enodeb_glb_id = t5.enodeb_glb_id left join
 (select   distinct a.record_time,city_name city,a.projectphase project_period,a.penodebid  ,b.enodeb_glb_id,b.online_mark  from mb_plan_ltesite_info partition('||v_time6||') a left join (
 select a.record_time,  b.city city,  d.project_period, a.enodeb_glb_id  enodeb_glb_id, substr(c.cgi,8,6) enodeb_id,   online_type online_mark
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%中兴%'' then 1 else operationalstate end) > 0 then 1  else  0  end online_type,
         enodeb_glb_id from mb_sys_ltecell_info_t partition('||v_time6||') a ,mb_sys_ltecell_info partition('||v_time6||') b where a.cell_glb_id = b.cell_glb_id(+)
         group by a.record_time, enodeb_glb_id) a,
       mb_sys_gis_permission partition('||v_time6||') b,
       mb_sys_ltecell_info partition('||v_time6||') c,
       mb_sys_ltesite_info partition('||v_time6||') d 
 where a.enodeb_glb_id = b.enodeb_glb_id(+)
   and a.enodeb_glb_id = c.enodeb_glb_id(+)
   and a.enodeb_glb_id = d.enodeb_glb_id(+)
) b on a.penodebid = b.enodeb_id  
 ) t6 on  t1.enodeb_glb_id = t6.enodeb_glb_id
 left join  (select   distinct a.record_time,city_name city,a.projectphase project_period,a.penodebid  ,b.enodeb_glb_id,b.online_mark  from mb_plan_ltesite_info partition('||v_time7||') a left join (
 select a.record_time,  b.city city,  d.project_period, a.enodeb_glb_id  enodeb_glb_id, substr(c.cgi,8,6) enodeb_id,   online_type online_mark
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%中兴%'' then 1 else operationalstate end)  > 0 then 1  else  0  end online_type,
         enodeb_glb_id from mb_sys_ltecell_info_t partition('||v_time7||') a ,mb_sys_ltecell_info partition('||v_time7||') b where a.cell_glb_id = b.cell_glb_id(+)
         group by a.record_time, enodeb_glb_id) a,
       mb_sys_gis_permission partition('||v_time7||') b,
       mb_sys_ltecell_info partition('||v_time7||') c,
       mb_sys_ltesite_info partition('||v_time7||') d 
 where a.enodeb_glb_id = b.enodeb_glb_id(+)
   and a.enodeb_glb_id = c.enodeb_glb_id(+)
   and a.enodeb_glb_id = d.enodeb_glb_id(+)
) b on a.penodebid = b.enodeb_id  
 ) t7   on   t1.enodeb_glb_id = t7.enodeb_glb_id  
 ）';
dbms_output.put_line(v_sql);
execute immediate v_sql;
commit;
end if;
 exception
        when INVALID_NUMBER   then
              DBMS_OUTPUT.PUT_LINE('内嵌的sql语句不能将字符转换为数字');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('为定义对象');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('除数为0');
        when others then
             DBMS_OUTPUT.PUT_LINE('其他数据错误');
        rollback ;
end;
/


spool off
