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
  is 'ͳ��API��;�����ݱ�������ʹ��';
comment on column MB_API_REPORT_INFO.app_name
  is 'APPӦ����';
comment on column MB_API_REPORT_INFO.api_name
  is '���ýӿ���';
comment on column MB_API_REPORT_INFO.request_api_time
  is '����ʱ��';
comment on column MB_API_REPORT_INFO.api_call_time
  is '������ʱ��';
comment on column MB_API_REPORT_INFO.call_state
  is '����״̬';
comment on column MB_API_REPORT_INFO.call_ip
  is '����IP';

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
  is 'ͳ���������õģ����ݱ�������ʹ��-�м��';
comment on column MB_BIN_PROCESS_INFO.record_time
  is '����';
comment on column MB_BIN_PROCESS_INFO.type
  is '�������ͣ��������Ρ��滮���Ρ�·�⡢��ͳ��mro�����';
comment on column MB_BIN_PROCESS_INFO.province
  is 'ʡ��';
comment on column MB_BIN_PROCESS_INFO.city
  is '����';
comment on column MB_BIN_PROCESS_INFO.original_record_num
  is 'ԭʼ������Ŀ
';
comment on column MB_BIN_PROCESS_INFO.original_file_num
  is 'ԭʼ�����ļ���
';
comment on column MB_BIN_PROCESS_INFO.original_file_size
  is '���մ����洢��������С
';
comment on column MB_BIN_PROCESS_INFO.data_origin
  is '������Դ �ļ���';
comment on column MB_BIN_PROCESS_INFO.data_generation
  is '2/3/4G �����ʶ';
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
  is 'ʱ��';
comment on column MB_BTS_TYPE.cgi
  is 'CGI';
comment on column MB_BTS_TYPE.eqp_type
  is '�豸����';
comment on column MB_BTS_TYPE.drx_type
  is '��Ƶ����';

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
  is 'ͳ���������õģ����ݱ�������ʹ��-�����';
comment on column MB_DATA_REPORT_INFO.record_time
  is '����';
comment on column MB_DATA_REPORT_INFO.type
  is '�������ͣ��������Ρ��滮���Ρ�·�⡢��ͳ��mro�����';
comment on column MB_DATA_REPORT_INFO.province
  is 'ʡ��';
comment on column MB_DATA_REPORT_INFO.city
  is '����';
comment on column MB_DATA_REPORT_INFO.original_record_num
  is 'ԭʼ������Ŀ
';
comment on column MB_DATA_REPORT_INFO.clean_data_num
  is '��ϴ��������Ŀ
';
comment on column MB_DATA_REPORT_INFO.legal_data_num
  is '��ϴ�����Ч��Ŀ';
comment on column MB_DATA_REPORT_INFO.original_file_num
  is 'ԭʼ�����ļ���
';
comment on column MB_DATA_REPORT_INFO.original_file_size
  is '���մ����洢��������С
';
comment on column MB_DATA_REPORT_INFO.data_origin
  is '������Դ
�ļ���';

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
  is '·���';
comment on column MB_DT_RECORD.device
  is '�����豸ID';
comment on column MB_DT_RECORD.record_time
  is '��¼ʱ��';
comment on column MB_DT_RECORD.lon
  is '����';
comment on column MB_DT_RECORD.lat
  is 'γ��';
comment on column MB_DT_RECORD.scell_pci
  is '������С��PCI';
comment on column MB_DT_RECORD.scell_cellid
  is '������С��CI';
comment on column MB_DT_RECORD.scell_enodebid
  is '������С��ENodeBID';
comment on column MB_DT_RECORD.crs_rsrp
  is '������С��RSRP';
comment on column MB_DT_RECORD.crs_sinr
  is '������С��SINR';
comment on column MB_DT_RECORD.ncell1_pci
  is '����1PCI';
comment on column MB_DT_RECORD.ncell1_cellid
  is '����1CI';
comment on column MB_DT_RECORD.ncell1_rsrp
  is '����1RSRP';
comment on column MB_DT_RECORD.ncell2_pci
  is '����2PCI';
comment on column MB_DT_RECORD.ncell2_cellid
  is '����2CI';
comment on column MB_DT_RECORD.ncell2_rsrp
  is '����2RSRP';
comment on column MB_DT_RECORD.ncell3_pci
  is '����3PCI';
comment on column MB_DT_RECORD.ncell3_cellid
  is '����3CI';
comment on column MB_DT_RECORD.ncell3_rsrp
  is '����3RSRP';
comment on column MB_DT_RECORD.ncell4_pci
  is '����4PCI';
comment on column MB_DT_RECORD.ncell4_cellid
  is '����4CI';
comment on column MB_DT_RECORD.ncell4_rsrp
  is '����4RSRP';
comment on column MB_DT_RECORD.ncell5_pci
  is '����5PCI';
comment on column MB_DT_RECORD.ncell5_cellid
  is '����5CI';
comment on column MB_DT_RECORD.ncell5_rsrp
  is '����5RSRP';
comment on column MB_DT_RECORD.ncell6_pci
  is '����6PCI';
comment on column MB_DT_RECORD.ncell6_cellid
  is '����6CI';
comment on column MB_DT_RECORD.ncell6_rsrp
  is '����6RSRP';
comment on column MB_DT_RECORD.ncell7_pci
  is '����7PCI';
comment on column MB_DT_RECORD.ncell7_cellid
  is '����7CI';
comment on column MB_DT_RECORD.ncell7_rsrp
  is '����7RSRP';
comment on column MB_DT_RECORD.ncell8_pci
  is '����8PCI';
comment on column MB_DT_RECORD.ncell8_cellid
  is '����8CI';
comment on column MB_DT_RECORD.ncell8_rsrp
  is '����8RSRP';
comment on column MB_DT_RECORD.ncell9_pci
  is '����9PCI';
comment on column MB_DT_RECORD.ncell9_cellid
  is '����9CI';
comment on column MB_DT_RECORD.ncell9_rsrp
  is '����9RSRP';
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
  is '�����ֻ�����ftp';
comment on column MB_LTE_ST_FTP_TY.record_time
  is '����';
comment on column MB_LTE_ST_FTP_TY.city
  is '����';
comment on column MB_LTE_ST_FTP_TY.network_type
  is '��������';
comment on column MB_LTE_ST_FTP_TY.business_type
  is 'ҵ������';
comment on column MB_LTE_ST_FTP_TY.avg_rate_ftp
  is 'FTPƽ�����ݴ�������(kb/s)';
comment on column MB_LTE_ST_FTP_TY.con_suc_rate_ftp
  is 'FTP�û����ӳɹ���';
comment on column MB_LTE_ST_FTP_TY.land_suc_rate_ftp
  is 'FTP��½�ɹ���';
comment on column MB_LTE_ST_FTP_TY.trans_suc_rate_ftp
  is 'FTP���ݴ���ɹ���';
comment on column MB_LTE_ST_FTP_TY.throughput_ftp
  is 'FTP������(KB)';
comment on column MB_LTE_ST_FTP_TY.time_amount_ftp
  is 'FTP������ʱ��(s)';
comment on column MB_LTE_ST_FTP_TY.max_rate_ftp
  is 'FTP�����������(kb/s)';
comment on column MB_LTE_ST_FTP_TY.min_rate_ftp
  is 'FTP��С��������(kb/s)';
comment on column MB_LTE_ST_FTP_TY.avg_rsrp_ftp
  is 'ƽ����ƽ(FTP)';

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
  is '�����ֻ�����ftp';
comment on column MB_LTE_ST_FTP_TY_BAK.record_time
  is '����';
comment on column MB_LTE_ST_FTP_TY_BAK.city
  is '����';
comment on column MB_LTE_ST_FTP_TY_BAK.network_type
  is '��������';
comment on column MB_LTE_ST_FTP_TY_BAK.business_type
  is 'ҵ������';
comment on column MB_LTE_ST_FTP_TY_BAK.avg_rate_ftp
  is 'FTPƽ�����ݴ�������(kb/s)';
comment on column MB_LTE_ST_FTP_TY_BAK.con_suc_rate_ftp
  is 'FTP�û����ӳɹ���';
comment on column MB_LTE_ST_FTP_TY_BAK.land_suc_rate_ftp
  is 'FTP��½�ɹ���';
comment on column MB_LTE_ST_FTP_TY_BAK.trans_suc_rate_ftp
  is 'FTP���ݴ���ɹ���';
comment on column MB_LTE_ST_FTP_TY_BAK.throughput_ftp
  is 'FTP������(KB)';
comment on column MB_LTE_ST_FTP_TY_BAK.time_amount_ftp
  is 'FTP������ʱ��(s)';
comment on column MB_LTE_ST_FTP_TY_BAK.max_rate_ftp
  is 'FTP�����������(kb/s)';
comment on column MB_LTE_ST_FTP_TY_BAK.min_rate_ftp
  is 'FTP��С��������(kb/s)';
comment on column MB_LTE_ST_FTP_TY_BAK.avg_rsrp_ftp
  is 'ƽ����ƽ��FTP��';

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
  is '�����ֻ�����http';
comment on column MB_LTE_ST_HTTP_TY.record_time
  is '����';
comment on column MB_LTE_ST_HTTP_TY.city
  is '����';
comment on column MB_LTE_ST_HTTP_TY.network_type
  is '��������';
comment on column MB_LTE_ST_HTTP_TY.business_type
  is 'ҵ������';
comment on column MB_LTE_ST_HTTP_TY.avg_rate_http
  is 'HTTPƽ�����ݴ�������(kb/s)';
comment on column MB_LTE_ST_HTTP_TY.first_req_suc_rate_http
  is 'HTTP�״�����ɹ���';
comment on column MB_LTE_ST_HTTP_TY.worst_req_duration_http
  is 'HTTP�������ʱ��(s)';
comment on column MB_LTE_ST_HTTP_TY.max_download_rate_http
  is 'HTTP�����������(kb/s)';
comment on column MB_LTE_ST_HTTP_TY.min_download_rate_http
  is 'HTTP��С��������(kb/s)';
comment on column MB_LTE_ST_HTTP_TY.avg_rsrp_http
  is 'ƽ����ƽ(HTTP)';

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
  is '�����ֻ�����http';
comment on column MB_LTE_ST_HTTP_TY_BAK.record_time
  is '����';
comment on column MB_LTE_ST_HTTP_TY_BAK.city
  is '����';
comment on column MB_LTE_ST_HTTP_TY_BAK.network_type
  is '��������';
comment on column MB_LTE_ST_HTTP_TY_BAK.business_type
  is 'ҵ������';
comment on column MB_LTE_ST_HTTP_TY_BAK.avg_rate_http
  is 'HTTPƽ�����ݴ�������(kb/s)';
comment on column MB_LTE_ST_HTTP_TY_BAK.first_req_suc_rate_http
  is 'HTTP�״�����ɹ���';
comment on column MB_LTE_ST_HTTP_TY_BAK.worst_req_duration_http
  is 'HTTP�������ʱ��(s)';
comment on column MB_LTE_ST_HTTP_TY_BAK.max_download_rate_http
  is 'HTTP�����������(kb/s)
';
comment on column MB_LTE_ST_HTTP_TY_BAK.min_download_rate_http
  is 'HTTP��С��������(kb/s)
';
comment on column MB_LTE_ST_HTTP_TY_BAK.avg_rsrp_http
  is 'ƽ����ƽ��HTTP��
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
  is '�����ֻ�����ping';
comment on column MB_LTE_ST_PING_TY.record_time
  is '����';
comment on column MB_LTE_ST_PING_TY.city
  is '����';
comment on column MB_LTE_ST_PING_TY.network_type
  is '��������';
comment on column MB_LTE_ST_PING_TY.business_type
  is 'ҵ������';
comment on column MB_LTE_ST_PING_TY.suc_rate_ping
  is 'PING�ɹ���(%)';
comment on column MB_LTE_ST_PING_TY.min_last_ping_packet
  is 'PING���ݰ�������С��ʱ(����)';
comment on column MB_LTE_ST_PING_TY.max_last_ping_packet
  is 'PING���ݰ����������ʱ(����)';
comment on column MB_LTE_ST_PING_TY.avg_last_ping_packet
  is 'PING���ݰ�����ƽ����ʱ(����)';
comment on column MB_LTE_ST_PING_TY.avg_rsrp_ping
  is 'ƽʱ��ƽ(PING)';

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
  is '�����ֻ�����ping';
comment on column MB_LTE_ST_PING_TY_BAK.record_time
  is '����';
comment on column MB_LTE_ST_PING_TY_BAK.city
  is '����
