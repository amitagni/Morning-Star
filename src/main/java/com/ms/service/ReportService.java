package com.ms.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.ReportDao;
import com.ms.dto.StudentFeeReportDTO;
import com.ms.enums.Month;
import com.ms.util.MSUtil;

@Service
public class ReportService {
	Map<String,String> map = null;
	
	@Autowired
	private ReportDao reportDao;
	
	public List<Object> fetchAllStudentFeeReport(){
		List<Object> dataList = new ArrayList<>();
		ResultSet rs = reportDao.fetchAllStudentFeeReport();
		double amount = 0;
		double disAmount = 0;
		if(rs != null){
			List<StudentFeeReportDTO> dtoList = new ArrayList();
			try {
				
				while(rs.next()){
					StudentFeeReportDTO studentFeeReportDTO = new StudentFeeReportDTO();
					studentFeeReportDTO.setStudentName(rs.getString("first_name")+ " "+rs.getString("last_name"));
					studentFeeReportDTO.setStudentFatherName(rs.getString("father_name"));
					studentFeeReportDTO.setPaidAmount(rs.getString("amount"));
					studentFeeReportDTO.setDiscAmount(rs.getString("discount"));
					studentFeeReportDTO.setMonthlyPaid(getAbbrebiation(rs.getString("monthly"),true));
					studentFeeReportDTO.setQuterlyPaid(getAbbrebiation(rs.getString("quaterly"),false));
					studentFeeReportDTO.setHalfyearlyPaid(getAbbrebiation(rs.getString("halfyearly"),false));
					studentFeeReportDTO.setAnuallyPaid(getAbbrebiation(rs.getString("anually"),false));
					amount = amount + Double.parseDouble(rs.getString("amount"));
					disAmount = disAmount + Double.parseDouble(rs.getString("discount"));
					dtoList.add(studentFeeReportDTO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dataList.add(dtoList);
			dataList.add(String.valueOf(amount));
			dataList.add(String.valueOf(disAmount));
		}
		return dataList;
	}

	/**
	 * @param string
	 * @param b
	 * @return
	 */
	private String getAbbrebiation(String paiddata, boolean isMontly) {
		List<String> list = MSUtil.tokenizeList(paiddata);
		StringBuilder data = new StringBuilder();
		if(isMontly){
			for (String month : list) {
				data.append(Month.findNameByCode(Byte.parseByte(month)));
				data.append(',');
			}
		}else{
			Map<String,String> feeStructureCache = fetchFeeStructureDataForCache();
			for (String str : list) {
				data.append(feeStructureCache.get(str));
				data.append(',');
			}
		}
		int index = data.lastIndexOf(",");
		if(index !=-1){
			return data.substring(0,index-1);
		}else{
			return data.toString();
		}
	}

	public Map<String,String> fetchFeeStructureDataForCache(){
		if(map == null) {
			ResultSet rs = reportDao.fetchFeeStructureDataForCache();
			if(rs != null){
				map = new HashMap<>();
				try {
					while(rs.next()){
						map.put(String.valueOf(rs.getInt("id")), rs.getString("abbr_name"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
		
	}
}
