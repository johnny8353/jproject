CREATE OR REPLACE VIEW SBL_ACCOUNT_PAGE_INFO_V AS
SELECT T9.ROW_ID  SIEBEL_ROW_ID, --Siebel主键Id
       T29.OU_NUM ACCOUNT_NUM, --客户编号
       /**
         视图说明：该视图提供客户分页查询接口使用，不可自行修改或减少字段，否则导致接口报错
         创 建 人：JohnnyHuang
         note    : 添加字段需要修改QUERY_CUSTOMER_INFO-SQL_STATEMENTS,OUT_CUSTOMER_INFO_REC
         创建日志：2015-01-07
         版    本：1.0
       **/
       T29.INTEGRATION_ID ECC_ID, --客户ECC_ID
       t29.X_NAME_LANG,
       decode(t29.X_NAME_LANG, 'EN', 'EN', 'ZH') LANGUAGE, --CN CN
       t14.AGREE_CD COUNTRYISO, --国家ISO码
       t29.ASGN_PH_AC REGION, --地区ISO码
       decode(t29.X_NAME_LANG, 'EN', t15.ENG_NAME, t15.LOCAL_NAME) CITY, --城市
       T29.X_LOC ADDRESS, -----通信地址
       t29.MAIN_EMAIL_ADDR E_MAIL, --电子邮件
       T9.CREATED CREATED_DATE, -----创建时间
       t29.NAME NAME, --客户名称
       T29.APPROVAL_STATUS_CD APPROVAL_STATUS_CD, --审批状态
       t29.ALIAS_NAME ALIAS_NAME, --客户简写
       T3.X_POSTAL_CODE POSTL_COD1, --邮政编码
       T30.LOGIN AS CREATED_BY, ----创建者
       t29.last_upd LAST_UPD,
       t29.last_upd LAST_UPD_DATE, --最近更新时间
       T31.LOGIN AS LAST_UPD_BY,
       T29.MAIN_PH_NUM PHONE_NUM, ------主要电话号码
       T29.MAIN_FAX_PH_NUM FAX_NUM, ------主要传真号码
       T29.PAR_OU_ID, -------客户上级单位
       T3.TAX_NUM, ------税务编码
       T3.ATTRIB_09 IS_LISTED_COMPANY, ------是否上市公司
       T3.ATTRIB_47 COMPANY_WEB_SITE, ------公司网址
       T3.ATTRIB_44 MTO_NAME, -----MTO名称
       T3.ATTRIB_46 LARGE_T_NAME, ------大T名称
       T3.X_HIGH_END_FLAG IS_HIGH_END_ACCOUNT, ------是否高端客户
       T3.X_ACNT_TYPE_4 MOBILE_AGENT_TYPE, -----手机渠道代理商子类型
       T29.CUST_STAT_CD CUSTOMER_STATUS, -------客户状态
       T29.ACCNT_TYPE_CD CUSTOMER_TYPE, ------客户类型
       T3.ATTRIB_49 OPERATOR_LEVEL, ----运营商级别
       T3.OPERATOR_TYPE, ------运营商类型
       T3.ATTRIB_34 ACCOUNT_CHILD_TYPE, -------客户子类型
       T3.ATTRIB_35 ZTE_BUSINESS_CATEGORY, -------ZTE业务客户分类
       T3.ATTRIB_39 ACCOUNT_RANGE, -------客户范围
       T3.ATTRIB_40 CONTACT_STATUS, ------联系状态
       T3.ATTRIB_41 ACCOUNT_PROPERTY, ------客户性质
       T3.ATTRIB_43 MTO_PROPERTY, ------MTO属性
       T3.X_ACNT_ADDR REGISTER_ADDR, ------注册地址
       T3.X_CHILD_COM_FLAG IS_CHILD_COMPANY, --是否子公司
       T1.OU_NUM DEPARTMENT_NUM, --部门编号
       T14.LOCAL_NUM, --国家或地区编号
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