';
comment on column MB_LTE_ST_PING_TY_BAK.network_type
  is '��������
';
comment on column MB_LTE_ST_PING_TY_BAK.business_type
  is 'ҵ������
';
comment on column MB_LTE_ST_PING_TY_BAK.suc_rate_ping
  is 'PING�ɹ���(%)
';
comment on column MB_LTE_ST_PING_TY_BAK.min_last_ping_packet
  is 'PING���ݰ�������С��ʱ(����)
';
comment on column MB_LTE_ST_PING_TY_BAK.max_last_ping_packet
  is 'PING���ݰ����������ʱ(����)
';
comment on column MB_LTE_ST_PING_TY_BAK.avg_last_ping_packet
  is 'PING���ݰ�����ƽ����ʱ(����)
';
comment on column MB_LTE_ST_PING_TY_BAK.avg_rsrp_ping
  is 'ƽ����ƽ��PING��
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
  is '�����ֻ�����video';
comment on column MB_LTE_ST_VIDEO_TY.record_time
  is '����';
comment on column MB_LTE_ST_VIDEO_TY.city
  is '����';
comment on column MB_LTE_ST_VIDEO_TY.network_type
  is '��������';
comment on column MB_LTE_ST_VIDEO_TY.business_type
  is 'ҵ������';
comment on column MB_LTE_ST_VIDEO_TY.fluency_video
  is '��Ƶ������';
comment on column MB_LTE_ST_VIDEO_TY.suc_rate_video_play
  is '��Ƶ�򿪳ɹ���(%)';
comment on column MB_LTE_ST_VIDEO_TY.duration_first_cideo_video
  is '�״���Ƶ����ʱ��(s)';
comment on column MB_LTE_ST_VIDEO_TY.duration_wait
  is '�û��ȴ�ʱ��(s)';

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
  is '�����ֻ�����video';
comment on column MB_LTE_ST_VIDEO_TY_BAK.record_time
  is '����';
comment on column MB_LTE_ST_VIDEO_TY_BAK.city
  is '����';
comment on column MB_LTE_ST_VIDEO_TY_BAK.network_type
  is '��������
';
comment on column MB_LTE_ST_VIDEO_TY_BAK.business_type
  is 'ҵ������
';
comment on column MB_LTE_ST_VIDEO_TY_BAK.fluency_video
  is '��Ƶ������
';
comment on column MB_LTE_ST_VIDEO_TY_BAK.suc_rate_video_play
  is '��Ƶ�򿪳ɹ���(%)
';
comment on column MB_LTE_ST_VIDEO_TY_BAK.duration_first_cideo_video
  is '�״���Ƶ����ʱ��(s)
';
comment on column MB_LTE_ST_VIDEO_TY_BAK.duration_wait
  is '�û��ȴ�ʱ��(s)
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
  is '��������MR����';
comment on column MB_MR_RECORD.mmegroupid
  is 'MME���ʶ
';
comment on column MB_MR_RECORD.mmecode
  is 'MME��
';
comment on column MB_MR_RECORD.mmeues2apid
  is 'MME UE S1Ӧ�ó����ʶ
';
comment on column MB_MR_RECORD.cellid
  is 'С����ʶ
';
comment on column MB_MR_RECORD.test_date
  is '�������ݲ�������
';
comment on column MB_MR_RECORD.test_time
  is '�������ݲ���ʱ��
';
comment on column MB_MR_RECORD.eventtype
  is 'EventType�������ݲ����¼�����
';
comment on column MB_MR_RECORD.mrltescrsrp
  is 'TD-LTE����С���Ĳο��źŽ��չ���
';
comment on column MB_MR_RECORD.mrltencrsrp
  is 'TD-LTE�Ѷ���������ϵ��δ����������ϵС���Ĳο��źŽ��չ���
';
comment on column MB_MR_RECORD.mrltescrsrq
  is 'TD-LTE����С���Ĳο��źŽ�������
';
comment on column MB_MR_RECORD.mrltencrsrq
  is 'TD-LTE�Ѷ���������ϵ��δ����������ϵС���Ĳο��źŽ�������
';
comment on column MB_MR_RECORD.mrltescrttd
  is 'TD-LTE����С����UE�շ�ʱ���
';
comment on column MB_MR_RECORD.mrltescphr
  is 'TD-LTE����С����UE���书������
';
comment on column MB_MR_RECORD.mrltescrip
  is 'TD-LTE����С����eNB���ո��Ź���
';
comment on column MB_MR_RECORD.mrltescaoa
  is 'TD-LTE����С����eNB���ߵ����
';
comment on column MB_MR_RECORD.mrltescplrdlqcix
  is 'TD-LTE����С�������������
';
comment on column MB_MR_RECORD.freq_band
  is 'TD-LTE����С���ز���
ע��X=1��9';
comment on column MB_MR_RECORD.mrltescsinrul
  is 'TD-LTE����С��������С��ʶ����
';
comment on column MB_MR_RECORD.mrltescearfcn
  is 'TD-LTE�Ѷ���������ϵ��δ����������ϵ�������ز���
';
comment on column MB_MR_RECORD.mrltescpci
  is 'TD-LTE�Ѷ���������ϵ��δ����������ϵ������С��ʶ����
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
  is 'OMC�ṩ�ľ�γ��';
comment on column MB_OMC_LO_LA.city
  is '����';
comment on column MB_OMC_LO_LA.enodeb_id
  is 'ENODEB_ID��OMC������';
comment on column MB_OMC_LO_LA.enodeb_name
  is 'վ����OMC������';
comment on column MB_OMC_LO_LA.longitude
  is '����';
comment on column MB_OMC_LO_LA.latitude
  is 'γ��';
comment on column MB_OMC_LO_LA.record_time
  is '����';

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
  is 'GSM��ͳ����';
comment on column MB_PERF_GSM_BUSISTAT.cell_glb_id
  is 'GSMС����ȫ��ID���
';
comment on column MB_PERF_GSM_BUSISTAT.cell_id
  is 'GSMС��ID
';
comment on column MB_PERF_GSM_BUSISTAT.cell_name
  is 'С������
';
comment on column MB_PERF_GSM_BUSISTAT.cycle_date
  is 'ͳ������
';
comment on column MB_PERF_GSM_BUSISTAT.period
  is 'ͳ������
';
comment on column MB_PERF_GSM_BUSISTAT.traffic
  is 'GSM������
';
comment on column MB_PERF_GSM_BUSISTAT.gprs_throu
  is 'Gprs����
';
comment on column MB_PERF_GSM_BUSISTAT.egprs_throu
  is 'Egprs����
';
comment on column MB_PERF_GSM_BUSISTAT.oper_time
  is 'ͳ��������ʱ��
';
comment on column MB_PERF_GSM_BUSISTAT.record_time
  is '��¼ʱ��';
comment on column MB_PERF_GSM_BUSISTAT.city
  is '����';
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
  is 'LTE��ͳ����';
comment on column MB_PERF_LTE_CELLBUSISTAT.cell_glb_id
  is 'С����ȫ��ID���
';
comment on column MB_PERF_LTE_CELLBUSISTAT.cell_id
  is 'С��ID
';
comment on column MB_PERF_LTE_CELLBUSISTAT.cell_name
  is 'С������
';
comment on column MB_PERF_LTE_CELLBUSISTAT.record_time
  is '��¼ʱ��';
comment on column MB_PERF_LTE_CELLBUSISTAT.period
  is 'ͳ������
';
comment on column MB_PERF_LTE_CELLBUSISTAT.pusch_prbs_used
  is 'С����ƵPUSCHʵ��ʹ��PRB����
';
comment on column MB_PERF_LTE_CELLBUSISTAT.uplink_prbs
  is 'С�������ŵ����õ�PRB����
';
comment on column MB_PERF_LTE_CELLBUSISTAT.pdsch_prbs_used
  is 'С����ƵPDSCHʵ��ʹ��PRB����
';
comment on column MB_PERF_LTE_CELLBUSISTAT.downlink_prbs
  is 'С�������ŵ����õ�PRB����
';
comment on column MB_PERF_LTE_CELLBUSISTAT.pdcp_uplink_throu
  is 'С����ƵPDSCHʵ��ʹ��PRB����
';
comment on column MB_PERF_LTE_CELLBUSISTAT.pdcp_downlink_throu
  is 'С�������ŵ����õ�PRB����
';
comment on column MB_PERF_LTE_CELLBUSISTAT.oper_time
  is 'ͳ��������ʱ��
';
comment on column MB_PERF_LTE_CELLBUSISTAT.city
  is '����';
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
  is 'TDS��ͳ����';
comment on column MB_PERF_TDS_BUSISTAT.cell_glb_id
  is 'TDSС����ȫ��ID���
';
comment on column MB_PERF_TDS_BUSISTAT.cell_id
  is 'TDSС��ID
';
comment on column MB_PERF_TDS_BUSISTAT.cell_name
  is 'С������
';
comment on column MB_PERF_TDS_BUSISTAT.period
  is 'ͳ������
';
comment on column MB_PERF_TDS_BUSISTAT.traffic
  is 'TDS������
';
comment on column MB_PERF_TDS_BUSISTAT.hs_throu
  is 'HS����
';
comment on column MB_PERF_TDS_BUSISTAT.r9_throu
  is 'R9����
';
comment on column MB_PERF_TDS_BUSISTAT.oper_time
  is 'ͳ��������ʱ��
';
comment on column MB_PERF_TDS_BUSISTAT.record_time
  is '��¼����';
comment on column MB_PERF_TDS_BUSISTAT.city
  is '����';
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
  is '7������ͳ��-�洢����  by huangc';
comment on column MB_PLAN_7DAYS_ONLINE.record_time
  is '����';
comment on column MB_PLAN_7DAYS_ONLINE.city
  is '����';
comment on column MB_PLAN_7DAYS_ONLINE.project_period
  is '���ں�';
comment on column MB_PLAN_7DAYS_ONLINE.enodeb_glb_id
  is '��վȫ��ID';
comment on column MB_PLAN_7DAYS_ONLINE.online_mark7days
  is '�Ƿ�����7������';
comment on column MB_PLAN_7DAYS_ONLINE.penodebid
  is '��վID';

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
  is 'LTE�滮С������';
comment on column MB_PLAN_LTECELL_INFO.record_time
  is 'ʱ��';
comment on column MB_PLAN_LTECELL_INFO.cell_id
  is '�滮С����Ψһ��ʶ';
comment on column MB_PLAN_LTECELL_INFO.city
  is '����';
comment on column MB_PLAN_LTECELL_INFO.contry
  is '����';
comment on column MB_PLAN_LTECELL_INFO.min_distance
  is '��Сվ���';
comment on column MB_PLAN_LTECELL_INFO.projectphase
  is '�����ڱ�';
comment on column MB_PLAN_LTECELL_INFO.cover_type
  is '��������';
comment on column MB_PLAN_LTECELL_INFO.high
  is '���߹Ҹ�';
comment on column MB_PLAN_LTECELL_INFO.longitude
  is '����';
comment on column MB_PLAN_LTECELL_INFO.latitude
  is 'γ��';
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
  is 'LTE�滮��վ����';
comment on column MB_PLAN_LTESITE_INFO.record_time
  is 'ʱ��
';
comment on column MB_PLAN_LTESITE_INFO.penodebclass
  is '�滮���(*����)
';
comment on column MB_PLAN_LTESITE_INFO.penodebname
  is '�滮վ��(*����)
';
comment on column MB_PLAN_LTESITE_INFO.province_name
  is 'ʡ��
';
comment on column MB_PLAN_LTESITE_INFO.city_name
  is '����(*����)
';
comment on column MB_PLAN_LTESITE_INFO.longitude
  is '�滮����
';
comment on column MB_PLAN_LTESITE_INFO.latitude
  is '�滮γ��
';
comment on column MB_PLAN_LTESITE_INFO.country_name
  is '����
';
comment on column MB_PLAN_LTESITE_INFO.regiontype
  is '��������
';
comment on column MB_PLAN_LTESITE_INFO.projectphase
  is '�����ڱ�
';
comment on column MB_PLAN_LTESITE_INFO.penodebid
  is '�滮��վ��ʶ
';
comment on column MB_PLAN_LTESITE_INFO.isopen
  is '�Ƿ�ͨ
';
comment on column MB_PLAN_LTESITE_INFO.coveragecharacter
  is '��վ���(��վ���ҷ�)
';
comment on column MB_PLAN_LTESITE_INFO.work_frqband
  is 'ʹ��Ƶ��
';
comment on column MB_PLAN_LTESITE_INFO.ischeck
  is '�Ƿ�鿱
