declare
  -- Non-scalar parameters require additional processing 
  msg_header msg_header_rec;
  input input_customer_info_rec;
  x_customer_info_tab out_customer_info_tab;
  x_error_msg_tab error_msg_tab;
begin
   msg_header := msg_header_rec(SOURCE_SYSTEM_ID => '100000201191',SOURCE_SYSTEM_NAME => 'Siebel CRM',
  USER_ID => 'Siebel CRM' ,USER_NAME =>'100000201191' ,SUBMIT_DATE => '2011-11-11 11:11:11' );
  
  input   := input_customer_info_rec(
             LAST_UPDATE_DATE_FROM => '2011-12-01 11:11:11',
             LAST_UPDATE_DATE_END => '2015-02-01 11:11:11',
             PAGE_SIZE => 1000,
             CURRENT_PAGE => 1,
             TOTAL_RECORD => '',
             NAME => ' 德州亚星通讯有限公司',
             ALIAS_NAME => '',
             ACCOUNT_NUM => '',
             APPROVAL_STATUS_CD => '',
             RESERVED1 => '',
             RESERVED2 => '',
             RESERVED3 => '',
             RESERVED4 => '',
             RESERVED5 => '');
  -- Call the procedure
  zte_customer_info_pkg.query_customer_info(msg_header => msg_header,
                                            input => input,
                                            instance_id => :instance_id,
                                            x_rtn_status => :x_rtn_status,
                                            process_message => :process_message,
                                            x_total_record => :x_total_record,
                                            x_total_page => :x_total_page,
                                            x_page_size => :x_page_size,
                                            x_current_page => :x_current_page,
                                            x_customer_info_tab => x_customer_info_tab,
                                            x_error_msg_tab => x_error_msg_tab);
end;
