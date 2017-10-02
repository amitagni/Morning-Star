/**
 * 
 */
package com.ms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.util.DBUtil;

/**
 * @author Amit.Agnihotri
 *
 */
@Component
public class ReportDao {
	
	@Autowired
	private DBUtil dbUtil;

	
	public ResultSet fetchAllStudentFeeReport(){
		PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try
        {
	        con = dbUtil.getConnection();
	        ps = con.prepareStatement("select st.id,st.first_name,st.last_name,st.father_name,st.current_class,st.section,sum(amount) amount,sum(discount_amt) discount," 
	        		+ "pfs.monthly_freq monthly,pfs.quaterly_freq quaterly,pfs.halfyearly_freq halfyearly,pfs.annually_freq anually from " 
	        		+ "payment p,student_info st,paid_fee_summary pfs where p.student_id = st.id and st.id = pfs.student_id group by p.student_id");
		    rs = ps.executeQuery();
		    
        }catch (Exception e) {
        	e.printStackTrace();
        }
		return rs;
	}
	
	public ResultSet fetchStudentFeeReport(String studentId){
		PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try
        {
	        con = dbUtil.getConnection();
	        ps = con.prepareStatement("select st.id,st.first_name,st.last_name,st.father_name,st.current_class,st.section,sum(amount) amount,sum(discount_amt) discount," 
	        		+ "pfs.monthly_freq monthly,pfs.quaterly_freq quaterly,pfs.halfyearly_freq halfyearly,pfs.annually_freq anually from " 
	        		+ "payment p,student_info st,paid_fee_summary pfs where p.student_id = st.id and st.id = pfs.student_id and st.id = "+studentId+" group by p.student_id");
		    rs = ps.executeQuery();
		    
        }catch (Exception e) {
        	e.printStackTrace();
        }
		return rs;
	}
	
	
	public ResultSet fetchAllStudentFeeReport(String currentClass){
		PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try
        {
	        con = dbUtil.getConnection();
	        ps = con.prepareStatement("select st.id,st.first_name,st.last_name,st.father_name,st.current_class,st.section,sum(amount) amount,sum(discount_amt) discount," 
	        		+ "pfs.monthly_freq monthly,pfs.quaterly_freq quaterly,pfs.halfyearly_freq halfyearly,pfs.annually_freq anually from " 
	        		+ "payment p,student_info st,paid_fee_summary pfs where p.student_id = st.id and st.id = pfs.student_id and st.current_class = "+currentClass+"  group by p.student_id");
		    rs = ps.executeQuery();
		    
        }catch (Exception e) {
        	e.printStackTrace();
        }
		return rs;
	}

	public ResultSet fetchFeeStructureDataForCache(){
		PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try
        {
	        con = dbUtil.getConnection();
	        ps = con.prepareStatement("select id,abbr_name from fee_structure where fee_freq_type != 4");
		    rs = ps.executeQuery();
		    
        }catch (Exception e) {
        	e.printStackTrace();
        }
		return rs;
		
	}

}