';
comment on column MB_PLAN_LTESITE_INFO.isnodebname
  is '�鿱վ��
';
comment on column MB_PLAN_LTESITE_INFO.ischecklon
  is '�鿱����
';
comment on column MB_PLAN_LTESITE_INFO.ischecklat
  is '�鿱γ��
';
comment on column MB_PLAN_LTESITE_INFO.azimuthcell1
  is '�ֳ��鿱�����CELL1
';
comment on column MB_PLAN_LTESITE_INFO.azimuthcell2
  is '�ֳ��鿱�����CELL2
';
comment on column MB_PLAN_LTESITE_INFO.azimuthcell3
  is '�ֳ��鿱�����CELL3
';
comment on column MB_PLAN_LTESITE_INFO.heightcell1
  is '�ֲ鿱�Ҹ�CELL1
';
comment on column MB_PLAN_LTESITE_INFO.heightcell2
  is '�ֲ鿱�Ҹ�CELL2
';
comment on column MB_PLAN_LTESITE_INFO.heightcell3
  is '�ֲ鿱�Ҹ�CELL3
';
comment on column MB_PLAN_LTESITE_INFO.downtiltcell1
  is '�ֳ��鿱�������CELL1
';
comment on column MB_PLAN_LTESITE_INFO.downtiltcell2
  is '�ֳ��鿱�������CELL2
';
comment on column MB_PLAN_LTESITE_INFO.downtiltcell3
  is '�ֳ��鿱�������CELL3
';
comment on column MB_PLAN_LTESITE_INFO.electricaldowntiltcell1
  is '�ֳ��鿱�������CELL1
';
comment on column MB_PLAN_LTESITE_INFO.electricaldowntiltcell2
  is '�ֳ��鿱�������CELL2
';
comment on column MB_PLAN_LTESITE_INFO.electricaldowntiltcell3
  is '�ֳ��鿱�������CELL3
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
  is '2G��վ����λ����Ϣ��';
comment on column MB_SYS_GIS_GSMPERMISSION.province
  is 'ʡ��
';
comment on column MB_SYS_GIS_GSMPERMISSION.city
  is '����
';
comment on column MB_SYS_GIS_GSMPERMISSION.county
  is '����
';
comment on column MB_SYS_GIS_GSMPERMISSION.bsc_name
  is 'bscname
';
comment on column MB_SYS_GIS_GSMPERMISSION.site_name
  is '��վ����
';
comment on column MB_SYS_GIS_GSMPERMISSION.netgrid
  is '����
';
comment on column MB_SYS_GIS_GSMPERMISSION.environ
  is '����
';
comment on column MB_SYS_GIS_GSMPERMISSION.vendor
  is '����
';
comment on column MB_SYS_GIS_GSMPERMISSION.record_time
  is '��¼ʱ��
';
comment on column MB_SYS_GIS_GSMPERMISSION.update_time
  is '����ʱ��
';
comment on column MB_SYS_GIS_GSMPERMISSION.update_user
  is '������
';
comment on column MB_SYS_GIS_GSMPERMISSION.site_glb_id
  is '��վ��ȫ��ID���
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
  is '4G��վ����λ����Ϣ��';
comment on column MB_SYS_GIS_PERMISSION.province
  is 'ʡ��';
comment on column MB_SYS_GIS_PERMISSION.city
  is '����';
comment on column MB_SYS_GIS_PERMISSION.county
  is '����';
comment on column MB_SYS_GIS_PERMISSION.enodeb_glb_id
  is '��վȫ�ֱ�ʶ';
comment on column MB_SYS_GIS_PERMISSION.enodeb_id
  is '��վ��ʶ';
comment on column MB_SYS_GIS_PERMISSION.enodeb_name
  is '��վ����';
comment on column MB_SYS_GIS_PERMISSION.netgrid
  is '����';
comment on column MB_SYS_GIS_PERMISSION.environ
  is '����';
comment on column MB_SYS_GIS_PERMISSION.vendor
  is '����';
comment on column MB_SYS_GIS_PERMISSION.record_time
  is '��¼����';
comment on column MB_SYS_GIS_PERMISSION.update_time
  is '����ʱ��';
comment on column MB_SYS_GIS_PERMISSION.update_user
  is '������';
comment on column MB_SYS_GIS_PERMISSION.address
  is '��ַ';
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
  is '3G��վ����λ����Ϣ��';
comment on column MB_SYS_GIS_TDSPERMISSION.province
  is 'ʡ��
';
comment on column MB_SYS_GIS_TDSPERMISSION.city
  is '����
';
comment on column MB_SYS_GIS_TDSPERMISSION.county
  is '����
';
comment on column MB_SYS_GIS_TDSPERMISSION.rncid
  is 'RNC��ʶ
';
comment on column MB_SYS_GIS_TDSPERMISSION.site_oid
  is '��վ��ʶ
';
comment on column MB_SYS_GIS_TDSPERMISSION.site_name
  is '��վ����
';
comment on column MB_SYS_GIS_TDSPERMISSION.netgrid
  is '����
';
comment on column MB_SYS_GIS_TDSPERMISSION.environ
  is '����
';
comment on column MB_SYS_GIS_TDSPERMISSION.vendor
  is '����
';
comment on column MB_SYS_GIS_TDSPERMISSION.record_time
  is '��¼ʱ��
';
comment on column MB_SYS_GIS_TDSPERMISSION.update_time
  is '����ʱ��
';
comment on column MB_SYS_GIS_TDSPERMISSION.update_user
  is '������
';
comment on column MB_SYS_GIS_TDSPERMISSION.site_glb_id
  is '��վ��ȫ��ID���
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
  is '2GС����Ϣ��';
comment on column MB_SYS_GSMCELL_INFO.cell_id
  is 'С��ID
';
comment on column MB_SYS_GSMCELL_INFO.cell_name
  is 'С������
';
comment on column MB_SYS_GSMCELL_INFO.cell_english_name
  is 'С��Ӣ������
';
comment on column MB_SYS_GSMCELL_INFO.site_id
  is '��վ��ʶ
';
comment on column MB_SYS_GSMCELL_INFO.cgi
  is 'ȫ��С��ID
';
comment on column MB_SYS_GSMCELL_INFO.rru_remote
  is '�Ƿ���ԶС��
';
comment on column MB_SYS_GSMCELL_INFO.cell_longitude
  is 'С������
';
comment on column MB_SYS_GSMCELL_INFO.cell_latitude
  is 'С��γ��
';
comment on column MB_SYS_GSMCELL_INFO.sector_id
  is '����С����ʶ
';
comment on column MB_SYS_GSMCELL_INFO.powerdivisiontype
  is '��������
';
comment on column MB_SYS_GSMCELL_INFO.powerdivisionindex
  is '��������
';
comment on column MB_SYS_GSMCELL_INFO.ncc
  is '����ɫ��
';
comment on column MB_SYS_GSMCELL_INFO.bcc
  is '��վɫ��
';
comment on column MB_SYS_GSMCELL_INFO.bcch
  is '��BCCHƵ��
';
comment on column MB_SYS_GSMCELL_INFO.covertype
  is '��������
';
comment on column MB_SYS_GSMCELL_INFO.bandindicatorforfrequency
  is 'Ƶ��ָʾ
';
comment on column MB_SYS_GSMCELL_INFO.rac
  is 'С��·��������
';
comment on column MB_SYS_GSMCELL_INFO.record_time
  is '¼��ʱ��
';
comment on column MB_SYS_GSMCELL_INFO.uptime_time
  is '����ʱ��
';
comment on column MB_SYS_GSMCELL_INFO.update_user
  is '������
';
comment on column MB_SYS_GSMCELL_INFO.cell_glb_id
  is 'С����ȫ��ID���
';
comment on column MB_SYS_GSMCELL_INFO.site_glb_id
  is '��վ��ȫ��ID���
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
  is '2GС��RF��';
comment on column MB_SYS_GSMCELL_RF.cell_id
  is 'С��ID
';
comment on column MB_SYS_GSMCELL_RF.cell_name
  is 'С��������
';
comment on column MB_SYS_GSMCELL_RF.azimuth
  is '���߷����
';
comment on column MB_SYS_GSMCELL_RF.height
  is '���߹Ҹ�
';
comment on column MB_SYS_GSMCELL_RF.mtilt
  is '���߻�е�����
';
comment on column MB_SYS_GSMCELL_RF.etilt
  is '���ߵ��������
';
comment on column MB_SYS_GSMCELL_RF.antenna
  is '�����ͺ�
';
comment on column MB_SYS_GSMCELL_RF.fake_antenna
  is '�Ƿ�����
';
comment on column MB_SYS_GSMCELL_RF.update_time
  is '����ʱ��
';
comment on column MB_SYS_GSMCELL_RF.record_time
  is '��¼ʱ��
';
comment on column MB_SYS_GSMCELL_RF.update_user
  is '������
';
comment on column MB_SYS_GSMCELL_RF.cell_glb_id
  is 'С����ȫ��ID���
';
comment on column MB_SYS_GSMCELL_RF.site_glb_id
  is '��վ��ȫ��ID���
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
  is '2G��վ��Ϣ��';
comment on column MB_SYS_GSMSITE_INFO.bsc_id
  is 'BSC_name
';
comment on column MB_SYS_GSMSITE_INFO.site_id
  is '��վ��ʶ
';
comment on column MB_SYS_GSMSITE_INFO.site_name
  is '��վ����
';
comment on column MB_SYS_GSMSITE_INFO.lac
  is '����������
';
comment on column MB_SYS_GSMSITE_INFO.vendor
  is '�豸����
';
comment on column MB_SYS_GSMSITE_INFO.longitude
  is '����
';
comment on column MB_SYS_GSMSITE_INFO.latitude
  is 'γ��
';
comment on column MB_SYS_GSMSITE_INFO.netgrid
  is '�����
';
comment on column MB_SYS_GSMSITE_INFO.environ
  is '����
';
comment on column MB_SYS_GSMSITE_INFO.freq_band
  is 'Ƶ��
';
comment on column MB_SYS_GSMSITE_INFO.cover_type
  is '��������
';
comment on column MB_SYS_GSMSITE_INFO.record_time
  is '¼��ʱ��
';
comment on column MB_SYS_GSMSITE_INFO.update_time
  is '��������ʱ��
';
comment on column MB_SYS_GSMSITE_INFO.update_user
  is '������
';
comment on column MB_SYS_GSMSITE_INFO.site_glb_id
  is '��վ��ȫ��ID���
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
  is 'ȫ�������ʶ';
comment on column MB_SYS_LTECELL_GSMNBR.name
  is '�û��Ѻ���
';
comment on column MB_SYS_LTECELL_GSMNBR.object_rdn
  is '��Դ����Ψһ��ʶ
';
comment on column MB_SYS_LTECELL_GSMNBR.zh_name
  is '��������
';
comment on column MB_SYS_LTECELL_GSMNBR.omc_id
  is 'OMC_ID
';
comment on column MB_SYS_LTECELL_GSMNBR.city
  is '����
';
comment on column MB_SYS_LTECELL_GSMNBR.vendor_id
  is '�豸����ID
';
comment on column MB_SYS_LTECELL_GSMNBR.time_stamp
  is '���ݲɼ�ʱ���
';
comment on column MB_SYS_LTECELL_GSMNBR.update_stamp
  is '���ݸ���ʱ���
';
comment on column MB_SYS_LTECELL_GSMNBR.confirmed
  is 'ɾ�������ӵ�ȷ��
';
comment on column MB_SYS_LTECELL_GSMNBR.tac
  is 'ԴС����������ʶ
';
comment on column MB_SYS_LTECELL_GSMNBR.pci
  is 'ԴС������С����ʶ
';
comment on column MB_SYS_LTECELL_GSMNBR.earfcn
  is 'ԴС��������Ƶ���ŵ���
';
comment on column MB_SYS_LTECELL_GSMNBR.adj_gsm_frqlst
  is '����Ƶ���б�';
comment on column MB_SYS_LTECELL_GSMNBR.m_name
  is '��С������
';
comment on column MB_SYS_LTECELL_GSMNBR.n_name
  is '��С������
';
comment on column MB_SYS_LTECELL_GSMNBR.id
  is '��ʶ��
';
comment on column MB_SYS_LTECELL_GSMNBR.adjacentcellid
  is '����С���ı�ʶ
';
comment on column MB_SYS_LTECELL_GSMNBR.bcch
  is 'Bcch�ŵ���Ƶ
';
comment on column MB_SYS_LTECELL_GSMNBR.ncc
  is '����ɫ��
';
comment on column MB_SYS_LTECELL_GSMNBR.bcc
  is '��վɫ��
