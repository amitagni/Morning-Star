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
import com.ms.enums.Section;
import com.ms.enums.StudentClass;
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
					studentFeeReportDTO.setStudentClass(StudentClass.findNameByCode(rs.getByte("current_class")));
					studentFeeReportDTO.setSection(Section.findNameByCode(rs.getByte("section")));
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

	
	public List<Object> fetchAllStudentFeeReport(String currentClass){
		List<Object> dataList = new ArrayList<>();
		ResultSet rs = reportDao.fetchAllStudentFeeReport(currentClass);
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
					studentFeeReportDTO.setStudentClass(StudentClass.findNameByCode(rs.getByte("current_class")));
					studentFeeReportDTO.setSection(Section.findNameByCode(rs.getByte("section")));
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
	
	public List<Object> fetchStudentFeeReport(String studentId){
		List<Object> dataList = new ArrayList<>();
		ResultSet rs = reportDao.fetchStudentFeeReport(studentId);
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
					studentFeeReportDTO.setStudentClass(StudentClass.findNameByCode(rs.getByte("current_class")));
					studentFeeReportDTO.setSection(Section.findNameByCode(rs.getByte("section")));
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
			int i = 1;
			for (String month : list) {
				data.append(Month.findAbbrByCode(Byte.parseByte(month)));
				data.append(',');
				if(i%4 == 0)
					data.append(' ');
				i++;
			}
		}else{
			int i = 1;
			Map<String,String> feeStructureCache = fetchFeeStructureDataForCache();
			for (String str : list) {
				data.append(feeStructureCache.get(str));
				data.append(',');
				if(i%4 == 0)
					data.append(' ');
				i++;
			}
		}
		/*int index = data.lastIndexOf(",");
		if(index !=-1){
			return data.substring(0,index-1);
		}else{
			return data.toString();
		}*/
		return data.toString();
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
