CREATE OR REPLACE VIEW SBL_ACCOUNT_PAGE_INFO_V AS
SELECT T9.ROW_ID  SIEBEL_ROW_ID, --Siebel����Id
       T29.OU_NUM ACCOUNT_NUM, --�ͻ����
       /**
         ��ͼ˵��������ͼ�ṩ�ͻ���ҳ��ѯ�ӿ�ʹ�ã����������޸Ļ�����ֶΣ������½ӿڱ���
         �� �� �ˣ�JohnnyHuang
         note    : ����ֶ���Ҫ�޸�QUERY_CUSTOMER_INFO-SQL_STATEMENTS,OUT_CUSTOMER_INFO_REC
         ������־��2015-01-07
         ��    ����1.0
       **/
       T29.INTEGRATION_ID ECC_ID, --�ͻ�ECC_ID
       t29.X_NAME_LANG,
       decode(t29.X_NAME_LANG, 'EN', 'EN', 'ZH') LANGUAGE, --CN CN
       t14.AGREE_CD COUNTRYISO, --����ISO��
       t29.ASGN_PH_AC REGION, --����ISO��
       decode(t29.X_NAME_LANG, 'EN', t15.ENG_NAME, t15.LOCAL_NAME) CITY, --����
       T29.X_LOC ADDRESS, -----ͨ�ŵ�ַ
       t29.MAIN_EMAIL_ADDR E_MAIL, --�����ʼ�
       T9.CREATED CREATED_DATE, -----����ʱ��
       t29.NAME NAME, --�ͻ�����
       T29.APPROVAL_STATUS_CD APPROVAL_STATUS_CD, --����״̬
       t29.ALIAS_NAME ALIAS_NAME, --�ͻ���д
       T3.X_POSTAL_CODE POSTL_COD1, --��������
       T30.LOGIN AS CREATED_BY, ----������
       t29.last_upd LAST_UPD,
       t29.last_upd LAST_UPD_DATE, --�������ʱ��
       T31.LOGIN AS LAST_UPD_BY,
       T29.MAIN_PH_NUM PHONE_NUM, ------��Ҫ�绰����
       T29.MAIN_FAX_PH_NUM FAX_NUM, ------��Ҫ�������
       T29.PAR_OU_ID, -------�ͻ��ϼ���λ
       T3.TAX_NUM, ------˰�����
       T3.ATTRIB_09 IS_LISTED_COMPANY, ------�Ƿ����й�˾
       T3.ATTRIB_47 COMPANY_WEB_SITE, ------��˾��ַ
       T3.ATTRIB_44 MTO_NAME, -----MTO����
       T3.ATTRIB_46 LARGE_T_NAME, ------��T����
       T3.X_HIGH_END_FLAG IS_HIGH_END_ACCOUNT, ------�Ƿ�߶˿ͻ�
       T3.X_ACNT_TYPE_4 MOBILE_AGENT_TYPE, -----�ֻ�����������������
       T29.CUST_STAT_CD CUSTOMER_STATUS, -------�ͻ�״̬
       T29.ACCNT_TYPE_CD CUSTOMER_TYPE, ------�ͻ�����
       T3.ATTRIB_49 OPERATOR_LEVEL, ----��Ӫ�̼���
       T3.OPERATOR_TYPE, ------��Ӫ������
       T3.ATTRIB_34 ACCOUNT_CHILD_TYPE, -------�ͻ�������
       T3.ATTRIB_35 ZTE_BUSINESS_CATEGORY, -------ZTEҵ��ͻ�����
       T3.ATTRIB_39 ACCOUNT_RANGE, -------�ͻ���Χ
       T3.ATTRIB_40 CONTACT_STATUS, ------��ϵ״̬
       T3.ATTRIB_41 ACCOUNT_PROPERTY, ------�ͻ�����
       T3.ATTRIB_43 MTO_PROPERTY, ------MTO����
       T3.X_ACNT_ADDR REGISTER_ADDR, ------ע���ַ
       T3.X_CHILD_COM_FLAG IS_CHILD_COMPANY, --�Ƿ��ӹ�˾
       T1.OU_NUM DEPARTMENT_NUM, --���ű��
       T14.LOCAL_NUM, --���һ�������
       '' RESERVED1,
       '' RESERVED2,
       '' RESERVED3,
       '' RESERVED4,
       '' RESERVED5,
       '' RESERVED6,
       '' RESERVED7,
       '' RESERVED8,
       '' RESERVED9,
       '' RESERVED10,
       '' RESERVED11,
       '' RESERVED12,
       '' RESERVED13,
       '' RESERVED14,
       '' RESERVED15,
       '' RESERVED16,
       '' RESERVED17,
       '' RESERVED18,
       '' RESERVED19,
       '' RESERVED20,
       '' RESERVED21,
       '' RESERVED22,
       '' RESERVED23
--
  FROM SIEBEL.S_ORG_EXT T29
  left join SIEBEL.s_party t9
    on t9.row_id = t29.row_id
  left join SIEBEL.S_ORG_EXT_X T3
    on t29.row_id = t3.row_id
  left join SIEBEL.S_USER T30
    on T9.CREATED_BY = T30.ROW_ID
  left join siebel.s_user t31
    on t31.row_id = t9.last_upd_by
  left join siebel.s_org_ext t1
    on t1.par_row_id = t29.bu_id
  left join SIEBEL.CX_LOCAL T14
    on T3.X_COUNTRY_ID = T14.ROW_ID
  left join SIEBEL.CX_LOCAL T15
    on T3.x_City_Id = T15.ROW_ID
 where 1 = 1
   and ((T29.INT_ORG_FLG != 'Y' OR T29.PRTNR_FLG != 'N') AND
       T29.ACCNT_FLG != 'N')
  and exists (select 1
                  from S_ORG_EXT t4
                 where t4.PAR_ROW_ID = t29.MASTER_OU_ID)
           and exists (select 1
                  from S_ACCNT_POSTN t6
                 where t29.PR_POSTN_ID = T6.POSITION_ID
                   AND t29.ROW_ID = T6.OU_EXT_ID)
           and exists (select 1
                  from S_ORG_BU t8
                 where t29.BU_ID = T8.BU_ID
                   AND t29.ROW_ID = T8.ORG_ID) --32051
   --and T29.OU_NUM = 'US912850'
  AND T29.APPROVAL_STATUS_CD IN ('Account State 3', 'Account State 5')
 order by NAME asc;