';
comment on column MB_SYS_LTECELL_GSMNBR.rac
  is '·��������
';
comment on column MB_SYS_LTECELL_GSMNBR.update_user
  is '������';
comment on column MB_SYS_LTECELL_GSMNBR.distance
  is '����';
comment on column MB_SYS_LTECELL_GSMNBR.record_time
  is '��¼����';

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
  is '4GС����Ϣ��';
comment on column MB_SYS_LTECELL_INFO.cell_glb_id
  is 'С����ȫ��ID���
';
comment on column MB_SYS_LTECELL_INFO.enodeb_glb_id
  is '��վ��ȫ��ID���
';
comment on column MB_SYS_LTECELL_INFO.cell_id
  is 'С��ID
';
comment on column MB_SYS_LTECELL_INFO.cell_name
  is 'С������
';
comment on column MB_SYS_LTECELL_INFO.cell_english_name
  is 'С��Ӣ������
';
comment on column MB_SYS_LTECELL_INFO.cgi
  is 'ȫ��С��ID
';
comment on column MB_SYS_LTECELL_INFO.sector_id
  is '����С����ʶ
';
comment on column MB_SYS_LTECELL_INFO.pci
  is '����С����ʶ��PCI)
';
comment on column MB_SYS_LTECELL_INFO.earfcn
  is '����Ƶ��
';
comment on column MB_SYS_LTECELL_INFO.rf_power
  is '�ο��źŹ���
';
comment on column MB_SYS_LTECELL_INFO.sfassign
  is '��������֡���
';
comment on column MB_SYS_LTECELL_INFO.sepcsfpattern
  is '������֡���
';
comment on column MB_SYS_LTECELL_INFO.record_time
  is '��¼ʱ��
';
comment on column MB_SYS_LTECELL_INFO.update_time
  is '����ʱ��
';
comment on column MB_SYS_LTECELL_INFO.update_user
  is '������
';
comment on column MB_SYS_LTECELL_INFO.min_distance
  is '��Сվ���';
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
  is '4GС����Ϣ��ʱ����ɾ��---by huangc';
comment on column MB_SYS_LTECELL_INFO_T.int_id
  is 'Ψһ��ʶ
';
comment on column MB_SYS_LTECELL_INFO_T.object_rdn
  is 'С��DN��
';
comment on column MB_SYS_LTECELL_INFO_T.name
  is 'С��Ӣ����
';
comment on column MB_SYS_LTECELL_INFO_T.zh_name
  is 'С��������
';
comment on column MB_SYS_LTECELL_INFO_T.omc_id
  is 'OMCID��
';
comment on column MB_SYS_LTECELL_INFO_T.vendor_id
  is '��������
';
comment on column MB_SYS_LTECELL_INFO_T.city_id
  is '��������
';
comment on column MB_SYS_LTECELL_INFO_T.time_stamp
  is '����ʱ��
';
comment on column MB_SYS_LTECELL_INFO_T.update_stamp
  is '����ʱ��
';
comment on column MB_SYS_LTECELL_INFO_T.confirmed
  is '��Ԫ״̬
';
comment on column MB_SYS_LTECELL_INFO_T.state
  is '�豸ά��״̬
';
comment on column MB_SYS_LTECELL_INFO_T.related_enodeb
  is '������վINT_id��
';
comment on column MB_SYS_LTECELL_INFO_T.cgi
  is 'ȫ��С��ʶ����
';
comment on column MB_SYS_LTECELL_INFO_T.eutrancell_id
  is 'Eutrancell��ʶ��
';
comment on column MB_SYS_LTECELL_INFO_T.cell_identity
  is 'С����ʶ
';
comment on column MB_SYS_LTECELL_INFO_T.cell_type
  is 'С������
';
comment on column MB_SYS_LTECELL_INFO_T.cellsize
  is 'С�����Ƿ�Χ
';
comment on column MB_SYS_LTECELL_INFO_T.plmnidlist
  is 'PLMN��ʶ���б�
';
comment on column MB_SYS_LTECELL_INFO_T.tac
  is '��������
';
comment on column MB_SYS_LTECELL_INFO_T.pci
  is '����С��ʶ����
';
comment on column MB_SYS_LTECELL_INFO_T.pcilist
  is '����С��ʶ�����б�
';
comment on column MB_SYS_LTECELL_INFO_T.maximumtransmissionpower
  is '����书��
';
comment on column MB_SYS_LTECELL_INFO_T.referencesignalpower
  is '�ο��źŹ���
';
comment on column MB_SYS_LTECELL_INFO_T.pb
  is '���߶˿��źŹ��ʱ�(PDSCH/RS�Ĺ��ʱ�ֵ����)
';
comment on column MB_SYS_LTECELL_INFO_T.part_of_sectorpower
  is '���ߵ紫�͹����б�����ı���
';
comment on column MB_SYS_LTECELL_INFO_T.administrativestate
  is '����״̬
';
comment on column MB_SYS_LTECELL_INFO_T.operationalstate
  is '����״̬
';
comment on column MB_SYS_LTECELL_INFO_T.celllocalid
  is '����С����ʶ
';
comment on column MB_SYS_LTECELL_INFO_T.relatedrrulist
  is '������RRU�б�
';
comment on column MB_SYS_LTECELL_INFO_T.relatedantennalist
  is '������������б�
';
comment on column MB_SYS_LTECELL_INFO_T.bandindicator
  is 'Ƶ��ָʾ
';
comment on column MB_SYS_LTECELL_INFO_T.earfcn
  is '������Ƶ���ŵ���
';
comment on column MB_SYS_LTECELL_INFO_T.bandwidth
  is 'С������
';
comment on column MB_SYS_LTECELL_INFO_T.sfassignment
  is '��������֡����
';
comment on column MB_SYS_LTECELL_INFO_T.specialsfpatterns
  is '������֡ģʽ
';
comment on column MB_SYS_LTECELL_INFO_T.mbmsswitch
  is 'С��MBMS����
';
comment on column MB_SYS_LTECELL_INFO_T.adj_td_num
  is 'LTEС����TD��������
';
comment on column MB_SYS_LTECELL_INFO_T.adj_lte_num
  is 'LTEС����LTE��������
';
comment on column MB_SYS_LTECELL_INFO_T.adj_gsm_num
  is 'LTEС����GSM��������
';
comment on column MB_SYS_LTECELL_INFO_T.u_sf_num
  is '������֡��
';
comment on column MB_SYS_LTECELL_INFO_T.d_sf_num
  is '������֡��
';
comment on column MB_SYS_LTECELL_INFO_T.totalprb
  is 'С��PRB��
';
comment on column MB_SYS_LTECELL_INFO_T.ecarrier_num
  is '��Ƶ����
';
comment on column MB_SYS_LTECELL_INFO_T.adj_lte_frqlst
  is 'EUTRANCELL������Ƶ���б�
';
comment on column MB_SYS_LTECELL_INFO_T.adj_td_frqlst
  is '����Ƶ���б�
';
comment on column MB_SYS_LTECELL_INFO_T.adj_gsm_frqlst
  is 'GSM����Ƶ���б�
';
comment on column MB_SYS_LTECELL_INFO_T.cell_glb_id
  is 'CGI_MD5';
comment on column MB_SYS_LTECELL_INFO_T.record_time
  is '��¼ʱ��';
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
  is 'LTE��LTEС����';
comment on column MB_SYS_LTECELL_LTENBR.cgi
  is 'ȫ�������ʶ
';
comment on column MB_SYS_LTECELL_LTENBR.name
  is '�û��Ѻ���
';
comment on column MB_SYS_LTECELL_LTENBR.object_rdn
  is '��Դ����Ψһ��ʶ
';
comment on column MB_SYS_LTECELL_LTENBR.zh_name
  is '��������
';
comment on column MB_SYS_LTECELL_LTENBR.omc_id
  is 'OMC_ID
';
comment on column MB_SYS_LTECELL_LTENBR.city
  is '����
';
comment on column MB_SYS_LTECELL_LTENBR.vendor_id
  is '�豸����';
comment on column MB_SYS_LTECELL_LTENBR.time_stamp
  is '���ݲɼ�ʱ���
';
comment on column MB_SYS_LTECELL_LTENBR.update_stamp
  is '���ݸ���ʱ���
';
comment on column MB_SYS_LTECELL_LTENBR.confirmed
  is 'ɾ�������ӵ�ȷ��
';
comment on column MB_SYS_LTECELL_LTENBR.tac
  is 'ԴС����������ʶ
';
comment on column MB_SYS_LTECELL_LTENBR.pci
  is 'ԴС������С����ʶ
';
comment on column MB_SYS_LTECELL_LTENBR.earfcn
  is 'ԴС��������Ƶ���ŵ���
';
comment on column MB_SYS_LTECELL_LTENBR.m_name
  is '��С������
';
comment on column MB_SYS_LTECELL_LTENBR.n_name
  is '��С������
';
comment on column MB_SYS_LTECELL_LTENBR.id
  is '��ʶ��
';
comment on column MB_SYS_LTECELL_LTENBR.tci
  is 'Ŀ��С����ʶ';
comment on column MB_SYS_LTECELL_LTENBR.ttac
  is 'Ŀ��С����������ʶ';
comment on column MB_SYS_LTECELL_LTENBR.tpci
  is 'Ŀ��С������С����ʶ';
comment on column MB_SYS_LTECELL_LTENBR.isremoveallowed
  is '�Ƿ�����ɾ��';
comment on column MB_SYS_LTECELL_LTENBR.ishoallowed
  is '�Ƿ������л���';
comment on column MB_SYS_LTECELL_LTENBR.isicicinformationsendallowed
  is '�Ƿ�������ICIC������Ϣ';
comment on column MB_SYS_LTECELL_LTENBR.islballowed
  is '���ؾ��⿪��';
comment on column MB_SYS_LTECELL_LTENBR.plmnidlist
  is 'PLMN��ʶ�б�';
comment on column MB_SYS_LTECELL_LTENBR.tearfcn
  is 'Ŀ��������Ƶ���ŵ���';
comment on column MB_SYS_LTECELL_LTENBR.cellindividualoffset
  is 'С������ƫ����';
comment on column MB_SYS_LTECELL_LTENBR.qoffsetcell
  is 'С��ƫ��';
comment on column MB_SYS_LTECELL_LTENBR.update_user
  is '������';
comment on column MB_SYS_LTECELL_LTENBR.record_time
  is '��¼����';

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
  is '4G��վ������';
comment on column MB_SYS_LTECELL_PARAM.cell_glb_id
  is 'С����ȫ��ID���
';
comment on column MB_SYS_LTECELL_PARAM.cell_id
  is 'С��ID
';
comment on column MB_SYS_LTECELL_PARAM.cell_name
  is 'С������
';
comment on column MB_SYS_LTECELL_PARAM.operastate
  is '״̬
';
comment on column MB_SYS_LTECELL_PARAM.csfb
  is 'CSFB����
';
comment on column MB_SYS_LTECELL_PARAM.drx
  is 'DRX����
';
comment on column MB_SYS_LTECELL_PARAM.qci6_dur_len
  is 'DRX�����ڵĳ���(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_dur_len
  is 'DRX�����ڵĳ���(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_dur_len
  is 'DRX�����ڵĳ���(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_dur_len
  is 'DRX�����ڵĳ���(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.qci6_cont_timer
  is 'DRX����ʱ�䶨ʱ��(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_cont_timer
  is 'DRX����ʱ�䶨ʱ��(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_cont_timer
  is 'DRX����ʱ�䶨ʱ��(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_cont_timer
  is 'DRX����ʱ�䶨ʱ��(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.qci6_notrig_timer
  is 'DRX�Ǽ��ʱ��(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_notrig_timer
  is 'DRX�Ǽ��ʱ��(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_notrig_timer
  is 'DRX�Ǽ��ʱ��(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_notrig_timer
  is 'DRX�Ǽ��ʱ��(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.qci6_waitresend_timer
  is 'DRX�ȴ��ش����ݵĶ�ʱ��(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_waitresend_timer
  is 'DRX�ȴ��ش����ݵĶ�ʱ��(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_waitresend_timer
  is 'DRX�ȴ��ش����ݵĶ�ʱ��(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_waitresend_timer
  is 'DRX�ȴ��ش����ݵĶ�ʱ��(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.qci6_shortdur_len
  is 'DRX�����ڵĳ���(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_shortdur_len
  is 'DRX�����ڵĳ���(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_shortdur_len
  is 'DRX�����ڵĳ���(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_shortdur_len
  is 'DRX�����ڵĳ���(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.qci6_shortdur_timer
  is 'DRX�����ڶ�ʱ��(QCI6)
';
comment on column MB_SYS_LTECELL_PARAM.qci7_shortdur_timer
  is 'DRX�����ڶ�ʱ��(QCI7)
';
comment on column MB_SYS_LTECELL_PARAM.qci8_shortdur_timer
  is 'DRX�����ڶ�ʱ��(QCI8)
';
comment on column MB_SYS_LTECELL_PARAM.qci9_shortdur_timer
  is 'DRX�����ڶ�ʱ��(QCI9)
';
comment on column MB_SYS_LTECELL_PARAM.rrc_noact_timer
  is 'RRC���Ӳ����ʱ��(���ű�׼:10s)
';
comment on column MB_SYS_LTECELL_PARAM.def_paging_dur
  is 'Ĭ��Ѱ������(���ű�׼:rf128)
';
comment on column MB_SYS_LTECELL_PARAM.rf_sig_power
  is '�ο��źŹ���(���ű�׼:15)
';
comment on column MB_SYS_LTECELL_PARAM.pdsch_rs_ratio
  is '���߶˿��źŹ��ʱ�(PDSCH/RS�Ĺ��ʱ�ֵ����,���ű�׼:1)
';
comment on column MB_SYS_LTECELL_PARAM.pa
  is 'Pa(���ű�׼:-3)
';
comment on column MB_SYS_LTECELL_PARAM.init_recv_power
  is '��ʼ����Ŀ�깦��(���ű�׼:-100dBm~-104dBm)
';
comment on column MB_SYS_LTECELL_PARAM.preamble_max_count
  is 'ǰ������������(���ű�׼:n8��n10)
';
comment on column MB_SYS_LTECELL_PARAM.power_inc_step
  is '�������²���(���ű�׼:dB2��dB4)
';
comment on column MB_SYS_LTECELL_PARAM.acc_ue_max_power
  is 'С��ѡ��UE�����(���ű�׼:23dBm)
';
comment on column MB_SYS_LTECELL_PARAM.up_pucch_power_ctrl
  is '����PUCCH�ջ����ؿ���(���ű�׼:����)
';
comment on column MB_SYS_LTECELL_PARAM.pucch_optimal_power
  is 'PUCCH��������(���ű�׼:-100dBm~ -105dBm)
';
comment on column MB_SYS_LTECELL_PARAM.up_pusch_power_ctrl
  is '����PUSCH�ջ����ؿ���(���ű�׼:����)
';
comment on column MB_SYS_LTECELL_PARAM.pathloss_comp_param
  is '����·�𲹳�ϵ��(���ű�׼:0.8)
';
comment on column MB_SYS_LTECELL_PARAM.instant_optimal_power
  is '�ǳ���������������(���ű�׼:-87)
';
comment on column MB_SYS_LTECELL_PARAM.acc_min_level
  is 'С��ѡ����С�����ƽ(���ű�׼:����-120dBm��-124dBm���ҷ�-120dBm��-128dBm)
';
comment on column MB_SYS_LTECELL_PARAM.cofreq_meas_start_th
  is 'ͬƵ������������(���ű�׼:-82dBm)
';
comment on column MB_SYS_LTECELL_PARAM.q_offsetcell
  is 'q-OffsetCell(���ű�׼:q-OffsetCell+q-Hyst��2~4dB)
';
comment on column MB_SYS_LTECELL_PARAM.q_hyst
  is 'q-Hyst(���ű�׼:q-OffsetCell+q-Hyst��2~4dB)
';
comment on column MB_SYS_LTECELL_PARAM.a3_offset_hyst
  is 'ͬƵ A3 offset + Hysteresis(���ű�׼:2~4dB)
';
comment on column MB_SYS_LTECELL_PARAM.a3_hyst
  is 'ͬƵ A3 Hysteresis(���ű�׼:ͬƵ A3 offset+Hysteresis��2~4dB)
';
comment on column MB_SYS_LTECELL_PARAM.a3_time_trig
  is 'ͬƵ A3 Time-to-trigger(���ű�׼:320ms)
';
comment on column MB_SYS_LTECELL_PARAM.if_a2_th
  is '��ƵA2����(Ŀǰ�޹淶)
';
comment on column MB_SYS_LTECELL_PARAM.irat_a2_tds_th
  is '��ϵͳA2����(3G)(Ŀǰ�޹淶)
';
comment on column MB_SYS_LTECELL_PARAM.irat_a2_gsm_th
  is '��ϵͳA2����(2G)(Ŀǰ�޹淶)
';
comment on column MB_SYS_LTECELL_PARAM.irat_a2_errdef_th
  is '��ϵͳA2����(ä�ض���)(���ű�׼:-118dBm��-126dBm)
';
comment on column MB_SYS_LTECELL_PARAM.update_time
  is '����ʱ��
';
comment on column MB_SYS_LTECELL_PARAM.update_user
  is '������';
comment on column MB_SYS_LTECELL_PARAM.enodeb_name
  is '������վ����
';
comment on column MB_SYS_LTECELL_PARAM.enodeb_id
  is '������վID
';
comment on column MB_SYS_LTECELL_PARAM.enodeb_glb_id
  is '��վ��ȫ��ID���';
comment on column MB_SYS_LTECELL_PARAM.record_time
  is '��¼����';

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
  is '4GС��RF��';
comment on column MB_SYS_LTECELL_RF.cell_glb_id
  is 'С����ȫ��ID���
';
comment on column MB_SYS_LTECELL_RF.azimuth
  is '��λ��
';
comment on column MB_SYS_LTECELL_RF.downtilt
  is '�������
';
comment on column MB_SYS_LTECELL_RF.m_downtilt
  is '��е�����
';
comment on column MB_SYS_LTECELL_RF.e_downtilt
  is '���������
';
comment on column MB_SYS_LTECELL_RF.height
  is '���߹Ҹ�
';
comment on column MB_SYS_LTECELL_RF.altitude
  is '���θ߶�
';
comment on column MB_SYS_LTECELL_RF.antenna
  is '�����ͺ�
';
comment on column MB_SYS_LTECELL_RF.fake_antenna
  is '�Ƿ�����
';
comment on column MB_SYS_LTECELL_RF.record_time
  is '��¼ʱ��
';
comment on column MB_SYS_LTECELL_RF.update_time
  is '����ʱ��
';
comment on column MB_SYS_LTECELL_RF.update_user
  is '������
';
comment on column MB_SYS_LTECELL_RF.share_rfs
  is '�Ƿ�����';
comment on column MB_SYS_LTECELL_RF.antenna_type_old
  is '���淽ʽ';
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
  is 'ȫ�������ʶ
';
comment on column MB_SYS_LTECELL_TDSNBR.name
  is '�û��Ѻ���
';
comment on column MB_SYS_LTECELL_TDSNBR.object_rdn
  is '��Դ����Ψһ��ʶ
';
comment on column MB_SYS_LTECELL_TDSNBR.zh_name
  is '��������
';
comment on column MB_SYS_LTECELL_TDSNBR.omc_id
  is 'OMC_ID
';
comment on column MB_SYS_LTECELL_TDSNBR.city
  is '����
';
comment on column MB_SYS_LTECELL_TDSNBR.vendor_id
  is '�豸����ID
';
comment on column MB_SYS_LTECELL_TDSNBR.time_stamp
  is '���ݲɼ�ʱ���
';
comment on column MB_SYS_LTECELL_TDSNBR.update_stamp
  is '���ݸ���ʱ���
';
comment on column MB_SYS_LTECELL_TDSNBR.confirmed
  is 'ɾ�������ӵ�ȷ��
';
comment on column MB_SYS_LTECELL_TDSNBR.tac
  is 'ԴС����������ʶ
';
comment on column MB_SYS_LTECELL_TDSNBR.pci
  is 'ԴС������С����ʶ
';
comment on column MB_SYS_LTECELL_TDSNBR.earfcn
  is 'ԴС��������Ƶ���ŵ���
';
comment on column MB_SYS_LTECELL_TDSNBR.m_name
  is '��С������
';
comment on column MB_SYS_LTECELL_TDSNBR.n_name
  is '��С������
';
comment on column MB_SYS_LTECELL_TDSNBR.id
  is '��ʶ��
';
comment on column MB_SYS_LTECELL_TDSNBR.adj_cgi
  is 'Ŀ��ȫ�������ʶ';
comment on column MB_SYS_LTECELL_TDSNBR.adjacentcellid
  is '����С���ı�ʶ';
comment on column MB_SYS_LTECELL_TDSNBR.lac
  is 'λ��������';
comment on column MB_SYS_LTECELL_TDSNBR.rac
  is '·��������';
comment on column MB_SYS_LTECELL_TDSNBR.uarfcn
  is 'Ƶ��';
comment on column MB_SYS_LTECELL_TDSNBR.cellparameterid
  is 'С��������ʶ';
comment on column MB_SYS_LTECELL_TDSNBR.update_user
  is '������ ';
comment on column MB_SYS_LTECELL_TDSNBR.record_time
  is '��¼����';

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
  is '4G��վ��Ϣ��';
comment on column MB_SYS_LTESITE_INFO.enodeb_glb_id
  is '��վ��ȫ�ֻ�վ��ȫ��ID���
';
comment on column MB_SYS_LTESITE_INFO.enodeb_id
  is '������վID
';
comment on column MB_SYS_LTESITE_INFO.enodeb_name
  is '������վ����
';
comment on column MB_SYS_LTESITE_INFO.tac
  is '����������
';
comment on column MB_SYS_LTESITE_INFO.vendor
  is '�豸����
';
comment on column MB_SYS_LTESITE_INFO.longitude
  is '����
';
comment on column MB_SYS_LTESITE_INFO.latitude
  is 'γ��
';
comment on column MB_SYS_LTESITE_INFO.netgrid
  is '�����
';
comment on column MB_SYS_LTESITE_INFO.environ
  is '����
';
comment on column MB_SYS_LTESITE_INFO.freq_band
  is 'Ƶ��
';
comment on column MB_SYS_LTESITE_INFO.cover_type
  is '��������
';
comment on column MB_SYS_LTESITE_INFO.project_period
  is 'վ�㹤�ں�
';
comment on column MB_SYS_LTESITE_INFO.single_pass
  is '�����Ƿ�ͨ��
';
comment on column MB_SYS_LTESITE_INFO.init_time
  is '��ʼ����ʱ��
';
comment on column MB_SYS_LTESITE_INFO.run_time
  is '�״ο�ͨʱ��
';
comment on column MB_SYS_LTESITE_INFO.record_time
  is '��¼ʱ��
';
comment on column MB_SYS_LTESITE_INFO.update_time
  is '����ʱ��
';
comment on column MB_SYS_LTESITE_INFO.update_user
  is '������
';
comment on column MB_SYS_LTESITE_INFO.regiontype
  is '��������';
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
  is '4G��վ��ʱ�ñ���ɾ��---by huangc';
comment on column MB_SYS_LTESITE_INFO_T.record_time
  is '��¼ʱ��';
comment on column MB_SYS_LTESITE_INFO_T.int_id
  is 'Ψһ��ʶ';
comment on column MB_SYS_LTESITE_INFO_T.object_rdn
  is '��վDN��';
comment on column MB_SYS_LTESITE_INFO_T.name
  is '��վӢ����';
comment on column MB_SYS_LTESITE_INFO_T.zh_name
  is '��վ������';
comment on column MB_SYS_LTESITE_INFO_T.omc_id
  is 'OMCID��';
comment on column MB_SYS_LTESITE_INFO_T.vendor_id
  is '��������';
comment on column MB_SYS_LTESITE_INFO_T.city_id
  is '��������';
comment on column MB_SYS_LTESITE_INFO_T.time_stamp
  is '����ʱ��';
comment on column MB_SYS_LTESITE_INFO_T.update_stamp
  is '����ʱ�䣨ͬ�ϣ��ļ�����2��һģһ���ģ�';
comment on column MB_SYS_LTESITE_INFO_T.confirmed
  is '��Ԫ״̬';
comment on column MB_SYS_LTESITE_INFO_T.state
  is '�豸ά��״̬';
comment on column MB_SYS_LTESITE_INFO_T.enodeb_id
  is 'Enodeb��ʶ��';
comment on column MB_SYS_LTESITE_INFO_T.enbid
  is 'eNodeB�����ʶ��';
comment on column MB_SYS_LTESITE_INFO_T.x2blacklist
  is 'eNodeB�������б�';
comment on column MB_SYS_LTESITE_INFO_T.x2whitelist
  is 'eNodeB�������б�';
comment on column MB_SYS_LTESITE_INFO_T.x2hoblacklist
  is 'X2�ӿ��л�eNodeB�������б�';
comment on column MB_SYS_LTESITE_INFO_T.cover_area_info
  is '��������ϸ��Ϣ';
comment on column MB_SYS_LTESITE_INFO_T.x2ipaddresslist
  is 'X2�ӿ�IP��ַ�б�';
comment on column MB_SYS_LTESITE_INFO_T.max_throughput_rate
  is '�滮�����������';
comment on column MB_SYS_LTESITE_INFO_T.administrativestate
  is '����״̬';
comment on column MB_SYS_LTESITE_INFO_T.operationalstate
  is '����״̬';
comment on column MB_SYS_LTESITE_INFO_T.x2_num
  is 'x2����';
comment on column MB_SYS_LTESITE_INFO_T.integrityprotalgorithm
  is '�����Ա����㷨';
comment on column MB_SYS_LTESITE_INFO_T.cipheringalgorithm
  is '�����㷨';
comment on column MB_SYS_LTESITE_INFO_T.related_me
  is '����ME��';

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
  is '4G��վ������';
comment on column MB_SYS_LTESITE_PARAM.enodeb_glb_id
  is '��վ��ȫ��ID���
';
comment on column MB_SYS_LTESITE_PARAM.enodeb_id
  is '������վID
';
comment on column MB_SYS_LTESITE_PARAM.enodeb_name
  is '������վ����
';
comment on column MB_SYS_LTESITE_PARAM.operastate
  is '״̬
';
comment on column MB_SYS_LTESITE_PARAM.update_time
  is '����ʱ��
';
comment on column MB_SYS_LTESITE_PARAM.record_time
  is '��¼����';

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
  is '3GС����Ϣ��';
comment on column MB_SYS_TDSCELL_INFO.cell_id
  is 'С��ID
';
comment on column MB_SYS_TDSCELL_INFO.cell_name
  is 'С������
';
comment on column MB_SYS_TDSCELL_INFO.site_oid
  is '��վ��ʶ
';
comment on column MB_SYS_TDSCELL_INFO.cgi
  is 'ȫ��С��ID
';
comment on column MB_SYS_TDSCELL_INFO.rru_remote
  is '�Ƿ���ԶС��
';
comment on column MB_SYS_TDSCELL_INFO.cell_longitude
  is 'С������
';
comment on column MB_SYS_TDSCELL_INFO.cell_latitude
  is 'С��γ��
';
comment on column MB_SYS_TDSCELL_INFO.sector_id
  is '����С����ʶ
';
comment on column MB_SYS_TDSCELL_INFO.pci
  is '����С����ʶ��PCI)
';
comment on column MB_SYS_TDSCELL_INFO.earfcn
  is '����Ƶ��
';
comment on column MB_SYS_TDSCELL_INFO.rf_power
  is '�ο��źŹ���
';
comment on column MB_SYS_TDSCELL_INFO.covertype
  is '��������
';
comment on column MB_SYS_TDSCELL_INFO.bandindicatorforfrequency
  is 'Ƶ��ָʾ
';
comment on column MB_SYS_TDSCELL_INFO.rac
  is 'С��·��������
';
comment on column MB_SYS_TDSCELL_INFO.powerdivisiontype
  is '��������
';
comment on column MB_SYS_TDSCELL_INFO.powerdivisionindex
  is '��������
';
comment on column MB_SYS_TDSCELL_INFO.record_time
  is '¼��ʱ��
';
comment on column MB_SYS_TDSCELL_INFO.uptime_time
  is '����ʱ��
';
comment on column MB_SYS_TDSCELL_INFO.update_user
  is '������
';
comment on column MB_SYS_TDSCELL_INFO.cell_glb_id
  is 'С����ȫ��ID���
';
comment on column MB_SYS_TDSCELL_INFO.site_glb_id
  is '��վ��ȫ��ID���
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
  is '3GС��RF��';
comment on column MB_SYS_TDSCELL_RF.cell_id
  is 'С��ID
';
comment on column MB_SYS_TDSCELL_RF.cell_name
  is 'С������
';
comment on column MB_SYS_TDSCELL_RF.azimuth
  is '���߷����
';
comment on column MB_SYS_TDSCELL_RF.height
  is '���߹Ҹ�
';
comment on column MB_SYS_TDSCELL_RF.mtilt
  is '���߻�е�����
';
comment on column MB_SYS_TDSCELL_RF.etilt
  is '���ߵ��������
';
comment on column MB_SYS_TDSCELL_RF.antenna
  is '�����ͺ�
';
comment on column MB_SYS_TDSCELL_RF.fake_antenna
  is '�Ƿ�����
';
comment on column MB_SYS_TDSCELL_RF.update_time
  is '����ʱ��
';
comment on column MB_SYS_TDSCELL_RF.record_time
  is '��¼ʱ��
';
comment on column MB_SYS_TDSCELL_RF.update_user
  is '������
';
comment on column MB_SYS_TDSCELL_RF.cell_glb_id
  is 'С����ȫ��ID���
';
comment on column MB_SYS_TDSCELL_RF.site_glb_id
  is '��վ��ȫ��ID���
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
  is '3G��վ��Ϣ��';
comment on column MB_SYS_TDSSITE_INFO.rnc_id
  is 'RNC_name
';
comment on column MB_SYS_TDSSITE_INFO.site_oid
  is '��վ��ʶ
';
comment on column MB_SYS_TDSSITE_INFO.site_name
  is '��վ����
';
comment on column MB_SYS_TDSSITE_INFO.lac
  is '����������
';
comment on column MB_SYS_TDSSITE_INFO.vendor
  is '�豸����
';
comment on column MB_SYS_TDSSITE_INFO.longitude
  is '����
';
comment on column MB_SYS_TDSSITE_INFO.latitude
  is 'γ��
';
comment on column MB_SYS_TDSSITE_INFO.netgrid
  is '�����
';
comment on column MB_SYS_TDSSITE_INFO.environ
  is '����
';
comment on column MB_SYS_TDSSITE_INFO.freq_band
  is 'Ƶ��
';
comment on column MB_SYS_TDSSITE_INFO.cover_type
  is '��������
';
comment on column MB_SYS_TDSSITE_INFO.record_time
  is '¼��ʱ��
';
comment on column MB_SYS_TDSSITE_INFO.update_time
  is '��������ʱ��
';
comment on column MB_SYS_TDSSITE_INFO.update_user
  is '������
';
comment on column MB_SYS_TDSSITE_INFO.site_glb_id
  is '��վ��ȫ��ID���
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
  is 'С������ͳ�Ʊ�';
comment on column MB_SYS_TRAFFIC_CELL.record_time
  is 'ʱ��';
comment on column MB_SYS_TRAFFIC_CELL.city
  is '����';
comment on column MB_SYS_TRAFFIC_CELL.cell_count
  is 'С������';
comment on column MB_SYS_TRAFFIC_CELL.network_type
  is '�������� 2/3/4G';

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
  is '��Ƶ��Ψһ��ʶ';
comment on column MB_TCC_CARRIER.record_time
  is 'ʱ��';
comment on column MB_TCC_CARRIER.related_utrancell
  is 'С����Ψһ��ʶ';

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
  is 'С����Ψһ��ʶ
';
comment on column MB_TCC_CELL.record_time
  is 'ʱ��
';
comment on column MB_TCC_CELL.region_id
  is '����
';
comment on column MB_TCC_CELL.bts_name
  is '����BTS
';
comment on column MB_TCC_CELL.vendor_id
  is '����
';
comment on column MB_TCC_CELL.trx_number
  is '��Ƶ����
';
comment on column MB_TCC_CELL.sdcch_num
  is 'SDCCH�ŵ���
';
comment on column MB_TCC_CELL.bsc_name
  is '����BSC
';
comment on column MB_TCC_CELL.btssm_name
  is '��վ����
';
comment on column MB_TCC_CELL.cgi
  is 'CGI
';
comment on column MB_TCC_CELL.sys_type
  is '����Ƶ��
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
  is 'С����Ψһ��ʶ';
comment on column MB_TCC_RNC.record_time
  is 'ʱ��';
comment on column MB_TCC_RNC.name
  is 'RNC����';

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
  is 'С����Ψһ��ʶ';
comment on column MB_TCC_TCO_PRO_CELL.record_time
  is 'ʱ��';
comment on column MB_TCC_TCO_PRO_CELL.bsc_name
  is '����BSC';
comment on column MB_TCC_TCO_PRO_CELL.cgi
  is 'CGI';
comment on column MB_TCC_TCO_PRO_CELL.longitude
  is '����';
comment on column MB_TCC_TCO_PRO_CELL.latitude
  is 'γ��';
comment on column MB_TCC_TCO_PRO_CELL.cover_type
  is '��������';
comment on column MB_TCC_TCO_PRO_CELL.ccch_num
  is 'CCCH�ŵ���';

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
  is 'С����Ψһ��ʶ';
comment on column MB_TCC_TCO_PRO_UTRANCELL.record_time
  is 'ʱ��';
comment on column MB_TCC_TCO_PRO_UTRANCELL.dt_region_type_id
  is '��������';
comment on column MB_TCC_TCO_PRO_UTRANCELL.longitude
  is '����';
comment on column MB_TCC_TCO_PRO_UTRANCELL.latitude
  is 'γ��';
comment on column MB_TCC_TCO_PRO_UTRANCELL.dir
  is '��λ��';
comment on column MB_TCC_TCO_PRO_UTRANCELL.indoor_support
  is '��������';

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
  is 'С����Ψһ��ʶ';
comment on column MB_TCC_UTRANCELL.record_time
  is 'ʱ��';
comment on column MB_TCC_UTRANCELL.city_id
  is '����';
comment on column MB_TCC_UTRANCELL.name
  is 'С����';
comment on column MB_TCC_UTRANCELL.lac
  is 'LAC';
comment on column MB_TCC_UTRANCELL.cid
  is 'CI';
comment on column MB_TCC_UTRANCELL.hcarrier_number
  is 'HSDPA�ز���';
comment on column MB_TCC_UTRANCELL.r4carrier_number
  is 'R4�ز���';
comment on column MB_TCC_UTRANCELL.rnc_name
  is '����RNC';
comment on column MB_TCC_UTRANCELL.cgi
  is 'CGI';
comment on column MB_TCC_UTRANCELL.confirmed
  is '״̬';
comment on column MB_TCC_UTRANCELL.time_stamp
  is '����ʱ��';

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
  is 'С����Ψһ��ʶ';
comment on column MB_TER_CNT_CELL.record_time
  is 'ʱ��';
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
  is 'С����Ψһ��ʶ';
comment on column MB_TER_CNT_CELL_GPRS.record_time
  is 'ʱ��';
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
  is 'ɨƵ����';
comment on column MB_TEST_SCANFREQ.task_id
  is '����ƻ�ID
';
comment on column MB_TEST_SCANFREQ.cell_glb_id
  is 'С����ȫ��ID���
';
comment on column MB_TEST_SCANFREQ.cell_id
  is 'С��ID
';
comment on column MB_TEST_SCANFREQ.cell_name
  is 'С������
';
comment on column MB_TEST_SCANFREQ.pci
  is '����С����ʶ��PCI)
';
comment on column MB_TEST_SCANFREQ.earfcn
  is '����Ƶ��
';
comment on column MB_TEST_SCANFREQ.rs_rp
  is '�ο��źŵ�ƽ
';
comment on column MB_TEST_SCANFREQ.rs_cinr_sinr
  is 'RS�����ź������(����������ż�����)���ǿ��
';
comment on column MB_TEST_SCANFREQ.test_time
  is 'ɨƵ����ʱ��
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
  is 'С����Ψһ��ʶ';
comment on column MB_THW_CNT_CELL2_6K.record_time
  is 'ʱ��';
comment on column MB_THW_CNT_CELL2_6K.c1278469458
  is 'AR3010A:�ŵ���̬����ƽ����Ŀ��SDCCH����900/850С����';
comment on column MB_THW_CNT_CELL2_6K.c1278469459
  is 'AR3010B:�ŵ���̬����ƽ����Ŀ��SDCCH����1800/1900С����';
comment on column MB_THW_CNT_CELL2_6K.c1278469468
  is 'AR3020A:�ŵ�����ƽ����Ŀ��SDCCH����900/850С����';
comment on column MB_THW_CNT_CELL2_6K.c1278469469
  is 'AR3020B:�ŵ�����ƽ����Ŀ��SDCCH����1800/1900С����';

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
  is 'С����Ψһ��ʶ';
comment on column MB_THW_CNT_CELL_GPRS_6K.record_time
  is 'ʱ��';
comment on column MB_THW_CNT_CELL_GPRS_6K.c1279175419
  is 'A9203:���ŵ���Դ��������EGPRSTBF����ʧ�ܴ���';
comment on column MB_THW_CNT_CELL_GPRS_6K.c1279176419
  is 'A9303:���ŵ���Դ��������EGPRSTBF����ʧ�ܴ���';

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
  is 'С����Ψһ��ʶ';
comment on column MB_THW_CNT_CELL_HO_6K.record_time
  is 'ʱ��';
comment on column MB_THW_CNT_CELL_HO_6K.c1278087446
  is 'RK3255:TRX��Ƶ������';

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
  is 'С����Ψһ��ʶ';
comment on column MB_TNK_CNT_CELL_GPRS_PACK.record_time
  is 'ʱ��';
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
  is 'С����Ψһ��ʶ';
comment on column MB_TNK_CNT_CELL_RES_AVAIL.record_time
  is 'ʱ��';
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
  is 'С����Ψһ��ʶ';
comment on column MB_TPA_STS_CELL_GPRS_NE.record_time
  is 'ʱ��';
comment on column MB_TPA_STS_CELL_GPRS_NE.m_occupy_pdch
  is 'ռ�õ�PDCH��ƽ����Ŀ';
comment on column MB_TPA_STS_CELL_GPRS_NE.static_pdch
  is 'PDCH��̬������';
comment on column MB_TPA_STS_CELL_GPRS_NE.sum_level
  is 'ʱ������';

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
  is 'С����Ψһ��ʶ';
comment on column MB_TPA_STS_CELL_NE.record_time
  is 'ʱ��';
comment on column MB_TPA_STS_CELL_NE.tch_traffic_half
  is '�����ʻ����ŵ�������';
comment on column MB_TPA_STS_CELL_NE.tch_traffic
  is 'С���ܻ�����';
comment on column MB_TPA_STS_CELL_NE.att_tch_ovrfl_nho
  is '�����ŵ���������������л���';
comment on column MB_TPA_STS_CELL_NE.tch_call_req_nho
  is '�����ŵ��Ժ������������л�)';
comment on column MB_TPA_STS_CELL_NE.att_tch_ovrfl
  is '�����ŵ�������������л�)';
comment on column MB_TPA_STS_CELL_NE.tch_call_req
  is '�����ŵ��Ժ����������л�)';
comment on column MB_TPA_STS_CELL_NE.tch_nbr
  is 'TCH�ŵ�������';
comment on column MB_TPA_STS_CELL_NE.sum_level
  is 'ʱ������';

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
  is '��Ƶ��Ψһ��ʶ
';
comment on column MB_TPD_STS_CARRIER_Q.record_time
  is 'ʱ��
';
comment on column MB_TPD_STS_CARRIER_Q.meannbruser_d
  is '��ƵHSDPAƽ���û���
';
comment on column MB_TPD_STS_CARRIER_Q.nbrassnbruul
  is '��Ƶ����ҵ��ռ�õ�BRU����
';
comment on column MB_TPD_STS_CARRIER_Q.nbrassnbrudl
  is '��Ƶ����ҵ��ռ�õ�BRU����
';
comment on column MB_TPD_STS_CARRIER_Q.nbravailbruul
  is '��Ƶ���п��õ�BRU����
';
comment on column MB_TPD_STS_CARRIER_Q.nbravailbrudl
  is '��Ƶ���п��õ�BRU����
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
  is 'С����Ψһ��ʶ';
comment on column MB_TPD_STS_UTRANCELL1_Q.record_time
  is 'ʱ��';
comment on column MB_TPD_STS_UTRANCELL1_Q.vendor_id
  is '����';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabcs_20
  is 'ԭ��Ϊ20��ָ��ʧ�ܵĵ�·��RAB����С������';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabcs_114
  is 'ԭ��Ϊ114��ָ��ʧ�ܵĵ�·��RAB����С������';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabps_20
  is 'ԭ��20��ָ��ʧ�ܵķ�����RAB����С������';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabps_114
  is 'ԭ��Ϊ114��ָ��ʧ�ܵķ�����RAB����С������';
comment on column MB_TPD_STS_UTRANCELL1_Q.failconnestab
  is 'RRC����ʧ�ܴ���';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabcs_53
  is 'ԭ��Ϊ53��ָ��ʧ�ܵĵ�·���RAB����С������';
comment on column MB_TPD_STS_UTRANCELL1_Q.failestabps_53
  is 'ԭ��Ϊ53��ָ��ʧ�ܵķ�����RAB����С������';
comment on column MB_TPD_STS_UTRANCELL1_Q.failconnestab_1
  is 'ԭ��Ϊ1��RRC����ʧ�ܴ���';
comment on column MB_TPD_STS_UTRANCELL1_Q.failconnestab_cong
  is 'ԭ��ΪCong��RRC����ʧ�ܴ���';

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
  is 'ʱ��';
comment on column MB_TPD_STS_UTRANCELL2_Q.psuloct
  is 'RLC���������������';
comment on column MB_TPD_STS_UTRANCELL2_Q.psdloct
  is 'RLC���������������';
comment on column MB_TPD_STS_UTRANCELL2_Q.cstraffic_conv11
  is 'RLC���·��Ự��խ��AMR������';
comment on column MB_TPD_STS_UTRANCELL2_Q.cstraffic_conv22
  is 'RLC���·��Ự��������12_2K������';
comment on column MB_TPD_STS_UTRANCELL2_Q.cstraffic_conv55
  is 'RLC���·��Ự��������64K������';
comment on column MB_TPD_STS_UTRANCELL2_Q.int_id
  is 'С����Ψһ��ʶ';

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
  is 'С����Ψһ��ʶ';
comment on column MB_TZX_CNT_CELL2_V3.record_time
  is 'ʱ��';
comment on column MB_TZX_CNT_CELL2_V3.c90108000030
  is '�ز�����';
comment on column MB_TZX_CNT_CELL2_V3.c90108000031
  is '����ز�����';
comment on column MB_TZX_CNT_CELL2_V3.c90108000007
  is 'SDCCH��̬���ÿ��ø���';

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
  is 'С����Ψһ��ʶ';
comment on column MB_TZX_CNT_CELL_GPRS_DL_V3.record_time
  is 'ʱ��';
comment on column MB_TZX_CNT_CELL_GPRS_DL_V3.c90118000008
  is '����EGPRS TBF�����������ݿ���RR��Դӵ��ʧ�ܴ���';

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
  is 'С����Ψһ��ʶ';
comment on column MB_TZX_CNT_CELL_GPRS_UL_V3.record_time
  is 'ʱ��';
comment on column MB_TZX_CNT_CELL_GPRS_UL_V3.c90120000016
  is '����GPRS TBF�����������ݿ���RR��Դӵ��ʧ�ܴ���';

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
 V_SQL_PARTION VARCHAR2(5000); --��̬sql���
 V_FALG_PARTION INT:=0;  -- �ж����ñ��Ƿ��Ѿ�������
 v_part_name varchar2(20);
 v_part_time varchar2(30);


BEGIN

        select to_char(trunc(sysdate+1),'yyyymmdd'),to_char(trunc(sysdate+2),'yyyy-mm-dd hh24:mi:ss')  into v_part_name,v_part_time from dual;
        --��ȡͳ�Ʒ���������,��ѯ�ñ�ķ����Ƿ��ѽ�
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_MR_RECORD' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_MR_RECORD add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


       select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_GSM_BUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PERF_GSM_BUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


              select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_LTE_CELLBUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PERF_LTE_CELLBUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_TDS_BUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PERF_TDS_BUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



       select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSSITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_TDSSITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


              select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSCELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_TDSCELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSCELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_TDSCELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_PARAM' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_PARAM add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_INFO_T' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_INFO_T add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_TDSNBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_TDSNBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_PARAM' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_PARAM add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_LTENBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_LTENBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_INFO_T' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_INFO_T add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_GSMNBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_GSMNBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMSITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GSMSITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMCELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GSMCELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMCELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GSMCELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_TDSPERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GIS_TDSPERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_PERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GIS_PERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_GSMPERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GIS_GSMPERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_LTESITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PLAN_LTESITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

          select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_LTECELL_INFO' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PLAN_LTECELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
   select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_7DAYS_ONLINE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PLAN_7DAYS_ONLINE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_BIN_PROCESS_INFO' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_BIN_PROCESS_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_PING_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_LTE_ST_PING_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_FTP_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_LTE_ST_FTP_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_VIDEO_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_LTE_ST_VIDEO_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_HTTP_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_LTE_ST_HTTP_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



         select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TCC_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_TCO_PRO_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TCC_TCO_PRO_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL_HO_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL_HO_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPA_STS_CELL_NE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TPA_STS_CELL_NE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPA_STS_CELL_GPRS_NE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TPA_STS_CELL_GPRS_NE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL_GPRS_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL_GPRS_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL_GPRS_UL_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL_GPRS_UL_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL_GPRS_DL_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL_GPRS_DL_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TNK_CNT_CELL_GPRS_PACK' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TNK_CNT_CELL_GPRS_PACK add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TER_CNT_CELL_GPRS' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TER_CNT_CELL_GPRS add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL2_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL2_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL2_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL2_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TER_CNT_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TER_CNT_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TNK_CNT_CELL_RES_AVAIL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TNK_CNT_CELL_RES_AVAIL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_BTS_TYPE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_BTS_TYPE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_UTRANCELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TCC_UTRANCELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_TCO_PRO_UTRANCELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TCC_TCO_PRO_UTRANCELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_RNC' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TCC_RNC add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_UTRANCELL1_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TPD_STS_UTRANCELL1_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_UTRANCELL2_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TPD_STS_UTRANCELL2_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_CARRIER_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TPD_STS_CARRIER_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_CARRIER' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
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
 V_SQL_PARTION VARCHAR2(5000); --��̬sql���
 V_FALG_PARTION INT:=0;  -- �ж����ñ��Ƿ��Ѿ�������
 v_part_name varchar2(20);
 v_part_time varchar2(30);


BEGIN

        select to_char(trunc(sysdate),'yyyymmdd'),to_char(trunc(sysdate+1),'yyyy-mm-dd hh24:mi:ss')  into v_part_name,v_part_time from dual;
        --��ȡͳ�Ʒ���������,��ѯ�ñ�ķ����Ƿ��ѽ�
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_MR_RECORD' and t.partition_name='PART_'||v_part_name;
        dbms_output.put_line('v_part_name='||v_part_name);
        dbms_output.put_line('v_part_time='||v_part_time);

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_MR_RECORD add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


       select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_GSM_BUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PERF_GSM_BUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


              select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_LTE_CELLBUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PERF_LTE_CELLBUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PERF_TDS_BUSISTAT' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PERF_TDS_BUSISTAT add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



       select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSSITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_TDSSITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


              select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSCELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_TDSCELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_TDSCELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_TDSCELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_PARAM' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_PARAM add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_INFO_T' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_INFO_T add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTESITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTESITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_TDSNBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_TDSNBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_PARAM' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_PARAM add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_LTENBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_LTENBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_INFO_T' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_INFO_T add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_LTECELL_GSMNBR' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_LTECELL_GSMNBR add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMSITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GSMSITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMCELL_RF' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GSMCELL_RF add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GSMCELL_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GSMCELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_TDSPERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GIS_TDSPERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_PERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GIS_PERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_SYS_GIS_GSMPERMISSION' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_SYS_GIS_GSMPERMISSION add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_LTESITE_INFO' and t.partition_name='PART_'||v_part_name;

        if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PLAN_LTESITE_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

          select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_LTECELL_INFO' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PLAN_LTECELL_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
   select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_PLAN_7DAYS_ONLINE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_PLAN_7DAYS_ONLINE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_BIN_PROCESS_INFO' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_BIN_PROCESS_INFO add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_PING_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_LTE_ST_PING_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_FTP_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_LTE_ST_FTP_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_VIDEO_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_LTE_ST_VIDEO_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;


 select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_LTE_ST_HTTP_TY' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_LTE_ST_HTTP_TY add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;



         select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TCC_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;

        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_TCO_PRO_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TCC_TCO_PRO_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL_HO_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL_HO_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPA_STS_CELL_NE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TPA_STS_CELL_NE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPA_STS_CELL_GPRS_NE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TPA_STS_CELL_GPRS_NE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL_GPRS_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL_GPRS_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL_GPRS_UL_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL_GPRS_UL_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL_GPRS_DL_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL_GPRS_DL_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TNK_CNT_CELL_GPRS_PACK' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TNK_CNT_CELL_GPRS_PACK add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TER_CNT_CELL_GPRS' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TER_CNT_CELL_GPRS add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_THW_CNT_CELL2_6K' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_THW_CNT_CELL2_6K add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TZX_CNT_CELL2_V3' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TZX_CNT_CELL2_V3 add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TER_CNT_CELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TER_CNT_CELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TNK_CNT_CELL_RES_AVAIL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TNK_CNT_CELL_RES_AVAIL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_BTS_TYPE' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_BTS_TYPE add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_UTRANCELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TCC_UTRANCELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_TCO_PRO_UTRANCELL' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TCC_TCO_PRO_UTRANCELL add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_RNC' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TCC_RNC add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_UTRANCELL1_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TPD_STS_UTRANCELL1_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_UTRANCELL2_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TPD_STS_UTRANCELL2_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TPD_STS_CARRIER_Q' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
             V_SQL_PARTION:='alter table MB_TPD_STS_CARRIER_Q add partition part_'||v_part_name||' values less than  (timestamp '''||v_part_time||''')';
            DBMS_OUTPUT.put_line(V_SQL_PARTION);
             EXECUTE IMMEDIATE V_SQL_PARTION;
             commit;
        end if;
        select count(1) INTO V_FALG_PARTION from user_tab_partitions t where  t.table_name='MB_TCC_CARRIER' and t.partition_name='PART_'||v_part_name;

           if V_FALG_PARTION = 0 then
             --��ͳ�Ʊ�ķ���
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
              DBMS_OUTPUT.PUT_LINE('��Ƕ��sql��䲻�ܽ��ַ�ת��Ϊ����');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('Ϊ�������');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('����Ϊ0');
        when others then
             DBMS_OUTPUT.PUT_LINE('�������ݴ���');
        rollback ;

 end;
/

prompt
prompt Creating procedure PROC_DATA_NUM
prompt ================================
prompt
create or replace procedure proc_data_num as   --�滮���κ�����������������ÿ���Ƴ��Լ�����ɺ����
 v_insert varchar2(20000);--SQL
 v_part varchar2(30);  --������
 v_del varchar2(2000);

begin
  select 'part_'||to_char(sysdate-1,'yyyymmdd')  into v_part from dual;  --ǰһ�������

  v_insert :='insert into MB_DATA_REPORT_INFO select b.record_time,b.type,b.province,b.city,a.original_record_num,b.sys_clean,b.sys_valid,a.original_file_num,a.original_file_size,a.data_origin from MB_BIN_PROCESS_INFO  partition('||v_part||')  a  ,(
select a.record_time,a.type ,a.province,a.city,a.sys_clean,b.sys_valid    from (
select b.province,b.city,a.record_time,count(*) sys_clean,''��������'' type from MB_SYS_LTECELL_INFO  partition('||v_part||') a,mb_sys_Gis_Permission  partition('||v_part||') b
where a.enodeb_glb_id = b.enodeb_glb_id(+) and b.city !=''unkonw region'' group by   b.province,b.city,a.record_time) a
left join (select b.province, b.city, a.record_time, count(*) sys_valid,''��������'' type
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
 select record_time,''�Ĵ�ʡ'' province,city_name,count(*) plan_clean ,''�滮����'' type from mb_plan_ltesite_info  partition('||v_part||') a group by record_time,city_name
) c    left join (
select record_time,''�Ĵ�ʡ'' province,city_name,count(*) plan_valid from mb_plan_ltesite_info  partition('||v_part||') a where    a.longitude is not null
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
              DBMS_OUTPUT.PUT_LINE('��Ƕ��sql��䲻�ܽ��ַ�ת��Ϊ����');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('Ϊ�������');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('����Ϊ0');
        when others then
             DBMS_OUTPUT.PUT_LINE('�������ݴ���');
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
  if type='1' then   ----��ͳ
  v_insert :='
   insert into MB_DATA_REPORT_INFO(Record_Time,Type,province,city,Original_Record_Num,CLEAN_DATA_NUM,Original_File_Num,Original_File_Size,DATA_ORIGIN)
select to_date(a.record_time,''yyyymmdd hh24:mi:ss'') record_time,a.type,a.province,a.city,b.original_record_num,a.clean,b.original_file_num,b.original_file_size,''�ļ�'' from   (
select t1.record_time,t1.province,t1.city,nvl(t1.clean,0)+nvl(t2.clean,0)+nvl(t3.clean,0) clean,t1.type from (
select to_char(record_time,''yyyymmdd hh24'') record_time,''�Ĵ�ʡ'' province ,city,count(*) clean, ''��ͳ'' type from mb_perf_lte_cellbusistat where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
 group by to_char(record_time,''yyyymmdd hh24''),city) t1 ,(select to_char(record_time,''yyyymmdd hh24'') record_time,''�Ĵ�ʡ'' province ,city,count(*) clean, ''��ͳ'' type from MB_PERF_TDS_BUSISTAT where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
 group by to_char(record_time,''yyyymmdd hh24''),city )t2,(select to_char(record_time,''yyyymmdd hh24'') record_time,''�Ĵ�ʡ'' province ,city,count(*) clean, ''��ͳ'' type from MB_PERF_GSM_BUSISTAT where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
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
 
if type='2' then   ----·��
    v_insert :='
insert into MB_DATA_REPORT_INFO(Record_Time,Type,Original_Record_Num,CLEAN_DATA_NUM,Original_File_Num,Original_File_Size,DATA_ORIGIN)
select to_date(a.record_time,''yyyymmdd hh24:mi:ss'') record_time,a.type,b.original_record_num,a.clean,b.original_file_num,b.original_file_size,b.data_origin from   (
 
select to_char(record_time,''yyyymmdd hh24'') record_time,count(*) clean,''·��'' type from mb_dt_record where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
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
 
select to_char(record_time,''yyyymmdd hh24'') record_time,count(*) clean,''·��'' type from mb_dt_record where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
 and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
group by to_char(record_time,''yyyymmdd hh24'')
) a left join (select to_char(record_time,''yyyymmdd hh24'') record_time,type, data_generation,sum(t.original_record_num) original_record_num ,sum(t.original_file_num) original_file_num,
sum(t.original_file_size) original_file_size,t.data_origin 
from MB_BIN_PROCESS_INFO t where record_time >=to_date('''||v_sttime||''',''yyyymmdd hh24:mi:ss'')
 and record_time < to_date('''||v_endtime||''',''yyyymmdd hh24:mi:ss'')
group by to_char(record_time,''yyyymmdd hh24''),type, data_generation,data_origin) b on a.record_time = b.record_time  and  a.type = b.type
';
end if;  ----ȥ�أ���ʱ����
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
              DBMS_OUTPUT.PUT_LINE('��Ƕ��sql��䲻�ܽ��ַ�ת��Ϊ����');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('Ϊ�������');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('����Ϊ0');
        when others then
             DBMS_OUTPUT.PUT_LINE('�������ݴ���');
        rollback ;
 end;
/

prompt
prompt Creating procedure PROC_DATA_NUM_TEST
prompt =====================================
prompt
create or replace procedure proc_data_num_test as   --�滮���κ�����������������ÿ���Ƴ��Լ�����ɺ����
 v_insert varchar2(20000);--SQL
 v_part varchar2(30);  --������
 v_del varchar2(2000);

begin
  select 'part_'||to_char(sysdate-1,'yyyymmdd')  into v_part from dual;  --ǰһ�������

  v_insert :='insert into MB_DATA_REPORT_INFO select b.record_time,b.type,b.province,b.city,a.original_record_num,b.sys_clean,b.sys_valid,a.original_file_num,a.original_file_size,a.data_origin from MB_BIN_PROCESS_INFO  partition('||v_part||')  a  ,(
select a.record_time,a.type ,a.province,a.city,a.sys_clean,b.sys_valid    from (
select b.province,b.city,a.record_time,count(*) sys_clean,''��������'' type from MB_SYS_LTECELL_INFO  partition('||v_part||') a,mb_sys_Gis_Permission  partition('||v_part||') b
where a.enodeb_glb_id = b.enodeb_glb_id(+) and b.city !=''unkonw region'' group by   b.province,b.city,a.record_time) a
left join (select b.province, b.city, a.record_time, count(*) sys_valid,''��������'' type
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
 select record_time,''�Ĵ�ʡ'' province,city_name,count(*) plan_clean ,''�滮����'' type from mb_plan_ltesite_info  partition('||v_part||') a group by record_time,city_name
) c    left join (
select record_time,''�Ĵ�ʡ'' province,city_name,count(*) plan_valid from mb_plan_ltesite_info  partition('||v_part||') a where    a.longitude is not null
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
              DBMS_OUTPUT.PUT_LINE('��Ƕ��sql��䲻�ܽ��ַ�ת��Ϊ����');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('Ϊ�������');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('����Ϊ0');
        when others then
             DBMS_OUTPUT.PUT_LINE('�������ݴ���');
        rollback ;

end;
/

prompt
prompt Creating procedure PROC_DELROWS
prompt ===============================
prompt
create or replace procedure proc_delrows(table_n varchar,time_t varchar)--���� �������ִ�Сд�� ʱ�䣬ֻ����20140606 ����2014-06-06���ָ�ʽ
as
v_sql varchar2(2000); --ȥ��SQL
num_a number(2); --ĳ���Ƿ����ENODEB_GLB_ID��
num_b number(2);--ĳ���Ƿ����CELL_GLB_ID��
table_name varchar2(300); --����������������
v_tchar number(1);--������ʶ�������ض���3���� ʱ ��ֵΪ1
v_tchar2 number(1);--mb_plan_ltesite_info���������ʶ
v_tchar3 number(1);--mb_plan_ltesite_info���������ʶ



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
              DBMS_OUTPUT.PUT_LINE('��Ƕ��sql��䲻�ܽ��ַ�ת��Ϊ����');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('Ϊ�������');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('����Ϊ0');
        when others then
             DBMS_OUTPUT.PUT_LINE('�������ݴ���');
        rollback ;

end;
/

prompt
prompt Creating procedure PROC_DELROWS4
prompt ================================
prompt
create or replace procedure proc_delrows4(table_n varchar,time_t varchar)--���� �������ִ�Сд�� ʱ�䣬ֻ����20140606 ����2014-06-06���ָ�ʽ
as---����ʱ���ȥ��
v_sql varchar2(20000); --ȥ��SQL
num_a number(2); --ĳ���Ƿ����ENODEB_GLB_ID��
num_b number(2);--ĳ���Ƿ����CELL_GLB_ID��
table_name varchar2(3000); --����������������
v_tchar number(1);--������ʶ�������ض���3���� ʱ ��ֵΪ1
v_tchar2 number(1);--mb_plan_ltesite_info���������ʶ
v_tchar3 number(1);--mb_plan_ltesite_info���������ʶ
time_e varchar2(100);--��������
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
              DBMS_OUTPUT.PUT_LINE('��Ƕ��sql��䲻�ܽ��ַ�ת��Ϊ����');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('Ϊ�������');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('����Ϊ0');
        when others then
             DBMS_OUTPUT.PUT_LINE('�������ݴ���');
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
  from ( select a.record_time,     case   when sum(case when vendor_id like ''%����%'' then 1 else operationalstate end) > 0 then 1  else  0  end online_type,
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
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%����%'' then 1 else operationalstate end) > 0 then 1  else  0  end online_type,
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
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%����%'' then 1 else operationalstate end) > 0 then 1  else  0  end online_type,
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
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%����%'' then 1 else operationalstate end)  > 0 then 1  else  0  end online_type,
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
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%����%'' then 1 else operationalstate end)  > 0 then 1  else  0  end online_type,
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
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%����%'' then 1 else operationalstate end) > 0 then 1  else  0  end online_type,
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
  from ( select a.record_time,    case   when sum(case when vendor_id like ''%����%'' then 1 else operationalstate end)  > 0 then 1  else  0  end online_type,
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
 ��';
dbms_output.put_line(v_sql);
execute immediate v_sql;
commit;
end if;
 exception
        when INVALID_NUMBER   then
              DBMS_OUTPUT.PUT_LINE('��Ƕ��sql��䲻�ܽ��ַ�ת��Ϊ����');
        when ACCESS_INTO_NULL THEN
              DBMS_OUTPUT.put_line('Ϊ�������');
        when ZERO_DIVIDE THEN
              DBMS_OUTPUT.put_line('����Ϊ0');
        when others then
             DBMS_OUTPUT.PUT_LINE('�������ݴ���');
        rollback ;
end;
/


spool off
